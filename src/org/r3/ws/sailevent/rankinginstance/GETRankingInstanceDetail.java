package org.r3.ws.sailevent.rankinginstance;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDTO;
import org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETRankingInstanceDetail extends ServicePattern
{
    private String instanceId;
    
	public GETRankingInstanceDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aRankId)
	{
		super(ctx, serviceEnvironment);
		instanceId = aRankId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		RankingInstanceViewPersistence p = RankingInstanceViewPersistence.createPersistenceObject(pcfg, aSession);
						
		RankingInstanceViewDTO dto1 = p.selectByEventidInstanceid(senv.getRequestSiteId(), instanceId, pcfg.getPersistenceConfigInfo());		
		return dto1;
	}

}
