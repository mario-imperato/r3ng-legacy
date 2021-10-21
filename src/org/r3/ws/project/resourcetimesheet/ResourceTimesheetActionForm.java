package org.r3.ws.project.resourcetimesheet;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.project.resourcetimesheet.ResourceTimesheetDTO;
import org.r3.system.rest.SecurityTokenActionForm;

public class ResourceTimesheetActionForm extends SecurityTokenActionForm
{

	@FormParam("teamid")
    private String teamid;

    public String getTeamid()
    {    	
    	return DTOBase.nullOnEmpty(teamid);
    }
    
	@FormParam("ordeffort")
    private String ordeffort;

    public String getOrdeffort()
    {    	
    	return DTOBase.nullOnEmpty(ordeffort);
    }

	@FormParam("exteffort")
    private String exteffort;

    public String getExteffort()
    {    	
    	return DTOBase.nullOnEmpty(exteffort);
    }

	@FormParam("oncalleffort")
    private String oncalleffort;

    public String getOncalleffort()
    {    	
    	return DTOBase.nullOnEmpty(oncalleffort);
    }
    
	public ResourceTimesheetDTO getDTO4Insert(String aSite, String aResourceId, int aCaleveDay, String aUserid)
	{
		ResourceTimesheetDTO dto = new ResourceTimesheetDTO();
		
		dto.setCaleveday(aCaleveDay);	
		dto.setSite(aSite);
		dto.setTeamid(getTeamid());
		dto.setResourceid(aResourceId);
				
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		
		dto.setOrdeffort(getOrdeffort());
		dto.setExteffort(getExteffort());
		dto.setOncalleffort(getOncalleffort());
		dto.setUniteffort("hour");
       			
		dto.setTseuserid(aUserid);
		return  dto;
	}


}
