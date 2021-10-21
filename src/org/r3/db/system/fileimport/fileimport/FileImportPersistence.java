//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimport;

import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceConfigInfo;

public class FileImportPersistence extends FileImportPersistenceBase
{
  public static FileImportPersistence createPersistenceObject(org.r3.db.PersistenceContext pcfg, org.apache.ibatis.session.SqlSession aSession)
	{
		  FileImportPersistence p = new FileImportPersistence();
	    p.setMapper(aSession.getMapper(FileImportMapper.class));
	    p.setSequencePersistence(pcfg.getSequencePersistence());
	    return p;
  }    

	public int markAsProcessed(String site, String fileImportId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		FileImportDTO dto = new FileImportDTO();
		dto.setImportid(fileImportId);
		dto.setSite(site);
		dto.setRecstatus(RecordStatus.sys_recprocessed.toString());
		return updateByPrimaryKey(dto, persistenceConfigInfo);		
	}

}
  
