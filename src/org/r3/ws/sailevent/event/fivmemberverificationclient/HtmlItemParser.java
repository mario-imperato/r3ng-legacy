package org.r3.ws.sailevent.event.fivmemberverificationclient;

public abstract class HtmlItemParser
{
	private String fieldName;
	private String matchingPattern;
	private String valuePattern;
	private String parsedValue;
	
    public HtmlItemParser(String aFieldName, String aValuePattern)
    {
        fieldName = aFieldName;
        matchingPattern = new StringBuilder().append("name=\"").append(aFieldName).append("\"").toString();
        valuePattern = aValuePattern;
    }
    
    public abstract boolean parse(String aLine);
    
    public String getFieldName()
    {
    	return fieldName;
    }
    
    protected String getValuePattern()
    {
    	return valuePattern;
    }
    
    protected String getMatchingPattern()
    {
    	return matchingPattern;
    }

	public String getParsedValue()
	{
		return parsedValue;
	}

	public void setParsedValue(String parsedValue)
	{
		if (parsedValue != null && parsedValue.length() == 0)
			 this.parsedValue = null;
		else this.parsedValue = parsedValue;
	}
    
	protected String getInputTextValueFromLine(String aLine, String valuePattern)
	{
		int ndx = aLine.indexOf(getMatchingPattern());
    	if (ndx > 0)
    	{
    		int ndxStart = aLine.indexOf(valuePattern, ndx);
    		if (ndxStart > 0)
    		{   			
    			ndxStart += valuePattern.length();
    			int ndxEnd = aLine.indexOf("\"", ndxStart);
    			if (ndxEnd >= ndxStart)
    				return aLine.substring(ndxStart, ndxEnd);
    		}
    	}
    	
    	return null;
	}

	protected String getOptionSelectedValueFromLine(String aLine, String valuePattern)
	{
		int ndx = aLine.indexOf(getMatchingPattern());
    	if (ndx > 0)
    	{
    		ndx = aLine.indexOf("<option selected", ndx);
    		if (ndx > 0)
    		{
    		int ndxStart = aLine.indexOf(valuePattern, ndx);
    		if (ndxStart > 0)
    		{   			
    			ndxStart += valuePattern.length();
    			int ndxEnd = aLine.indexOf("\"", ndxStart);
    			if (ndxEnd >= ndxStart)
    				return aLine.substring(ndxStart, ndxEnd);
    		}
    		}
    	}
    	
    	return null;
	}

	protected String getCheckedRadioValueFromLine(String aLine, String valuePattern)
	{
		int ndx = aLine.indexOf("checked");		
    	if (ndx > 0)
    	{
    		String reducedLine = aLine.substring(0, ndx);
    		ndx = reducedLine.lastIndexOf(getMatchingPattern());
    		if (ndx > 0)
    		{
    		int ndxStart = reducedLine.indexOf(valuePattern, ndx);
    		if (ndxStart > 0)
    		{   			
    			ndxStart += valuePattern.length();
    			int ndxEnd = reducedLine.indexOf("\"", ndxStart);
    			if (ndxEnd >= ndxStart)
    				return reducedLine.substring(ndxStart, ndxEnd);
    		}
    		}
    	}
    	
    	return null;
	}

}
