package org.r3.ws.wbs;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.bbs.bbstopic.BBSTopicDTO;
import org.r3.db.wbs.wbs.WBSDTO;
import org.r3.db.wbs.wbs.WBSDTO.WBSOptions;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodeDTO.NodeType;

public class WBSActionForm
{
	@FormParam("wbstitle")
    private String wbstitle;

    public String getWbstitle()
    {    	
    	return DTOBase.nullOnEmpty(wbstitle);
    }

	@FormParam("wbsmanager")
    private String wbsmanager;

    public String getWbsmanager()
    {    	
    	return DTOBase.nullOnEmpty(wbsmanager);
    }

	@FormParam("wbscoach")
    private String wbscoach;

    public String getWbscoach()
    {    	
    	return DTOBase.nullOnEmpty(wbscoach);
    }

	@FormParam("wbssponsor")
    private String wbssponsor;

    public String getWbssponsor()
    {    	
    	return DTOBase.nullOnEmpty(wbssponsor);
    }

	@FormParam("wbstext")
    private String wbstext;

    public String getWbstext()
    {    	
    	return DTOBase.nullOnEmpty(wbstext);
    }
       
	@FormParam("options")
    private String[] options;

    public String[] getOptions()
    {    	
    	return options;
    }    
    
    public String getOptionsAsCSV()
    {
        String s = DTOBase.stringArray2CSV(options);
        if (s == null)
        	s = WBSOptions.wbs_none.toString();
        
        return s;
    }
    
    public boolean isDiscussionEnabled()
    {
        String[] s = getOptions();
        if (s != null && s.length > 0)
        {
        	for(String s1 : s)
        	{
        		if (s1.equalsIgnoreCase("discussion"))
        		{
        			return true;
        		}
        	}
        }
        
        return false;
    }
    
	public WBSDTO getDTO4Insert(String aSite)
	{
		WBSDTO dto = new WBSDTO();
        dto.setSite(aSite);
        dto.setWbstitle(getWbstitle());
        dto.setWbstext(getWbstext());
        dto.setOptions(getOptionsAsCSV());
        
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		
		return  dto;
	}

	public WBSDTO getDTO4Update(WBSDTO dto)
	{		
        dto.setWbstitle(getWbstitle());
        dto.setWbstext(getWbstext());
              
        dto.setOptions(getOptionsAsCSV());
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		
		return  dto;
	}

	public WBSNodeDTO getDTO4WBSRoot(String aSite, String aWbsId)
	{
		WBSNodeDTO dto = new WBSNodeDTO();
		dto.setWbsnodeid(aWbsId);
        dto.setSite(aSite);
        dto.setWbsid(aWbsId);
        dto.setNodetype(NodeType.root.toString());
        dto.setNodename(getWbstitle());
        dto.setNodepath(".");
        dto.setNodeorder(1);
		return dto;
	}

	public BBSTopicDTO getTopicDTO4Insert(String requestSiteId, String wbsid)
	{
		BBSTopicDTO dto = new BBSTopicDTO();
		dto.setSite(requestSiteId);
		dto.setTopicid(wbsid);
		dto.setTopictitle(getWbstitle());
		dto.setModeratormode("moderated");
		dto.setRecstatus(RecordStatus.sys_recact.toString());
		return  dto;
	}
	
}
