package org.r3.ws.test;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.DebugTokenInfo;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;

public class RestFBTest
{
	private static final String R3_FBAPP = "253135905118260";
	private static final String R3_SECRET = "68e45144154bae4f5befd48559cae942";
	
	private static final String MY_ACCESS_TOKEN = "EAADmOcu0WDQBAFoM5KsZA9KkLZAXSZBD8RZB3l4PJMNcR4qZCpZCQGvNMCAEZBOMX0UZBMM0ZB81EMauYUKwXPKnk2Pf0qvsYvvvij4OSZCqaThrpG8WSXTZAZCvRgVxV7B5bsNezvvNYZBehOcpzoaVbk4PK6FIJu5mWMSHVax1OtRxLJAZDZD";

	public RestFBTest()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		// You'll want to initialize the bridge just once at app startup.
		// In a webapp, a good place to do this is ContextLoaderListener#contextInitialized()
		// SLF4JBridgeHandler.install();

		try {
		  FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN, Version.LATEST);
		  // FacebookClient facebookClient = new DefaultFacebookClient(R3_FBAPP, R3_SECRET, Version.LATEST);
		  DebugTokenInfo debugToken = facebookClient.debugToken(MY_ACCESS_TOKEN);
			
//		  // You'll notice that logging statements from this call are bridged from java.util.logging to Log4j
		  // facebookClient.fetchObject("debug_token", DebugTokenInfo.class, Parameter.with("input_token", MY_ACCESS_TOKEN), Parameter.with("access_token", MY_ACCESS_TOKEN));
		  System.out.println(debugToken);
		  
		  User user = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "first_name,last_name,email"));
		  System.out.println(user);
		  // ...and of course this goes straight to Log4j

		} 
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally {
		  // Make sure to tear down when you're done using the bridge.
		  // In a webapp, a good place to do this is at Servlet Container shutdown time
		  // SLF4JBridgeHandler.uninstall();
		}
	}

}
