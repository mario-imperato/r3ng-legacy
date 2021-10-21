package org.r3.ws.project.team;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.team.TeamDTO;
import org.r3.db.project.team.TeamPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTTeam extends ServicePattern
{
	private TeamActionForm actionForm;

    private String teamId;
    
	public PUTTeam(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aTeamId, TeamActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;

		teamId = aTeamId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO rc = null;
		
		TeamPersistence p = TeamPersistence.createPersistenceObject(pcfg, aSession);
		TeamDTO dto2 = p.selectBySiteTeamid(senv.getRequestSiteId(), teamId, pcfg.getPersistenceConfigInfo());
		
		dto2 = actionForm.getDTO4Update(dto2);
		p.updateByPrimaryKey(dto2, pcfg.getPersistenceConfigInfo());

		return dto2;				
	}

}
