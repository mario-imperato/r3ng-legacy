package org.r3.db.cms.pageview;

import java.util.List;

import org.r3.db.LUTItemDTOBase;

public class PageViewLUTDTO extends LUTItemDTOBase
{

    protected java.lang.String  site;
    protected java.lang.String  languagecode;

	public PageViewLUTDTO()
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

	public java.lang.String getLanguagecode()
	{
		return languagecode;
	}

	public void setLanguagecode(java.lang.String aLanguageCode)
	{
		this.languagecode = aLanguageCode;
	}

    public String getDtokey()
    {
        return getDtokey(site, languagecode);
    }
    
    public static String getDtokey(String aSite, String aLanguageCode)
    {
        StringBuilder stb = new StringBuilder();
        stb.append(aSite);
        stb.append("_");
        stb.append(aLanguageCode);
        return stb.toString();
    }
    
    private List<PageViewDTO> pages;

  	public List<PageViewDTO> getPages()
  	{
  		return pages;
  	}

  	public void setPages(List<PageViewDTO> properties)
  	{
  		this.pages = properties;
  	}
}
