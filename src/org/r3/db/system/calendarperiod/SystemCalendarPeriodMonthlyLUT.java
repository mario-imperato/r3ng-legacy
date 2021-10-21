package org.r3.db.system.calendarperiod;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;

public class SystemCalendarPeriodMonthlyLUT extends LUT
{
	
	public SystemCalendarPeriodMonthlyLUT() 
	{
		try
		{
	    setReader(new  SystemCalendarPeriodLUTReader("monthly"));
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
