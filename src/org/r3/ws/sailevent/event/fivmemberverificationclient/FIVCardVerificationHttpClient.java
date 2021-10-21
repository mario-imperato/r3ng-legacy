package org.r3.ws.sailevent.event.fivmemberverificationclient;



import org.r3.db.sailevent.fivmember.FIVMemberDTO;
import org.r3.system.util.TemporaryDirectory;
import org.r3.ws.sailevent.event.fivmemberverificationclient.RegattaCubedClient.HTTPRequestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FIVCardVerificationHttpClient extends FIVMemberClient
{
	public static Logger crewVerificationLogger = LoggerFactory.getLogger(FIVCardVerificationHttpClient.class.getName());
	
	private enum ClientStatus { NOTCONNECTED, CONNECTIONFAILURE, CONNECTED };	
	
	private String yachtClubId;
	private String yachtClubPasswd;
	private ClientStatus clientStatus;
	private RegattaCubedClient fivHttpClient;
	
	public FIVCardVerificationHttpClient(String yachtClubFIVId, String yachtClubFIVPassword)
	{
		yachtClubId = yachtClubFIVId;
		yachtClubPasswd = yachtClubFIVPassword;
		clientStatus = ClientStatus.NOTCONNECTED;
		
		fivHttpClient = new RegattaCubedClient();
		fivHttpClient.setDumpHeaders(true);
		fivHttpClient.setDumpBody(false);
	}
	
	@Override
	public void setWorkDirectory(TemporaryDirectory aWorkDirectory)
	{		
		fivHttpClient.setDumpBodyDirectory(aWorkDirectory);
	}
	
	@Override
	public void setLogHTTPResponses(boolean aFlag)
	{		
		fivHttpClient.setDumpBody(aFlag);
	}

	@Override
	public FIVMemberDTO retrieveFIVMemberInfoFromFIVSite(String aCardNumber)
	{
		FIVMemberDTO resultDataBean = null;
		
		FIVCardVerificationHttpClient.crewVerificationLogger.info("### BOF - retrieveFIVMemberInfoFromFIVSite: " + aCardNumber);

		if (clientStatus == ClientStatus.NOTCONNECTED)
			connect(yachtClubId, yachtClubPasswd);
		
		if (clientStatus == ClientStatus.CONNECTED)		
		      resultDataBean = retrievemembershipDataBean(aCardNumber);
		
		FIVCardVerificationHttpClient.crewVerificationLogger.info("### EOF - retrieveFIVMemberInfoFromFIVSite - " + resultDataBean);
		return resultDataBean;
	}
	
	private void connect(String yachtClubFIVId, String yachtClubFIVPassword)
	{
		clientStatus = ClientStatus.CONNECTIONFAILURE;
		
        HTTPRequestResult reqResult = fivHttpClient.loginPage();
        FIVCardVerificationHttpClient.crewVerificationLogger.info("LoginPage: " + reqResult.isSuccess());
        
        if (reqResult.isSuccess())
        {
        	reqResult = fivHttpClient.login(yachtClubFIVId, yachtClubFIVPassword);
        	FIVCardVerificationHttpClient.crewVerificationLogger.info("Login: " + reqResult.isSuccess());
        }
        
        if (reqResult.isSuccess())
        {
        	clientStatus = ClientStatus.CONNECTED;
        }
	}

	private FIVMemberDTO retrievemembershipDataBean(String aCardNumber)
	{		
		FIVMemberDTO fivMemberDataBean = null;
		HTTPRequestResult reqResult = null;
		reqResult = fivHttpClient.getMembershipLinkToDetail(aCardNumber);
		if (reqResult.isSuccess())
		{
			FIVCardVerificationHttpClient.crewVerificationLogger.info("Link of Card[" + aCardNumber + "] is: " + reqResult.getLink2Follow());
			if (reqResult.getLink2Follow() != null)
			{
				reqResult = fivHttpClient.executeCardDetail(reqResult.getLink2Follow());
				String hNTESS = reqResult.getPageInfoParameter("hNTESS");
				if (hNTESS != null && hNTESS.equalsIgnoreCase(aCardNumber))
				{
					reqResult.setReturnCode(true);
					fivMemberDataBean = getDataBeanFromPageInfo(reqResult);	
				}
				else
				{
					reqResult.setReturnCode(false);
				}
			}
		}
			
		return fivMemberDataBean;
	}
	
	@Override
	public void close()
	{
	    if (clientStatus == ClientStatus.CONNECTED)
	    {
	    	fivHttpClient.logout();
	    }
	}
	
}
