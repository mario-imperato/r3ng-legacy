package org.r3.ws.sailevent.appcrewmember;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTO;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewPersistence;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.system.mail.SEV_CrewMemberChange_Notification;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public abstract class SailApplicationCrewMemberChangePattern extends ServicePattern
{	
	private VelocityTemplateModel velocityEngine;
	
	public SailApplicationCrewMemberChangePattern(ServletContext ctx, ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);
	}

	protected void notifyChange(PersistenceContext ctx, SqlSession aSession, String aSite, String anApplicationId, String aCrewMemberId) throws Exception
	{				
		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, this.getServiceEnvironment().getRequestLanguage()); 
        String toMail = sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, "mail_sevcrewchange");
        
        // Se la mail non è configurata... ciao....
        if (DTOBase.isEmpty(toMail))
        	return ;
                
		SailApplicationPersistence applicationPersistence = SailApplicationPersistence.createPersistenceObject(ctx, aSession);
		SailApplicationDTO applicationDTO = applicationPersistence.selectByEventidApplicationid(aSite, anApplicationId, ctx.getPersistenceConfigInfo());
		
		SailApplicationCrewMemberViewPersistence p = SailApplicationCrewMemberViewPersistence.createPersistenceObject(ctx, aSession);
		List<SailApplicationCrewMemberViewDTO> listOfItems = p.selectByEventidApplicationid(aSite, anApplicationId, ctx.getPersistenceConfigInfo());
		
		SEV_CrewMemberChange_Notification n1 = new SEV_CrewMemberChange_Notification(velocityEngine, this.getServiceEnvironment().getProperties(), applicationDTO, listOfItems, aCrewMemberId);
		n1.notify(ctx,  aSession, toMail);
		
//		VelocityTemplateRenderer renderer = velocityEngine.newRendererInstance("SailApplicationCrewChangeNotificationMailMessage", senv.getRequestSiteDomain());
//		renderer.add("senv", getServiceEnvironment());
//		renderer.add("appObj", applicationDTO);		
//		renderer.add("crewList", listOfItems);
//		renderer.add("crewMemberId", aCrewMemberId);
//		String messageBody = renderer.mergeTemplate();
//        		        
//		String messageTitle = String.format("%s - Var. Equipaggio: %s - %s", applicationDTO.getEventid(), applicationDTO.getSailnumber(), applicationDTO.getYachtname());		
//        notifyEvent(ctx, aSession, messageTitle, messageBody, toMail, null);
	}

//	private void notifyEvent(PersistenceContext ctx, SqlSession aSession, String messageTitle, String messageBody, String toRecipients, String bccs) throws Exception
//	{       
//		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, this.getServiceEnvironment().getRequestLanguage()); 
//        SimpleNotifier wm = new SimpleNotifier(); 
//
//        wm.setMessageSender(sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSFROM));
//        wm.setMessageTitle(messageTitle);
//
//        ArrayList<MailRecipient> listOfRecipients = new ArrayList<MailRecipient>();
//        String[] listOfEmails = toRecipients.split(";");
//        for(String email : listOfEmails)
//        {
//            MailRecipient recipient = MailRecipient.newRecipient(email, MailRecipient.TO_RECIPIENT);            
//            listOfRecipients.add(recipient);            	
//        }
//
//        String bccRecipient = bccs;
//        if (bccRecipient != null) 
//        {
//        	listOfEmails = bccRecipient.split(";");
//            for(String email : listOfEmails)
//            {
//            	MailRecipient recipient = MailRecipient.newRecipient(email, MailRecipient.BCC_RECIPIENT);            
//                listOfRecipients.add(recipient);            	
//            }        	            
//        }      
//        
//        wm.notify(ctx, aSession, senv.getRequestSiteId(), messageBody, listOfRecipients, null, 2);	
//	}
	
	
}
