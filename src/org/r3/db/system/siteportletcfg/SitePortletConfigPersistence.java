//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.siteportletcfg;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.r3.db.PersistenceConfigInfo;


public class SitePortletConfigPersistence extends
		SitePortletConfigPersistenceBase
{
	public static SitePortletConfigPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		SitePortletConfigPersistence p = new SitePortletConfigPersistence();
		p.setMapper(aSession.getMapper(SitePortletConfigMapper.class));
		return p;
	}

	public List<org.r3.db.system.siteportletcfg.SitePortletConfigLUTDTO> readLUT(
			org.r3.db.system.siteportletcfg.SitePortletConfigFilter filterCondition,
			org.r3.db.PersistenceConfigInfo pcfg)
	{
		if (filterCondition == null)
		{
			filterCondition = new org.r3.db.system.siteportletcfg.SitePortletConfigFilter();
		}

		List<org.r3.db.system.siteportletcfg.SitePortletConfigLUTDTO> listOfDTOs = this.mapper
				.readLUT(filterCondition, pcfg, new RowBounds());
		return listOfDTOs;
	}

	public SitePortletConfigDataTableAdapter queryBySitePageid(
			String requestSite, String pageid,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		SitePortletConfigFilter filter = new  SitePortletConfigFilter();
		filter.or().andSiteEqualTo(requestSite).andPageidEqualTo(pageid);
        filter.setOrderByClause(" positionid asc ");
		return query(filter, persistenceConfigInfo);
	}

}
