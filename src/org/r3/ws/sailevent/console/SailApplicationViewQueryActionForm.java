package org.r3.ws.sailevent.console;

import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.sailevent.applicationview.SailApplicationViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailApplicationViewQueryActionForm extends DataTableQueryActionForm
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
    
    @QueryParam("racegroup")
    private String racegroup;

    @QueryParam("raceclass")
    private String raceclass;

    public String getRacegroup()
    {
    	String s = getsSearch();
    	if (s == null)
   		  s = DTOBase.nullOnEmpty(racegroup);
    	else 
    	{
    		int ndx = s.indexOf(";");
    		if (ndx > 0)
    			s = s.substring(0, ndx);
    	}
    	  
    	return s;
    }

    public String getRaceclass()
    {
    	String s = getsSearch();
    	if (s == null)
   		  s = DTOBase.nullOnEmpty(raceclass);
    	else 
    	{
    		int ndx = s.indexOf(";");
    		if (ndx > 0)
    			s = s.substring(ndx + 1);
    		else s = null;
    	}
    	  
    	return s;
    }
    
	public SailApplicationViewFilter getSearchCondition(String anEventId)
	{
		SailApplicationViewFilter filter = new SailApplicationViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" yachtname asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		filter.or().andUseridEqualTo(getUserid()).andEventidEqualTo(anEventId).andRacegroupEqualTo(getRacegroup()).andRaceclassEqualTo(getRaceclass());
		return filter;
	}
}
