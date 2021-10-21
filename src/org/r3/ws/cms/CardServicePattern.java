package org.r3.ws.cms;

import javax.servlet.ServletContext;

import org.r3.db.cms.card.CardDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public abstract class CardServicePattern extends ServicePattern
{
    protected String cardId;
    protected String site;
    protected String languageCode;
    
	public CardServicePattern(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aLanguageCode, String aCardId)
	{
		super(ctx, serviceEnvironment);
		
		cardId = aCardId;
		site = aSite;
		languageCode = aLanguageCode;
		
		// Modifico al volo il sito di richiesta nel caso in cui si tratti di una card di dominio.
		if (CardDTO.isDomainScope(aCardId))
		{
			site = senv.getRequestSite().getSitedomain();
		}
	}

}
