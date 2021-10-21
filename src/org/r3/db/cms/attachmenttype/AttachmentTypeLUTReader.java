package org.r3.db.cms.attachmenttype;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTReader;
import org.r3.db.system.lut.LUTTable;

public class AttachmentTypeLUTReader extends LUTReader
{
	private String classifierId = null;
	private int    depth        = -1;
	
	public AttachmentTypeLUTReader(String aClassifierId)
	{
	    this(aClassifierId, -1);	
	}

	public AttachmentTypeLUTReader(String aClassifierId, int aDepth)
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
			AttachmentTypePersistence p = AttachmentTypePersistence.createPersistenceObject(pcfg, session);
			AttachmentTypeFilter filter = new AttachmentTypeFilter();
			filter.setOrderByClause(" site, attachtypedescr ");
			
			List<AttachmentTypeDTO> listOf = p.select(filter, pcfg.getPersistenceConfigInfo());
			for (AttachmentTypeDTO dto : listOf)
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
