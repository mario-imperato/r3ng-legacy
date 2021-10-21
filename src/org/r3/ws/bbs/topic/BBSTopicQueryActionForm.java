package org.r3.ws.bbs.topic;


import org.r3.db.bbs.bbstopicview.BBSTopicViewCriteria;
import org.r3.db.bbs.bbstopicview.BBSTopicViewFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class BBSTopicQueryActionForm extends DataTableQueryActionForm
{    		
	public BBSTopicViewFilter getSearchCondition(String aSite)
	{
		BBSTopicViewFilter filter = new BBSTopicViewFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" topicid desc ");
		else filter.setOrderByClause(getSortingCondition());
				
		BBSTopicViewCriteria criteria = filter.or().andSiteEqualTo(aSite);
		
		return filter;
	}
}
