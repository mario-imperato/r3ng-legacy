//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pagedescr;

import org.r3.db.PersistenceConfigInfo;

public class PageDescrPersistence extends PageDescrPersistenceBase
{
  public static PageDescrPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  PageDescrPersistence p = new PageDescrPersistence();
	    p.setMapper(aSession.getMapper(PageDescrMapper.class));
	    return p;
  }

  public void deleteBySitePageid(String site, String pageId,
		PersistenceConfigInfo persistenceConfigInfo)
  {
	   PageDescrFilter filter = new PageDescrFilter();
	   filter.or().andSiteEqualTo(site).andPageidEqualTo(pageId);
	 
	   this.delete(filter, persistenceConfigInfo);
  }    

}
  
