package org.r3.ws.sailevent.ranking;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.ranking.RankingDTO;
import org.r3.db.sailevent.ranking.RankingPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTRanking extends ServicePattern
{
    private RankingActionForm actionForm;
    
	public POSTRanking(ServletContext ctx,  ServiceEnvironment serviceEnvironment, RankingActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		RankingPersistence p = RankingPersistence.createPersistenceObject(pcfg, aSession);
		
		RankingDTO dto1 = actionForm.getDTO4Insert(senv.getRequestSiteId());		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());	    
	    
		return dto1;
	}

}
