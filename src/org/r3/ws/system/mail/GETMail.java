package org.r3.ws.system.mail;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.outmailspooler.OutMailSpoolerDataTableAdapter;
import org.r3.db.system.outmailspooler.OutMailSpoolerFilter;
import org.r3.db.system.outmailspooler.OutMailSpoolerPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETMail extends ServicePattern
{
    private MailQueryActionForm queryForm;
    
	public GETMail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, MailQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		OutMailSpoolerPersistence p = OutMailSpoolerPersistence.createPersistenceObject(pcfg, aSession);				
		OutMailSpoolerFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		OutMailSpoolerDataTableAdapter dt = p.queryWithCounters(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}

}
