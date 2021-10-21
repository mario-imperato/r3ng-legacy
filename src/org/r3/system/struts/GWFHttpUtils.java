package org.r3.system.struts;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;

public class GWFHttpUtils
{
	public static boolean isAbsolute(String pathName)
	{
		if (pathName != null)
		{
			return pathName.toUpperCase().startsWith("HTTP");			
		}

		return false;
	}
	
	public static boolean isStrutsAction(String pathName)
	{
		if (pathName != null)
		{
			int ndx = pathName.indexOf('?');
			if (ndx >= 0)
			{
				pathName = pathName.substring(0, ndx);
			}

			return pathName.endsWith(GWFConstants.GWFServletMappingExtension);
		}

		return false;
	}

	public static boolean isJSPUrl(String pathName)
	{
		if (pathName != null)
		{
			int ndx = pathName.indexOf('?');
			if (ndx >= 0)
			{
				pathName = pathName.substring(0, ndx);
			}

			return pathName.endsWith(GWFConstants.JSPMappingExtension);
		}

		return false;
	}

	public static String getRequestUri(HttpServletRequest request)
	{
		String path = (String) request.getAttribute(Globals.ORIGINAL_URI_KEY);
		if (path == null)
			path = request.getServletPath();

		return path;
	}

	public static String getRequestSite(HttpServletRequest request)
	{
		String path = getRequestUri(request);

		StringTokenizer strTok = new StringTokenizer(path, "/");
		if (strTok.countTokens() <= 2)
			return null;

		return strTok.nextToken();
	}

	public static String getRequestLanguage(HttpServletRequest request)
	{
		String path = getRequestUri(request);

		StringTokenizer strTok = new StringTokenizer(path, "/");
		if (strTok.countTokens() <= 2)
			return null;

		strTok.nextToken();
		return strTok.nextToken();
	}

	public static String getRequestSiteAndLanguagePrefix(HttpServletRequest request)
	{
		String path = getRequestUri(request);

		StringTokenizer strTok = new StringTokenizer(path, "/");
		if (strTok.countTokens() <= 2)
			return null;

		StringBuilder stb = new StringBuilder();
		stb.append('/').append(strTok.nextToken()).append('/').append(strTok.nextToken());
		return stb.toString();
	}

	/**
	 * Parses the request ContextPath and returns the part of the application's
	 * name. The request URL has the format:
	 * 
	 * http://hostname/application_part/language/subcontext/action.act
	 * 
	 * 
	 * @param path
	 *            The request ContextPath.
	 * @return The application's name.
	 * @see javax.servlet.http.HttpServletRequest
	 * 
	 */
	public static String getApplication(HttpServletRequest request)
	{
		String path = request.getContextPath();

		// Check if the string is empty.
		//
		if (path == null)
			return null;

		String ret = new String(path.trim());
		if (ret.length() == 0)
			return null;

		// Look if the string starts with a slash.
		//
		if (!ret.startsWith("/"))
			return ret;

		// Cut the first char.
		//
		ret = ret.substring(1);
		if (ret.length() == 0)
			return null;

		return ret;
	}

	public static String getRelativePathToStaticContent(String aTheme, String aLanguage)
	{
		StringBuffer stb = new StringBuffer();
		stb.append("themes/").append(aTheme).append("/").append(aLanguage).append("/");
		return stb.toString();
	}

	public static String getApplicationSiteLanguagePrefixPath(HttpServletRequest request, String overrideSite, String overrideLanguage)
	{
		StringBuilder stb = new StringBuilder();
		stb.append('/').append(getApplication(request));
		
		if (overrideSite != null)
			  stb.append('/').append(overrideSite);
		else  stb.append('/').append(getRequestSite(request));

		if (overrideLanguage != null)
			stb.append('/').append(overrideLanguage);
		else			
		    stb.append('/').append(getRequestLanguage(request));
        
		return stb.toString();
	}

}
