package org.r3.ws.bbs.topic;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.bbs.bbstopic.BBSTopicDTO;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardDTO.PageLinkType;
import org.r3.db.cms.card.CardDTO.ValidityRule;

public class BBSTopicActionForm
{
	@FormParam("topicid")
    private String topicid;

    public String getTopicid()
    {    	
    	return DTOBase.nullOnEmpty(topicid);
    }
    
	@FormParam("topictitle")
    private String topictitle;

    public String getTopictitle()
    {    	
    	return DTOBase.nullOnEmpty(topictitle);
    }

    public String getTopictitle(int maxLength)
    {    	
    	String s = DTOBase.nullOnEmpty(topictitle);
    	if (s != null && s.length() > maxLength)
    		s = s.substring(0, maxLength);
    	
    	return s;
    }

    @FormParam("moderatormode")
    private String moderatormode;
        	
	public String getModeratormode()
	{
		return DTOBase.nullOnEmpty(moderatormode);
	}
    	
	@FormParam("threadid")
    private String[] threadid;
	
	public String[] getThreadid()
	{
	    return threadid;	
	}
	
	public BBSTopicDTO getDTO4Insert(String aSite)
	{
		BBSTopicDTO dto = new BBSTopicDTO();
		dto.setSite(aSite);
		dto.setTopicid(getTopicid());
		dto.setTopictitle(getTopictitle());
		dto.setModeratormode(getModeratormode());
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}

	public BBSTopicDTO getDTO4Update(String aSite, String aTopicId)
	{
		BBSTopicDTO dto = new BBSTopicDTO();
		dto.setSite(aSite);
		dto.setTopicid(aTopicId);
		
		dto.setTopictitle(getTopictitle());
		dto.setModeratormode(getModeratormode());
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}

    public CardDTO getCMSCardDTO4Insert(String currentSite, String aTopicId)
	{
		CardDTO dto = new CardDTO();
		dto.setSite(currentSite);
		dto.setCardid(aTopicId);
		
		dto.setSystemtitle(getTopictitle(80));
	    dto.setValidityrule(ValidityRule.never.toString());
	    dto.setCategoryid("bbs");
	    
	    dto.setPagelinktype(PageLinkType.none.toString());
	    dto.setRefdate(DTOBase.currentDate());
	    
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}
}
