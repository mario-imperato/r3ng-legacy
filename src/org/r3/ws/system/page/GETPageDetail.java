package org.r3.ws.system.page;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.page.PageDTO;
import org.r3.db.cms.page.PagePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETPageDetail extends ServicePattern
{
    private String pageId;
    private String site;
    
	public GETPageDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aPageId)
	{
		super(ctx, serviceEnvironment);
		pageId = aPageId;
		site = aSite;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		PagePersistence p = PagePersistence.createPersistenceObject(pcfg, aSession);
						
		PageDTO dto1 = p.selectBySitePageid(site, pageId, pcfg.getPersistenceConfigInfo());
				
		return dto1;
	}

}
