package org.r3.ws.sailevent.ranking;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.ranking.RankingDTO;
import org.r3.db.sailevent.ranking.RankingPersistence;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class DELETERanking extends ServicePattern
{
    private String rankId;
    private VelocityTemplateModel velocityEngine;
    
	public DELETERanking(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aRankId)
	{
		super(ctx, serviceEnvironment);				
		rankId = aRankId;	
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}
	
	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		EventLogPersistence ep = EventLogPersistence.createPersistenceObject(pcfg, aSession);
		
		RankingPersistence p = RankingPersistence.createPersistenceObject(pcfg, aSession);
		RankingDTO dto = p.selectByEventidRankid(senv.getRequestSiteId(), rankId, pcfg.getPersistenceConfigInfo());
		
		if (dto != null)
		{
	    try
		{
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "RankingDeletionSQLScript");
							
			scriptPersistence.addParameter("rankingDTO", dto);							
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
