
package org.r3.system.taglibs.r3_lang;

import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;

import org.r3.system.struts.RequestEnvironment;

public class IfInRoleTag  extends GWFTagSupport
{
    private boolean enabled              = true;
    private boolean defaultIncludePolicy = false;

    private String  allowFunctions = null;
    private String  allowRoles     = null;
    private String  allowUsers     = null;

    private String  denyFunctions  = null;
    private String  denyRoles      = null;
    private String  denyUsers      = null;

    private String  targetSite     = null;
    
    public IfInRoleTag()
    {
    	clearTagState();
    }

    public void clearTagState()
    {
    	super.clearTagState();
    	setAllowFunctions(null);
    	setAllowRoles(null);
    	setAllowUsers(null);

    	setDenyFunctions(null);
    	setDenyRoles(null);
    	setDenyUsers(null);
        
    	enabled              = true;
    	setDefaultIncludePolicy(false);
    	targetSite           = null;
    }

    public int doStartTag() throws JspException
    {
    	RequestEnvironment env = getEnvironment();
        boolean inRole = isInRole(env);

        if (getId() != null)
        {
        	pageContext.setAttribute(getId(), new Boolean(inRole), getScopeAsInt());
        }

        if (inRole) return EVAL_BODY_INCLUDE;
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException
    {
    	clearTagState();
        return EVAL_PAGE;
    }

    public void setEnabled(String s)
    {
        enabled = stringToBoolean(s);
    }

    public void setDefaultIncludePolicy(boolean defaultIncludePolicy)
    {
        this.defaultIncludePolicy = defaultIncludePolicy;
    }

    public boolean isDefaultIncludePolicy()
    {
        return defaultIncludePolicy;
    }

    public void setAllowFunctions(String allowFunctions)
    {
        this.allowFunctions = allowFunctions;
    }

    public String getAllowFunctions()
    {
        return allowFunctions;
    }

    public void setAllowRoles(String allowRoles)
    {
        this.allowRoles = allowRoles;
    }

    public String getAllowRoles()
    {
        return allowRoles;
    }

    public void setAllowUsers(String allowUsers)
    {
        this.allowUsers = allowUsers;
    }

    public String getAllowUsers()
    {
        return allowUsers;
    }

    public void setDenyFunctions(String denyFunctions)
    {
        this.denyFunctions = denyFunctions;
    }

    public String getDenyFunctions()
    {
        return denyFunctions;
    }

    public void setDenyRoles(String denyRoles)
    {
        this.denyRoles = denyRoles;
    }

    public String getDenyRoles()
    {
        return denyRoles;
    }

    public void setDenyUsers(String denyUsers)
    {
        this.denyUsers = denyUsers;
    }

    public String getDenyUsers()
    {
        return denyUsers;
    }

    private boolean isInRole(RequestEnvironment env)
    {
        if (!enabled) return false;

        if (checkFunctions(env, denyFunctions) ||  checkUsers(env, denyUsers) || checkRoles(env, denyRoles))
                       return false;

        if (checkFunctions(env, allowFunctions) || checkUsers(env, allowUsers) || checkRoles(env, allowRoles))
                       return true;

        return defaultIncludePolicy;
    }

    public boolean checkFunctions(RequestEnvironment env, String aListOfResources)
    {
    	if (aListOfResources == null) return false;

    	StringTokenizer strTok = new StringTokenizer(aListOfResources, ", ");
    	for( ; strTok.hasMoreTokens(); )
    	{
    		String theToken = strTok.nextToken();
    		if (env.checkFunction(getTargetSite(), theToken))  return true;
        }

        return false;
    }

    public boolean checkRoles(RequestEnvironment env, String aListOfResources)
    {
    	if (aListOfResources == null) return false;

    	StringTokenizer strTok = new StringTokenizer(aListOfResources, ", ");
    	for( ; strTok.hasMoreTokens(); )
    	{
    		String theToken = strTok.nextToken();
    		if (env.checkRole(getTargetSite(), theToken))  return true;
        }

        return false;
    }

    public boolean checkUsers(RequestEnvironment env, String aListOfResources)
    {
    	if (aListOfResources == null) return false;

    	StringTokenizer strTok = new StringTokenizer(aListOfResources, ", ");
    	for( ; strTok.hasMoreTokens(); )
    	{
    		String theToken = strTok.nextToken();
    		if (env.checkUser(theToken))  return true;
        }

        return false;
    }

	/**
	 * @param targetSite the targetSite to set
	 */
	public void setTargetSite(String targetSite)
	{
		this.targetSite = targetSite;
	}

	/**
	 * @return the targetSite
	 */
	public String getTargetSite()
	{
		return targetSite;
	}

}
