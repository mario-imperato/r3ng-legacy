//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbstopic;

public class BBSTopicPersistence extends BBSTopicPersistenceBase
{
  public static BBSTopicPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  BBSTopicPersistence p = new BBSTopicPersistence();
	    p.setMapper(aSession.getMapper(BBSTopicMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

}
  
