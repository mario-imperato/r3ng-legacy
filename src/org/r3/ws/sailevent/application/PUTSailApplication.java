package org.r3.ws.sailevent.application;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.actor.group.ActorGroupDTO;
import org.r3.db.actor.group.ActorGroupPersistence;
import org.r3.db.actor.relactorgroup.ActorGroupRelationPersistence;
import org.r3.db.sailevent.appdata.SailApplicationDataDTO;
import org.r3.db.sailevent.appdata.SailApplicationDataPersistence;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationDTO.ApplicationSection;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTSailApplication extends ServicePattern
{
	private SailFillOutApplicationActionForm actionForm;
    private String applicationId;
    private ApplicationSection section;
    
	public PUTSailApplication(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anApplicationId, ApplicationSection aSection, SailFillOutApplicationActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);				
		section = aSection;
		applicationId = anApplicationId;			
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		EventLogPersistence ep = EventLogPersistence.createPersistenceObject(pcfg, aSession);
		
		SailApplicationPersistence p = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);
		ActorPersistence actorPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);
		ActorGroupRelationPersistence relActor = ActorGroupRelationPersistence.createPersistenceObject(pcfg, aSession);
		
		ActorGroupPersistence actorGroupPersistence = ActorGroupPersistence.createPersistenceObject(pcfg, aSession);
		ActorGroupDTO actorGroupDTO = null;
		
		ActorDTO dtoActor = null;
		SailApplicationDTO dto1 = p.selectByEventidApplicationid(senv.getRequestSiteId(), applicationId, pcfg.getPersistenceConfigInfo());
		if (dto1 != null)
		{
			switch(section)
			{
			case r3ea_boatinfo:
				dto1 = actionForm.getDTO4UpdateBoatInfo(dto1);
				p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
				ep.logEventBoatInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, senv.getUserProfile().getUserid());
				break;
				
			case r3ea_classinfo:
				dto1 = actionForm.getDTO4UpdateClassInfo(dto1);
				p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
				ep.logEventClassInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, senv.getUserProfile().getUserid());
				break;
				
			case r3ea_ownerinfo:
				dtoActor = actionForm.getDTO4OwnerActor(senv.getRequestSiteId(), dto1.getOwnerid());
				if (dto1.getOwnerid() != null)
				{
					actorPersistence.updateByPrimaryKey(dtoActor, pcfg.getPersistenceConfigInfo());
				}
				else
				{
					actorPersistence.insert(dtoActor, pcfg.getPersistenceConfigInfo());
					relActor.insertActorIntoGroup(senv.getRequestSiteId(), "ACGOWNERS", dtoActor.getActorid(), pcfg.getPersistenceConfigInfo());
					dto1.setOwnerid(dtoActor.getActorid());
					p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
				}				

				dtoActor = actionForm.getDTO4HelmsmanActor(senv.getRequestSiteId(), dto1.getHelmsmanid());
				if (dtoActor != null)
				{
					if (dto1.getHelmsmanid() != null)
					{
						actorPersistence.updateByPrimaryKey(dtoActor, pcfg.getPersistenceConfigInfo());
					}
					else
					{
						actorPersistence.insert(dtoActor, pcfg.getPersistenceConfigInfo());
						relActor.insertActorIntoGroup(senv.getRequestSiteId(), "ACGHELMSMAN", dtoActor.getActorid(),
										pcfg.getPersistenceConfigInfo());
						dto1.setHelmsmanid(dtoActor.getActorid());
						p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
					}
				}
				else
				{
					if (dto1.getHelmsmanid() != null)
					{
						relActor.deleteByEventidActorid(senv.getRequestSiteId(), dto1.getHelmsmanid(), pcfg.getPersistenceConfigInfo());
						actorPersistence.deleteByEventidActorid(senv.getRequestSiteId(), dto1.getHelmsmanid(), pcfg.getPersistenceConfigInfo());
						
						dto1.setHelmsmanid(null);
						p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
					}
				}
								
				ep.logEventOwnerInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, senv.getUserProfile().getUserid());				
				break;
				
			case r3ea_crewinfo:
				break;
				
			case r3ea_docinfo:
				break;
				
			case r3ea_authorinfo:
				ep.logEventAuthorInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, senv.getUserProfile().getUserid());				
				break;
			
			case r3ea_attsheet:
				ep.logEventAttendanceSheetInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, senv.getUserProfile().getUserid());				
				break;
				
			case r3ea_payinfo:
				break;
				
			case r3ea_summaryinfo:     
				break;

			case r3ea_adminchecks:     
				dto1 = actionForm.getDTO4UpdateAdminChecks(dto1);
				p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
				break;

			case r3ea_adminraceinfo:     
				dto1 = actionForm.getDTO4UpdateAdminRaceInfo(dto1);
				p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
				
				if (dto1.getOwnerid() != null)
				{
					relActor.removeActorFromGroupsOfType(senv.getRequestSiteId(), dto1.getOwnerid(), "sevracegroup", pcfg.getPersistenceConfigInfo());
					
					
					if (dto1.getAdminracegroup() != null)
					{
						actorGroupDTO = actorGroupPersistence.selectByEventidGroupid(senv.getRequestSiteId(), dto1.getAdminracegroup(), pcfg.getPersistenceConfigInfo());
						if (actorGroupDTO != null)
						    relActor.insertActorIntoGroup(senv.getRequestSiteId(), dto1.getAdminracegroup(), dto1.getOwnerid(), pcfg.getPersistenceConfigInfo());													
					}

					actorGroupDTO = actorGroupPersistence.selectByEventidGroupid(senv.getRequestSiteId(), dto1.getAdminraceclass(), pcfg.getPersistenceConfigInfo());

					if (dto1.getAdminraceclass() != null)
					{
						actorGroupDTO = actorGroupPersistence.selectByEventidGroupid(senv.getRequestSiteId(), dto1.getAdminraceclass(), pcfg.getPersistenceConfigInfo());
						if (actorGroupDTO != null)
						     relActor.insertActorIntoGroup(senv.getRequestSiteId(), dto1.getAdminraceclass(), dto1.getOwnerid(), pcfg.getPersistenceConfigInfo());																		
					}
				}
				
				break;				
			}
					
			SailApplicationDataPersistence p1 = SailApplicationDataPersistence.createPersistenceObject(pcfg, aSession);
			if (section == ApplicationSection.r3ea_attsheet) {
				if (actionForm.getAttendanceSheetActiveItem() != "") {
				p1.deleteByEventidApplicationidSectionidParamNamePrefix(senv.getRequestSiteId(), applicationId, section.toString(), actionForm.getAttendanceSheetActiveItem(),
						pcfg.getPersistenceConfigInfo());
				}
			} else {
			    p1.deleteByEventidApplicationidSectionid(senv.getRequestSiteId(), applicationId, section.toString(),
							pcfg.getPersistenceConfigInfo());
			}
			
			List<SailApplicationDataDTO> listOfProperties = 
				getDTO4UpdateProperties(senv.getRequestSiteId(), applicationId, section, actionForm);
			
			if (listOfProperties != null)
			{
			for (SailApplicationDataDTO propertyDTO : listOfProperties)
				p1.insert(propertyDTO, pcfg.getPersistenceConfigInfo());
			}
		}
		
		return dto1;
	}

	private List<SailApplicationDataDTO> getDTO4UpdateProperties(String anEventId, String anApplicationId, ApplicationSection aSection, SailFillOutApplicationActionForm anActionForm)
	{
		List<SailApplicationDataDTO> resList = null;
		
		switch(aSection)
		{
		case r3ea_boatinfo:
			resList = anActionForm.getDTO4UpdateBoatInfoProperties(anEventId, anApplicationId);
			break;
			
		case r3ea_classinfo:
			resList = anActionForm.getDTO4UpdateClassInfoProperties(anEventId, anApplicationId);
			break;
			
		case r3ea_ownerinfo:
			resList = anActionForm.getDTO4UpdateOwnerInfoProperties(anEventId, anApplicationId);
			break;
			
		case r3ea_crewinfo:
			break;
			
		case r3ea_docinfo:
			break;
			
		case r3ea_authorinfo:
			resList = anActionForm.getDTO4UpdateAuthorInfoProperties(anEventId, anApplicationId);
			break;
			
		case r3ea_attsheet:
			resList = anActionForm.getDTO4UpdateAttendanceSheetInfoProperties(anEventId, anApplicationId);
			break;
			
		case r3ea_payinfo:
			break;
			
		case r3ea_summaryinfo:     
			break;

		case r3ea_adminchecks:			
			break;

		case r3ea_adminraceinfo:			
			break;
			
		}
		
		return resList;
	}

}
