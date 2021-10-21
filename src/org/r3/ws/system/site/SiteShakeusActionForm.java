package org.r3.ws.system.site;

import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SiteDTO.RefSiteType;

public class SiteShakeusActionForm extends SiteActionForm
{
		
    public SiteDTO getDTO4Insert(SiteDTO currentSite, String siteCardId)
	{
    	
    	SiteDTO dto = super.getDTO4Insert(currentSite, siteCardId);
    	dto.setRefsitetype(RefSiteType.site_none.toString());
    	dto.setRefsitevisible("bfalse");
    	dto.setAdmrefsitetype(RefSiteType.site_internal.toString());
		dto.setAdmrefsitevisible("btrue");
		dto.setAdmrefsite(currentSite.getSite());
		dto.setAdmrefsitedescr(currentSite.getSitedescr());
		
		return dto;
	}        
	
}
