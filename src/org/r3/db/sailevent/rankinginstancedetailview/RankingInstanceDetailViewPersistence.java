//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstancedetailview;

public class RankingInstanceDetailViewPersistence extends RankingInstanceDetailViewPersistenceBase
{
  public static RankingInstanceDetailViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  RankingInstanceDetailViewPersistence p = new RankingInstanceDetailViewPersistence();
	    p.setMapper(aSession.getMapper(RankingInstanceDetailViewMapper.class));
	    return p;
  }    

}
  
