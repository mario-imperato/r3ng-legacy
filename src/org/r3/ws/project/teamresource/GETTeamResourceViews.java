package org.r3.ws.project.teamresource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.teamresourceview.TeamResourceViewDataTableAdapter;
import org.r3.db.project.teamresourceview.TeamResourceViewFilter;
import org.r3.db.project.teamresourceview.TeamResourceViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETTeamResourceViews extends ServicePattern
{
		
	private TeamResourceViewQueryActionForm  queryForm;
    private String resourceId;
    private String teamId;
    
    // Il costruttore viene invocato in maniera diversa: con il solo resourceid oppure con il solo teamid a seconda del contesto nel quale ci troviamo, ovvero stiamo cercando i team
    // nei quali la risorsa è definita oppure le risorse presenti nel team.
	public GETTeamResourceViews(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aResourceId, String aTeamId, TeamResourceViewQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		resourceId = aResourceId;
		teamId = aTeamId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		TeamResourceViewPersistence p = TeamResourceViewPersistence.createPersistenceObject(pcfg, aSession);				
		TeamResourceViewFilter filter = null;
		
		if (resourceId != null) 
			filter = queryForm.getSearchConditionByResourceId(senv.getRequestSiteId(), resourceId);
		else 
			filter = queryForm.getSearchConditionByTeamId(senv.getRequestSiteId(), teamId);

		TeamResourceViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());				
		return dt;
	}

}

