package org.r3.ws.project.team;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.team.TeamDTO;
import org.r3.db.project.team.TeamPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTTeam extends ServicePattern
{
	private TeamActionForm actionForm;

	public POSTTeam(ServletContext ctx, ServiceEnvironment serviceEnvironment, TeamActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		TeamDTO dto2 = null;
		TeamPersistence p = TeamPersistence.createPersistenceObject(pcfg, aSession);

		dto2 = p.selectBySitePeriodindex(senv.getRequestSiteId(), actionForm.getPeriodindexAsInt(), pcfg.getPersistenceConfigInfo());
		if (dto2 != null)
		{
			RestServiceDTO srvDTO = new RestServiceDTO(Status.fail, "RESTDTO_ERROR_DUPTEAMPERIOD", "Periodo gia' presente");
			return srvDTO;
		}

		dto2 = actionForm.getDTO4Insert(senv.getRequestSiteId());
		p.insert(dto2, pcfg.getPersistenceConfigInfo());

		return dto2;
	}

}
