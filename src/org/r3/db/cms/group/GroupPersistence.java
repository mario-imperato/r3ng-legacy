//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.group;

import org.r3.db.PersistenceConfigInfo;

public class GroupPersistence extends GroupPersistenceBase
{
	public static GroupPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		GroupPersistence p = new GroupPersistence();
		p.setMapper(aSession.getMapper(GroupMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

//	public GroupDataTableAdapter selectBySite(String site, PersistenceConfigInfo persistenceConfigInfo)
//	{
//		GroupFilter filter = new GroupFilter();
//		filter.or().andSiteEqualTo(site);
//		filter.setOrderByClause(" groupname asc ");
//		return query(filter, persistenceConfigInfo, "1", -1, -1, false);		
//	}

	public GroupDataTableAdapter selectBySiteCardid(String site, String aCardid, PersistenceConfigInfo persistenceConfigInfo)
	{
		GroupFilter filter = new GroupFilter();
		filter.or().andSiteEqualTo(site).andCardidEqualTo(site, aCardid);
		filter.setOrderByClause(" groupname asc ");
		return query(filter, persistenceConfigInfo, "1", -1, -1, false);		
	}

}
