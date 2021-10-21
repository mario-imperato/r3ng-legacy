package org.r3.ws.user.user;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.ws.rs.FormParam;

import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserDTO.UserType;
import org.r3.db.system.user.user.UserFilter;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.util.Codecs;
import org.r3.system.util.CryptoUtils;

public class UserActionForm
{
	@FormParam("securetoken")
    private String securetoken;

    public String getSecuretoken()
    {    	
    	return DTOBase.nullOnEmpty(securetoken);
    }

	@FormParam("securecode")
    private String securecode;

    public String getSecurecode()
    {    	
    	return DTOBase.nullOnEmpty(securecode);
    }

    private String getSecuretokenDecoded() throws GeneralSecurityException, IOException
    {
        String s = getSecuretoken();
        if (s != null)
        {
        	return CryptoUtils.decrypt(s);
        }
        
        return null;
    }
    
    public boolean isSecuritycodeValid()
    {
        try
        {
        	String token = getSecuretokenDecoded();
        	String scode = getSecurecode();
        	
        	if (token != null && scode != null && token.equalsIgnoreCase(scode))
        		return true;
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        return false;        
    }

	@FormParam("activationcode")
    private String activationcode;

    public String getActivationcode()
    {    	
    	return DTOBase.nullOnEmpty(activationcode);
    }
        
    public boolean isDirectActivation(String systemActivationCode)
    {
    	String s = getActivationcode();
        if (systemActivationCode != null && s != null && systemActivationCode.equalsIgnoreCase(s))
        	return true;
        
        return false;
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
    
	@FormParam("email")
    private String email;

    public String getEmail()
    {    	
    	return DTOBase.nullOnEmpty(email);
    }
       
	@FormParam("nickname")
    private String nickname;

    public String getNickname()
    {    	
    	String n = DTOBase.nullOnEmpty(nickname);
    	if (n == null)
    		return getEmail();
    	
    	return n;
    }

	@FormParam("currentpassword")
    private String currentpassword;

    public String getCurrentpassword()
    {    	
    	return DTOBase.nullOnEmpty(currentpassword);
    }
    
	@FormParam("password")
    private String password;

    public String getPassword()
    {    	
    	return DTOBase.nullOnEmpty(password);
    }
	
	@FormParam("recstatus")
    private String recstatus;

    public String getRecstatus()
    {    	
    	return DTOBase.nullOnEmpty(recstatus);
    }
    
    @FormParam("createsiteactor")
    private String createsiteactor;
        
	public String getCreatesiteactor()
	{
		return createsiteactor;
	}

	public boolean getCreatesiteactorAsBoolean()
	{
		return DTOBase.getBTrueFalseAsBoolean(createsiteactor);
	}

	@FormParam ("authrole")
	private String[] authrole;

	public String[] getAuthrole()
	{				
		return authrole;
	}
	
	@FormParam ("roles")
	private String[] roles;

	public String[] getRoles()
	{
		if (roles != null && roles.length == 1)
		{
			if (roles[0].indexOf(",") >= 0)
			{
				roles = roles[0].split(",");
			}				
		}
		return roles;
	}
	
	public UserDTO getDTO4Insert()
	{
		UserDTO dto = new UserDTO();
		dto.setNickname(getNickname());
		dto.setPassword(Codecs.digestAsString(getPassword()));
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setEmail(getEmail());
		dto.setRecstatus(getRecstatus());
		
		dto.setUsertype(UserType.user.toString());
		return  dto;
	}

	public UserCollectionDTO getUserCollectionDTO4Insert(String aUserId)
	{
		UserCollectionDTO dto = new UserCollectionDTO();
		dto.setUserid(aUserId);		
		dto.setNickname(getNickname());
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setEmail(getEmail());
		dto.setUsertype(UserType.user.toString());
		return  dto;
	}
	
	public UserDTO getDTO4ChangePassword(String aUserId)
	{
		UserDTO dto = new UserDTO();
		dto.setUserid(aUserId);
		dto.setPassword(Codecs.digestAsString(getPassword()));
		return  dto;
	}

	public UserDTO getDTO4Update(String aUserId)
	{
		UserDTO dto = new UserDTO();
		dto.setUserid(aUserId);
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setEmail(getEmail());
		dto.setRecstatus(getRecstatus());
		
		return  dto;
	}

	public UserCollectionDTO getUserCollectionDTO4Update(String aUserId, UpdateOperations<UserCollectionDTO> uop)
	{
		UserCollectionDTO dto = new UserCollectionDTO();
		dto.setUserid(aUserId);
		dto.setFirstname4Update(uop, getFirstname());
		dto.setLastname4Update(uop, getLastname());
		dto.setEmail4Update(uop, getEmail());

		return  dto;
	}
	
	public UserDTO getDTO4Registration(boolean activate)
	{
		UserDTO dto = new UserDTO();
		dto.setNickname(getNickname());
		dto.setPassword(Codecs.digestAsString(getPassword()));
		dto.setFirstname(getFirstname());
		dto.setLastname(getLastname());
		dto.setEmail(getEmail());
		dto.setUsertype(UserType.user.toString());
		if (activate)
		   dto.setRecstatus(RecordStatus.sys_recact.toString());
		else
		   dto.setRecstatus(RecordStatus.sys_recblock.toString());
		
		dto.setNumberoflogins(0);
		return  dto;
	}
	
	public UserDTO getDTO4ResetPassword(String newPassword)
	{
		UserDTO dto = new UserDTO();
		dto.setPassword(Codecs.digestAsString(newPassword));
		return  dto;
	}

	public UserFilter getDTO4FilterUpdateResetPassword()
	{
		UserFilter dto = new UserFilter();
		dto.or().andEmailEqualTo(getEmail());
		return  dto;
	}

	public UserDTO getDTO4ChangeMyPassword()
	{
		UserDTO dto = new UserDTO();
		
		dto.setPassword(Codecs.digestAsString(getPassword()));
		return  dto;
	}

	public UserFilter getDTO4FilterUpdateChangeMyPassword(UserProfileViewDTO userprofile)
	{
		UserFilter dto = new UserFilter();
		dto.or().andUseridEqualTo(userprofile.getUserid()).andPasswordEqualTo(Codecs.digestAsString(getCurrentpassword()));
		return  dto;
	}
	

	
}
