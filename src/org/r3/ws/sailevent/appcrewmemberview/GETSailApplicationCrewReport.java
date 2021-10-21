package org.r3.ws.sailevent.appcrewmemberview;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDataTableAdapter;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewFilter;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailApplicationCrewReport extends ServicePattern
{
    private String applicationId;
    private SailApplicationCrewMemberViewQueryActionForm queryForm;
    private boolean activeOnly;
    
	public GETSailApplicationCrewReport(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anApplicationId, SailApplicationCrewMemberViewQueryActionForm anActionForm, boolean activeOnlyFlag)
	{
		super(ctx, serviceEnvironment);
		applicationId = anApplicationId;
		queryForm = anActionForm;
		activeOnly = activeOnlyFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SailApplicationCrewMemberViewPersistence p = SailApplicationCrewMemberViewPersistence.createPersistenceObject(pcfg, aSession);				
		SailApplicationCrewMemberViewFilter filter = queryForm.getSearchCondition(applicationId, activeOnly);
		
		SailApplicationCrewMemberViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}

}
