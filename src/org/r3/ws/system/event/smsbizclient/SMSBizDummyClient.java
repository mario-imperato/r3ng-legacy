package org.r3.ws.system.event.smsbizclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.r3.system.util.StringUtils;

public class SMSBizDummyClient extends SMSBizClient
{
	private SMSBizClientResponse defaultResponse;
	
	public SMSBizDummyClient(String targetHost, int targetPort, String aUrl, String aSmsLogin, String aSmsPasswd)
    {
		 smsBizClientLogger.info(String.format("Host is: http://%s:%d%s", targetHost, targetPort, aUrl));
		
         defaultResponse = 	new SMSBizClientResponse();
         defaultResponse.setStatus(SMSBizClientStatus.success);         
         defaultResponse.setErrorInfo("OK", "Messaggio Generico");
         defaultResponse.setResponseOccurrences(9999);
    }
    
	@Override
	public SMSBizClientResponse checkSMSCredits()
	{
		smsBizClientLogger.info("Doing Checking Credits");
		return defaultResponse;
	}

	@Override
	public SMSBizClientResponse sendSMS(String mitt, String dest, String text, boolean notificaRicezione, boolean flashMode)
	{
		smsBizClientLogger.info(String.format("Mitt: %s, Text: %s, Notifica: %b, Flash: %b, Dest: [%s]", mitt, text, notificaRicezione, flashMode, dest));
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("login", "fake"));
        formparams.add(new BasicNameValuePair("password", "fake"));
        formparams.add(new BasicNameValuePair("dest", dest));
        formparams.add(new BasicNameValuePair("testo", text));
        formparams.add(new BasicNameValuePair("mitt", mitt));        
        formparams.add(new BasicNameValuePair("tipo", "1"));

        if (notificaRicezione)
        	formparams.add(new BasicNameValuePair("status", "1"));

        if (flashMode)
        	formparams.add(new BasicNameValuePair("flash", "1"));
        
        dumpFormParams("invokeTheScript", formparams);
        
        try
		{
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "ISO-8859-1" /* "UTF-8" */);
			smsBizClientLogger.info(String.format("UrlEncodedFormEntity: %s", StringUtils.getStringFromInputStream(entity.getContent())));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        
		return defaultResponse;
	}

}
