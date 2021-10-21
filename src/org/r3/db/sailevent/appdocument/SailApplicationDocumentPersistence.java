//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appdocument;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceConfigInfo;
import org.r3.db.sailevent.application.SailApplicationDTO.DocumentType;

public class SailApplicationDocumentPersistence extends SailApplicationDocumentPersistenceBase
{
  public static SailApplicationDocumentPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  SailApplicationDocumentPersistence p = new SailApplicationDocumentPersistence();
	    p.setMapper(aSession.getMapper(SailApplicationDocumentMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }

	public int numberOfDocumentsByDocumentType(String eventid, String applicationid, DocumentType aDocumentType,
					PersistenceConfigInfo persistenceConfigInfo, SqlSession aSession)
	{
		SailApplicationDocumentFilter filter = new SailApplicationDocumentFilter();
		filter.or().andEventidEqualTo(eventid).andApplicationidEqualTo(applicationid).andDocumenttypecodeEqualTo(aDocumentType.toString());

		int numberOfRows = count(filter, persistenceConfigInfo);
		return numberOfRows;
	}

}
  
