package org.r3.ws.cms.channel;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.cardchannel.CardChannelPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETECollectionCardChannel extends ServicePattern
{
    private ChannelActionForm actionForm;
    
	public DELETECollectionCardChannel(ServletContext ctx,  ServiceEnvironment serviceEnvironment, ChannelActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CardChannelPersistence p = CardChannelPersistence.createPersistenceObject(pcfg, aSession);

		int nr = 0;
		
		int numberOfDeletions = actionForm.getNumberOfChannelid_site_cardid();

		if (numberOfDeletions > 0)
		{
			for(int i = 0; i < numberOfDeletions; i++)
			{
				String[] ids = actionForm.getChannelid_site_cardid(i);
				if (ids != null && ids.length >= 3)
				   nr += p.deleteByChannelidSiteCardid(ids[0], ids[1], ids[2], pcfg.getPersistenceConfigInfo());				
			}
		}
				
		
		return RestServiceDTO.SuccessDTO;
	}

}
