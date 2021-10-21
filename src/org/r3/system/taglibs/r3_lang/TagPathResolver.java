package org.r3.system.taglibs.r3_lang;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

public class TagPathResolver extends GWFTagSupport
{
    private String  path    = null;
    private String  overrideSite = null;
    private String  overrideLanguage = null;
    private boolean declare = true;

    // private boolean relative = false;

    public void clearTagState()
    {
        super.clearTagState();
        path = null;
        declare = true;
        
        overrideSite = null;
        overrideLanguage = null;
    }

    public void setPath(String aPath)
    {
        path = aPath;
    }

    public void setDeclare(boolean flag)
    {
        declare = flag;
    }
    
    // public void setRelative(boolean flag) { relative = flag; }

    public TagPathResolver()
    {
        clearTagState();
    }

    public int doStartTag() throws JspException
    {
        String pathTranslated = null;
        try
        {        
        	pathTranslated = getAbsoluteUrl(pageContext, path, overrideSite, overrideLanguage);        	
            if (getId() == null)
            {
                pageContext.getOut().print(pathTranslated);
                return SKIP_BODY;
            }
            else
            {
                pageContext.setAttribute(getId(), pathTranslated, PageContext.PAGE_SCOPE);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new JspException(e.getMessage());
        }

        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException
    {
        clearTagState();
        return EVAL_PAGE;
    }

	/**
	 * @param overrideSite the overrideSite to set
	 */
	public void setOverrideSite(String overrideSite)
	{
		this.overrideSite = overrideSite;
	}

	/**
	 * @return the overrideSite
	 */
	public String getOverrideSite()
	{
		return overrideSite;
	}

	/**
	 * @param overrideLanguage the overrideLanguage to set
	 */
	public void setOverrideLanguage(String overrideLanguage)
	{
		this.overrideLanguage = overrideLanguage;
	}

	/**
	 * @return the overrideLanguage
	 */
	public String getOverrideLanguage()
	{
		return overrideLanguage;
	}

//    public String addRequestSiteAndLanguageToPath(HttpServletRequest request, String aSite, String aLanguage, String aPath)
//    {
//        StringBuilder stb = new StringBuilder();
//        
//        if (aSite == null && aLanguage == null)
//        {
//           stb.append(GWFHttpUtils.getRequestSiteAndLanguagePrefix(request))
//              .append(aPath);        
//        }
//        else
//        {
//        	if (aSite == null)
//        		stb.append('/').append(GWFHttpUtils.getRequestSite(request));
//        	else 
//        		stb.append('/').append(aSite);
//        	
//        	if (aLanguage == null)
//        		stb.append('/').append(GWFHttpUtils.getRequestLanguage(request));
//        	else 
//        		stb.append('/').append(aLanguage);      
//        	
//        	stb.append(aPath);
//        }
//        return stb.toString();
//    }

    
    /**
     * @see it.gwf_30.gwfsystem.taglibs.PathResolver#getAbsoluteUrl(java.lang.String)
     */
//    public String getAbsoluteUrl(HttpServletRequest request, String pathName)
//    {
//        return getAbsoluteUrl(request, pathName, null, null, false);
//    }

    /**
     * @see it.gwf_30.gwfsystem.taglibs.PathResolver#getAbsoluteUrl(java.lang.String,
     *      boolean)
     */
//    public String getAbsoluteUrl(HttpServletRequest request, String pathName, String aSite, String aLanguage, boolean isThemed)
//    {
//        if (pathName == null)
//            return null;
//
//        StringBuffer urlPrefix = new StringBuffer();
//
//        if (!isThemed)
//        {
//            if (pathName == null || GWFHttpUtils.isStrutsAction(pathName))
//            {
//            	 urlPrefix.append(GWFHttpUtils.getApplicationSiteLanguagePrefixPath(request, aSite, aLanguage));
//            }
//            else 
//            {
//            	urlPrefix.append(request.getContextPath());
//            }            
//        }
//        else
//        {
//        	urlPrefix
//        	.append(request.getContextPath());
//        	
//        	if (aLanguage != null)
//        		urlPrefix.append("/themes/").append(aLanguage);
//        	else
//        	    urlPrefix.append("/themes/").append(GWFHttpUtils.getRequestLanguage(request));        	
//        }
//        
//        if (pathName != null)
//            urlPrefix.append(pathName);
//        
//        return urlPrefix.toString();
//    }

}
