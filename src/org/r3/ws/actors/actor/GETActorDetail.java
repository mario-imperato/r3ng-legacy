package org.r3.ws.actors.actor;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.group.ActorGroupDataTableAdapter;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETActorDetail extends ServicePattern
{
    private String actorId;
    
	public GETActorDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUserId)
	{
		super(ctx, serviceEnvironment);
		actorId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorPersistence p = ActorPersistence.createPersistenceObject(pcfg, aSession);
						
		ActorDTO dto1 = p.selectByEventidActorid(senv.getRequestSiteId(), actorId, pcfg.getPersistenceConfigInfo());
		if (dto1 != null)
		{
			ActorGroupPersistence pg = ActorGroupPersistence.createPersistenceObject(pcfg, aSession);
			ActorGroupDataTableAdapter groups = pg.queryByEventidActorid(senv.getRequestSiteId(), actorId, pcfg.getPersistenceConfigInfo());
			
			dto1.setGroups(groups);
		}
		
		return dto1;
	}

}
