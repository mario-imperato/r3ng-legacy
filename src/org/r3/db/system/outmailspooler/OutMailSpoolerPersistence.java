//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.outmailspooler;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.r3.db.PersistenceConfigInfo;

public class OutMailSpoolerPersistence extends OutMailSpoolerPersistenceBase
{
	public static OutMailSpoolerPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		OutMailSpoolerPersistence p = new OutMailSpoolerPersistence();
		p.setMapper(aSession.getMapper(OutMailSpoolerMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	public int updateRecstatusBySiteMessageid(String aSite, String aMessageId, String recStatus, PersistenceConfigInfo pcfg)
	{
		return this.mapper.updateRecstatusBySiteMessageid(aSite, aMessageId, recStatus, pcfg);
	}
	
	// Al Query è aggiunta una join per il calcolo di alcuni contatori di sintesi sui messaggi inviati e non.
	public org.r3.db.system.outmailspooler.OutMailSpoolerDataTableAdapter queryWithCounters(
			org.r3.db.system.outmailspooler.OutMailSpoolerFilter aFilterCondition, 
			org.r3.db.PersistenceConfigInfo pcfg, 
			String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(aFilterCondition, pcfg) : -1;
		List<org.r3.db.system.outmailspooler.OutMailSpoolerDTO> l = null;
		if (numberOfItems != 0)
		{
			RowBounds rb = new RowBounds((iDisplayStart >= 0) ? iDisplayStart : RowBounds.NO_ROW_OFFSET,
					(iDisplayLength > 0) ? iDisplayLength : RowBounds.NO_ROW_LIMIT);

			l = selectWithCounters(aFilterCondition, pcfg, rb);
		}

		org.r3.db.system.outmailspooler.OutMailSpoolerDataTableAdapter dt = new org.r3.db.system.outmailspooler.OutMailSpoolerDataTableAdapter();
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
	  
	public List<org.r3.db.system.outmailspooler.OutMailSpoolerDTO> selectWithCounters(
			org.r3.db.system.outmailspooler.OutMailSpoolerFilter filterCondition,
			org.r3.db.PersistenceConfigInfo pcfg, 
			RowBounds aRowBounds)
	{
		if (filterCondition == null)
		{
			filterCondition = new org.r3.db.system.outmailspooler.OutMailSpoolerFilter();
		}

		if (aRowBounds == null)
			aRowBounds = new RowBounds();
		else
		{
			if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
				filterCondition.setLimitFetch(aRowBounds.getOffset() + aRowBounds.getLimit());
		}

		List<org.r3.db.system.outmailspooler.OutMailSpoolerDTO> listOfDTOs = this.mapper.selectWithCounters(filterCondition, pcfg, aRowBounds);
		return listOfDTOs;
	}
	  
}
