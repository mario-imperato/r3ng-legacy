package org.r3.ws.wbs;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.CountByDTO;
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

public class POSTWBSNode extends ServicePattern
{
	private WBSNodeActionForm actionForm;
    private String wbsId;
    private String parentNodeId;
    
	public POSTWBSNode(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aWbsId, String aParentNodeId, WBSNodeActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		wbsId = aWbsId;
		parentNodeId = aParentNodeId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		WBSNodePersistence p = WBSNodePersistence.createPersistenceObject(pcfg, aSession);

		WBSNodeDTO dtoParent = p.selectByWbsnodeid(parentNodeId, pcfg.getPersistenceConfigInfo());
		
		int nodePosition = 1;
        CountByDTO countDto = p.countChildren(parentNodeId, pcfg.getPersistenceConfigInfo());
        if (countDto.getCount() > 0)
        {
        	nodePosition = countDto.getMaxintvalue() + 5;
        }
        
		WBSNodeDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId(), wbsId, parentNodeId, dtoParent.getNodepath(), nodePosition);
		
		RestServiceDTO restServiceDTO = null;
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
		
		p.insert(dto1, pcfg.getPersistenceConfigInfo());		

		WBSNodeTeamMemberProfilePersistence tmp = WBSNodeTeamMemberProfilePersistence.createPersistenceObject(pcfg, aSession);
		
		if (dto1.isTow())
		{				
			List<WBSNodeTeamMemberProfileDTO> teamEffortForecast = actionForm.getTeamEffortForecast(getRequestSite().getSite(), wbsId, dto1.getWbsnodeid());
			if (teamEffortForecast != null)
			{
				for(WBSNodeTeamMemberProfileDTO d : teamEffortForecast)
				{
					tmp.insert(d, pcfg.getPersistenceConfigInfo());
				}
			}
		}
		
		return dto1;
	}

}
