//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.sailevent.rankingview;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class RankingViewPersistence extends RankingViewPersistenceBase
{
	public static RankingViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		RankingViewPersistence p = new RankingViewPersistence();
		p.setMapper(aSession.getMapper(RankingViewMapper.class));
		return p;
	}

	public org.r3.db.sailevent.rankingview.RankingViewSynopticDataTableAdapter querySynoptic(
					org.r3.db.sailevent.rankingview.RankingViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
	{
		RowBounds rb = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);
		List<org.r3.db.sailevent.rankingview.RankingViewSynopticDTO> l = this.mapper.selectSynoptic(aFilterCondition, pcfg, rb);

		int numberOfItems = (l != null) ? l.size() : 0;
		org.r3.db.sailevent.rankingview.RankingViewSynopticDataTableAdapter dt = new org.r3.db.sailevent.rankingview.RankingViewSynopticDataTableAdapter();
		dt.setsEcho("1");
		dt.setiTotalRecords(numberOfItems);
		dt.setiTotalDisplayRecords(numberOfItems);
		dt.setAaData(l);

		return dt;
	}

}
