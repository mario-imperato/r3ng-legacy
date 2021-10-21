//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.fivmember;

public class FIVMemberPersistence extends FIVMemberPersistenceBase
{
  public static FIVMemberPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  FIVMemberPersistence p = new FIVMemberPersistence();
	    p.setMapper(aSession.getMapper(FIVMemberMapper.class));
	    return p;
  }    

}
  
