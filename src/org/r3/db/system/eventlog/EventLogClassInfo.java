package org.r3.db.system.eventlog;

public class EventLogClassInfo extends EventLogDTO
{
    public EventLogClassInfo(String site, String applicationId, String aUserId)
    {
    	this.setUsecaseambit(UseCaseAmbit.sev_application);
    	this.setUsecase(UseCase.ev_classinfo);
    	this.setSite(site);
    	this.setRefentityid1(applicationId);
    	this.setRecstatus(RecordStatus.sys_recact.toString());
    	this.setUserid(aUserId);
    }
}
