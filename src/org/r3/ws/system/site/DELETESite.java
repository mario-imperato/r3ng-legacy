package org.r3.ws.system.site;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.folder.DMSFolderDTO.FolderStatus;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.DMSFolderHelper;
import org.r3.db.mongo.script.JSONHelperFormatter;
import org.r3.db.mongo.script.MongoSimpleImport;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SitePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class DELETESite extends ServicePattern
{    
    private String regattaId;
	private VelocityTemplateModel velocityEngine;
	
	public DELETESite(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aRegattaId)
	{
		super(ctx, serviceEnvironment);
		
		regattaId = aRegattaId;
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}
	
	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		SitePersistence p = SitePersistence.createPersistenceObject(pcfg, aSession);
		SiteDTO dto = p.selectBySite(regattaId, pcfg.getPersistenceConfigInfo());
		
		if (dto != null)
		{
	    try
		{
	    	DMSContext dmsContext = new DMSContext(pcfg, aSession);		    	
	    	
	    	DMSFolder f = DMSFolderHelper.getSiteFolder(dmsContext, dto.getSite(), true);
	    	f.setEnabled(dmsContext, FolderStatus.sys_recdeleted);	    	
	    	
			f = DMSFolderHelper.getSiteFolder(dmsContext,  dto.getSite(), false);
			f.setEnabled(dmsContext, FolderStatus.sys_recdeleted);			
			
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "SiteDeleteSQLScript");
							
			scriptPersistence.addParameter("siteDTO", dto);							
			scriptPersistence.execute(pcfg, aSession);	
			
			 if (pcfg.isMongoDbAvailable())
			 {
			    MongoSimpleImport simpleImport = MongoSimpleImport.createPersistenceObject(velocityEngine, "SiteCollectionDeleteMongoScript");
			    simpleImport.setStatementSeparator(";\\(EOS\\)");
			    simpleImport.addParameter("siteDTO", dto);
			    simpleImport.addParameter("jsonHelper", new JSONHelperFormatter());	
				simpleImport.execute(pcfg.getMongoPersistenceContext());
			 }
			 
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}
		}
	    
		LUTManager.getLUTManager().invalidateLUT(LUTName.site);
		return RestServiceDTO.SuccessDTO;
	}
}
