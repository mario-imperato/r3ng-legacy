//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.openregattas.openregattasview;

public class OpenRegattasViewPersistence extends OpenRegattasViewPersistenceBase
{
  public static OpenRegattasViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  OpenRegattasViewPersistence p = new OpenRegattasViewPersistence();
	    p.setMapper(aSession.getMapper(OpenRegattasViewMapper.class));
	    return p;
  }    

}
  
