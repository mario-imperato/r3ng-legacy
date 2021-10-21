package org.r3.db.system.siteportletcfg;

import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTException;

public class SitePortletConfigLUT extends LUT
{
	public SitePortletConfigLUT() 
	{
		try
		{
	    setReader(new SitePortletConfigLUTReader());	
	    // setTimeout(300000);
		}
		catch(LUTException lute)
		{
			lute.printStackTrace();
		}
	}
			
	public String getDtodescr(String aDtokey)
	{
		SitePortletConfigLUTDTO dto = getItem(aDtokey);
		if (dto != null)
			return dto.getDtodescr();
	    
	    return null;
	}
	
	public SitePortletConfigLUTDTO getItem(String aDtokey)
	{
	    try
		{		    
	    	SitePortletConfigLUTDTO dto = (SitePortletConfigLUTDTO)getInstance().getItem(aDtokey);
			return dto;
		}
		catch (LUTException e1)
		{
			e1.printStackTrace();
		}
	    
	    return null;
	}

	public SitePortletConfigLUTDTO getItem(String aSite, String aPageId)
	{
		return getItem(SitePortletConfigLUTDTO.getDtokey(aSite, aPageId));
	}

}
