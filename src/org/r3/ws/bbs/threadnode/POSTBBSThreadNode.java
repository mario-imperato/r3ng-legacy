package org.r3.ws.bbs.threadnode;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodeDTO;
import org.r3.db.bbs.bbsthreadnode.BBSThreadNodePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTBBSThreadNode extends ServicePattern
{
    private BBSThreadNodeActionForm actionForm;
    private String topicId;
    private String threadId;
    
	public POSTBBSThreadNode(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, String aThreadId, BBSThreadNodeActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		topicId = aTopicId;
		threadId = aThreadId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSThreadNodePersistence p = BBSThreadNodePersistence.createPersistenceObject(pcfg, aSession);
		
		String parentNodeId = actionForm.getNodeparentid();
		String parentNodePath = null;
		if (parentNodeId != null)
		{
			BBSThreadNodeDTO dtoParent = p.selectByThreadnodeid(parentNodeId, pcfg.getPersistenceConfigInfo());	
			if (dtoParent != null)
			{
				parentNodePath = dtoParent.getNodepath();
			}
			else parentNodeId = null;
		}
		
		BBSThreadNodeDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId(), topicId, threadId, parentNodeId, parentNodePath, senv.getUserProfile().getUserid());		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    
	    BBSThreadPersistence pthread = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);
		pthread.updatePostCountersOnAddBySiteThreadid(senv.getRequestSiteId(), threadId, dto1.getThreadnodeid(), pcfg.getPersistenceConfigInfo());

		return dto1;
	}

}
