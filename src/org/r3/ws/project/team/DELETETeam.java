package org.r3.ws.project.team;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.team.TeamDTO;
import org.r3.db.project.team.TeamPersistence;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class DELETETeam extends ServicePattern
{
    private String teamId;
    private VelocityTemplateModel velocityEngine;
    
	public DELETETeam(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aTeamId)
	{
		super(ctx, serviceEnvironment);
		teamId = aTeamId;
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		TeamPersistence p = TeamPersistence.createPersistenceObject(pcfg, aSession);
		TeamDTO dto = p.selectBySiteTeamid(senv.getRequestSiteId(), teamId, pcfg.getPersistenceConfigInfo());
        
        if (dto != null)
		{
		    try
			{						
				RunSqlPersistence scriptPersistence = 
				RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "delete_prj_team");
								
				scriptPersistence.addParameter("teamDTO", dto);							
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
