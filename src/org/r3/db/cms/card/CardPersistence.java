//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.card;

import org.r3.db.PersistenceConfigInfo;

public class CardPersistence extends CardPersistenceBase
{
	public static CardPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		CardPersistence p = new CardPersistence();
		p.setMapper(aSession.getMapper(CardMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}
	
    public String getCardid_domain_sequence(org.r3.db.PersistenceConfigInfo pcfg)
    {
      String seqId = null;
      seqId = sequencePersistence.getSequence(CardDTO.CARDID_DOMAIN_SEQUENCE_CODE, pcfg.getSequenceSubPrefix());
      return seqId;
    }
	  
  public int insert(org.r3.db.cms.card.CardDTO aRecord, String aDomain, org.r3.db.PersistenceConfigInfo pcfg)
  {
	  if (aDomain != null)
	  {
		  aRecord.setSite(aDomain);
		  
	      String seqId = null;
	      if (aRecord.getCardid() == null)
	      {     
	        seqId = getCardid_domain_sequence(pcfg);
	        aRecord.setCardid(seqId);
	      }      		  
	  }

	  return insert(aRecord, pcfg);
  }
	  
	public void clearReference2Property(String site, String cardId, String propertyId, String aPropertyRole, PersistenceConfigInfo pcfg)
	{
//       CardFilter filter = new CardFilter();     
//       
//       CardCriteria c = filter.or().andSiteEqualTo(site).andCardidEqualTo(cardId);
//       
//       CardDTO cardDTO = null;
//       switch(aPropertyRole)
//       {
//       case cardimage: 
//    	   c.andImagepropertyidEqualTo(propertyId);
//           cardDTO = new CardDTO();
//           cardDTO.setImagepropertyid(null);
//           
//
//    	   break;
//       case cardicon:
//    	   c.andIconpropertyidEqualTo(propertyId);
//
//           cardDTO = new CardDTO();
//           cardDTO.setIconpropertyid(null);
//
//    	   break;
//       case  linktitle:
//    	   c.andTitlelinkidEqualTo(propertyId);
//
//           cardDTO = new CardDTO();
//           cardDTO.setTitlelinkid(null);
//
//    	   break;
//       }
//
//       if (cardDTO != null)
//           this.update(cardDTO, filter, pcfg);

	}

}
