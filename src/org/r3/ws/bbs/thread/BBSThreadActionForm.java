package org.r3.ws.bbs.thread;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.bbs.bbsthread.BBSThreadDTO;

public class BBSThreadActionForm
{
	@FormParam("threadid")
    private String threadid;

    public String getThreadid()
    {    	
    	return DTOBase.nullOnEmpty(threadid);
    }
    
	@FormParam("threadtitle")
    private String threadtitle;

    public String getThreadtitle()
    {    	
    	return DTOBase.nullOnEmpty(threadtitle);
    }

	@FormParam("threadnodeid")
    private String[] threadnodeid;
	
	public String[] getThreadnodeid()
	{
	    return threadnodeid;	
	}
	
	public BBSThreadDTO getDTO4Insert(String aSite, String aTopicId, String aUserId)
	{
		BBSThreadDTO dto = new BBSThreadDTO();
		dto.setSite(aSite);
		dto.setThreadid(getThreadid());
		dto.setTopicid(aTopicId);
		dto.setThreadtitle(getThreadtitle());
		dto.setNumposts(0);
		dto.setCreationdate(DTOBase.currentTimestamp());
		dto.setUserid(aUserId);
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}	
	
	public BBSThreadDTO getDTO4Update(String aSite, String aThreadId)
	{
		BBSThreadDTO dto = new BBSThreadDTO();
		dto.setSite(aSite);
		dto.setThreadid(aThreadId);
		
		dto.setThreadtitle(getThreadtitle());		
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}

}
