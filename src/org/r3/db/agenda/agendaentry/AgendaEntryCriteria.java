//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.agenda.agendaentry;

import org.r3.db.utils.SQLStringUtils;

public class AgendaEntryCriteria extends
		AgendaEntryFilter.AgendaEntryCriteriaBase
{
    private static String calendarWidgetFilterCriteria_startdate = 
    		"(startdate >= '%s' and startdate <= '%s')";

    private static String calendarWidgetFilterCriteria_enddate = 
    		"(enddate >= '%s' and enddate <= '%s')";

	private static String calendarWidgetFilterCriteria_startdate_enddate = 
    		"((startdate >= '%s' and startdate <= '%s') or (enddate >= '%s' and enddate <= '%s'))";
	    
    private static String dateStringFormat ;
	
	public AgendaEntryCriteria andStartdateOrEnddateInRange(
			java.sql.Date lowEndDate, java.sql.Date highEndDate)
	{
		if (lowEndDate == null && highEndDate == null)
			return null;
		
		StringBuilder stb = new StringBuilder();
		
		String lowEnd = SQLStringUtils.getDateAsSQLString(lowEndDate);
		String highEnd = SQLStringUtils.getDateAsSQLString(highEndDate);
		
		if (lowEnd != null && highEnd != null)
		{
			addCriterion(String.format(
					calendarWidgetFilterCriteria_startdate_enddate, 
					lowEnd, highEnd, lowEnd, highEnd)
			);
		}
		else
		{
		    if (lowEnd != null)
				addCriterion(String.format(
						calendarWidgetFilterCriteria_startdate, 
						lowEnd, highEnd)
				);
		    
		    if (highEnd != null)
		    	addCriterion(String.format(
						calendarWidgetFilterCriteria_enddate, 
						lowEnd, highEnd)
				);		        	
		}

		return (AgendaEntryCriteria) this;
	}
		
	@Override
	public AgendaEntryCriteria andEnddateLessThanOrEqualTo(
			java.sql.Date value)
	{
		if (value != null)
			addSubSelectCriterion("(enddate is null or enddate <= ", value,
					")", "enddate");
		return (AgendaEntryCriteria) this;
	}
	
	@Override
	public AgendaEntryCriteria andStartdateGreaterThanOrEqualTo(java.sql.Date value) {
        if (value != null)
          addCriterion("startdate >=", value, "startdate");
        return (AgendaEntryCriteria) this;
    }
	

}
