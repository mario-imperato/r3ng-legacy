//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.carddescr;

public class CardDescrPersistence extends CardDescrPersistenceBase
{
  public static CardDescrPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  CardDescrPersistence p = new CardDescrPersistence();
	    p.setMapper(aSession.getMapper(CardDescrMapper.class));
	    return p;
  }    

}
  
