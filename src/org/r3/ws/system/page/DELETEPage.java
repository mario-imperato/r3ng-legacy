package org.r3.ws.system.page;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.page.PagePersistence;
import org.r3.db.cms.pagedescr.PageDescrPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEPage extends ServicePattern
{    
    private String site;
    private String pageId;
	
	
	public DELETEPage(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aPageId)
	{
		super(ctx, serviceEnvironment);
		
		site = aSite;
		pageId = aPageId;
		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		PageDescrPersistence pdescr = PageDescrPersistence.createPersistenceObject(pcfg, aSession);
		pdescr.deleteBySitePageid(site, pageId, pcfg.getPersistenceConfigInfo());

		PagePersistence p = PagePersistence.createPersistenceObject(pcfg, aSession);
		p.deleteBySitePageid(site, pageId, pcfg.getPersistenceConfigInfo());
			    
		return RestServiceDTO.SuccessDTO;
	}
}
