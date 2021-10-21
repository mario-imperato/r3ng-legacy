package org.r3.ws.bbs.threadnode;


import javax.ws.rs.QueryParam;

import org.r3.db.DTOBase;
import org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewCriteria;
import org.r3.db.bbs.bbsthreadnodeview.BBSThreadNodeViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class BBSThreadNodeQueryActionForm extends DataTableQueryActionForm
{    		
	@QueryParam("upperthreadnodeid")
    private String upperthreadnodeid;

	public String getUpperthreadnodeid()
	{
		return DTOBase.nullOnEmpty(upperthreadnodeid);
	}
	
	public BBSThreadNodeViewFilter getSearchCondition(String aSite, String aTopicId, String aThreadId)
	{
		BBSThreadNodeViewFilter filter = new BBSThreadNodeViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" threadnodeid ");
		else filter.setOrderByClause(getSortingCondition());
				
		BBSThreadNodeViewCriteria criteria = filter.or().andSiteEqualTo(aSite).andThreadidEqualTo(aThreadId);
		
		return filter;
	}
	
	public BBSThreadNodeViewFilter getTimelinePrimaryNodesSearchCondition(String aSite, String aTopicId, String aThreadId)
	{
		BBSThreadNodeViewFilter filter = new BBSThreadNodeViewFilter();
		
		filter.setOrderByClause(" threadnodeid desc ");		
		filter.setLimitFetch(getiDisplayLength());
		BBSThreadNodeViewCriteria criteria = filter.or().andSiteEqualTo(aSite).andThreadidEqualTo(aThreadId)
				.andNodeparentidIsNull()                            // Sto cercando i nodi radice senza padre.
				.andThreadnodeidLessThan(getUpperthreadnodeid());   // Sto cercando i nodi con id inferiore a. Poichè sto ordinando discending sto paginando..
		
		return filter;
	}
	
	public BBSThreadNodeViewFilter getTimelineChildNodesSearchCondition(String aSite, String aTopicId, String aThreadId, String aBetweenFromNodeParentId, String aBetweenToNodeParentId)
	{
		BBSThreadNodeViewFilter filter = new BBSThreadNodeViewFilter();
		
		filter.setOrderByClause(" threadnodeid desc ");				
		BBSThreadNodeViewCriteria criteria = filter.or().andSiteEqualTo(aSite).andThreadidEqualTo(aThreadId).andNodeparentidBetween(aBetweenFromNodeParentId, aBetweenToNodeParentId);
		
		return filter;
	}
}
