package org.r3.ws.user.user;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserDTO.UserType;
import org.r3.system.util.Codecs;

public class LoginActionForm
{
	
	@FormParam ("password")
    private String password;
		
	public String getPassword()
	{
		return password;
	}
	
	@FormParam ("membershipid")
    private String membershipid;
		
	public String getMembershipid()
	{
		return DTOBase.nullOnEmpty(membershipid);
	}
	
	@FormParam ("rememberme")
    private String rememberme;
		
	public String getRememberme()
	{
		return rememberme;
	}
	
	public boolean shouldRememberUserSession()
	{
		return DTOBase.getBTrueFalseAsBoolean(rememberme);
	}
	
	@FormParam ("accesstoken")
    private String accesstoken;
		
	public String getAccesstoken()
	{
		return accesstoken;
	}

	@FormParam ("fbuserid")
    private String fbuserid;
		
	public String getFbuserid()
	{
		return fbuserid;
	}
	
	@FormParam ("firstname")
    private String firstname;
		
	public String getFirstname()
	{
		return firstname;
	}

	@FormParam ("lastname")
    private String lastname;
		
	public String getLastname()
	{
		return lastname;
	}
	
	@FormParam ("email")
    private String email;
		
	public String getEmail()
	{
		return email;
	}
	
	public UserDTO getDTO4FBRegistration()
	{
		UserDTO dto = new UserDTO();
		dto.setNickname(getEmail());
		dto.setPassword(Codecs.digestAsString("regatta"));
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setEmail(getEmail());
		dto.setUsertype(UserType.user.toString());
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		dto.setLastlogin(DTOBase.currentTimestamp());
		dto.setFbuserid(getFbuserid());
		dto.setNumberoflogins(0);
		return  dto;
	}
	
	public UserCollectionDTO getUserCollectionDTO4Insert(String aUserId)
	{
		UserCollectionDTO dto = new UserCollectionDTO();
		dto.setUserid(aUserId);		
		dto.setNickname(getEmail());
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setEmail(getEmail());
		dto.setUsertype(UserType.user.toString());
		return  dto;
	}
}
