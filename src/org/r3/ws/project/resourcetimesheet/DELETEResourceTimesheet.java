package org.r3.ws.project.resourcetimesheet;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.resourcetimesheet.ResourceTimesheetPersistence;
import org.r3.db.system.calendar.SystemCalendarDTO;
import org.r3.db.system.calendar.SystemCalendarLUT;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEResourceTimesheet extends ServicePattern
{	
  
    private String resourceId;
    private String timesheetDay;
    
	public DELETEResourceTimesheet(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aResourceId, String aTimesheetDay)
	{
		super(ctx, serviceEnvironment);
		
		resourceId = aResourceId;
		timesheetDay = aTimesheetDay;

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SystemCalendarDTO dto = SystemCalendarLUT.getDateAsCalendarDTO(senv.getRequestSiteDomain(), senv.getRequestSiteCalendarId(), timesheetDay);
		if (dto == null)
		{
			return RestServiceDTO.FailDTO;
		}
		
		ResourceTimesheetPersistence p = ResourceTimesheetPersistence.createPersistenceObject(pcfg, aSession);		
		int numberOfRowsAffected = p.deleteByResourceidCaleveday(senv.getRequestSiteId(), resourceId, dto.getCaleveday(), pcfg.getPersistenceConfigInfo());
		
		
						    
		return RestServiceDTO.SuccessDTO;
	}
	
	
	
}
