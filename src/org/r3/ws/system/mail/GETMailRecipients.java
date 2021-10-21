package org.r3.ws.system.mail;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientDataTableAdapter;
import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientFilter;
import org.r3.db.system.outmailspoolerrecipient.OutMailSpoolerRecipientPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETMailRecipients extends ServicePattern
{
    private MailRecipientsQueryActionForm queryForm;
    private String messageId;
    
	public GETMailRecipients(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aMessageId, MailRecipientsQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		messageId = aMessageId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		OutMailSpoolerRecipientPersistence p = OutMailSpoolerRecipientPersistence.createPersistenceObject(pcfg, aSession);				
		OutMailSpoolerRecipientFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), messageId);
		
		OutMailSpoolerRecipientDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}

}
