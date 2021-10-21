package org.r3.db.system.queues.model;

public abstract class QueueMessageProcessor
{
    public abstract boolean process(QueueProcessorContext processContext, QueueMessage aQueueMessage) throws QueueMessageProcessorException;               
	public abstract void initialize(String aSiteContext, QueueProcessorContext processContext);	
	public abstract void release();

	public boolean isCacheable()
	{
		return false;
	}	
}
