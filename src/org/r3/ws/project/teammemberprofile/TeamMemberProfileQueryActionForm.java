package org.r3.ws.project.teammemberprofile;

import org.r3.db.project.teammemberprofile.TeamMemberProfileFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class TeamMemberProfileQueryActionForm extends DataTableQueryActionForm
{
		
	public TeamMemberProfileFilter getSearchCondition(String aSite, String aTeamId)
	{
		TeamMemberProfileFilter filter = new TeamMemberProfileFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" profileid asc ");
		else filter.setOrderByClause(getSortingCondition());						
		
		filter.or().andTeamidEqualTo(aTeamId).andSiteEqualTo(aSite);
		return filter;
	}
}
