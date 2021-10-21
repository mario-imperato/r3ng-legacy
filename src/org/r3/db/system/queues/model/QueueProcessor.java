package org.r3.db.system.queues.model;


import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;

public class QueueProcessor
{
	private HashMap<String, QueueMessageProcessor> messageprocessorCache = null; 

	private String queueName = null;
	private Queue queue;

	public void setQueueName(String aQueueName)
	{
		queueName = aQueueName;
	}

	public String getQueueName()
	{
		return queueName;
	}

	private Queue getQueue(PersistenceContext pcfg, SqlSession aSession) throws QueueException
	{
		if (queue == null)
			queue = getQueue(pcfg, aSession, getQueueName());

		return queue;
	}

	private Queue getQueue(PersistenceContext pcfg, SqlSession aSession, String aQueueName) throws QueueException
	{
		Queue aQueue = null;
		if (aQueueName != null)
		{
			aQueue = Queue.newInstance(pcfg, aSession, aQueueName);
		}

		return aQueue;
	}

	/**
     *  
     */
	public QueueProcessor()
	{
		super();		
		messageprocessorCache = new HashMap<String, QueueMessageProcessor>();
	}

	// protected QueueMessage getMessage(PersistenceContext pcfg, SqlSession
	// aSession) throws QueueException
	// {
	// return getFrom(pcfg, aSession, getQueueName());
	// }

	private void sendTo(Queue aQueue, QueueMessage aMessage) throws QueueException
	{
		if (aMessage != null)
		{
			try
			{
				if (aQueue != null)
					aQueue.put(aMessage);
				else
				{
					// Task.taskLogger.error("Unconfigured queue");
				}

			}
			catch (QueueException exc)
			{
				exc.printStackTrace();
				throw exc;
			}
			finally
			{
			}
		}
	}

	// private QueueMessage getFrom(PersistenceContext pcfg, SqlSession
	// aSession, String aQueueName) throws QueueException
	// {
	// QueueMessage aQueueMessage = null;
	//
	// if (aQueueName == null)
	// return null;
	//
	// try
	// {
	//
	// Queue aQueue = getQueue(pcfg, aSession, aQueueName);
	// if (aQueue != null)
	// aQueueMessage = aQueue.get(pcfg, aSession);
	//
	// }
	// catch (QueueException exc)
	// {
	// exc.printStackTrace();
	// throw exc;
	// }
	// finally
	// {
	// }
	//
	// return aQueueMessage;
	// }

	public boolean processMessage(QueueProcessorContext processContext, QueueMessage queueMessage) throws QueueMessageProcessorException
	{
		QueueMessageProcessor mproc = null;
        try
        {
		String messageProcessorClassName = queueMessage.getMessageProcessor();
		mproc = messageprocessorCache.get(messageProcessorClassName);
		if (mproc == null)
		{
			mproc = queueMessage.getMessageProcessorInstance();
			mproc.initialize(queueMessage.getSiteContext(), processContext);
			
			if (mproc.isCacheable())
				messageprocessorCache.put(messageProcessorClassName, mproc);
		}
			
	    boolean b = mproc.process(processContext, queueMessage);
	    return b;
		}
		finally
		{
			if (mproc != null && !mproc.isCacheable())
			       mproc.release();
		}
       		
	}

	private void releaseQuemessageProcessors()
	{
		for(String mprocName : messageprocessorCache.keySet())
		{
			QueueMessageProcessor mproc = messageprocessorCache.get(mprocName);
			mproc.release();
		}
	}
	
	public void process(QueueProcessorContext processContext)
	{
		QueueMessage queueMessage = null;

		SqlSession queueSession = processContext.getQueueSession();
		try
		{
			Queue q = getQueue(processContext.getPcfg(), queueSession);
			try
			{
				queueMessage = q.get();
				queueSession.commit();
				while (queueMessage != null)
				{
					if (!processMessage(processContext, queueMessage))
					{
						queueMessage.incNumberOfRetries();
						if (queueMessage.tooManyRetries())
						{
							sendTo(q.getDeadQueue(), queueMessage);
						}
						else
						{
							sendTo(q.getRetryQueue(), queueMessage);
						}
						
						queueSession.commit();
					}
					
					queueMessage = q.get();
					queueSession.commit();
				}
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
				if (queueMessage != null)
					try
					{
						sendTo(q.getDeadQueue(), queueMessage);
						queueSession.commit();
					}
					catch (QueueException e)
					{
						e.printStackTrace();
					}
			}

		}
		catch (QueueException qe)
		{
			qe.printStackTrace();
		}
		finally
		{
			releaseQuemessageProcessors();
			processContext.close();
		}
	}

}
