package org.r3.ws.system.sms;

import org.r3.db.system.smsqueue.SMSQueueCriteria;
import org.r3.db.system.smsqueue.SMSQueueFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class SMSQueryActionForm extends DataTableQueryActionForm
{    
	public SMSQueueFilter getSearchCondition(String aSite)
	{
		SMSQueueFilter filter = new SMSQueueFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" rectimestamp desc ");
		else filter.setOrderByClause(getSortingCondition());
				
		SMSQueueCriteria criteria = filter.or().andSiteEqualTo(aSite);
		
		return filter;
	}
}
