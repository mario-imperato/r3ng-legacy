package org.r3.db.system.eventlog;

public class EventLogCrewInfo extends EventLogDTO
{
    public EventLogCrewInfo(String site, String applicationId, String crewMemberId, String cardnumber, String aUserId)
    {
    	this.setUsecaseambit(UseCaseAmbit.sev_application);
    	this.setUsecase(UseCase.ev_crewinfo);
    	this.setSite(site);
    	this.setRefentityid1(applicationId);
    	this.setRefentityid2(crewMemberId);
    	this.setRefentityid3(cardnumber);
    	
    	this.setRecstatus(RecordStatus.sys_recact.toString());
    	this.setUserid(aUserId);
    }
}
