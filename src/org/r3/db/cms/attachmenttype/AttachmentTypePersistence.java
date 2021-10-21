//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.attachmenttype;

public class AttachmentTypePersistence extends AttachmentTypePersistenceBase
{
  public static AttachmentTypePersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  AttachmentTypePersistence p = new AttachmentTypePersistence();
	    p.setMapper(aSession.getMapper(AttachmentTypeMapper.class));
	    return p;
  }    

}
  
