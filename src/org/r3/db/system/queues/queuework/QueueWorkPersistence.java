//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto  2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuework;

import java.util.List;

import org.r3.db.CountByDTO;
import org.r3.db.PersistenceConfigInfo;
import org.r3.db.system.queues.model.QueueMessage.MessageStatus;
import org.r3.db.system.queues.queuework.QueueWorkDTO.WorkQueue;


public class QueueWorkPersistence extends QueueWorkPersistenceBase
{
  public static QueueWorkPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  QueueWorkPersistence p = new QueueWorkPersistence();
	    p.setMapper(aSession.getMapper(QueueWorkMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

	public List<CountByDTO> countByRefEntityId(QueueWorkFilter filterCondition,
					PersistenceConfigInfo pcfg)
	{
		List<CountByDTO> listOfDTOs = this.mapper.countByRefEntityId(filterCondition, pcfg);
		return listOfDTOs;
	}

	public List<CountByDTO> countByRefAmbitId(QueueWorkFilter filterCondition,
					PersistenceConfigInfo pcfg)
	{
		List<CountByDTO> listOfDTOs = this.mapper.countByRefAmbitId(filterCondition, pcfg);
		return listOfDTOs;
	}

	public QueueWorkDTO selectByQueueidRefambitidRefentityid(
					WorkQueue workQueueId, String refAmbitId, String refEntityId, PersistenceConfigInfo pcfg)
	{
		QueueWorkFilter filter = new QueueWorkFilter();
		filter.or().andQueueidEqualTo(workQueueId.toString()).andRefambitidEqualTo(refAmbitId).andRefentityidEqualTo(refEntityId).andMessagestatusEqualTo(MessageStatus.qmsg_active.toString());
		return selectFirst(filter, pcfg);
	}
	
	public int deleteByQueueidRefambitidRefentityid(
					WorkQueue workQueueId, String refAmbitId, String refEntityId, PersistenceConfigInfo pcfg)
	{
		QueueWorkFilter filter = new QueueWorkFilter();
		filter.or().andQueueidEqualTo(workQueueId.toString()).andRefambitidEqualTo(refAmbitId).andRefentityidEqualTo(refEntityId).andMessagestatusEqualTo(MessageStatus.qmsg_active.toString());
		return delete(filter, pcfg);
	}
	
	public int consumeByQueueidRefambitid(
					WorkQueue workQueueId, String refAmbitId, PersistenceConfigInfo pcfg)
	{
		return consumeByQueueidRefambitidRefEntityid(workQueueId, refAmbitId, null, pcfg);
	}

	public int consumeByQueueidRefambitidRefEntityid(
					WorkQueue workQueueId, String refAmbitId, String refEntityId, PersistenceConfigInfo pcfg)
	{
		QueueWorkFilter filter = new QueueWorkFilter();
		QueueWorkCriteria c = filter.or().andQueueidEqualTo(workQueueId.toString()).andRefambitidEqualTo(refAmbitId).andMessagestatusEqualTo(MessageStatus.qmsg_active.toString());
		if (refEntityId != null)
			c.andRefentityidEqualTo(refEntityId);
		
		QueueWorkDTO dto = new QueueWorkDTO();
		dto.setMessagestatus(MessageStatus.qmsg_consumed.toString());
		
		return update(dto, filter, pcfg);
	}

	public int markAsConsumedByQueueidRefambitidMinqueueworkidMaxqueueworkid(String aQueueId, String aRefAmbitId, String min, String max,
					PersistenceConfigInfo persistenceConfigInfo)
	{
		QueueWorkFilter filter = new QueueWorkFilter();
        filter.or()
              .andQueueidEqualTo(aQueueId)
              .andRefambitidEqualTo(aRefAmbitId)
              .andMessagestatusEqualTo(MessageStatus.qmsg_active.toString())
              .andQueueworkidGreaterThanOrEqualTo(min)
              .andQueueworkidLessThanOrEqualTo(max);
        
		QueueWorkDTO dto = new QueueWorkDTO();
		dto.setMessagestatus(MessageStatus.qmsg_consumed.toString());
		
		return update(dto, filter, persistenceConfigInfo);
		
	}

}
  
