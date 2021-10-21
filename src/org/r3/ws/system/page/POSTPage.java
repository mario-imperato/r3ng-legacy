package org.r3.ws.system.page;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.page.PageDTO;
import org.r3.db.cms.page.PagePersistence;
import org.r3.db.cms.pagedescr.PageDescrDTO;
import org.r3.db.cms.pagedescr.PageDescrPersistence;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.RestServiceDTO.Status;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTPage extends ServicePattern
{
    private PageActionForm actionForm;
    
	public POSTPage(ServletContext ctx,  ServiceEnvironment serviceEnvironment, PageActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		PagePersistence p = PagePersistence.createPersistenceObject(pcfg, aSession);
		PageDTO pageDTO = null;
		
		String cardId = actionForm.getPageid();
		if (cardId != null)
		{
		   pageDTO = p.selectBySitePageid(getServiceEnvironment().getRequestSiteId(), cardId, pcfg.getPersistenceConfigInfo());
		}
		
		if (pageDTO != null)
			return new RestServiceDTO(Status.fail, "RESTDTO_ERROR_DUPCODE", "Codice Pagina gia' presenta a sistema");
		
		PageDTO dto1 = actionForm.getDTO4Insert(getServiceEnvironment().getRequestSiteId());		
	    p.insert(dto1, pcfg.getPersistenceConfigInfo());
	        		    	    
	    // Inserisco il System Title come titolo per la lingua correntemente usata. Debbo avere almneno un record di descrizione.
	    PageDescrPersistence pDescr = PageDescrPersistence.createPersistenceObject(pcfg, aSession);	
	    PageDescrDTO dtoDescr = actionForm.getDescrDTO4Insert(getServiceEnvironment().getRequestSiteId(), dto1.getPageid(), getServiceEnvironment().getRequestLanguage());
	    pDescr.insert(dtoDescr, pcfg.getPersistenceConfigInfo());
		       	
	    LUTManager.getLUTManager().invalidateLUT(LUTName.cms_page);
		return dto1;
	}

}
