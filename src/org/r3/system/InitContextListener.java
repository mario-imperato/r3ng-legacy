package org.r3.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.PropertyConfigurator;
import org.apache.velocity.app.Velocity;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.metadata.tmetadataview.TableColumnsMetadataDTOValidator;
import org.r3.db.system.metadata.tmetadataview.TableColumnsMetadataLUT;
import org.r3.db.system.transaction.SqlManagedSessionManager;
import org.r3.system.struts.GWFConstants;
import org.r3.system.util.SystemUtils;
import org.r3.system.util.classLoadHelper.CascadingClassLoadHelper;
import org.r3.system.util.classLoadHelper.ResourceLoadHelper;
import org.r3.system.util.nls_dictionary.NLSDictionary;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.slf4j.bridge.SLF4JBridgeHandler;

public final class InitContextListener implements ServletContextListener, java.io.Serializable
{
	private static SystemLogger logger = null;
	
	private void logInfo(String aMessage)
	{
		logger.info(this.getClass(), aMessage, 1);
        System.out.println(aMessage);
	}

	private void logError(String aMessage)
	{
		logger.error(this.getClass(), aMessage, 1);
        System.out.println(aMessage);
	}

	public InitContextListener()
    {
    }

	protected void initializeQuartzScheduler(ServletContext ctx) throws SchedulerException
	{
		StdSchedulerFactory schedulerFactory = (StdSchedulerFactory) 
		ctx.getAttribute(QuartzInitializerListener.QUARTZ_FACTORY_KEY);
		
		Collection<Scheduler> schedulers = schedulerFactory.getAllSchedulers();
		if (schedulers == null || schedulers.size() == 0)
			throw new SchedulerException(String.format("### %s - INITCONTEXT LISTENER::initializeQuartzScheduler: Could not find any initialized schedulers", ctx.getContextPath()));
		
		for(Scheduler s : schedulers)
		{
			s.getContext().put(GWFConstants.QUARTZ_HTTP_SERVLET_CONTEXT_KEY, ctx);
		}
				            
	}

    public void setupLogSubSystem(ServletContext servletCtx) throws NamingException, Exception
    {
        Context ctx = new InitialContext();
        if (ctx == null)
            throw new Exception(String.format("### %s - No Initial Context Available ---", servletCtx.getContextPath()));
        
        // AppServerImplementation appServer = AppServerImplementationFactory.getCurrentInstance();
        String logCfgFileName = servletCtx.getInitParameter("logger.properties"); 
        if (logCfgFileName != null)
        {
            // String resource = "etc/GlobalDictionary_it.xml";
            
            ResourceLoadHelper resourceLoadHelper = CascadingClassLoadHelper.getInstance();
            if (resourceLoadHelper.resourceIsFile(logCfgFileName))
                ; // PropertyConfigurator.configure(logCfgFileName);
            else
            {
               URL logCfgFileUrl = CascadingClassLoadHelper.getInstance().getResource(logCfgFileName);  
               if (logCfgFileUrl != null)            	   
                  PropertyConfigurator.configure(logCfgFileUrl);
            }            
        }
        else System.out.println(String.format("### %s - Log configuration file not found", servletCtx.getContextPath()));

        // Bridge per ruotare java.util.logging su slf
        SLF4JBridgeHandler.install();
        
        logger = new SystemLogger(InitContextListener.class);
    }

    public void openConnectionPool(ServletContext servletCtx) throws NamingException, Exception
    {
    	MongoPersistenceContext mctx = newMongoPersistenceContext(servletCtx);
    	
    	String resource = "resources/mybatis_config_jndi.xml";
        try {       
        	Reader reader = Resources.getResourceAsReader(resource);             
        	SqlManagedSessionManager sqlSessionFactory = SqlManagedSessionManager.newInstance(reader);
        	
        	SqlSession session = sqlSessionFactory.openSession();
        	session.close();
        	
        	logInfo(String.format("### %s - SQLSessionFactory: %s", servletCtx.getContextPath(), sqlSessionFactory));
        	servletCtx.setAttribute("sqlSessionFactory", sqlSessionFactory);      
        	
        	PersistenceContext pctx = PersistenceContext.initPersistenceContext(sqlSessionFactory, mctx);
        	LUTManager.initializeLUTManager();
        	
        	TableColumnsMetadataLUT o = (TableColumnsMetadataLUT)LUTManager.getLUTManager().getLUT(LUTName.table_metadata, null);
        	pctx.setPersisteceDTOValidator(new TableColumnsMetadataDTOValidator(o));
        }      
        catch(Exception e)
        {       
        	e.printStackTrace();
        	System.out.println("FATAL ERROR: myBatis could not be initialized");          	
        }
    }

    public MongoPersistenceContext newMongoPersistenceContext(ServletContext servletCtx) throws NamingException, Exception
    {
    	String mongoDbProperties = servletCtx.getInitParameter("MongoDBProperties");
        if (mongoDbProperties == null)
        {
        	System.out.println(String.format("### %s - MongoDB Not Configured - Properties Not Defined", servletCtx.getContextPath()));
        	return null;
        }
        
        MongoPersistenceContext mongoCtx = null;
        try 
        {       
        	mongoCtx = new MongoPersistenceContext(mongoDbProperties);  
        	System.out.println(String.format("### %s - Mongo Persistence Context Created Using: %s", servletCtx.getContextPath(), mongoDbProperties)); 
        }      
        catch(Exception e)
        {       
        	e.printStackTrace();
        	System.out.println(String.format("### %s - FATAL ERROR: MongoDB could not be initialized", servletCtx.getContextPath()));        	
        }
        
        return mongoCtx;
    }
    
	public void initializeServerNLSDictionary(ServletContext servletCtx,  String rootPath)
			throws NamingException, Exception
			
			
			
	{	
		if (rootPath != null)
		{
			try
			{
				CascadingClassLoadHelper c = new CascadingClassLoadHelper();
				NLSDictionary d = new NLSDictionary();
				d.readDirectory(rootPath, c);
				servletCtx.setAttribute(d.getNLSDictionaryClassId, d);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	}

    public void contextInitialized(ServletContextEvent parm1)
    {
    	ServletContext ctx = parm1.getServletContext();
    	
        try
        {        	
            System.out.println(String.format("### %s - BOF INITCONTEXT LISTENER", ctx.getContextPath()));

            System.out.println(String.format("### %s - INITCONTEXT LISTENER: SetupLogSubSystem", ctx.getContextPath()));
            setupLogSubSystem(ctx);

            System.out.println(String.format("### %s - INITCONTEXT LISTENER: OpeningConnectionPool", ctx.getContextPath()));
            openConnectionPool(ctx);     
            
            System.out.println(String.format("### %s - INITCONTEXT LISTENER: Initializing Velocity Engine", ctx.getContextPath()));
            List<String> templateList = new ArrayList<String>();
            // General
            templateList.add("resources/velocity/template_dictionary.xml");
            // sitecreation
            templateList.add("resources/velocity/sitecreation/template_dictionary_sitecreation.xml");
            // mail
            templateList.add("resources/velocity/mail/template_dictionary_mail.xml");
            // templateList.add("resources/velocity/mail/template_dictionary_mail_s100.xml");
            templateList.add("resources/velocity/mail/template_dictionary_mail_shakeus.xml");
            // sylk
            templateList.add("resources/velocity/sylk/template_dictionary_sylk.xml");
            // dbscripts
            templateList.add("resources/velocity/dbscripts/template_dictionary_dbscripts.xml");
            
            initVelocityEngine(ctx, "resources/velocity/velocity.properties", templateList );                        

            System.out.println(String.format("### %s - INITCONTEXT LISTENER: Initializing NLSDictionary", ctx.getContextPath()));   
        	String rootPath = ctx.getInitParameter("nlsDictionary.scanDirectory");
        	if (rootPath == null)
        	{
        		rootPath = ctx.getRealPath("/");
        	}
        	initializeServerNLSDictionary(ctx, rootPath);
            
            System.out.println(String.format("### %s - INITCONTEXT LISTENER: SchedulerFactory", ctx.getContextPath()));
            // initializeQuartzScheduler(parm1.getServletContext());
            
        }
        catch (Exception e)
        {
            System.out.println(String.format("### %s - INITCONTEXT LISTENER: Exception caught (See System.err)", ctx.getContextPath()));
            e.printStackTrace(System.err);
        }

        System.out.println(String.format("### %s - EOF INITCONTEXT LISTENER", ctx.getContextPath()));
    }

    public void contextDestroyed(ServletContextEvent parm1)
    {
    	ServletContext ctx = parm1.getServletContext();
    	
    	// Operazione Duale rispetto alla invocazione setupLogSubSystem
    	SLF4JBridgeHandler.uninstall();
    	
        System.out.println(String.format("### %s - BOF System Shutdown\n###\n", ctx.getContextPath()));
        System.out.println(String.format("### %s - Shutdown MongoDb\n###\n", ctx.getContextPath()));
        PersistenceContext.getPersistenceContext().shutdownMongoDb();
        System.out.println(String.format("### %s - EOF System Shutdown\n###\n", ctx.getContextPath()));
    }

    public void initVelocityEngine(ServletContext ctx, String propertyFileName, List<String> listOfTemplateDictionaries)
    {
        System.out.println(String.format("### %s - GWFVelocityPlugIn::init", ctx.getContextPath()));
        VelocityTemplateModel theModel = new VelocityTemplateModel();
        
        InputStream propertiesStream = null;
        try
        {
            ResourceLoadHelper resourceLoadHelper = CascadingClassLoadHelper.getInstance();
            if (propertyFileName != null)
            {
                Properties p = new Properties();
                propertiesStream = resourceLoadHelper.getFileOrResourceAsInputStream(propertyFileName);
                if (propertiesStream == null)
                {
                    throw new IOException("Could not find " + propertyFileName);   
                }
                p.load(propertiesStream);
                Velocity.init(p);
            }
            else
                Velocity.init();

            theModel.loadTemplates(listOfTemplateDictionaries);
            theModel.setInContext(ctx);
            
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);            
        }
        finally
        {
            SystemUtils.close(propertiesStream);
        }
    }

}
