package org.r3.ws.sailevent.ranking;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.rankinginstance.RankingInstancePersistence;
import org.r3.db.sailevent.rankinginstancedetail.RankingInstanceDetailPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETERankingInstances extends ServicePattern
{
    private RankingActionForm actionForm;
    private String rankId;
    
	public DELETERankingInstances(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aRankId, RankingActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		rankId = aRankId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		RankingInstancePersistence p = RankingInstancePersistence.createPersistenceObject(pcfg, aSession);		
		RankingInstanceDetailPersistence p1 = RankingInstanceDetailPersistence.createPersistenceObject(pcfg, aSession);
		
		String[] a = actionForm.getInstanceid();
		if (a != null && a.length > 0)
		{
			for(String instanceId : a)
			{
				p1.deleteByEventidInstanceid(senv.getRequestSiteId(), instanceId, pcfg.getPersistenceConfigInfo());
				p.deleteByEventidInstanceid(senv.getRequestSiteId(), instanceId, pcfg.getPersistenceConfigInfo());
			}
		}
		return RestServiceDTO.SuccessDTO;
	}
}
