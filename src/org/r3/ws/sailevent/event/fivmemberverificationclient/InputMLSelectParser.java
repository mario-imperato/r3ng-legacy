package org.r3.ws.sailevent.event.fivmemberverificationclient;

public class InputMLSelectParser extends HtmlItemParser
{
    public InputMLSelectParser(String aMatchingString, String aValuePattern)
    {
    	super(aMatchingString, aValuePattern);
    }

    @Override
    public boolean parse(String aLine)
    {
    	return false;
    }

}    
