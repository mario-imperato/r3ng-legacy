package org.r3.ws.wbs;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.utils.DataTableQueryActionForm;
import org.r3.db.wbs.wbs.WBSCriteria;
import org.r3.db.wbs.wbs.WBSFilter;


public class WBSQueryActionForm extends DataTableQueryActionForm
{    
	@QueryParam("assignee")
	private String assignee;
	
	public String getAssignee()
	{
	    return DTOBase.nullOnEmpty(assignee);	
	}
		
	public WBSFilter getSearchCondition(String aSite)
	{
		WBSFilter filter = new WBSFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" rectimestamp desc ");
		else filter.setOrderByClause(getSortingCondition());
				
		WBSCriteria criteria = filter.or().andSiteEqualTo(aSite).andAssigneeEqualTo(aSite, getAssignee());
		
		return filter;
	}
}
