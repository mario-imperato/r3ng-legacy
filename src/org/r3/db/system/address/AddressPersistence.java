//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.address;

public class AddressPersistence extends AddressPersistenceBase
{
  public static AddressPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  AddressPersistence p = new AddressPersistence();
	    p.setMapper(aSession.getMapper(AddressMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

}
  
