package org.r3.ws.user.user;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.core.NewCookie;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.db.system.user.usersession.UserSessionDTO;
import org.r3.db.system.user.usersession.UserSessionPersistence;
import org.r3.system.R3Application;
import org.r3.system.rest.LoginFailedException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTLogin extends ServicePattern
{
    private LoginActionForm actionForm;
    private String          nickname;
    private String          jsessionid;
    
	public POSTLogin(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aLoginUserName, LoginActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		nickname = aLoginUserName;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws LoginFailedException
	{	
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);
		
		UserDTO dto1 = p.selectByNickname(nickname, pcfg.getPersistenceConfigInfo());

		if (dto1 == null)
		{
			List<UserDTO> l = p.selectByEMailRecstatus(nickname, RecordStatus.sys_recact, pcfg.getPersistenceConfigInfo());
			if (l != null && l.size() > 0)
			{
				if (l.size() > 1)
					return new RestServiceDTO(Status.fail, "ERR_FBLOGIN_002", "LoginFailure (2)");

				dto1 = l.get(0);
			}
		}
		
		if (dto1 == null)			
		    return new RestServiceDTO(Status.fail, "ERR_LOGIN_001", "LoginFailure (1)");
		
		if (!dto1.matchesPassword(actionForm.getPassword()))
			return new RestServiceDTO(Status.fail, "ERR_LOGIN_002", "LoginFailure (2)");
				
		UserSessionPersistence sessionPersistence = UserSessionPersistence.createPersistenceObject(pcfg, aSession);
	    String userSessionId = this.getWebAuthInfo().getUserSessionId();
	    if (userSessionId != null)
	    {	    
	    	sessionPersistence.deleteBySessionid(userSessionId, pcfg.getPersistenceConfigInfo());
	    }
		
		UserSessionDTO sessionDTO = new UserSessionDTO(dto1);				
		sessionPersistence.insert(sessionDTO, pcfg.getPersistenceConfigInfo());
		jsessionid = sessionDTO.getSessionid();
		
		dto1.setLastlogin(DTOBase.currentTimestamp());
		p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
		
		return dto1;
	}

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

}
