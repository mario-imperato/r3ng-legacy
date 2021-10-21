//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agendaentry;

import org.r3.db.DTOBase;

public class AgendaEntryDTO extends AgendaEntryDTOBase
{
    public AgendaEntryDTO()
    {
        super();
    }

    public AgendaEntryDTO(AgendaEntryDTO another)
    {
        super(another);
    }

    
    public String getId()
	{
		return agendaentryid;
	}

    public java.lang.String   getTitle()         { return entrydescr; }
    
	public String getStart()
	{
		StringBuilder stb = new StringBuilder();
		
		java.sql.Date t = getStartdate();
		if (t != null)
		{
			stb.append(DTOBase.dateAsString(t, DTOBase.ISO8601DateFormat));
		}
		
		if (getStarttime() != null)
			stb.append(' ').append(getStarttime());
		
		return (stb.length() > 0) ? stb.toString() : null;
	}
	
	public String getEnd()
	{
		StringBuilder stb = new StringBuilder();
		
		java.sql.Date t = getEnddate();
		if (t != null)
		{
			stb.append(DTOBase.dateAsString(t, DTOBase.ISO8601DateFormat));			
		}
		
		if (getEndtime() != null)
			stb.append(' ').append(getEndtime());
		
		return (stb.length() > 0) ? stb.toString() : null;	
	}
	
	private String source;
	
	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}
	
	public boolean getAllDay()
	{
		return DTOBase.getBTrueFalseAsBoolean(alldayflag);
	}
}
