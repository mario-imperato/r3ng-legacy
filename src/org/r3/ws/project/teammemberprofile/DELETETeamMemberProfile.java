package org.r3.ws.project.teammemberprofile;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.teammemberprofile.TeamMemberProfilePersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETETeamMemberProfile extends ServicePattern
{

    private String profileId;
    
	public DELETETeamMemberProfile(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aProfileId)
	{
		super(ctx, serviceEnvironment);

		profileId = aProfileId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession) throws ServicePatternException
	{
		TeamMemberProfilePersistence p = TeamMemberProfilePersistence.createPersistenceObject(pcfg, aSession);
        p.deleteByProfileid(profileId, pcfg.getPersistenceConfigInfo());
        
		return RestServiceDTO.SuccessDTO;
	}

}
