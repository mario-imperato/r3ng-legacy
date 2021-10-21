package org.r3.ws.system.site;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.site.SiteDataTableAdapter;
import org.r3.db.system.site.SiteFilter;
import org.r3.db.system.site.SitePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSites extends ServicePattern
{
    private SiteQueryActionForm queryForm;
    
	public GETSites(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SiteQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		SitePersistence p = SitePersistence.createPersistenceObject(pcfg, aSession);				
		SiteFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		SiteDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());				
		return dt;		
	}

}
