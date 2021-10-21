package org.r3.db.system.calendarperiod;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;

public class SystemCalendarPeriodWeeklyLUT extends LUT
{
	
	public SystemCalendarPeriodWeeklyLUT() 
	{
		try
		{
	    setReader(new  SystemCalendarPeriodLUTReader("weekly"));	
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
