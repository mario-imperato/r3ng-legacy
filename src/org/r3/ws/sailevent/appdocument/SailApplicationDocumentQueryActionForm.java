package org.r3.ws.sailevent.appdocument;

import org.r3.db.sailevent.appdocument.SailApplicationDocumentFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailApplicationDocumentQueryActionForm extends DataTableQueryActionForm
{    
    
	public SailApplicationDocumentFilter getSearchCondition(String anAppId, String aCrewMemberId)
	{
		SailApplicationDocumentFilter filter = new SailApplicationDocumentFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" documentid asc ");
		else filter.setOrderByClause(getSortingCondition());
		
        filter.or().andApplicationidEqualTo(anAppId).andCrewmemberidEqualTo(aCrewMemberId);
		return filter;
	}
}
