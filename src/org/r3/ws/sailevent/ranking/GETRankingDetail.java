package org.r3.ws.sailevent.ranking;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.ranking.RankingDTO;
import org.r3.db.sailevent.ranking.RankingPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETRankingDetail extends ServicePattern
{
    private String rankId;
    
	public GETRankingDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aRankId)
	{
		super(ctx, serviceEnvironment);
		rankId = aRankId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		RankingPersistence p = RankingPersistence.createPersistenceObject(pcfg, aSession);
						
		RankingDTO dto1 = p.selectByEventidRankid(senv.getRequestSiteId(), rankId, pcfg.getPersistenceConfigInfo());		
		return dto1;
	}

}
