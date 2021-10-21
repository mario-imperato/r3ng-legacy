//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.homeentrylist;

public class SailHomeEntryListPersistence extends SailHomeEntryListPersistenceBase
{
  public static SailHomeEntryListPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SailHomeEntryListPersistence p = new SailHomeEntryListPersistence();
	    p.setMapper(aSession.getMapper(SailHomeEntryListMapper.class));
	    return p;
  }    

}
  
