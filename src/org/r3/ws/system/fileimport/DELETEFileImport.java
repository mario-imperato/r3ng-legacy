package org.r3.ws.system.fileimport;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.fileimport.fileimport.FileImportPersistence;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class DELETEFileImport extends ServicePattern
{    
    private String site;
    private String fileImportId;
	
	public DELETEFileImport(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aSite, String aFileImportId)
	{
		super(ctx, serviceEnvironment);
		
		site = aSite;
		fileImportId = aFileImportId;				
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		FileImportPersistence p = FileImportPersistence.createPersistenceObject(pcfg, aSession);
		FileImportDataPersistence pd = FileImportDataPersistence.createPersistenceObject(pcfg, aSession);
		
		int numRowsDeleted = pd.deleteBySiteImportid(site,  fileImportId, pcfg.getPersistenceConfigInfo());
		
		numRowsDeleted = p.deleteBySiteImportid(site, fileImportId, pcfg.getPersistenceConfigInfo());
			    
		return RestServiceDTO.SuccessDTO;
	}
}
