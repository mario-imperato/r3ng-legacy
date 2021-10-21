package org.r3.ws.system.siteproperty;


import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.siteproperty.SitePropertyFilter;
import org.r3.db.system.siteproperty.SitePropertyPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSiteProperties extends ServicePattern
{
    private SitePropertyQueryActionForm queryForm;
    
	public GETSiteProperties(ServletContext ctx,  ServiceEnvironment serviceEnvironment, SitePropertyQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SitePropertyPersistence p = SitePropertyPersistence.createPersistenceObject(pcfg, aSession);

		SitePropertyFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());						
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}
