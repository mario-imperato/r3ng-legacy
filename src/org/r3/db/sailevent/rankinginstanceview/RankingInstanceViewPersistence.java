//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.rankinginstanceview;

import org.r3.db.PersistenceConfigInfo;

public class RankingInstanceViewPersistence extends RankingInstanceViewPersistenceBase
{
	public static RankingInstanceViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		RankingInstanceViewPersistence p = new RankingInstanceViewPersistence();
		p.setMapper(aSession.getMapper(RankingInstanceViewMapper.class));
		return p;
	}

	public RankingInstanceViewDTO selectByEventidInstanceid(String requestSiteId, String instanceId,
					PersistenceConfigInfo persistenceConfigInfo)
	{
		RankingInstanceViewFilter filter = new RankingInstanceViewFilter();
		filter.or().andEventidEqualTo(requestSiteId).andInstanceidEqualTo(instanceId);
		return selectFirst(filter, persistenceConfigInfo);
	}

}
