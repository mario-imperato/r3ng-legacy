package org.r3.ws.system.agenda.lut;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.agenda.agendaentry.AgendaEntryFilter;
import org.r3.db.agenda.agendaentry.AgendaEntryPersistence;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETAgendaEntryLUTItems extends LUTConditionalGetPattern
{
	private String agendaId;
	
	public GETAgendaEntryLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anAgendaId)
	{
		super(ctx, serviceEnvironment, LUTName.r3ea_calendar.toString());
		agendaId = anAgendaId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		AgendaEntryPersistence p = AgendaEntryPersistence.createPersistenceObject(pcfg, aSession);

		AgendaEntryFilter filter = new AgendaEntryFilter();
		filter.or().andAgendaidEqualTo(agendaId);
		filter.setOrderByClause(" startdate ");
		
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}
