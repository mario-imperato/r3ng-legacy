package org.r3.ws.sailevent.console;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewDataTableAdapter;
import org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewFilter;
import org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailApplicationsEventLogView extends ServicePattern
{
    private SailApplicationEventLogViewQueryActionForm queryForm;
    
	public GETSailApplicationsEventLogView(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SailApplicationEventLogViewQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		SailApplicationEventLogViewPersistence p = SailApplicationEventLogViewPersistence.createPersistenceObject(pcfg, aSession);	
		
		queryForm.setUserid(senv.getUserProfile().getUserid());
		SailApplicationEventLogViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		SailApplicationEventLogViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
