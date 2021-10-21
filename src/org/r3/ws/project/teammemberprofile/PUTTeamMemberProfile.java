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

public class PUTTeamMemberProfile extends ServicePattern
{
	private TeamMemberProfileActionForm actionForm;

    private String profileId;
    
	public PUTTeamMemberProfile(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aProfileId, TeamMemberProfileActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;

		profileId = aProfileId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		RestServiceDTO rc = null;
		
		TeamMemberProfilePersistence p = TeamMemberProfilePersistence.createPersistenceObject(pcfg, aSession);
		TeamMemberProfileDTO dto2 = p.selectByProfileid(profileId, pcfg.getPersistenceConfigInfo());

		if (dto2 != null)
		{
			if (dto2.getSite().equalsIgnoreCase(senv.getRequestSiteId()) )
			{
				dto2 = actionForm.getDTO4Update(dto2);
				p.updateByPrimaryKey(dto2, pcfg.getPersistenceConfigInfo());

				return dto2;
			}
		}
		
		rc = new RestServiceDTO(Status.fail, "CLSF_0002", "Elemento di Classificazione non presente");
		return rc;
		
	}

}
