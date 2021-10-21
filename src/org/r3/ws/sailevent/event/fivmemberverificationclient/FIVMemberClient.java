package org.r3.ws.sailevent.event.fivmemberverificationclient;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.PropertyConfigurator;
import org.r3.db.sailevent.fivmember.FIVMemberDTO;
import org.r3.db.sailevent.fivmember.FIVMemberDTO.CardNumberStatus;
import org.r3.system.util.TemporaryDirectory;
import org.r3.system.util.classLoadHelper.CascadingClassLoadHelper;
import org.r3.ws.sailevent.event.fivmemberverificationclient.RegattaCubedClient.HTTPRequestResult;



public abstract class FIVMemberClient
{
	public abstract FIVMemberDTO retrieveFIVMemberInfoFromFIVSite(String aCardNumber);
	public abstract void setWorkDirectory(TemporaryDirectory aDirectory);
	public abstract void setLogHTTPResponses(boolean aFlag);
	
	public abstract void close();
	
	protected FIVMemberDTO getDataBeanFromPageInfo(HTTPRequestResult reqResult)
	{
		FIVMemberDTO fivMemberDataBean = new FIVMemberDTO();				
		
		fivMemberDataBean.setCardnumber(reqResult.getPageInfoParameter("hNTESS"));

		java.util.Calendar calNow = java.util.Calendar.getInstance();
		fivMemberDataBean.setSystemcheckdate(new java.sql.Timestamp(calNow.getTimeInMillis()));
		
		java.sql.Timestamp renewalDate = reqResult.getPageInfoParameterAsTimestamp("hRinnovo");
		java.sql.Timestamp medicalExamExpirationDate = reqResult.getPageInfoParameterAsTimestamp("txtSCAD");
		fivMemberDataBean.setRenewaldate(renewalDate);
		fivMemberDataBean.setMedexamexpirationdate(medicalExamExpirationDate);
		fivMemberDataBean.setCardexpirationdate(getCardExpirationDate(renewalDate, medicalExamExpirationDate));
		
		fivMemberDataBean.setCardholdername(reqResult.getPageInfoParameter("txtNOM"));		
		fivMemberDataBean.setCardholderlastname(reqResult.getPageInfoParameter("txtCOG"));
		fivMemberDataBean.setSex(reqResult.getPageInfoParameter("txtSEX"));
		
		fivMemberDataBean.setYachtclub(reqResult.getPageInfoParameter("hSocieta"));
		fivMemberDataBean.setCity(reqResult.getPageInfoParameter("txtCIT"));
		fivMemberDataBean.setZipcode(reqResult.getPageInfoParameter("txtCAP"));
		fivMemberDataBean.setDistrict(reqResult.getPageInfoParameter("txtPRO"));
		fivMemberDataBean.setAddress(reqResult.getPageInfoParameter("txtIND"));
		fivMemberDataBean.setStreetnumber(reqResult.getPageInfoParameter("txtNCIV"));
		
		fivMemberDataBean.setBirthdate(reqResult.getPageInfoParameter("txtDNAS"));
		fivMemberDataBean.setEmail(reqResult.getPageInfoParameter("txtEMAIL"));
		fivMemberDataBean.setPhone(reqResult.getPageInfoParameter("txtTEL"));
		fivMemberDataBean.setCellular(reqResult.getPageInfoParameter("txtCEL"));
		
		fivMemberDataBean.setCardnumberstatuscode(CardNumberStatus.fiv_cn_exist.toString());
		
		return fivMemberDataBean;
	}
	
	private java.sql.Timestamp getCardExpirationDate(java.sql.Timestamp rinnovo, java.sql.Timestamp medicalExamExpiration)
	{
		java.util.Calendar calendarRinnovo = java.util.Calendar.getInstance();
		java.sql.Timestamp now = new java.sql.Timestamp(calendarRinnovo.getTimeInMillis());

		if (rinnovo == null || medicalExamExpiration == null)
			return now;
					
		calendarRinnovo.setTime(rinnovo);		
		calendarRinnovo.set(calendarRinnovo.get(Calendar.YEAR), 11, 31, 23, 59, 59);

		java.util.Calendar calendarMedicalExamExpiration = java.util.Calendar.getInstance();
		calendarMedicalExamExpiration.setTime(medicalExamExpiration);		
		
		java.sql.Timestamp earlierDate = null;
		if (calendarRinnovo.before(calendarMedicalExamExpiration))
		{
		     earlierDate = new java.sql.Timestamp(calendarRinnovo.getTimeInMillis());	
		}
		else earlierDate = new java.sql.Timestamp(calendarMedicalExamExpiration.getTimeInMillis());
		return earlierDate;
	}

	public static FIVMemberClient newClientInstance(String yachtClubFIVId, String yachtClubFIVPassword)
	{
		return new FIVCardVerificationHttpClient(yachtClubFIVId, yachtClubFIVPassword);
		// return new FIVMemberTestClient();
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException
	{
        URL logCfgFileUrl = CascadingClassLoadHelper.getInstance().getResource("resources/logger.properties");  
        if (logCfgFileUrl != null)
           PropertyConfigurator.configure(logCfgFileUrl);
        
        FIVMemberClient c = newClientInstance("1322", "clubnautico");
		c.setWorkDirectory(new TemporaryDirectory("C:/tmp/r3ng/", true));
		c.setLogHTTPResponses(true);
		
		try
		{
			c.retrieveFIVMemberInfoFromFIVSite("724926");
			c.retrieveFIVMemberInfoFromFIVSite("729823");
		}
		finally
		{
			c.close();
		}
	}

}
