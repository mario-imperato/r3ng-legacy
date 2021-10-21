package org.r3.ws.system.siteproperty;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.system.siteproperty.SitePropertyDTO;

public class FBAcquirePageTokenActionForm
{

	@FormParam("fbpageid")
    private String fbpageid;

    public String getFbpageid()
    {    	
    	return DTOBase.nullOnEmpty(fbpageid);
    }

	@FormParam("fbpagename")
    private String fbpagename;

    public String getFbpagename()
    {    	
    	return DTOBase.nullOnEmpty(fbpagename);
    }

	@FormParam("fbaccesstoken")
    private String fbaccesstoken;

    public String getFbaccesstoken()
    {    	
    	return DTOBase.nullOnEmpty(fbaccesstoken);
    }
    
	@FormParam("fbpagetoken")
    private String fbpagetoken;

    public String getFbpagetoken()
    {    	
    	return DTOBase.nullOnEmpty(fbpagetoken);
    }

	@FormParam("fbuserid")
    private String fbuserid;

    public String getFbuserid()
    {    	
    	return DTOBase.nullOnEmpty(fbuserid);
    }

	public SitePropertyDTO getDTO4Insert(String aSite, String aPropertyScope, String aPropertyKey, String aPropertyValue)
	{
		SitePropertyDTO dto = new SitePropertyDTO();
        dto.setSite(aSite);
        dto.setPropertyscope(aPropertyScope);
        dto.setPropertykey(aPropertyKey);
        dto.setPropertyvalue(aPropertyValue);
		
		return  dto;
	}


	
}
