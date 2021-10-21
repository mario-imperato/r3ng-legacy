package org.r3.ws.sailevent.entrylist;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.homeentrylist.SailHomeEntryListDataTableAdapter;
import org.r3.db.sailevent.homeentrylist.SailHomeEntryListFilter;
import org.r3.db.sailevent.homeentrylist.SailHomeEntryListPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailHomeEntryListApplications extends ServicePattern
{    
    
	public GETSailHomeEntryListApplications(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		SailHomeEntryListPersistence p = SailHomeEntryListPersistence.createPersistenceObject(pcfg, aSession);
 
		SailEntryListQueryActionForm qdt = new SailEntryListQueryActionForm();
		qdt.setExecuteCount(false);
		
		SailHomeEntryListFilter filter = qdt.getHomeEntryListSearchCondition(senv.getRequestSiteId(), 12);
		
		SailHomeEntryListDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), qdt.getsEcho(), qdt.getiDisplayStart(), qdt.getiDisplayLength(), qdt.isExecuteCount());
		return dt;
	}



}
