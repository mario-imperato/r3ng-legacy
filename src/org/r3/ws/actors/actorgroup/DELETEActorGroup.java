package org.r3.ws.actors.actorgroup;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEActorGroup extends ServicePattern
{
    private String groupId;
    private boolean removeActors;
    
	public DELETEActorGroup(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aGroupId, boolean aRemoveActors)
	{
		super(ctx, serviceEnvironment);
		groupId = aGroupId;
		removeActors = aRemoveActors;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorGroupPersistence p = ActorGroupPersistence.createPersistenceObject(pcfg, aSession);		
		ActorGroupRelationPersistence pr = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);	
		ActorPersistence actorPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);
		
		if (removeActors)
		{
		     actorPersistence.markActorsInGroupAsDeleted(senv.getRequestSiteId(), groupId, pcfg.getPersistenceConfigInfo());
		}
		
		pr.deleteByEventidGroupid(senv.getRequestSiteId(), groupId, pcfg.getPersistenceConfigInfo());		
	    int numberOfRowsDeleted = p.deleteByEventidGroupid(senv.getRequestSiteId(), groupId, pcfg.getPersistenceConfigInfo());
	    
		return RestServiceDTO.SuccessDTO;
	}
}
