package org.r3.ws.system.agenda;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.agenda.agendaentry.AgendaEntryDTO;
import org.r3.db.agenda.agendaentry.AgendaEntryDataTableAdapter;
import org.r3.db.agenda.agendaentry.AgendaEntryFilter;
import org.r3.db.agenda.agendaentry.AgendaEntryPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.ws.system.agenda.WsAgenda.EventFormat;

public class GETAgendaEntries extends ServicePattern
{
    private AgendaQueryActionForm queryForm;
    private EventFormat outputFormat;
    private String agendaId;
    
	public GETAgendaEntries(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anAgendaId, AgendaQueryActionForm aQueryForm, EventFormat anOutputFormat)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		outputFormat = anOutputFormat;
		agendaId = anAgendaId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		AgendaEntryPersistence p = AgendaEntryPersistence.createPersistenceObject(pcfg, aSession);				
		AgendaEntryFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), agendaId);
		
		if (outputFormat == EventFormat.datatable)
		{
			AgendaEntryDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());				
		   return dt;
		}
		
		if (outputFormat == EventFormat.eventarray)
		{
   		   List<AgendaEntryDTO> listOf = p.select(filter, pcfg.getPersistenceConfigInfo());				
		   return listOf;
		}
		
		return null;
	}

}
