package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.system.UnauthorizedException;
import org.r3.system.WebAuthInfo;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWhoAmI extends ServicePattern
{    
	public GETWhoAmI(ServletContext ctx, ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws UnauthorizedException
	{
		WebAuthInfo authInfo = getWebAuthInfo(); 
		if (authInfo.isUserNotIdentified())
			throw new UnauthorizedException(authInfo.getUnauthorizedExceptionReason(), authInfo.getUnauthorizedExceptionReason().toString());		
		
		return authInfo.getUserProfile();
	}

}
