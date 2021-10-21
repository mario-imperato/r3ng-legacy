package org.r3.db.system.eventlog;

public class EventLogAddDocInfo extends EventLogDTO
{
    public EventLogAddDocInfo(String site, String applicationId, String aDocumentId, String aUserId)
    {
    	this.setUsecaseambit(UseCaseAmbit.sev_application);
    	this.setUsecase(UseCase.ev_adddocinfo);
    	this.setSite(site);
    	this.setRefentityid1(applicationId);
    	this.setRefentityid2(aDocumentId);
    	this.setRecstatus(RecordStatus.sys_recact.toString());
    	this.setUserid(aUserId);
    }
}
