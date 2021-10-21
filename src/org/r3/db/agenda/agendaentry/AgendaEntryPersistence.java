//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.agenda.agendaentry;

public class AgendaEntryPersistence extends AgendaEntryPersistenceBase
{
  public static AgendaEntryPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  AgendaEntryPersistence p = new AgendaEntryPersistence();
	    p.setMapper(aSession.getMapper(AgendaEntryMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    


}

  
