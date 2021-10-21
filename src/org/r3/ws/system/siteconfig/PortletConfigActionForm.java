package org.r3.ws.system.siteconfig;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.system.siteportletcfg.SitePortletConfigDTO;
import org.r3.db.system.siteportletcfg.SitePortletConfigDTO.PortletOnUserStatusActivation;

public class PortletConfigActionForm
{	
	@FormParam("jsclassname")
    private String jsclassname;

    public String getJsclassname()
    {    	
    	return  DTOBase.nullOnEmpty(jsclassname);    	
    }            
 
    public boolean isPositionConfigured()
    {
        return getJsclassname() != null;	
    }
    
	@FormParam("cssclassname")
    private String cssclassname;

    public String getCssclassname()
    {    	
    	return DTOBase.nullOnEmpty(cssclassname);
    }

	@FormParam("datacardid")
    private String datacardid;

    public String getDatacardid()
    {    	
    	return DTOBase.nullOnEmpty(datacardid);
    }

    
	@FormParam("dataoptions")
    private String dataoptions;

    public String getDataoptions()
    {    	
    	return DTOBase.nullOnEmpty(dataoptions);
    }
    
	@FormParam("dataonuserstatus")
    private String dataonuserstatus;

    public String getDataonuserstatus()
    {    	
    	return DTOBase.nullOnEmpty(dataonuserstatus);
    }

    public PortletOnUserStatusActivation getDataonuserstatusAsEnum()
    {
    	return PortletOnUserStatusActivation.getValue4(getDataonuserstatus(), PortletOnUserStatusActivation.always);
    }
    
    public SitePortletConfigDTO getDTO4InsertUpdate(String aSite, String aPageId, String aPositionId)
	{
    	SitePortletConfigDTO dto = new SitePortletConfigDTO();
		dto.setSite(aSite);
		dto.setPageid(aPageId);
		dto.setPositionid(aPositionId);
	    dto.setJsclassname(getJsclassname());
	    dto.setCssclassname(getCssclassname());
	    dto.setDatacardid(getDatacardid());
	    dto.setDataoptions(getDataoptions());	    
	    dto.setDataonuserstatus(getDataonuserstatusAsEnum().toString());
	    return  dto;
	}

}
