package org.r3.ws.sailevent.event.fivmemberverificationclient;

import java.util.HashMap;

public class HttpResponseEntityFilter
{   
	protected boolean returnCode = false;	
	private HashMap<String, String> pageInfo = null;
    
	public boolean visit(String lineOfBody)
    {
    	return true;
    }
    
	public boolean isSuccess()
	{
		return returnCode;
	}
	
    public HashMap<String, String> getPageInfo()
    {
    	if (pageInfo == null)
    		pageInfo = new HashMap<String, String>();
    	
    	return pageInfo;
    }
    
    public String getPageInfo(String paramName)
    {    	    
    	return getPageInfo().get(paramName);
    }
    
    protected void addInfo(String paramName, String paramValue)
    {
    	getPageInfo().put(paramName, paramValue);
    }
}
