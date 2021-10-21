package org.r3.ws.project.teamresource;

import org.r3.db.project.teamresourceview.TeamResourceViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class TeamResourceViewQueryActionForm extends DataTableQueryActionForm
{	
	public TeamResourceViewFilter getSearchConditionByTeamId(String aSite, String aTeamId)
	{
		TeamResourceViewFilter filter = new TeamResourceViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" periodindex asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		filter.or().andSiteEqualTo(aSite).andTeamidEqualTo(aTeamId);
		
		return filter;
	}
	
	public TeamResourceViewFilter getSearchConditionByResourceId(String aSite, String aResourceId)
	{
		TeamResourceViewFilter filter = new TeamResourceViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" periodindex asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		filter.or().andSiteEqualTo(aSite).andResourceidEqualTo(aResourceId);
		
		return filter;
	}
}
