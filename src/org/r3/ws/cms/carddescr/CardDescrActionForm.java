package org.r3.ws.cms.carddescr;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.cms.carddescr.CardDescrDTO;

public class CardDescrActionForm
{	
	@FormParam("title")
    private String title;

    public String getTitle()
    {    	
    	return DTOBase.nullOnEmpty(title);
    }

	@FormParam("summary")
    private String summary;

    public String getSummary()
    {    	
    	return DTOBase.nullOnEmpty(summary);
    }

	@FormParam("textbody")
    private String textbody;

    public String getTextbody()
    {    	
    	return DTOBase.nullOnEmpty(textbody);
    }

	public CardDescrDTO getDTO4Insert(String aSite, String aCardId, String aCardLanguage)
	{
		CardDescrDTO dto = new CardDescrDTO();
		dto.setSite(aSite);
		dto.setCardid(aCardId);
		dto.setLanguagecode(aCardLanguage);
		
		dto.setTitle(getTitle());
		dto.setSummary(getSummary());
		dto.setTextbody(getTextbody());
		
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}

	public CardDescrDTO getDTO4Update(CardDescrDTO dto)
	{		
		dto.setTitle(getTitle());
		dto.setSummary(getSummary());
		dto.setTextbody(getTextbody());
		
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}

}
