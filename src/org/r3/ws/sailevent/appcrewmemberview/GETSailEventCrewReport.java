package org.r3.ws.sailevent.appcrewmemberview;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewPersistence;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewSummaryDataTableAdapter;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailEventCrewReport extends ServicePattern
{
    
	public GETSailEventCrewReport(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SailApplicationCrewMemberViewPersistence p = SailApplicationCrewMemberViewPersistence.createPersistenceObject(pcfg, aSession);			
		SailApplicationCrewMemberViewSummaryDataTableAdapter dt = p.selectCrewReport(senv.getRequestSiteId(), pcfg.getPersistenceConfigInfo());
		return dt;
	}
	

}
