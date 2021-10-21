package org.r3.ws.project.team;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.team.TeamDataTableAdapter;
import org.r3.db.project.team.TeamFilter;
import org.r3.db.project.team.TeamPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETTeams extends ServicePattern
{
		
	private TeamQueryActionForm  queryForm;
      
	public GETTeams(ServletContext ctx,  ServiceEnvironment serviceEnvironment, TeamQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		TeamPersistence p = TeamPersistence.createPersistenceObject(pcfg, aSession);				
		TeamFilter filter = queryForm.getSearchCondition(senv.getRequestSiteDomain(), senv.getRequestSiteId(), senv.getRequestSiteCalendarId());
		
		TeamDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());		
		
		return dt;
	}

}

