package org.r3.ws.user.user;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.usercollection.UserCollectionPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.mail.UserRegistration_Activated_Notification;
import org.r3.system.mail.UserRegistration_ActivationRequested_Notification;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class POSTUserRegistration  extends ServicePattern
{
	private VelocityTemplateModel velocityEngine;
    private UserActionForm actionForm;
    
	public POSTUserRegistration(ServletContext ctx,  ServiceEnvironment serviceEnvironment, UserActionForm anActionForm)
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
		UserDTO userDTO = p.selectByNickname(actionForm.getNickname(), pcfg.getPersistenceConfigInfo());
		if (userDTO != null)
			return new RestServiceDTO(Status.fail, "USR_ERROR_DUPUSER", "Utente gia' presente a sistema");
		
		// Verifico se esistono utenti con la stessa mail e stato attivo.
		List<UserDTO> l = p.selectByEMailRecstatus(actionForm.getEmail(), RecordStatus.sys_recact, pcfg.getPersistenceConfigInfo());
		if (l != null && l.size() > 0)
			return new RestServiceDTO(Status.fail, "USR_ERROR_DUPUSER", "Utente gia' presente a sistema");
					
		boolean immediateActivation = actionForm.isDirectActivation("1322");
		UserDTO dto1 = actionForm.getDTO4Registration(immediateActivation);
		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    	    
	    try
		{
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "UserRegistrationSQLScript");
							
			scriptPersistence.addParameter("userDTO", dto1);							
			scriptPersistence.execute(pcfg, aSession);

			if (!immediateActivation)
			{
				UserRegistration_ActivationRequested_Notification n = new UserRegistration_ActivationRequested_Notification(velocityEngine, this.getServiceEnvironment().getProperties(), dto1, true);
				n.notify(pcfg,  aSession);
//		    	OTPPersistence otpPersistence = OTPPersistence.createPersistenceObject(pcfg, aSession); 
//		        OTPDTO otpDataBean = new OTPDTO();
//		        otpDataBean.setOTPInfo(dto1.getUserid(), 5);
//		        otpPersistence.insert(otpDataBean, pcfg.getPersistenceConfigInfo());
//
//		        sendRegistration2ActivateMail(pcfg, aSession, otpDataBean, dto1);	
			}
			else 
			{
				UserRegistration_Activated_Notification n1 = new UserRegistration_Activated_Notification(velocityEngine, this.getServiceEnvironment().getProperties(), dto1, false);
				n1.notify(pcfg,  aSession);
//				sendActivatedRegistrationMail(pcfg, aSession, dto1);     
			}
				
		    // Inserisco il record corrispondente nella collection Mongo se disponibile
		    if (pcfg.isMongoDbAvailable())
		    {
		    	MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();
		    	Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		    	UserCollectionPersistence ucp = UserCollectionPersistence.createPersistenceObject(mpctx);
		    	ucp.insert(actionForm.getUserCollectionDTO4Insert(dto1.getUserid()), datastore);	    	
		    }
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ServicePatternException(e);
		}	    
	    
	    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);	    	    
		return dto1;
	}

//	private void sendRegistration2ActivateMail(PersistenceContext ctx, SqlSession aSession, OTPDTO otpDto, UserDTO user) throws Exception
//	{        
//		VelocityTemplateRenderer renderer = velocityEngine.newRendererInstance("UserRegistration_RequestActivatationMailMessage", senv.getRequestSiteDomain());
//		renderer.add("userObj", user);
//		renderer.add("senv", getServiceEnvironment());
//		renderer.add("otpObj", otpDto);
//		
//		String messageBody = renderer.mergeTemplate();
//		
//		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, this.getServiceEnvironment().getRequestLanguage()); 
//        SimpleNotifier wm = new SimpleNotifier(); 
//
//        wm.setMessageSender(sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSFROM));
//        wm.setMessageTitle(sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.REGIST_MAILTITLE));
//
//        MailRecipient recipient = MailRecipient.newRecipient(user.getEmail(), MailRecipient.TO_RECIPIENT);
//        ArrayList<MailRecipient> listOfRecipients = new ArrayList<MailRecipient>();
//        listOfRecipients.add(recipient);
//
//        String bccRecipient = sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSBCC);
//        if (bccRecipient != null) {
//            recipient = MailRecipient.newRecipient(bccRecipient, MailRecipient.BCC_RECIPIENT);
//            listOfRecipients.add(recipient);
//        }
//
//        wm.notify(ctx, aSession, senv.getRequestSiteId(), messageBody, listOfRecipients, null, 2);	
//	}
//
//	private void sendActivatedRegistrationMail(PersistenceContext ctx, SqlSession aSession, UserDTO user) throws Exception
//	{        
//		VelocityTemplateRenderer renderer = velocityEngine.newRendererInstance( "UserActivatedRegistrationMailMessage", senv.getRequestSiteDomain());
//		renderer.add("userObj", user);
//		renderer.add("senv", getServiceEnvironment());
//		
//		String messageBody = renderer.mergeTemplate();
//		
//		SitePropertyLUT sitePropertyLut = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, this.getServiceEnvironment().getRequestLanguage()); 
//        SimpleNotifier wm = new SimpleNotifier(); 
//
//        wm.setMessageSender(sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSFROM));
//        wm.setMessageTitle(sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.REGIST_MAILTITLE));
//
//        MailRecipient recipient = MailRecipient.newRecipient(user.getEmail(), MailRecipient.TO_RECIPIENT);
//        ArrayList<MailRecipient> listOfRecipients = new ArrayList<MailRecipient>();
//        listOfRecipients.add(recipient);
//
//        String bccRecipient = sitePropertyLut.getDtodescr(senv.getRequestSiteId(), PropertyScope.mail, SitePropertyDTO.SMTP_SYSBCC);
//        if (bccRecipient != null) {
//            recipient = MailRecipient.newRecipient(bccRecipient, MailRecipient.BCC_RECIPIENT);
//            listOfRecipients.add(recipient);
//        }
//
//        wm.notify(ctx, aSession, senv.getRequestSiteId(), messageBody, listOfRecipients, null, 2);	
//	}

}
