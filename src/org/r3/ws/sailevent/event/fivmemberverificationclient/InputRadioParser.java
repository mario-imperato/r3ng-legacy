package org.r3.ws.sailevent.event.fivmemberverificationclient;

public class InputRadioParser extends HtmlItemParser
{
	public InputRadioParser(String aMatchingString, String aValuePattern)
    {
    	super(aMatchingString, aValuePattern);
    }
	
    @Override
    public boolean parse(String aLine)
    {
    	String s = getCheckedRadioValueFromLine(aLine, getValuePattern());
    	setParsedValue(s);
    	
    	return false;
    }
    
    public static void main(String[] args)
    {
    	String line = "						<TD align=\"left\" height=\"30\">M<input type=\"radio\" name=\"txtSEX\" height=\"25\"  value=\"M\" id=\"id1\" >&nbsp;F<input type=\"radio\" name=\"txtSEX\" height=\"25\"value=\"F\" id=\"id1\" checked>";
    	
    	HtmlItemParser p = new InputRadioParser("txtSEX", "value=\"");
    	p.parse(line);
    	System.out.println(p.getParsedValue());
    }
	
}

