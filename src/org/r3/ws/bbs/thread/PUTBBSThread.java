package org.r3.ws.bbs.thread;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadDTO;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTBBSThread extends ServicePattern
{
	private String threadId;
    private BBSThreadActionForm actionForm;
    
	public PUTBBSThread(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, String aThreadId, BBSThreadActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		threadId = aThreadId;
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSThreadPersistence p = BBSThreadPersistence.createPersistenceObject(pcfg, aSession); 
				
		BBSThreadDTO dto1 = actionForm.getDTO4Update(senv.getRequestSiteId(), threadId);		
	    int nr = p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
	    	    
		return dto1;
	}

}
