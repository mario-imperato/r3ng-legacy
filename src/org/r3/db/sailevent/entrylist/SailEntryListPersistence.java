//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.entrylist;

public class SailEntryListPersistence extends SailEntryListPersistenceBase
{
  public static SailEntryListPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SailEntryListPersistence p = new SailEntryListPersistence();
	    p.setMapper(aSession.getMapper(SailEntryListMapper.class));
	    return p;
  }    

}
  
