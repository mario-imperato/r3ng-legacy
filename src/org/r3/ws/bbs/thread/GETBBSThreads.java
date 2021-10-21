package org.r3.ws.bbs.thread;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadDataTableAdapter;
import org.r3.db.bbs.bbsthread.BBSThreadFilter;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETBBSThreads extends ServicePattern
{
    private BBSThreadQueryActionForm queryForm;
    private String topicId;
    
	public GETBBSThreads(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, BBSThreadQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		topicId = aTopicId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		BBSThreadPersistence p = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);				
		BBSThreadFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), topicId);
		
		BBSThreadDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
				
		return dt;
	}

}
