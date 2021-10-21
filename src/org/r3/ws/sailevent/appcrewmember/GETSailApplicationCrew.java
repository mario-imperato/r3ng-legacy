package org.r3.ws.sailevent.appcrewmember;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDataTableAdapter;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailApplicationCrew extends ServicePattern
{
    private String applicationId;
    private SailApplicationCrewMemberQueryActionForm queryForm;
    private boolean activeOnly;
    
	public GETSailApplicationCrew(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anApplicationId, SailApplicationCrewMemberQueryActionForm anActionForm, boolean activeOnlyFlag)
	{
		super(ctx, serviceEnvironment);
		applicationId = anApplicationId;
		queryForm = anActionForm;
		activeOnly = activeOnlyFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SailApplicationCrewMemberPersistence p = SailApplicationCrewMemberPersistence.createPersistenceObject(pcfg, aSession);				
		SailApplicationCrewMemberFilter filter = queryForm.getSearchCondition(applicationId, activeOnly);
		
		SailApplicationCrewMemberDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}

}
