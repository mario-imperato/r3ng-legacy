package org.r3.ws.sailevent.appdocument;



import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSFileHelper;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentDTO;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentPersistence;
import org.r3.db.sailevent.application.SailApplicationPersistence;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETESailApplicationDocument extends ServicePattern
{    
    private String site;
    private String applicationId;
    private String documentId;
    
	public DELETESailApplicationDocument(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String anApplicationId, String aDocumentId)
	{
		super(ctx, serviceEnvironment);
		
		site = aSite;
		applicationId = anApplicationId;
		documentId = aDocumentId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		EventLogPersistence ep = EventLogPersistence.createPersistenceObject(pcfg, aSession);
		
		SailApplicationPersistence applicationPersistence = SailApplicationPersistence.createPersistenceObject(pcfg, aSession);
		applicationPersistence.clearReference2Document(site, applicationId, documentId, pcfg.getPersistenceConfigInfo());
		
		SailApplicationDocumentPersistence p = SailApplicationDocumentPersistence.createPersistenceObject(pcfg, aSession);		
		SailApplicationDocumentDTO documentDto = p.selectByDocumentid(documentId, pcfg.getPersistenceConfigInfo());
		
		p.deleteByDocumentid(documentId, pcfg.getPersistenceConfigInfo());

		ep.logEventDelDocInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, documentId, senv.getUserProfile().getUserid());

		if (documentDto != null)
		{
			DMSContext dmsContext = new DMSContext(pcfg, aSession);	
			DMSFileHelper.deleteDMSFile(dmsContext, documentDto.getDocumenturl());			
		}
			
		return RestServiceDTO.SuccessDTO;
	}
}
