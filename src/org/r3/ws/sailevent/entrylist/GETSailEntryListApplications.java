package org.r3.ws.sailevent.entrylist;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.entrylist.SailEntryListDataTableAdapter;
import org.r3.db.sailevent.entrylist.SailEntryListFilter;
import org.r3.db.sailevent.entrylist.SailEntryListPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailEntryListApplications extends ServicePattern
{    
    private SailEntryListQueryActionForm queryActionForm;
    
	public GETSailEntryListApplications(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SailEntryListQueryActionForm aQueryActionForm)
	{
		super(ctx, serviceEnvironment);
		queryActionForm = aQueryActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		SailEntryListPersistence p = SailEntryListPersistence.createPersistenceObject(pcfg, aSession);
 		
		SailEntryListFilter filter = queryActionForm.getSearchCondition(senv.getRequestSiteId());
		
		SailEntryListDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryActionForm.getsEcho(), queryActionForm.getiDisplayStart(), queryActionForm.getiDisplayLength(), queryActionForm.isExecuteCount());
		return dt;
	}



}
