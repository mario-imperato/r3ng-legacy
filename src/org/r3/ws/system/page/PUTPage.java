package org.r3.ws.system.page;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.page.PageDTO;
import org.r3.db.cms.page.PagePersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTPage extends ServicePattern
{
    private PageActionForm actionForm;
    private String pageId;
    
	public PUTPage(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aPageId, PageActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		pageId = aPageId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		PagePersistence p = PagePersistence.createPersistenceObject(pcfg, aSession);	
		
		PageDTO dto1 = actionForm.getDTO4Update(getServiceEnvironment().getRequestSiteId(), pageId);		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
	    LUTManager.getLUTManager().invalidateLUT(LUTName.cms_page);	        		    	    		       	
		return dto1;
	}

}
