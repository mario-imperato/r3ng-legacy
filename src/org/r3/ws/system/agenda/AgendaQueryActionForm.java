package org.r3.ws.system.agenda;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.agenda.agendaentry.AgendaEntryCriteria;
import org.r3.db.agenda.agendaentry.AgendaEntryFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class AgendaQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("start")
    private String start;

    public String getStart()
    {
   		return DTOBase.nullOnEmpty(start);
    }

    public java.sql.Date getStartAsDate()
    {
        String s = getStart();
        if (s != null)
        	return DTOBase.stringAsDate(s, DTOBase.ISO8601DateFormat);
        
        return null;
    }
    
//    public java.sql.Timestamp getStartAsTimestamp()
//    {
//        String s = getStart();
//        if (s != null)
//        	return DTOBase.stringAsTimestamp(s, DTOBase.ISO8601DateFormat);
//        
//        return null;
//    }

	@QueryParam("end")
    private String end;

    public String getEnd()
    {
   		return DTOBase.nullOnEmpty(end);
    }
    
    public java.sql.Date getEndAsDate()
    {
        String s = getEnd();
        if (s != null)
        	return DTOBase.stringAsDate(s, DTOBase.ISO8601DateFormat);
        
        return null;
    }
    
	public AgendaEntryFilter getSearchCondition(String aSite, String anAgendaId)
	{
		AgendaEntryFilter filter = new AgendaEntryFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" startdate asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		AgendaEntryCriteria criteria = filter.or().andAgendaidEqualTo(anAgendaId)
				.andStartdateOrEnddateInRange(getStartAsDate(), getEndAsDate());
		
		return filter;
	}

}
