package org.r3.ws.system.sms;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.ws.system.event.smsbizclient.SMSBizClient;
import org.r3.ws.system.event.smsbizclient.SMSBizClient.SMSBizClientResponse;

public class POST_GETSMSCredits extends ServicePattern
{
    private SMSActionForm actionForm;
    
	public POST_GETSMSCredits(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SMSActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SitePropertyPersistence sitePropertyPersistence =  SitePropertyPersistence.createPersistenceObject(pcfg, aSession);
		List<SitePropertyDTO> listOf = sitePropertyPersistence.selectPropertiesInPropertyScope(senv.getRequestSiteId(), SitePropertyDTO.SMS_SYSTEM_PKG, null, pcfg.getPersistenceConfigInfo());
		
		String smsUrl = null;
		String smsHost = null;
		int smsPort = 80;
		
		if (listOf != null)
		{
			for(SitePropertyDTO dto : listOf)
			{
				if (dto.getPropertykey().equalsIgnoreCase(SitePropertyDTO.SMS_URL))
				{
			        smsUrl = dto.getPropertyvalue();			        
				}
				
				if (dto.getPropertykey().equalsIgnoreCase(SitePropertyDTO.SMS_HOST))
				{
				        smsHost = dto.getPropertyvalue();			        
				}
				
				if (dto.getPropertykey().equalsIgnoreCase(SitePropertyDTO.SMS_PORT))
				{
			        smsPort = dto.getPropertyvalueAsInt();			        
				}					
			}
		}
				
	    ActorPersistence itemPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);	    
	    int numberOfActors = itemPersistence.countActors4InsertIntoSMS(senv.getRequestSiteId(), actionForm.getActorgroup(), pcfg.getPersistenceConfigInfo());
		
//		try
//		{
//			InetAddress a = InetAddress.getByName("www.federvela.it");
//			System.out.println("HostAddress is: " + a.getHostAddress());
//		}
//		catch (UnknownHostException e)
//		{
//			e.printStackTrace();
//		}
		
        SMSBizClient client = SMSBizClient.newInstance(smsHost, smsPort, smsUrl, actionForm.getSmslogin(), actionForm.getSmspasswd());
        SMSBizClientResponse response = client.checkSMSCredits();
        
        RestServiceDTO r = null;
		if (response.isSuccess())
		{
		    r = new RestServiceDTO(Status.ok, "RESTDTO_OK", "Success");
		    r.setCounter1(response.getResponseOccurrences());
		    r.setCounter2(numberOfActors);
		}
		else
		{
		    r = new RestServiceDTO(Status.fail, response.getErrorReason());
		}
		
		return r;
	}

}
