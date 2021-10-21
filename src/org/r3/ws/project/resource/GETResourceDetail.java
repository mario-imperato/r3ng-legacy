package org.r3.ws.project.resource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.resource.ResourceDTO;
import org.r3.db.project.resource.ResourcePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETResourceDetail extends ServicePattern
{
    private String resourceId;
    
	public GETResourceDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUserId)
	{
		super(ctx, serviceEnvironment);
		resourceId = aUserId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		ResourcePersistence p = ResourcePersistence.createPersistenceObject(pcfg, aSession);
						
		ResourceDTO dto1 = p.selectBySiteResourceid(senv.getRequestSiteId(), resourceId, pcfg.getPersistenceConfigInfo());
		return dto1;
	}

}
