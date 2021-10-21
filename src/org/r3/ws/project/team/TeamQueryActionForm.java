package org.r3.ws.project.team;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.project.team.TeamCriteria;
import org.r3.db.project.team.TeamFilter;
import org.r3.db.system.calendar.SystemCalendarDTO;
import org.r3.db.system.calendar.SystemCalendarLUT;
import org.r3.db.utils.DataTableQueryActionForm;


public class TeamQueryActionForm extends DataTableQueryActionForm
{	
	@QueryParam("teamstatus")
    private String teamstatus;

    public String getTeamstatus()
    {    	
    	return DTOBase.nullOnEmpty(teamstatus);
    }

    public boolean isTeamStatusCSV()
    {
        return 	teamstatus != null && teamstatus.indexOf(',') >= 0;
    }
    
    public List<String> getTeamstatusAsList()
    {    	
    	return DTOBase.string2List(teamstatus, ",");
    }
    
	@QueryParam("perioddate")
    private String perioddate;

    public String getPerioddate()
    {    	
    	return DTOBase.nullOnEmpty(perioddate);
    }
    
    public java.sql.Date getPerioddateAsDate()
	{
		return DTOBase.stringAsDate(perioddate);
	}
    
    public int getPerioddateAsPeriodIndex(String aSiteDomain, String aCalendarId)
	{
    	SystemCalendarDTO dto = SystemCalendarLUT.getDateAsCalendarDTO(aSiteDomain, aCalendarId, getPerioddateAsDate());
		if (dto == null)
    	{
    		return -1;
    	}
    	
    	return dto.getCalevemonthAsInt();
    	
	}
    
	public TeamFilter getSearchCondition(String aSiteDomain, String aSite, String aSiteCalendarId)
	{
		TeamFilter filter = new TeamFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" periodindex asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		TeamCriteria criteria = filter.or().andSiteEqualTo(aSite);
		if (getPerioddate() != null)
		{
			criteria.andPeriodindexEqualTo(getPerioddateAsPeriodIndex(aSiteDomain, aSiteCalendarId));
		}
		
		if (getTeamstatus() != null)
		{
			if (isTeamStatusCSV())
			{
				criteria.andTeamstatusIn(getTeamstatusAsList());
			}
			else criteria.andTeamstatusEqualTo(getTeamstatus());
		}
			
		return filter;
	}
}
