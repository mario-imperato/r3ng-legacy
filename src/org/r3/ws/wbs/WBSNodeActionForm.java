package org.r3.ws.wbs;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;

import org.r3.db.DTOBase;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.project.wbsnodeteammemberprofile.WBSNodeTeamMemberProfileDTO;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodeDTO.ActionCompletionType;
import org.r3.db.wbs.wbsnode.WBSNodeDTO.CompletionStatus;

public class WBSNodeActionForm
{
	@FormParam("nodetype")
	private String nodetype;
	
	public String getNodetype()
	{
		return DTOBase.nullOnEmpty(nodetype);
	}

	@FormParam("stereotype")
	private String stereotype;
				
	public String getStereotype()
	{
		return DTOBase.nullOnEmpty(stereotype);
	}

	@FormParam("nodename")
	private String nodename;
	
	public String getNodename()
	{
		return DTOBase.nullOnEmpty(nodename);
	}

	@FormParam("nodetext")
	private String nodetext;
	
	public String getNodetext()
	{
		return DTOBase.nullOnEmpty(nodetext);
	}

	@FormParam("assignedto")
	private String assignedto;

	public String getAssignedto()
	{
		return DTOBase.nullOnEmpty(assignedto);
	}

	@FormParam("startdate")
	private String startdate;

	public String getStartdate()
	{
		return DTOBase.nullOnEmpty(startdate);
	}

    public java.sql.Date getStartdate(DateFormat df)
	{
		return DTOBase.stringAsDate(startdate, df);
	}
	  
	@FormParam("enddate")
	private String enddate;

	public String getEnddate()
	{
		return DTOBase.nullOnEmpty(enddate);
	}

    public java.sql.Date getEnddate(DateFormat df)
	{
		return DTOBase.stringAsDate(enddate, df);
	}
	  
    
	@FormParam("duration")
	private String duration;

	public String getDuration()
	{
		return DTOBase.nullOnEmpty(duration);
	}

	public int getDurationAsInt()
	{
		int r = 0;
		
		String s = getDuration();
		if (s != null)
		{
			try
			{
				r = Integer.parseInt(s);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return r; 
	}

	@FormParam("completiontype")
	private String completiontype;

	public String getCompletiontype()
	{
		return DTOBase.nullOnEmpty(completiontype);
	}
	
	@FormParam("completion")
	private String completion;

	public String getCompletion()
	{
		return DTOBase.nullOnEmpty(completion);
	}

	public int getCompletionAsInt()
	{
		int r = -1;
		
		String s = getCompletion();
		if (s != null)
		{
			r = Integer.parseInt(s);
		}
			
		return r;
	}

	@FormParam("completiondescr")
	private String completiondescr;

	public String getCompletiondescr()
	{
		return DTOBase.nullOnEmpty(completiondescr);
	}

	@FormParam("completionfrom")
	private String completionfrom;

	public String getCompletionfrom()
	{
		return DTOBase.nullOnEmpty(completionfrom);
	}

	@FormParam("completionto")
	private String completionto;

	public String getCompletionto()
	{
		return DTOBase.nullOnEmpty(completionto);
	}

	public int getCompletiontoAsInt()
	{
		int r = -1;
		
		String s = getCompletionto();
		if (s != null)
		{
			r = Integer.parseInt(s);
		}
			
		return r;
	}
	
	@FormParam("nodesummary")
	private String nodesummary;
	
	public String getNodesummary()
	{
		return DTOBase.nullOnEmpty(nodesummary);
	}

	@FormParam("completioneffort")
	private String completioneffort;

	public String getCompletioneffort()
	{
		return DTOBase.nullOnEmpty(completioneffort);
	}

	public int getCompletioneffortAsInt()
	{
		int r = 0;
		
		String s = getCompletioneffort();
		if (s != null)
		{
			try
			{
				r = Integer.parseInt(s);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return r; 
	}

	@FormParam("economicvalue")
	private String economicvalue;

	public String getEconomicvalue()
	{
		return DTOBase.nullOnEmpty(economicvalue);
	}
	
	@FormParam("economicvalue2")
	private String economicvalue2;

	public String getEconomicvalue2()
	{
		return DTOBase.nullOnEmpty(economicvalue2);
	}

	@FormParam("economicvalue3")
	private String economicvalue3;

	public String getEconomicvalue3()
	{
		return DTOBase.nullOnEmpty(economicvalue3);
	}

	@FormParam("teameffortunit")
	public String teameffortunit;
	
	public String getTeameffortunit()
	{
		return teameffortunit;
	}

	@FormParam("profileid")
	public String[] profileid;
	
	public String[] getProfileid()
	{
		return DTOBase.nullOnEmpty(profileid);
	}
	
	@FormParam("teameffort")
	public String[] teameffort;
	
	public String[] getTeameffort()
	{
		return DTOBase.nullOnEmpty(teameffort);
	}
	
	public WBSNodeDTO getDTO4Insert(String aSite, String aWbsId, String aParentNodeId, String aParentPath, int aNodePosition)
	{
		WBSNodeDTO dto = new WBSNodeDTO();
		dto.setWbsid(aWbsId);
        dto.setSite(aSite);
        dto.setNodeparentid(aParentNodeId);
        dto.setNodetype(getNodetype());
        dto.setNodename(getNodename());
        dto.setStereotype(getStereotype());
        dto.setAssignedto(getAssignedto());
        dto.setNodeorder(aNodePosition);
        dto.setNodesummary(getNodesummary());
        dto.setStartdate(getStartdate(DTOBase.printDateFormat));
        
        // Nel caso di nodetype == action viene ricalcolato dal metodo POSTWBSNode
        dto.setEnddate(getEnddate(DTOBase.printDateFormat));
        
        dto.setDuration(getDuration());
        dto.setCompletiontype(getCompletiontype());
        dto.setCompletiondescr(getCompletiondescr());
        dto.setCompletionfrom(getCompletionfrom());
        dto.setCompletionto(getCompletionto());
        
        switch(ActionCompletionType.getValue4(getCompletiontype(), ActionCompletionType.percentage))
        {
        case percentage:
            dto.setCompletion(0.0f);
        	break;

        case int_pos_range:
        	dto.setCompletion(getCompletionfrom());
        	break;        	
        }
        
        dto.setCompletionstatus(CompletionStatus.empty.toString());
        dto.setCompletioneffort(getCompletioneffortAsInt());
        dto.setEconomicvalue(getEconomicvalue());
        dto.setEconomicvalue2(getEconomicvalue2());
        dto.setEconomicvalue3(getEconomicvalue3());
        StringBuilder stb = new StringBuilder();
        stb.append(aParentPath).append(aParentNodeId).append('.');
        dto.setNodepath(stb.toString());
        
		return dto;
	}

	public WBSNodeDTO getDTO4Update(WBSNodeDTO currentNodeDTO) {
		WBSNodeDTO dto = new WBSNodeDTO();
		dto.setWbsid(currentNodeDTO.getWbsid());
		dto.setSite(currentNodeDTO.getSite());
		dto.setWbsnodeid(currentNodeDTO.getWbsnodeid());

		dto.setNodetype(getNodetype());
		dto.setNodename(getNodename());
		dto.setStereotype(getStereotype());
		dto.setAssignedto(getAssignedto());
		dto.setNodesummary(getNodesummary());
		dto.setStartdate(getStartdate(DTOBase.printDateFormat));
		
		// Nel caso di nodetype == action viene ricalcolato dal metodo PUTWBSNode
		dto.setEnddate(getEnddate(DTOBase.printDateFormat));
		dto.setDuration(getDuration());

		dto.setCompletiontype(getCompletiontype());
		dto.setCompletiondescr(getCompletiondescr());
		// dto.setCompletion(getCompletion());
		dto.setCompletionfrom(getCompletionfrom());
		dto.setCompletionto(getCompletionto());

		ActionCompletionType currentCompletionType = ActionCompletionType.getValue4(
				currentNodeDTO.getCompletiontype(), ActionCompletionType.percentage);
		ActionCompletionType updatedCompletionType = 
				ActionCompletionType.getValue4(getCompletiontype(), ActionCompletionType.percentage);
				
		// Lo stato avanzamento si resetta solo nel caso di un cambio di tipo completamento.
		if (currentCompletionType != updatedCompletionType)		
		{
		switch (updatedCompletionType) {
		case percentage:
			dto.setCompletion(0.0f);
			break;

		case int_pos_range:
			dto.setCompletion(getCompletionfrom());
			break;
		}
		}
		
		dto.setCompletioneffort(getCompletioneffortAsInt());
		dto.setEconomicvalue(getEconomicvalue());
		dto.setEconomicvalue2(getEconomicvalue2());
		dto.setEconomicvalue3(getEconomicvalue3());

		return dto;
	}

	public WBSNodeDTO getDTO4FillOutUpdate(WBSNodeDTO currentNodeDTO) {
		WBSNodeDTO dto = new WBSNodeDTO();
		dto.setWbsid(currentNodeDTO.getWbsid());
		dto.setSite(currentNodeDTO.getSite());
		dto.setWbsnodeid(currentNodeDTO.getWbsnodeid());

		dto.setCompletion(getCompletion());
		switch (ActionCompletionType.getValue4(currentNodeDTO.getCompletiontype(), ActionCompletionType.percentage)) {
		case percentage:
			if (getCompletionAsInt() == 100)
				dto.setCompletionstatus(CompletionStatus.completed.toString());
			else
				dto.setCompletionstatus(CompletionStatus.partial.toString());
			break;

		case int_pos_range:
			if (getCompletionAsInt() == currentNodeDTO.getCompletiontoAsInt())
				dto.setCompletionstatus(CompletionStatus.completed.toString());
			else
				dto.setCompletionstatus(CompletionStatus.partial.toString());
			break;
		}

		dto.setCompletiondate(DTOBase.currentTimestamp());
		dto.setNodetext(getNodetext());
		dto.setCompletioneffort(getCompletioneffortAsInt());
        dto.setEconomicvalue(getEconomicvalue());
		return dto;
	}
	
	public List<WBSNodeTeamMemberProfileDTO> getTeamEffortForecast(String aSite, String aWbs, String aWbsNodeId)
	{
		List<WBSNodeTeamMemberProfileDTO> l = null;
		
		String[] teamProfileList = getProfileid();
		String[] teamEffortList = getTeameffort();
		
		if (teamProfileList != null)
		{
			for(int i = 0; i < teamProfileList.length; i++)
			{
                String e = DTOBase.nullOnEmpty(teamEffortList[i]);
                if (e != null)
                {
                	WBSNodeTeamMemberProfileDTO dto = new WBSNodeTeamMemberProfileDTO();
                	dto.setEffort(e);
                	dto.setProfileid(teamProfileList[i]);
                	dto.setUniteffort(getTeameffortunit());
                	dto.setWbsnodeid(aWbsNodeId);
                	dto.setRecstatus(RecordStatus.sys_recact.toString());
                	
                	if (l == null)
                		l = new ArrayList<WBSNodeTeamMemberProfileDTO>();
                	
                	l.add(dto);
                }
			}
		}
		
		return l;
	}
}
