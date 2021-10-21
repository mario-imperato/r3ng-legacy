// GWF version 9.9.18: Fixed popUpMenu and getSequence bug. December 6th.

package org.r3.system.taglibs.r3_lang;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.r3.system.struts.GWFHttpUtils;
import org.r3.system.struts.RequestEnvironment;

public class GWFTagSupport extends TagSupport
{
	public enum PathType { dms, dms_public, path };
	
    private String         theme;
    private String         id;
    private int            scope;
    
    public void clearTagState()
    {
        theme = null;
        id = null;
        scope = PageContext.PAGE_SCOPE;
    }

    public void setTheme(String t)
    {
        theme = t;
    }

    public String getTheme()
    {
        return theme;
    }

    public int getScopeAsInt()
    {
        return scope;
    }

    public void setScope(String aScope)
    {
        if (aScope.equalsIgnoreCase("request"))
            scope = PageContext.REQUEST_SCOPE;
        else if (aScope.equalsIgnoreCase("session"))
            scope = PageContext.SESSION_SCOPE;
        else if (aScope.equalsIgnoreCase("page"))
            scope = PageContext.PAGE_SCOPE;
        else if (aScope.equalsIgnoreCase("application"))
            scope = PageContext.APPLICATION_SCOPE;
    }

    public void setScopeAsInt(int aScope)
    {
        scope = aScope;
    }

    // 5/3/2005 Vengono convertiti i punti in '_' per evitare problemi nella
    // gestione Javascript.
    public void setId(String x)
    {
        if (x != null)
            id = x.replace('.', '_');
        else
            id = x;
    }

    public String getId()
    {
        return id;
    }

    public EnvironmentTag getParentEnvironmentTag()
    {
        return (EnvironmentTag) findAncestorWithClass(this, EnvironmentTag.class);
    }


//    public Locale getLocale()
//    {
//        return getTagHelper().getLocale();
//    }

    public RequestEnvironment getEnvironment()
    {
        EnvironmentTag e = getParentEnvironmentTag();
        if (e == null)
            return null;
        return e.getEnvironment();
    }

    public Object getDefinition(PageContext aPageContext, String definitionName)
    {

        Object o = aPageContext.getAttribute(definitionName, PageContext.PAGE_SCOPE);
        if (o == null)
            o = aPageContext.getAttribute(definitionName, PageContext.REQUEST_SCOPE);

        return o;
    }

    public boolean stringToBoolean(String s)
    {
        boolean retC = false;
        try
        {
            retC = Boolean.valueOf(s).booleanValue();
        }
        catch (Exception e)
        {
            retC = false;
        }

        return retC;
    }

    public int stringToInt(String s)
    {
        int retC = 0;
        try
        {
            retC = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            retC = 0;
        }

        return retC;
    }

	/**
     * @see it.gwf_30.gwfsystem.taglibs.PathResolver#getAbsoluteUrl(java.lang.String,
     *      boolean)
     */
    protected String getAbsoluteUrl(PageContext aPageContext, String pathName)
    {
        return getAbsoluteUrl(aPageContext, pathName, null, null);
    }

    protected String getAbsoluteUrl(PageContext aPageContext, String pathName, String aSite, String aLanguage)
    {    	
        if (pathName == null)
            return null;

        String dmsMountPoint = null;            
        HttpServletRequest request = (HttpServletRequest) aPageContext.getRequest();
        
        PathType resolveAsDMSUrl = PathType.path;
        
        // Lo faccio inizialmente piu' generico in quanto potrei gestire anche i DMS privati nello stesso modo.
        if (pathName.startsWith("DMS_FILE:///"))
		{
        	resolveAsDMSUrl = PathType.dms;
        	
       		dmsMountPoint = pageContext.getServletContext().getInitParameter("deploy.dmspubmountpoint");        		        	
        	if (pathName.startsWith("DMS_FILE:///PUB/"))
        	{
        		resolveAsDMSUrl = PathType.dms_public;        		
            	pathName = pathName.substring("DMS_FILE:///PUB/".length());
        	}
		}
        
        StringBuffer urlPrefix = new StringBuffer();

        switch(resolveAsDMSUrl)
        {
        case path:
        	if (GWFHttpUtils.isAbsolute(pathName))
        	{
        		// Non Faccio Nulla. Il Path Viene Inserito Automaticamente.
        	}
        	else if (GWFHttpUtils.isStrutsAction(pathName))
            {
            	 urlPrefix.append(GWFHttpUtils.getApplicationSiteLanguagePrefixPath(request, aSite, aLanguage));
            }
            else 
            {
            	urlPrefix.append(request.getContextPath());
            }            
            break;

        case dms:
        	// Questo caso e' da gestire...
        	
        case dms_public:
        	urlPrefix.append(dmsMountPoint);        	
        	if (dmsMountPoint.charAt(0) != '/')
        		urlPrefix.append('/');
        	break;
        	
        }
       
        if (pathName != null)
            urlPrefix.append(pathName);
        
        return urlPrefix.toString();
    }

}
