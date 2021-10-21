//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.devicealias;


import java.util.List;

import org.r3.db.PersistenceConfigInfo;

public class DMSDeviceAliasPersistence extends DMSDeviceAliasPersistenceBase
{
  public static DMSDeviceAliasPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  DMSDeviceAliasPersistence p = new DMSDeviceAliasPersistence();
	    p.setMapper(aSession.getMapper(DMSDeviceAliasMapper.class));
	    return p;
  }    

	public List<DMSDeviceAliasDTO> selectByDeviceid(String aDeviceid, PersistenceConfigInfo pcfg)
	{
		DMSDeviceAliasFilter filter = new DMSDeviceAliasFilter();
		filter.or().andDeviceidEqualTo(aDeviceid);
		return select(filter, pcfg);
	}
}
  
