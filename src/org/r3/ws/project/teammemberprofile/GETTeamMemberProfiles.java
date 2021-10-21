package org.r3.ws.project.teammemberprofile;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.teammemberprofile.TeamMemberProfileDataTableAdapter;
import org.r3.db.project.teammemberprofile.TeamMemberProfileFilter;
import org.r3.db.project.teammemberprofile.TeamMemberProfilePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETTeamMemberProfiles extends ServicePattern
{

	private TeamMemberProfileQueryActionForm queryForm;
    
	public GETTeamMemberProfiles(ServletContext ctx,  ServiceEnvironment serviceEnvironment,  TeamMemberProfileQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		TeamMemberProfilePersistence p = TeamMemberProfilePersistence.createPersistenceObject(pcfg, aSession);				
		TeamMemberProfileFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), senv.getRequestSiteId());
		
		TeamMemberProfileDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());		
		
		
		return dt;
	}

	
}
