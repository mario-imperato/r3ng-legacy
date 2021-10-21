//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.cms.cardfullview;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.r3.db.PersistenceConfigInfo;

public class CardFullViewPersistence extends CardFullViewPersistenceBase
{
	public static CardFullViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		CardFullViewPersistence p = new CardFullViewPersistence();
		p.setMapper(aSession.getMapper(CardFullViewMapper.class));
		return p;
	}

	public CardFullViewDTO selectBySiteLanguagecodeCardid(String site, String languageCode, String cardId, boolean fullMode,
					PersistenceConfigInfo persistenceConfigInfo)

	{
		CardFullViewFilter filter = new CardFullViewFilter();
		filter.or().andCardidEqualTo(cardId).andSiteEqualTo(site).andLanguagecodeEqualTo(languageCode);

		List<CardFullViewDTO> resultList = null;
		if (fullMode)
			resultList = this.select(filter, persistenceConfigInfo);
		else
			resultList = this.selectPartial(filter, persistenceConfigInfo);

		if (resultList != null && resultList.size() > 0)
			return resultList.get(0);

		return null;
	}

	public int countPartial(org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
	{
		int numberOfRowsAffected = this.mapper.countPartial(aFilterCondition, pcfg);
		return numberOfRowsAffected;
	}

	public List<org.r3.db.cms.cardfullview.CardFullViewDTO> selectPartial(org.r3.db.cms.cardfullview.CardFullViewFilter filterCondition,
					org.r3.db.PersistenceConfigInfo pcfg)
	{
		return selectPartial(filterCondition, pcfg, null);
	}

	public List<org.r3.db.cms.cardfullview.CardFullViewDTO> selectPartial(org.r3.db.cms.cardfullview.CardFullViewFilter filterCondition,
					org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
	{
		if (filterCondition == null)
		{
			filterCondition = new org.r3.db.cms.cardfullview.CardFullViewFilter();
		}

		if (aRowBounds == null)
			aRowBounds = new RowBounds();
		else
		{
			if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
				filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
		}

		List<org.r3.db.cms.cardfullview.CardFullViewDTO> listOfDTOs = this.mapper.selectPartial(filterCondition, pcfg, aRowBounds);
		return listOfDTOs;
	}

	public org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter queryPartial(
					org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg, String sEcho,
					int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? countPartial(aFilterCondition, pcfg) : -1;
		List<org.r3.db.cms.cardfullview.CardFullViewDTO> l = null;
		if (numberOfItems != 0)
		{
			RowBounds rb = new RowBounds((iDisplayStart >= 0) ? iDisplayStart : RowBounds.NO_ROW_OFFSET,
							(iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);

			l = selectPartial(aFilterCondition, pcfg, rb);
		}

		org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter dt = new org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter();
		dt.setsEcho(sEcho);
		if (numberOfItems >= 0)
		{
			dt.setiTotalRecords(numberOfItems);
			dt.setiTotalDisplayRecords(numberOfItems);
		}
		else
		{
			if (l != null)
			{
				dt.setiTotalRecords(l.size());
				dt.setiTotalDisplayRecords(l.size());
			}
			else
			{
				dt.setiTotalRecords(0);
				dt.setiTotalDisplayRecords(0);
			}
		}
		dt.setAaData(l);

		return dt;
	}

	public org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter queryPartial(
					org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
	{
		return queryPartial(aFilterCondition, pcfg, "1", -1, -1, false);
	}

	// Channel Methods.
	public int countChannel(org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
	{
		int numberOfRowsAffected = this.mapper.countChannel(aFilterCondition, pcfg);
		return numberOfRowsAffected;
	}

	public List<org.r3.db.cms.cardfullview.CardFullViewDTO> selectChannel(org.r3.db.cms.cardfullview.CardFullViewFilter filterCondition,
					org.r3.db.PersistenceConfigInfo pcfg)
	{
		return selectChannel(filterCondition, pcfg, null);
	}

	public List<org.r3.db.cms.cardfullview.CardFullViewDTO> selectChannel(org.r3.db.cms.cardfullview.CardFullViewFilter filterCondition,
					org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
	{
		if (filterCondition == null)
		{
			filterCondition = new org.r3.db.cms.cardfullview.CardFullViewFilter();
		}

		if (aRowBounds == null)
			aRowBounds = new RowBounds();
		else
		{
			if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
				filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
		}

		List<org.r3.db.cms.cardfullview.CardFullViewDTO> listOfDTOs = this.mapper.selectChannel(filterCondition, pcfg, aRowBounds);
		return listOfDTOs;
	}

	public org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter queryChannel(
					org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg, String sEcho,
					int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? countChannel(aFilterCondition, pcfg) : -1;
		List<org.r3.db.cms.cardfullview.CardFullViewDTO> l = null;
		if (numberOfItems != 0)
		{
			RowBounds rb = new RowBounds((iDisplayStart >= 0) ? iDisplayStart : RowBounds.NO_ROW_OFFSET,
							(iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);

			l = selectChannel(aFilterCondition, pcfg, rb);
		}

		org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter dt = new org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter();
		dt.setsEcho(sEcho);
		if (numberOfItems >= 0)
		{
			dt.setiTotalRecords(numberOfItems);
			dt.setiTotalDisplayRecords(numberOfItems);
		}
		else
		{
			if (l != null)
			{
				dt.setiTotalRecords(l.size());
				dt.setiTotalDisplayRecords(l.size());
			}
			else
			{
				dt.setiTotalRecords(0);
				dt.setiTotalDisplayRecords(0);
			}
		}
		dt.setAaData(l);

		return dt;
	}

	public org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter queryChannel(
					org.r3.db.cms.cardfullview.CardFullViewFilter aFilterCondition, org.r3.db.PersistenceConfigInfo pcfg)
	{
		return queryChannel(aFilterCondition, pcfg, "1", -1, -1, false);
	}
	
}
