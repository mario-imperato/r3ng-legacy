package org.r3.ws.sailevent.console;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.actor.actor.ActorPersistence;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationDTO.CompletionStatus;
import org.r3.db.sailevent.application.SailApplicationDTO.VerificationStatus;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.script.RunSqlPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.velocity.VelocityTemplateModel;


public class POSTSailEventApplicationClone extends ServicePattern
{
    private SailEventCloneApplicationActionForm actionForm;
    private String applicationId;
    private VelocityTemplateModel velocityEngine;
    
    public POSTSailEventApplicationClone(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String targetApplicationId, SailEventCloneApplicationActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);			
		actionForm = anActionForm;
		applicationId = targetApplicationId;	
		
		velocityEngine = VelocityTemplateModel.getVelocityPlugInModel(ctx);	
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO rc = null;
		
        try
		{
        	SailApplicationPersistence applicationPersistence = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);
        	SailApplicationDTO applicationDTO = 
        	   applicationPersistence.selectByEventidApplicationid(senv.getRequestSiteId(), this.applicationId, pcfg.getPersistenceConfigInfo());
        	
        	if (applicationDTO == null)
        	{
        		rc = new RestServiceDTO(Status.fail, "RESTDTO_FAIL", "Domanda di iscrizione non disponibile");        		
        	}
        	else
        	{
        		SailApplicationDTO newApplicationDTO = cloneApplicationDTO(actionForm.getCloneeventid(), applicationDTO, pcfg, aSession);
        		applicationPersistence.insert(newApplicationDTO, pcfg.getPersistenceConfigInfo());
        		
    			RunSqlPersistence scriptPersistence = 
				RunSqlPersistence.createPersistenceObject(aSession, velocityEngine, "SailApplicationCloneSQLScript");
								
				scriptPersistence.addParameter("targetApplicationDTO", newApplicationDTO);
				scriptPersistence.addParameter("sourceApplicationDTO", applicationDTO);
				if (newApplicationDTO.getOwnerid() != null)
				{
					scriptPersistence.addParameter("sourceOwnerId", applicationDTO.getOwnerid());
					scriptPersistence.addParameter("targetOwnerId", newApplicationDTO.getOwnerid());
				}

				if (newApplicationDTO.getHelmsmanid() != null)
				{
					scriptPersistence.addParameter("sourceHelmsmanId", applicationDTO.getHelmsmanid());
					scriptPersistence.addParameter("targetHelmsmanId", newApplicationDTO.getHelmsmanid());
				}

				scriptPersistence.execute(pcfg, aSession);			

        		rc = new RestServiceDTO(Status.ok, "RESTDTO_OK", "Success");	
        	}
        	    		
		}
		catch (Exception e)
		{                
			e.printStackTrace();
			throw new ServicePatternException(e.getMessage());
		}		
        
		return rc;        
	}

	private SailApplicationDTO cloneApplicationDTO(
			String targetSite, SailApplicationDTO applicationDTO, PersistenceContext pcfg, SqlSession aSession)
	{
		SailApplicationDTO dto = new SailApplicationDTO();
		dto.setEventid(targetSite);

		dto.setCompletionstatus(CompletionStatus.r3ea_draft.toString());
        dto.setVerificationstatus(VerificationStatus.r3ea_unknown.toString());
        
		dto.setSailnumber(applicationDTO.getSailnumber());
		dto.setYachtname(applicationDTO.getYachtname());
		dto.setYachttype(applicationDTO.getYachttype());
		dto.setYachtclub(applicationDTO.getYachtclub());
		dto.setPlate(applicationDTO.getPlate());
		dto.setMooringloc(applicationDTO.getMooringloc());

		dto.setUserid(applicationDTO.getUserid());
		dto.setBoatimageid(applicationDTO.getBoatimageid());
		dto.setBoatimageurl(applicationDTO.getBoatimageurl());
		dto.setBoatimagewidth(applicationDTO.getBoatimagewidth());
		dto.setBoatimageheight(applicationDTO.getBoatimageheight());
		dto.setBoaticonwidth(applicationDTO.getBoaticonwidth());
		dto.setBoaticonheight(applicationDTO.getBoaticonheight());
		dto.setAddtohomeentrylist(applicationDTO.getAddtohomeentrylist());

		dto.setBoaticonurl(applicationDTO.getBoaticonurl());
		dto.setCreatetimestamp(DTOBase.currentTimestamp());
		
	    ActorPersistence actorPersistence = ActorPersistence.createPersistenceObject(pcfg, aSession);
		if (applicationDTO.getOwnerid() != null)
		{
		     String o = actorPersistence.getActorid_sequence(pcfg.getPersistenceConfigInfo());
		     dto.setOwnerid(o);		     		     
		}
		
		if (applicationDTO.getHelmsmanid() != null)
		{
		     String o = actorPersistence.getActorid_sequence(pcfg.getPersistenceConfigInfo());
		     dto.setHelmsmanid(o);		     		     
		}
		
		return dto;
	}

}
