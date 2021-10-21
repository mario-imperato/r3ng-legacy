package org.r3.ws.actors.actorgroup;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTActorGroupRemoveActors extends ServicePattern
{
    private ActorGroupActionForm actionForm;
    private String groupId;
    private boolean removeActors;
    
	public PUTActorGroupRemoveActors(ServletContext ctx, ServiceEnvironment serviceEnvironment, String anActorId, ActorGroupActionForm anActionForm, boolean aRemoveActors)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		groupId = anActorId;
		removeActors = aRemoveActors;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorGroupRelationPersistence p = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);						
        ActorPersistence actorPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);
		
		String[] a = actionForm.getActorid();
		if (a != null && a.length > 0)
		{
			for(String actorId : a)
			{
				if (removeActors)
				{
				     actorPersistence.markActorAsDeleted(senv.getRequestSiteId(), actorId, pcfg.getPersistenceConfigInfo());
				}
				
				p.removeActorFromGroup(senv.getRequestSiteId(), groupId, actorId, pcfg.getPersistenceConfigInfo());
			}
		}
		return RestServiceDTO.SuccessDTO;
	}
}
