//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueue;

public class SMSQueueDTO extends SMSQueueDTOBase
{
    public SMSQueueDTO()
    {
        super();
    }

    public SMSQueueDTO(SMSQueueDTO another)
    {
        super(another);
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public boolean IsNotificaRicezioneMode()
	{
		return isOptionEnabled("smsopt_status");
	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public boolean isFlashMode()
	{
		return isOptionEnabled("smsopt_flash");
	}
    
    public boolean isOptionEnabled(String anOptionCode)
    {
    	String s = getSmsopts();
    	if (s != null && s.indexOf(anOptionCode) >= 0)
    		return true;
    	
    	return false;
    }
}
