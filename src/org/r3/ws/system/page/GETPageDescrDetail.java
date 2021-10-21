package org.r3.ws.system.page;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.pagedescr.PageDescrDTO;
import org.r3.db.cms.pagedescr.PageDescrPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETPageDescrDetail extends ServicePattern
{
    private String pageId;
    private String site;
    private String languageCode;
    
	public GETPageDescrDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String aLanguageCode)
	{
		super(ctx, serviceEnvironment);
		pageId = aCardId;
		site = aSite;
		languageCode = aLanguageCode;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		PageDescrPersistence p = PageDescrPersistence.createPersistenceObject(pcfg, aSession);						
		PageDescrDTO dto1 = p.selectBySitePageidLanguagecode(site, pageId, languageCode, pcfg.getPersistenceConfigInfo());
		return dto1;
	}

}
