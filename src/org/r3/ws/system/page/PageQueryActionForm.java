package org.r3.ws.system.page;

import org.r3.db.cms.page.PageCriteria;
import org.r3.db.cms.page.PageFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class PageQueryActionForm extends DataTableQueryActionForm
{    	
	public PageFilter getSearchCondition(String aSite)
	{
		PageFilter filter = new PageFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" pageorder asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		PageCriteria criteria = filter.or().andSiteEqualTo(aSite);
		
		return filter;
	}
}
