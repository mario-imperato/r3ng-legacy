//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.categoryview;

public class CategoryViewPersistence extends CategoryViewPersistenceBase
{
  public static CategoryViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  CategoryViewPersistence p = new CategoryViewPersistence();
	    p.setMapper(aSession.getMapper(CategoryViewMapper.class));
	    return p;
  }    

}
  
