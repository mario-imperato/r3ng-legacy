package org.r3.ws.project.team;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.team.TeamDTO;
import org.r3.db.project.team.TeamPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETTeamDetail extends ServicePattern
{

    private String teamId;
    
	public GETTeamDetail(ServletContext ctx, ServiceEnvironment serviceEnvironment,  String aTeamId)
	{
		super(ctx, serviceEnvironment);

		teamId = aTeamId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		TeamPersistence p = TeamPersistence.createPersistenceObject(pcfg, aSession);
		TeamDTO dto2 = p.selectBySiteTeamid(senv.getRequestSiteId(), teamId, pcfg.getPersistenceConfigInfo());

		return dto2;
	}

}
