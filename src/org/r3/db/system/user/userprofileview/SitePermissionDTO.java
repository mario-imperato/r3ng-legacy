package org.r3.db.system.user.userprofileview;

import java.util.List;

import org.r3.system.AuthFunction;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class SitePermissionDTO
{
	private String site;
	
	public String getSite()
	{
		return site;
	}

	public void setSite(String site)
	{
		this.site = site;
	}

	private List<RoleDTO> roles;

	public List<RoleDTO> getRoles()
	{
		return roles;
	}

	public void setRoles(List<RoleDTO> functions)
	{
		this.roles = functions;
	}

	public boolean isInRole(AuthFunction f)
	{
		if (roles == null || roles.size() == 0)
			return false;
		
        for(RoleDTO r : roles)
        {
            for(FunctionDTO fun : r.getFunctions())
            {
            	if (fun.getFunctioncode().equalsIgnoreCase(f.toString()))
            		return true;
            }
        }

        return false;
	}

	public boolean hasRole(String aRole)
	{
		if (roles == null || roles.size() == 0)
			return false;
		
        for(RoleDTO r : roles)
        {
        	if (r.getRoleid().equalsIgnoreCase(aRole))
        		return true;
        }

        return false;
	}
	
	public boolean hasRoles(String[] aListOfRoles)
	{
		if (roles == null || roles.size() == 0 || aListOfRoles == null || aListOfRoles.length == 0)
			return false;
		
        for(RoleDTO r : roles)
        {        	
        	String rid = r.getRoleid();
        	for(String reqRole : aListOfRoles)
        	{
            	if (rid.equalsIgnoreCase(reqRole))
            		return true;        		
        	}
        }

        return false;
	}

//	@JsonIgnore
//	public UserProfileAuthInfo asUserProfileAuthInfo()
//	{
//		UserProfileAuthInfo userAuthInfo = new UserProfileAuthInfo();
//		userAuthInfo.setSite(getSite());
//		
//		List<RoleDTO> listOfRoles = getRoles();
//		if (listOfRoles != null)
//		{
//			for(RoleDTO r : listOfRoles)
//			{
//				UserProfileAuthInfo.Role role = new UserProfileAuthInfo.Role();
//				role.setRoleid(r.getRoleid());
//				userAuthInfo.addRole(role);
//				
//				List<FunctionDTO> listOfFunctions = r.getFunctions();
//				if (listOfFunctions != null)
//				{
//					for(FunctionDTO f : listOfFunctions)
//					{
//						UserProfileAuthInfo.Function function = new UserProfileAuthInfo.Function();
//						function.setFunctioncode(f.getFunctioncode());
//						role.addFunction(function);
//					}
//				}
//			}
//		}
//		
//		return userAuthInfo;
//	}
}
