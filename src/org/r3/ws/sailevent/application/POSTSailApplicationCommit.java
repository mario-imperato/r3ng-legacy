package org.r3.ws.sailevent.application;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberPersistence;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentDTO;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentPersistence;
import org.r3.db.sailevent.application.SailApplicationDTO;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTSailApplicationCommit extends ServicePattern
{
    private String applicationId;
    
	public POSTSailApplicationCommit(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anApplicationId)
	{
		super(ctx, serviceEnvironment);
		
		applicationId = anApplicationId;			
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		EventLogPersistence ep = EventLogPersistence.createPersistenceObject(pcfg, aSession);
		
		SailApplicationPersistence p = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);

		SailApplicationDTO dto1 = p.selectByEventidApplicationid(senv.getRequestSiteId(), applicationId, pcfg.getPersistenceConfigInfo());
        if (dto1 == null)
        {
        	return RestServiceDTO.FailDTO;
        }
        
        RestServiceDTO restDto = RestServiceDTO.SuccessDTO;
        if (applicationIsIncomplete(dto1, pcfg, aSession))
        {
           restDto = new RestServiceDTO(RestServiceDTO.Status.fail, "SEV_ERR_0001", "Domanda di iscrizione incompleta");
        }
        else
        {
            dto1.setCompleted();
            p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());      
            
            ep.logEventSEVCommit(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, senv.getUserProfile().getUserid());
        }
        
        return restDto;		
	}

	private boolean applicationIsIncomplete(SailApplicationDTO dto1, PersistenceContext pcfg, SqlSession aSession)
	{		
		SailApplicationDocumentPersistence documentPersistence = SailApplicationDocumentPersistence.createPersistenceObject(pcfg, aSession);
		int numberOfInsuranceDocument = documentPersistence.numberOfDocumentsByDocumentType(dto1.getEventid(), dto1.getApplicationid(), SailApplicationDTO.DocumentType.r3ea_dtinsur, pcfg.getPersistenceConfigInfo(), aSession);		
		if (numberOfInsuranceDocument == 0)
			return true;

		/*
		int numberOfCovidOwnerDocument = documentPersistence.numberOfDocumentsByDocumentType(dto1.getEventid(), dto1.getApplicationid(), SailApplicationDTO.DocumentType.r3ea_dtcovidowner, pcfg.getPersistenceConfigInfo(), aSession);		
		if (numberOfCovidOwnerDocument == 0)
			return true;
		*/
		
		SailApplicationCrewMemberPersistence crewPersistence = SailApplicationCrewMemberPersistence.createPersistenceObject(pcfg, aSession);
		int crewSize = crewPersistence.crewSize(dto1.getEventid(), dto1.getApplicationid(), pcfg.getPersistenceConfigInfo(), aSession);
		if (crewSize == 0)
			return true;

		return false; 
	}

}
