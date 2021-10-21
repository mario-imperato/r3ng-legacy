package org.r3.ws.actors.actor;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupDTO.GroupNature;
import org.r3.ws.system.fileimport.ProcessFileImportActionForm;

public class ProcessActorFileImportActionForm extends ProcessFileImportActionForm
{
	@FormParam("actorgroup")
    private String actorgroup;

    public String getActorgroup()
    {    	
    	return DTOBase.nullOnEmpty(actorgroup);
    }

    public String getImportActorGroupTitle()
    {
    	StringBuilder stb = new StringBuilder();
    	stb.append("IMP.").append(DTOBase.currentTimestampAsFileStampString());
    	
    	return stb.toString();
    }
    
    public ActorGroupDTO getImportActorGroup4Insert(String aSite)
    {
    	ActorGroupDTO dto = new ActorGroupDTO();
    	dto.setEventid(aSite);
		dto.setGrouptitle(getImportActorGroupTitle());
		dto.setGroupnature(GroupNature.user.toString());
		dto.setGroupprofile("visible,deletable");
		return dto;    	
    }
}
