package org.r3.ws.bbs.thread;


import org.r3.db.bbs.bbsthread.BBSThreadCriteria;
import org.r3.db.bbs.bbsthread.BBSThreadFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class BBSThreadQueryActionForm extends DataTableQueryActionForm
{    		
	public BBSThreadFilter getSearchCondition(String aSite, String aTopicId)
	{
		BBSThreadFilter filter = new BBSThreadFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" threadid ");
		else filter.setOrderByClause(getSortingCondition());
				
		BBSThreadCriteria criteria = filter.or().andSiteEqualTo(aSite).andTopicidEqualTo(aTopicId);
		
		return filter;
	}
}
