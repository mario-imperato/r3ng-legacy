//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.fileproperty;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;

public class DMSFilePropertyPersistence extends DMSFilePropertyPersistenceBase
{
  public static DMSFilePropertyPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  DMSFilePropertyPersistence p = new DMSFilePropertyPersistence();
	    p.setMapper(aSession.getMapper(DMSFilePropertyMapper.class));
	    return p;
  }    

	public void deleteByFileid(String aFileId, PersistenceConfigInfo persistenceContext)
	{
		DMSFilePropertyFilter filter = new DMSFilePropertyFilter();
		filter.or().andFileidEqualTo(aFileId);
      
      this.delete(filter, persistenceContext);
	}

	public List<DMSFilePropertyDTO> selectByFileid(String aFileId, PersistenceConfigInfo persistenceContext)
	{
		DMSFilePropertyFilter filter = new DMSFilePropertyFilter();
		filter.or().andFileidEqualTo(aFileId);
      
      return this.select(filter, persistenceContext);
	}

	public void physicalDeleteByFilephysicalpath(String physicalName, PersistenceConfigInfo persistenceContext)
	{
		DMSFilePropertyFilter filter = new DMSFilePropertyFilter();
		filter.or().andFilephysicalpathEqualTo(physicalName);
       
		 delete(filter, persistenceContext);
	}

}
  
