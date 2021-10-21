//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.siteview;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class SiteViewPersistence extends SiteViewPersistenceBase
{
	public static SiteViewPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		SiteViewPersistence p = new SiteViewPersistence();
		p.setMapper(aSession.getMapper(SiteViewMapper.class));
		return p;
	}

	public List<org.r3.db.system.site.SiteDTO> selectSiteDTO(
			org.r3.db.system.siteview.SiteViewFilter filterCondition,
			org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
	{
		if (filterCondition == null)
		{
			filterCondition = new org.r3.db.system.siteview.SiteViewFilter();
		}

		if (aRowBounds == null)
			aRowBounds = new RowBounds();
		else
		{
			if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
				filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
		}

		List<org.r3.db.system.site.SiteDTO> listOfDTOs = this.mapper.selectSiteDTO(filterCondition, pcfg, aRowBounds);		
		return listOfDTOs;
	}
}
