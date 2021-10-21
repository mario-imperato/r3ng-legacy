//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.siteresource;

public class SiteResourcePersistence extends SiteResourcePersistenceBase
{
  public static SiteResourcePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SiteResourcePersistence p = new SiteResourcePersistence();
	    p.setMapper(aSession.getMapper(SiteResourceMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

}
  
