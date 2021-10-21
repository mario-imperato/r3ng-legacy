package org.r3.ws.wbs;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.wbs.wbsactor.WBSActorDataTableAdapter;
import org.r3.db.wbs.wbsactor.WBSActorFilter;
import org.r3.db.wbs.wbsactor.WBSActorPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETWBSActors extends ServicePattern
{
    private WBSActorQueryActionForm queryForm;
    private String wbsid;
    
	public GETWBSActors(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aWbsId, WBSActorQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		wbsid = aWbsId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		WBSActorPersistence p = WBSActorPersistence.createPersistenceObject(pcfg, aSession);				
		WBSActorFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId(), wbsid);
		
		WBSActorDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());				
		return dt;
	}



}
