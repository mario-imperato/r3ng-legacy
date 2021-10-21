package org.r3.ws.user.user;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.core.NewCookie;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.DTOBase;
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
import org.r3.db.system.user.usersession.UserSessionDTO;
import org.r3.db.system.user.usersession.UserSessionPersistence;
import org.r3.system.R3Application;
import org.r3.system.mail.UserRegistration_Activated_Notification;
import org.r3.system.rest.LoginFailedException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.social.facebook.AppInfo;
import org.r3.system.util.velocity.VelocityTemplateModel;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.FacebookClient.DebugTokenInfo;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;

public class POSTFBLogin extends ServicePattern
{	
	private VelocityTemplateModel velocityEngine;

	private static final String SHAKEUS_FBAPP = "606765369532517";
	private static final String SHAKEUS_FBAPPNAME = "ShakeUs";
	private static final String SHAKEUS_SECRET = "1b4921f032d0ded74220a8bb942464f9";

	private static final String R3_FBAPP = "253135905118260";
	private static final String R3_FBAPPNAME = "R3";
	private static final String R3_SECRET = "68e45144154bae4f5befd48559cae942";
	
    private LoginActionForm actionForm;
    private String          nickname;
    private String          jsessionid;
    
	public POSTFBLogin(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aLoginUserName, LoginActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		nickname = aLoginUserName;
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws LoginFailedException
	{
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);

		try
		{
			AppInfo appInfo = AppInfo.retrieveAppInfo(senv.getServerName());
			if (appInfo == null || !appInfo.isValid())
			{
				return new RestServiceDTO(Status.fail, "ERR_FBLOGIN_00C", "LoginFailure (C)");
			}
			
///			SitePropertyLUT siteProperties = (SitePropertyLUT)LUTManager.getLUTManager().getLUT(LUTName.siteproperty, null);
//			String appId = siteProperties.getDtodescr(senv.getRequestSiteDomain(), PropertyScope.facebook, SitePropertyDTO.FB_APPID);			
//			String appSecret = siteProperties.getDtodescr(senv.getRequestSiteDomain(), PropertyScope.facebook, SitePropertyDTO.FB_APPSECRET);
			// !verifyFBLogin(appInfo.getAppId(), appInfo.getAppName(), appInfo.getAppSecret(), actionForm.getAccesstoken(), actionForm.getFbuserid())
			if (!appInfo.verifyToken(actionForm.getAccesstoken(), actionForm.getFbuserid()))
				return new RestServiceDTO(Status.fail, "ERR_FBLOGIN_001", "LoginFailure (1)");

			// Verifico se l'utente è già censito a sistema con uguale nickname
			// (che in questo caso è l'email)
			UserDTO dto1 = p.selectByNickname(nickname, pcfg.getPersistenceConfigInfo());
			if (dto1 != null)
			{
				doLoginUser(pcfg, aSession, p, dto1);
				return dto1;
			}

			// Verifico se esistono utenti con la stessa mail e stato attivo.
			List<UserDTO> l = p.selectByEMailRecstatus(actionForm.getEmail(), RecordStatus.sys_recact, pcfg.getPersistenceConfigInfo());
			if (l != null && l.size() > 0)
			{
				if (l.size() > 1)
					return new RestServiceDTO(Status.fail, "ERR_FBLOGIN_002", "LoginFailure (2)");

				dto1 = l.get(0);
				doLoginUser(pcfg, aSession, p, dto1);
				return dto1;
			}

			dto1 = actionForm.getDTO4FBRegistration();
			p.insert(dto1, pcfg.getPersistenceConfigInfo());
			doRegisterUser(pcfg, aSession, p, dto1);
		    LUTManager.getLUTManager().invalidateLUT(LUTName.userprofile);
		    			
		    return dto1;
		}
		catch (com.restfb.exception.FacebookException e)
		{
			e.printStackTrace();
			return new RestServiceDTO(Status.fail, "ERR_FBLOGIN_00E", "LoginFailure (E)");
		}
		catch (Exception exc)
		{
			throw new LoginFailedException(exc.getMessage());
		}
	}

	private void doLoginUser(PersistenceContext pcfg, SqlSession aSession, UserPersistence p, UserDTO loggingUserDTO)
	{
		UserSessionPersistence sessionPersistence = UserSessionPersistence.createPersistenceObject(pcfg, aSession);
	    String userSessionId = this.getWebAuthInfo().getUserSessionId();
	    if (userSessionId != null)
	    {	    
	    	sessionPersistence.deleteBySessionid(userSessionId, pcfg.getPersistenceConfigInfo());
	    }
		
		UserSessionDTO sessionDTO = new UserSessionDTO(loggingUserDTO);				
		sessionPersistence.insert(sessionDTO, pcfg.getPersistenceConfigInfo());
		jsessionid = sessionDTO.getSessionid();
		
		loggingUserDTO.setLastlogin(DTOBase.currentTimestamp());
		loggingUserDTO.setFbuserid(actionForm.getFbuserid());
		p.updateByPrimaryKey(loggingUserDTO, pcfg.getPersistenceConfigInfo());
	}

	private void doRegisterUser(PersistenceContext pcfg, SqlSession aSession, UserPersistence p, UserDTO loggingUserDTO) throws Exception
	{
			RunSqlPersistence scriptPersistence = 
			RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "UserRegistrationSQLScript");
							
			scriptPersistence.addParameter("userDTO", loggingUserDTO);							
			scriptPersistence.execute(pcfg, aSession);

			UserRegistration_Activated_Notification n1 = new UserRegistration_Activated_Notification(velocityEngine, this.getServiceEnvironment().getProperties(), loggingUserDTO, false);
			n1.notify(pcfg,  aSession);
			
			// sendActivatedRegistrationMail(pcfg, aSession, loggingUserDTO);     
				
		    // Inserisco il record corrispondente nella collection Mongo se disponibile
		    if (pcfg.isMongoDbAvailable())
		    {
		    	MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();
		    	Datastore datastore = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		    	UserCollectionPersistence ucp = UserCollectionPersistence.createPersistenceObject(mpctx);
		    	ucp.insert(actionForm.getUserCollectionDTO4Insert(loggingUserDTO.getUserid()), datastore);	    	
		    }
		    
		    doLoginUser(pcfg, aSession, p, loggingUserDTO);
	}
	    
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
		
	@Override
	protected NewCookie returningCookies()
	{	
		int maxAge = NewCookie.DEFAULT_MAX_AGE; 
		if (actionForm.shouldRememberUserSession())
		{
			maxAge = R3Application.ApplicationCookieRememberMeMaxAge;
		}
		
		NewCookie cookie = new NewCookie(R3Application.ApplicationCookieName, jsessionid, R3Application.ApplicationCookiePath, R3Application.ApplicationCookieDomain, null, maxAge, false);
		return cookie;
	}
	
	private boolean verifyFBLogin(String appId, String appName, String appSecret, String anAccessToken, String anFBUserId)
	{
		  boolean verifyOK = true;
		  FacebookClient authFacebookClient = new DefaultFacebookClient(Version.LATEST);
		  AccessToken appToken = authFacebookClient.obtainAppAccessToken(appId, appSecret);
		  
		  FacebookClient appFacebookClient = new DefaultFacebookClient(appToken.getAccessToken(), Version.LATEST);
		  DebugTokenInfo debugToken = appFacebookClient.debugToken(anAccessToken);

		  String s;
		  if (verifyOK)
		  {
			  if (debugToken == null)
				  verifyOK = false;
		  }

		  if (verifyOK)
		  {
			 if (!debugToken.isValid())
				  verifyOK = false;
		  }

		  if (verifyOK)
		  {
			  s = debugToken.getAppId();
			  if (!(s != null && s.equalsIgnoreCase(appId)))
				  verifyOK = false;
		  }

		  if (verifyOK)
		  {
			  s = debugToken.getApplication();
			  if (!(s != null && s.equalsIgnoreCase(appName)))
				  verifyOK = false;
		  }
		  
		  if (verifyOK)
		  {
			  s = debugToken.getUserId();
			  if (!(s != null && s.equalsIgnoreCase(anFBUserId)))
				  verifyOK = false;
		  }

		  if (verifyOK)
		  {
			  logger.debug("FB Token: " + debugToken.toString());
			  FacebookClient facebookClient = new DefaultFacebookClient(anAccessToken, Version.LATEST);
			  User user = facebookClient.fetchObject("me", User.class, Parameter.with("fields", "first_name,last_name,email"));
			  System.out.println(user);
		  }
		  
		  return verifyOK;
	}

}
