package org.r3.ws.actors.actor;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class DELETEActor extends ServicePattern
{    
    private String site;
    private String actorId;
	private VelocityTemplateModel velocityEngine;
	
	public DELETEActor(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String anActorId)
	{
		super(ctx, serviceEnvironment);
		
		site = aSite;
		actorId = anActorId;
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		ActorPersistence p = ActorPersistence.createPersistenceObject(pcfg, aSession);
		ActorDTO dto = p.selectByEventidActorid(site, actorId, pcfg.getPersistenceConfigInfo());
		
		if (dto != null)
		{
	    try
		{						
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "ActorDeletionSQLScript");
							
			scriptPersistence.addParameter("actorDTO", dto);							
			scriptPersistence.execute(pcfg, aSession);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}
		}
	    
		return RestServiceDTO.SuccessDTO;
	}
}
