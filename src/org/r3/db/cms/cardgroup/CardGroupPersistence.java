//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.cardgroup;

import org.r3.db.PersistenceConfigInfo;

public class CardGroupPersistence extends CardGroupPersistenceBase
{
	public static CardGroupPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		CardGroupPersistence p = new CardGroupPersistence();
		p.setMapper(aSession.getMapper(CardGroupMapper.class));
		return p;
	}

	public int insertCardIntoGroup(String requestSiteId,  String cardid, String groupId, PersistenceConfigInfo persistenceConfigInfo)
	{
		CardGroupDTO dto = new CardGroupDTO();
		dto.setSite(requestSiteId);
		dto.setCardid(cardid);
		dto.setGroupid(groupId);
		
		return insert(dto, persistenceConfigInfo);

	}

	public int deleteBySiteCardId(String site, String cardId, PersistenceConfigInfo pcfg)
	{
		CardGroupFilter filter = new CardGroupFilter();
		filter.or().andSiteEqualTo(site).andCardidEqualTo(cardId);
		
		return delete(filter, pcfg);
	}

}
