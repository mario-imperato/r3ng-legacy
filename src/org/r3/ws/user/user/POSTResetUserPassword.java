package org.r3.ws.user.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.queues.simplemail.MailRecipient;
import org.r3.db.system.queues.simplemail.SimpleNotifier;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTO.PropertyScope;
import org.r3.db.system.siteproperty.SitePropertyLUT;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserFilter;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.mail.UserResetPassword_Notification;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.StringUtils;
import org.r3.system.util.velocity.VelocityTemplateModel;
import org.r3.system.util.velocity.VelocityTemplateRenderer;

public class POSTResetUserPassword  extends ServicePattern
{
	private VelocityTemplateModel velocityEngine;
    private UserActionForm actionForm;
    
	public POSTResetUserPassword(ServletContext ctx,  ServiceEnvironment serviceEnvironment, UserActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);
	}

	// 25/01/2017 14:32:18 - Inserito il rethrow della ServicePatternException
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		if (!actionForm.isSecuritycodeValid())
		{
			return new RestServiceDTO(Status.fail, "CAPTCHA_ERROR_001", "Codice di sicurezza non valido");
		}
				
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);

		UserFilter filterUserDTO = actionForm.getDTO4FilterUpdateResetPassword();

		List<UserDTO> listOfMatchedUsers = p.select(filterUserDTO, pcfg.getPersistenceConfigInfo());
		if (listOfMatchedUsers == null || listOfMatchedUsers.size() == 0)
			return new RestServiceDTO(Status.fail, "USR_ERROR_002", "Nessun utente associato all'email indicata");

		String newPassword = StringUtils.generateRandomPassword();
		UserDTO updateUserDTO = actionForm.getDTO4ResetPassword(newPassword);		
		int numberOfRows = p.update(updateUserDTO, filterUserDTO, pcfg.getPersistenceConfigInfo());
	    
	    try
		{			
	    	UserResetPassword_Notification n1 = new UserResetPassword_Notification(velocityEngine, this.getServiceEnvironment().getProperties(), listOfMatchedUsers, newPassword);
			n1.notify(pcfg,  aSession, actionForm.getEmail());
		    // sendResetPasswordMail(pcfg, aSession, actionForm.getEmail(), listOfMatchedUsers, newPassword);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}	    
	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);	    	    
		return RestServiceDTO.SuccessDTO;
	}

	private void sendResetPasswordMail(PersistenceContext ctx, SqlSession aSession, String targetEMail, List<UserDTO> listOfUsersDto, String userPassword) throws Exception
	{        
		VelocityTemplateRenderer renderer = velocityEngine.newRendererInstance( "UserResetPasswordMailMessage", senv.getRequestSiteDomain());
		renderer.add("listOfUserObj", listOfUsersDto);
		renderer.add("senv", getServiceEnvironment());
		renderer.add("userPassword", userPassword);
		
		String messageBody = renderer.mergeTemplate();
		
		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, this.getServiceEnvironment().getRequestLanguage()); 
        SimpleNotifier wm = new SimpleNotifier(); 

        wm.setMessageSender(sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSFROM));
        wm.setMessageTitle(sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.RESETPWD_MAILTITLE));

        MailRecipient recipient = MailRecipient.newRecipient(targetEMail, MailRecipient.TO_RECIPIENT);
        ArrayList<MailRecipient> listOfRecipients = new ArrayList<MailRecipient>();
        listOfRecipients.add(recipient);

        String bccRecipient = sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSBCC);
        if (bccRecipient != null) {
            recipient = MailRecipient.newRecipient(bccRecipient, MailRecipient.BCC_RECIPIENT);
            listOfRecipients.add(recipient);
        }

        wm.notify(ctx, aSession, senv.getRequestSiteId(), messageBody, listOfRecipients, null, 2);	
	}

}
