package org.r3.db.system.eventlog;

public class EventLogUserAction extends EventLogDTO
{
    public EventLogUserAction(String site, UseCaseAmbit anAmbit, UseCase aUseCase, String refEntityId, String aUserId, String aUserSessionId)
    {
    	this.setUsecaseambit(anAmbit);
    	this.setUsecase(aUseCase);
    	this.setSite(site);
    	this.setReason(aUseCase.toString());    	
    	this.setRefentityid1(refEntityId);
    	this.setRecstatus(RecordStatus.sys_recact.toString());
    	this.setUserid(aUserId);
    	this.setUsersessionid(aUserSessionId);
    }
}
