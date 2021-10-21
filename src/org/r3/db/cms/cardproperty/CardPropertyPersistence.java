//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.cardproperty;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;

public class CardPropertyPersistence extends CardPropertyPersistenceBase
{
	public static CardPropertyPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		CardPropertyPersistence p = new CardPropertyPersistence();
		p.setMapper(aSession.getMapper(CardPropertyMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public void clearReference2Property(String site, String cardId, String propertyId, PersistenceConfigInfo pcfg)
	{
		CardPropertyFilter filter = new CardPropertyFilter();
		filter.or().andSiteEqualTo(site).andCardidEqualTo(cardId).andRefpropertyidEqualTo(propertyId);

		CardPropertyDTO cardDTO = new CardPropertyDTO();
		cardDTO.setRefpropertyid(null);

		this.update(cardDTO, filter, pcfg);
	}

	public List<CardPropertyDTO> selectBySiteCardidPropertyrole(String site, String aCardId, String propertyRole, PersistenceConfigInfo pcfg)
	{
		CardPropertyFilter filter = new CardPropertyFilter();
		filter.or().andSiteEqualTo(site).andCardidEqualTo(aCardId).andPropertyroleEqualTo(propertyRole);
		
		return select(filter, pcfg);
	}
	
//	public int addRole2Property(String propertyId, String aRole, PersistenceConfigInfo pcfg)
//	{
//		if (propertyId != null)
//	    {
//	    				
//	    	CardPropertyDTO propertyDTO = selectByPropertyid(propertyId, pcfg);
//	    	
//	    	if (propertyDTO != null)
//	    	{
//	    		propertyDTO.addRole(aRole);
//	    	}
//	    	
//	    	return updateByPrimaryKey(propertyDTO, pcfg);
//	    }
//		
//		return  0;
//	}

}
