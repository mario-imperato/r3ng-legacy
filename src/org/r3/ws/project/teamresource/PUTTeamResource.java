package org.r3.ws.project.teamresource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.team.TeamDTO.TeamStatus;
import org.r3.db.project.team.TeamPersistence;
import org.r3.db.project.teamresource.TeamResourceDTO;
import org.r3.db.project.teamresource.TeamResourcePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTTeamResource extends ServicePattern
{
	
    private TeamResourceActionForm actionForm;
    private String resourceId;
    private String teamId;
        
	public PUTTeamResource(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aResourceId, String aTeamId, TeamResourceActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		resourceId = aResourceId;
		teamId = aTeamId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		TeamPersistence tp = TeamPersistence.createPersistenceObject(pcfg, aSession);
		tp.updateTeamStatus(senv.getRequestSiteId(), teamId, TeamStatus.team_building, pcfg.getPersistenceConfigInfo());
		
		TeamResourcePersistence rp = TeamResourcePersistence.createPersistenceObject(pcfg, aSession);
		TeamResourceDTO rdto = rp.selectBySiteTeamidResourceid(senv.getRequestSiteId(), teamId, resourceId, pcfg.getPersistenceConfigInfo());
		if (rdto != null)
		{
			rdto = actionForm.getDTO4TeamResourceUpdate(rdto);		
			rp.updateByPrimaryKey(rdto, pcfg.getPersistenceConfigInfo());			
		}
		else
		{
			rdto = actionForm.getDTO4TeamResourceInsert(senv.getRequestSiteId(), teamId, resourceId);
			rp.insert(rdto, pcfg.getPersistenceConfigInfo());				
		}
		    
		return rdto;
	}
	
	
	
}
