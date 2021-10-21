package org.r3.ws.sailevent.event.fivmemberverificationclient;

public class InputTextParser extends HtmlItemParser
{
	
    public InputTextParser(String aMatchingString, String valuePattern)
    {
    	super(aMatchingString, valuePattern);
    }
    
    @Override
    public boolean parse(String aLine)
    {
    	String s = getInputTextValueFromLine(aLine, getValuePattern());
    	setParsedValue(s);
    	
    	return false;
    }
    
    public static void main(String[] args)
    {
    	String line = "						<TD align=\"left\" height=\"30\"><input height=\"25\" name=\"txtCOG\" maxlength=\"80\" size=\"20\" value=\"s\">";
    	
    	HtmlItemParser p = new InputTextParser("txtCOG", "value=\"");
    	p.parse(line);
    	System.out.println(p.getParsedValue());
    }
}
