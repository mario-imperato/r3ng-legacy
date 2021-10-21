package org.r3.ws.sailevent.event.fivmemberverificationclient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RinnovoDateParser extends HtmlItemParser
{
	private DateFormat       inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private DateFormat       outputDateFormat;
	private String           timeString;
	
    public RinnovoDateParser(String aMatchingString, String aValuePattern, DateFormat anOutputDateFormat)
    {
    	super(aMatchingString, aValuePattern);
    	outputDateFormat = anOutputDateFormat;
    	timeString = "00:00:00";
    }

    @Override
    public boolean parse(String aLine)
    {
    	String s = getInputTextValueFromLine(aLine, "value=\"");
    	if (s != null)
    	{
    		int ndx = aLine.lastIndexOf(' ');
    		if (ndx > 0)
    		{
    		   String dayPart = aLine.substring(ndx + 1);
    		   if (dayPart.length() < 3 || dayPart.length() > 5)
    			   return false;
    		   
    		   StringBuilder stb = new StringBuilder().append(dayPart).append("/").append(s);
    		   s = stb.toString();
    		}
    		
    		try
			{
				java.util.Date d = inputDateFormat.parse(s);				
				StringBuilder stb = new StringBuilder().append(outputDateFormat.format(d)).append(' ').append(timeString);
				s = stb.toString();
			}
			catch (ParseException e)
			{
				e.printStackTrace();
				s = null;
			}
    	}
    	setParsedValue(s);
    	
    	return false;
    }
    
    public static void main(String[] args)
    {
    	String line = "						<TD align=\"left\" height=\"30\" class=\"formData\">2012<input type=\"hidden\" name=\"hRinnovo\" value=\"2012\"><span class=\"formcaptionRO\">  il</span> 15/01";
    	
    	HtmlItemParser p = new RinnovoDateParser("hRinnovo", "value=\"", new SimpleDateFormat("yyyy-MM-dd"));
    	p.parse(line);
    	System.out.println(p.getParsedValue());
    }

}
