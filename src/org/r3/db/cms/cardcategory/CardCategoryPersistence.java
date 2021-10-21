//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardcategory;

public class CardCategoryPersistence extends CardCategoryPersistenceBase
{
  public static CardCategoryPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  CardCategoryPersistence p = new CardCategoryPersistence();
	    p.setMapper(aSession.getMapper(CardCategoryMapper.class));
	    return p;
  }    

}
  
