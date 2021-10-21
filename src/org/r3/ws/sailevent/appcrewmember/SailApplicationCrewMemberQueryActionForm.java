package org.r3.ws.sailevent.appcrewmember;

import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberCriteria;
import org.r3.db.sailevent.appcrewmember.SailApplicationCrewMemberFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailApplicationCrewMemberQueryActionForm extends DataTableQueryActionForm
{    
    
	public SailApplicationCrewMemberFilter getSearchCondition(String anAppId, boolean activeOnly)
	{
		SailApplicationCrewMemberFilter filter = new SailApplicationCrewMemberFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" crewmemberid asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		SailApplicationCrewMemberCriteria c = filter.or().andApplicationidEqualTo(anAppId);
		if (activeOnly)
			c.andRecstatusEqualTo(RecordStatus.sys_recact.toString());
		
		return filter;
	}
}
