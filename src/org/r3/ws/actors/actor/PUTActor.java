package org.r3.ws.actors.actor;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.group.ActorGroupDTO.GroupNature;
import org.r3.db.actor.group.ActorGroupDTO.SpecialInterestGroup;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;

public class PUTActor extends ServicePattern
{
	private enum LoginContactUpdateMode { 		
		newNo_oldNo, newYes_oldNo, newNo_oldYes, newYes_oldYes_equal, newYes_oldYes_notEqual
	};
	
    private ActorActionForm actionForm;
    private String actorId;
    private VelocityTemplateModel velocityEngine;
    
	public PUTActor(ServletContext ctx, ServiceEnvironment serviceEnvironment, String anActorId, ActorActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		actorId = anActorId;
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ActorPersistence p = ActorPersistence.createPersistenceObject(pcfg, aSession);		
		ActorDTO dtoActor = p.selectByEventidActorid(senv.getRequestSiteId(), actorId, pcfg.getPersistenceConfigInfo());
		if (dtoActor != null)
		{
			if (actionForm.getEmail() != null)
			{					
				int duplicateActors = p.countByEventidEmailNotActorid(senv.getRequestSiteId(), actionForm.getEmail(), dtoActor.getActorid(), pcfg.getPersistenceConfigInfo());
				if (duplicateActors > 0)
				{
					RestServiceDTO restDTO = new RestServiceDTO(RestServiceDTO.Status.fail, "ACTOR_ERROR_001", "Actor: EMAIL DUPLICATA");
					return restDTO;
				}
			}
			
			ActorDTO newDtoActor = actionForm.getDTO4Update(dtoActor);		
		    p.updateByPrimaryKey(newDtoActor, pcfg.getPersistenceConfigInfo());	    
	
	        ActorGroupRelationPersistence gp = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);    		
	        gp.removeActorFromGroupsOfNature(senv.getRequestSiteId(), actorId, GroupNature.user, pcfg.getPersistenceConfigInfo());
	        
	    	String[] actorGroupArray = DTOBase.string2Array(actionForm.getActorgroup(), ",");
	    	if (actorGroupArray != null)
	    	{
	             for(String groupId : actorGroupArray)
	             {
	            	 gp.insertActorIntoGroup(senv.getRequestSiteId(), groupId, actorId, pcfg.getPersistenceConfigInfo());
	             }             
	    	}
	    	
	    	switch(getLoginContactUpdateMode(dtoActor, newDtoActor))
	    	{
	    	case newNo_oldNo:
	    	case newYes_oldYes_equal:
	    		// In questo caso non debbo fare nulla.
	    		break;
	    		
	    	case newNo_oldYes:
	    		gp.removeActorFromGroup(senv.getRequestSiteId(), SpecialInterestGroup.ACGLOGIN.toString(), actorId, pcfg.getPersistenceConfigInfo());
	    		// Debbo però eliminare i riferimenti in giro alle userid selezionate tramite il contatto.
	    		removeLoginContactReferences2UserId(pcfg, aSession, dtoActor);
	    		break;
	    		
	    	case newYes_oldNo:
	    		// Debbo inserire il contatto nel gruppo ACGLOGIN
	    		gp.insertActorIntoGroup(senv.getRequestSiteId(), SpecialInterestGroup.ACGLOGIN.toString(), actorId, pcfg.getPersistenceConfigInfo());
	    		break;
	    		
	    	case newYes_oldYes_notEqual:
	    		// L'inserimento nel gruppo non serve in quanto è già presente.
	    		// Debbo però eliminare i riferimenti in giro alle userid selezionate tramite il contatto.
	    		removeLoginContactReferences2UserId(pcfg, aSession, dtoActor);
	    		break;	    		
	    	}
		}
		
		return dtoActor;
	}
	
	private void removeLoginContactReferences2UserId(PersistenceContext pcfg, SqlSession aSession, ActorDTO asIsActor)
	{
		RunSqlPersistence scriptPersistence = 
		RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "LoginActorClearReferencesSQLScript");
								
		scriptPersistence.addParameter("actorDTO", asIsActor);							
		scriptPersistence.execute(pcfg, aSession);			
	}
	
	private LoginContactUpdateMode getLoginContactUpdateMode(ActorDTO asIsActor, ActorDTO toBeActor)
	{
		LoginContactUpdateMode m = LoginContactUpdateMode.newNo_oldNo;
		
		String asIsUserId = asIsActor.getUserid();
		String toBeUserId = toBeActor.getUserid();
		
		//
		// La prima condizione mi determina se sono tutti e due nulli oppure uno è null e l'altro no. 
		// L'else identifica se la situazione è tutti e due diversi da null oppure sono null (in questo caso torno il valore di
		// inizializzazione
		//
		if (asIsUserId != null ^ toBeUserId  != null)
		{
			if (asIsUserId != null)
				 m = LoginContactUpdateMode.newNo_oldYes;
			else m = LoginContactUpdateMode.newYes_oldNo;
		}
		else
		{
			if (asIsUserId != null)
			{
				if (asIsUserId.equalsIgnoreCase(toBeUserId))
					 m = LoginContactUpdateMode.newYes_oldYes_equal;
				else m = LoginContactUpdateMode.newYes_oldYes_notEqual;
			}
		}
		
		return m;
	}
	
}
