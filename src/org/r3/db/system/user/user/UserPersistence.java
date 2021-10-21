//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.user;

import java.util.List;

import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceConfigInfo;

public class UserPersistence extends UserPersistenceBase
{
  public static UserPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  UserPersistence p = new UserPersistence();
	    p.setMapper(aSession.getMapper(UserMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    
  
	public UserDTO selectByNickname(String aUserName, PersistenceConfigInfo pcfg)
	{
		UserFilter filterCondition = new UserFilter();
		filterCondition.or().andNicknameEqualTo(aUserName);

		List<UserDTO> aUserDTOList = select(filterCondition, pcfg);
		if (aUserDTOList != null && aUserDTOList.size() > 0)
			return aUserDTOList.get(0);

		return null;
	}

	public boolean check4DuplicateCompanyid(PersistenceConfigInfo pcfg, String aUserName, String aCompanyId)
	{
		UserFilter filterCondition = new UserFilter();
		filterCondition.or().andNicknameNotEqualTo(aUserName).andCompanyidEqualTo(aCompanyId);

		return count(filterCondition, pcfg) > 0;		
	}
	
	public List<UserDTO> selectByEMailRecstatus(String aUserEMail, RecordStatus recStatus, PersistenceConfigInfo pcfg)
	{
		UserFilter filterCondition = new UserFilter();
		filterCondition.or().andEmailEqualTo(aUserEMail).andRecstatusEqualTo(recStatus.toString());

		List<UserDTO> aUserDTOList = select(filterCondition, pcfg);		
		return aUserDTOList;
	}
}
  
