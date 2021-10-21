package org.r3.ws.sailevent.rankingview;

import org.r3.db.sailevent.rankingview.RankingViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailRankingViewQueryActionForm extends DataTableQueryActionForm
{    

	public RankingViewFilter getSearchCondition(String requestSiteId)
	{
		RankingViewFilter filter = new RankingViewFilter();
		// filter.setOrderByClause(" eventid, rankordering, rankid, racenumber ");
		filter.setOrderByClause("eventid, rankordering, rankid, case when instancetype = 'rank_overall' then 99 else 0 end,racenumber");
		filter.or().andEventidEqualTo(requestSiteId);
		return filter;
	}
}
