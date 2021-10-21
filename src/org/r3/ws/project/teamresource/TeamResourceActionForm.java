package org.r3.ws.project.teamresource;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.project.teamresource.TeamResourceDTO;
import org.r3.db.project.teamresource.TeamResourceDTO.ResourceStatus;
import org.r3.system.rest.SecurityTokenActionForm;

public class TeamResourceActionForm extends SecurityTokenActionForm
{	    
	@FormParam("profileid")
    private String profileid;

    public String getProfileid()
    {    	
    	return DTOBase.nullOnEmpty(profileid);
    }
    
    @FormParam("srcteamid")
    private String srcteamid;

    public String getSrcteamid()
    {    	
    	return DTOBase.nullOnEmpty(srcteamid);
    }
    
	public TeamResourceDTO getDTO4TeamResourceInsert(String aSite, String aTeamId, String aResourceId)
	{
		TeamResourceDTO dto = new TeamResourceDTO();
	    dto.setSite(aSite);
	    dto.setTeamid(aTeamId);
	    dto.setResourceid(aResourceId);
	    dto.setEvalueunit("day");
	    dto.setCost(0.0f);
	    dto.setPrice(0.0f);
	    dto.setProfileid(getProfileid());
	    dto.setResourcedefstatus(ResourceStatus.incomplete.toString());
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    
	    return dto;
	}
		
	public TeamResourceDTO getDTO4TeamResourceUpdate(TeamResourceDTO asIsActor)
	{
		TeamResourceDTO dto = new TeamResourceDTO(asIsActor);
	   
	    dto.setEvalueunit("day");
	    dto.setCost(0.0f);
	    dto.setPrice(0.0f);
	    dto.setProfileid(getProfileid());	
	    dto.setResourcedefstatus(ResourceStatus.incomplete.toString());
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    
	    return dto;
	}
	
    
}
