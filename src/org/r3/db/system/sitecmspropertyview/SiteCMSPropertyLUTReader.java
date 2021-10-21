package org.r3.db.system.sitecmspropertyview;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTReader;
import org.r3.db.system.lut.LUTTable;

public class SiteCMSPropertyLUTReader extends LUTReader
{

	public LUTTable readLUT() throws LUTException
	{
		LUTTable table = new LUTTable();

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();

		try
		{
			SiteCMSPropertyViewPersistence p = SiteCMSPropertyViewPersistence.createPersistenceObject(pcfg, session);
			SiteCMSPropertyViewFilter filter = new SiteCMSPropertyViewFilter();
			List<SiteCMSPropertyLUTDTO> listOf = p.readLUT(filter, pcfg.getPersistenceConfigInfo());
            
			for (SiteCMSPropertyLUTDTO dto : listOf)
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
