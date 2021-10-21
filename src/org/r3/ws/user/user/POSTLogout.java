package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.user.usersession.UserSessionPersistence;
import org.r3.system.rest.LoginFailedException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTLogout extends ServicePattern
{
//    private String          nickname;
//    private String          userid;
    
	public POSTLogout(ServletContext ctx, ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
		// nickname = aLoginUserName;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws LoginFailedException
	{
	    String userSessionId = this.getWebAuthInfo().getUserSessionId();
	    if (userSessionId != null)
	    {
	    	UserSessionPersistence p = UserSessionPersistence.createPersistenceObject(pcfg, aSession);
	    	p.deleteBySessionid(userSessionId, pcfg.getPersistenceConfigInfo());
	    }
		RestServiceDTO dto = new RestServiceDTO(RestServiceDTO.Status.ok, null);
		return dto;
	}
	
}
