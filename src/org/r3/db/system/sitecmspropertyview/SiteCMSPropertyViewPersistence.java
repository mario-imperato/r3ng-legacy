//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.sitecmspropertyview;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public class SiteCMSPropertyViewPersistence extends SiteCMSPropertyViewPersistenceBase
{
  public static SiteCMSPropertyViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SiteCMSPropertyViewPersistence p = new SiteCMSPropertyViewPersistence();
	    p.setMapper(aSession.getMapper(SiteCMSPropertyViewMapper.class));
	    return p;
  }    

	public List<SiteCMSPropertyLUTDTO> readLUT(
			SiteCMSPropertyViewFilter filterCondition,
			org.r3.db.PersistenceConfigInfo pcfg)
	{
		if (filterCondition == null)
		{
			filterCondition = new SiteCMSPropertyViewFilter();
		}

		List<SiteCMSPropertyLUTDTO> listOfDTOs = this.mapper
				.readLUT(filterCondition, pcfg, new RowBounds());
		return listOfDTOs;
	}
}
  
