//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teamresource;

import org.r3.db.PersistenceConfigInfo;
import org.r3.db.project.teamresource.TeamResourceDTO.ResourceStatus;

public class TeamResourcePersistence extends TeamResourcePersistenceBase
{
  public static TeamResourcePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  TeamResourcePersistence p = new TeamResourcePersistence();
	    p.setMapper(aSession.getMapper(TeamResourceMapper.class));
	    return p;
  }    

	public int countBySiteTeamid(String aSite, String aTeamId, PersistenceConfigInfo persistenceConfigInfo)
	{
		TeamResourceFilter filter = new TeamResourceFilter();
		filter.or().andSiteEqualTo(aSite).andTeamidEqualTo(aTeamId);
		return count(filter, persistenceConfigInfo);
	}
	
	public int countBySiteTeamidResourcedefstatus(String aSite, String aTeamId, ResourceStatus resourceStatus, PersistenceConfigInfo persistenceConfigInfo)
	{
		TeamResourceFilter filter = new TeamResourceFilter();
		filter.or().andSiteEqualTo(aSite).andTeamidEqualTo(aTeamId).andResourcedefstatusEqualTo(resourceStatus.toString());
		return count(filter, persistenceConfigInfo);
	}
}
  
