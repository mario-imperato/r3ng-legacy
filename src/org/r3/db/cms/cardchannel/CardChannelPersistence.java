//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.cardchannel;

import org.r3.db.PersistenceConfigInfo;

public class CardChannelPersistence extends CardChannelPersistenceBase {
	
	public static CardChannelPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession) 
	{
		CardChannelPersistence p = new CardChannelPersistence();
		p.setMapper(aSession.getMapper(CardChannelMapper.class));
		return p;
	}

	public int insert(String aChannelId, String aSite, String aCardid, PersistenceConfigInfo pcfg) 
	{
		CardChannelDTO dto = new CardChannelDTO();
		dto.setChannelid(aChannelId);
		dto.setSite(aSite);
		dto.setCardid(aCardid);
		
		return insert(dto, pcfg);

	}

	public int deleteBySiteCardid(String aSite, String aCardid, PersistenceConfigInfo persistenceConfigInfo) 
	{
		CardChannelFilter filter = new CardChannelFilter();
		filter.or().andSiteEqualTo(aSite).andCardidEqualTo(aCardid);
		
		return delete(filter, persistenceConfigInfo);
	}

}
