package org.r3.ws.sailevent.event.fivmemberverificationclient;

public class InputCheckBoxParser extends HtmlItemParser
{
    public InputCheckBoxParser(String aMatchingString, String aValuePattern)
    {
    	super(aMatchingString, aValuePattern);
    }

    @Override
    public boolean parse(String aLine)
    {
    	return false;
    }

}    
