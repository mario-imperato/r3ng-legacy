package org.r3.ws.project.team;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.team.TeamDTO;
import org.r3.db.project.team.TeamDTO.TeamStatus;
import org.r3.db.project.team.TeamPersistence;
import org.r3.db.project.teamresource.TeamResourceDTO.ResourceStatus;
import org.r3.db.project.teamresource.TeamResourcePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTTeamOnCompleteTask extends ServicePattern
{
	private String nextTeamStatus;
    private String teamId;
    
	public PUTTeamOnCompleteTask(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aTeamId, String aTeamStatus)
	{
		super(ctx, serviceEnvironment);
		nextTeamStatus = aTeamStatus;
		teamId = aTeamId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO rc = null;
		
		TeamStatus t = null;
		try
		{
			t = TeamStatus.valueOf(nextTeamStatus);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return RestServiceDTO.FailDTO;
		}
				
		TeamPersistence p = TeamPersistence.createPersistenceObject(pcfg, aSession);
		TeamDTO dto =  p.selectBySiteTeamid(senv.getRequestSiteId(), teamId, pcfg.getPersistenceConfigInfo());
		if (dto == null)
			return RestServiceDTO.FailDTO;
		
		TeamResourcePersistence trp = TeamResourcePersistence.createPersistenceObject(pcfg, aSession);
		int numberOfResources = 0;
		switch(TeamStatus.valueOf(dto.getTeamstatus()))
		{
		case team_empty:
		case team_building:
			
			numberOfResources = trp.countBySiteTeamid(senv.getRequestSiteId(), teamId, pcfg.getPersistenceConfigInfo());
			if (numberOfResources == 0)
			{
				rc = new RestServiceDTO(Status.fail, "RESTDTO_ERROR_PRJ_001", "Il team non contiene risorse");
			}
			break;
			
		case team_verifying:
			if (t == TeamStatus.team_reporting)
			{				
				numberOfResources = trp.countBySiteTeamidResourcedefstatus(senv.getRequestSiteId(), teamId, ResourceStatus.incomplete, pcfg.getPersistenceConfigInfo());
				if (numberOfResources > 0)
				{
					// Disabilito il controllo in questa fase.
					// rc = new RestServiceDTO(Status.fail, "RESTDTO_ERROR_PRJ_002", "Il team contiene risorse non completamente configurate");
				}
			}
			
			break;
		}
		
		if (rc != null)
		{
			return rc;
		}
		
		dto.setTeamstatus(t.toString());
		p.updateByPrimaryKey(dto, pcfg.getPersistenceConfigInfo());	
		return dto;		
				
	}

}
