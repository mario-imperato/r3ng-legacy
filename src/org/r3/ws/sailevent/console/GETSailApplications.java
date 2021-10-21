package org.r3.ws.sailevent.console;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.applicationview.SailApplicationViewDataTableAdapter;
import org.r3.db.sailevent.applicationview.SailApplicationViewFilter;
import org.r3.db.sailevent.applicationview.SailApplicationViewPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailApplications extends ServicePattern
{
    private SailApplicationViewQueryActionForm queryForm;
    
	public GETSailApplications(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SailApplicationViewQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		SailApplicationViewPersistence p = SailApplicationViewPersistence.createPersistenceObject(pcfg, aSession);				
		SailApplicationViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		SailApplicationViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
