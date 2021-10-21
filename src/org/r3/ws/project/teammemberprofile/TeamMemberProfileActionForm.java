package org.r3.ws.project.teammemberprofile;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.project.teammemberprofile.TeamMemberProfileDTO;

public class TeamMemberProfileActionForm
{
	@FormParam("profileid")
    private String profileid;

    public String getProfileid()
    {    	
    	return DTOBase.nullOnEmpty(profileid);
    }

	@FormParam("profiledescr")
    private String profiledescr;

    public String getProfiledescr()
    {    	
    	return DTOBase.nullOnEmpty(profiledescr);
    }

	@FormParam("itemorder")
    private String itemorder;

    public String getItemorder()
    {    	
    	return DTOBase.nullOnEmpty(itemorder);
    }

    public int getItemorderAsInt()
    {    	
    	String s = DTOBase.nullOnEmpty(itemorder);
    	if (s != null)
    		return Integer.parseInt(s);
    	
    	return 99;
    }
    
	@FormParam("skillprofile")
    private String skillprofile;

    public String getSkillprofile()
    {    	
    	return DTOBase.nullOnEmpty(skillprofile);
    }

	@FormParam("skillambit")
    private String skillambit;

    public String getSkillambit()
    {    	
    	return DTOBase.nullOnEmpty(skillambit);
    }
    
	public TeamMemberProfileDTO getDTO4Insert(String aSite, String aTeamId)
	{
		TeamMemberProfileDTO dto = new TeamMemberProfileDTO();
		dto.setProfileid(getProfileid());
        dto.setSite(aSite);
        dto.setTeamid(aTeamId);
        dto.setProfiledescr(getProfiledescr());
        dto.setSkillambit(getSkillambit());
        dto.setSkillprofile(getSkillprofile());  
        dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}

	public TeamMemberProfileDTO getDTO4Update(TeamMemberProfileDTO dto)
	{		        
		dto.setProfiledescr(getProfiledescr());
		dto.setSkillambit(getSkillambit());
	    dto.setSkillprofile(getSkillprofile());  

       	return  dto;
	}


}
