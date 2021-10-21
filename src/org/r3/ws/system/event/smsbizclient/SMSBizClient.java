package org.r3.ws.system.event.smsbizclient;

import java.util.List;

import org.apache.http.NameValuePair;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.system.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SMSBizClient
{
	public static Logger smsBizClientLogger = LoggerFactory.getLogger(SMSBizClient.class.getName());	
	
	public enum SMSBizClientStatus { success, fail, unknown };
	
	public static class SMSBizClientProperties
	{
		public String smsUrl = null;
		public String smsHost = null;
		public int smsPort = 80;				
	}
	
	public static class SMSBizClientResponse
	{
		private SMSBizClientStatus status;
		private String             errorCode;
		private String             errorReason;
		
		private int                responseOccurrences;

		public SMSBizClientStatus getStatus()
		{
			return status;
		}

		public boolean isSuccess()
		{
		    return status != null && status == SMSBizClientStatus.success;	
		}
		
		public void setStatus(SMSBizClientStatus status)
		{
			this.status = status;
		}

		public String getErrorCode()
		{
			return errorCode;
		}

		public void setErrorCode(String errorCode)
		{
			this.errorCode = errorCode;
		}

		public String getErrorReason()
		{
			return errorReason;
		}

		public void setErrorReason(String errorReason)
		{
			this.errorReason = errorReason;
		}

		public int getResponseOccurrences()
		{
			return responseOccurrences;
		}

		public void setResponseOccurrences(int responseOccurrences)
		{
			this.responseOccurrences = responseOccurrences;
		}		
		
		public void initializeFromResponseBody(String contentBody)
		{
			smsBizClientLogger.info(String.format("SMSBiz Returning: [%s]", contentBody));
			
			String returnCode = null;
			String returnSpecification = null;
			
			int ndx = contentBody.indexOf(' ');
			if (ndx > 0)
			{
				 returnCode = contentBody.substring(0, ndx);
			}
			else returnCode = contentBody;

			returnSpecification = contentBody;			

			if (returnCode == null)
			{
				status = SMSBizClientStatus.unknown;
				setErrorInfo(returnCode, returnSpecification);
			}
			else
			{
			    if (returnCode.equalsIgnoreCase("OK"))
			    {
					status = SMSBizClientStatus.success;
					
					if (ndx > 0 && contentBody.length() > (ndx + 1))
				    	 returnSpecification = contentBody.substring(ndx + 1);				

					if (returnSpecification != null && StringUtils.isNumeric(returnSpecification))
					{
						responseOccurrences = Integer.parseInt(returnSpecification);						
					}
			    }
			    else
			    {
			    	status = SMSBizClientStatus.fail;
			    	setErrorInfo(returnCode, returnSpecification);
			    }
			}			
		}

		public void setErrorInfo(String returnCode, String returnSpecification)
		{
			if (returnCode != null && returnCode.length() > 8)
				returnCode = returnCode.substring(0, 8);

			if (returnSpecification != null && returnSpecification.length() > 255)
				returnCode = returnSpecification.substring(0, 255);
			
			errorCode = returnCode;
			errorReason = returnSpecification;			
		}
		
	}
	
    protected SMSBizClient()
    {
    }
        
    public abstract SMSBizClientResponse checkSMSCredits();       
    public abstract SMSBizClientResponse sendSMS(String mitt, String dest, String text, boolean notificaRicezione, boolean flashMode);       
    	
	public void close()
	{
	}
	
	public static SMSBizClient newInstance(String targetHost, int targetPort, String aUrl, String aSmsLogin, String aSmsPasswd)
	{
		SitePropertyLUT lut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, null);
		SitePropertyDTO gatewayName = lut.getItem(SitePropertyDTO.SiteIdentifier.__any__.toString(), SitePropertyDTO.SMS_SYSTEM_PKG, SitePropertyDTO.SMS_GATEWAYNAME);
		
		String aName = SitePropertyDTO.SMS_GATEWAYNAME_TEST;
		if (gatewayName != null)
			aName = gatewayName.getPropertyvalue();
		
		if (aName.equalsIgnoreCase(SitePropertyDTO.SMS_GATEWAYNAME_SMSBIZ))
		{
		     return new SMSBizHttpClient(targetHost, targetPort, aUrl, aSmsLogin, aSmsPasswd);			
		}
		else return new SMSBizDummyClient(targetHost, targetPort, aUrl, aSmsLogin, aSmsPasswd);
	}
	
    protected void dumpFormParams(String aRequestContext, List<NameValuePair> formparams)
    {
    	smsBizClientLogger.info("BOF Dump FormParams For "  + aRequestContext);
	    if (formparams != null)
	    {
	    	for(NameValuePair aValuePair : formparams)
	    	{
	    		smsBizClientLogger.info(" --> " + aValuePair.getName() + " = " + aValuePair.getValue());	
	    	}
	    }
	    smsBizClientLogger.info("EOF Dump FormParams For "  + aRequestContext);    	
    }
}
