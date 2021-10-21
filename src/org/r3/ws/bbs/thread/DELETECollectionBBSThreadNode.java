package org.r3.ws.bbs.thread;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETECollectionBBSThreadNode extends ServicePattern
{
    private String topicId;
    private String threadId;
    private BBSThreadActionForm actionForm;
    
	public DELETECollectionBBSThreadNode(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, String aThreadId, BBSThreadActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		topicId = aTopicId;
		threadId = aThreadId;
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSThreadNodePersistence p = BBSThreadNodePersistence.createPersistenceObject(pcfg, aSession);

		int nr = 0;
		
		String[] tid = actionForm.getThreadnodeid();
		if (tid != null && tid.length > 0)
		{
			for(String t : tid)
			{
				nr += p.deleteByThreadnodeid(t, pcfg.getPersistenceConfigInfo());				
			}
		}
				
		if (nr > 0)
		{
	      BBSThreadPersistence pthread = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);
		  pthread.updatePostCountersOnDeleteBySiteThreadid(senv.getRequestSiteId(), threadId, nr, pcfg.getPersistenceConfigInfo());
		}
		
		return RestServiceDTO.SuccessDTO;
	}

}
