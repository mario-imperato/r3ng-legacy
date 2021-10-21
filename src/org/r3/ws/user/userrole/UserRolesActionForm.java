package org.r3.ws.user.userrole;

import javax.ws.rs.FormParam;

public class UserRolesActionForm
{
		
	@FormParam("userid")
	private String[] userid;
		
	public String[] getUserid()
	{
		return userid;
	}
	

	
}
