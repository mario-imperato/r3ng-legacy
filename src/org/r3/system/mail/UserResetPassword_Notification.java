package org.r3.system.mail;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.queues.simplemail.MailRecipient;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.db.system.user.user.UserDTO;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;

public class UserResetPassword_Notification extends MailNotification
{
	private String userPassword;
	private List<UserDTO> listOfUsers;
	
	public UserResetPassword_Notification(VelocityTemplateModel aVelocityEngine, Properties aContextProperties, 
		List<UserDTO> listOfUsersDto, String aUserPassword)
	{
		super(aVelocityEngine, aContextProperties);
		listOfUsers = listOfUsersDto;
		userPassword = aUserPassword;		
	}	
	
	protected VelocityTemplateRenderer getVelocityTemplateRenderer(PersistenceContext pcfg, SqlSession aSession, String aTemplateName)
	{
		VelocityTemplateRenderer renderer = super.getVelocityTemplateRenderer(pcfg, aSession, aTemplateName);
		
		renderer.add("listOfUserObj", listOfUsers);
		renderer.add("userPassword", userPassword);
		
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
        
		VelocityTemplateRenderer renderer = getVelocityTemplateRenderer(ctx, aSession, "UserResetPasswordMailMessage");						
		setBody(renderer.mergeTemplate());        
		setSender(sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSFROM));
		setTitle(sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, SitePropertyDTO.RESETPWD_MAILTITLE));		
        				
        String bccRecipient = sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSBCC);
        if (bccRecipient != null) {
        	addRecipient(bccRecipient, MailRecipient.BCC_RECIPIENT);
        }
                
        super.notify(ctx, aSession);	
	}

}

