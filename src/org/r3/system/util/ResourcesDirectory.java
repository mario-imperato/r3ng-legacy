package org.r3.system.util;

import java.io.File;

public class ResourcesDirectory extends SystemDirectory
{

	public ResourcesDirectory(String aRootLocation)
	{
		super(aRootLocation, "/");
	}
	
    public File getFile(String aFileName)
    {
    	if (aFileName.indexOf("/") >= 0)
    		return new File(aFileName);
    	    	
    	File f = new File(rootLocation, aFileName);
    	return f;
    }
    
}
