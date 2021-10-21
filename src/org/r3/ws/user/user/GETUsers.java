package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.user.user.UserDataTableAdapter;
import org.r3.db.system.user.user.UserFilter;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETUsers extends ServicePattern
{
    private UserQueryActionForm queryForm;
    
	public GETUsers(ServletContext ctx,  ServiceEnvironment serviceEnvironment, UserQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);				
		UserFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		UserDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
