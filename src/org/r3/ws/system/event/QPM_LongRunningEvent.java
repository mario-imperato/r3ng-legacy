package org.r3.ws.system.event;

import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifier.ClassifierDTO;
import org.r3.db.system.classifier.ClassifierPersistence;
import org.r3.db.system.queues.model.QueueMessage;
import org.r3.db.system.queues.model.QueueMessageProcessorException;
import org.r3.db.system.queues.model.QueueProcessorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QPM_LongRunningEvent extends QPM_QueueEventProcessor
{			
	protected static Logger logger = LoggerFactory.getLogger(QPM_LongRunningEvent.class);
	
	@Override
	public boolean process(QueueProcessorContext processContext, QueueMessage aQueueMessage) throws QueueMessageProcessorException
	{
		SqlSession session = processContext.getProcessSession();
		PersistenceContext pcfg = processContext.getPcfg();
		
		try
		{
			Random r = new Random(new java.util.Date().getTime());
			boolean longSleep = r.nextBoolean();
			int sleepTime = (longSleep) ? 5000 : 500;
			
			logger.info(String.format("Sleeping: %s - %d", Thread.currentThread().getName(), sleepTime));
			System.out.printf("Sleeping: %s - %d for %s\n", Thread.currentThread().getName(), sleepTime, aQueueMessage.getMessageid());
			
			ClassifierPersistence cp = ClassifierPersistence.createPersistenceObject(pcfg, session);
			ClassifierDTO dto = new ClassifierDTO();
			dto.setSite("default");
			dto.setClsid(aQueueMessage.getMessageid());
			dto.setClstypecode("linear");
			
			cp.insert(dto, pcfg.getPersistenceConfigInfo());
			
			Thread.sleep(sleepTime);	
			
			session.commit();
			
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			session.rollback();
		}
		
		return true;
	}
	
}
