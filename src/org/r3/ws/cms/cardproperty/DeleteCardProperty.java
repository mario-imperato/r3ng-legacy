package org.r3.ws.cms.cardproperty;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.cms.cardproperty.CardPropertyDTO;
import org.r3.db.cms.cardproperty.CardPropertyPersistence;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSFileHelper;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.CardServicePattern;

public class DeleteCardProperty extends CardServicePattern
{    

    protected String propertyId;
    
	public DeleteCardProperty(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aCardId, String aPropertyId)
	{
		super(ctx, serviceEnvironment,  aSite, null, aCardId);
		

		propertyId = aPropertyId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardPropertyPersistence p = CardPropertyPersistence.createPersistenceObject(pcfg, aSession);		
		CardPropertyDTO dto = p.selectByPropertyid(propertyId, pcfg.getPersistenceConfigInfo());
		
		if (dto.hasRoles())
		{
			String[] roles = dto.getRoles();
			if (roles != null)
			{
				CardPersistence cardPersistence = CardPersistence.createPersistenceObject(pcfg, aSession);
				for(String aRole : roles)
				{
					   cardPersistence.clearReference2Property(site, cardId, propertyId, aRole, pcfg.getPersistenceConfigInfo());		
				}
			}		   		   
		}
		
		p.clearReference2Property(site, cardId, propertyId, pcfg.getPersistenceConfigInfo());	
		
		if (dto.isDMSProperty())
		{
		   DMSContext dmsContext = new DMSContext(pcfg, aSession);
		   DMSFileHelper.deleteDMSFile(dmsContext, dto.getPropertyvalue());		   
		}
		
	    p.deleteByPropertyid(propertyId, pcfg.getPersistenceConfigInfo());		   
	    
		return RestServiceDTO.SuccessDTO;
	}
	
}
