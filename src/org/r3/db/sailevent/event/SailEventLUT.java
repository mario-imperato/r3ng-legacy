package org.r3.db.sailevent.event;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;

public class SailEventLUT extends LUT
{
	public SailEventLUT() 
	{
		try
		{
	    setReader(new SailEventLUTReader());	
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aDtokey)
	{
		SailEventDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}
	
	public SailEventDTO getItem(String aDtokey)
	{
	    try
		{		    
	    	SailEventDTO dto = (SailEventDTO)getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

}
