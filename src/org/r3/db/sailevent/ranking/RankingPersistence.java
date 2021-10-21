//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.ranking;

import java.util.List;

import org.r3.db.PersistenceContext;

public class RankingPersistence extends RankingPersistenceBase
{
	public static RankingPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		RankingPersistence p = new RankingPersistence();
		p.setMapper(aSession.getMapper(RankingMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public List<RankingDTO> selectByEventid(String requestSiteId, PersistenceContext pcfg)
	{
		RankingFilter f = new RankingFilter();
		f.or().andEventidEqualTo(requestSiteId);

		return select(f, pcfg.getPersistenceConfigInfo());
	}

}
