
package org.r3.system.taglibs.r3_lang;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

public class IfIncludeTag  extends GWFTagSupport
{
    private boolean  include = true;

    public IfIncludeTag()
    {
    	clearTagState();
    }

    public void clearTagState()
    {
    	super.clearTagState();
    	include = true;
    }

    public int doStartTag() throws JspException
    {
        if (!include)  return SKIP_BODY;
        return EVAL_BODY_INCLUDE;
    }

    public int doEndTag() throws JspException
    {
        JspWriter out = pageContext.getOut();

        try
        {
            
        }
        catch(Exception ex)
        {
            throw new JspTagException(ex.getMessage());
        }
        finally
        {
            clearTagState();
        }

        return EVAL_PAGE;
    }


    public void setInclude(boolean b)
    {
        include = b;
    }

    public void setInclude(String s)
    {
        include = stringToBoolean(s);
    }

}
