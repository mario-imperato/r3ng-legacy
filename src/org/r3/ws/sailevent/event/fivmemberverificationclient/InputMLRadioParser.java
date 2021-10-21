package org.r3.ws.sailevent.event.fivmemberverificationclient;

public class InputMLRadioParser extends HtmlItemParser
{
    public InputMLRadioParser(String aMatchingString, String aValuePattern)
    {
    	super(aMatchingString, aValuePattern);
    }

    @Override
    public boolean parse(String aLine)
    {
    	return false;
    }

}    
