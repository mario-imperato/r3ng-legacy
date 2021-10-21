package org.r3.system;

import javax.servlet.http.HttpServletRequest;

import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.usercollection.UserCollectionDTO;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.site.SiteDTO;
import org.r3.db.system.site.SiteDTO.SiteProfile;
import org.r3.db.system.site.SiteLUT;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.struts.GWFHttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Environment
{
	protected static Logger logger = LoggerFactory.getLogger(Environment.class);

	private SiteDTO requestSite;
	private String requestLanguage;
	private String remoteHost;
	private int    remotePort;
	private String httpScheme;
	
	private WebAuthInfo authInfo;
	private AuthFunction requestedFunction;

	public boolean isSiteOfType(String aSiteType)
	{
		if (requestSite != null && requestSite.getSitetype().equalsIgnoreCase(aSiteType))
			return true;
		
		return false;
	}
	
	public boolean isDefaultSite()
	{
		if (requestSite == null || getRequestSiteId().equalsIgnoreCase("default"))
			return true;
		
		return false;
	}

	public boolean isRegattaSite()
	{
		if (requestSite != null && requestSite.getSitetype().equalsIgnoreCase("regatta"))
			return true;
		
		return false;		
	}
	
	public SiteProfile getSiteProfile()
	{
	    if (requestSite != null)
	    {
	    	return requestSite.getSiteprofile();	    	
	    }
	    
	    return SiteProfile.profilebase;
	}
	
	public WebAuthInfo getAuthInfo()
	{
		return authInfo;
	}

	public UserProfileViewDTO getUserProfile()
	{
		if (authInfo != null)
			return authInfo.getUserProfile();
		
		return null;
	}

	public UserCollectionDTO getUserCollectionDTO()
	{
		if (isGuest() || !PersistenceContext.getPersistenceContext().isMongoDbAvailable())
			return null;
		
		MongoPersistenceContext mpctx = PersistenceContext.getPersistenceContext().getMongoPersistenceContext();
		Datastore mongoDatastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		UserCollectionPersistence userCollectionPersistence = UserCollectionPersistence.createPersistenceObject(mpctx);
		return userCollectionPersistence.selectByUserid(mongoDatastore, getUserProfile().getUserid());
	}

	public String getServerName()
	{
		String s = remoteHost != null ? remoteHost.toLowerCase() : null;
		if (s != null && !s.startsWith("www") && !s.equalsIgnoreCase("localhost")) {
			return "www." + s;
		}
		
		return remoteHost;
	}
	
	public String getRequestSchemeHostPort()
	{
		StringBuilder stb = new StringBuilder();
		stb.append(httpScheme).append("://").append(remoteHost);
		if (remotePort != 80)
			stb.append(":").append(remotePort);
		
	    return stb.toString();	
	}
	
	public String getUsername()
	{
		UserProfileViewDTO u = getUserProfile();
		if (u != null)
			return u.getLastname();
		
		return "";
	}
	
	public boolean isGuest()
	{
		if (authInfo != null)
		{
			UserProfileViewDTO profileView = authInfo.getUserProfile(); 
			if (profileView != null && !profileView.isGuest())
			     return false;	
		}
		
		return true;
	}

	public void setAuthInfo(WebAuthInfo authInfo)
	{
		this.authInfo = authInfo;
	}

	public AuthFunction getRequestedFunction()
	{
		return requestedFunction;
	}

	public void setRequestedFunction(AuthFunction requestedFunction)
	{
		this.requestedFunction = requestedFunction;
	}

//	public void setRequestedFunction(String requestedFunction)
//	{
//		this.requestedFunction = new AuthFunction(requestedFunction);
//	}
//
//	public void setRequestedAuthorization(AuthFunction requestedAuthorization)
//	{
//		this.requestedFunction = requestedAuthorization;
//	}

	public void setRequestSite(SiteDTO requestSite)
	{
		this.requestSite = requestSite;
	}

	public SiteDTO getRequestSite()
	{
		return requestSite;
	}

	public void setRequestInfo(HttpServletRequest request)
	{
		setRequestInfo(request, GWFHttpUtils.getRequestSite(request),  GWFHttpUtils.getRequestLanguage(request));
	}

	public void setRequestInfo(HttpServletRequest request, String aSite, String aLanguage)
	{
		remoteHost = request.getServerName();
		remotePort = request.getServerPort();
		httpScheme = request.getScheme();
		
		setRequestSiteId(aSite);
		setRequestLanguage(aLanguage);
	}

	public String getRequestSiteId()
	{
		if (requestSite != null)
			return requestSite.getSite();
		
		return null;
	}

	public String getRequestSiteDomain()
	{
		if (requestSite != null)
			return requestSite.getSitedomain();
		
		return null;		
	}
	
	public String getRequestSiteCalendarId()
	{
		if (requestSite != null)
			return requestSite.getCalendarid();
		
		return null;		
	}
	
	public String getSiteresourcepath()
	{
		if (requestSite != null)
			return requestSite.getSiteresourcepath();
		
		return null;
	}	
	
	private void setRequestSiteId(String aSite)
	{
		SiteLUT siteLUT = (SiteLUT)LUTManager.getLUTManager().getLUT(LUTName.site, null);
		setRequestSite(siteLUT.getItem(aSite));	
	}
	
	public String getRequestLanguage()
	{
		return requestLanguage;
	}

	public void setRequestLanguage(String requestLanguage)
	{
		this.requestLanguage = requestLanguage;
	}

    public boolean checkFunction(String aDomain, String f)
    {
        if (authInfo == null)
            return false;
     
        if (aDomain == null)
        	aDomain = getRequestSiteId();
        
        return authInfo.getUserProfile().isInRole(aDomain, new AuthFunction(f));    	
    }
    
    public boolean checkFunction(String f)
    {
    	return checkFunction(null, f);
    }

    public boolean checkRole(String aDomain, String r)
    {
        if (authInfo == null)
            return false;
     
        if (aDomain == null)
        	aDomain = getRequestSiteId();
        
        return authInfo.getUserProfile().hasRole(aDomain, r);    	
    }
    
    public boolean checkRole(String f)
    {
    	return checkRole(null, f);
    }

    public boolean checkUser(String f)
    {
        if (authInfo == null)
            return false;

        return authInfo.getUserProfile().getUserid().equalsIgnoreCase(f);
    }

}
