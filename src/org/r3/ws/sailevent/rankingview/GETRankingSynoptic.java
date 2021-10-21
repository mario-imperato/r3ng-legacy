package org.r3.ws.sailevent.rankingview;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.rankingview.RankingViewFilter;
import org.r3.db.sailevent.rankingview.RankingViewPersistence;
import org.r3.db.sailevent.rankingview.RankingViewSynopticDataTableAdapter;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETRankingSynoptic extends ServicePattern
{
    private SailRankingViewQueryActionForm queryForm;
    
	public GETRankingSynoptic(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SailRankingViewQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		RankingViewPersistence p = RankingViewPersistence.createPersistenceObject(pcfg, aSession);				
		RankingViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		RankingViewSynopticDataTableAdapter dt = p.querySynoptic(filter, pcfg.getPersistenceConfigInfo());
		return dt;
	}



}
