package org.r3.ws.system.mail;

import org.r3.db.system.outmailspooler.OutMailSpoolerCriteria;
import org.r3.db.system.outmailspooler.OutMailSpoolerFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class MailQueryActionForm extends DataTableQueryActionForm
{    
	public OutMailSpoolerFilter getSearchCondition(String aSite)
	{
		OutMailSpoolerFilter filter = new OutMailSpoolerFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" messageid desc ");
		else filter.setOrderByClause(getSortingCondition());
				
		OutMailSpoolerCriteria criteria = filter.or().andSiteEqualTo(aSite);
		
		return filter;
	}
}
