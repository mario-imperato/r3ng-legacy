package org.r3.system;

public class R3Application
{
	public static final String ApplicationCookieName = "UNEPSESSIONID";
	public static final String ApplicationCookieDomain = null;
	public static final String ApplicationCookiePath = "/";   // "/r3ng"
	public static final String ApplicationCookieContext = "/r3ng";
	
	// 30gg meno un sec.. :-)
	public static final int    ApplicationCookieRememberMeMaxAge = 2591999;
	
	public static final String SMCookieName = "SMSESSION";
	public static final String HTTPUseridHeaderName = "USERID";
	public static final String GuestUserId = "guest";
	
	public static final boolean DMSPublicURLWWWvisible = false; 
	public static final String DMSPublicURLMountPoint  = "/r3ng/was/%s/%s/system/dms/document/PUB/%s";
	public static final String DMSPrivateURLMountPoint = "/r3ng/was/%s/%s/system/dms/%s";
	
	public static final String MongoDbFileUrlMountPoint = "/r3ng/was/%s/%s/system/mdbdms/%s";
	
	public R3Application()
	{
		
	}
	
	
}
