//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.usersession;

public class UserSessionPersistence extends UserSessionPersistenceBase
{
  public static UserSessionPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  UserSessionPersistence p = new UserSessionPersistence();
	    p.setMapper(aSession.getMapper(UserSessionMapper.class));
	    return p;
  }    

}
  
