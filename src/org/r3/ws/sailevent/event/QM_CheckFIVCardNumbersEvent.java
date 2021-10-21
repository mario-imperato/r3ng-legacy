package org.r3.ws.sailevent.event;

import org.r3.ws.system.event.QM_R3Event;


public class QM_CheckFIVCardNumbersEvent extends QM_R3Event
{	
	private String yachtClubFivCode;
	private String yachtClubFivPwd;

	public QM_CheckFIVCardNumbersEvent(String aSite, String aYachtClubFivCode, String aYachtClubFivPwd)
	{
		setMessageProcessor(QPM_CheckFIVCardNumbersEvent.class);
		setSiteContext(aSite);
		
		setYachtClubFivCode(aYachtClubFivCode);
		setYachtClubFivPwd(aYachtClubFivPwd);		
	}

	
	public QM_EventCode getEvent()
	{
		return QM_EventCode.checkfivcardnumbers;
	}

	public String getYachtClubFivCode()
	{
		return yachtClubFivCode;
	}

	public void setYachtClubFivCode(String yachtClubFivCode)
	{
		this.yachtClubFivCode = yachtClubFivCode;
	}

	public String getYachtClubFivPwd()
	{
		return yachtClubFivPwd;
	}

	public void setYachtClubFivPwd(String yachtClubFivPwd)
	{
		this.yachtClubFivPwd = yachtClubFivPwd;
	}
}
