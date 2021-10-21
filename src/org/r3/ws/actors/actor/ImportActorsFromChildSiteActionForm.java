package org.r3.ws.actors.actor;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupDTO.GroupNature;
import org.r3.system.rest.SecurityTokenActionForm;

public class ImportActorsFromChildSiteActionForm extends SecurityTokenActionForm
{
	@FormParam("actorgroup")
    private String actorgroup;

    public String getActorgroup()
    {    	
    	return DTOBase.nullOnEmpty(actorgroup);
    }

	@FormParam("sourcesite")
    private String sourcesite;

    public String getSourcesite()
    {    	
    	return DTOBase.nullOnEmpty(sourcesite);
    }

	@FormParam("sourcegroup")
    private String sourcegroup;

    public String getSourcegroup()
    {    	
    	return DTOBase.nullOnEmpty(sourcegroup);
    }

    public String[] getProcessingopts()
    {
    	String[] processingOpts = new String[2];
    	processingOpts[0] = "mail_required";
    	processingOpts[1] = "checkduplicates";
    	return processingOpts;    	
    }
    
    public String getImportActorGroupTitle()
    {
    	StringBuilder stb = new StringBuilder();
    	stb.append("IMP.").append(sourcesite);
        
    	if (sourcegroup != null)
    		stb.append(sourcegroup);	
    
        stb.append(DTOBase.currentTimestampAsFileStampString());    	
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
