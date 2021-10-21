package org.r3.ws.system.event;

public class QM_SendNewMailMessageEvent extends QM_R3Event
{	
	public QM_SendNewMailMessageEvent(String aSite, String aSmsId)
	{
		setMessageProcessor(QPM_SendNewMailMessageEvent.class);
		setSiteContext(aSite);		
        setRefentita(aSmsId);       
	}
	
	
	public QM_EventCode getEvent()
	{
		return QM_EventCode.newmailmessage;
	}

}
