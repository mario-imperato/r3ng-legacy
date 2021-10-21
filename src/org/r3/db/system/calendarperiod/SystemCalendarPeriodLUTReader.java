package org.r3.db.system.calendarperiod;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTReader;
import org.r3.db.system.lut.LUTTable;

public class SystemCalendarPeriodLUTReader extends LUTReader
{
	private String periodtype = null;
	
	public SystemCalendarPeriodLUTReader(String aPeriodtype)
	{
		periodtype = aPeriodtype;
	}

	public LUTTable readLUT() throws LUTException
	{
		LUTTable table = new LUTTable();

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();

		try
		{
			SystemCalendarPeriodPersistence p = SystemCalendarPeriodPersistence.createPersistenceObject(pcfg, session);
			SystemCalendarPeriodFilter filter = new SystemCalendarPeriodFilter();
			SystemCalendarPeriodCriteria criteria = filter.or().andPeriodtypeEqualTo(periodtype);
		    filter.setOrderByClause("periodindex asc");
		    
			List<SystemCalendarPeriodDTO> listOf = p.select(filter, pcfg.getPersistenceConfigInfo());

			for (SystemCalendarPeriodDTO dto : listOf)
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
