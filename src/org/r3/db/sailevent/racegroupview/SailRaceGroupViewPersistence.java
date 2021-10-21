//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.racegroupview;

public class SailRaceGroupViewPersistence extends SailRaceGroupViewPersistenceBase
{
  public static SailRaceGroupViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SailRaceGroupViewPersistence p = new SailRaceGroupViewPersistence();
	    p.setMapper(aSession.getMapper(SailRaceGroupViewMapper.class));
	    return p;
  }    

}
  
