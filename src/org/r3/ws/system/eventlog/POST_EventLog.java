package org.r3.ws.system.eventlog;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.page.PagePersistence;
import org.r3.db.system.eventlog.EventLogDTO.UseCase;
import org.r3.db.system.eventlog.EventLogDTO.UseCaseAmbit;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.ServicePatternException;
import org.r3.system.WebAuthInfo;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class POST_EventLog  extends ServicePattern
{			
	protected static Logger logger = LoggerFactory.getLogger(POST_EventLog.class);
	
	private UseCaseAmbit ambit;
	private UseCase useCase;
	private String refEntityId;
	
	public POST_EventLog(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anAmbit, String aUseCase, String aRefEntityId)
	{
		super(ctx, serviceEnvironment);
		ambit = UseCaseAmbit.getUseCaseAmbit4(anAmbit, UseCaseAmbit.unknown);
		useCase = UseCase.getUseCase4(aUseCase, UseCase.unknown);
		refEntityId = aRefEntityId;
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
		p.logEvent(pcfg.getPersistenceConfigInfo(), this.senv.getRequestSiteId(), ambit, useCase, refEntityId, userId, userSessionId);
		return null;
	}
	
}
