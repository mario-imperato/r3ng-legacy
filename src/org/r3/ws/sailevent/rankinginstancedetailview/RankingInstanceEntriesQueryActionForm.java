package org.r3.ws.sailevent.rankinginstancedetailview;

import org.r3.db.sailevent.rankinginstancedetailview.RankingInstanceDetailViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class RankingInstanceEntriesQueryActionForm extends DataTableQueryActionForm
{
	@Override
	public String getsColumns(int indexOfColumn)
	{
		int orderingNominalValue = -1;
		switch(getsSortDir_0_AsEnum())
		{
		case asc:
			orderingNominalValue = Integer.MAX_VALUE;
			break;
		case desc:
			orderingNominalValue = Integer.MIN_VALUE;
			break;
		}
		
		String s = super.getsColumns(indexOfColumn);
		if (s != null)
		{
			if (s.equalsIgnoreCase("realtime"))
				return String.format(" case when annotation is not null then %d else realtime end ", orderingNominalValue);
			
			if (s.equalsIgnoreCase("correctedtime"))
				return String.format(" case when annotation is not null then %d else correctedtime end ", orderingNominalValue);
		}
		
		return s;
	}
    
	public RankingInstanceDetailViewFilter getSearchCondition(String anEventId, String anInstanceId)
	{
		RankingInstanceDetailViewFilter filter = new RankingInstanceDetailViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" rankentryid ");
		else filter.setOrderByClause(getSortingCondition());
		
		filter.or().andEventidEqualTo(anEventId).andInstanceidEqualTo(anInstanceId);
		return filter;
	}
}
