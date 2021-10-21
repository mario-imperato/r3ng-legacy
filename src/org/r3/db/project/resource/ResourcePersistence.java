//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.project.resource;

import org.r3.db.PersistenceConfigInfo;

public class ResourcePersistence extends ResourcePersistenceBase
{
	public static ResourcePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		ResourcePersistence p = new ResourcePersistence();
		p.setMapper(aSession.getMapper(ResourceMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public ResourceDTO selectBySiteResourceid(String requestSiteId, String resourceId, PersistenceConfigInfo persistenceConfigInfo)
	{
		ResourceFilter filter = new ResourceFilter();
		filter.or().andSiteEqualTo(requestSiteId).andResourceidEqualTo(resourceId);
		return selectFirst(filter, persistenceConfigInfo);
	}

	public ResourceDTO selectBySitedomainSSN(String domain, String ssn, PersistenceConfigInfo persistenceConfigInfo)
	{
		ResourceFilter filter = new ResourceFilter();
		filter.or().andSitedomainEqualTo(domain).andSsnEqualTo(ssn);
		
		return this.selectFirst(filter, persistenceConfigInfo);
	}
	

	

}
