package org.r3.system;

import org.r3.system.util.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemLogger
{
	private enum SystemLogLevel { info, trace, warn, debug, error };

	private Logger baseLogger; 
	
    public SystemLogger(Class<?> anObjectClass)
    {
        if (anObjectClass != null)
        	 baseLogger = LoggerFactory.getLogger(anObjectClass);
        else baseLogger = LoggerFactory.getLogger(SystemLogger.class);
    }

	public void debug(Class<?> objectClass, String aLoggedString, int stackTraceOffset)
	{		
		if (baseLogger.isDebugEnabled())
		{
			String c = getCategoryName(SystemLogLevel.debug, objectClass, stackTraceOffset);
			getLogger(c).debug(aLoggedString);	
		}		
	}

	public void debug(Class<?> objectClass, String aLoggedString)
	{		
		debug(objectClass, aLoggedString, 0);
	}

	public void info(Class<?> objectClass, String aLoggedString, int stackTraceOffset)
	{		
		if (baseLogger.isInfoEnabled())
		{
			String c = getCategoryName(SystemLogLevel.info, objectClass, stackTraceOffset);
			getLogger(c).info(aLoggedString);	
		}		
	}

	public void info(Class<?> objectClass, String aLoggedString)
	{		
		info(objectClass, aLoggedString, 0);
	}

	public void warn(Class<?> objectClass, String aLoggedString, int stackTraceOffset)
	{		
		if (baseLogger.isWarnEnabled())
		{
			String c = getCategoryName(SystemLogLevel.warn, objectClass, stackTraceOffset);
			getLogger(c).warn(aLoggedString);	
		}		
	}

	public void warn(Class<?> objectClass, String aLoggedString)
	{		
		warn(objectClass, aLoggedString, 0);
	}

	public void error(Class<?> objectClass, String aLoggedString, int stackTraceOffset)
	{		
		if (baseLogger.isErrorEnabled())
		{
			String c = getCategoryName(SystemLogLevel.warn, objectClass, stackTraceOffset);
			getLogger(c).error(aLoggedString);	
		}		
	}

	public void error(Class<?> objectClass, String aLoggedString)
	{		
		error(objectClass, aLoggedString, 0);
	}

	public void trace(Class<?> objectClass, String aLoggedString, int stackTraceOffset)
	{		
		if (baseLogger.isTraceEnabled())
		{
			String c = getCategoryName(SystemLogLevel.trace, objectClass, stackTraceOffset);
			getLogger(c).trace(aLoggedString);	
		}		
	}

	public void trace(Class<?> objectClass, String aLoggedString)
	{		
		trace(objectClass, aLoggedString, 0);
	}

	private Logger getLogger(String aCategoryName)
	{
	    return LoggerFactory.getLogger(aCategoryName);	
	}
	
	private String getCategoryName(SystemLogLevel logLevel, Class<?> objectClass, int stackTraceOffset)
	{
		String methodName = null;
		String categoryName = objectClass.getName();
	
		switch(logLevel)
		{
		case info:
			break;
		case trace:
			methodName = MethodUtils.methodName(stackTraceOffset + 2);
			categoryName = new StringBuilder(objectClass.getName()).append(".").append(methodName).toString();
			break;
		case warn:
			break;
		case debug:
			methodName = MethodUtils.methodName(stackTraceOffset + 2);
			categoryName = new StringBuilder(objectClass.getName()).append(".").append(methodName).toString();
			break;
		case error:
			break;			
		}
		
		return categoryName;
	}

}
