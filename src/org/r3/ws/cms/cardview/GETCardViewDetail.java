package org.r3.ws.cms.cardview;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.cardfullview.CardFullViewDTO;
import org.r3.db.cms.cardfullview.CardFullViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.CardServicePattern;

public class GETCardViewDetail extends CardServicePattern
{
    private boolean withProperties;
    
	public GETCardViewDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aLanguageCode, String aCardId, boolean withPropertiesFlag)
	{
		super(ctx, serviceEnvironment, aSite, aLanguageCode, aCardId);

	    withProperties = withPropertiesFlag;	
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardFullViewPersistence p = CardFullViewPersistence.createPersistenceObject(pcfg, aSession);						
	    CardFullViewDTO dto1 = null;
	    
	    dto1 = p.selectBySiteLanguagecodeCardid(site, languageCode, cardId, withProperties, pcfg.getPersistenceConfigInfo());

	    return dto1;			
	}

}
