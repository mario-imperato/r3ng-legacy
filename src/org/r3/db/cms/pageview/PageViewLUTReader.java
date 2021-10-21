package org.r3.db.cms.pageview;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTReader;
import org.r3.db.system.lut.LUTTable;

public class PageViewLUTReader extends LUTReader
{
	private String languageCode = null;	
	
	public PageViewLUTReader(String aLanguageCode)
	{
		languageCode = aLanguageCode;	
	}
	
	public LUTTable readLUT() throws LUTException
	{
		LUTTable table = new LUTTable();

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();

		try
		{
			PageViewPersistence p = PageViewPersistence.createPersistenceObject(pcfg, session);
			PageViewFilter filter = new PageViewFilter();
			filter.or().andLanguagecodeEqualTo(languageCode);
			filter.setOrderByClause(" pageorder asc ");
			List<PageViewLUTDTO> listOf = p.readLUT(filter, pcfg.getPersistenceConfigInfo());

			for (PageViewLUTDTO dto : listOf)
			{
				addToTable(table, dto);
			}

			postReadLUTProcessing(table);
			session.commit();
		}
		catch (Exception e)
		{
			throw new LUTException(e.getMessage());
		}
		finally
		{
			session.close();
		}

		return table;
	}

}
