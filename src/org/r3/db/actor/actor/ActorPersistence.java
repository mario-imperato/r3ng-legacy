//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.actor.actor;

import java.util.List;

import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceConfigInfo;

public class ActorPersistence extends ActorPersistenceBase
{
	public static ActorPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		ActorPersistence p = new ActorPersistence();
		p.setMapper(aSession.getMapper(ActorMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public int markActorsInGroupAsDeleted(String requestSiteId, String aGroup, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andActorInGroup(requestSiteId, aGroup).andRecstatusNotEqualTo(RecordStatus.sys_recblock.toString());

		ActorDTO dto = new ActorDTO();
		dto.setRecstatus(RecordStatus.sys_recdeleted.toString());
		return this.mapper.update(dto, filter, pcfg);
	}
	
	public int insertActorsIntoSMS(String requestSiteId, String smsid, String[] listOfGroups, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andActorInGroup(requestSiteId, listOfGroups).andCellphoneIsNotNull().andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

		return this.mapper.insertActorsIntoSMS(requestSiteId, smsid, filter, pcfg);
	}

	public int insertActorsIntoMail(String requestSiteId, String messageId, String[] listOfGroups, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andActorInGroup(requestSiteId, listOfGroups).andEmailIsNotNull().andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

		return this.mapper.insertActorsIntoOutMailSpoolerRecipient(requestSiteId, messageId, filter, pcfg);
	}
	
	public int countActors4InsertIntoSMS(String requestSiteId, String[] listOfGroups, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andActorInGroup(requestSiteId, listOfGroups).andCellphoneIsNotNull().andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

		return this.mapper.count(filter, pcfg);
	}
	
//	public int countActorsByEmail(String requestSiteId, String email, PersistenceConfigInfo pcfg)
//	{
//		ActorFilter filter = new ActorFilter();
//		filter.or().andEventidEqualTo(requestSiteId).andEmailEqualTo(email);
//
//		return this.mapper.count(filter, pcfg);		
//	}

//	public List<ActorDTO> selectActorsByEmail(String requestSiteId, String email, PersistenceConfigInfo pcfg)
//	{
//		ActorFilter filter = new ActorFilter();
//		filter.or().andEventidEqualTo(requestSiteId).andEmailEqualTo(email);
//
//		// Metto un limite a cinque doppioni...
//		RowBounds rb = new RowBounds(RowBounds.NO_ROW_OFFSET, 30);		
//		return this.mapper.select(filter, pcfg, rb);		
//	}
	
	public int countActorsByEmailGroupid(String requestSiteId, String email, String aGroupid, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andEmailEqualTo(email).andActorInGroup(requestSiteId, aGroupid).andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

		return this.mapper.count(filter, pcfg);		
	}

	public List<ActorDTO> selectByEventidEmail(String requestSiteId, String email, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andEmailEqualTo(email).andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

		return select(filter, pcfg);
	}

	public ActorDTO selectFirstByEventidEmail(String requestSiteId, String email, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andEmailEqualTo(email).andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

		return selectFirst(filter, pcfg);
	}
	
	public int countByEventidEmail(String requestSiteId, String email, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andEmailEqualTo(email).andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

		return count(filter, pcfg);
	}

	// Conto il numero degli attori che hanno mail uguale ma con userid diversa.
	public int countByEventidEmailNotActorid(String requestSiteId, String email, String anActorId, PersistenceConfigInfo pcfg)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andActoridNotEqualTo(anActorId).andEmailEqualTo(email).andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

		return count(filter, pcfg);
	}	
	
	public int markActorAsDeleted(String requestSiteId, String actorId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andActoridEqualTo(actorId).andRecstatusNotEqualTo(RecordStatus.sys_recblock.toString());

		ActorDTO dto = new ActorDTO();
		dto.setRecstatus(RecordStatus.sys_recdeleted.toString());
		
		return update(dto, filter, persistenceConfigInfo);
	}

	public ActorDTO selectByEventidUserid(String requestSiteId, String userid, PersistenceConfigInfo persistenceConfigInfo) 
	{
		ActorFilter filter = new ActorFilter();
		filter.or().andEventidEqualTo(requestSiteId).andUseridEqualTo(userid);

		return selectFirst(filter, persistenceConfigInfo);
	}
}
