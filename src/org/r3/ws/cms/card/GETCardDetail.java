package org.r3.ws.cms.card;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.card.CardDTO;
import org.r3.db.cms.card.CardPersistence;
import org.r3.db.cms.channel.ChannelDataTableAdapter;
import org.r3.db.cms.channel.ChannelPersistence;
import org.r3.db.cms.group.GroupDataTableAdapter;
import org.r3.db.cms.group.GroupPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.CardServicePattern;

public class GETCardDetail extends CardServicePattern
{

    
	public GETCardDetail(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aCardId)
	{
		super(ctx, serviceEnvironment, aSite, null, aCardId);

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardPersistence p = CardPersistence.createPersistenceObject(pcfg, aSession);
						
		CardDTO dto1 = p.selectBySiteCardid(site, cardId, pcfg.getPersistenceConfigInfo());
		
		if (dto1 != null)
		{
			GroupPersistence groupPersistence = GroupPersistence.createPersistenceObject(pcfg, aSession);
			GroupDataTableAdapter groupAdapter = groupPersistence.selectBySiteCardid(site, cardId, pcfg.getPersistenceConfigInfo());
			
			dto1.setGroups(groupAdapter);
			
			ChannelPersistence channelPersistence = ChannelPersistence.createPersistenceObject(pcfg, aSession);
			ChannelDataTableAdapter channelAdapter = channelPersistence.selectBySiteCardid(site, cardId, pcfg.getPersistenceConfigInfo());
			dto1.setChannels(channelAdapter);
		}
		
		return dto1;
	}

}
