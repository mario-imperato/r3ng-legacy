package org.r3.ws.actors.actor;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorFilter;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportProcessingOptions;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class ImportActorsFromChildSite extends ServicePattern
{
	protected ImportActorsFromChildSiteActionForm actionForm;
    
	public ImportActorsFromChildSite(ServletContext ctx,
			ServiceEnvironment serviceEnvironment, String aSite, 
			ImportActorsFromChildSiteActionForm anActionForm)
	{
	   super(ctx, serviceEnvironment);
	   actionForm = anActionForm;
	}
	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{		
		ActorPersistence p = ActorPersistence.createPersistenceObject(pcfg, aSession);
        ActorFilter actorFilter = new ActorFilter();
        actorFilter.or()
           .andEventidEqualTo(actionForm.getSourcesite())
           .andActorInGroup(actionForm.getSourcesite(), actionForm.getSourcegroup())
           .andRecstatusNotEqualTo(RecordStatus.sys_recdeleted.toString());

        List<ActorDTO> importData = p.select(actorFilter, pcfg.getPersistenceConfigInfo());
		if (importData != null && importData.size() > 0)
		{
			ActorGroupPersistence groupPersistence = ActorGroupPersistence.createPersistenceObject(pcfg,
					aSession);
			ActorGroupDTO importActorGroup = actionForm.getImportActorGroup4Insert(senv.getRequestSiteId());
			groupPersistence.insert(importActorGroup, pcfg.getPersistenceConfigInfo());
			
			ActorGroupRelationPersistence gp = ActorGroupRelationPersistence
					.createPersistenceObject(pcfg, aSession);
			
			for (ActorDTO importDTO : importData)
			{
				
				ActorDTO dto1 = null;
				try
				{
					dto1 = getActorDTO(pcfg, aSession, p, importDTO, actionForm.getProcessingopts());
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}

				if (dto1 != null)
				{
					boolean shouldCheckGroup = true;
					if (dto1.getActorid() == null)
					{
					   p.insert(dto1, pcfg.getPersistenceConfigInfo());
					   
					   // Inserisco nel gruppo di Importazione.
				       gp.insertActorIntoGroup(senv.getRequestSiteId(), importActorGroup.getGroupid(), dto1.getActorid(), pcfg.getPersistenceConfigInfo());
					   
					   // Se sto lavorando con un actor vecchio potrebbe capitare che l'actor stesso è già inserito nel gruppo in questione.
					   // debbo pertanto verificarlo o meno (in questo caso metto false per non fare questa verifica) 
					   shouldCheckGroup = false;
					}
					
					String[] actorGroupArray = DTOBase.string2Array(actionForm.getActorgroup(), ",");
					if (actorGroupArray != null)
					{
                        String actorGroups = null;
 					    if (shouldCheckGroup)
						{
						   actorGroups = gp.selectByEventidActoridAsCSV(senv.getRequestSiteId(), dto1.getActorid(), pcfg.getPersistenceConfigInfo());
					    }
 					    
						for (String groupId : actorGroupArray)
						{
							boolean doInsert = true;
						    if (shouldCheckGroup && actorGroups != null)
						    {
						         if (actorGroups.indexOf(groupId) >= 0)
						        	 doInsert = false;
						    }
						    
						    if (doInsert)
						       gp.insertActorIntoGroup(senv.getRequestSiteId(), groupId, dto1.getActorid(), pcfg.getPersistenceConfigInfo());
						}
					}
				}
				
			}
		}

		return RestServiceDTO.SuccessDTO;
	}

	private ActorDTO getActorDTO(PersistenceContext pcfg, SqlSession aSession, ActorPersistence actorPersistence, ActorDTO importDTO, String[] processingOpts) throws Exception
	{		
		ActorDTO dto1 = importDTO;
		dto1.setEventid(senv.getRequestSiteId());
		dto1.setActorid(null);
		dto1.setRecstatus(RecordStatus.sys_recact.toString());
        
		if (processingOpts != null && processingOpts.length > 0)
		{
			ActorDTO dupActor = null;
			boolean po_ok = true;
			for(String po : processingOpts)
			{
				FileImportProcessingOptions fipo = FileImportProcessingOptions.getValueFor(po, FileImportProcessingOptions.none);
				switch(fipo)
				{
				case mail_required:
					if (!dto1.isEmailPresent())
						po_ok = false;
					
					break;
				case checkduplicates:
					if (dto1.isEmailPresent())
					{
						dupActor = actorPersistence.selectFirstByEventidEmail(senv.getRequestSiteId(), importDTO.getEmail(), pcfg.getPersistenceConfigInfo());
						if (dupActor != null)
						{
							po_ok = false;
						}
					}
					break;
				}
			}
			
			if (!po_ok)
			{
				dto1 = null;
				
				// Nel caso vi sia un record duplicato provvedo a ritornare il record presente invece di null.
				if (dupActor != null)
					dto1 = dupActor;
			}
				
		}
		
		return dto1;
	}

}
