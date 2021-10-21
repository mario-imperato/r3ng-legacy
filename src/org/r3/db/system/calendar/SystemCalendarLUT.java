package org.r3.db.system.calendar;

import org.r3.db.DTOBase;
import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;



public class SystemCalendarLUT extends LUT
{

	public SystemCalendarLUT(long aTimeout)
	{
		super(aTimeout);

		try
		{
			setReader(new SystemCalendarLUTReader());
			// setTimeout(UNEPCalendarDTO.ADAYINMSECS);
		}
		catch (LUTException lute)
		{
			lute.printStackTrace();
		}
	}

	public SystemCalendarDTO getItem(String aSiteDomain, String aCalendarId, java.util.Date aDate)
	{
		if (aDate == null)
			return null;
				
		return getItem(SystemCalendarDTO.getDtokey(aSiteDomain, aCalendarId, aDate));
	}

	public SystemCalendarDTO getItem4Today(String aSiteDomain, String aCalendarId)
	{				
		return getItem(SystemCalendarDTO.getDtokey(aSiteDomain, aCalendarId, DTOBase.currentDate()));
	}
	
	public SystemCalendarDTO getItem(String aDtokey)
	{
		try
		{
			SystemCalendarDTO dto = (SystemCalendarDTO) getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}

		return null;
	}
	
	public static int getTodayAsCalendarEveDay(String aSiteDomain, String aCalendarId)
    {    	
    	return getDateAsCalendarEveDay(aSiteDomain, aCalendarId, new java.util.Date());
    }

	public static int getDateAsCalendarEveDay(String aSiteDomain, String aCalendarId, java.util.Date aDate)
    {
		SystemCalendarLUT lut = (SystemCalendarLUT)LUTManager.getLUTManager().getLUT(LUTName.calendar, null);
		SystemCalendarDTO dto = lut.getItem(aSiteDomain, aCalendarId, aDate);
    	if (dto == null)
    	{
    		return -1;
    	}
    	
    	return dto.getCalevedayAsInt();
    }

	public static SystemCalendarDTO getDateAsCalendarDTO(String aSiteDomain, String aCalendarId, java.util.Date aDate)
    {
		SystemCalendarLUT lut = (SystemCalendarLUT)LUTManager.getLUTManager().getLUT(LUTName.calendar, null);
		SystemCalendarDTO dto = lut.getItem(aSiteDomain, aCalendarId, aDate);
    	return dto;
    }
	
	public static SystemCalendarDTO getDateAsCalendarDTO(String aSiteDomain, String aCalendarId, String aDate)
    {
		SystemCalendarLUT lut = (SystemCalendarLUT)LUTManager.getLUTManager().getLUT(LUTName.calendar, null);
		SystemCalendarDTO dto = lut.getItem(aSiteDomain, aCalendarId, DTOBase.stringAsDate(aDate));
    	return dto;
    }
	
}
