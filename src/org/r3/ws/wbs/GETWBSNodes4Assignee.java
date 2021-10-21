package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.wbs.wbsnode.WBSNodeDataTableAdapter;
import org.r3.db.wbs.wbsnode.WBSNodeFilter;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWBSNodes4Assignee extends ServicePattern
{
	private WBSNodeQueryActionForm queryForm;
    private String actorId;
    
	public GETWBSNodes4Assignee(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anActorId, WBSNodeQueryActionForm aQueryActionForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryActionForm;
		actorId = anActorId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		WBSNodePersistence p = WBSNodePersistence.createPersistenceObject(pcfg, aSession);				
		WBSNodeFilter filter = new  WBSNodeFilter();
		
		filter.or().andCompletionstatusNotEqualTo("completed").andSiteEqualTo(senv.getRequestSiteId()).andNodetypeEqualTo("action").andAssignedtoEqualTo(actorId);
		filter.setOrderByClause(" wbsid, nodesect ");
		WBSNodeDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
