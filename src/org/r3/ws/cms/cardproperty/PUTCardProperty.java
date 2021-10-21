package org.r3.ws.cms.cardproperty;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.cardproperty.CardPropertyDTO;
import org.r3.db.cms.cardproperty.CardPropertyPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.CardServicePattern;

public class PUTCardProperty extends CardServicePattern
{
    private CardPropertyActionForm actionForm;
    
    private String propertyId;
    
	public PUTCardProperty(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String aPropertyId, CardPropertyActionForm anActionForm)
	{
		super(ctx, serviceEnvironment, aSite, null, aCardId);
		actionForm = anActionForm;
		
		propertyId = aPropertyId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardPropertyPersistence p = CardPropertyPersistence.createPersistenceObject(pcfg, aSession);		
				
		CardPropertyDTO dto1 = actionForm.getDTO4Update(site, cardId, propertyId);		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());
	    
		return dto1;
	}
}
