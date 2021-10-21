package org.r3.system.rest;

import java.util.Properties;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;

import org.r3.system.AuthFunction;
import org.r3.system.Environment;
import org.r3.system.UnauthorizedException;
import org.r3.system.UnauthorizedException.UnauthorizedExceptionReason;

public class ServiceEnvironment extends Environment
{
		        
	public void processAuthorization() throws UnauthorizedException
	{
		AuthFunction f = getRequestedFunction();
		if (f.isIdentified())
		{
			 if (getUserProfile() == null)
			    	throw new UnauthorizedException(UnauthorizedExceptionReason.userunknown, "userId is null");
			 
			 if (getUserProfile().isGuest())
			    	throw new UnauthorizedException(UnauthorizedExceptionReason.notinrole, "userId has not permissions");				 
		}
		
		if (!f.isPublic())
		{
		    if (getUserProfile() == null)
		    	throw new UnauthorizedException(UnauthorizedExceptionReason.userunknown, "userId is null");
		    
		    if (!getUserProfile().isInRole(getRequestSiteId(), f))
		    	throw new UnauthorizedException(UnauthorizedExceptionReason.notinrole, "userId has not permissions");
		}					
	}
	
    public static Cookie getCookie(HttpHeaders headers, String aName)
    {
   	 if (headers != null)
   	 {
   		 for(String cname : headers.getCookies().keySet())
   		 {
   			 if (cname.equalsIgnoreCase(aName))
   				 return headers.getCookies().get(cname);
   		 }
   	 }
   	 
   	 return null;
    }

	public static final String SENV_SITE = ServiceEnvironment.class.getName() + "targetsite";
	public static final String SENV_LANGUAGE = ServiceEnvironment.class.getName() + "targetlanguage";
	public static final String SENV_SCHEMEHOSTPORT = ServiceEnvironment.class.getName() + "schemehostport";
	public static final String SENV_SITEDOMAINID = ServiceEnvironment.class.getName() + "sitedomain";
	
	public Properties getProperties()
	{
		Properties serviceEnvProperties = new Properties();
		serviceEnvProperties.put(SENV_SITE, getRequestSiteId());
		serviceEnvProperties.put(SENV_LANGUAGE, getRequestLanguage());
		serviceEnvProperties.put(SENV_SITEDOMAINID, getRequestSiteDomain());
		serviceEnvProperties.put(SENV_SCHEMEHOSTPORT, getRequestSchemeHostPort());
		
		return serviceEnvProperties;
	}
	
}
