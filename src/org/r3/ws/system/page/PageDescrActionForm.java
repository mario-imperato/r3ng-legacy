package org.r3.ws.system.page;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.cms.pagedescr.PageDescrDTO;

public class PageDescrActionForm
{	
	@FormParam("pagetitle")
    private String pagetitle;

    public String getPagetitle()
    {    	
    	return DTOBase.nullOnEmpty(pagetitle);
    }

	@FormParam("summary")
    private String summary;

    public String getSummary()
    {    	
    	return DTOBase.nullOnEmpty(summary);
    }

	public PageDescrDTO getDTO4Insert(String aSite, String aPageId, String aCardLanguage)
	{
		PageDescrDTO dto = new PageDescrDTO();
		dto.setSite(aSite);
		dto.setPageid(aPageId);
		dto.setLanguagecode(aCardLanguage);
		
		dto.setPagetitle(getPagetitle());
		dto.setSummary(getSummary());
		
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}

	public PageDescrDTO getDTO4Update(PageDescrDTO dto)
	{		
		dto.setPagetitle(getPagetitle());
		dto.setSummary(getSummary());
		
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}

}
