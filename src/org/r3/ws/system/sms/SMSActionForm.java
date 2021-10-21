package org.r3.ws.system.sms;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.system.smsqueue.SMSQueueDTO;

public class SMSActionForm
{

	@FormParam("smslogin")
    private String smslogin;

    public String getSmslogin()
    {    	
    	return DTOBase.nullOnEmpty(smslogin);
    }

	@FormParam("smspasswd")
    private String smspasswd;

    public String getSmspasswd()
    {    	
    	return DTOBase.nullOnEmpty(smspasswd);
    }
    
	@FormParam("smssender")
    private String smssender;

    public String getSmssender()
    {    	
    	return DTOBase.nullOnEmpty(smssender);
    }

	@FormParam("smsopts")
    private String[] smsopts;

    public String[] getSmsopts()
    {    	
    	return smsopts;
    }

    public String getSmsoptsAsCSV()
    {
        return DTOBase.stringArray2CSV(smsopts);	
    }
    
	@FormParam("smstext")
    private String smstext;

    public String getSmstext()
    {    	
    	return DTOBase.nullOnEmpty(smstext);
    }
        
    @FormParam("actorgroup")
    private String[] actorgroup;

    public String[] getActorgroup()
    {    	
    	return DTOBase.nullOnEmpty(actorgroup);
    }
    
	public SMSQueueDTO getDTO4Insert(String aSite)
	{
		SMSQueueDTO dto = new SMSQueueDTO();
        dto.setSite(aSite);
        dto.setSmssender(getSmssender());
        dto.setSmsopts(getSmsoptsAsCSV());
        dto.setSmstext(getSmstext());
        dto.setNumberofretries(0);
        dto.setNumberoftargets(0);
        dto.setNumberofsentitems(0);
        
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		
		return  dto;
	}


	
}
