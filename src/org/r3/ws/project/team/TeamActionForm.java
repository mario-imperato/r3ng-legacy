package org.r3.ws.project.team;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.project.team.TeamDTO;
import org.r3.db.project.team.TeamDTO.TeamStatus;
import org.r3.db.system.calendarperiod.SystemCalendarPeriodDTO.PeriodType;

public class TeamActionForm
{
	@FormParam("teamdescr")
	private String teamdescr;
	
	public String getTeamdescr()
	{
		return DTOBase.nullOnEmpty(teamdescr);
	}
	
	@FormParam("periodindex")
    private String periodindex;

    public String getPeriodindex()
    {    	
    	return DTOBase.nullOnEmpty(periodindex);
    }
    
    public int getPeriodindexAsInt()
    {    	
    	String s = DTOBase.nullOnEmpty(periodindex);
    	if (s != null)
    		return Integer.parseInt(s);
    	
    	return -1;
    }

	@FormParam("templateteamid")
    private String templateteamid;

    public String getTemplateteamid()
    {    	
    	return DTOBase.nullOnEmpty(templateteamid);
    }
    
	public TeamDTO getDTO4Insert(String aSite)
	{
		TeamDTO dto = new TeamDTO();
		dto.setSite(aSite);
		dto.setTeamdescr(getTeamdescr());
		dto.setPeriodtype(PeriodType.monthly.toString());
		dto.setPeriodindex(getPeriodindex());
        dto.setTeamstatus(TeamStatus.team_empty.toString());
		return  dto;
	}

	public TeamDTO getDTO4Update(TeamDTO dto)
	{		        
		dto.setTeamdescr(getTeamdescr());	
       	return  dto;
	}


}
