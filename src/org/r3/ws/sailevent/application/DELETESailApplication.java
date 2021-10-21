package org.r3.ws.sailevent.application;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class DELETESailApplication extends ServicePattern
{
    private String applicationId;
    private VelocityTemplateModel velocityEngine;
    
	public DELETESailApplication(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anApplicationId)
	{
		super(ctx, serviceEnvironment);				
		applicationId = anApplicationId;	
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		EventLogPersistence ep = EventLogPersistence.createPersistenceObject(pcfg, aSession);
		
		SailApplicationPersistence p = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);
		SailApplicationDTO dto = p.selectByEventidApplicationid(senv.getRequestSiteId(), applicationId, pcfg.getPersistenceConfigInfo());
		
		if (dto != null)
		{
	    try
		{
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "SailApplicationDeletionSQLScript");
							
			scriptPersistence.addParameter("applicationDTO", dto);							
			scriptPersistence.execute(pcfg, aSession);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
			// return RestServiceDTO.FailDTO;
		}
		}
		
		return RestServiceDTO.SuccessDTO;
	}


}
