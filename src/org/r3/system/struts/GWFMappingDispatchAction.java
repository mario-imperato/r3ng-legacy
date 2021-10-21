package org.r3.system.struts;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.config.ControllerConfig;
import org.apache.struts.config.ModuleConfig;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GWFMappingDispatchAction extends MappingDispatchAction
{
	/**
	 * Commons Logging instance.
	 */
	private static Logger logger = LoggerFactory.getLogger(GWFMappingDispatchAction.class);

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
					throws Exception
	{
		ActionEnvironment cEnv = ActionEnvironment.getInstance(getServlet().getServletContext());

		try
		{

			ActionForward af;

			GWFActionMapping gwfMapping = processCastActionMapping(mapping);
			if (gwfMapping == null)
			{
				return mapping.findForward(GWFConstants.SystemFailure);
			}

			GWFControllerConfig gwfCfg = getControllerConfig(gwfMapping);
			if (gwfCfg == null)
			{
				return gwfMapping.findForward(GWFConstants.SystemFailure);
			}

			// If a secure (SSL) connection has been required for the action,
			// check if the HTTP request complies.
			//
			af = processSSLRequired(gwfMapping, request);
			if (af != null)
				return af;

			af = processAllowDenyRules(gwfMapping, request);
			if (af != null)
				return af;

			try
			{
				RequestEnvironment reqEnv = new RequestEnvironment();
				reqEnv.setRequestedFunction(gwfMapping.getAuthFunction());
				reqEnv.setRequestInfo(request);
				reqEnv.saveInstance(request);
				
                // reqEnv.setRequestContextPath(request.getContextPath());
                
				af = processStartProcessing(cEnv, gwfMapping, request);
				if (af != null)
					return af;

				af = processRequestSnooper(gwfMapping, getServlet().getServletConfig(), request);
				if (af != null)
					return af;				
				
				af = processUserIdentification(request, response, gwfMapping, reqEnv);
				if (af != null)
					return af;

				af = processUserAuthorization(gwfMapping, reqEnv);
				if (af != null)
					return af;

				af = processTimeToken(gwfMapping, request);
				if (af != null)
					return af;

				try
				{
					af = super.execute(gwfMapping, form, request, response);
					if (af != null)
					{
						logger.info("Forward Found.....");
					}
					else
					{
						// Nei casi in cui si esegue streaming di content non
						// viene ritornato
						// un forward in quanto il response e' stato gia'
						// popolato.
						logger.error("ERROR", "No forward returned from method!");
						// return
						// gwfMapping.findForward(GWFConstants.GWFNoForwardFailure);
					}

				}
				catch (Exception e)
				{
					e.printStackTrace();
					logger.error("ERROR", "Exception in method invocation!");

					return gwfMapping.findForward(GWFConstants.SystemFailure);
				}

				return af;
			}
			finally
			{
			}
		}
		finally
		{
			// NDC.remove();
		}
	}

	private ActionForward processUserIdentification(HttpServletRequest request, HttpServletResponse response, GWFActionMapping gwfMapping, RequestEnvironment reqEnv)
	{
		reqEnv.processUserIdentification(request, null, gwfMapping.canCreateSession(), gwfMapping.isOneTimePasswordEnabled());
				
		if (reqEnv.getAuthInfo().isUserNotIdentified())
			return gwfMapping.findForward(gwfMapping.getSessionRequiredFailureForward(), reqEnv.getRequestSiteId(), reqEnv.getRequestLanguage());
		
//		switch (gwfMapping.getSessionBehaviourAsEnum())
//		{
//		case create:
//			if (reqEnv.getAuthInfo().isUserNotIdentified())
//			{
//				reqEnv.processGuestLogin();
//			}            
//			
//			break;
//
//		case required:
//			if (reqEnv.getAuthInfo().isUserNotIdentified())
//				return gwfMapping.findForward(GWFConstants.GWFSessionRequiredFailure);
//
//			break;
//
//		case failed:
//			return gwfMapping.findForward(GWFConstants.GWFSessionRequiredFailure);
//
//		}
		
		if (reqEnv.isApplicationCookieRequired())
		{
			response.addCookie(reqEnv.getHttpServletCookie(request));
		}
		
		return null;
	}

	private ActionForward processTimeToken(GWFActionMapping mapping, HttpServletRequest request)
	{

		if (logger.isTraceEnabled())
		{
			logger.trace("### GWF - processTimeToken");
		}

		return null;
	}

	private ActionForward processUserAuthorization(GWFActionMapping mapping, RequestEnvironment reqEnv)
	{
		String idFunction = mapping.getFunctionId();

		if (logger.isTraceEnabled())
		{
			logger.trace("### GWF - processUserAuthorization for " + idFunction);
		}

		UserProfileViewDTO currentLogin = reqEnv.getAuthInfo().getUserProfile();
		if (!currentLogin.isInRole(reqEnv.getRequestSiteId(), reqEnv.getRequestedFunction()))
		{
			logger.warn("### GWF - Authorization for " + idFunction + " failed for user " + currentLogin.getUserid() + "/"
							+ currentLogin.getNickname());
			logger.error("ERROR", "Function not authorized");

			return mapping.findForward(mapping.getAuthorizationRequiredFailureForward(), reqEnv.getRequestSiteId(), reqEnv.getRequestLanguage());
		}

		return null;
	}

	private ActionForward processSSLRequired(GWFActionMapping mapping, HttpServletRequest request)
	{

		if (logger.isTraceEnabled())
		{
			logger.trace("### GWF - processSSLRequired");
		}

		if (mapping.isSSLRequired())
		{
			if (!request.isSecure())
			{
				return mapping.findForward(GWFConstants.SSLRequiredFailure);
			}
		}

		return null;
	}

	protected GWFActionMapping processCastActionMapping(ActionMapping mapping)
	{
		if (logger.isTraceEnabled())
		{
			logger.trace("### GWF - processCastActionMapping");
		}

		if (mapping instanceof GWFActionMapping)
			return (GWFActionMapping) mapping;
		return null;
	}

	/**
	 * If the specified session instantiation behaviour requires that a session
	 * should be present in order to perform the selected action, check if it is
	 * so. If the session was not already created, redirect the flow toward a
	 * predefined page. The check for the presence of the session has been
	 * replaced by a check of the Environment since the session can be created
	 * by the Struts framework and we might not have full control on its
	 * lifecycle.
	 * 
	 * private ActionForward processSession( GWFActionMapping mapping,
	 * HttpServletRequest request, AccessLogInfo accessLogInfo) { if
	 * (logger.isTraceEnabled()) {
	 * logger.trace("### GWF - processSession - sessione required " +
	 * mapping.isSessionRequired()); }
	 * 
	 * Environment env = null; env = Environment.getSessionInstance(request,
	 * true);
	 * 
	 * accessLogInfo.setSessionId(request.getSession(true).getId());
	 * 
	 * env.initialize(request, getControllerConfig(mapping).getGWFApplication(),
	 * mapping.getFunctionalAreaId(), mapping.getFunctionId());
	 * 
	 * return null; }
	 */

	// if (isSessionFailed(gwfMapping, request, accessLogInfo))
	// {
	// // In questo caso la verifica di nullability viene eliminata in quanto
	// nel caso af sia null
	// // vuold dire che e' stato effettuato un sendError sulla response.
	// af = processSessionFailed(gwfMapping, request, response, accessLogInfo);
	// return af;
	// }
	// else
	// af = processSession(gwfMapping, request, accessLogInfo);

	private ActionForward processSession(GWFActionMapping mapping, RequestEnvironment reqEnv)
	{
		switch (mapping.getSessionBehaviourAsEnum())
		{
		case create:
			if (reqEnv.getAuthInfo().isUserNotIdentified())
			{
				reqEnv.processGuestLogin();
			}            
			
			break;

		case required:
			if (reqEnv.getAuthInfo().isUserNotIdentified())
				return mapping.findForward(mapping.getSessionRequiredFailureForward(), reqEnv.getRequestSiteId(), reqEnv.getRequestLanguage());

			break;

		case failed:
			return mapping.findForward(GWFConstants.SystemFailure, reqEnv.getRequestSiteId(), reqEnv.getRequestLanguage());

		}

		return null;
	}

	private GWFControllerConfig getControllerConfig(ActionMapping mapping)
	{
		ControllerConfig ctrlConfig = mapping.getModuleConfig().getControllerConfig();
		if (!(ctrlConfig instanceof GWFControllerConfig))
		{
			return null;
		}

		return (GWFControllerConfig) ctrlConfig;
	}

	private ActionForward processAllowDenyRules(GWFActionMapping mapping, HttpServletRequest request)
	{
		if (logger.isTraceEnabled())
		{
			logger.trace("### GWF - processAllowDenyRules");
		}

		// If the action has an "allow" policy, do the necessary verifications.
		//
		if (!mapping.isAllowed(request.getRemoteAddr()))
		{
			return mapping.findForward(GWFConstants.AuthorizationFailure);
		}

		// If the action has a "deny" policy, do the necessary verifications.
		//
		if (mapping.isDenied(request.getRemoteAddr()))
		{
			return mapping.findForward(GWFConstants.AuthorizationFailure);
		}

		return null;
	}

    protected ActionForward processRequestSnooper(GWFActionMapping mapping, ServletConfig servletCfg, HttpServletRequest request)
    {
       if (logger.isTraceEnabled()) {
            logger.trace("### GWF - processRequestSnooper");
       }              

       if (mapping.isSnoopRequestEnabled())
       {
           RequestSnooper s = RequestSnooper.getRequestSnooper(mapping.getRequestSnooperType());
           s.snoop(servletCfg, request);
       }

       return null;
    }
    
	private ActionForward processStartProcessing(ActionEnvironment cEnv, GWFActionMapping mapping, HttpServletRequest request)
	{
		if (logger.isTraceEnabled())
		{
			logger.trace("### GWF - processStartProcessing");
		}

		return null;
	}

	protected GWFActionForm instantiateActionForm(String aClassName)
	{
		try
		{
			Class c = Class.forName(aClassName);
			Object o = c.newInstance();
			if (o instanceof GWFActionForm)
			{
				return (GWFActionForm) o;
			}
		}
		catch (Exception exc)
		{
			exc.printStackTrace(System.err);
		}

		return null;
	}

	// Questo snippet per ottenere il ModuleConfig e' stato copiato guardando il
	// codice di struts.
	protected ModuleConfig getModuleConfig(HttpServletRequest request)
	{
		ModuleConfig config = (ModuleConfig) request.getAttribute(Globals.MODULE_KEY);

		return config;
	}
	
    protected void saveFormBean(HttpServletRequest request, String aScope, GWFActionForm anActionForm)
    {
        saveFormBean(request, aScope, anActionForm.getId(), anActionForm);
    }

    protected void saveFormBean(HttpServletRequest request, ActionMapping mapping, GWFActionForm anActionForm)
    {
    	saveFormBean(request, mapping.getScope(), anActionForm);
    }

    protected void saveFormBean(HttpServletRequest request, String aScope, String attributeName, Object anObject)
    {
        if (aScope.equalsIgnoreCase("request"))
        {
            request.setAttribute(attributeName, anObject);
        }
        else if (aScope.equalsIgnoreCase("session"))
             {
                request.getSession().setAttribute(attributeName, anObject);
             }
             else
             {
                logger.error("saveFormBean::unrecognized scope " + aScope);
             }      
    }

    protected GWFActionForm getFormBean(HttpServletRequest request, String aScope, String anActionFormName)
    {
        return getFormBean(request, aScope, anActionFormName, false);
    }
    
    protected GWFActionForm getFormBean(
                 HttpServletRequest request, 
                 String aScope, String anActionFormName, boolean createOnNotFound)
    {
        Object o = null;
    	if (aScope.equalsIgnoreCase("request"))
    	{
    		o = request.getAttribute(anActionFormName);
        }
    	else if (aScope.equalsIgnoreCase("session"))
    	     {
    	     	o = request.getSession().getAttribute(anActionFormName);
    	     }
    	     else
    	     {
    	     	logger.error("saveFormBean::unrecognized scope " + aScope);
    	     }    	
    	
    	if (o != null && o instanceof GWFActionForm)
    	{
    	    return (GWFActionForm)o;
    	}
    	else if (createOnNotFound) 
    	{
            GWFActionForm anActionForm = instantiateActionForm(anActionFormName);
            if (anActionForm != null)
                saveFormBean(request, aScope, anActionForm);
            return anActionForm;
        }
    	
    	return null;
    }

}
