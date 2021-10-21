package org.r3.ws.bbs.topic;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbstopic.BBSTopicDTO;
import org.r3.db.bbs.bbstopic.BBSTopicPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTBBSTopic extends ServicePattern
{
	private String topicId;
    private BBSTopicActionForm actionForm;
    
	public PUTBBSTopic(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId, BBSTopicActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		topicId = aTopicId;
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSTopicPersistence p = BBSTopicPersistence.createPersistenceObject(pcfg, aSession); 
				
		BBSTopicDTO dto1 = actionForm.getDTO4Update(senv.getRequestSiteId(), topicId);		
	    int nr = p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
	    	    
		return dto1;
	}

}
