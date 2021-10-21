//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appeventlogview;

public class SailApplicationEventLogViewPersistence extends SailApplicationEventLogViewPersistenceBase
{
  public static SailApplicationEventLogViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SailApplicationEventLogViewPersistence p = new SailApplicationEventLogViewPersistence();
	    p.setMapper(aSession.getMapper(SailApplicationEventLogViewMapper.class));
	    return p;
  }    

}
  
