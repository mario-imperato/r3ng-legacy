//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.classifieritem;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.r3.db.PersistenceConfigInfo;

public class ClassifierItemPersistence extends ClassifierItemPersistenceBase
{
	public static ClassifierItemPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg,
					org.apache.ibatis.session.SqlSession aSession)
	{
		ClassifierItemPersistence p = new ClassifierItemPersistence();
		p.setMapper(aSession.getMapper(ClassifierItemMapper.class));
		p.setSequencePersistence(pcfg.getSequencePersistence());
		return p;
	}

	@Override
	public int insert(
			org.r3.db.system.classifieritem.ClassifierItemDTO aRecord,
			org.r3.db.PersistenceConfigInfo pcfg)
	{
		String seqId = null;
		if (aRecord.getClsitemid() == null)
		{
			seqId = getClsitemid_sequence(pcfg);
			aRecord.setClsitemid(seqId);						
		}

		if (aRecord.getClsitembusid() == null)
			aRecord.setClsitembusid(aRecord.getClsitemid());
		
		int numberOfRowsAffected = this.mapper.insert(aRecord, pcfg);
		return numberOfRowsAffected;
	}

    public List<ClassifierItemDTO> 
    selectByClassifierid(String aSite, String aClassifierid, Integer aClassifierItemDepth, String classifierItemSAttr, org.r3.db.PersistenceConfigInfo pcfg)
    {
    	Integer depth = null;
    	if (aClassifierItemDepth != null)
    	{
    	     if (aClassifierItemDepth >= 0)
    	    	 depth = aClassifierItemDepth;
    	}
    	else depth = 0;
    	
    	ClassifierItemFilter queryCondition = new ClassifierItemFilter();
    	queryCondition.setOrderByClause("classifieritemorder");
    	
    	queryCondition.or().andSiteEqualTo(aSite).andClsidEqualTo(aClassifierid).andClassifieritemdepthEqualTo(depth).andClassifieritemsattrEqualTo(classifierItemSAttr);    	
    	return select(queryCondition, pcfg);
    }
    
    public List<ClassifierItemDTO> 
    selectChildrenOfClassifieritemid(String aSite, String aClassifierid, String aClassifierItemid, String classifierItemSAttr, PersistenceConfigInfo pcfg)
    {
    	ClassifierItemFilter queryCondition = new ClassifierItemFilter();
    	queryCondition.setOrderByClause("classifieritemorder");
    	queryCondition.or().andSiteEqualTo(aSite).andClsidEqualTo(aClassifierid).andParentitemidEqualTo(aClassifierItemid).andClassifieritemsattrEqualTo(classifierItemSAttr);    	
    	return select(queryCondition, pcfg);
    }

	public int deleteBySiteClsidClsitemid(String requestSiteId,
			String classifierId, String classifierItemId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		ClassifierItemFilter filter = new ClassifierItemFilter();
    	filter.or().andSiteEqualTo(requestSiteId).andClsidEqualTo(classifierId).andClsitemidEqualTo(classifierItemId);
		return delete(filter, persistenceConfigInfo);
	}

	public int deleteBySiteClsidParentclsitemid(String requestSiteId,
			String classifierId, String parentClassifierItemId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		ClassifierItemFilter filter = new ClassifierItemFilter();
    	filter.or().andSiteEqualTo(requestSiteId).andClsidEqualTo(classifierId).andParentitemidEqualTo(parentClassifierItemId);
		return delete(filter, persistenceConfigInfo);
	}
	
	
	// WNOC
	public List<org.r3.db.system.classifieritem.ClassifierItemDTO> select_WNOC(
			org.r3.db.system.classifieritem.ClassifierItemFilter filterCondition,
			org.r3.db.PersistenceConfigInfo pcfg, RowBounds aRowBounds)
	{
		if (filterCondition == null)
		{
			filterCondition = new org.r3.db.system.classifieritem.ClassifierItemFilter();
		}

		if (aRowBounds == null)
			aRowBounds = new RowBounds();
		else
		{
			if (aRowBounds.getLimit() < RowBounds.NO_ROW_LIMIT)
				filterCondition.setLimitFetch(aRowBounds.getOffset()
						+ aRowBounds.getLimit());
		}

		List<org.r3.db.system.classifieritem.ClassifierItemDTO> listOfDTOs = this.mapper
				.select_WNOC(filterCondition, pcfg, aRowBounds);
		return listOfDTOs;
	}

	public org.r3.db.system.classifieritem.ClassifierItemDataTableAdapter query_WNOC(
			org.r3.db.system.classifieritem.ClassifierItemFilter aFilterCondition,
			org.r3.db.PersistenceConfigInfo pcfg, String sEcho,
			int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(aFilterCondition, pcfg)
				: -1;
		List<org.r3.db.system.classifieritem.ClassifierItemDTO> l = null;
		if (numberOfItems != 0)
		{
			RowBounds rb = new RowBounds((iDisplayStart >= 0) ? iDisplayStart
					: RowBounds.NO_ROW_OFFSET,
					(iDisplayLength > 0) ? iDisplayLength
							: RowBounds.NO_ROW_LIMIT);

			l = select_WNOC(aFilterCondition, pcfg, rb);
		}

		org.r3.db.system.classifieritem.ClassifierItemDataTableAdapter dt = new org.r3.db.system.classifieritem.ClassifierItemDataTableAdapter();
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

}
