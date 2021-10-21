package org.r3.ws.system.agenda;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.agenda.agendaentry.AgendaEntryPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEAgendaEntry extends ServicePattern
{    
    private String site;
    private String agendaId;
    private String calendarId;
	
	public DELETEAgendaEntry(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String anAgendaId, String aCalendarId)
	{
		super(ctx, serviceEnvironment);
		
		site = aSite;
		agendaId = anAgendaId;
		calendarId = aCalendarId;
		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		AgendaEntryPersistence p = AgendaEntryPersistence.createPersistenceObject(pcfg, aSession);
		p.deleteByAgendaentryid(calendarId, pcfg.getPersistenceConfigInfo());
			    
		return RestServiceDTO.SuccessDTO;
	}
}
