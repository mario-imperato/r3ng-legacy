package org.r3.ws.sailevent.application;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.sailevent.application.SailApplicationFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailApplicationQueryActionForm extends DataTableQueryActionForm
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
    
	public SailApplicationFilter getSearchCondition(String anEventId)
	{
		SailApplicationFilter filter = new SailApplicationFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" yachtname asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		filter.or().andUseridEqualTo(getUserid()).andEventidEqualTo(anEventId);
		return filter;
	}
}
