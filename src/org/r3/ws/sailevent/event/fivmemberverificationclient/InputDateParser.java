package org.r3.ws.sailevent.event.fivmemberverificationclient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.r3.db.DTOBase;

public class InputDateParser extends HtmlItemParser
{
	private DateFormat       inputDateFormat;
	private DateFormat       outputDateFormat;
	private String           timeString;
	
    public InputDateParser(String aMatchingString, String aValuePattern, DateFormat anInputDateFormat, DateFormat anOutputDateFormat, String aTimeString)
    {
    	super(aMatchingString, aValuePattern);
    	inputDateFormat = anInputDateFormat;
    	outputDateFormat = anOutputDateFormat;
    	timeString = aTimeString;
    }

    @Override
    public boolean parse(String aLine)
    {
    	String s = DTOBase.nullOnEmpty(getInputTextValueFromLine(aLine, getValuePattern()));
    	if (s != null)
    	{
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
    	String line = "						<TD align=\"left\" height=\"30\"><input height=\"25\" name=\"txtDNAS\" maxlength=\"10\" size=\"12\" value=\"21/11/1962\">";
    	
    	HtmlItemParser p = new InputDateParser("txtDNAS", "value=\"", new SimpleDateFormat("dd/MM/yyyy"), new SimpleDateFormat("yyyy-MM-dd"), "00:00:00");
    	p.parse(line);
    	System.out.println(p.getParsedValue());
    }

}
