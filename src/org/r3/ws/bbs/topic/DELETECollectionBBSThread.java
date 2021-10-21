package org.r3.ws.bbs.topic;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodePersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETECollectionBBSThread extends ServicePattern
{
    private String topicId;
    private BBSTopicActionForm actionForm;
    
	public DELETECollectionBBSThread(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, BBSTopicActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		topicId = aTopicId;
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSThreadPersistence p = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);

		String[] tid = actionForm.getThreadid();
		if (tid != null && tid.length > 0)
		{
			BBSThreadNodePersistence pthreadnode = BBSThreadNodePersistence.createPersistenceObject(pcfg, aSession);
			for(String t : tid)
			{				
	    		pthreadnode.deleteBySiteThreadid(senv.getRequestSiteId(), t, pcfg.getPersistenceConfigInfo());	    		
				p.deleteBySiteThreadid(senv.getRequestSiteId(), t, pcfg.getPersistenceConfigInfo());				
			}
		}
				
		return RestServiceDTO.SuccessDTO;
	}

}
