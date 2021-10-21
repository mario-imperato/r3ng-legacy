package org.r3.db.dms.model;


import java.io.File;

public class DMSFileHelper
{
    public static File getDMSFileAsFile(DMSContext dmsContext, String aDmsUrl)
    {
		File actualFile = null;
		try
		{
			DMSFile f = new DMSFile(new DMSFileSystemUrl(aDmsUrl));
			actualFile = f.getFile(dmsContext);
		}
		catch (DMSException e)
		{
			e.printStackTrace();
		}
		
		return actualFile;
    }
    
    public static String getDMSFileFileName(String aDMSUrl)
    {
    	String s = aDMSUrl;
		if (s != null)
		{
			int ndx = s.lastIndexOf("/");
			if (ndx >= 0)
				 s = s.substring(ndx + 1);		
		}		

 		return s;
    }
    
	public static boolean deleteDMSFile(DMSContext dmsContext, String aDMSUrl) 
	{
		try
		{
        if (aDMSUrl != null)
        {
   			DMSFile f = new DMSFile(new DMSFileSystemUrl(aDMSUrl));
   			f.delete(dmsContext);
        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
        
        return true;
	}

}
