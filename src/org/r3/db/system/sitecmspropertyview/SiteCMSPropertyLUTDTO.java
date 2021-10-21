package org.r3.db.system.sitecmspropertyview;

import java.util.ArrayList;

import org.r3.db.LUTItemDTOBase;
import org.r3.db.cms.cardproperty.CardPropertyDTO;

public class SiteCMSPropertyLUTDTO extends LUTItemDTOBase
{

    protected java.lang.String  site;

	public SiteCMSPropertyLUTDTO()
	{
		// TODO Auto-generated constructor stub
	}

	public java.lang.String getSite()
	{
		return site;
	}

	public void setSite(java.lang.String site)
	{
		this.site = site;
	}

    public String getDtokey()
    {        
        StringBuilder stb = new StringBuilder();
        stb.append(site);
        return stb.toString();
    }
    
    private ArrayList<CardPropertyDTO> cmsProperties;

	public ArrayList<CardPropertyDTO> getCmsProperties()
	{
		return cmsProperties;
	}

	public void setCmsProperties(ArrayList<CardPropertyDTO> cmsProperties)
	{
		this.cmsProperties = cmsProperties;
	}

        
}
