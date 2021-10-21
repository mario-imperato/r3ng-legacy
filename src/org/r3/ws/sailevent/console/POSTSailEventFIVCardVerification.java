package org.r3.ws.sailevent.console;




import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberPersistence;
import org.r3.db.system.queues.model.Queue;
import org.r3.db.system.queues.model.QueueException;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.ws.sailevent.event.QM_CheckFIVCardNumbersEvent;


public class POSTSailEventFIVCardVerification extends ServicePattern
{
    private SailEventFIVVerificationActionForm actionForm;
    private String applicationId;
    
    public POSTSailEventFIVCardVerification(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String targetApplicationId, SailEventFIVVerificationActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);			
		actionForm = anActionForm;
		applicationId = targetApplicationId;		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO rc = null;
		
        try
		{
    		SailApplicationCrewMemberPersistence p = SailApplicationCrewMemberPersistence.createPersistenceObject(pcfg, aSession);
         
    		if (applicationId != null)
    			p.markForFIVCardNumberVerification(senv.getRequestSiteId(), applicationId, pcfg.getPersistenceConfigInfo());
    		else 
    		{
    		String[] targetApplicationId = actionForm.getApplicationid();
    		if (targetApplicationId == null || targetApplicationId.length == 0)
    		   p.markFleetForFIVCardNumberVerification(senv.getRequestSiteId(), pcfg.getPersistenceConfigInfo());
    		else 
    		   p.markForFIVCardNumberVerification(senv.getRequestSiteId(), actionForm.getApplicationid(), pcfg.getPersistenceConfigInfo());
    		}
    		
        	Queue q = Queue.newInstance(pcfg, aSession, "fivcardqueue");
        	QM_CheckFIVCardNumbersEvent qm = new QM_CheckFIVCardNumbersEvent(senv.getRequestSiteId(), actionForm.getYachtclubcode(), actionForm.getYachtclubpwd());
        	    		
			q.put(qm);
						
			rc = new RestServiceDTO(Status.ok, "RESTDTO_OK", "Success");
			rc.setCorrelationid(qm.getMessageid());
			return rc;
		}
		catch (QueueException e)
		{                
			e.printStackTrace();
			throw new ServicePatternException(e.getMessage());
		}		
        	    
	}

}
