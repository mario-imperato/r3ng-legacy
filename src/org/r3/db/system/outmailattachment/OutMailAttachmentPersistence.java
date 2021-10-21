//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailattachment;

import java.util.List;

import org.r3.db.PersistenceConfigInfo;

public class OutMailAttachmentPersistence extends OutMailAttachmentPersistenceBase
{
  public static OutMailAttachmentPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  OutMailAttachmentPersistence p = new OutMailAttachmentPersistence();
	    p.setMapper(aSession.getMapper(OutMailAttachmentMapper.class));
	    return p;
  }    

  public List<OutMailAttachmentDTO> selectByMessageid(String aMessageId, PersistenceConfigInfo pcfg)
  {
	  OutMailAttachmentFilter f = new OutMailAttachmentFilter();
	  f.or().andMessageidEqualTo(aMessageId);
	  
	  List<OutMailAttachmentDTO> l = this.select(f, pcfg);
	  return l;	  
  }
}
  
