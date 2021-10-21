package org.r3.ws.user.user;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.system.user.user.UserDTO;
import org.r3.db.system.user.user.UserPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETUserDetail extends ServicePattern
{
    private String userId;
    
	public GETUserDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUserId)
	{
		super(ctx, serviceEnvironment);
		userId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserPersistence p = UserPersistence.createPersistenceObject(pcfg, aSession);
						
		UserDTO dto1 = p.selectByUserid(userId, pcfg.getPersistenceConfigInfo());
		if (dto1 != null && !senv.isDefaultSite())
		{
		    ActorPersistence ap = ActorPersistence.createPersistenceObject(pcfg, aSession);
		    ActorDTO adto = ap.selectByEventidUserid(senv.getRequestSiteId(), dto1.getUserid(), pcfg.getPersistenceConfigInfo());
		    if (adto != null)
		    {
		    	dto1.setActorid(adto.getActorid());
		    }
		}
		
		return dto1;
	}

}
