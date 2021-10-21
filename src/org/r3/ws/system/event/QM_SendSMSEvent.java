package org.r3.ws.system.event;



public class QM_SendSMSEvent extends QM_R3Event
{	
	private String smsLogin;
	private String smsPassword;

	public QM_SendSMSEvent(String aSite, String aSmsId, String aSmsLogin, String aSmsPassword)
	{
		setMessageProcessor(QPM_SendSMSEvent.class);
        setSiteContext(aSite);		
        setRefentita(aSmsId);
        
        setSmsLogin(aSmsLogin);
        setSmsPassword(aSmsPassword);
	}
	
	public String getSmsLogin()
	{
		return smsLogin;
	}

	public void setSmsLogin(String smsLogin)
	{
		this.smsLogin = smsLogin;
	}

	public String getSmsPassword()
	{
		return smsPassword;
	}

	public void setSmsPassword(String smsPassword)
	{
		this.smsPassword = smsPassword;
	}

	public QM_EventCode getEvent()
	{
		return QM_EventCode.sendsms;
	}

}
