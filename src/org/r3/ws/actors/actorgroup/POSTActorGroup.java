package org.r3.ws.actors.actorgroup;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTActorGroup extends ServicePattern
{
    private ActorGroupActionForm actionForm;
    
	public POSTActorGroup(ServletContext ctx,  ServiceEnvironment serviceEnvironment, ActorGroupActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorGroupPersistence p = ActorGroupPersistence.createPersistenceObject(pcfg, aSession);
		
		ActorGroupDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId());		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    
	    if (actionForm.getCreatefromgroupAsBoolean())
	    {
	    	ActorGroupRelationPersistence relp = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);
	        if (actionForm.isCreateFromAllContacts())
	        {
	        	relp.insertAllActorsIntoGroup(senv.getRequestSiteId(), dto1.getGroupid(), pcfg.getPersistenceConfigInfo());
	        }
	        else 
	        {
	        	relp.insertActorsIntoGroupFromGroup(senv.getRequestSiteId(), dto1.getGroupid(), actionForm.getCreatefromgroup(), pcfg.getPersistenceConfigInfo());
	        }
	    }
	    
		return dto1;
	}

}
