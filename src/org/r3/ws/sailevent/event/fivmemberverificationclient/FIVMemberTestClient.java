package org.r3.ws.sailevent.event.fivmemberverificationclient;

import org.r3.db.sailevent.fivmember.FIVMemberDTO;
import org.r3.system.util.TemporaryDirectory;
import org.r3.ws.sailevent.event.fivmemberverificationclient.RegattaCubedClient.HTTPRequestResult;



public class FIVMemberTestClient extends FIVMemberClient
{
	@Override
	public FIVMemberDTO retrieveFIVMemberInfoFromFIVSite(String aCardNumber)
	{		
		FIVMemberDTO fivMemberDataBean = getDataBeanFromPageInfo(getPageInfo(aCardNumber));	
		System.out.println(fivMemberDataBean);
		return fivMemberDataBean;
	}


	private HTTPRequestResult getPageInfo(String aCardNumber)
	{
		HTTPRequestResult pageInfo = new HTTPRequestResult();
		pageInfo.setReturnCode(true);
		
		pageInfo.addPageInfo("txtNOM", "MARIO ALESSANDRO");
		pageInfo.addPageInfo("txtNCIV", "32");
		pageInfo.addPageInfo("txtCIT", "ROMA");
		pageInfo.addPageInfo("hCFBloccato", "X");
		pageInfo.addPageInfo("txtPNAS", "PR");
		pageInfo.addPageInfo("txtCAP", "00199");
		pageInfo.addPageInfo("hStato", "A");
		pageInfo.addPageInfo("txtIND", "VIA SEBINO");
		pageInfo.addPageInfo("hNTESS", aCardNumber);
		pageInfo.addPageInfo("txtCOG", "IMPERATO");
		pageInfo.addPageInfo("hIDS", "03F6");
		pageInfo.addPageInfo("txtLNAS", "PARMA");
		pageInfo.addPageInfo("txtPRO", "RM");
		pageInfo.addPageInfo("txtSEX", "M");
		pageInfo.addPageInfo("hSocieta", "Club Nautico di Roma AssSportDil (1322/04)");
		pageInfo.addPageInfo("txtDNAS", "1962-11-21 00:00:00");
		pageInfo.addPageInfo("txtVISITA", "S");
		pageInfo.addPageInfo("hRinnovo", "2012-01-15 00:00:00");
		pageInfo.addPageInfo("txtSCAD", "2012-10-25 23:59:59");

		return pageInfo;
	}
	

	@Override
	public void close()
	{		
	}

	@Override
	public void setWorkDirectory(TemporaryDirectory aDirectory)
	{
	}

	@Override
	public void setLogHTTPResponses(boolean aFlag)
	{		
	}
	
}
