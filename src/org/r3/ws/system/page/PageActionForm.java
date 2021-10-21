package org.r3.ws.system.page;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.cms.page.PageDTO;
import org.r3.db.cms.page.PageDTO.OnUserStatus;
import org.r3.db.cms.page.PageDTO.PageVisibility;
import org.r3.db.cms.pagedescr.PageDescrDTO;

public class PageActionForm
{
	
	@FormParam("pageid")
    private String pageid;

    public String getPageid()
    {    	
    	String s = DTOBase.nullOnEmpty(pageid);
    	if (s != null)
    		return s.toUpperCase();
    	
    	return null;
    }
    
	@FormParam("pagetitle")
    private String pagetitle;

    public String getPagetitle()
    {    	
    	return DTOBase.nullOnEmpty(pagetitle);
    }

	@FormParam("pagelink")
    private String pagelink;

    public String getPagelink()
    {    	
    	return DTOBase.nullOnEmpty(pagelink);
    }       
    
	@FormParam("onuserstatus")
    private String onuserstatus;

    public String getOnuserstatus()
    {    	
    	return DTOBase.nullOnEmpty(onuserstatus);
    }

    public OnUserStatus getOnuserstatusAsEnum()
    {
        return OnUserStatus.getValueFor(getOnuserstatus(), OnUserStatus.always);	
    }
            
	@FormParam("permissions")
    private String permissions;

    public String getPermissions()
    {    	    	
    	return DTOBase.nullOnEmpty(permissions);
    }

	@FormParam("pagestyle")
    private String pagestyle;

    public String getPagestyle()
    {    	    	
    	return DTOBase.nullOnEmpty(pagestyle);
    }

	@FormParam("pageicon1")
    private String pageicon1;

    public String getPageicon1()
    {    	    	
    	return DTOBase.nullOnEmpty(pageicon1);
    }

	@FormParam("pageicon2")
    private String pageicon2;

    public String getPageicon2()
    {    	    	
    	return DTOBase.nullOnEmpty(pageicon2);
    }
    
	@FormParam("forwardview")
    private String forwardview;

    public String getForwardview()
    {    	    	
    	return DTOBase.nullOnEmpty(forwardview);
    }
    
	@FormParam("pagetype")
    private String pagetype;

    public String getPagetype()
    {    	    	
    	return DTOBase.nullOnEmpty(pagetype);
    }

    @FormParam("pageorder")
    private String pageorder;

    public String getPageorder()
    {    	   
    	return DTOBase.nullOnEmpty(pageorder);
    }

    public int getPageorderAsInt()
    {    	   
    	String s = DTOBase.nullOnEmpty(pageorder);
    	if (s != null)
    		return Integer.parseInt(s);
    	
    	return 99;
    }

	@FormParam("visibility")
    private String[] visibility;

    public String[] getVisibility()
    {    	    	
    	return visibility;
    }
    
    public String getVisibilityAsCSV()
    {
        String s = DTOBase.stringArray2CSV(visibility);
        if (s == null)
        	s = PageVisibility.cmspg_none.toString();
        
        return s;
    }
    
    @FormParam("viewoptions")
    private String viewoptions;

    public String getViewoptions()
    {    	   
    	return DTOBase.nullOnEmpty(viewoptions);
    }
    
    public PageDTO getDTO4Insert(String aSite)
	{
		PageDTO dto = new PageDTO();
		dto.setSite(aSite);
		dto.setPageid(getPageid());
		dto.setPagetitle(getPagetitle());
	    dto.setPagetype(getPagetype());
	    dto.setPageicon1(getPageicon1());
	    dto.setPageicon2(getPageicon2());
	    dto.setPagelink(getPagelink());
	    dto.setPageorder(getPageorderAsInt());
	    dto.setVisibility(getVisibilityAsCSV());
	    dto.setPagestyle(getPagestyle());
	    dto.setForwardview(getForwardview());
	    dto.setOnuserstatus(getOnuserstatusAsEnum().toString());
	    dto.setPermissions(getPermissions());
	    dto.setViewoptions(getViewoptions());
	    return  dto;
	}

	public PageDTO getDTO4Update(String aSite, String aPageId)
	{
		PageDTO dto = new PageDTO();
		dto.setSite(aSite);
		dto.setPageid(aPageId);

		dto.setPagetitle(getPagetitle());
	    dto.setPagetype(getPagetype());
	    dto.setPageicon1(getPageicon1());
	    dto.setPageicon2(getPageicon2());
	    dto.setPagelink(getPagelink());
	    dto.setPageorder(getPageorderAsInt());
	    dto.setVisibility(getVisibilityAsCSV());
	    dto.setPagestyle(getPagestyle());
	    dto.setForwardview(getForwardview());
	    dto.setOnuserstatus(getOnuserstatusAsEnum().toString());
	    dto.setPermissions(getPermissions());
	    dto.setViewoptions(getViewoptions());
		return  dto;
	}

	public PageDescrDTO getDescrDTO4Insert(String aSite, String aPageId, String aLanguage)
	{
		PageDescrDTO dto = new PageDescrDTO();
		dto.setSite(aSite);
		dto.setPageid(aPageId);
		dto.setLanguagecode(aLanguage);
		
		dto.setPagetitle(getPagetitle());		
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}
}
