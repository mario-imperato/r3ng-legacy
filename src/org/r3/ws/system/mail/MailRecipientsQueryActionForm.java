package org.r3.ws.system.mail;

import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientCriteria;
import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter;
import org.r3.db.utils.DataTableQueryActionForm;


public class MailRecipientsQueryActionForm extends DataTableQueryActionForm
{    
	public OutMailSpoolerRecipientFilter getSearchCondition(String aSite, String aMessageId)
	{
		OutMailSpoolerRecipientFilter filter = new OutMailSpoolerRecipientFilter();
		if (isDefaultSorting())
		     filter.setOrderByClause(" recipientid desc ");
		else filter.setOrderByClause(getSortingCondition());
				
		OutMailSpoolerRecipientCriteria criteria = filter.or().andSiteEqualTo(aSite).andMessageidEqualTo(aMessageId);
		
		return filter;
	}
}
