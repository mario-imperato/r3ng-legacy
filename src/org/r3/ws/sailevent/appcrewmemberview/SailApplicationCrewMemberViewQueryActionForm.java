package org.r3.ws.sailevent.appcrewmemberview;

import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewCriteria;
import org.r3.db.sailevent.appcrewmemberview.SailApplicationCrewMemberViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailApplicationCrewMemberViewQueryActionForm extends DataTableQueryActionForm
{    
    
	public SailApplicationCrewMemberViewFilter getSearchCondition(String anAppId, boolean activeOnly)
	{
		SailApplicationCrewMemberViewFilter filter = new SailApplicationCrewMemberViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" crewmemberid asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		SailApplicationCrewMemberViewCriteria c = filter.or().andApplicationidEqualTo(anAppId);
		if (activeOnly)
			c.andRecstatusEqualTo(RecordStatus.sys_recact.toString());
		
		return filter;
	}
}
