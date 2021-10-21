//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.user.userrole;

import org.r3.db.PersistenceConfigInfo;

public class UserRolePersistence extends UserRolePersistenceBase
{
	public static UserRolePersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		UserRolePersistence p = new UserRolePersistence();
		p.setMapper(aSession.getMapper(UserRoleMapper.class));
		return p;
	}

	public int deleteRolesBySiteUserid(String aSite, String aUserid, PersistenceConfigInfo pcfg)
	{
		UserRoleFilter userFilter = new UserRoleFilter();
	    userFilter.or().andUseridEqualTo(aUserid).andSiteEqualTo(aSite);
	    return delete(userFilter, pcfg);
	}
}
