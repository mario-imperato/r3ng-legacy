package org.r3.ws.sailevent.event;

import org.r3.ws.system.event.QPM_QueueEventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class QPM_SEVQueueEventProcessor extends QPM_QueueEventProcessor
{
	protected static Logger sevQueueLogger = LoggerFactory.getLogger(QPM_SEVQueueEventProcessor.class);

}
