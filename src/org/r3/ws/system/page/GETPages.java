package org.r3.ws.system.page;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.page.PageDataTableAdapter;
import org.r3.db.cms.page.PageFilter;
import org.r3.db.cms.page.PagePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETPages extends ServicePattern
{
    private PageQueryActionForm queryForm;
    
	public GETPages(ServletContext ctx,  ServiceEnvironment serviceEnvironment, PageQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		PagePersistence p = PagePersistence.createPersistenceObject(pcfg, aSession);				
		PageFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		PageDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		
		return dt;
	}



}
