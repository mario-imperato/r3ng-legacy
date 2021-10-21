package org.r3.ws.project.resourcetimesheet;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewDataTableAdapter;
import org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewFilter;
import org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETResourceTimesheet extends ServicePattern
{	 	

	
	private ResourceTimesheetQueryActionForm queryForm;
    
	public GETResourceTimesheet(ServletContext ctx,  ServiceEnvironment serviceEnvironment, ResourceTimesheetQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		ResourceTimesheetViewPersistence p = ResourceTimesheetViewPersistence.createPersistenceObject(pcfg, aSession);				
		ResourceTimesheetViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteDomain(), senv.getRequestSiteId(), senv.getRequestSiteCalendarId());
		
		ResourceTimesheetViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());		
		
		return dt;
	}


}
