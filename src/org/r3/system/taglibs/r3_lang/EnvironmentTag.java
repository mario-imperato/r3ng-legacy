package org.r3.system.taglibs.r3_lang;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SiteLUT;
import org.r3.system.WebAuthInfo;
import org.r3.system.struts.RequestEnvironment;
import org.r3.system.util.nls_dictionary.NLSDictionary;

public class EnvironmentTag extends TagSupport
{
    protected RequestEnvironment userEnvironment;
    protected String      id;
    protected String namespace;

    private SiteDTO getSiteDTO()
    {
    	SiteDTO siteDTO = userEnvironment.getRequestSite();    	
    	return siteDTO;
    }    
    
//    private String getSiteTheme() 
//    {
//       	SiteDTO item = getSiteDTO();
//        if (item != null)
//            return item.getSitetheme();
//        
//        return null;
//    }
    
    public void setId(String x)
    {
        id = x;
    }

    public String getId()
    {
        return id;
    }

    
    public String getNamespace()
	{
		return namespace;
	}

	public void setNamespace(String namespace)
	{
		this.namespace = namespace;
	}

	public RequestEnvironment getEnvironment()
    {
        return userEnvironment;
    }


    //private String             pageUrlPath;

    //private String             pageUrlName;

//    private String             staticContentRootURL;
//
//    private String             relativePathToStaticContent = null;
//
//    private String             absoluteRootUrl             = null;

    public void clearTagState()
    {
        userEnvironment = null;
        namespace = null;
        
//        staticContentRootURL = null;
//        relativePathToStaticContent = null;
//        absoluteRootUrl = null;        
    }

    public EnvironmentTag()
    {
        clearTagState();
    }

    public int doStartTag() throws JspException
    {
        try
        {
            HttpServletRequest req = (HttpServletRequest) pageContext.getRequest();
            
            // Retrieve the environment from the session
            userEnvironment = RequestEnvironment.getInstance(req);
            if (userEnvironment == null)
            {
                 String targetSiteId = req.getParameter("r3_site");
                 String targetLocale = req.getParameter("r3_lang");
                 if (targetSiteId != null)
                 {
                	 userEnvironment = new RequestEnvironment();
                	 SiteDTO targetSite = ((SiteLUT)LUTManager.getLUTManager().getLUT(LUTName.site, null)).getItem(targetSiteId);
                	 if (targetSite != null)
                	    userEnvironment.setRequestSite(targetSite);
                	 
                	 if (targetLocale != null)
                		 userEnvironment.setRequestLanguage(targetLocale);                    	                  	 
                 }
            }
                                    
            if (id != null)
            {
                pageContext.setAttribute(id, userEnvironment, PageContext.PAGE_SCOPE);
            }

            
//            relativePathToStaticContent = GWFHttpUtils.getRelativePathToStaticContent(getSiteTheme(), getRequestLanguage());
//            staticContentRootURL = initStaticContentURL(req, staticContentRootURL, getTheme(), getRequestLanguage());

            // System.err.println("### GWF - StaticContent URL: " +
            // staticContentRootURL);

            // String jspPath =
            // pageContext.getServletContext().getRealPath(req.getServletPath());
            String jspPath = req.getServletPath();

            // File f = new File(jspPath);
            // jspPath = f.getParent();
            // extendedDictionaryPrefix =
            // Integer.toHexString(jspPath.toUpperCase().hashCode());
            // System.err.println("jspPath hashCode: " + jspPath +
            // extendedDictionaryPrefix);
            jspPath = req.getContextPath();

            // Compute the URL of the current request in order to use it in the
            // TopMenuBar
            // where a printer is automatically inserted. May be dropped in a
            // future release
            // in favour of a different implementation
//            File f = new File(req.getServletPath());
//            StringBuffer stb = new StringBuffer();
//            if (jspPath.charAt(0) != '/')
//                stb.append('/');
//            stb.append(jspPath);
//            pageUrlPath = stb.append(f.getParent()).toString().replace('\\', '/');
//            // pageUrlName = f.getName();
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
        try
        {
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            throw new JspException(e.getMessage());
        }
        finally
        {
            clearTagState();
        }
        return EVAL_PAGE;
    }

//    public void setStaticContentRootURL(String t)
//    {
//        staticContentRootURL = t;
//    }
//
//    public String getStaticContentRootURL()
//    {
//        return staticContentRootURL;
//    }
//
//    private String getAbsoluteRootURL()
//    {
//        return absoluteRootUrl;
//    }

    private String getRequestLanguage()
    {
        return userEnvironment.getRequestLanguage();
    }
    
//    private String getRelativePathToStaticContent()
//    {
//        return relativePathToStaticContent;
//    }

//    private String getPageUrlPath()
//    {
//        return pageUrlPath;
//    }

    public WebAuthInfo getLoginInfo()
    {
        return userEnvironment.getAuthInfo();
    }

    public NLSDictionary getNLSDictionary(PageContext pageContext)
    {
    	ServletContext ctx = pageContext.getServletContext();
		NLSDictionary d = (NLSDictionary)ctx.getAttribute(NLSDictionary.getNLSDictionaryClassId);
		
		return d;
    }
    
    public String stringLookupForLanguage(PageContext pageContext, String aStringIdentifier)
    {
    	String res = aStringIdentifier;
    	
    	if (userEnvironment != null && namespace != null)
    	{
    		String l = userEnvironment.getRequestLanguage();
    		if (l != null)
    		{
    			NLSDictionary d = getNLSDictionary(pageContext);
    			if (d != null)
    			{
    				res = d.getStringFor(namespace, l, aStringIdentifier);
    			}
    		}
    	}
    	
    	return res;
    }
    
//    private String initStaticContentURL(HttpServletRequest request, String aRootURL, String aTheme, String aLanguage)
//    {
//        StringBuffer stb = new StringBuffer();
//
//        if (aRootURL == null)
//            aRootURL = GWFHttpUtils.getApplication(request);
//
//        if (!aRootURL.startsWith("/"))
//            stb.append("/");
//        stb.append(aRootURL);
//
//        if (!aRootURL.endsWith("/"))
//            stb.append("/");
//
//        absoluteRootUrl = stb.toString();
//
//        stb.append("themes/").append(aTheme).append("/").append(aLanguage).append("/");
//        return stb.toString();
//    }


}
