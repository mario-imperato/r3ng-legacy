//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.cardview;

import org.r3.db.PersistenceConfigInfo;

public class CardViewPersistence extends CardViewPersistenceBase
{
	public static CardViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		CardViewPersistence p = new CardViewPersistence();
		p.setMapper(aSession.getMapper(CardViewMapper.class));
		return p;
	}

	public CardViewDTO selectBySiteLanguagecodeCardid(String site, String languageCode, String cardId,
					PersistenceConfigInfo persistenceConfigInfo)
	{
        CardViewFilter filter = new CardViewFilter();
        filter.or().andCardidEqualTo(cardId).andSiteEqualTo(site).andLanguagecodeEqualTo(languageCode);
        
        return this.selectFirst(filter, persistenceConfigInfo);		
	}

}
