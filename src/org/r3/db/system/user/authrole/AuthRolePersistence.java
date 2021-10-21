//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.authrole;

public class AuthRolePersistence extends AuthRolePersistenceBase
{
  public static AuthRolePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  AuthRolePersistence p = new AuthRolePersistence();
	    p.setMapper(aSession.getMapper(AuthRoleMapper.class));
	    return p;
  }    

}
  
