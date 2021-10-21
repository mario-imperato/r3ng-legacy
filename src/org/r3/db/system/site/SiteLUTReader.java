package org.r3.db.system.site;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTException;
import org.r3.db.system.lut.LUTReader;
import org.r3.db.system.lut.LUTTable;
import org.r3.db.system.siteproperty.SitePropertyDTO;
import org.r3.db.system.siteproperty.SitePropertyDTOCollection;
import org.r3.db.system.siteview.SiteViewFilter;
import org.r3.db.system.siteview.SiteViewPersistence;

public class SiteLUTReader extends LUTReader
{

	public LUTTable readLUT() throws LUTException
	{
		LUTTable table = new LUTTable();

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession session = pcfg.openSession();

		try
		{
			SiteViewPersistence p = SiteViewPersistence.createPersistenceObject(pcfg, session);
			SiteViewFilter filter = new SiteViewFilter();
			List<SiteDTO> listOf = p.selectSiteDTO(filter, pcfg.getPersistenceConfigInfo(), null);
            
			// 30/01/2018 16:06:20 Necessità di riportare 'dentro' le variabili tolte e messe in properties.			
			for (SiteDTO dto : listOf)
			{
				dto.resolveSiteDTOFromSiteProperties();				
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
