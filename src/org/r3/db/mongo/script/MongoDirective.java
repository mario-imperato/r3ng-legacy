package org.r3.db.mongo.script;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MongoDirective
{
    public enum MongoDirectiveType { 
    	none, insert, update, delete;
    	
        public static MongoDirectiveType getValue4(String s, MongoDirectiveType defaultValue)
        {
        	try
        	{
        		if (s != null && s.length() > 0)
        			return MongoDirectiveType.valueOf(s);
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        	return defaultValue;
        }
    };
    
    public static Pattern DEFAULT_PATTERN =  Pattern.compile("^\\[(insert)\\:(\\w*)\\]$");
    public static Pattern UPDATE_PATTERN =  Pattern.compile("^\\[(update)\\:(\\w*)\\]$");
    public static Pattern DELETE_PATTERN =  Pattern.compile("^\\[(delete)\\:(\\w*)\\]$");
    
    private MongoDirectiveType type;
    private String param;
    
	public MongoDirective(MongoDirectiveType aType, String aParam)
	{
		type = aType;
		param = aParam;
	}
	
	public static MongoDirective getMongoDirective(String aStatement)
	{		
		Pattern directivePattern = null;
		if (aStatement.startsWith("[insert"))
			directivePattern = DEFAULT_PATTERN;
		else if (aStatement.startsWith("[update"))
			directivePattern = UPDATE_PATTERN;
		else if (aStatement.startsWith("[delete"))
			directivePattern = DELETE_PATTERN;
			
		if (directivePattern != null)
			return  getMongoDirective(directivePattern, aStatement);
		
		return null;	
	}

	public static MongoDirective getMongoDirective(Pattern aPattern, String aStatement)
	{		
		 Matcher m = aPattern.matcher(aStatement);
		 
		 m.find();		
		 if (!m.matches())
			 return null;
		 
		 if (m.groupCount() <= 0)
			 return null;
		 
		 for(int i = 0; i <= m.groupCount(); i++)
			 System.out.println("Group - " + i + " - " + m.group(i));
		 
		 MongoDirectiveType t = MongoDirectiveType.getValue4(m.group(1), MongoDirectiveType.none);
		 if (t != MongoDirectiveType.none)
			 return new MongoDirective(t, m.group(2));
		 
		 return null;	
	}
	
	
	public MongoDirectiveType getType()
	{
		return type;
	}

	public String getParam()
	{
		return param;
	}

}
