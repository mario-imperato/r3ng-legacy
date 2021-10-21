package org.r3.ws.cms.carddescr;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.carddescr.CardDescrDTO;
import org.r3.db.cms.carddescr.CardDescrPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.CardServicePattern;

public class GETCardDescrDetail extends CardServicePattern
{
    
	public GETCardDescrDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String aLanguageCode)
	{
		super(ctx, serviceEnvironment, aSite, aLanguageCode, aCardId);
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardDescrPersistence p = CardDescrPersistence.createPersistenceObject(pcfg, aSession);						
		CardDescrDTO dto1 = p.selectBySiteCardidLanguagecode(site, cardId, languageCode, pcfg.getPersistenceConfigInfo());
		return dto1;
	}

}
