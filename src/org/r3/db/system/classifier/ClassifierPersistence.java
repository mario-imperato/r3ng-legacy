//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifier;

public class ClassifierPersistence extends ClassifierPersistenceBase
{
  public static ClassifierPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  ClassifierPersistence p = new ClassifierPersistence();
	    p.setMapper(aSession.getMapper(ClassifierMapper.class));
	    return p;
  }    

}
  
