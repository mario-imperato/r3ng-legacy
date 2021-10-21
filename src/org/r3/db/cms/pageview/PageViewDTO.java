//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pageview;

import org.r3.db.cms.page.PageDTO.OnUserStatus;
import org.r3.db.cms.page.PageDTO.PageVisibility;

public class PageViewDTO extends PageViewDTOBase
{
    public PageViewDTO()
    {
        super();
    }

    public PageViewDTO(PageViewDTO another)
    {
        super(another);
    }

    @Override
    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(site);
        stb.append(", ");
        stb.append(pageid);
        stb.append(", ");
        stb.append(languagecode);

        return stb.toString();
    }

    @Override
    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (pagetitle != null)
        {
        stb.append(pagetitle);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }
    
    public boolean isVisibleSomewhere()
    {
    	PageVisibility pv = PageVisibility.getValue(visibility, PageVisibility.cmspg_none);
    	return (pv != PageVisibility.cmspg_none);
    }
    
    public boolean isVisibleIn(PageVisibility aPageVisibility, boolean userIsGuest)
    {
    	return (visibility != null && visibility.indexOf(aPageVisibility.toString()) >= 0 && isPageVisibleOnUserLogged(!userIsGuest));
    }
    
    public boolean isPageVisibleOnUserLogged(boolean userLogged)
    {
    	OnUserStatus s = OnUserStatus.getValueFor(getOnuserstatus(), OnUserStatus.always);
    	return s == OnUserStatus.always || (s == OnUserStatus.userlogged && userLogged) || (s == OnUserStatus.usernotlogged && !userLogged);
    }
    
    @Override
    public String getPermissions()
    {
    	String f = super.getPermissions();
    	if (f == null || f.length() == 0)
    		return "pub";
    	
    	return f;
    }
    
    /**
     * Questo metodo viene utilizzato in quanto il link potrebbe non risultare assoluto ma debba essere reso relativo rispetto a qualche cosa.
     * @param docBase
     * @return
     */
    public String getPagelink(String docBase)
    {
    	String conversion = pagelink;
    	
    	if (pagelink != null && docBase != null)
    	{
    		if (!docBase.endsWith("/"))
    		{
    			docBase += "/";
    		}
    		
    		if (pagelink.startsWith(docBase))
    		{
    		    conversion = conversion.substring(docBase.length());	
    		}    		    		
    	}
    	
    	return conversion;
    }
    
    /**
     * L'icona puo' essere specificata secca senza indicare un path preciso. In questo caso viene resa relativa al path delle risorse 
     * 
     * @param docBase
     * @return
     */
    public String getPageicon1(String targetSiteResourcePath)
    {
    	String conversion = pageicon1;
    	
    	if (pageicon1 != null && !pageicon1.startsWith("/") && targetSiteResourcePath != null)
    	{
    		if (!targetSiteResourcePath.endsWith("/"))
    		{
    			targetSiteResourcePath += "/";
    		}
    		
    		conversion = conversion + targetSiteResourcePath;	
    	}
    	
    	return conversion;
    }
    
}
