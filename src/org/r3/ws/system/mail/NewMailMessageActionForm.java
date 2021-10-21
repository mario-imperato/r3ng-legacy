package org.r3.ws.system.mail;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.system.outmailspooler.OutMailSpoolerDTO;

public class NewMailMessageActionForm
{
	@FormParam("msgfrom")
    private String msgfrom;

    public String getMsgfrom()
	{
		return DTOBase.nullOnEmpty(msgfrom);
	}
    
	@FormParam("msgto")
    private String msgto;

    public String getMsgto()
	{
		return DTOBase.nullOnEmpty(msgto);
	}

    public String[] getMsgtoRecipients()
    {
    	String[] marr = null;
        String m = getMsgto();
        
        if (m != null)
        {
        	marr = m.split(";");
        }
        
        return marr;        
    }
    
	@FormParam("msgcc")
    private String msgcc;

	public String getMsgcc()
	{
		return DTOBase.nullOnEmpty(msgcc);
	}

	@FormParam("msgbcc")
    private String msgbcc;

	public String getMsgbcc()
	{
		return DTOBase.nullOnEmpty(msgbcc);
	}

	@FormParam("msgtitle")
    private String msgtitle;

	public String getMsgtitle()
	{
		return DTOBase.nullOnEmpty(msgtitle);
	}

	@FormParam("mailopt")
    private String[] mailopt;

	public String[] getMailopt()
	{
		return mailopt;
	}

	public String getMailoptsAsCSV()
    {
        return DTOBase.stringArray2CSV(mailopt);	
    }
    
	public boolean isSend2All()
	{
	    if (mailopt != null && mailopt.length > 0)
	    {
	    	for(String s : mailopt)
	    	{
	    		if (s.equalsIgnoreCase("send2all"))
	    			return true;
	    	}
	    }
	    
	    return false;
	}
	
	@FormParam("msgmode")
    private String msgmode;

	public String getMsgmode()
	{
		return DTOBase.nullOnEmpty(msgmode);
	}
    
	@FormParam("msgtext")
    private String msgtext;

	public String getMsgtext()
	{
		return DTOBase.nullOnEmpty(msgtext);
	}
    
	public String parseMsgTextCIDReferences()
	{
	    CIDParser p = new CIDParser(getMsgtext());
	    return p.parse();
	}
	
	@FormParam("attachmentgroupid")
    private String attachmentgroupid;

	public String getAttachmentgroupid()
	{
		return DTOBase.nullOnEmpty(attachmentgroupid);
	}
	
    @FormParam("actorgroup")
    private String[] actorgroup;

    public String[] getActorgroup()
    {    	
    	return DTOBase.nullOnEmpty(actorgroup);
    }
    
	public OutMailSpoolerDTO getDTO4Insert(String aSite)
	{
		OutMailSpoolerDTO dto = new OutMailSpoolerDTO();
        dto.setSite(aSite);
        dto.setMsgfrom(getMsgfrom());
        dto.setMsgbcc(getMsgbcc());
        dto.setMsgcc(getMsgcc());
        dto.setMsgtitle(getMsgtitle());
        dto.setMsgmode(getMsgmode());
        dto.setMsgtext(parseMsgTextCIDReferences());
        
		dto.setRecstatus(RecordStatus.sys_recact.toString());		
		return  dto;
	}


	
}
