//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.user.userprofileview;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;

public class UserProfileViewPersistence extends UserProfileViewPersistenceBase
{
	public static UserProfileViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		UserProfileViewPersistence p = new UserProfileViewPersistence();
		p.setMapper(aSession.getMapper(UserProfileViewMapper.class));
		return p;
	}

	public UserProfileViewDTO selectByNickname(String aNickName, PersistenceConfigInfo pcfg)
	{
		UserProfileViewFilter filter = new UserProfileViewFilter();
		filter.or().andNicknameEqualTo(aNickName);

		// Non utilizzo selectFirst in quanto selectFirst mi impone un filtro di tipo RowBounds che non va se il resultset e' nestato..
		List<UserProfileViewDTO> listOf = select(filter, pcfg);
		if (listOf != null && !listOf.isEmpty())
			return listOf.get(0);
		
		return null; 
	}

	public UserProfileViewDTO selectByUserid(String userid, PersistenceConfigInfo pcfg)
	{
		UserProfileViewFilter filter = new UserProfileViewFilter();
		filter.or().andUseridEqualTo(userid);

		// Non utilizzo selectFirst in quanto selectFirst mi impone un filtro di tipo RowBounds che non va se il resultset e' nestato..
		List<UserProfileViewDTO> listOf = select(filter, pcfg);
		if (listOf != null && !listOf.isEmpty())
			return listOf.get(0);
		
		return null; 
	}

}
