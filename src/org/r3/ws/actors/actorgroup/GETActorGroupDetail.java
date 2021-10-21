package org.r3.ws.actors.actorgroup;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETActorGroupDetail extends ServicePattern
{
    private String actorGroupId;
    
	public GETActorGroupDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUserId)
	{
		super(ctx, serviceEnvironment);
		actorGroupId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorGroupPersistence p = ActorGroupPersistence.createPersistenceObject(pcfg, aSession);
						
		ActorGroupDTO dto1 = p.selectByEventidGroupid(senv.getRequestSiteId(), actorGroupId, pcfg.getPersistenceConfigInfo());		
		return dto1;
	}

}
