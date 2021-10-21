//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.userroleview;

public class UserRoleViewPersistence extends UserRoleViewPersistenceBase
{
  public static UserRoleViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  UserRoleViewPersistence p = new UserRoleViewPersistence();
	    p.setMapper(aSession.getMapper(UserRoleViewMapper.class));
	    return p;
  }    

}
  
