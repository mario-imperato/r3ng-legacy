//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.wbsnodeteammemberprofileview;

public class WBSNodeTeamMemberProfileViewPersistence extends WBSNodeTeamMemberProfileViewPersistenceBase
{
  public static WBSNodeTeamMemberProfileViewPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  WBSNodeTeamMemberProfileViewPersistence p = new WBSNodeTeamMemberProfileViewPersistence();
	    p.setMapper(aSession.getMapper(WBSNodeTeamMemberProfileViewMapper.class));
	    return p;
  }    

}
  
