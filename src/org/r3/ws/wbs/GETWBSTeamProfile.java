package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewDataTableAdapter;
import org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewFilter;
import org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWBSTeamProfile extends ServicePattern
{
	private String wbsid;
    
	private WBSNodeTeamProfileQueryActionForm queryForm;
    
	public GETWBSTeamProfile(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aWbsId, WBSNodeTeamProfileQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		wbsid = aWbsId;
	}

	/*
	 * Il metodo viene invocato in due modi: wbsNodeId valorizzato o meno. Nel caso di non valorizzazione allora vengono ritornati tutti i nodi appartenenti ad una
	 * wbs di un certo tipo.
	 */
	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		WBSNodeTeamMemberProfileViewPersistence p = WBSNodeTeamMemberProfileViewPersistence.createPersistenceObject(pcfg, aSession);				
		WBSNodeTeamMemberProfileViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), wbsid);
		
		WBSNodeTeamMemberProfileViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());						
		return dt;
	}

	
}
