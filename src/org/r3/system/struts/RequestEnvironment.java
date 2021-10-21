package org.r3.system.struts;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.db.system.user.userprofileview.UserProfileViewLUT;
import org.r3.db.system.user.usersession.UserSessionDTO;
import org.r3.db.system.user.usersession.UserSessionPersistence;
import org.r3.system.Environment;
import org.r3.system.R3Application;
import org.r3.system.WebAuthInfo;
import org.r3.system.WebAuthInfo.AuthInfo;
import org.r3.system.util.HttpRequestUtils;

public class RequestEnvironment extends Environment
{


	// private String requestContextPath;

	private boolean applicationCookieRequired;

	public boolean isApplicationCookieRequired()
	{
		return applicationCookieRequired;
	}

    public String getAppContext()
    {
    	return "r3ng";
    }
    
//	public String getRequestContextPath()
//	{
//		return requestContextPath;
//	}
//
//	public void setRequestContextPath(String requestContextPath)
//	{
//		this.requestContextPath = requestContextPath;
//	}

	public AuthInfo processUserIdentification(javax.servlet.http.HttpServletRequest servletRequest, HttpHeaders headers,
					boolean sessionCreate, boolean oneTimePasswordEnabled)
	{
		applicationCookieRequired = false;
		AuthInfo a = processIdentByOTP(servletRequest, headers, oneTimePasswordEnabled);
		if (a == AuthInfo.unknown)
		{
			a = processIdentByApplicationSessionId(servletRequest, headers);
			if (a == AuthInfo.unknown && sessionCreate)
			{
				a = processIdentByHTTPHeader(servletRequest, headers);
				if (a == AuthInfo.unknown)
				{
					a = processGuestLogin();
				}

				applicationCookieRequired = true;
			}
		}

		return a;
	}

	public AuthInfo processIdentByApplicationSessionId(javax.servlet.http.HttpServletRequest servletRequest, HttpHeaders headers)
	{
		String unepSessionId = HttpRequestUtils.getCookieValue(servletRequest, headers, R3Application.ApplicationCookieName);
		WebAuthInfo authInfo = getLoggedUser(unepSessionId);
		setAuthInfo(authInfo);
		return authInfo.getAuthInfoStatus();
	}

	public AuthInfo processIdentByHTTPHeader(javax.servlet.http.HttpServletRequest servletRequest, HttpHeaders headers)
	{
		String smSession = HttpRequestUtils.getCookieValue(servletRequest, headers, R3Application.SMCookieName);
		String userIdHeader = HttpRequestUtils.getRequestHeader(servletRequest, headers, R3Application.HTTPUseridHeaderName);

		WebAuthInfo authInfo = getUserByHTTPHeader(smSession, userIdHeader);
		switch (authInfo.getAuthInfoStatus())
		{
		case unknown:
			logger.debug(String.format("IAM user: UNKNOWN"));
			break;
		case httpheadersession:
			logger.debug(String.format("IAM userprofile: name=%s", authInfo.getUserProfile().getNickname()));
			break;
		case httpheaderusernotfound:
			logger.debug(String.format("IAM user: name=%s - NOTFOUND", authInfo.getHttpHeaderUserId()));
			break;
		}

		setAuthInfo(authInfo);
		return authInfo.getAuthInfoStatus();
	}

	public AuthInfo processIdentByOTP(javax.servlet.http.HttpServletRequest servletRequest, HttpHeaders headers, boolean enabled)
	{
		String otp = servletRequest.getParameter(GWFConstants.RequestOneTimePasswordParam);

		WebAuthInfo authInfo = WebAuthInfo.unknownUser;
		if (!enabled)
		{
			setAuthInfo(authInfo);
		}
		else
		{
			setAuthInfo(authInfo);
		}

		return authInfo.getAuthInfoStatus();
	}

	public AuthInfo processGuestLogin()
	{
		WebAuthInfo authInfo = loginUser(R3Application.GuestUserId);
		setAuthInfo(authInfo);
		return authInfo.getAuthInfoStatus();
	}

	private WebAuthInfo getLoggedUser(String unepSessionId)
	{
		WebAuthInfo authInfo = WebAuthInfo.unknownUser;

		if (unepSessionId != null)
		{
			logger.debug(String.format("%s found as %s", R3Application.ApplicationCookieName, unepSessionId));

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

	private WebAuthInfo getUserByHTTPHeader(String smSession, String aUserIdHeader)
	{
		return loginUser(aUserIdHeader);
	}

	private WebAuthInfo loginUser(String aNickname)
	{
		WebAuthInfo authInfo = WebAuthInfo.unknownUser;

		UserProfileViewDTO userProfileDTO = null;

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();

		if (aNickname != null)
		{
			String junepsessionid = null;
			try
			{
				UserPersistence userPersistence = UserPersistence.createPersistenceObject(pcfg, session);
				UserDTO userDTO = userPersistence.selectByNickname(aNickname, pcfg.getPersistenceConfigInfo());

				if (userDTO != null)
				{
					UserProfileViewLUT userProfileLUT = (UserProfileViewLUT) LUTManager.getLUTManager().getLUT(LUTName.userprofile, null);
					userProfileDTO = userProfileLUT.getItem(userDTO.getUserid(), true);

					UserSessionPersistence sessionPersistence = UserSessionPersistence.createPersistenceObject(pcfg, session);
					UserSessionDTO sessionDTO = new UserSessionDTO(userDTO);
					sessionPersistence.insert(sessionDTO, pcfg.getPersistenceConfigInfo());
					junepsessionid = sessionDTO.getSessionid();
					authInfo = new WebAuthInfo(AuthInfo.httpheadersession, sessionDTO, userProfileDTO, false);
				}
				else
					authInfo = new WebAuthInfo(AuthInfo.httpheaderusernotfound, aNickname);

				session.commit();
			}
			finally
			{
				session.close();
			}
		}

		return authInfo;
	}

	public javax.servlet.http.Cookie getHttpServletCookie(HttpServletRequest request)
	{
		javax.servlet.http.Cookie c = new javax.servlet.http.Cookie(R3Application.ApplicationCookieName, getAuthInfo().getUserSessionId());
		// On Some AS the setVersion Creates Problems....
		// c.setVersion(1);
		c.setPath(R3Application.ApplicationCookiePath);
		if (R3Application.ApplicationCookieDomain != null)
		    c.setDomain(R3Application.ApplicationCookieDomain);
		
		return c;
	}

	
	public void saveInstance(HttpServletRequest req)
	{
	    req.setAttribute("RequestEnv", this);
	}
	
	public static RequestEnvironment getInstance(HttpServletRequest req)
	{	
		Object o = req.getAttribute("RequestEnv");
		if (o != null)
			return (RequestEnvironment)o;
		
		return null;
	}

}
