package org.r3.ws.system.sms;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.smsqueue.SMSQueueDataTableAdapter;
import org.r3.db.system.smsqueue.SMSQueueFilter;
import org.r3.db.system.smsqueue.SMSQueuePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSMSes extends ServicePattern
{
    private SMSQueryActionForm queryForm;
    
	public GETSMSes(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SMSQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		SMSQueuePersistence p = SMSQueuePersistence.createPersistenceObject(pcfg, aSession);				
		SMSQueueFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		SMSQueueDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
