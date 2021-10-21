//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto  2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.queues.queuemessage;

import java.util.List;

import org.r3.db.DTOBase;
import org.r3.db.PersistenceConfigInfo;
import org.r3.db.system.queues.model.QueueMessage;

public class QueueMessagePersistence extends QueueMessagePersistenceBase
{
	public static QueueMessagePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		QueueMessagePersistence p = new QueueMessagePersistence();
		p.setMapper(aSession.getMapper(QueueMessageMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public List<QueueMessageDTO> selectByQueueidMessagestatusPutaddress(java.lang.String queueid, String messageStatus, String address,
					PersistenceConfigInfo pcfg)
	{
		QueueMessageFilter f = new QueueMessageFilter();
		f.or().andQueueidEqualTo(queueid).andMessagestatusEqualTo(messageStatus);
		f.setLimitFetch(1);

		List<QueueMessageDTO> dto = this.select(f, pcfg);
		return dto;
	}

	public int markAsFailedByMessageid(String aMessageId, PersistenceConfigInfo pcfg)
	{
		QueueMessageFilter f = new QueueMessageFilter();
		f.or().andQueuemessageidEqualTo(aMessageId).andMessagestatusEqualTo(QueueMessage.MessageStatus.qmsg_active.toString());
		;

		QueueMessageDTO updatedDTO = new QueueMessageDTO();
		updatedDTO.setMessagestatus(QueueMessage.MessageStatus.qmsg_failed.toString());
		updatedDTO.setGetdate(DTOBase.currentTimestamp());
		int impactedRows = update(updatedDTO, f, pcfg);

		return impactedRows;
	}

	public int markAsConsumedByMessageid(String aMessageId, PersistenceConfigInfo pcfg)
	{
		QueueMessageFilter f = new QueueMessageFilter();
		f.or().andQueuemessageidEqualTo(aMessageId).andMessagestatusEqualTo(QueueMessage.MessageStatus.qmsg_active.toString());

		QueueMessageDTO updatedDTO = new QueueMessageDTO();
		updatedDTO.setMessagestatus(QueueMessage.MessageStatus.qmsg_consumed.toString());
		updatedDTO.setGetdate(DTOBase.currentTimestamp());
		int impactedRows = update(updatedDTO, f, pcfg);

		return impactedRows;
	}

}
