package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserDTO.UserConsent;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.db.system.user.usersession.UserSessionDTO;
import org.r3.db.system.user.usersession.UserSessionPersistence;
import org.r3.system.UnauthorizedException;
import org.r3.system.WebAuthInfo;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTUserConsent extends ServicePattern
{    
	public PUTUserConsent(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aUserId)
	{
		super(ctx, serviceEnvironment);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws UnauthorizedException
	{
		WebAuthInfo authInfo = getWebAuthInfo(); 
		if (authInfo.isUserNotIdentified())
			throw new UnauthorizedException(authInfo.getUnauthorizedExceptionReason(), authInfo.getUnauthorizedExceptionReason().toString());		
		
		UserSessionPersistence sessionPersistence = UserSessionPersistence.createPersistenceObject(pcfg, aSession);
		UserSessionDTO sessionDTO = sessionPersistence.selectBySessionid(authInfo.getUserSessionId(), pcfg.getPersistenceConfigInfo());
		if (sessionDTO == null)
			throw new UnauthorizedException(authInfo.getUnauthorizedExceptionReason(), authInfo.getUnauthorizedExceptionReason().toString());		

		sessionDTO.setConsentmode(UserConsent.provided.toString());
		sessionPersistence.updateByPrimaryKey(sessionDTO, pcfg.getPersistenceConfigInfo());
			
		UserProfileViewDTO userProfile = authInfo.getUserProfile();
		userProfile.setUserconsent(UserConsent.provided.toString());
		
		if (!userProfile.isGuest())
		{
			UserPersistence up = UserPersistence.createPersistenceObject(pcfg, aSession);
			UserDTO aUserDTO = new UserDTO();
			aUserDTO.setUserconsent(UserConsent.provided.toString());
			aUserDTO.setUserid(userProfile.getUserid());
			
			up.updateByPrimaryKey(aUserDTO, pcfg.getPersistenceConfigInfo());
		}
		
		return userProfile;
	}

}
