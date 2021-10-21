package org.r3.system.util;

import java.text.SimpleDateFormat;

public class SystemDirectory
{
	protected static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd_HHmmss_SS");
	protected String rootLocation;
	
    public SystemDirectory(String aRootLocation, String defaultLocation)
    {
    	if (aRootLocation == null)
    		   rootLocation = defaultLocation;
    	else   rootLocation = aRootLocation;    	    	
    }
    
    public void release()
    {

    }

}
