package org.r3.system.util;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.slf4j.Logger;

public class HttpRequestUtils
{
    public static String getCookieValue(HttpServletRequest request, HttpHeaders headers, String aName)
    {
    	javax.ws.rs.core.Cookie c1 = getCookie(headers, aName);
    	if (c1 != null)
    	{
    	    return c1.getValue();	
    	}
    	
    	javax.servlet.http.Cookie c2 = getCookie(request, aName);
    	if (c2 != null)
    	{
    		return c2.getValue();
    	}
    	    	
   	    return null;
    }
	
	public static javax.ws.rs.core.Cookie getCookie(HttpHeaders headers, String aName)
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
     
     public static javax.servlet.http.Cookie getCookie(HttpServletRequest request, String aName)
     {
    	 javax.servlet.http.Cookie[] cookies = request.getCookies();
    	 if (cookies != null && cookies.length > 0)
    	 {
    		 for(javax.servlet.http.Cookie ck : cookies)
    		 {
    			 if (ck.getName().equalsIgnoreCase(aName))
    				 return ck;
    		 }
    	 }
    	 
    	 return null;
     }
     
     public static String getRequestHeader(HttpServletRequest req, HttpHeaders headers, String aName)
     {
    	 String h = null;
    	 if (req != null)
    	 {
    		 h = getRequestHeader(req, aName);
    	 }
    	 
    	 if (h == null && headers != null)
    	 {
    	     h = getRequestHeader(headers, aName);	 
    	 }
    	 
    	 return h;
     }
     
     public static String getRequestHeader(HttpHeaders headers, String aName)
     {
    	String s = null;
     	List<String> userHeaders = headers.getRequestHeader(aName);
     	if (userHeaders != null && userHeaders.size() > 0)
     	{
     		s = userHeaders.get(0);
         	//logger.debug(String.format("IAM info: userid=%s", IAMUserid));        		
     	}
     	
     	return s;
     }

     public static String getRequestHeader(HttpServletRequest req, String aName)
     {
     	String header = req.getHeader(aName);     	
     	return header;
     }

     public static void snoopHeaders(Logger aLogger, HttpHeaders headers)
     {
    	 MultivaluedMap<String, String> userMapHeaders = headers.getRequestHeaders();
			for(String headerName : userMapHeaders.keySet())
			{
				List<String> hs = headers.getRequestHeader(headerName);
				for(String p : hs)
				{
					aLogger.debug(String.format("Header: %s - %s", headerName, p));
				}
			}
     }

     public static void snoopHeaders(Logger aLogger, HttpServletRequest servletRequest)
     {
    	 Enumeration<String> userMapHeaders = servletRequest.getHeaderNames();
    	 if (userMapHeaders != null)
    	 {
			for( ; userMapHeaders.hasMoreElements(); )
			{
				String headerName = userMapHeaders.nextElement();
				String p = servletRequest.getHeader(headerName);
					aLogger.debug(String.format("Header: %s - %s", headerName, p));
			}
    	 }
     }

}