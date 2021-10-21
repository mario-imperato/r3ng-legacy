package org.r3.ws.sailevent.appcrewmember;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberDTO;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberPersistence;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;

public class POSTSailApplicationCrewMember extends SailApplicationCrewMemberChangePattern
{
    private SailApplicationCrewMemberActionForm actionForm;
    private String eventId;
    private String applicationId;
    
	public POSTSailApplicationCrewMember(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anEventId, String anApplicationId, SailApplicationCrewMemberActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		
        eventId = anEventId;
        applicationId = anApplicationId;
        actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		EventLogPersistence ep = EventLogPersistence.createPersistenceObject(pcfg, aSession);
		
		SailApplicationCrewMemberPersistence p = SailApplicationCrewMemberPersistence.createPersistenceObject(pcfg, aSession);
		SailApplicationCrewMemberDTO dto = p.selectByEventidApplicationidCardnumberRecstatus(eventId, applicationId, actionForm.getCrewcardnumber(), RecordStatus.sys_recact, pcfg.getPersistenceConfigInfo());
		
        if (dto != null)
        {
		    dto = actionForm.getDTO4Update(dto);
		    p.updateByPrimaryKey(dto, pcfg.getPersistenceConfigInfo());
        }
        else  
        {
            dto = actionForm.getDTO4Insert(eventId, applicationId);
            p.insert(dto, pcfg.getPersistenceConfigInfo());
        }
        	    
		try
		{
		notifyChange(pcfg, aSession, eventId, applicationId,dto.getCrewmemberid());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ep.logEventCrewInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, dto.getCrewmemberid(), actionForm.getCrewcardnumber(), senv.getUserProfile().getUserid());

		return RestServiceDTO.SuccessDTO;
	}

}
