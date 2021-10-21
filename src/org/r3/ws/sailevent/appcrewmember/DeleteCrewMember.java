package org.r3.ws.sailevent.appcrewmember;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberPersistence;
import org.r3.db.system.eventlog.EventLogPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;

public class DeleteCrewMember extends SailApplicationCrewMemberChangePattern
{    
	private String eventId;
    private String applicationId;
    private String crewMemberId;
    
	public DeleteCrewMember(ServletContext ctx, ServiceEnvironment serviceEnvironment, String anEventId, String anApplicationId, String aCrewMemberId)
	{
		super(ctx, serviceEnvironment);
		
		eventId = anEventId;
        applicationId = anApplicationId;
        crewMemberId = aCrewMemberId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		EventLogPersistence ep = EventLogPersistence.createPersistenceObject(pcfg, aSession);
		
		SailApplicationCrewMemberPersistence p = SailApplicationCrewMemberPersistence.createPersistenceObject(pcfg, aSession);
		p.logicalDeleteByCrewmemberid(crewMemberId, pcfg);
		
		try
		{
		notifyChange(pcfg, aSession, eventId, applicationId,crewMemberId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		ep.logEventCrewInfo(pcfg.getPersistenceConfigInfo(), senv.getRequestSiteId(), applicationId, crewMemberId, null, senv.getUserProfile().getUserid());

		return RestServiceDTO.SuccessDTO;
	}
}
