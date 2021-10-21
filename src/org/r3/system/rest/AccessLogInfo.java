package org.r3.system.rest;

import java.lang.annotation.Annotation;
import java.util.HashMap;

public class AccessLogInfo
{
	private long startTimeInMillis;
	private String methodName;
	private String servicePath;
	private String methodPath;
	private String httpMethod;

	private HashMap<String, Object>  params;
	
	private enum AccessLogAnnotations {
		Path, POST, GET, PUT, DELETE, Produces, Consumes, Unknown, RestServiceMeta
	};

	public AccessLogInfo(String aMethodName, Annotation[] classAnnotations, Annotation[] methodAnnotations)
	{
		params = null;
		
		startTimeInMillis = new java.util.Date().getTime();

		methodName = aMethodName;
		if (classAnnotations != null)
			processClassAnnotations(classAnnotations);

		if (methodAnnotations != null)
			processMethodAnnotations(methodAnnotations);
	}

	public void pushParam(String paramName, Object aParam)
	{
	    if (params == null)
	    	params = new HashMap<String, Object>();
	    
	    params.put(paramName, aParam);
	}

	public String start()
	{
	    StringBuilder stb = new StringBuilder();
	    
	    if (httpMethod != null)
	         stb.append(httpMethod).append(" ");
	    
	    if (servicePath != null)
	    {
	    	 stb.append(servicePath);
	    	 if (!servicePath.endsWith("/"))
	    	 {
	    		 stb.append("/");
	    	 }
	    }
	    
	    if (methodPath != null)
	    {
	    	if (methodPath.charAt(0) == '/')
	    	{
	    		stb.append(methodPath.substring(1));
	    	}
	    	else 
	    	{
	    		stb.append(methodPath);
	    	}
	    }
	    	    
	    if (methodName != null)
	    {
	        stb.append(" - ::").append(methodName);
	    }
	
	    if (params != null)
	    {
	        stb.append("(...");
	        for(String pName : params.keySet())
	        {
	        	stb.append(", ").append(pName).append("=").append(params.get(pName).toString());
	        }
	        stb.append(")");
	    }

	    return stb.toString();
	}

	public String close()
	{
	    StringBuilder stb = new StringBuilder();
	    
	    if (httpMethod != null)
	         stb.append(httpMethod).append(" ");
	    
	    if (servicePath != null)
	    {
	    	 stb.append(servicePath);
	    	 if (!servicePath.endsWith("/"))
	    	 {
	    		 stb.append("/");
	    	 }
	    }
	    
	    if (methodPath != null)
	    {
	    	if (methodPath.charAt(0) == '/')
	    	{
	    		stb.append(methodPath.substring(1));
	    	}
	    	else 
	    	{
	    		stb.append(methodPath);
	    	}
	    }
	    
	    long endTimeInMillis = new java.util.Date().getTime();
	    
	    stb.append(" PTime(ms): ").append(endTimeInMillis - startTimeInMillis);
	    
	    if (methodName != null)
	    {
	        stb.append(" - ::").append(methodName);
	    }
	
	    if (params != null)
	    {
	        stb.append("(...");
	        for(String pName : params.keySet())
	        {
	        	stb.append(", ").append(pName).append("=").append(params.get(pName).toString());
	        }
	        stb.append(")");
	    }

	    return stb.toString();
	}
	
	private void processMethodAnnotations(Annotation[] listOf)
	{
		for (Annotation a : listOf)
		{
			switch (getAnnotationType(a))
			{
			case Path:
				methodPath = ((javax.ws.rs.Path) a).value();
				break;
			case POST:
				httpMethod = "POST";
				break;
			case GET:
				httpMethod = "GET";
				break;

			case PUT:
				httpMethod = "PUT";
				break;
			case DELETE:
				httpMethod = "DELETE";
				break;
			case Produces:
				break;
			case Consumes:
				break;
			case Unknown:
				break;
			}
		}
	}

	private void processClassAnnotations(Annotation[] listOf)
	{
		for (Annotation a : listOf)
		{
			switch (getAnnotationType(a))
			{
			case Path:
				servicePath = ((javax.ws.rs.Path) a).value();
				break;
			case Unknown:
				break;
			}
		}
	}

	private AccessLogAnnotations getAnnotationType(Annotation a)
	{
		AccessLogAnnotations t = AccessLogAnnotations.Unknown;
		String aType = a.annotationType().getName();
		int ndx = aType.lastIndexOf('.');
		if (ndx >= 0)
		{
			aType = aType.substring(ndx + 1);
			try
			{
				t = AccessLogAnnotations.valueOf(aType);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		return t;
	}
}
