package org.r3.system.struts;

//import org.apache.struts.action.*;
import org.apache.struts.config.ControllerConfig;

public class GWFControllerConfig extends ControllerConfig
{
	private String guestUserId = null;
	private String guestPassword = null;

	public void setGuestUserId(String anId)
	{
		guestUserId = anId;
	}

	public void setGuestPassword(String aPassword)
	{
		guestPassword = aPassword;
	}


}
