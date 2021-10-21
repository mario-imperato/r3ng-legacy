//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardchannelview;

public class CardChannelViewPersistence extends CardChannelViewPersistenceBase
{
  public static CardChannelViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  CardChannelViewPersistence p = new CardChannelViewPersistence();
	    p.setMapper(aSession.getMapper(CardChannelViewMapper.class));
	    return p;
  }    

}
  
