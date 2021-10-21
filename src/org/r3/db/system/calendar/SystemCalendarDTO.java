//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendar;

import org.r3.db.DTOBase;

public class SystemCalendarDTO extends SystemCalendarDTOBase
{
	public enum CalendarEntryType { 
	
		work, sunday, saturday, holiday, strike, undef;
		
		public static CalendarEntryType getValueFor(String s, CalendarEntryType defaultValue)
		{
			if (s != null)
				return CalendarEntryType.valueOf(s);
			
			return defaultValue;
		}
	
	};

    @Override
    public String getDtokey()
    {
    	return getDtokey(sitedomain, calendarid, getCaldate());
    }

    public static String getDtokey(String aSiteDomain, String aCalendarId, java.util.Date aCalDate)
    {
    	StringBuilder stb = new StringBuilder().append(aSiteDomain).append('_').append(aCalendarId).append('_').append(dateAsString(aCalDate, DTOBase.sysDateFormat));
    	return stb.toString();
    }

    public SystemCalendarDTO()
    {
        super();
    }

    public SystemCalendarDTO(SystemCalendarDTO another)
    {
        super(another);
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public boolean isWorkingDay()
	{
		return CalendarEntryType.getValueFor(calentrytype, CalendarEntryType.undef) == CalendarEntryType.work;
	}

}
