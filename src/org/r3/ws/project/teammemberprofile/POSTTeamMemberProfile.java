package org.r3.ws.project.teammemberprofile;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.teammemberprofile.TeamMemberProfileDTO;
import org.r3.db.project.teammemberprofile.TeamMemberProfilePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTTeamMemberProfile extends ServicePattern
{
	private TeamMemberProfileActionForm actionForm;

    
	public POSTTeamMemberProfile(ServletContext ctx, ServiceEnvironment serviceEnvironment,  TeamMemberProfileActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		TeamMemberProfileDTO dto2 = null;
		TeamMemberProfilePersistence p = TeamMemberProfilePersistence.createPersistenceObject(pcfg, aSession);

		if (actionForm.getProfileid() != null)
		{
			dto2 = p.selectByProfileid(actionForm.getProfileid(), pcfg.getPersistenceConfigInfo());
			if (dto2 != null)
			{
				RestServiceDTO srvDTO = new RestServiceDTO(Status.fail, "CLSF_0001", "Identificativo gia' presente");
				return srvDTO;
			}
		}
		
		dto2 = actionForm.getDTO4Insert(senv.getRequestSiteId(), senv.getRequestSiteId());
		p.insert(dto2, pcfg.getPersistenceConfigInfo());
		
		return dto2;
	}

	
}
