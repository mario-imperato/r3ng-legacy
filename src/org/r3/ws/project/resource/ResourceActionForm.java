package org.r3.ws.project.resource;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardDTO.PageLinkType;
import org.r3.db.cms.card.CardDTO.ValidityRule;
import org.r3.db.project.resource.ResourceDTO;
import org.r3.db.project.resource.ResourceDTO.ResourceType;
import org.r3.db.project.teamresource.TeamResourceDTO;
import org.r3.db.project.teamresource.TeamResourceDTO.ResourceStatus;
import org.r3.system.rest.SecurityTokenActionForm;
import org.r3.system.util.StringUtils;

public class ResourceActionForm extends SecurityTokenActionForm
{
	@FormParam("resourceid")
    private String resourceid;

    public String getResourceid()
    {    	
    	return DTOBase.nullOnEmpty(resourceid);
    }
    
	@FormParam("ssn")
    private String ssn;

    public String getSsn()
    {    	
    	return DTOBase.nullOnEmpty(ssn);
    }
    
	@FormParam("firstname")
    private String firstname;

    public String getFirstname()
    {    	
    	return DTOBase.nullOnEmpty(firstname);
    }

	@FormParam("lastname")
    private String lastname;

    public String getLastname()
    {    	
    	return DTOBase.nullOnEmpty(lastname);
    }
    
    public String getResourcedescr()
    {
    	return StringUtils.joinStrings(getFirstname(), getLastname());    	
    }
    
	@FormParam("email")
    private String email;

    public String getEmail()
    {    	
    	return DTOBase.nullOnEmpty(email);
    }

	@FormParam("cellphone")
    private String cellphone;

    public String getCellphone()
    {    	
    	return DTOBase.nullOnEmpty(cellphone);
    }

	@FormParam("phone")
    private String phone;

    public String getPhone()
    {    	
    	return DTOBase.nullOnEmpty(phone);
    }

	@FormParam("address")
    private String address;

    public String getAddress()
    {    	
    	return DTOBase.nullOnEmpty(address);
    }

	@FormParam("town")
    private String town;

    public String getTown()
    {    	
    	return DTOBase.nullOnEmpty(town);
    }

	@FormParam("zipcode")
    private String zipcode;

    public String getZipcode()
    {    	
    	return DTOBase.nullOnEmpty(zipcode);
    }
	
	@FormParam("userid")
    private String userid;

    public String getUserid()
    {    	
    	return DTOBase.nullOnEmpty(userid);
    }
    
	@FormParam("profileid")
    private String profileid;

    public String getProfileid()
    {    	
    	return DTOBase.nullOnEmpty(profileid);
    }
    
	@FormParam("teamid")
    private String teamid;

    public String getTeamid()
    {    	
    	return DTOBase.nullOnEmpty(teamid);
    }
    
	public ResourceDTO getDTO4Insert(String aSiteDomain)
	{
		ResourceDTO dto = new ResourceDTO();
		dto.setSitedomain(aSiteDomain);
		dto.setResourcetype(ResourceType.hr.toString());
		
		dto.setSsn(getSsn());
		
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setResourcedescr(getResourcedescr());
		
		dto.setEmail(getEmail());
		dto.setCellphone(getCellphone());
		dto.setPhone(getPhone());
		dto.setAddress(getAddress());
		dto.setZipcode(getZipcode());
		dto.setTown(getTown());
		dto.setUserid(getUserid());
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		
		return  dto;
	}

	public TeamResourceDTO getDTO4SiteResourceInsert(String aSite, String aResourceId)
	{
		TeamResourceDTO dto = new TeamResourceDTO();
	    dto.setSite(aSite);
	    dto.setTeamid(getTeamid());
	    dto.setResourceid(aResourceId);
	    dto.setEvalueunit("day");
	    dto.setCost(0.0f);
	    dto.setPrice(0.0f);
	    dto.setProfileid(getProfileid());
	    dto.setResourcedefstatus(ResourceStatus.incomplete.toString());
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    
	    return dto;
	}
	
	
	public ResourceDTO getDTO4Update(ResourceDTO asIsActor)
	{		
		ResourceDTO dto = new ResourceDTO(asIsActor);		

		dto.setEmail(getEmail());
		dto.setCellphone(getCellphone());
		dto.setPhone(getPhone());
		dto.setAddress(getAddress());
		dto.setZipcode(getZipcode());
		dto.setUserid(getUserid());
		dto.setTown(getTown());
		return  dto;
	}

	public TeamResourceDTO getDTO4SiteResourceUpdate(TeamResourceDTO asIsActor)
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
	
    public CardDTO getCMSCardDTO4Insert(String currentSite, String aTopicId)
	{
		CardDTO dto = new CardDTO();
		dto.setSite(currentSite);
		dto.setCardid(aTopicId);
		
		dto.setSystemtitle(getResourcedescr());
	    dto.setValidityrule(ValidityRule.never.toString());
	    dto.setCategoryid("resource");
	    
	    dto.setPagelinktype(PageLinkType.none.toString());
	    dto.setRefdate(DTOBase.currentDate());
	    
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}
}
