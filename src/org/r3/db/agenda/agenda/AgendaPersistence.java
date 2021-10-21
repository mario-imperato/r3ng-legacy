//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agenda;

public class AgendaPersistence extends AgendaPersistenceBase
{
  public static AgendaPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  AgendaPersistence p = new AgendaPersistence();
	    p.setMapper(aSession.getMapper(AgendaMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

}
  
