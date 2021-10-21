package org.r3.ws.system.event;

import org.r3.db.system.queues.model.QueueMessage;

public abstract class QM_R3Event extends QueueMessage
{
	public enum QM_EventCode 
	{
	    checkfivcardnumbers, sendsms, newmailmessage, longrunningevent
	}
	
	private String userid;
//	private String site;
    private String refentita;
    
	public QM_R3Event()
	{
		
	}

	public String getUserid()
	{
		return userid;
	}
	
	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	
//	public String getSite()
//	{
//		return site;
//	}
//
//	public void setSite(String site)
//	{
//		this.site = site;
//	}

	public String getRefentita()
	{
		return refentita;
	}

	public void setRefentita(String refentita)
	{
		this.refentita = refentita;
	}
	
    public abstract QM_EventCode getEvent();
}
