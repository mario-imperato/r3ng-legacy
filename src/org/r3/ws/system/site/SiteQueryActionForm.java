package org.r3.ws.system.site;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.system.site.SiteFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SiteQueryActionForm extends DataTableQueryActionForm
{	
	@QueryParam("sitetype")
    private String sitetype;
		
	public String getSitetype()
	{
		return DTOBase.nullOnEmpty(sitetype);
	}

	public void setSitetype(String sitetype)
	{
		this.sitetype = sitetype;
	}

	public SiteFilter getSearchCondition(String aDomain)
	{
		SiteFilter filter = new SiteFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" sitedescr asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		filter.or().andSiteIsChildOf(aDomain).andSitetypeEqualTo(sitetype);		
		return filter;
	}

}
