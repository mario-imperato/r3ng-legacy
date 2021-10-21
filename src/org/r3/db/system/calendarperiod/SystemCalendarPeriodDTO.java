//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendarperiod;

public class SystemCalendarPeriodDTO extends SystemCalendarPeriodDTOBase
{
	public enum PeriodType { weekly, monthly, quarterly, yearly };
	
    public SystemCalendarPeriodDTO()
    {
        super();
    }

    public SystemCalendarPeriodDTO(SystemCalendarPeriodDTO another)
    {
        super(another);
    }

	@Override
	public String getDtokey()
	{
		return getPeriodindexAsString();
	}
}
