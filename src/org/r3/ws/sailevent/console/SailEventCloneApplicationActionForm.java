package org.r3.ws.sailevent.console;

import javax.ws.rs.FormParam;

public class SailEventCloneApplicationActionForm
{
	@FormParam("cloneeventid")
	private String cloneeventid;

	public String getCloneeventid()
	{
		return cloneeventid;
	}
	
}
