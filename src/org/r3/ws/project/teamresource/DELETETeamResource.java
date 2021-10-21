package org.r3.ws.project.teamresource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.teamresource.TeamResourceDTO;
import org.r3.db.project.teamresource.TeamResourcePersistence;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class DELETETeamResource extends ServicePattern
{	
    private String resourceId;
    private String teamId;
    private VelocityTemplateModel velocityEngine;
    
	public DELETETeamResource(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aResourceId, String aTeamId)
	{
		super(ctx, serviceEnvironment);
		resourceId = aResourceId;
		teamId = aTeamId;
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		TeamResourcePersistence rp = TeamResourcePersistence.createPersistenceObject(pcfg, aSession);
		TeamResourceDTO dto = rp.selectBySiteTeamidResourceid(senv.getRequestSiteId(), teamId, resourceId, pcfg.getPersistenceConfigInfo());
		
		if (dto != null)
		{
		    try
			{						
				RunSqlPersistence scriptPersistence = 
				RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "delete_prj_teamresource");
								
				scriptPersistence.addParameter("teamResourceDTO", dto);							
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
