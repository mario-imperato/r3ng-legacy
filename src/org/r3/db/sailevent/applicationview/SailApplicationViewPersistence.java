//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.applicationview;

public class SailApplicationViewPersistence extends SailApplicationViewPersistenceBase
{
  public static SailApplicationViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SailApplicationViewPersistence p = new SailApplicationViewPersistence();
	    p.setMapper(aSession.getMapper(SailApplicationViewMapper.class));
	    return p;
  }    

}
  
