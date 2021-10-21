//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//

package org.r3.db.system.fileimport.fileimportdata;

import java.util.List;

import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceConfigInfo;

public class FileImportDataPersistence extends FileImportDataPersistenceBase
{
	public static FileImportDataPersistence createPersistenceObject(
			org.r3.db.PersistenceContext pcfg,
			org.apache.ibatis.session.SqlSession aSession)
	{
		FileImportDataPersistence p = new FileImportDataPersistence();
		p.setMapper(aSession.getMapper(FileImportDataMapper.class));
		return p;
	}

	public int deleteBySiteImportid(String site, String fileImportId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		FileImportDataFilter filter = new FileImportDataFilter();
		filter.or().andSiteEqualTo(site).andImportidEqualTo(fileImportId);

		return delete(filter, persistenceConfigInfo);
	}

	public int markAsProcessed(String site, String fileImportId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		FileImportDataFilter filter = new FileImportDataFilter();
		filter.or().andSiteEqualTo(site).andImportidEqualTo(fileImportId);

		FileImportDataDTO dto = new FileImportDataDTO();
		dto.setRecstatus(RecordStatus.sys_recprocessed.toString());
		return update( dto, filter, persistenceConfigInfo);		
	}
	
	public int markAs(int fileImportDataId, RecordStatus aRecStatus,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		FileImportDataDTO dto = new FileImportDataDTO();
		dto.setRecstatus(aRecStatus.toString());
		dto.setImportdataid(fileImportDataId);
		return updateByPrimaryKey( dto, persistenceConfigInfo);		
	}
	
	public List<FileImportDataDTO> selectBySiteImportid(String site, String fileImportId,
			PersistenceConfigInfo persistenceConfigInfo)
	{
		FileImportDataFilter filter = new FileImportDataFilter();
		filter.or().andSiteEqualTo(site).andImportidEqualTo(fileImportId);

		return select(filter, persistenceConfigInfo);
	}
}
