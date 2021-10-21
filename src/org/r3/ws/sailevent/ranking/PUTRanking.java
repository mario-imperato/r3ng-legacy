package org.r3.ws.sailevent.ranking;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.ranking.RankingDTO;
import org.r3.db.sailevent.ranking.RankingPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTRanking extends ServicePattern
{
    private RankingActionForm actionForm;
    private String rankId;
    
	public PUTRanking(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aRankId, RankingActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		rankId = aRankId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		RankingPersistence p = RankingPersistence.createPersistenceObject(pcfg, aSession);		
				
		RankingDTO dto1 = actionForm.getDTO4Update(senv.getRequestSiteId(), rankId);
		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());	    
		return dto1;
	}
}
