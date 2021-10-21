//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.project.team;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.project.team.TeamDTO.TeamStatus;

public class TeamPersistence extends TeamPersistenceBase
{
	public static TeamPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		TeamPersistence p = new TeamPersistence();
		p.setMapper(aSession.getMapper(TeamMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public TeamDTO selectBySitePeriodindex(String aSite, Integer periodIndex, PersistenceConfigInfo persistenceConfigInfo)
	{
		TeamFilter filter = new TeamFilter();
		filter.or().andSiteEqualTo(aSite).andPeriodindexEqualTo(periodIndex);
		return selectFirst(filter, persistenceConfigInfo);
	}

	public void updateTeamStatus(String aSite, String aTeamId, TeamStatus aTeamStatus, PersistenceConfigInfo persistenceConfigInfo)
	{
		TeamDTO dto = new TeamDTO();
		dto.setSite(aSite);
		dto.setTeamid(aTeamId);
		dto.setTeamstatus(aTeamStatus.toString());
		
		updateByPrimaryKey(dto, persistenceConfigInfo);
	}
	
	

}
