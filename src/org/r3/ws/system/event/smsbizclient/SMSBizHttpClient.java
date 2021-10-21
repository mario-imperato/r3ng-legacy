package org.r3.ws.system.event.smsbizclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.r3.system.util.SystemUtils;

public class SMSBizHttpClient extends SMSBizClient
{			
	private String smsLogin;
	private String smsPasswd;
	private String smsBizUrl;

	private DefaultHttpClient httpClient;	
    private HttpHost          smsBizHost;
	
    protected SMSBizHttpClient(String targetHost, int targetPort, String aUrl, String aSmsLogin, String aSmsPasswd)
    {
    	smsLogin = aSmsLogin;
    	smsPasswd = aSmsPasswd;
    	smsBizUrl = aUrl;
    	
    	smsBizClientLogger.info(String.format("Host is: http://%s:%d%s", targetHost, targetPort, aUrl));
    	smsBizHost = new HttpHost(targetHost, targetPort, "http");
    }
    
    public String getSmsLogin()
	{
		return smsLogin;
	}

	public String getSmsPasswd()
	{
		return smsPasswd;
	}

	public String getSmsBizUrl()
	{
		return smsBizUrl;
	}

	public HttpHost getSmsBizHost()
	{
		return smsBizHost;
	}

	private boolean isDumpHeaders()
    {
    	return true;
    }
    
    private boolean isDumpBody()
    {
    	return true;
    }
    
    public SMSBizClientResponse checkSMSCredits()
    {
    	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("login", getSmsLogin()));
        formparams.add(new BasicNameValuePair("password", getSmsPasswd()));
        formparams.add(new BasicNameValuePair("tipo", "2"));

    	SMSBizClientResponse response = invokeTheScript(getSmsBizUrl(), formparams);
    	
    	return response;
    }

	@Override
	public SMSBizClientResponse sendSMS(String mitt, String dest, String text, boolean notificaRicezione, boolean flashMode)
	{
    	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("login", getSmsLogin()));
        formparams.add(new BasicNameValuePair("password", getSmsPasswd()));
        formparams.add(new BasicNameValuePair("dest", dest));
        formparams.add(new BasicNameValuePair("testo", text));
        formparams.add(new BasicNameValuePair("mitt", mitt));        
        formparams.add(new BasicNameValuePair("tipo", "1"));

        if (notificaRicezione)
        	formparams.add(new BasicNameValuePair("status", "1"));

        if (flashMode)
        	formparams.add(new BasicNameValuePair("flash", "1"));
        
    	SMSBizClientResponse response = invokeTheScript(getSmsBizUrl(), formparams);    	
    	return response;
	}

    public SMSBizClientResponse invokeTheScript(String aUrl, List<NameValuePair> formparams)
    {
    	SMSBizClientResponse reqResult = new SMSBizClientResponse();
    	
    	HttpEntity responseEntity = null;
        
        try
		{
        	smsBizClientLogger.info(String.format("Posting to %s", aUrl));

        	HttpPost httppost = new HttpPost(aUrl);
            setRequestHeaders(httppost, null);

//        	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
//            formparams.add(new BasicNameValuePair("txtCOG", ""));
//            formparams.add(new BasicNameValuePair("txtNOM", ""));
//            formparams.add(new BasicNameValuePair("txtCF", ""));
//            formparams.add(new BasicNameValuePair("txtTESS", aCardNumber));
//            formparams.add(new BasicNameValuePair("txtTATT", ""));
//            formparams.add(new BasicNameValuePair("txtZONA", ""));
//            formparams.add(new BasicNameValuePair("CMD", "Cerca"));
            
			if (isDumpHeaders())
				   dumpFormParams("invokeTheScript", formparams);
			
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "ISO-8859-1" /* "UTF-8" */);
            httppost.setEntity(entity);

			HttpResponse rsp = getHttpClient().execute(getSmsBizHost(), httppost);
			
			if (isDumpHeaders())
			   dumpHeaders("invokeTheScript", rsp);
			
			int statusCode = rsp.getStatusLine().getStatusCode();						
			if (statusCode == HttpStatus.SC_OK)
			{	
				responseEntity = rsp.getEntity();
				reqResult.initializeFromResponseBody(getBodyAsString(responseEntity));
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			reqResult.setStatus(SMSBizClientStatus.fail);
			reqResult.setErrorCode("EXC");
			reqResult.setErrorInfo("EXC", e.getMessage());
		}
		finally
		{
			if (responseEntity != null)
				try
				{
					EntityUtils.consume(responseEntity);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			
			this.close();
		}
		
		return reqResult;
    }
    
    private void setRequestHeaders(AbstractHttpMessage anHttpMessage, String aReferer)
    {    	
    	// anHttpMessage.setHeader("Keep-Alive", "115");
    	anHttpMessage.setHeader("Connection", "keep-alive");
    	anHttpMessage.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    	// anHttpMessage.setHeader("Accept-Encoding", "gzip, deflate");
    	anHttpMessage.setHeader("Accept-Language", "it-IT,it;q=0.8,en-US;q=0.5,en;q=0.3");
    	anHttpMessage.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0");    					    	
    	// anHttpMessage.setHeader("Host", "www.nsgateway.net");
    }


     
	private void dumpHeaders(String aRequestContext, HttpResponse rsp)
	{
		smsBizClientLogger.info("BOF Dump Headers For " + aRequestContext);
		smsBizClientLogger.info(" --> " + rsp.getStatusLine());
		
		HeaderIterator it = rsp.headerIterator();
		for( ; it.hasNext(); )
		{
			Header h = (Header)it.next();
			smsBizClientLogger.info(" --> " + h.getName() + " = " + h.getValue());
		}
		
		smsBizClientLogger.info("EOF Dump Headers For " + aRequestContext);
	}

    private String getBodyAsString(HttpEntity responseEntity)
	{
        StringBuilder stb = new StringBuilder();        
    	    	
    	BufferedReader bd = null;
        try
        {
             bd = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
             
             boolean rc = false;
             
             String line = bd.readLine();
             while(line != null)
             {
            	 stb.append(line);
            	 line = bd.readLine();
             }             
        }
		catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
        finally
        {
        	SystemUtils.close(bd);
        }
        
        return stb.toString();        
	}

	public HttpClient getHttpClient()
    {
        if (httpClient == null)
        {
        	httpClient = new DefaultHttpClient();
        	httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        	httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0) Gecko/20100101 Firefox/4.0");
        }
        return httpClient;
    }
	
	public void close()
	{
	     if (httpClient != null)
	    	   httpClient.getConnectionManager().shutdown();
	     
	     httpClient = null;
	}

	    
}
