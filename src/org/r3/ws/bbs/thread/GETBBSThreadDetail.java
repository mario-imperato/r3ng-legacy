package org.r3.ws.bbs.thread;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadDTO;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETBBSThreadDetail extends ServicePattern
{
    private String threadId;
    private String topicId;
    
	public GETBBSThreadDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, String aThreadId)
	{
		super(ctx, serviceEnvironment);
		threadId = aThreadId;
		topicId =aTopicId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSThreadPersistence p = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);
						
		BBSThreadDTO dto1 = p.selectBySiteThreadid(senv.getRequestSiteId(), threadId, pcfg.getPersistenceConfigInfo());					
		return dto1;
	}

}
