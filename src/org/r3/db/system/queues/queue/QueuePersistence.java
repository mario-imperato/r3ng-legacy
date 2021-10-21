//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queue;

public class QueuePersistence extends QueuePersistenceBase
{
  public static QueuePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  QueuePersistence p = new QueuePersistence();
	    p.setMapper(aSession.getMapper(QueueMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

}
  
