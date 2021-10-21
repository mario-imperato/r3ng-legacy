package org.r3.ws.cms.carddescr;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.carddescr.CardDescrDTO;
import org.r3.db.cms.carddescr.CardDescrPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.CardServicePattern;

public class PUTCardDescr extends CardServicePattern
{
    private CardDescrActionForm actionForm;
    

    
	public PUTCardDescr(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String aCardLanguage, CardDescrActionForm anActionForm)
	{
		super(ctx, serviceEnvironment, aSite, aCardLanguage, aCardId);
		actionForm = anActionForm;
		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardDescrPersistence p = CardDescrPersistence.createPersistenceObject(pcfg, aSession);						
		CardDescrDTO dto1 = p.selectBySiteCardidLanguagecode(site, cardId, languageCode, pcfg.getPersistenceConfigInfo());
        if (dto1 == null)
        {
		   dto1 = actionForm.getDTO4Insert(site, cardId, languageCode);
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
