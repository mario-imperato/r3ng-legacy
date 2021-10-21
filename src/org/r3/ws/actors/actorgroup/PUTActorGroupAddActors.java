package org.r3.ws.actors.actorgroup;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTActorGroupAddActors extends ServicePattern
{
    private ActorGroupActionForm actionForm;
    private String groupId;
    
	public PUTActorGroupAddActors(ServletContext ctx, ServiceEnvironment serviceEnvironment, String anActorId, ActorGroupActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		groupId = anActorId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorGroupRelationPersistence p = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);		
				
		String[] a = actionForm.getActorid();
		if (a != null && a.length > 0)
		{
			for(String actorId : a)
			{
				p.insertActorIntoGroup(senv.getRequestSiteId(), groupId, actorId, pcfg.getPersistenceConfigInfo());
			}
		}
		return RestServiceDTO.SuccessDTO;
	}
}
