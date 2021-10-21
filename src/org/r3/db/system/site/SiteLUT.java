package org.r3.db.system.site;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;



public class SiteLUT extends LUT
{
	public SiteLUT() 
	{
		try
		{
	    setReader(new SiteLUTReader());	
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aDtokey)
	{
		SiteDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}
	
	public SiteDTO getItem(String aDtokey)
	{
	    try
		{		    
	    	SiteDTO dto = (SiteDTO)getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

}
