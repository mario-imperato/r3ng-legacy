package org.r3.ws.sailevent.rankinginstance;

import org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class RankingInstancesQueryActionForm extends DataTableQueryActionForm
{

    
	public RankingInstanceViewFilter getSearchCondition(String anEventId, String rankId)
	{
		RankingInstanceViewFilter filter = new RankingInstanceViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" rankid, racenumber ");
		else filter.setOrderByClause(getSortingCondition());
		
		filter.or().andEventidEqualTo(anEventId).andRankidEqualTo(rankId);
		return filter;
	}
}
