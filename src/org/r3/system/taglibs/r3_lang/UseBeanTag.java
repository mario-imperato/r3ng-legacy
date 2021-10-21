
package org.r3.system.taglibs.r3_lang;

import javax.servlet.jsp.JspException;

public class UseBeanTag  extends GWFTagSupport
{
	private String   type    = null;
	private String   name    = null;
	private boolean  declare = true;

	public void clearTagState()
	{
		super.clearTagState();
		name    = null;
		declare = true;
		type    = "java.lang.String";
    }

    public void setType(String aType)       { type = aType;    }
    public void setName(String aName)       { name = aName;    }
    public void setDeclare(boolean flag)    { declare = flag;  }

    public UseBeanTag()
    {
    	clearTagState();
    }

    public int doStartTag() throws JspException
    {
    	int retCode = SKIP_BODY;

        try
        {
             if (name == null)  name = getId();

             Object item = pageContext.getAttribute(name, getScopeAsInt());
             if (item == null)
             {
            	 System.out.println("UseBean: Not Found " + name);
                 try
                 {
                   item = java.beans.Beans.instantiate(this.getClass().getClassLoader(), type);
                   pageContext.setAttribute(getId(), item, getScopeAsInt());
                 }
                 catch (ClassNotFoundException exc)
                 {
        	        exc.printStackTrace(System.err);
                    throw new InstantiationException(exc.getMessage());
                 }
                 retCode = EVAL_BODY_INCLUDE;
             }
             else
             {
             	  if (!name.equalsIgnoreCase(getId()))
             	  {
             		// System.out.println("UseBean: Setting PageContext Attribute " + name);
             	  	pageContext.setAttribute(getId(), item, getScopeAsInt());
             	  }
             }

        }
        catch(Exception e)
        {
        	e.printStackTrace(System.err);
            throw new JspException(e.getMessage());
        }

        return retCode;
    }

    public int doEndTag() throws JspException
    {
    	clearTagState();
        return EVAL_PAGE;
    }

}
