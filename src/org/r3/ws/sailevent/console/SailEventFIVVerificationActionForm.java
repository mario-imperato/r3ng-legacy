package org.r3.ws.sailevent.console;

import javax.ws.rs.FormParam;

public class SailEventFIVVerificationActionForm
{
	@FormParam("yachtclubcode")
	private String yachtclubcode;

	public String getYachtclubcode()
	{
		return yachtclubcode;
	}
	
	@FormParam("yachtclubpwd")
	private String yachtclubpwd;
	
	public String getYachtclubpwd()
	{
		return yachtclubpwd;
	}
	
	@FormParam("applicationid")
	private String[] applicationid;
	
	public String[] getApplicationid()
	{
		if (applicationid != null && applicationid.length == 1)
		{
			if (applicationid[0].indexOf(",") >= 0)
			{
				applicationid = applicationid[0].split(",");
			}				
		}
		
		return applicationid;
	}
	

}
