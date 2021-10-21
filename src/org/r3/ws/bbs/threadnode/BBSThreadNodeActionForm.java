package org.r3.ws.bbs.threadnode;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodeDTO;

public class BBSThreadNodeActionForm
{
	@FormParam("nodetitle")
    private String nodetitle;

    public String getNodetitle()
    {    	
    	String s = DTOBase.nullOnEmpty(nodetitle);
    	if (s != null && s.length() > 80)
    		s = s.substring(0, 80);
    	
    	return s;
    }
    
	@FormParam("nodetype")
    private String nodetype;

    public String getNodetype()
    {    	
    	return DTOBase.nullOnEmpty(nodetype);
    }
    
	@FormParam("nodetext")
    private String nodetext;

    public String getNodetext()
    {    	
    	return DTOBase.nullOnEmpty(nodetext);
    }
    	
	@FormParam("nodeparentid")
    private String nodeparentid;

    public String getNodeparentid()
    {    	
    	return DTOBase.nullOnEmpty(nodeparentid);
    }
    
	public BBSThreadNodeDTO getDTO4Insert(String aSite, String aTopicId, String aThreadId, String aParentNodeId, String aParentPath, String aUserId)
	{
		BBSThreadNodeDTO dto = new BBSThreadNodeDTO();
		dto.setSite(aSite);
		dto.setThreadid(aThreadId);
		dto.setNodetype(getNodetype());
		dto.setNodetitle(getNodetitle());
		dto.setNodetext(getNodetext());
		dto.setNodeparentid(aParentNodeId);
		
		if (aParentNodeId != null)
		{
		StringBuilder stb = new StringBuilder();
        stb.append(aParentPath).append(aParentNodeId).append('.');
        dto.setNodepath(stb.toString());
		}
		else dto.setNodepath(".");
		
		dto.setUserid(aUserId);
		dto.setCreationdate(DTOBase.currentTimestamp());
		
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}

	public BBSThreadNodeDTO getDTO4Update(BBSThreadNodeDTO dto, String aSite, String aTopicId, String aThreadId, String aThreadNodeId)
	{
		if (dto == null)
		{
			 dto = new BBSThreadNodeDTO();
			 dto.setThreadnodeid(aThreadNodeId);			
		}
		else dto.clearDirtyFlags();

		dto.setSite(aSite);
		dto.setThreadid(aThreadId);
		
		dto.setNodetitle(getNodetitle());
		dto.setNodetext(getNodetext());
		dto.setRectimestamp(DTOBase.currentTimestamp());
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}

}
