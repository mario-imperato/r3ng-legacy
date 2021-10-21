//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.eventlog;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.r3.db.PersistenceConfigInfo;
import org.r3.db.system.eventlog.EventLogDTO.UseCase;
import org.r3.db.system.eventlog.EventLogDTO.UseCaseAmbit;

public class EventLogPersistence extends EventLogPersistenceBase
{
	public static EventLogPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		EventLogPersistence p = new EventLogPersistence();
		p.setMapper(aSession.getMapper(EventLogMapper.class));
		return p;
	}

	  
	public int logEvent(PersistenceConfigInfo cfgInfo, String site, UseCaseAmbit aUseCaseAmbit, UseCase aUseCase, String refId, String aUserId, String aUserSessionId)
	{
		int rc = 0;

		EventLogUserAction dto = new EventLogUserAction(site, aUseCaseAmbit, aUseCase, refId, aUserId, aUserSessionId);
		rc = insert(dto, cfgInfo);
		return rc;
	}
	
	public int logEventSEVCommit(PersistenceConfigInfo cfgInfo, String site, String applicationId, String aUserId)
	{
		int rc = 0;

		EventLogSEVCommit dto = new EventLogSEVCommit(site, applicationId, aUserId);
		rc = insert(dto, cfgInfo);
		return rc;
	}

	public int logEventBoatInfo(PersistenceConfigInfo cfgInfo, String site, String applicationId, String aUserId)
	{
		int rc = 0;

		EventLogBoatInfo dto = new EventLogBoatInfo(site, applicationId, aUserId);
		rc = insert(dto, cfgInfo);
		return rc;
	}

	public int logEventClassInfo(PersistenceConfigInfo cfgInfo, String site, String applicationId, String aUserId)
	{
		int rc = 0;

		EventLogClassInfo dto = new EventLogClassInfo(site, applicationId, aUserId);
		rc = insert(dto, cfgInfo);
		return rc;
	}

	public int logEventOwnerInfo(PersistenceConfigInfo cfgInfo, String site, String applicationId, String aUserId)
	{
		int rc = 0;

		EventLogOwnerInfo dto = new EventLogOwnerInfo(site, applicationId, aUserId);
		rc = insert(dto, cfgInfo);
		return rc;
	}

	public int logEventAuthorInfo(PersistenceConfigInfo cfgInfo, String site, String applicationId, String aUserId)
	{
		int rc = 0;

		EventLogAuthorInfo dto = new EventLogAuthorInfo(site, applicationId, aUserId);
		rc = insert(dto, cfgInfo);
		return rc;
	}

	public int logEventAddDocInfo(PersistenceConfigInfo cfgInfo, String site, String applicationId, String documentid, String aUserid)
	{
		int rc = 0;

		EventLogAddDocInfo dto = new EventLogAddDocInfo(site, applicationId, documentid, aUserid);
		rc = insert(dto, cfgInfo);
		return rc;
	}

	public int logEventDelDocInfo(PersistenceConfigInfo cfgInfo, String site, String applicationId, String documentid, String aUserid)
	{
		int rc = 0;

		EventLogDelDocInfo dto = new EventLogDelDocInfo(site, applicationId, documentid, aUserid);
		rc = insert(dto, cfgInfo);
		return rc;
	}

	public int logEventCrewInfo(PersistenceConfigInfo cfgInfo, String site, String applicationId, String crewMemberId, String cardNumber, String aUserid)
	{
		int rc = 0;

		EventLogCrewInfo dto = new EventLogCrewInfo(site, applicationId, crewMemberId, cardNumber, aUserid);
		rc = insert(dto, cfgInfo);
		return rc;
	}

}
