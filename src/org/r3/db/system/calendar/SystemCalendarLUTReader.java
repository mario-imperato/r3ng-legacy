package org.r3.db.system.calendar;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTReader;
import org.r3.db.system.lut.LUTTable;

public class SystemCalendarLUTReader extends LUTReader
{
	
	public SystemCalendarLUTReader()
	{
	}

	public LUTTable readLUT() throws LUTException
	{
		LUTTable table = new LUTTable();

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();

		try
		{
			SystemCalendarPersistence p = SystemCalendarPersistence.createPersistenceObject(pcfg, session);
			SystemCalendarFilter filter = new SystemCalendarFilter();
		    filter.setOrderByClause("caldate asc");
		    
			List<SystemCalendarDTO> listOf = p.select(filter, pcfg.getPersistenceConfigInfo());

			for (SystemCalendarDTO dto : listOf)
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
