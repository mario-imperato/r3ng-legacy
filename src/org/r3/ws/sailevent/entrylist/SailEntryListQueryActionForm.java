package org.r3.ws.sailevent.entrylist;


import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.sailevent.entrylist.SailEntryListFilter;
import org.r3.db.sailevent.homeentrylist.SailHomeEntryListFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SailEntryListQueryActionForm extends DataTableQueryActionForm
{
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

	public SailHomeEntryListFilter getHomeEntryListSearchCondition(String anEventId, int limitSearch)
	{
		SailHomeEntryListFilter filter = new SailHomeEntryListFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" addtohomeentrylist desc, yachtname asc ");
		else filter.setOrderByClause(getSortingCondition());
		
		filter.setLimitFetch(limitSearch);
		
		filter.or().andEventidEqualTo(anEventId);
		return filter;
	}

	public SailEntryListFilter getSearchCondition(String anEventId)
	{
		SailEntryListFilter filter = new SailEntryListFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" yachtname asc ");
		else filter.setOrderByClause(getSortingCondition());

		filter.or().andEventidEqualTo(anEventId).andRacegroupEqualTo(getRacegroup()).andRaceclassEqualTo(getRaceclass());
		return filter;
	}
}
