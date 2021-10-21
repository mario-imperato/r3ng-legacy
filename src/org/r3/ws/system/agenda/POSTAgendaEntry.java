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

public class POSTAgendaEntry extends ServicePattern
{
    private AgendaActionForm actionForm;
    private String agendaId;
    
	public POSTAgendaEntry(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anAgendaId, AgendaActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		agendaId = anAgendaId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		AgendaEntryPersistence p = AgendaEntryPersistence.createPersistenceObject(pcfg, aSession);
		
		AgendaEntryDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId(), agendaId);		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    LUTManager.getLUTManager().invalidateLUT(LUTName.r3ea_calendar);	    	    	    
		return dto1;
	}

}
