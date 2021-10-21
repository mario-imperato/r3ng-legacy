package org.r3.db.system.user.userprofileview;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "FunctionDTO")
public class FunctionDTO
{
	private String functioncode;

	public String getFunctioncode()
	{
		return functioncode;
	}

	public void setFunctioncode(String functioncode)
	{
		this.functioncode = functioncode;
	}

}
