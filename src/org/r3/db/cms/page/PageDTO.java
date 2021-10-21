//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.page;

import org.r3.system.util.StringUtils;

public class PageDTO extends PageDTOBase
{
	public enum PageType { page, media, group, cmspage }
	public enum PageVisibility { 
		
		cmspg_none, cmspg_txtmenu, cmspg_iconmenu, cmspg_homemenu, cmspg_consolemenu;
		
		public static PageVisibility getValue(String s, PageVisibility defaultResult)
		{
			PageVisibility pv = defaultResult;
			if (s != null && s.length() > 0)
				pv = PageVisibility.valueOf(s);
			
			return pv;
		}
	}
	
	public enum OnUserStatus {
		
		userlogged, usernotlogged, always;
		
		public static OnUserStatus getValueFor(String s, OnUserStatus defaultValue)
		{
			if (s != null && s.length() > 0)
				return OnUserStatus.valueOf(s);
			
			return defaultValue;
		}
	}
		
    public PageDTO()
    {
        super();
    }

    public PageDTO(PageDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(site);
        stb.append("_");
        stb.append(pageid);
        return stb.toString();
    }
    
    public String getDtokey(boolean excludeSite)
    {
    	String dtok = getDtokey();
    	
    	if (excludeSite)
    	{
    		dtok = StringUtils.sliceTokens(dtok, '_', 1);        	
    	}
    		
    	return dtok;
    }
    
    public boolean isVisibleSomewhere()
    {
    	return !isVisibleIn(PageVisibility.cmspg_none);
    }
    
    public boolean isVisibleIn(PageVisibility aPageVisibility)
    {
    	if (visibility != null && visibility.indexOf(aPageVisibility.toString()) >= 0)
    		return true;
    	
    	return false;
    }
    
    public OnUserStatus getOnuserstatusAsEnum()
    {
    	return OnUserStatus.getValueFor(getOnuserstatus(), OnUserStatus.always);
    }
}
