package org.r3.ws.bbs.topic;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.bbs.bbstopic.BBSTopicDTO;
import org.r3.db.bbs.bbstopic.BBSTopicPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETBBSTopicDetail extends ServicePattern
{
    private String topicId;
    
	public GETBBSTopicDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aTopicId)
	{
		super(ctx, serviceEnvironment);
		topicId = aTopicId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		BBSTopicPersistence p = BBSTopicPersistence.createPersistenceObject(pcfg, aSession);
						
		BBSTopicDTO dto1 = p.selectBySiteTopicid(senv.getRequestSiteId(), topicId, pcfg.getPersistenceConfigInfo());		
		return dto1;
	}

}
