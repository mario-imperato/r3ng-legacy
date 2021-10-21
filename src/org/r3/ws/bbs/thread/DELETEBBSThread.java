package org.r3.ws.bbs.thread;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadDTO;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEBBSThread extends ServicePattern
{
    private String threadId;
    
	public DELETEBBSThread(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, String aThreadId)
	{
		super(ctx, serviceEnvironment);
		threadId = aThreadId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSThreadPersistence p = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);
		BBSThreadDTO topicDTO = p.selectBySiteThreadid(senv.getRequestSiteId(), threadId, pcfg.getPersistenceConfigInfo());

		if (topicDTO != null)
		{            
			BBSThreadNodePersistence pthreadnode = BBSThreadNodePersistence.createPersistenceObject(pcfg, aSession);
    		pthreadnode.deleteBySiteThreadid(senv.getRequestSiteId(), threadId, pcfg.getPersistenceConfigInfo());
    		
			p.deleteBySiteThreadid(senv.getRequestSiteId(), threadId, pcfg.getPersistenceConfigInfo());
		}
		
		return RestServiceDTO.SuccessDTO;
	}

}
