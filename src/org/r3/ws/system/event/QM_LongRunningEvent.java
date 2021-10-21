package org.r3.ws.system.event;


public class QM_LongRunningEvent extends QM_R3Event
{	
	public QM_LongRunningEvent()
	{
		setMessageProcessor(QPM_LongRunningEvent.class);     
	}
	
	
	public QM_EventCode getEvent()
	{
		return QM_EventCode.longrunningevent;
	}

}
