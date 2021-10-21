package org.r3.ws.cms.card;

import java.text.DateFormat;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardDTO.PageLinkType;
import org.r3.db.cms.card.CardDTO.ValidityRule;
import org.r3.db.cms.carddescr.CardDescrDTO;
import org.r3.system.util.StringUtils;

public class CardActionForm
{
	
	@FormParam("cardid")
    private String cardid;

    public String getCardid()
    {    	
    	String s = DTOBase.nullOnEmpty(cardid);
    	if (s != null)
    		return s.toUpperCase();
    	
    	return null;
    }
    
	@FormParam("systemtitle")
    private String systemtitle;

    public String getSystemtitle()
    {    	
    	return DTOBase.nullOnEmpty(systemtitle);
    }

//	@FormParam("imagepropertyid")
//    private String imagepropertyid;
//
//    public String getImagepropertyid()
//    {    	
//    	return DTOBase.nullOnEmpty(imagepropertyid);
//    }
//
//	@FormParam("iconpropertyid")
//    private String iconpropertyid;
//
//    public String getIconpropertyid()
//    {    	
//    	return DTOBase.nullOnEmpty(iconpropertyid);
//    }
//
//	@FormParam("titlelinkid")
//    private String titlelinkid;
//
//    public String getTitlelinkid()
//    {    	
//    	return DTOBase.nullOnEmpty(titlelinkid);
//    }

	@FormParam("categoryid")
    private String categoryid;

    public String getCategoryid()
    {    	
    	return DTOBase.nullOnEmpty(categoryid);
    }

    
	@FormParam("validityrule")
    private String validityrule;

    public String getValidityrule()
    {    	
    	return DTOBase.nullOnEmpty(validityrule);
    }

    public ValidityRule getValidityruleAsEnum()
    {
        return CardDTO.getValidityruleAsEnum(getValidityrule(), ValidityRule.never);	
    }
    
	@FormParam("validfrom")
    private String validfrom;

    public String getValidfrom()
    {    	
    	return DTOBase.nullOnEmpty(validfrom);
    }
        
    public java.sql.Date getValidfrom(DateFormat df)
	{
		return DTOBase.stringAsDate(validfrom, df);
	}

	@FormParam("validto")
    private String validto;

    public String getValidto()
    {    	
    	return DTOBase.nullOnEmpty(validto);
    }

    public java.sql.Date getValidto(DateFormat df)
	{
		return DTOBase.stringAsDate(validto, df);
	}
        
	@FormParam("pubchannels")
    private String pubchannels;

    public String getPubchannels()
    {    	
    	String s = DTOBase.nullOnEmpty(pubchannels);
    	if (s != null)
    		return s.toUpperCase();
    	
    	return null;
    }
    
	@FormParam("cardgroup")
    private String[] cardgroup;

    public String[] getCardgroup()
    {    	
    	return DTOBase.nullOnEmpty(cardgroup);
    }

	@FormParam("pagelinktype")
    private String pagelinktype;

    public String getPagelinktype()
    {    	    	
    	return DTOBase.nullOnEmpty(pagelinktype);
    }

    public PageLinkType getPagelinktypeAsEnum()
    {
        return CardDTO.getPagelinktypeAsEnum(getPagelinktype(), PageLinkType.none);	
    }
    
	@FormParam("pagelink")
    private String pagelink;

    public String getPagelink()
    {    	
    	return DTOBase.nullOnEmpty(pagelink);
    }

	@FormParam("pageid")
    private String pageid;

    public String getPageid()
    {    	
    	String s = DTOBase.nullOnEmpty(pageid);
    	if (s != null)
    		return StringUtils.sliceTokens(s, '_', 99);   // Take the last token... or so....
    	
    	return s;
    }

	@FormParam("refdate")
    private String refdate;

    public String getRefdate()
    {    	
    	return DTOBase.nullOnEmpty(refdate);
    }

    public java.sql.Date getRefdate(DateFormat df)
	{
		return DTOBase.stringAsDate(refdate, df);
	}

    public CardDTO getDTO4Insert(String aSite)
	{
		CardDTO dto = new CardDTO();
		dto.setSite(aSite);
		dto.setCardid(getCardid());
		dto.setSystemtitle(getSystemtitle());
	    dto.setValidityrule(getValidityrule());
	    dto.setCategoryid(getCategoryid());
	    
	    if (getValidityruleAsEnum() == ValidityRule.date)
	    {
	    	dto.setValidfrom(getValidfrom(DTOBase.printDateFormat));
	    	dto.setValidto(getValidto(DTOBase.printDateFormat));
	    }

	    dto.setPagelinktype(getPagelinktype());
	    dto.setPagelink(getPagelink());
	    dto.setPageid(getPageid());
	    dto.setRefdate(getRefdate(DTOBase.printDateFormat));
	    
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    dto.setRectimestamp(DTOBase.currentTimestamp());
	    return  dto;
	}

	public CardDTO getDTO4Update(String aSite, String aCardId)
	{
		CardDTO dto = new CardDTO();
		dto.setSite(aSite);
		dto.setCardid(aCardId);
		dto.setSystemtitle(getSystemtitle());

		dto.setValidityrule(getValidityrule());
	    
	    if (getValidityruleAsEnum() == ValidityRule.date)
	    {
	    	dto.setValidfrom(getValidfrom(DTOBase.printDateFormat));
	    	dto.setValidto(getValidto(DTOBase.printDateFormat));
	    }
	    else
	    {
	    	dto.setValidfrom(null);
	    	dto.setValidto(null);
	    }

	    dto.setRecstatus(RecordStatus.sys_recact.toString());		
	    dto.setPagelinktype(getPagelinktype());
	    dto.setPagelink(getPagelink());
	    dto.setPageid(getPageid());
	    
        dto.setRefdate(getRefdate(DTOBase.printDateFormat));
	    return  dto;
	}

	public CardDescrDTO getDescrDTO4Insert(String aSite, String aCardId, String aCardLanguage)
	{
		CardDescrDTO dto = new CardDescrDTO();
		dto.setSite(aSite);
		dto.setCardid(aCardId);
		dto.setLanguagecode(aCardLanguage);
		
		dto.setTitle(getSystemtitle());		
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}
}
