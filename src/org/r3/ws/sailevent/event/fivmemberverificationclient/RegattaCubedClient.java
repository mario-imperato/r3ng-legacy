package org.r3.ws.sailevent.event.fivmemberverificationclient;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.r3.system.util.SystemUtils;
import org.r3.system.util.TemporaryDirectory;

public class RegattaCubedClient
{
	private static final boolean FIV_MODE = true;
	
/*	
	//private static final String TARGET_HOST = "www.gpagroup.it";
	private static final String FIV_TARGET_HOST = "localhost";
	private static final int    FIV_TARGET_PORT = 8080;
	private static final String FIV_LOGIN_PAGE_URL = "/regattacubed/default/it/login/login.do";
	private static final String FIV_LOGIN_PAGE_REFERER_URL = "/regattacubed/default/it/login/login.do";
	private static final String FIV_PaginaLoginTitle = "<title>Pagina di Log-in</title>";

	private static final String FIV_DO_LOGIN_URL = "/regattacubed/default/it/login/doLogin.do";
	private static final String FIV_DO_LOGIN_REFERER_URL = "/regattacubed/default/it/login/doLogin.do";
	private static final String FIV_doLoginPageTitle = "<title>Benvenuto</title>";

	private static final String FIV_DO_LOGOUT_URL = "http://www.gpagroup.it:8080/regattacubed/default/it/home/doLogout.do";
	private static final String FIV_DO_LOGOUT_REFERER_URL = "http://www.gpagroup.it:8080/regattacubed/default/it/home/doLogout.do";

	private static final String FIV_EXECUTE_SEARCH_URL = "None.do";
	private static final String FIV_EXECUTE_SEARCH_REFERER_URL = "none.do";
*/

	private static final String FIV_TARGET_HOST = "www.npcloud.it"; // "213.225.206.70";
	private static final int    FIV_TARGET_PORT = 80;
		
	private static final String FIV_LOGIN_PAGE_URL = "/fiv/Main.aspx?WCI=F_Login&WCE=N&WCU=01";
	private static final String FIV_LOGIN_PAGE_REFERER_URL = "www.npcloud.it"; // "http://213.225.206.70/fiv/";

	private static final String FIV_PaginaLoginTitle = "<title>FIV - Tesseramento Online</title>";
	
	
	private static final String FIV_DO_LOGIN_URL = "/fiv/main.aspx?WCI=F_Login&WCE=Login&WCU=01";
	private static final String FIV_DO_LOGIN_REFERER_URL = "http://www.npcloud.it/fiv/Main.aspx?WCI=F_Login&WCE=N&WCU=01"; // "http://213.225.206.70/fiv/Main.aspx?WCI=F_Login&WCE=N&WCU=01";
	private static final String FIV_doLoginPageTitle = "<title>Benvenuto</title>";
		
	private static final String FIV_SEARCH_PAGE_URL = "/fiv/main.aspx?WCI=F_Ricerca&WCU=01";
	private static final String FIV_SEARCH_PAGE_REFERER_URL = "http://www.npcloud.it/fiv/Main.aspx?WCI=M_Menu&WCU=01"; // "http://213.225.206.70/fiv/Main.aspx?WCI=M_Menu&WCU=01";
	
	private static final String FIV_EXECUTE_SEARCH_URL = "/fiv/Main.aspx?WCI=F_Ricerca&WCE=Invia&WCU=01";
	private static final String FIV_EXECUTE_SEARCH_REFERER_URL = "http://www.npcloud.it/fiv/main.aspx?WCI=F_Ricerca&WCU=01"; // "http://213.225.206.70/fiv/main.aspx?WCI=F_Ricerca&WCU=01";

	private static final String FIV_RETRIEVE_MEMBER_DETAIL_URL = "Dynamically Computed";
	private static final String FIV_RETRIEVE_MEMBER_DETAIL_REFERER_URL = "http://www.npcloud.it/fiv/Main.aspx?WCI=F_Ricerca&WCE=Invia&WCU=01"; // "http://213.225.206.70/fiv/Main.aspx?WCI=F_Ricerca&WCE=Invia&WCU=01";

	private static final String FIV_DO_LOGOUT_URL = "/fiv/main.aspx?WCI=Fine&WCU=01";
	private static final String FIV_DO_LOGOUT_REFERER_URL = "http://www.npcloud.it/fiv/Main.aspx?WCI=M_Menu&WCU=01"; // "http://213.225.206.70/fiv/Main.aspx?WCI=M_Menu&WCU=01";
						
    private DefaultHttpClient httpClient;
    private HttpHost          targetHost;
    private String            sessionCookie;
    private int               cookie_status = 1;
    
    private boolean dumpHeaders = false;
    private TemporaryDirectory  workDirectory = null;
    
    private boolean dumpBody    = false;
    
    public RegattaCubedClient(String hostName, int port, String protocolScheme)
    {
    	targetHost = new HttpHost(hostName, port, protocolScheme);	
    }

    public RegattaCubedClient()
    {
    	this(FIV_TARGET_HOST, FIV_TARGET_PORT, "http");	
    }

    private int fileCounter = 0;
    private File generateBodyLogFile(String fileNamePart)
    {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
        StringBuilder stb = 
        	new StringBuilder()
            .append(df.format(new java.util.Date()))
            .append(fileCounter++).append("_")
            .append(fileNamePart);
        
        File f = workDirectory.getFile(stb.toString());
        return f;
    }
    
    public void setDumpBodyDirectory(TemporaryDirectory aDirectory)
    {
    	workDirectory = aDirectory;
    }
    
    public boolean isDumpHeaders()
	{
		return dumpHeaders;
	}

	public void setDumpHeaders(boolean dumpHeaders)
	{
		this.dumpHeaders = dumpHeaders;
	}

	public boolean isDumpBody()
	{
		return dumpBody;
	}

	public void setDumpBody(boolean dumpBody)
	{
		this.dumpBody = dumpBody;
	}

	private HttpClient getHttpClient()
    {
        if (httpClient == null)
        {
        	httpClient = new DefaultHttpClient();
        	httpClient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
        	httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0) Gecko/20100101 Firefox/4.0");
        	// httpClient.getParams().setParameter("http.protocol.single-cookie-header", true);    
        	httpClient.getParams().setParameter(
        	        ClientPNames.COOKIE_POLICY, CookiePolicy.RFC_2965);
        }
        return httpClient;
    }
    
    public void close()
    {
       if (httpClient != null)
    	   httpClient.getConnectionManager().shutdown();
    }
    
    public boolean hasSessionCookie()
    {
       return sessionCookie != null;	
    }
    
    public String getSessionCookie()
    {
    	if (FIV_MODE)
    	{
    		StringBuilder stb = new StringBuilder().append("CookieStatus=").append(cookie_status++).append("; ").append(sessionCookie);
    		return stb.toString();
    	}
    	
    	return sessionCookie;
    }
    
    public static class HTTPRequestResult
    {
    	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	
        private boolean rc = false;
        private String  link2Follow = null;
        private HashMap<String, String> httpPageInfo;
		
        public HTTPRequestResult()
        {
            rc = false;	
        }
        
        public boolean isSuccess()
		{
			return rc;
		}
		
		public void setReturnCode(boolean rc)
		{
			this.rc = rc;
		}
		
		public String getLink2Follow()
		{
			return link2Follow;
		}
		
		public void setLink2Follow(String link2Follow)
		{
			this.link2Follow = link2Follow;
		}
		
		private HashMap<String, String> getHttpPageInfo()
		{
		    if (httpPageInfo == null)
		    	httpPageInfo = new HashMap<String, String>();
		    
			return httpPageInfo;
		}
		
		public void addPageInfo(String paramName, String paramValue)
		{
		    if (httpPageInfo == null)
		    	httpPageInfo = new HashMap<String, String>();
		    
		    httpPageInfo.put(paramName, paramValue);
		}      
		
		public String getPageInfoParameter(String paramName)
		{
			return getHttpPageInfo().get(paramName);
		}

		public java.sql.Timestamp getPageInfoParameterAsTimestamp(String paramName)
		{
			java.sql.Timestamp ts = null;
			
			String pValue = getHttpPageInfo().get(paramName);
			if (pValue != null)
			{
				try
				{
					ts = new java.sql.Timestamp(df.parse(pValue).getTime());
				}
				catch(Exception e)
				{
					ts = null;
				}
			}
			return ts;
		}
		
		public void dumpPageInfo()
		{
		    for( String k : getHttpPageInfo().keySet() )
		    {
		    	System.out.println("Key: " + k + " - Value: " + getHttpPageInfo().get(k));
		    }
		}

    }
        
    private HTTPRequestResult executeLoginPage(String aUrl, String theReferer)
    {
    	HTTPRequestResult reqResult = new HTTPRequestResult();
    	
        HttpGet req = new HttpGet(aUrl);
        setRequestHeaders(req, theReferer);
        
        HttpEntity responseEntity = null;
        
        try
		{
			HttpResponse rsp = getHttpClient().execute(targetHost, req);
			
			if (isDumpHeaders())
			   dumpHeaders("executeLoginPage", rsp);
			
			int statusCode = rsp.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK)
			{
				if (sessionCookie == null)
					sessionCookie = getCookieHeader(rsp);
								
				responseEntity = rsp.getEntity();
				if (matchStringInBody(responseEntity.getContent(), FIV_PaginaLoginTitle,  isDumpBody(), "executeLoginPage.txt"))
				{
					reqResult.setReturnCode(true);
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
		}
		
		return reqResult;
    }

    
    public HTTPRequestResult executeLogin(String aUrl, String theReferer, String aUserName, String aPassword)
    {
    	HTTPRequestResult reqResult = new HTTPRequestResult();
    	
        HttpEntity responseEntity = null;
        
        try
		{
            HttpPost httppost = new HttpPost(aUrl);
            setRequestHeaders(httppost, theReferer);

        	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("txtUTE", aUserName));  // "nickname"
            formparams.add(new BasicNameValuePair("txtPWD", aPassword)); // "password"
            
			if (isDumpHeaders())
				   dumpFormParams("executeLogin", formparams);

            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(entity);

			HttpResponse rsp = getHttpClient().execute(targetHost, httppost);
			
			if (isDumpHeaders())
			   dumpHeaders("executeLogin", rsp);
			
			int statusCode = rsp.getStatusLine().getStatusCode();
			
			reqResult.setReturnCode(false);
			if (statusCode == HttpStatus.SC_OK)
			{											
			responseEntity = rsp.getEntity();
			if (matchStringInBody(responseEntity.getContent(), FIV_doLoginPageTitle,  isDumpBody(), "executeLogin.txt"))
			{
				reqResult.setReturnCode(true);
			}						
			}			
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
		}
		
		return reqResult;
    }

    public HTTPRequestResult executeSearch(String aUrl, String theReferer, String aCardNumber)
    {
    	HTTPRequestResult reqResult = new HTTPRequestResult();
    	reqResult.setReturnCode(false);
    	
    	HttpEntity responseEntity = null;
        
        try
		{
            HttpPost httppost = new HttpPost(aUrl);
            setRequestHeaders(httppost, null);

        	List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("txtCOG", ""));
            formparams.add(new BasicNameValuePair("txtNOM", ""));
            formparams.add(new BasicNameValuePair("txtCF", ""));
            formparams.add(new BasicNameValuePair("txtTESS", aCardNumber));
            formparams.add(new BasicNameValuePair("txtTATT", ""));
            formparams.add(new BasicNameValuePair("txtZONA", ""));
            formparams.add(new BasicNameValuePair("CMD", "Cerca"));
            
			if (isDumpHeaders())
				   dumpFormParams("executeSearch", formparams);
			
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(entity);

			HttpResponse rsp = getHttpClient().execute(targetHost, httppost);
			
			if (isDumpHeaders())
			   dumpHeaders("executeSearch", rsp);
			
			int statusCode = rsp.getStatusLine().getStatusCode();
						
			if (statusCode == HttpStatus.SC_OK)
			{	
				reqResult.setReturnCode(true);
				responseEntity = rsp.getEntity();
				String linkDetail = findFIVCardLinkInBody(responseEntity.getContent(), aCardNumber,  isDumpBody(), "executeSearch.txt");
				if (linkDetail != null)
				{		
					reqResult.setLink2Follow(linkDetail);
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
		}
		
		return reqResult;
    }

    private HTTPRequestResult executeCardDetail(String aUrl, String theReferer)
    {
    	HTTPRequestResult reqResult = new HTTPRequestResult();
    	
        HttpGet req = new HttpGet(aUrl);
        setRequestHeaders(req, theReferer);
        
        HttpEntity responseEntity = null;
        
        try
		{
			HttpResponse rsp = getHttpClient().execute(targetHost, req);
			
			if (isDumpHeaders())
			   dumpHeaders("executeCardDetail", rsp);
			
			int statusCode = rsp.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK)
			{
				if (sessionCookie == null)
					sessionCookie = getCookieHeader(rsp);
								
				responseEntity = rsp.getEntity();
				FIVMemberCardParser parser = new FIVMemberCardParser();
				parser.parse(responseEntity.getContent(), isDumpBody(), generateBodyLogFile("executeCardDetail.txt"));
								
				reqResult = parser.getPageInfo();
				reqResult.dumpPageInfo();		
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
		}
		
		return reqResult;
    }

    private String findFIVCardLinkInBody(InputStream contentStream, final String aCardNumber, boolean dumpBodyFlag, String logFileName)
	{
		HttpResponseEntityFilter filter = new HttpResponseEntityFilter() 
		{
			private String matchingString = null;
			public boolean visit(String lineOfBody)
			{
				if (matchingString == null)
				{
				    matchingString = new StringBuilder()
				          .append("';\">").append(aCardNumber).append("</td>")
				          .toString();
				}
				
				int ndxEnd = lineOfBody.indexOf(matchingString);
				int ndxStart = lineOfBody.indexOf("Main.aspx?WCI=F_Nuovo&WCE=");
				if (ndxStart >= 0 && ndxEnd >= 0)					
				{
					StringBuilder linkdetail = new StringBuilder().append("/fiv/").append(lineOfBody.substring(ndxStart, ndxEnd));
					addInfo("FIVCardDetailLink", linkdetail.toString());
					returnCode = true;
					return false;
				}

				return true;
			}
		};
		
		if (filterBody(contentStream, filter, dumpBodyFlag, logFileName))
		{
			return filter.getPageInfo("FIVCardDetailLink");
    	}

		return null;
	}

    
	private HTTPRequestResult executeLogout(String aUrl, String aReferer)
    {
    	HTTPRequestResult reqResult = new HTTPRequestResult();
        
        HttpEntity responseEntity = null;
        
        try
		{
            HttpGet req = new HttpGet(aUrl);
            setRequestHeaders(req, aReferer);

            HttpResponse rsp = getHttpClient().execute(targetHost, req);
			
			if (isDumpHeaders())
			   dumpHeaders("executeLogout", rsp);
			
			responseEntity = rsp.getEntity();
			if (isDumpBody())
				dumpBody(responseEntity, "logout.txt");
			
			// Il codice è un redirect che in caso di GET forza il client a seguire automaticamente il link.
			int statusCode = rsp.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK)
			{
				reqResult.setReturnCode(true);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
		}
		
		return reqResult;
    }

	
		
	private boolean matchStringInBody(InputStream contentStream, final String aMatchingString, boolean dumpBodyFlag, String logFileName)
	{
		HttpResponseEntityFilter filter = new HttpResponseEntityFilter() 
		{
			public boolean visit(String lineOfBody)
			{
				if (lineOfBody.indexOf(aMatchingString) >= 0)
				{
					returnCode = true;
					return false;
				}

				return true;
			}
		};
		
		return filterBody(contentStream, filter, dumpBodyFlag, logFileName);
	}
    
    private boolean filterBody(InputStream contentStream, HttpResponseEntityFilter aFilter, boolean dumpBodyFlag, String logFileName)
	{
        boolean keepVisiting = true;        
    	BufferedReader bd = null;    
    	PrintWriter prt = null;
    	File outFile = null;
    	
    	if (dumpBodyFlag)
    	{
    		outFile = generateBodyLogFile(logFileName);	
    	}
    	     	
        try
        {
             bd = new BufferedReader(new InputStreamReader(contentStream));
             
         	if (dumpBodyFlag)
                 prt = new PrintWriter(new FileWriter(outFile));
                          
             String line = bd.readLine();
             while(line != null)
             {            	
            	 if (!keepVisiting)
            	 {
            		 if (!dumpBodyFlag)
            			 return aFilter.isSuccess();
            	 }
            	 keepVisiting = aFilter.visit(line);
	
            	 if (dumpBodyFlag)
            		 prt.println(line);
            	 
            	 line = bd.readLine();
             }
             
             return aFilter.isSuccess();
        }
		catch (Exception e)
		{
			e.printStackTrace();
		}
        finally
        {
        	SystemUtils.close(bd);
        	SystemUtils.close(prt);
        }
        
		return false;
	}

    private void dumpBody(HttpEntity responseEntity, String targetFileName)
	{
    	System.out.println();
    	
    	File outFile = generateBodyLogFile(targetFileName);
    	
    	BufferedReader bd = null;
    	PrintWriter prt = null;
        try
        {
             bd = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
             prt = new PrintWriter(new FileWriter(outFile));
             
             boolean rc = false;
             
             String line = bd.readLine();
             while(line != null)
             {
          		 prt.println(line);            	 
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
        	SystemUtils.close(prt);
        }
        
	}

    private void dumpFormParams(String aRequestContext, List<NameValuePair> formparams)
    {
		FIVCardVerificationHttpClient.crewVerificationLogger.info("BOF Dump FormParams For "  + aRequestContext);
	    if (formparams != null)
	    {
	    	for(NameValuePair aValuePair : formparams)
	    	{
	    		FIVCardVerificationHttpClient.crewVerificationLogger.info(" --> " + aValuePair.getName() + " = " + aValuePair.getValue());	
	    	}
	    }
		FIVCardVerificationHttpClient.crewVerificationLogger.info("EOF Dump FormParams For "  + aRequestContext);    	
    }
     
	private void dumpHeaders(String aRequestContext, HttpResponse rsp)
	{
		FIVCardVerificationHttpClient.crewVerificationLogger.info("BOF Dump Headers For " + aRequestContext);
		FIVCardVerificationHttpClient.crewVerificationLogger.info(" --> " + rsp.getStatusLine());
		
		HeaderIterator it = rsp.headerIterator();
		for( ; it.hasNext(); )
		{
			Header h = (Header)it.next();
			FIVCardVerificationHttpClient.crewVerificationLogger.info(" --> " + h.getName() + " = " + h.getValue());
		}
		
		FIVCardVerificationHttpClient.crewVerificationLogger.info("EOF Dump Headers For " + aRequestContext);
	}

    
	private String getCookieHeader(HttpResponse rsp)
    {
		HeaderElementIterator it = new BasicHeaderElementIterator(rsp.headerIterator("Set-Cookie"));
		if (it.hasNext()) 
		{
			HeaderElement elem = it.nextElement();
			StringBuilder stb = new StringBuilder().append(elem.getName()).append("=").append(elem.getValue());
			return stb.toString();
		}
		         	
    	return "";
    }
    
    private void setRequestHeaders(AbstractHttpMessage anHttpMessage, String aReferer)
    {
    	// anHttpMessage.getParams().setParameter("http.protocol.single-cookie-header", true);

    	anHttpMessage.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    	anHttpMessage.setHeader("Accept-Language", "it-it,it;q=0.8,en-us;q=0.5,en;q=0.3");
    	anHttpMessage.setHeader("Accept-Encoding", "gzip;q=0" /* "gzip, deflate" */);
    	anHttpMessage.setHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
    	
    	if (hasSessionCookie())
    	{
    		String cookie = getSessionCookie();
    		anHttpMessage.setHeader("Cookie", cookie);
    		FIVCardVerificationHttpClient.crewVerificationLogger.info(" --> " + "Setting Cookie to: [" + cookie + "]");
    		
    	}
    	
    	// anHttpMessage.setHeader("Keep-Alive", "115");
    	// anHttpMessage.setHeader("Connection", "keep-alive");
    	
    	if (aReferer != null)
    		anHttpMessage.setHeader("Referer", aReferer);    	
    }
    
    public HTTPRequestResult loginPage()
    {
    	FIVCardVerificationHttpClient.crewVerificationLogger.info(" --> " + FIV_LOGIN_PAGE_URL);
        return executeLoginPage(FIV_LOGIN_PAGE_URL, FIV_LOGIN_PAGE_REFERER_URL);	
    }

    public HTTPRequestResult login(String aUserId, String aPassword)
    {
    	return executeLogin(FIV_DO_LOGIN_URL, FIV_DO_LOGIN_REFERER_URL, aUserId, aPassword);
    }

    public HTTPRequestResult logout()
    {
        return executeLogout(FIV_DO_LOGOUT_URL, FIV_DO_LOGOUT_REFERER_URL);	
    }

    public HTTPRequestResult getMembershipLinkToDetail(String aCardNumber)
    {
    	return executeSearch(FIV_EXECUTE_SEARCH_URL, FIV_EXECUTE_SEARCH_REFERER_URL, aCardNumber);
    }

    public HTTPRequestResult executeCardDetail(String detailUrl)
    {
    	return executeCardDetail(detailUrl, FIV_RETRIEVE_MEMBER_DETAIL_REFERER_URL);
    }

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException
	{
        RegattaCubedClient reg = new RegattaCubedClient();
        reg.setDumpHeaders(true);
        reg.setDumpBody(false);
        HTTPRequestResult reqResult = reg.loginPage();
        
        if (reqResult.isSuccess())
        {
        	reqResult = reg.login("root", "sprint");
        }
        
        if (false)
        {
        	reqResult = reg.getMembershipLinkToDetail("724926");
        }
        
        if (reqResult.isSuccess())
        {
        	reqResult = reg.logout();
        }
        
        System.out.println("Result of WorkFlow: " + reqResult.isSuccess());
        
        FileInputStream fin = null;
        try
        {
        	fin = new FileInputStream("Z:\\DiscoF\\shuttle\\temp\\Sito_FIV_tessere\\response_4.txt");
        	String link = reg.findFIVCardLinkInBody(fin, "724926", false, "executeSearch.txt");
        	System.out.println("Link is: --" + link + "--");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	SystemUtils.close(fin);
        }
                
	}
	    
}
