package org.r3.ws.sailevent.application;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorDTO;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.sailevent.appdata.SailApplicationDataDataTableAdapter;
import org.r3.db.sailevent.appdata.SailApplicationDataPersistence;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.db.system.user.userprofileview.UserProfileViewLUT;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailApplicationDetail extends ServicePattern
{
    private String applicationId;
    private boolean userCheckFlag;
    
	public GETSailApplicationDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anApplicationId, boolean aUserCheckFlag)
	{
		super(ctx, serviceEnvironment);
		applicationId = anApplicationId;
		userCheckFlag = aUserCheckFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SailApplicationPersistence p = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);
						
		SailApplicationDTO dto1 = p.selectByEventidApplicationid(senv.getRequestSiteId(), applicationId, pcfg.getPersistenceConfigInfo());
		if (dto1 == null)
		{
			return RestServiceDTO.FailDTO;
		}
		
		if (userCheckFlag && !dto1.getUserid().equalsIgnoreCase(senv.getUserProfile().getUserid()))
		{
			logger.error("Accesso ad una iscrizione non di pertinenza - " + senv.getUserProfile().getUserid());
			return new RestServiceDTO(Status.fail, "RESTDTO_FAIL", "Errore");
		}
		
		UserProfileViewLUT userProfile = (UserProfileViewLUT)LUTManager.getLUTManager().getLUT(LUTName.userprofile, this.getServiceEnvironment().getRequestLanguage());
		UserProfileViewDTO userProfileDTO = userProfile.getItem(dto1.getUserid());
		if (userProfileDTO != null)
		{
			dto1.setNickname(userProfileDTO.getNickname());
		}
		
		ActorDTO actorDto = null;
		if (dto1.getOwnerid() != null)
		{
		     ActorPersistence actorPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);
		     actorDto = actorPersistence.selectByEventidActorid(senv.getRequestSiteId(), dto1.getOwnerid(), pcfg.getPersistenceConfigInfo());
		     dto1.setOwner(actorDto);
		}

		if (dto1.getHelmsmanid() != null)
		{
		     ActorPersistence actorPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);
		     actorDto = actorPersistence.selectByEventidActorid(senv.getRequestSiteId(), dto1.getHelmsmanid(), pcfg.getPersistenceConfigInfo());
		     dto1.setHelmsman(actorDto);
		}
		
		SailApplicationDataPersistence applicationProperties = SailApplicationDataPersistence.createPersistenceObject(pcfg, aSession);
		SailApplicationDataDataTableAdapter properties = applicationProperties.queryByEventidApplicationid(senv.getRequestSiteId(), applicationId, pcfg.getPersistenceConfigInfo());
		dto1.setProperties(properties);	
		
		return dto1;
	}

}
