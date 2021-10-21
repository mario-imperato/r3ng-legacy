//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueue;

public class SMSQueuePersistence extends SMSQueuePersistenceBase
{
  public static SMSQueuePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SMSQueuePersistence p = new SMSQueuePersistence();
	    p.setMapper(aSession.getMapper(SMSQueueMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

}
  
