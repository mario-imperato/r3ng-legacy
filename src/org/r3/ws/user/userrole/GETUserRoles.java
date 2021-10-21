package org.r3.ws.user.userrole;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.user.userroleview.UserRoleViewCriteria;
import org.r3.db.system.user.userroleview.UserRoleViewDataTableAdapter;
import org.r3.db.system.user.userroleview.UserRoleViewFilter;
import org.r3.db.system.user.userroleview.UserRoleViewPersistence;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETUserRoles extends ServicePattern
{   
	private String userId;
	private boolean limit2CurrentSite;
	
	public GETUserRoles(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUserId, boolean aLimit2CurrentSiteFlag)
	{
		super(ctx, serviceEnvironment);
		userId = aUserId;
		limit2CurrentSite = aLimit2CurrentSiteFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserRoleViewPersistence p = UserRoleViewPersistence.createPersistenceObject(pcfg, aSession);				
		UserRoleViewFilter filter = new UserRoleViewFilter();
		filter.setOrderByClause(" roledescr ");
		
		UserRoleViewCriteria c = filter.or().andUseridEqualTo(userId);
        if (limit2CurrentSite)
        	c.andSiteEqualTo(senv.getRequestSiteId());
        
		DataTableQueryActionForm queryForm = new DataTableQueryActionForm();
		queryForm.setExecuteCount(false);
		
		UserRoleViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}

}
