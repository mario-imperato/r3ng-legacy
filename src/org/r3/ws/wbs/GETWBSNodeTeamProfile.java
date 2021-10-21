package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.wbsnodeteammemberprofile.WBSNodeTeamMemberProfileDataTableAdapter;
import org.r3.db.project.wbsnodeteammemberprofile.WBSNodeTeamMemberProfileFilter;
import org.r3.db.project.wbsnodeteammemberprofile.WBSNodeTeamMemberProfilePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWBSNodeTeamProfile extends ServicePattern
{

    private String wbsNodeId;
    
	private WBSNodeTeamProfileQueryActionForm queryForm;
    
	public GETWBSNodeTeamProfile(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aWbsId, String aWbsNodeId, WBSNodeTeamProfileQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;

		wbsNodeId = aWbsNodeId;
	}

	/*
	 * Il metodo viene invocato in due modi: wbsNodeId valorizzato o meno. Nel caso di non valorizzazione allora vengono ritornati tutti i nodi appartenenti ad una
	 * wbs di un certo tipo.
	 */
	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		WBSNodeTeamMemberProfilePersistence p = WBSNodeTeamMemberProfilePersistence.createPersistenceObject(pcfg, aSession);				
		WBSNodeTeamMemberProfileFilter filter = queryForm.getSearchCondition(wbsNodeId);
		
		WBSNodeTeamMemberProfileDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());						
		return dt;
	}

	
}
