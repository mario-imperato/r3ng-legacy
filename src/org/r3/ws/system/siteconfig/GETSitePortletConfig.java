package org.r3.ws.system.siteconfig;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.siteportletcfg.SitePortletConfigDataTableAdapter;
import org.r3.db.system.siteportletcfg.SitePortletConfigPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSitePortletConfig extends ServicePattern
{
    private String pageid;
    
	public GETSitePortletConfig(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aPageId)
	{
		super(ctx, serviceEnvironment);
		pageid = aPageId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		SitePortletConfigPersistence p = SitePortletConfigPersistence.createPersistenceObject(pcfg, aSession);				
		
		SitePortletConfigDataTableAdapter dt = p.queryBySitePageid(senv.getRequestSiteId(), pageid, pcfg.getPersistenceConfigInfo());
		return dt;
	}



}
