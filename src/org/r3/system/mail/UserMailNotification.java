package org.r3.system.mail;

import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.otp.OTPDTO;
import org.r3.db.system.queues.simplemail.MailRecipient;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.db.system.user.user.UserDTO;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;

public class UserMailNotification extends MailNotification
{
	private UserDTO user;
	private boolean otpRequired;
	
	public UserMailNotification(VelocityTemplateModel aVelocityEngine, Properties aContextProperties, UserDTO aUser, boolean oneTimePassword) 
	{
		super(aVelocityEngine, aContextProperties);
		user = aUser;
		addRecipient(user.getEmail(), MailRecipient.TO_RECIPIENT);
		
		otpRequired = oneTimePassword;
	}

	protected UserDTO getUser()
	{
		return user;
	}
	
	@Override
	protected VelocityTemplateRenderer getVelocityTemplateRenderer(PersistenceContext pcfg, SqlSession aSession, String aTemplateName)
	{
		VelocityTemplateRenderer renderer = super.getVelocityTemplateRenderer(pcfg, aSession, aTemplateName);
		
		renderer.add("userObj", user);
		
		OTPDTO otpDto = getOneTimePasswordDataBean(pcfg, aSession);
		if (otpDto != null)
			renderer.add("otpObj", otpDto);

		return renderer;
	}
	
	protected OTPDTO getOneTimePasswordDataBean(PersistenceContext pcfg, SqlSession aSession)
	{
		if (otpRequired)
			return getOneTimePasswordDataBean(pcfg, aSession, user.getUserid());
		
		return null;
	}

	protected void notify(PersistenceContext ctx, SqlSession aSession, String templateName, String mailTitlePropertyName) throws Exception
	{        
		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, getTargetLanguage()); 

		VelocityTemplateRenderer renderer = getVelocityTemplateRenderer(ctx, aSession, templateName);
						
		setBody(renderer.mergeTemplate());        
		setSender(sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSFROM));
		setTitle(sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, mailTitlePropertyName));		
  
        String bccRecipient = sitePropertyLut.getDtodescr(getTargetSite(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSBCC);
        if (bccRecipient != null) {
    		addRecipient(bccRecipient, MailRecipient.BCC_RECIPIENT);
        }
                
        super.notify(ctx, aSession);	
	}
	
}
