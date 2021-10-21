package org.r3.ws.sailevent.rankinginstancedetailview;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.rankinginstancedetailview.RankingInstanceDetailViewDataTableAdapter;
import org.r3.db.sailevent.rankinginstancedetailview.RankingInstanceDetailViewFilter;
import org.r3.db.sailevent.rankinginstancedetailview.RankingInstanceDetailViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETRankingInstanceEntries extends ServicePattern
{
    private RankingInstanceEntriesQueryActionForm queryForm;
    private String instanceId;
    
	public GETRankingInstanceEntries(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anInstanceId, RankingInstanceEntriesQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		instanceId = anInstanceId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		RankingInstanceDetailViewPersistence p = RankingInstanceDetailViewPersistence.createPersistenceObject(pcfg, aSession);				
		RankingInstanceDetailViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), instanceId);
		
		RankingInstanceDetailViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
