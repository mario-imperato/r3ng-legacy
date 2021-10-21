//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.lut;

import org.r3.db.PersistenceConfigInfo;

public class LUTDictionaryPersistence extends LUTDictionaryPersistenceBase
{
  public static LUTDictionaryPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  LUTDictionaryPersistence p = new LUTDictionaryPersistence();
	    p.setMapper(aSession.getMapper(LUTDictionaryMapper.class));
	    return p;
  }    

	public int invalidateLUT(String aLutName, PersistenceConfigInfo pcfg)
	{
		int numberOfRowsAffected = this.mapper.invalidateByLutid(aLutName, pcfg);
		return numberOfRowsAffected;
	}

	public int invalidate(LUTDictionaryFilter filterCondition, PersistenceConfigInfo pcfg)
	{
		int numberOfRowsAffected = this.mapper.invalidate(filterCondition, pcfg);
		return numberOfRowsAffected;
	}

}
  
