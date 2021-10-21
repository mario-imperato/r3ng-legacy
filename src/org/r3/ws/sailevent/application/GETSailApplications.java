package org.r3.ws.sailevent.application;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.application.SailApplicationDataTableAdapter;
import org.r3.db.sailevent.application.SailApplicationFilter;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailApplications extends ServicePattern
{
    private SailApplicationQueryActionForm queryForm;
    
	public GETSailApplications(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SailApplicationQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		SailApplicationPersistence p = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);				
		SailApplicationFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		SailApplicationDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
