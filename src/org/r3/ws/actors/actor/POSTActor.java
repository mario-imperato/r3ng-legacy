package org.r3.ws.actors.actor;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.group.ActorGroupDTO.SpecialInterestGroup;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTActor extends ServicePattern
{
    private ActorActionForm actionForm;
    
	public POSTActor(ServletContext ctx,  ServiceEnvironment serviceEnvironment, ActorActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorPersistence p = ActorPersistence.createPersistenceObject(pcfg, aSession);
		
		if (actionForm.getEmail() != null)
		{
			int duplicateActors = p.countByEventidEmail(senv.getRequestSiteId(), actionForm.getEmail(), pcfg.getPersistenceConfigInfo());
			if (duplicateActors > 0)
			{
				RestServiceDTO restDTO = new RestServiceDTO(RestServiceDTO.Status.fail, "ACTOR_ERROR_001", "Actor: EMAIL DUPLICATA");
				return restDTO;
			}
		}
		
		ActorDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId());		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    
        ActorGroupRelationPersistence gp = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);    		
        
    	String[] actorGroupArray = DTOBase.string2Array(actionForm.getActorgroup(), ",");
    	if (actorGroupArray != null)
    	{
             for(String groupId : actorGroupArray)
             {
            	 gp.insertActorIntoGroup(senv.getRequestSiteId(), groupId, dto1.getActorid(), pcfg.getPersistenceConfigInfo());
             }             
    	}
	    
    	if (dto1.getUserid() != null)
    	{
    		 gp.insertActorIntoGroup(senv.getRequestSiteId(), SpecialInterestGroup.ACGLOGIN.toString(), dto1.getActorid(), pcfg.getPersistenceConfigInfo());	
    	}
    	
		return dto1;
	}

}
