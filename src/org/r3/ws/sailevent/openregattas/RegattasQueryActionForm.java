package org.r3.ws.sailevent.openregattas;

import org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class RegattasQueryActionForm extends DataTableQueryActionForm
{	
    
	public OpenRegattasViewFilter getSearchCondition(String aDomain)
	{
		OpenRegattasViewFilter filter = new OpenRegattasViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" title asc ");
		else filter.setOrderByClause(getSortingCondition());
				
		filter.or().andDomainEqualTo(aDomain);
		return filter;
	}

}
