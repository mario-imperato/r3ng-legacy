package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.wbs.wbsnode.WBSNodeDataTableAdapter;
import org.r3.db.wbs.wbsnode.WBSNodeFilter;
import org.r3.db.wbs.wbsnode.WBSNodePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWBSNodeChildren extends ServicePattern
{
	private WBSNodeQueryActionForm queryForm;
    private String wbsId;
    private String wbsNodeId;
    
	public GETWBSNodeChildren(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aWbsId, String aWbsNodeId, WBSNodeQueryActionForm aQueryActionForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryActionForm;
		wbsId = aWbsId;
		wbsNodeId = aWbsNodeId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		WBSNodePersistence p = WBSNodePersistence.createPersistenceObject(pcfg, aSession);				
		WBSNodeFilter filter = new  WBSNodeFilter();
		filter.or().andNodeparentidEqualTo(wbsNodeId).andSiteEqualTo(senv.getRequestSiteId()).andWbsidEqualTo(wbsId);
		filter.setOrderByClause(" nodeorder ");
		WBSNodeDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
