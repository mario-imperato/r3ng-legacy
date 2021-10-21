//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbstopicview;

public class BBSTopicViewPersistence extends BBSTopicViewPersistenceBase
{
  public static BBSTopicViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  BBSTopicViewPersistence p = new BBSTopicViewPersistence();
	    p.setMapper(aSession.getMapper(BBSTopicViewMapper.class));
	    return p;
  }    

}
  
