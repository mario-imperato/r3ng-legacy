package org.r3.ws.wbs;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.project.wbsnodeteammemberprofile.WBSNodeTeamMemberProfileFilter;
import org.r3.db.project.wbsnodeteammemberprofileview.WBSNodeTeamMemberProfileViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class WBSNodeTeamProfileQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("nodetype")
    private String nodetype;

	public String getNodetype()
	{
		return DTOBase.nullOnEmpty(nodetype);
	}
	
	public WBSNodeTeamMemberProfileViewFilter getSearchCondition(String aSite, String aWbsId)
	{
		WBSNodeTeamMemberProfileViewFilter filter = new WBSNodeTeamMemberProfileViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" profileid asc ");
		else filter.setOrderByClause(getSortingCondition());						
		
		filter.or().andSiteEqualTo(aSite).andWbsidEqualTo(aWbsId);
		return filter;
	}
	
	public WBSNodeTeamMemberProfileFilter getSearchCondition(String aWBSNodeId)
	{
		WBSNodeTeamMemberProfileFilter filter = new WBSNodeTeamMemberProfileFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" profileid asc ");
		else filter.setOrderByClause(getSortingCondition());						
		
		filter.or().andWbsnodeidEqualTo(aWBSNodeId);
		return filter;
	}
}
