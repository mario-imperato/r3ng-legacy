package org.r3.system.mail;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewDTO;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.queues.simplemail.MailRecipient;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;

public class SEV_CrewMemberChange_Notification extends MailNotification
{
	private SailApplicationDTO applicationDTO;
	private List<SailApplicationCrewMemberViewDTO> crewList;
	private String crewMemberId;
	
	public SEV_CrewMemberChange_Notification(VelocityTemplateModel aVelocityEngine, Properties aContextProperties, 
			SailApplicationDTO anApplicationDTO, List<SailApplicationCrewMemberViewDTO> aCrewList, String aCrewMemberId)
	{
		super(aVelocityEngine, aContextProperties);
		applicationDTO = anApplicationDTO;
		crewList = aCrewList;
		crewMemberId = aCrewMemberId;
	}	
	
	protected VelocityTemplateRenderer getVelocityTemplateRenderer(PersistenceContext pcfg, SqlSession aSession, String aTemplateName)
	{
		VelocityTemplateRenderer renderer = super.getVelocityTemplateRenderer(pcfg, aSession, aTemplateName);
		
		renderer.add("appObj", applicationDTO);		
		renderer.add("crewList", crewList);
		renderer.add("crewMemberId", crewMemberId);

		return renderer;
	}
	
	public void notify(PersistenceContext ctx, SqlSession aSession, String anEmail) throws Exception
	{        
		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, getTargetLanguage()); 
//        toMail = sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, "mail_sevcrewchange");
//        
//        // Se la mail non è configurata... ciao....
//        if (DTOBase.isEmpty(toMail))
//        	return ;        
        
        addRecipient(anEmail, MailRecipient.TO_RECIPIENT);
        
		VelocityTemplateRenderer renderer = getVelocityTemplateRenderer(ctx, aSession, "SailApplicationCrewChangeNotificationMailMessage");						
		setBody(renderer.mergeTemplate());        
		setSender(sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSFROM));
		setTitle(String.format("%s - Var. Equipaggio: %s - %s", applicationDTO.getEventid(), applicationDTO.getSailnumber(), applicationDTO.getYachtname()));		
        				
        String bccRecipient = sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSBCC);
        if (bccRecipient != null) {
        	addRecipient(bccRecipient, MailRecipient.BCC_RECIPIENT);
        }
                
        super.notify(ctx, aSession);	
	}

}

