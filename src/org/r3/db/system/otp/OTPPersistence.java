//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.otp;

public class OTPPersistence extends OTPPersistenceBase
{
  public static OTPPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  OTPPersistence p = new OTPPersistence();
	    p.setMapper(aSession.getMapper(OTPMapper.class));
	    return p;
  }    

}
  
