//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthreadnodeview;

public class BBSThreadNodeViewPersistence extends BBSThreadNodeViewPersistenceBase
{
  public static BBSThreadNodeViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  BBSThreadNodeViewPersistence p = new BBSThreadNodeViewPersistence();
	    p.setMapper(aSession.getMapper(BBSThreadNodeViewMapper.class));
	    return p;
  }    

}
  
