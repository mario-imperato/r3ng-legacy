package org.r3.db.system.sitecmspropertyview;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;

public class SiteCMSPropertyLUT extends LUT
{
	public SiteCMSPropertyLUT() 
	{
		try
		{
	    setReader(new SiteCMSPropertyLUTReader());	
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aDtokey)
	{
		SiteCMSPropertyLUTDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}
	
	public SiteCMSPropertyLUTDTO getItem(String aDtokey)
	{
	    try
		{		    
	    	SiteCMSPropertyLUTDTO dto = (SiteCMSPropertyLUTDTO)getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

}
