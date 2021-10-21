package org.r3.db.system.siteportletcfg;

import org.r3.db.LUTItemDTOBase;

public class SitePortletConfigLUTDTO extends LUTItemDTOBase
{

    protected java.lang.String  site;
    protected java.lang.String  pageid;

	public SitePortletConfigLUTDTO()
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

	public java.lang.String getPageid()
	{
		return pageid;
	}

	public void setPageid(java.lang.String pageid)
	{
		this.pageid = pageid;
	}

    public String getDtokey()
    {
        return getDtokey(site, pageid);
    }
    
    public static String getDtokey(String aSite, String aPageId)
    {
        StringBuilder stb = new StringBuilder();
        stb.append(aSite);
        stb.append("_");
        stb.append(aPageId);
        return stb.toString();
    }
    
    private SitePortletConfigDTOCollection positions;

	public SitePortletConfigDTOCollection getPositions()
	{
		return positions;
	}

	public void setPositions(SitePortletConfigDTOCollection positions)
	{
		this.positions = positions;
	}
        
	public String getHTML4Position(String posId, boolean isUserLogged)
	{
		SitePortletConfigDTO item = null;
		if (positions != null)
			item = positions.getPortletConfigByPositionId(posId);
		
		if (item == null)
			item = SitePortletConfigDTO.NullPortlet;
		
		return item.getHTML4Position(posId, isUserLogged);
	}
}
