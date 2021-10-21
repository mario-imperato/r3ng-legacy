package org.r3.ws.system.page;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.pagedescr.PageDescrDTO;
import org.r3.db.cms.pagedescr.PageDescrPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTPageDescrDetail extends ServicePattern
{
    private String pageId;
    private String site;
    private String languageCode;
    private PageDescrActionForm actionForm;
    
	public PUTPageDescrDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String aLanguageCode, PageDescrActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		pageId = aCardId;
		site = aSite;
		languageCode = aLanguageCode;
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		PageDescrPersistence p = PageDescrPersistence.createPersistenceObject(pcfg, aSession);	
		
		PageDescrDTO dto1 = p.selectBySitePageidLanguagecode(site, pageId, languageCode, pcfg.getPersistenceConfigInfo());
        if (dto1 == null)
        {
		   dto1 = actionForm.getDTO4Insert(site, pageId, languageCode);
		   p.insert(dto1, pcfg.getPersistenceConfigInfo());
        }
        else 
        {
           dto1 = actionForm.getDTO4Update(dto1);           
           if (dto1.hasPendingChanges())
               p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
        }
        
		return dto1;		
	}

}
