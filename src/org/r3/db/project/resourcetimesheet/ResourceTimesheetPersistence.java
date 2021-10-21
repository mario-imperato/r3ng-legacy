//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.project.resourcetimesheet;

import org.r3.db.PersistenceConfigInfo;

public class ResourceTimesheetPersistence extends ResourceTimesheetPersistenceBase
{
	public static ResourceTimesheetPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		ResourceTimesheetPersistence p = new ResourceTimesheetPersistence();
		p.setMapper(aSession.getMapper(ResourceTimesheetMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public int deleteByResourceidCaleveday(String aSite, String resourceId, Integer caleveday,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		ResourceTimesheetFilter filter = new ResourceTimesheetFilter();
		filter.or().andSiteEqualTo(aSite).andResourceidEqualTo(resourceId).andCalevedayEqualTo(caleveday);

		return delete(filter, persistenceConfigInfo);
	}

}
