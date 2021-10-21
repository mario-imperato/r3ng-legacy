package org.r3.ws.sailevent.rankinginstance;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewDataTableAdapter;
import org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewFilter;
import org.r3.db.sailevent.rankinginstanceview.RankingInstanceViewPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETRankingInstances extends ServicePattern
{
    private RankingInstancesQueryActionForm queryForm;
    private String rankId;
    
	public GETRankingInstances(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aRankId, RankingInstancesQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		rankId = aRankId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		RankingInstanceViewPersistence p = RankingInstanceViewPersistence.createPersistenceObject(pcfg, aSession);				
		RankingInstanceViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), rankId);
		
		RankingInstanceViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
