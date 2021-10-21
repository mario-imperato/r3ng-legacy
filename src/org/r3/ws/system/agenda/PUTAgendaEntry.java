package org.r3.ws.system.agenda;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.agenda.agendaentry.AgendaEntryDTO;
import org.r3.db.agenda.agendaentry.AgendaEntryPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.ws.system.agenda.WsAgenda.CalendarUpdateAction;


public class PUTAgendaEntry extends ServicePattern
{
    private AgendaActionForm actionForm;
    private String calendarId;
    private String agendaId;
    private CalendarUpdateAction updateAction;
    
	public PUTAgendaEntry(ServletContext ctx, ServiceEnvironment serviceEnvironment, String anAgendaId, String aCalendarId, AgendaActionForm anActionForm, CalendarUpdateAction anUpdateAction)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		updateAction = anUpdateAction;
		calendarId = aCalendarId;
		agendaId = anAgendaId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		AgendaEntryPersistence p = AgendaEntryPersistence.createPersistenceObject(pcfg, aSession);		
				
		AgendaEntryDTO dto1 = actionForm.getDTO4Update(senv.getRequestSiteId(), agendaId, calendarId, updateAction);		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());	    
	    	
	    LUTManager.getLUTManager().invalidateLUT(LUTName.r3ea_calendar);
		return dto1;
	}
}
