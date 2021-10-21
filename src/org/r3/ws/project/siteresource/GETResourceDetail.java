package org.r3.ws.project.siteresource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.siteresource.SiteResourceDTO;
import org.r3.db.project.siteresource.SiteResourcePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETResourceDetail extends ServicePattern
{
    private String resourceId;
    
	public GETResourceDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aResourceId)
	{
		super(ctx, serviceEnvironment);
		resourceId = aResourceId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SiteResourcePersistence p = SiteResourcePersistence.createPersistenceObject(pcfg, aSession);						
		SiteResourceDTO dto1 = p.selectBySiteResourceid(senv.getRequestSiteId(), resourceId, pcfg.getPersistenceConfigInfo());		
		
		return dto1;
	}

}
