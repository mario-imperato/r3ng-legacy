package org.r3.ws.sailevent.ranking;

import org.r3.db.sailevent.ranking.RankingFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailRankingQueryActionForm extends DataTableQueryActionForm
{    
	public RankingFilter getSearchCondition(String anEventId)
	{
		RankingFilter filter = new RankingFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" rankordering, rankid ");
		else filter.setOrderByClause(getSortingCondition());
		
		filter.or().andEventidEqualTo(anEventId);
		return filter;
	}

}
