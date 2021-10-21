package org.r3.ws.actors.actor;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.system.rest.SecurityTokenActionForm;

public class ActorActionForm extends SecurityTokenActionForm
{

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
	
	@FormParam("actorgroup")
    private String actorgroup;

    public String getActorgroup()
    {    	
    	return DTOBase.nullOnEmpty(actorgroup);
    }

	@FormParam("userid")
    private String userid;

    public String getUserid()
    {    	
    	return DTOBase.nullOnEmpty(userid);
    }
    
	public ActorDTO getDTO4Insert(String aSite)
	{
		ActorDTO dto = new ActorDTO();
		dto.setEventid(aSite);
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
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
	
	
	public ActorDTO getDTO4Update(ActorDTO asIsActor)
	{		
		ActorDTO dto = new ActorDTO(asIsActor);
		
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setEmail(getEmail());
		dto.setCellphone(getCellphone());
		dto.setPhone(getPhone());
		dto.setAddress(getAddress());
		dto.setZipcode(getZipcode());
		dto.setUserid(getUserid());
		dto.setTown(getTown());
		return  dto;
	}

	
}
