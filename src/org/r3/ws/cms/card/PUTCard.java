package org.r3.ws.cms.card;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.cms.cardchannel.CardChannelPersistence;
import org.r3.db.cms.cardgroup.CardGroupPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.CardServicePattern;

public class PUTCard extends CardServicePattern
{
    private CardActionForm actionForm;
    

    
	public PUTCard(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aCardId, CardActionForm anActionForm)
	{
		super(ctx, serviceEnvironment, aSite, null, aCardId);
		actionForm = anActionForm;		
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardPersistence p = CardPersistence.createPersistenceObject(pcfg, aSession);		
				
		CardDTO dto1 = actionForm.getDTO4Update(site, cardId);		
	    p.updateByPrimaryKey(dto1, pcfg.getPersistenceConfigInfo());

	    CardChannelPersistence channelPersistence = CardChannelPersistence.createPersistenceObject(pcfg, aSession);
	    channelPersistence.deleteBySiteCardid(dto1.getSite(), dto1.getCardid(), pcfg.getPersistenceConfigInfo());
	    
	    String[] cardChannelArray = DTOBase.string2Array(actionForm.getPubchannels(), ",");
    	if (cardChannelArray != null)
    	{
             for(String channelId : cardChannelArray)
             {
            	 channelPersistence.insert(channelId, dto1.getSite(), dto1.getCardid(), pcfg.getPersistenceConfigInfo());
             }             
    	}
	    	    
	    CardGroupPersistence gp = CardGroupPersistence.createPersistenceObject(pcfg, aSession);
	    gp.deleteBySiteCardId(site, cardId, pcfg.getPersistenceConfigInfo());
	    
	    String[] cardGroupArray = actionForm.getCardgroup();
    	if (cardGroupArray != null)
    	{
             for(String groupId : cardGroupArray)
             {
            	 gp.insertCardIntoGroup(dto1.getSite(), dto1.getCardid(), groupId, pcfg.getPersistenceConfigInfo());
             }             
    	}
    	
//    	CardPropertyPersistence pp = CardPropertyPersistence.createPersistenceObject(pcfg, aSession);		

//	    pp.addRole2Property(actionForm.getImagepropertyid(), CardPropertyRole.cardimage, pcfg.getPersistenceConfigInfo());
//	    pp.addRole2Property(actionForm.getIconpropertyid(), CardPropertyRole.cardicon, pcfg.getPersistenceConfigInfo());
//	    pp.addRole2Property(actionForm.getTitlelinkid(), CardPropertyRole.linktitle, pcfg.getPersistenceConfigInfo());
	    
		return dto1;
	}

}
