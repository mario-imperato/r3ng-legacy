package org.r3.ws.bbs.thread;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbsthread.BBSThreadDTO;
import org.r3.db.bbs.bbsthread.BBSThreadPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTBBSThread extends ServicePattern
{
    private BBSThreadActionForm actionForm;
    private String topicId;
    
	public POSTBBSThread(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, BBSThreadActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		topicId = aTopicId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSThreadPersistence p = BBSThreadPersistence.createPersistenceObject(pcfg, aSession);
		BBSThreadDTO dto1 = null;
		
		String threadId = actionForm.getThreadid();
		if (threadId != null)
		{
		   dto1 = p.selectBySiteThreadid(getServiceEnvironment().getRequestSiteId(), threadId, pcfg.getPersistenceConfigInfo());
		}
		
		if (dto1 != null)
			return new RestServiceDTO(Status.fail, "RESTDTO_ERROR_ID_DUP", "Codice Thread gia' presenta a sistema");
				
		dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId(), topicId, senv.getUserProfile().getUserid());		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	    
		return dto1;
	}

}
