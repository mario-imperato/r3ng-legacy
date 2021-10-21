package org.r3.ws.project.siteresource;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.project.siteresource.SiteResourceDTO;
import org.r3.system.rest.SecurityTokenActionForm;

public class SiteResourceActionForm extends SecurityTokenActionForm
{

	@FormParam("cost")
    private String cost;

    public String getCost()
    {    	
    	return DTOBase.nullOnEmpty(cost);
    }

	@FormParam("price")
    private String price;

    public String getPrice()
    {    	
    	return DTOBase.nullOnEmpty(price);
    }
	
	@FormParam("evalueunit")
    private String evalueunit;

    public String getEvalueunit()
    {    	
    	return DTOBase.nullOnEmpty(evalueunit);
    }
    
	public SiteResourceDTO getDTO4Update(String aSite, String aResourceId)
	{
		SiteResourceDTO dto = new SiteResourceDTO();
		dto.setSite(aSite);
		dto.setResourceid(aResourceId);
		dto.setCost(getCost());
		dto.setPrice(getPrice());
		dto.setEvalueunit(getEvalueunit());
		return  dto;
	}

	
}
