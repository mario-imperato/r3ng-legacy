package org.r3.system.social.facebook;

import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO.SiteIdentifier;
import org.r3.db.system.siteproperty.SitePropertyLUT;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.FacebookClient.DebugTokenInfo;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.GraphResponse;
import com.restfb.types.User;

public class AppInfo
{
	private String appSecret;
	private String appId;
	private String appName;
	
	public AppInfo()
	{
		
	}

	public String getAppSecret()
	{
		return appSecret;
	}

	public void setAppSecret(String appSecret)
	{
		this.appSecret = appSecret;
	}

	public String getAppId()
	{
		return appId;
	}

	public void setAppId(String appId)
	{
		this.appId = appId;
	}

	public String getAppName()
	{
		return appName;
	}

	public void setAppName(String appName)
	{
		this.appName = appName;
	}
	
	public static AppInfo retrieveAppInfo(String aServerName)
	{
		AppInfo retInfo = null;
		
		SitePropertyLUT sitePropertyLUT = (SitePropertyLUT) LUTManager.getLUTManager().getLUT(LUTName.siteproperty, null);

		SitePropertyDTO property = sitePropertyLUT.getItem(SiteIdentifier.__any__.toString(), SitePropertyDTO.FB_APPDOMAIN_PACKAGE, aServerName);
		if (property != null)
		{
			String serverNameFacebookAppPackageName = String.format(SitePropertyDTO.FB_SERVERNAME_FACEBOOKAPP_PACKAGE, property.getDtodescr());
			
			retInfo = new AppInfo();
			retInfo.setAppId(sitePropertyLUT.getDtodescr(SiteIdentifier.__any__.toString(), serverNameFacebookAppPackageName, SitePropertyDTO.FB_SERVERNAME_FACEBOOKAPP_APPID));
			retInfo.setAppName(sitePropertyLUT.getDtodescr(SiteIdentifier.__any__.toString(), serverNameFacebookAppPackageName, SitePropertyDTO.FB_SERVERNAME_FACEBOOKAPP_APPNAME));
			retInfo.setAppSecret(sitePropertyLUT.getDtodescr(SiteIdentifier.__any__.toString(), serverNameFacebookAppPackageName, SitePropertyDTO.FB_SERVERNAME_FACEBOOKAPP_APPSECRET));			
		}
		
		return retInfo;
	}

	public boolean isValid()
	{
		return appName != null && appId != null && appSecret != null;
	}
	
	public boolean verifyToken(String anAccessToken, String anFBUserId)
	{
		if (!isValid())
			return false;

		boolean verifyOK = true;
		FacebookClient authFacebookClient = new DefaultFacebookClient(Version.LATEST);
		AccessToken appToken = authFacebookClient.obtainAppAccessToken(appId, appSecret);

		FacebookClient appFacebookClient = new DefaultFacebookClient(appToken.getAccessToken(), Version.LATEST);
		DebugTokenInfo debugToken = appFacebookClient.debugToken(anAccessToken);

		String s;
		if (verifyOK && debugToken == null)
		{
				verifyOK = false;
		}

		if (verifyOK && !debugToken.isValid())
		{			
				verifyOK = false;
		}

		if (verifyOK)
		{
			s = debugToken.getAppId();
			if (!(s != null && s.equalsIgnoreCase(appId)))
				verifyOK = false;
		}

		if (verifyOK)
		{
			s = debugToken.getApplication();
			if (!(s != null && s.equalsIgnoreCase(appName)))
				verifyOK = false;
		}

		if (verifyOK && anFBUserId != null)
		{
			s = debugToken.getUserId();
			if (!(s != null && s.equalsIgnoreCase(anFBUserId)))
				verifyOK = false;
		}

		if (verifyOK)
		{
			FacebookClient facebookClient = new DefaultFacebookClient(anAccessToken, Version.LATEST);
			User user = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "first_name,last_name,email"));
			System.out.println(user);
		}

		return verifyOK;
	}
	
	public boolean post2FaceBookPage(String aPageId, String aPageToken, String aMessage)
	{
		FacebookClient facebookClient = new DefaultFacebookClient(aPageToken, Version.LATEST);
		GraphResponse publishMessageResponse =
				facebookClient.publish(aPageId + "/feed", GraphResponse.class, Parameter.with("message", aMessage));

		// 137508629631125_1287817174600259
		System.out.println("Published message ID: " + publishMessageResponse.getId());				
		return true;
	}

}
