package org.r3.system.struts;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.r3.system.AuthFunction;
import org.r3.system.struts.RequestSnooper.RequestSnooperType;



public class GWFActionMapping extends ActionMapping
{
    public enum SessionBehaviour { required, create, supported, failed };
    
    // Codice utilizzato quando non viene eseguito il redirect ma viene inizializzato il codice di stato dell'HTTP.
    // Il 499 e' un codice non utilizzato dal protocollo.
    private static final int SC_SESSIONREQUIRED = 499;
    
    public  static  final String  KEEP_CURRENT   = "GWF__keep_current__";
    public  static  final String  FAREA_NONE     = "GWF__functionalarea_none__";  
	    
    private SessionBehaviour  sessionBehaviour                     = SessionBehaviour.required;
    private String            sessionRequiredFailureForward        = GWFConstants.SessionRequiredFailure;
    private String            authorizationRequiredFailureForward  = GWFConstants.AuthorizationFailure;
    
    private boolean SSLRequiredFlag      = false;
    private boolean oneTimePasswordFlag  = false;
    private boolean enforceTimeTokenFlag = false;    
    private boolean autoCommitFlag       = true;
    
    private String  allowedSites         = null;
    
    // Flag per abilitare la scrittura della request su console.... in generale...

    private RequestSnooperType  snoopRequest = RequestSnooperType.none;
    
    private String  sessionErrorPolicy   = "redirect";
    
    private String  functionalAreaId = FAREA_NONE;
    private String  functionId       = null;

    private String  listOfBeans2Drop = null;
    private String  forwardKeyForSessionRequiredFailure = null;
    
    public String getFunctionalAreaId()
    {
      return functionalAreaId;
    }
  
    public void setFunctionalAreaId(String aFunctionalAreaId)
    {
    	if (aFunctionalAreaId == null)  functionalAreaId = FAREA_NONE;
        this.functionalAreaId = aFunctionalAreaId;
    }
  
    public AuthFunction getAuthFunction()
    {
        if (functionId != null)
        	return new AuthFunction(functionId);
        
        return null;
    }
    
    public String getFunctionId()
    {
      return functionId;
    }
  
    public void setFunctionId(String aFunctionId)
    {
      this.functionId = aFunctionId;
    }

    public  boolean autoCommit()     { return autoCommitFlag; }
    public  void    setAutoCommit(boolean flag)
    {
    	autoCommitFlag = flag;
    }
    

    public  boolean enforceTimeToken()     { return enforceTimeTokenFlag; }
    public  void    setEnforceTimeToken(boolean flag)
    {
    	enforceTimeTokenFlag = flag;
    }
    
    public  boolean isSSLRequired()     { return SSLRequiredFlag; }
    public  void    setSSLRequired(boolean flag)
    {
    	SSLRequiredFlag = flag;
    }

    public  boolean isOneTimePasswordEnabled()     { return oneTimePasswordFlag; }
    
    public  void    setOneTimePassword(boolean flag)
    {
    	oneTimePasswordFlag = flag;
    }
        
    public  void    setSessionBehaviour(String aSessionBehaviour)
    {        
        try
        {
            sessionBehaviour = SessionBehaviour.valueOf(aSessionBehaviour);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            sessionBehaviour = SessionBehaviour.failed;
        }
    }
    
    public  SessionBehaviour getSessionBehaviourAsEnum()
    {
        return sessionBehaviour;    
    }
    
    public  boolean isSessionRequired() 
    {
    	return sessionBehaviour == SessionBehaviour.required;
    }
    
    public boolean isSessionFailed()
    {
        return sessionBehaviour == SessionBehaviour.failed;
    }
    
    public  boolean canCreateSession() 
    {
        return sessionBehaviour == SessionBehaviour.create;
    }
    
    public boolean isSnoopRequestEnabled()
    {
        return snoopRequest != null && snoopRequest != RequestSnooperType.none;
    }
    
    public void setSnoopRequest(String aSnoopRequest)
    {
        if (aSnoopRequest != null)
        {
            try
            {
                snoopRequest = RequestSnooperType.valueOf(aSnoopRequest);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public RequestSnooperType getRequestSnooperType()
    {
        return snoopRequest ;
    }
    
    public void setAllowRules(String aCSVListOfRules)
    {
    }
    
    public void setDenyRules(String aCSVListOfRules)
    {
    }
    
    public boolean isAllowed(String anAddress)
    {
    	return true;
    }
    
    public boolean isDenied(String anAddress)
    {
    	return false;
    }

    public String getSessionRequiredFailureForward()
	{
		return sessionRequiredFailureForward;
	}

	public void setSessionRequiredFailureForward(String onSessionFail)
	{
		this.sessionRequiredFailureForward = onSessionFail;
	}

	public String getAuthorizationRequiredFailureForward()
	{
		return authorizationRequiredFailureForward;
	}

	public void setAuthorizationRequiredFailureForward(String authorizationRequiredFailureForward)
	{
		this.authorizationRequiredFailureForward = authorizationRequiredFailureForward;
	}

	private String  addQueryStringToURL(String url, String aQueryString)
    {
          if (url == null) return null;
    
          int     ndx            = -1;
          int     ndxInsertPoint = -1;
          boolean qMark          = false;
          
          if ((ndx=url.indexOf(GWFConstants.GWFServletMappingExtension))>0)
          {
          	  ndxInsertPoint = ndx + 3;
          	  if ((ndx=url.indexOf(GWFConstants.GWFServletMappingExtension + "?"))>0)
          	  {
          	  	   ndxInsertPoint = ndx + 4; 
          	  	   qMark          = true;
          	  }
          }
          else if ((ndx=url.indexOf(".jsp"))>0)
               {
               	   ndxInsertPoint = ndx + 4;
              	   if ((ndx=url.indexOf(".jsp?"))>0)
              	   {
              	   	   ndxInsertPoint = ndx + 5;
              	   	   qMark          = true;
              	   }               	   
               }
               
           if (ndxInsertPoint > 0)    
           {
              StringBuffer stb = new StringBuffer(url);
              if (qMark)
              {
                 stb.insert(ndxInsertPoint, aQueryString + "&");
              }
              else
              {
                 stb.insert(ndxInsertPoint, "?" + aQueryString);
              }    
              return stb.toString();
          }
    
          return url;
    }
    
    /**
      *  This method finds an appropriate forward, then it clones it in order for the upper
      *  levels of the framework to be able to modify it by putting in there
      *  extra parameters.
      */
    private ActionForward findForward(String name, String webSite, String language, String userTheme, String queryString, long   timeToken) 
    {
    	// Invoke the super class.        
    	ActionForward af = null;
    	if (userTheme != null)
    	{
    	    // Verifico se per caso vi e' un forward specifico per questo theme.
    	    af = findForward(new StringBuffer(userTheme).append("::").append(name).toString());
    	}
    	
    	// Cerco il 'default'
    	if (af == null) af = findForward(name);

    	ActionForward af1 = null;
    	if (af != null && af.getPath().endsWith(GWFConstants.GWFServletMappingExtension))
    	{
    	    String path = af.getPath();
    	    if (path.endsWith(GWFConstants.GWFServletMappingExtension) && webSite != null && language != null)
    	    {
    	       af1 = new ActionForward(af);   
    	       
    	       StringBuilder stb1 = new StringBuilder();
    	       stb1.append('/').append(webSite).append('/').append(language).append(path);
    	       path = stb1.toString();
    	       
    	       af1.setPath(path);
    	    }
    	    
    	    // This condition is to determine if the path of the forward has to be modified somehow.
            if ((timeToken > 0 || (queryString != null && queryString.length() > 0)) )
            {
                if (af1 == null)
                   af1 = new ActionForward(af);
                                                    
                StringBuilder stb = new StringBuilder();
                if (timeToken > 0)
                   stb.append(GWFConstants.RequestTimeTokenParam).append('=').append(timeToken);
              
                if (queryString != null && queryString.length() > 0)
                {
                   if (timeToken > 0)  stb.append('&');
                   stb.append(queryString);
                }
                                   
                af1.setPath(addQueryStringToURL(path, stb.toString()));
            }
            
            if (af1 != null)
                return af1;    	    
    	}
    	                
        return af;
    }
 
//    private ActionForward findForward(String name, String queryString, Environment anEnv) 
//    {    	
//        String userTheme = null;
//        if (anEnv != null && anEnv.getLoginInfo() != null)
//        {
//            userTheme = anEnv.getLoginInfo().getTheme();
//        }
//    	return findForward(name, null, null, userTheme, queryString, (anEnv != null) ? anEnv.getTimeToken() : 0);
//    }               
//
//    private ActionForward findForward(String name, String webSite, String language, String queryString, Environment anEnv) 
//    {       
//        String userTheme = null;
//        if (anEnv != null && anEnv.getLoginInfo() != null)
//        {
//            userTheme = anEnv.getLoginInfo().getTheme();
//        }
//        return findForward(name, webSite, language, userTheme, queryString, (anEnv != null) ? anEnv.getTimeToken() : 0);
//    }               

    public ActionForward findForward(HttpServletRequest request, String name) 
    {
        return findForward(request, name, null);
    }
    
    public ActionForward findForward(HttpServletRequest request, String name, String queryString) 
    {       
        String userTheme = null;        
        return findForward(name, GWFHttpUtils.getRequestSite(request), GWFHttpUtils.getRequestLanguage(request), userTheme, queryString, 0);
    }               

    public ActionForward findForward(String name, String aSite, String aLanguage) 
    {       
        return findForward(name, aSite, aLanguage, null, null, 0);
    }               

//    private Environment getEnvironment(HttpServletRequest request, boolean createFlag)
//    {
//         HttpSession ses = request.getSession(false);         
//         if (ses == null)
//         {
//            if (createFlag)
//            {
//                ses = request.getSession(true);         
//            }
//            else return null;
//         }
//         
//         return Environment.getSessionInstance(ses, createFlag);        
//    }


    public void setDropBeansFromSession(String aListOfActionFormNames)
    {
        listOfBeans2Drop = aListOfActionFormNames;        
    }
     
    public String getDropBeansFromSession()
    {
        return listOfBeans2Drop;        
    }
    
    public String[] getDropBeansFromSessionAsArray()
    {
         if (listOfBeans2Drop == null)  return null;
         
         StringTokenizer strTok = new StringTokenizer(listOfBeans2Drop);
         if (strTok.countTokens() == 0) return null;
         
         String[] resultArray = new String[strTok.countTokens()];
         
         for(int i=0 ; strTok.hasMoreTokens(); i++)
         {
             resultArray[i] = strTok.nextToken();
         }
         
         return resultArray;
    }

    public void setSessionErrorPolicy(String sessionErrorPolicy)
    {
        this.sessionErrorPolicy = sessionErrorPolicy;
    }

    public String getSessionErrorPolicy()
    {
        return sessionErrorPolicy;
    }
    
    public boolean isSessionErrorPolicyRedirect()
    {
        return sessionErrorPolicy != null && sessionErrorPolicy.equalsIgnoreCase("redirect");
    }

    public boolean isSessionErrorPolicyStatusCode()
    {
        return sessionErrorPolicy != null && sessionErrorPolicy.equalsIgnoreCase("statusCode");
    }

    public int getSessionErrorStatusCode()
    {
        int sc = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
        
        if (isSessionErrorPolicyStatusCode())
        {
            sc = SC_SESSIONREQUIRED;
        }
        
        return sc;        
    }

    /**
     * @param allowedSites the allowedSites to set
     */
    public void setAllowedSites(String allowedSites)
    {
        this.allowedSites = allowedSites;
    }

    /**
     * @return the allowedSites
     */
    public String getAllowedSites()
    {
        return allowedSites;
    }

	/**
	 * @param forwardKeyForSessionRequiredFailure the forwardKeyForSessionRequiredFailure to set
	 */
	public void setForwardKeyForSessionRequiredFailure(String forwardKeyForSessionRequiredFailure)
	{
		this.forwardKeyForSessionRequiredFailure = forwardKeyForSessionRequiredFailure;
	}

	/**
	 * @return the forwardKeyForSessionRequiredFailure
	 */
	public String getForwardKeyForSessionRequiredFailure()
	{
		return forwardKeyForSessionRequiredFailure;
	}
}
