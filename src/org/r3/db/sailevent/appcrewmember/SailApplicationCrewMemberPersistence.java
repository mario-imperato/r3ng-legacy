//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.appcrewmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceConfigInfo;
import org.r3.db.PersistenceContext;

public class SailApplicationCrewMemberPersistence extends SailApplicationCrewMemberPersistenceBase
{
	public static SailApplicationCrewMemberPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		SailApplicationCrewMemberPersistence p = new SailApplicationCrewMemberPersistence();
		p.setMapper(aSession.getMapper(SailApplicationCrewMemberMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public List<SailApplicationCrewMemberDTO> selectCrewMember4FIVCardNumberCheckingByEventid(String eventId, int limitFetch, PersistenceConfigInfo persistenceConfigInfo)
	{
		SailApplicationCrewMemberFilter filter = new SailApplicationCrewMemberFilter();
		filter.or().andEventidEqualTo(eventId).andCheckcardnumberEqualTo("btrue").andRecstatusEqualTo(RecordStatus.sys_recact.toString());
		
		if (limitFetch > 0)
		    filter.setLimitFetch(limitFetch);
		return select(filter, persistenceConfigInfo);
	}
	
	public List<SailApplicationCrewMemberDTO> selectByEventidApplicationid(String eventId, String applicationId, PersistenceConfigInfo persistenceConfigInfo)
	{
		SailApplicationCrewMemberFilter filter = new SailApplicationCrewMemberFilter();
		filter.or().andApplicationidEqualTo(applicationId).andEventidEqualTo(eventId);
		return select(filter, persistenceConfigInfo);
	}
	
	public SailApplicationCrewMemberDTO selectByEventidApplicationidCardnumberRecstatus(String eventId, String applicationId,
					String crewcardnumber, RecordStatus recStatus, PersistenceConfigInfo persistenceConfigInfo)
	{
		SailApplicationCrewMemberFilter filter = new SailApplicationCrewMemberFilter();
		filter.or().andApplicationidEqualTo(applicationId).andEventidEqualTo(eventId).andCardnumberEqualTo(crewcardnumber).andRecstatusEqualTo(recStatus.toString());
		return selectFirst(filter, persistenceConfigInfo);
	}

	public void logicalDeleteByCrewmemberid(String crewMemberId, PersistenceContext pcfg)
	{
		SailApplicationCrewMemberFilter filter = new SailApplicationCrewMemberFilter();
		filter.or().andCrewmemberidEqualTo(crewMemberId);
		
		SailApplicationCrewMemberDTO updateDTO = new SailApplicationCrewMemberDTO();
		updateDTO.setRecstatus(RecordStatus.sys_recdeleted.toString());
		updateDTO.setDeletetimestamp(DTOBase.currentTimestamp());
		update(updateDTO, filter, pcfg.getPersistenceConfigInfo());
	}

	public int crewSize(String eventid, String applicationid, 
					PersistenceConfigInfo persistenceConfigInfo, SqlSession aSession)
	{
		SailApplicationCrewMemberFilter filter = new SailApplicationCrewMemberFilter();
		filter.or().andEventidEqualTo(eventid).andApplicationidEqualTo(applicationid).andRecstatusEqualTo(RecordStatus.sys_recact.toString());
		
		int numberOfRows = count(filter, persistenceConfigInfo);
		return numberOfRows;
	}

	public void markFleetForFIVCardNumberVerification(String eventid, PersistenceConfigInfo persistenceConfigInfo)
	{
		SailApplicationCrewMemberFilter filter = new SailApplicationCrewMemberFilter();
		filter.or().andEventidEqualTo(eventid).andRecstatusEqualTo(RecordStatus.sys_recact.toString());
		SailApplicationCrewMemberDTO crewDTO = new SailApplicationCrewMemberDTO();
		crewDTO.setCheckcardnumber("btrue");
		this.update(crewDTO, filter, persistenceConfigInfo);
	}    

	public void markForFIVCardNumberVerification(String eventid, String applicationid, PersistenceConfigInfo persistenceConfigInfo)
	{				
		SailApplicationCrewMemberFilter filter = new SailApplicationCrewMemberFilter();
		filter.or().andEventidEqualTo(eventid).andApplicationidEqualTo(applicationid).andRecstatusEqualTo(RecordStatus.sys_recact.toString());
		SailApplicationCrewMemberDTO crewDTO = new SailApplicationCrewMemberDTO();
		crewDTO.setCheckcardnumber("btrue");
		this.update(crewDTO, filter, persistenceConfigInfo);			
	}    

	public void markForFIVCardNumberVerification(String eventid, String[] applicationid, PersistenceConfigInfo persistenceConfigInfo)
	{				
		for(String appId : applicationid)
		{
			markForFIVCardNumberVerification(eventid, appId, persistenceConfigInfo);
		}						
	}    
	
	
}
