//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.project.wbsnodeteammemberprofile;

import org.r3.db.PersistenceConfigInfo;

public class WBSNodeTeamMemberProfilePersistence extends
		WBSNodeTeamMemberProfilePersistenceBase {
	public static WBSNodeTeamMemberProfilePersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession) {
		WBSNodeTeamMemberProfilePersistence p = new WBSNodeTeamMemberProfilePersistence();
		p.setMapper(aSession.getMapper(WBSNodeTeamMemberProfileMapper.class));
		return p;
	}

	public int deleteByWbsnodeid(String nodeId, PersistenceConfigInfo persistenceConfigInfo) 
	{
		// TODO Auto-generated method stub
		WBSNodeTeamMemberProfileFilter f = new WBSNodeTeamMemberProfileFilter();
		f.or().andWbsnodeidEqualTo(nodeId);
		return delete(f, persistenceConfigInfo);
	}

}
