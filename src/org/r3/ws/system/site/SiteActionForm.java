package org.r3.ws.system.site;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardDTO.PageLinkType;
import org.r3.db.cms.card.CardDTO.ValidityRule;
import org.r3.db.sailevent.event.SailEventDTO;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SiteDTO.RefSiteType;
import org.r3.db.system.site.SiteDTO.SiteProfile;
import org.r3.db.system.site.SiteDTO.SiteType;

public class SiteActionForm
{
	
	@FormParam("site")
    private String site;

    public String getSite()
    {    	
    	String s = DTOBase.nullOnEmpty(site);
    	if (s != null)
    		return s.toLowerCase();
    	
    	return null;
    }

    @FormParam("sitedomain_opt")
    private String sitedomain_opt;
    
    
	public String getSitedomain_opt()
	{
		return DTOBase.nullOnEmpty(sitedomain_opt);
	}

	public boolean isDomainController()
	{
		String s = getSitedomain_opt();
		if (s != null && s.equalsIgnoreCase("primary"))
			return true;
		
		return false;
	}
	
	@FormParam("sitedescr")
    private String sitedescr;

    public String getSitedescr()
    {    	
    	return DTOBase.nullOnEmpty(sitedescr);
    }

    @FormParam("sitetype")
    private String sitetype;

    public String getSitetype()
    {    	
    	return DTOBase.nullOnEmpty(sitetype);
    }

    public SiteType getSitetypeAsSiteType()
    {    	
    	String s = DTOBase.nullOnEmpty(sitetype);
    	return SiteType.valueOf(s, null);
    }    
    
	@FormParam("siteresourcepath")
    private String siteresourcepath;

    public String getSiteresourcepath()
    {    	
    	return DTOBase.nullOnEmpty(siteresourcepath);
    }

	@FormParam("sitetheme")
    private String sitetheme;

    public String getSitetheme()
    {    	
    	return DTOBase.nullOnEmpty(sitetheme);
    }
    
    @FormParam("refsitetype")
    private String refsitetype;

    public String getRefsitetype()
    {    	
    	return DTOBase.nullOnEmpty(refsitetype);
    }

    public SiteDTO.RefSiteType getRefsitetypeAsEnum()
    {
    	return RefSiteType.valueOf(getRefsitetype(), SiteDTO.RefSiteType.site_none);
    }
    
    @FormParam("refsite")
    private String refsite;

    public String getRefsite()
    {    	
    	return DTOBase.nullOnEmpty(refsite);
    }

    @FormParam("refsitevisible")
    private String refsitevisible;

    public String getRefsitevisible()
    {    	
    	return DTOBase.nullOnEmpty(refsitevisible);
    }
    
    @FormParam("refsitedescr")
    private String refsitedescr;

    public String getRefsitedescr()
    {    	
    	return DTOBase.nullOnEmpty(refsitedescr);
    }

    @FormParam("admrefsitetype")
    private String admrefsitetype;

    public String getAdmrefsitetype()
    {    	
    	return DTOBase.nullOnEmpty(admrefsitetype);
    }

    public SiteDTO.RefSiteType getAdmrefsitetypeAsEnum()
    {
    	return RefSiteType.valueOf(getAdmrefsitetype(), SiteDTO.RefSiteType.site_none);
    }
    
    @FormParam("admrefsite")
    private String admrefsite;

    public String getAdmrefsite()
    {    	
    	return DTOBase.nullOnEmpty(admrefsite);
    }

    @FormParam("admrefsitevisible")
    private String admrefsitevisible;

    public String getAdmrefsitevisible()
    {    	
    	return DTOBase.nullOnEmpty(admrefsitevisible);
    }

    @FormParam("admrefsitedescr")
    private String admrefsitedescr;

    public String getAdmrefsitedescr()
    {    	
    	return DTOBase.nullOnEmpty(admrefsitedescr);
    }

    @FormParam("eventdescr")
    private String eventdescr;

    public String getEventdescr()
    {    	
    	String ed = DTOBase.nullOnEmpty(eventdescr);
    	if (ed == null)
    		return getSitedescr();
    	
    	return ed;
    }
    
	@FormParam("options")
	private String[] options;
		
	public String[] getOptions()
	{
		return options;
	}

	public String getOptionsAsCSV()
    {
		String s = DTOBase.stringArray2CSV(options);
		if (s == null)
			s = SiteProfile.profilebase.toString();
		else
		{
		   StringBuilder stb = new StringBuilder();
		   stb.append(s).append(',').append(SiteProfile.profilebase.toString());
		   s = stb.toString();
		}
		
        return s;	
    }
	
    public SiteDTO getDTO4Insert(SiteDTO currentSite, String siteCardId)
	{
    	SiteDTO dto = new SiteDTO();
		dto.setSite(getSite());
		
		// Setto il dominio al dominio del padre.
		if (isDomainController())
			dto.setSitedomain(getSite());
		else
			dto.setSitedomain(currentSite.getSitedomain());
		
		dto.setCalendarid(currentSite.getCalendarid());
		
		dto.setSitedescr(getSitedescr());
		dto.setSitetype(getSitetype());
		dto.setSitesummary(getEventdescr());
		dto.setSiteresourcepath(getSiteresourcepath());
		dto.setSitetheme(getSitetheme());
		dto.setSitelanguages("it,en");
		// Non Lo Assegno. Viene Assegnato Negli Script velocity
		// dto.setSitelayout("default");
		dto.setSitetype(getSitetype());
        dto.setCardid(siteCardId);
        dto.setOptions(getOptionsAsCSV());
		dto.setRefsitetype(getRefsitetype());
		dto.setRefsitevisible(getRefsitevisible());
		switch(getRefsitetypeAsEnum())
		{
		case site_none:
			dto.setRefsitevisible("bfalse");
			break;
			
		case site_external:
			dto.setRefsite(getRefsite());
			dto.setRefsitedescr(getRefsitedescr());
			break;
			
		case site_internal:
			dto.setRefsite(currentSite.getSite());
			dto.setRefsitedescr(getRefsitedescr());
			break;
		}

		dto.setAdmrefsitetype(getAdmrefsitetype());
		dto.setAdmrefsitevisible(getAdmrefsitevisible());
		switch(getAdmrefsitetypeAsEnum())
		{
		case site_none:
			dto.setAdmrefsitevisible("bfalse");
			break;
			
		case site_external:
			dto.setAdmrefsite(getAdmrefsite());
			dto.setAdmrefsitedescr(getAdmrefsitedescr());
			break;
			
		case site_internal:
			dto.setAdmrefsite(currentSite.getSite());
			dto.setAdmrefsitedescr(getAdmrefsitedescr());
			break;
		}

	    return  dto;
	}

    public SailEventDTO getSailEventDTO4Insert(SiteDTO currentSite)
	{
    	SailEventDTO dto = new SailEventDTO();
		dto.setEventid(getSite());
		dto.setEventtitle(getSitedescr());
		dto.setEventdescr(getEventdescr());
		dto.setEventstatus("running");
		dto.setApplicationstatus("open");
		
		switch(getRefsitetypeAsEnum())
		{
		case site_none:
			break;
			
		case site_external:
			break;
			
		case site_internal:
			dto.setEventgroup(currentSite.getSite());
			break;
		}
		
	    return  dto;
	}
    
    public CardDTO getCMSCardDTO4Insert(String currentSite)
	{
		CardDTO dto = new CardDTO();
		dto.setSite(getSite());		
		dto.setSystemtitle("Site CMS Card");
	    dto.setValidityrule(ValidityRule.never.toString());
	    dto.setCategoryid("speciale");
	    
	    dto.setPagelinktype(PageLinkType.none.toString());
	    dto.setRefdate(DTOBase.currentDate());
	    
	    dto.setRecstatus(RecordStatus.sys_recact.toString());
	    return  dto;
	}
    
	public SiteDTO getDTO4Update(String currentSite, String aSite)
	{
		SiteDTO dto = new SiteDTO();
		dto.setSite(aSite);
		dto.setSitedescr(getSitedescr());
		dto.setSitesummary(getEventdescr());
		dto.setSiteresourcepath(getSiteresourcepath());
		dto.setSitetheme(getSitetheme());
		
		// Se i due siti sono diversi vuol dire che sono in Amministrazione e non in configurazione.
		if (!aSite.equalsIgnoreCase(currentSite))
		{
		dto.setRefsitetype(getRefsitetype());
		dto.setRefsitevisible(getRefsitevisible());
		switch(getRefsitetypeAsEnum())
		{
		case site_none:
			dto.setRefsitevisible("bfalse");
			break;
			
		case site_external:
			dto.setRefsite(getRefsite());
			dto.setRefsitedescr(getRefsitedescr());
			break;
			
		case site_internal:
			dto.setRefsite(currentSite);
			dto.setRefsitedescr(getRefsitedescr());
			break;
		}

		dto.setAdmrefsitetype(getAdmrefsitetype());
		dto.setAdmrefsitevisible(getAdmrefsitevisible());		
		switch(getAdmrefsitetypeAsEnum())
		{
		case site_none:
			dto.setAdmrefsitevisible("bfalse");			
			break;
			
		case site_external:
			dto.setAdmrefsite(getAdmrefsite());
			dto.setAdmrefsitedescr(getAdmrefsitedescr());
			break;
			
		case site_internal:
			dto.setAdmrefsite(currentSite);
			dto.setAdmrefsitedescr(getAdmrefsitedescr());
			break;
		}		
		
		dto.setOptions(getOptionsAsCSV());
	    }
		
	    return  dto;
	}

	public SailEventDTO getSailEventDTO4Update(String currentSite, String aSite)
	{
		SailEventDTO dto = new SailEventDTO();
		dto.setEventid(aSite);
		dto.setEventtitle(getSitedescr());
		dto.setEventdescr(getEventdescr());

		switch(getRefsitetypeAsEnum())
		{
		case site_none:
			break;
			
		case site_external:
			break;
			
		case site_internal:
			dto.setEventgroup(currentSite);
			break;
		}

	    return  dto;
	}

}
