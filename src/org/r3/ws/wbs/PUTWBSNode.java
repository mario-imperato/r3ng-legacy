package org.r3.ws.wbs;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.wbsnodeteammemberprofile.WBSNodeTeamMemberProfileDTO;
import org.r3.db.project.wbsnodeteammemberprofile.WBSNodeTeamMemberProfilePersistence;
import org.r3.db.system.calendar.SystemCalendarDTO;
import org.r3.db.system.calendar.SystemCalendarPersistence;
import org.r3.db.wbs.wbsnode.WBSNodeDTO;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTWBSNode extends ServicePattern
{
	private WBSNodeActionForm actionForm;
    private String wbsId;
    private String nodeId;
    private boolean modeFill;
    
	public PUTWBSNode(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aWbsId, String aNodeId, WBSNodeActionForm anActionForm, boolean isModeFillFlag)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		wbsId = aWbsId;
		nodeId = aNodeId;
		modeFill = isModeFillFlag;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO restServiceDTO = null;
		
		WBSNodePersistence p = WBSNodePersistence.createPersistenceObject(pcfg, aSession);
		WBSNodeDTO currentNodeDTO = p.selectByWbsnodeid(nodeId, pcfg.getPersistenceConfigInfo());
		
		WBSNodeDTO dto1 = null;
		if (!modeFill )
		{
			dto1 = actionForm.getDTO4Update(currentNodeDTO);
			
			if (dto1.isAction())
			{
				SystemCalendarPersistence cal = SystemCalendarPersistence.createPersistenceObject(pcfg, aSession);
				SystemCalendarDTO calDto = cal.selectBySitedomainCalendaridCaldate(senv.getRequestSiteDomain(), senv.getRequestSiteCalendarId(), dto1.getStartdate(), pcfg.getPersistenceConfigInfo());
				
				if (calDto == null)
					return RestServiceDTO.FailDTO;

				if (!calDto.isWorkingDay())
				{
					restServiceDTO = new RestServiceDTO(Status.fail, "CALENDAR_001", "Non Working Day");
				}
				
				if (restServiceDTO != null)
					return restServiceDTO;
				
				int workingDayIndex = calDto.getCaleveworkday() + dto1.getDuration() - 1;
				SystemCalendarDTO endCalDto = cal.selectByCaleveworkday(senv.getRequestSiteDomain(), senv.getRequestSiteCalendarId(), workingDayIndex, pcfg.getPersistenceConfigInfo());
				if (endCalDto == null)
					return RestServiceDTO.FailDTO;
				
				dto1.setEnddate(endCalDto.getCaldate());				
			}			
			
			WBSNodeTeamMemberProfilePersistence tmp = WBSNodeTeamMemberProfilePersistence.createPersistenceObject(pcfg, aSession);
			tmp.deleteByWbsnodeid(nodeId, pcfg.getPersistenceConfigInfo());
			
			if (dto1.isTow())
			{				
				List<WBSNodeTeamMemberProfileDTO> teamEffortForecast = actionForm.getTeamEffortForecast(getRequestSite().getSite(), wbsId, nodeId);
				if (teamEffortForecast != null)
				{
					for(WBSNodeTeamMemberProfileDTO d : teamEffortForecast)
					{
						tmp.insert(d, pcfg.getPersistenceConfigInfo());
					}
				}
			}
		}
		else
		{			
			dto1 = actionForm.getDTO4FillOutUpdate(currentNodeDTO);			
		}
		
		p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
		
		return dto1;
	}

}
