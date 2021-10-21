package org.r3.ws.bbs.threadnode;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodeDTO;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETBBSThreadNodeDetail extends ServicePattern
{
    private String topicId;
    private String threadId;	
	private String threadNodeId;
    
	public GETBBSThreadNodeDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, String aThreadId, String aThreadNodeId)
	{
		super(ctx, serviceEnvironment);
		topicId = aTopicId;
		threadId = aThreadId;
		threadNodeId = aThreadNodeId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSThreadNodePersistence p = BBSThreadNodePersistence.createPersistenceObject(pcfg, aSession);
						
		BBSThreadNodeDTO dto1 = p.selectByThreadnodeid(threadNodeId, pcfg.getPersistenceConfigInfo());		
		return dto1;
	}

}
