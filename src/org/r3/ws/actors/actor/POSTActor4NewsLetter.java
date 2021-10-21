package org.r3.ws.actors.actor;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTActor4NewsLetter extends ServicePattern
{
    private ActorActionForm actionForm;
    
	public POSTActor4NewsLetter(ServletContext ctx,  ServiceEnvironment serviceEnvironment, ActorActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		if (!actionForm.isSecuritycodeValid())
		{
			return new RestServiceDTO(Status.fail, "CAPTCHA_ERROR_001", "Codice di sicurezza non valido");
		}
		
		ActorPersistence p = ActorPersistence.createPersistenceObject(pcfg, aSession);
		int numActorsByEmail = p.countByEventidEmail(senv.getRequestSiteId(), actionForm.getEmail(), pcfg.getPersistenceConfigInfo());
		if (numActorsByEmail > 0)
		{
			numActorsByEmail = p.countActorsByEmailGroupid(senv.getRequestSiteId(), actionForm.getEmail(), "newsletter", pcfg.getPersistenceConfigInfo());
			if (numActorsByEmail > 0)
			    return new RestServiceDTO(Status.warning, "NEWSLET_ERROR_001", "Indirizzo EMail gia' presente nel gruppo");
			
			List<ActorDTO> listOfActors = p.selectByEventidEmail(senv.getRequestSiteId(), actionForm.getEmail(), pcfg.getPersistenceConfigInfo());
			if (listOfActors != null)
			{
				ActorGroupRelationPersistence rp = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);
				for(ActorDTO a : listOfActors)
				{
					rp.insertActorIntoGroup(senv.getRequestSiteId(), "newsletter", a.getActorid(), pcfg.getPersistenceConfigInfo());  
				}
			}
		}
		else
		{
			ActorDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId());		
		    p.insert(dto1, pcfg.getPersistenceConfigInfo());
		    
	        ActorGroupRelationPersistence gp = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);    		
	        gp.insertActorIntoGroup(senv.getRequestSiteId(), "newsletter", dto1.getActorid(), pcfg.getPersistenceConfigInfo());
		}
		
	    return RestServiceDTO.SuccessDTO;
	}

}
