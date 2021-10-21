//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.device;

public class DMSDevicePersistence extends DMSDevicePersistenceBase
{
  public static DMSDevicePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  DMSDevicePersistence p = new DMSDevicePersistence();
	    p.setMapper(aSession.getMapper(DMSDeviceMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

}
  
