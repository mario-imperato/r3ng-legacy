//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.pageview;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class PageViewPersistence extends PageViewPersistenceBase
{
	public static PageViewPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		PageViewPersistence p = new PageViewPersistence();
		p.setMapper(aSession.getMapper(PageViewMapper.class));
		return p;
	}

	public List<org.r3.db.cms.pageview.PageViewLUTDTO> readLUT(
			org.r3.db.cms.pageview.PageViewFilter filterCondition,
			org.r3.db.PersistenceConfigInfo pcfg)
	{
		return readLUT(filterCondition, pcfg, null);
	}

	public List<org.r3.db.cms.pageview.PageViewLUTDTO> readLUT(
			org.r3.db.cms.pageview.PageViewFilter filterCondition,
			org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
	{
		if (filterCondition == null)
		{
			filterCondition = new org.r3.db.cms.pageview.PageViewFilter();
		}

		if (aRowBounds == null)
			aRowBounds = new RowBounds();
		else
		{
			if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
				filterCondition.setLimitFetch(aRowBounds.getOffset()
						+ aRowBounds.getLimit());
		}

		List<org.r3.db.cms.pageview.PageViewLUTDTO> listOfDTOs = this.mapper
				.readLUT(filterCondition, pcfg, aRowBounds);
		return listOfDTOs;
	}
	
	  public org.r3.db.cms.pageview.PageViewDTO  selectBySiteLanguagePageid( java.lang.String site, String aLanguage, java.lang.String pageid, org.r3.db.PersistenceConfigInfo pcfg)
	  {
		  PageViewFilter filter = new PageViewFilter();
		  filter.or().andSiteEqualTo(site).andLanguagecodeEqualTo(aLanguage).andPageidEqualTo(pageid);
		  org.r3.db.cms.pageview.PageViewDTO dto = selectFirst(filter, pcfg);
	      return dto;
	  }
	  
}
