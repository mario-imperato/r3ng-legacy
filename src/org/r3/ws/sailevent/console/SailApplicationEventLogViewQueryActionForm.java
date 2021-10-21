package org.r3.ws.sailevent.console;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.sailevent.appeventlogview.SailApplicationEventLogViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailApplicationEventLogViewQueryActionForm extends DataTableQueryActionForm
{
	@QueryParam("userid")
    private String userid;

    public String getUserid()
    {    	
    	return DTOBase.nullOnEmpty(userid);
    }

    public void setUserid(String aUserid)
    {
    	userid = aUserid;
    }
        
	public SailApplicationEventLogViewFilter getSearchCondition(String anEventId)
	{
		SailApplicationEventLogViewFilter filter = new SailApplicationEventLogViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" latest_ts desc ");
		else filter.setOrderByClause(getSortingCondition());
		
		filter.or().andUseridNotEqualTo(getUserid()).andSiteEqualTo(anEventId);
		return filter;
	}
}
