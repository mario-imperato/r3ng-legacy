package org.r3.db.system.user.userprofileview;

import java.util.List;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "RoleDTO")
public class RoleDTO
{
	private String roleid;

	public RoleDTO()
	{
		
	}
	
	public String getRoleid()
	{
		return roleid;
	}

	public void setRoleid(String roleid)
	{
		this.roleid = roleid;
	}

	private List<FunctionDTO> functions;

	public List<FunctionDTO> getFunctions()
	{
		return functions;
	}

	public void setFunctions(List<FunctionDTO> functions)
	{
		this.functions = functions;
	}

}
