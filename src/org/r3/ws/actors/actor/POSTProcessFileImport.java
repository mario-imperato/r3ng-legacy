package org.r3.ws.actors.actor;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportFields;
import org.r3.db.system.fileimport.fileimport.FileImportDTO.FileImportProcessingOptions;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO.FileImportRecordType;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.system.fileimport.ProcessFileImport;

public class POSTProcessFileImport extends ProcessFileImport
{

	public POSTProcessFileImport(ServletContext ctx,
			ServiceEnvironment serviceEnvironment, String aSite,
			String anImportId, ProcessActorFileImportActionForm anActionForm)
	{
		super(ctx, serviceEnvironment, aSite, anImportId, anActionForm);
	}

	protected ProcessActorFileImportActionForm getActionForm()
	{
		return (ProcessActorFileImportActionForm) actionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{		
		List<FileImportDataDTO> importData = getImportData(pcfg, aSession,
				senv.getRequestSiteId(), importId);
		if (importData != null && importData.size() > 0)
		{
			ActorGroupPersistence groupPersistence = ActorGroupPersistence.createPersistenceObject(pcfg,
					aSession);
			ActorGroupDTO importActorGroup = getActionForm().getImportActorGroup4Insert(senv.getRequestSiteId());
			groupPersistence.insert(importActorGroup, pcfg.getPersistenceConfigInfo());
			
			String[] listOfMatches = actionForm.getColumnmatch();

			ActorGroupRelationPersistence gp = ActorGroupRelationPersistence
					.createPersistenceObject(pcfg, aSession);
			ActorPersistence p = ActorPersistence.createPersistenceObject(pcfg,
					aSession);

			for (FileImportDataDTO importDTO : importData)
			{
				if (importDTO.getRecordTypeAsEnum() == FileImportRecordType.header)
					continue;
				
				ActorDTO dto1 = null;
				try
				{
					dto1 = getActorDTO(pcfg, aSession, p, importDTO, listOfMatches, actionForm.getProcessingopts());
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
					
					String[] actorGroupArray = DTOBase.string2Array(getActionForm().getActorgroup(), ",");
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
				else
				{
					markImportDataAs(pcfg, aSession, null,
							importDTO.getImportdataid(),
							RecordStatus.sys_recdeleted);					
				}
				
			}
		}

		return super.process(pcfg, aSession);
	}

	private ActorDTO getActorDTO(PersistenceContext pcfg, SqlSession aSession, ActorPersistence actorPersistence, FileImportDataDTO importDTO, String[] listOfMatches, String[] processingOpts) throws Exception
	{		
		ActorDTO dto1 = new ActorDTO();
		dto1.setEventid(senv.getRequestSiteId());
        dto1.setRecstatus(RecordStatus.sys_recact.toString());
        
		for (int i = 0; i < listOfMatches.length; i++)
		{
			String matchField = listOfMatches[i];

			String value = null;
            String[] multiValue = null;
			FileImportFields field = FileImportFields.getValueFor(matchField, FileImportFields.fimp_none);
			switch (field)
			{
			case fimp_cellphone:
				value = importDTO.getColumnValue(i + 1, 15);
				dto1.setCellphone(value);
				break;
			case fimp_firstname:
				value = importDTO.getColumnValue(i + 1, 30);
				dto1.setFirstname(value);
				break;
			case fimp_lastname:
				value = importDTO.getColumnValue(i + 1, 30);
				dto1.setLastname(value);
				break;
			case fimp_firstlast:
				multiValue = importDTO.getColumnValueSplitted(i + 1, 30, " ");
				if (multiValue != null && multiValue.length > 0)
				{
					switch(multiValue.length)
					{
					case 1: 
						dto1.setLastname(multiValue[0]); break; // Setto Comunque il Cognome...
					case 2:
						dto1.setFirstname(multiValue[0]); 
						dto1.setLastname(multiValue[1]); 
						break; 						
					case 3:
						dto1.setFirstname(new StringBuilder().append(multiValue[0]).append(' ').append(multiValue[1]).toString()); 
						dto1.setLastname(multiValue[2]); 
						break; 												
					default:
						dto1.setFirstname(multiValue[0]); 
						dto1.setLastname(multiValue[multiValue.length - 1]); 
					}
				}
				break;
			case fimp_lastfirst:
				multiValue = importDTO.getColumnValueSplitted(i + 1, 30, " ");
				if (multiValue != null && multiValue.length > 0)
				{
					switch(multiValue.length)
					{
					case 1: 
						dto1.setLastname(multiValue[0]); break; // Setto Comunque il Cognome...
					case 2:
						dto1.setLastname(multiValue[0]); 
						dto1.setFirstname(multiValue[1]); 
						break; 						
					case 3:
						dto1.setLastname(multiValue[0]); 
						dto1.setFirstname(new StringBuilder().append(multiValue[1]).append(' ').append(multiValue[2]).toString()); 
						break; 												
					default:
						dto1.setLastname(multiValue[0]); 
						dto1.setFirstname(multiValue[multiValue.length - 1]); 
					}					
				}				
				break;
				
			case fimp_email:
				value = importDTO.getColumnValue(i + 1, 50);
				dto1.setEmail(value);
				break;
			case fimp_phone:
				value = importDTO.getColumnValue(i + 1, 15);
				dto1.setPhone(value);
				break;
			default:
			}
		}

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
						dupActor = actorPersistence.selectFirstByEventidEmail(senv.getRequestSiteId(), dto1.getEmail(), pcfg.getPersistenceConfigInfo());
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
