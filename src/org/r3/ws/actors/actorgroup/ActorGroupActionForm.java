package org.r3.ws.actors.actorgroup;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupDTO.GroupNature;
import org.r3.db.actor.group.ActorGroupDTO.GroupProfile;

public class ActorGroupActionForm
{

	@FormParam("grouptitle")
    private String grouptitle;

    public String getGrouptitle()
    {    	
    	return DTOBase.nullOnEmpty(grouptitle);
    }

    @FormParam("createfromgroup")
    private String createfromgroup;
        	
	public String getCreatefromgroup()
	{
		return DTOBase.nullOnEmpty(createfromgroup);
	}

	public boolean getCreatefromgroupAsBoolean()
	{
		return DTOBase.nullOnEmpty(createfromgroup) != null;
	}
	
	public boolean isCreateFromAllContacts()
	{
		String s = getCreatefromgroup();
		if (s != null && s.equalsIgnoreCase("__ALL__"))
			return true;
		
		return false;
	}
	
	@FormParam("actorid")
	private String[] actorid;
		
	public String[] getActorid()
	{
		return actorid;
	}

	@FormParam("groupprofile")
	private String[] groupprofile;
		
	public String[] getGroupprofile()
	{
		return groupprofile;
	}

	public String getGroupprofileAsCSV()
    {
		String s = DTOBase.stringArray2CSV(groupprofile);
		if (s == null)
			s = GroupProfile.visible.toString();
		else
		{
		   StringBuilder stb = new StringBuilder();
		   stb.append(s).append(',').append(GroupProfile.visible.toString());
		   s = stb.toString();
		}
		
        return s;	
    }
    	
	public ActorGroupDTO getDTO4Insert(String aSite)
	{
		ActorGroupDTO dto = new ActorGroupDTO();
		dto.setEventid(aSite);
		dto.setGrouptitle(getGrouptitle());
		dto.setGroupnature(GroupNature.user.toString());
		dto.setGroupprofile(getGroupprofileAsCSV());
		return  dto;
	}

	public ActorGroupDTO getDTO4Update(String aSite, String aUserId)
	{
		ActorGroupDTO dto = new ActorGroupDTO();
		dto.setEventid(aSite);	
		dto.setGroupid(aUserId);
		dto.setGrouptitle(getGrouptitle());
		dto.setGroupprofile(getGroupprofileAsCSV());
		return  dto;
	}

	
}
