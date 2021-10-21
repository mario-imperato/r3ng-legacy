
package org.r3.system.taglibs.r3_lang;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.r3.system.util.StringUtils;

public class StringTag  extends GWFTagSupport
{
	private String   resourceId    = null;

	public void clearTagState()
	{
		super.clearTagState();
		resourceId = null;
    }


    public String getResourceId()
	{
		return resourceId;
	}


	public void setResourceId(String resourceId)
	{
		this.resourceId = resourceId;
	}


	public StringTag()
    {
    	clearTagState();
    }

    public int doStartTag() throws JspException
    {
    	int retCode = SKIP_BODY;
    	
    	String actualString = resolveStringTranslation(pageContext, resourceId);
        if (false)
            actualString = StringUtils.escapeSingleQuotes(actualString);
        
        try
        {
            if (getId() != null)
            {
                pageContext.setAttribute(getId(), actualString, PageContext.PAGE_SCOPE);
            }
            else 
            {
                pageContext.getOut().print(actualString);
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace(System.err);
            throw new JspException(e.getMessage());
        }

        return retCode;
    }

    private String resolveStringTranslation(PageContext pageContext, String resourceId2)
	{
    	EnvironmentTag e = getParentEnvironmentTag();
    	return e.stringLookupForLanguage(pageContext, resourceId2);
	}

	public int doEndTag() throws JspException
    {
    	clearTagState();
        return EVAL_PAGE;
    }

}
