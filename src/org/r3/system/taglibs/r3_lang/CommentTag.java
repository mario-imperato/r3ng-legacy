
package org.r3.system.taglibs.r3_lang;


import javax.servlet.jsp.JspException;

public class CommentTag extends GWFTagSupport
{

    public CommentTag()
    {
    }

    public int doStartTag() throws JspException
    {
         return SKIP_BODY;
    }

    public int doEndTag() throws JspException
    {
    	clearTagState();
        return EVAL_PAGE;
    }
}

