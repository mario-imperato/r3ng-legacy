package org.r3.ws.sailevent.ranking;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.ranking.RankingDataTableAdapter;
import org.r3.db.sailevent.ranking.RankingFilter;
import org.r3.db.sailevent.ranking.RankingPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailRankings extends ServicePattern
{
    private SailRankingQueryActionForm queryForm;
    
	public GETSailRankings(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SailRankingQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		RankingPersistence p = RankingPersistence.createPersistenceObject(pcfg, aSession);				
		RankingFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		RankingDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
