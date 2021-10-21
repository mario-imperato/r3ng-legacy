package org.r3.ws.actors.actorgroup;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTActorGroup extends ServicePattern
{
    private ActorGroupActionForm actionForm;
    private String groupId;
    
	public PUTActorGroup(ServletContext ctx, ServiceEnvironment serviceEnvironment, String anActorId, ActorGroupActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		groupId = anActorId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorGroupPersistence p = ActorGroupPersistence.createPersistenceObject(pcfg, aSession);		
				
		ActorGroupDTO dto1 = actionForm.getDTO4Update(senv.getRequestSiteId(), groupId);
		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());	    
		return dto1;
	}
}
