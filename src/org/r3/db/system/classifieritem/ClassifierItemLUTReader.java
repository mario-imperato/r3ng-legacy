package org.r3.db.system.classifieritem;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTReader;
import org.r3.db.system.lut.LUTTable;

public class ClassifierItemLUTReader extends LUTReader
{
	private String classifierId = null;
	private int    depth        = -1;
	
	public ClassifierItemLUTReader(String aClassifierId)
	{
	    this(aClassifierId, -1);	
	}

	public ClassifierItemLUTReader(String aClassifierId, int aDepth)
	{
		classifierId = aClassifierId;
		depth = aDepth;
	}

	public LUTTable readLUT() throws LUTException
	{
		LUTTable table = new LUTTable();

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();

		try
		{
			ClassifierItemPersistence p = ClassifierItemPersistence.createPersistenceObject(pcfg, session);
			ClassifierItemFilter filter = new ClassifierItemFilter();
			ClassifierItemCriteria criteria = filter.or().andClsidEqualTo(classifierId);
			
			if (depth >= 0)
				criteria.andClassifieritemdepthEqualTo(depth);
			
			List<ClassifierItemDTO> listOf = p.select(filter, pcfg.getPersistenceConfigInfo());

			for (ClassifierItemDTO dto : listOf)
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
