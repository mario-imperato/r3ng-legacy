package org.r3.db.system.calendarperiod;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;

public class SystemCalendarPeriodYearlyLUT extends LUT
{
	
	public SystemCalendarPeriodYearlyLUT() 
	{
		try
		{
	    setReader(new  SystemCalendarPeriodLUTReader("yearly"));
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
	
	public SystemCalendarPeriodDTO getItem(String aDtokey)
	{
	    try
		{		    
	    	SystemCalendarPeriodDTO dto = (SystemCalendarPeriodDTO)getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}
		
	public String getDtodescr(String aDtokey)
	{
		SystemCalendarPeriodDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getPerioddescr();
			    
	    return null;
	}
}
