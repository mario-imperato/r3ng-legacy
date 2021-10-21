package org.r3.ws.project.resourcetimesheet;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewCriteria;
import org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewFilter;
import org.r3.db.project.resourcetimesheetview.ResourceTimesheetViewPersistence.ReportType;
import org.r3.db.system.calendar.SystemCalendarLUT;
import org.r3.db.utils.DataTableQueryActionForm;


public class ResourceTimesheetQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("profileid")
    private String profileid;

    public String getProfileid()
    {    	
    	return DTOBase.nullOnEmpty(profileid);    	
    }
    
	@QueryParam("resourceid")
    private String resourceid;

    public String getResourceid()
    {    	
    	return DTOBase.nullOnEmpty(resourceid);
    }
    
    @QueryParam("periodindexfrom")
    private String periodindexfrom;

    public String getPeriodindexfrom()
    {    	
    	return DTOBase.nullOnEmpty(periodindexfrom);    	
    }
    
    public int getTeamperiodfrom()
    {    	
    	String s = getPeriodindexfrom();
    	if (s != null)
    	{
    		return Integer.parseInt(s);
    	}
    	
    	return -1;
    }
    
    @QueryParam("periodindexto")
    private String periodindexto;

    public String getPeriodindexto()
    {    	
    	return DTOBase.nullOnEmpty(periodindexto);    	
    }
    
    public int getTeamperiodto()
    {    	
    	String s = getPeriodindexto();
    	if (s != null)
    	{
    		return Integer.parseInt(s);
    	}
    	
    	return -1;
    }
    
    @QueryParam("timesheetday")
    private String timesheetday;

    public String getTimesheetday()
    {    	
    	return DTOBase.nullOnEmpty(timesheetday);
    }
    
    public java.sql.Date getTimesheetdayAsDate()
	{
		return DTOBase.stringAsDate(timesheetday);
	}
    
    public int getTimesheetdayAsCalendarEveDay(String aSiteDomain, String aCalendarId)
	{
		return SystemCalendarLUT.getDateAsCalendarEveDay(aSiteDomain, aCalendarId, getTimesheetdayAsDate());
	}
    
    @QueryParam("reporttype")
    private String reporttype;

    public String getReporttype()
    {    	
    	return DTOBase.nullOnEmpty(reporttype);    	
    }
    
    public ReportType getReporttypeAsReportType()
    {    	
    	return ReportType.valueOfWithDefault(getReporttype(), ReportType.base);    	
    }
    
    public String getGropuByClauseByReportType()
    {    	
    	return ReportType.getGropuByClauseByReportType(getReporttype());    	
    }
    
    @QueryParam("groupby")
    private String[] groupby;

    public String[] getGroupby()
    {    	
    	return groupby;    	
    }
    
    public String getGroupby2CSV()
    {    	
    	return DTOBase.stringArray2CSV(groupby);    	
    }
    
//	@QueryParam("logincontact")
//    private String logincontact;
//
//    public String getLogincontact()
//    {    	
//    	return DTOBase.nullOnEmpty(logincontact);
//    }
//
//    public boolean getLogincontactAsBoolean()
//    {    	
//    	return DTOBase.getBTrueFalseAsBoolean(logincontact);
//    }

	public ResourceTimesheetViewFilter getSearchCondition(String aSiteDomain, String aSite, String aSiteCalendarId)
	{
		ResourceTimesheetViewFilter filter = new ResourceTimesheetViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" caleveday asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		ResourceTimesheetViewCriteria criteria = 
				filter.or().andSiteEqualTo(aSite).andProfileidEqualTo(getProfileid()).andResourceidEqualTo(getResourceid())
				;	
		
		if (getTimesheetday() != null)
			criteria.andCalevedayEqualTo(getTimesheetdayAsCalendarEveDay(aSiteDomain, aSiteCalendarId));
		
		if (getPeriodindexfrom() != null)
			criteria.andTeamperiodGreaterThanOrEqualTo(getTeamperiodfrom());
		
		if (getPeriodindexto() != null)
			criteria.andTeamperiodLessThanOrEqualTo(getTeamperiodto());
		
		filter.setGroupByClause(getGroupby2CSV());
		
		return filter;
	}


}
