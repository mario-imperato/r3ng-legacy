package org.r3.ws.system.eventlog;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.page.PagePersistence;
import org.r3.db.system.eventlog.EventLogDTO;
import org.r3.db.system.eventlog.EventLogDTO.UseCase;
import org.r3.db.system.eventlog.EventLogDTO.UseCaseAmbit;
import org.r3.db.system.eventlog.EventLogFilter;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.ServicePatternException;
import org.r3.system.WebAuthInfo;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GET_EventLogStats  extends ServicePattern
{			
	protected static Logger logger = LoggerFactory.getLogger(GET_EventLogStats.class);
	
	EventLogQueryActionForm actionForm;
	
	public GET_EventLogStats(ServletContext ctx,  ServiceEnvironment serviceEnvironment, EventLogQueryActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}
	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		WebAuthInfo authInfo = senv.getAuthInfo();		
		String userSessionId = authInfo.getUserSessionId();

		String userId = null;
		if (!authInfo.isUserNotIdentified())
		{
			UserProfileViewDTO up = authInfo.getUserProfile();
			userId = up.getUserid();
		}
		
		EventLogPersistence p = EventLogPersistence.createPersistenceObject(pcfg, aSession);
		EventLogFilter filter = actionForm.getStatsSearchCondition(senv.getRequestSiteId());
		List<EventLogDTO> resultList = p.select(filter, pcfg.getPersistenceConfigInfo());
		return resultList;
	}
	
}
