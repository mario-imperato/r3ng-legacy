package org.r3.system;

import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.db.system.user.usersession.UserSessionDTO;
import org.r3.system.UnauthorizedException.UnauthorizedExceptionReason;


public class WebAuthInfo
{
	public enum AuthInfo { unknown, httpheaderusernotfound, unepsession, httpheadersession, guestsession };
	
	public static WebAuthInfo unknownUser = new WebAuthInfo();
	
	private AuthInfo authInfoStatus;
	private UserProfileViewDTO userProfile;
	
	private String ipaddress;
    private boolean ipaddressmismatch;
    
	private String userSessionId;
	
	private String httpHeaderUserId;
	
    public WebAuthInfo()
    {
    	authInfoStatus = AuthInfo.unknown;
    }
        
	public String getHttpHeaderUserId()
	{
		return httpHeaderUserId;
	}

	public UserProfileViewDTO getUserProfile()
	{
		return userProfile;
	}

	public String getUserIdOrUserSessionId()
	{
		if (userProfile != null && !userProfile.isGuest())
		{
			return userProfile.getUserid();
		}
		
		return userSessionId != null ? userSessionId : "_NOUSID_";
	}
	
	public WebAuthInfo(AuthInfo a, UserSessionDTO aUserSessionDTO, UserProfileViewDTO userProfile, boolean ipMismatch)
	{
		this.userProfile = userProfile;
		authInfoStatus = a;
		ipaddress = aUserSessionDTO.getIpaddress();
		userSessionId = aUserSessionDTO.getSessionid();
		
		// Il consent dello userprofile subisce l'override del consent della sessione.		
		userProfile.setUserconsent(aUserSessionDTO.getConsentmode());		
	}

//	public void setHttpHeaderUserProfile(UserProfileViewDTO userProfile, String ipAddress, String aSessionId, boolean ipMismatch)
//	{
//		this.userProfile = userProfile;
//		authInfoStatus = AuthInfo.httpheadersession;
//		ipaddress = ipAddress;
//		ipaddressmismatch = ipMismatch;
//		userSessionId = aSessionId;
//		junepsessionid = aSessionId;
//	}

	public WebAuthInfo(AuthInfo a, String aNickname)
	{
		this.httpHeaderUserId = aNickname;
		authInfoStatus = a;
	}

	public AuthInfo getAuthInfoStatus()
	{
		return authInfoStatus;
	}

	public boolean isUserNotIdentified()
	{
	    return 	userProfile == null;
	}
	
	public UnauthorizedExceptionReason getUnauthorizedExceptionReason()
	{
		UnauthorizedExceptionReason r = null;
	    switch(authInfoStatus)
	    {
	    case unknown: r = UnauthorizedExceptionReason.userunknown; break;
	    case httpheaderusernotfound: r = UnauthorizedExceptionReason.usernotfound; break;
	    }
	    
	    return r;
	}
	
	public String getUserSessionId()
	{
		return userSessionId;
	}
	
//	public void setJunepsessionid(String junepsessionid)
//	{
//		this.junepsessionid = junepsessionid;
//	}
   
	public String getIpaddress()
	{
		return ipaddress;
	}

	public void setIpaddress(String ipaddress)
	{
		this.ipaddress = ipaddress;
	}

	public boolean isIpaddressmismatch()
	{
		return ipaddressmismatch;
	}

	public void setIpaddressmismatch(boolean ipaddressmismatch)
	{
		this.ipaddressmismatch = ipaddressmismatch;
	}

}
