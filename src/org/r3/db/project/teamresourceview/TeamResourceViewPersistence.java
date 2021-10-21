//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teamresourceview;

public class TeamResourceViewPersistence extends TeamResourceViewPersistenceBase
{
  public static TeamResourceViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  TeamResourceViewPersistence p = new TeamResourceViewPersistence();
	    p.setMapper(aSession.getMapper(TeamResourceViewMapper.class));
	    return p;
  }    

}
  
