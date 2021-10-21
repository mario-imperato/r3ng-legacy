//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.country;

public class CountryPersistence extends CountryPersistenceBase
{
  public static CountryPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  CountryPersistence p = new CountryPersistence();
	    p.setMapper(aSession.getMapper(CountryMapper.class));
	    return p;
  }    

}
  
