//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.rankinginstancedetail;

import org.r3.db.PersistenceConfigInfo;

public class RankingInstanceDetailPersistence extends RankingInstanceDetailPersistenceBase
{
	public static RankingInstanceDetailPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		RankingInstanceDetailPersistence p = new RankingInstanceDetailPersistence();
		p.setMapper(aSession.getMapper(RankingInstanceDetailMapper.class));
		return p;
	}

	public int deleteByEventidInstanceid(String eventid, String instanceid, PersistenceConfigInfo persistenceConfigInfo)
	{
		RankingInstanceDetailFilter filter = new RankingInstanceDetailFilter();
		filter.or().andEventidEqualTo(eventid).andInstanceidEqualTo(instanceid);
		
		return delete(filter, persistenceConfigInfo);

	}



}
