package org.r3.system.rest;



import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.db.system.user.userprofileview.UserProfileViewLUT;
import org.r3.db.system.user.usersession.UserSessionDTO;
import org.r3.db.system.user.usersession.UserSessionPersistence;
import org.r3.system.AuthFunction;
import org.r3.system.R3Application;
import org.r3.system.WebAuthInfo;
import org.r3.system.WebAuthInfo.AuthInfo;
import org.r3.system.util.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestService
{
	public enum OutputFormat { csv, json, sylk };
	
	private static Logger logger = LoggerFactory.getLogger(RestService.class);
		
	protected SqlSessionFactory getSessionFactory(javax.servlet.ServletContext ctx)
	{
		return (SqlSessionFactory) ctx.getAttribute("sqlSessionFactory");
	}

	private WebAuthInfo getLoggedUser(String unepSessionId)
	{
		WebAuthInfo authInfo = WebAuthInfo.unknownUser;

		if (unepSessionId != null)
		{
			logger.debug(String.format("%s found as ", R3Application.ApplicationCookieName, unepSessionId));

			PersistenceContext pcfg = PersistenceContext.getPersistenceContext();

			SqlSession session = pcfg.openSession();
			try
			{
				UserSessionPersistence sessionPersistence = UserSessionPersistence.createPersistenceObject(pcfg, session);
				UserSessionDTO sessionDTO = sessionPersistence.selectBySessionid(unepSessionId, pcfg.getPersistenceConfigInfo());

				if (sessionDTO != null)
				{
					UserProfileViewLUT userProfileLUT = (UserProfileViewLUT) LUTManager.getLUTManager().getLUT(LUTName.userprofile, null);
					UserProfileViewDTO userDto = userProfileLUT.getItem(sessionDTO.getUserid(), true);
					authInfo = new WebAuthInfo(AuthInfo.unepsession, sessionDTO, userDto, false);
					return authInfo;
				}
				else
					logger.debug("SessionDTO is NULL");

				session.commit();
			}
			finally
			{
				session.close();
			}
		}

		return authInfo;
	}

	private WebAuthInfo getLoggedUser(javax.servlet.ServletContext ctx, HttpHeaders headers)
	{
		Cookie c = ServiceEnvironment.getCookie(headers, R3Application.ApplicationCookieName);		
        if (c != null)
        {
           return getLoggedUser(c.getValue());	
        }
        
        return WebAuthInfo.unknownUser;
	}
		
	private RestServiceMeta getServiceAnnotatedContext(String aMethodName)
	{
		try
		{
			Method[] listOfMethods = this.getClass().getMethods();
			if (listOfMethods != null && listOfMethods.length > 0)
			{
				for(Method m : listOfMethods)
				{
					if (m.getName().equalsIgnoreCase(aMethodName))
					{
						RestServiceMeta serviceProperties = m.getAnnotation(RestServiceMeta.class);
						if (serviceProperties != null)
							return serviceProperties;
					}
				}
			}
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	private Method getMethodByName(String aMethodName)
	{
		try
		{
			Method[] listOfMethods = this.getClass().getMethods();
			if (listOfMethods != null && listOfMethods.length > 0)
			{
				for(Method m : listOfMethods)
				{
					if (m.getName().equalsIgnoreCase(aMethodName))
					{
						return m;
					}
				}
			}
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

//	private String getServiceFunction(String aRESTServiceName)
//	{
//		RestServiceMeta serviceProperties = getServiceAnnotatedContext(aRESTServiceName);
//		if (serviceProperties == null)
//		{
//			return AuthFunction.FunctionPub;
//		}
//		
//		return serviceProperties.function();		
//	}
	
	private AuthFunction getRequestedAuthorization(String aRESTServiceName)
	{
		RestServiceMeta serviceProperties = getServiceAnnotatedContext(aRESTServiceName);
		if (serviceProperties == null)
		{
			return AuthFunction.PublicAuthorization;
		}
		
		return new AuthFunction(serviceProperties.identified(), serviceProperties.function());		
	}
	
	protected ServiceEnvironment getServiceEnvironment(javax.servlet.ServletContext ctx, javax.servlet.http.HttpServletRequest servletRequest, HttpHeaders headers, String aSite, String aLanguage)
	{
		UserProfileViewDTO userProfile = null;
		ServiceEnvironment senv = new ServiceEnvironment();
		
		senv.setRequestInfo(servletRequest, aSite, aLanguage);
		
		WebAuthInfo authInfo = getLoggedUser(ctx, headers);
		senv.setAuthInfo(authInfo);
        
		String serviceName = MethodUtils.methodName(1);
        senv.setRequestedFunction(getRequestedAuthorization(serviceName));		
		
		return senv;
	}

	
	protected AccessLogInfo accessLogInfo()
	{
		String serviceName = MethodUtils.methodName(1);
		
		Annotation[] methodAnnotations  = null;
		
		Method m = getMethodByName(serviceName);
		if (m != null)
			methodAnnotations = m.getAnnotations();
		
		Annotation[] classAnnotations   = this.getClass().getAnnotations();
		AccessLogInfo a = new AccessLogInfo(serviceName, classAnnotations, methodAnnotations);
		return a;
	}
}
