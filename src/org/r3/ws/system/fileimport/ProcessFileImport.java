package org.r3.ws.system.fileimport;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.DTOBase.RecordStatus;
import org.r3.db.PersistenceContext;
import org.r3.db.system.fileimport.fileimport.FileImportPersistence;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataDTO;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataPersistence;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class ProcessFileImport extends ServicePattern
{
    protected String importId;
    protected ProcessFileImportActionForm actionForm;
    
	public ProcessFileImport(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String anImportId, ProcessFileImportActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		importId = anImportId;
		actionForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		markImportDataAsProcessed(pcfg, aSession, senv.getRequestSiteId(), importId);
		markImportAsProcessed(pcfg, aSession, senv.getRequestSiteId(), importId);
        return RestServiceDTO.SuccessDTO;
	}
	
	protected List<FileImportDataDTO> getImportData(PersistenceContext pcfg, SqlSession aSession, String aSite, String importId)
	{
		FileImportDataPersistence pdata = FileImportDataPersistence.createPersistenceObject(pcfg, aSession);
        return pdata.selectBySiteImportid(aSite, importId, pcfg.getPersistenceConfigInfo());
	}

	protected int markImportAsProcessed(PersistenceContext pcfg, SqlSession aSession, String aSite, String anImportId)
	{
		FileImportPersistence p = FileImportPersistence.createPersistenceObject(pcfg, aSession);
		return p.markAsProcessed(aSite, anImportId, pcfg.getPersistenceConfigInfo());		
	}
	
	protected int markImportDataAsProcessed(PersistenceContext pcfg, SqlSession aSession, String aSite, String anImportId)
	{
		FileImportDataPersistence   p = FileImportDataPersistence.createPersistenceObject(pcfg, aSession);		
        return p.markAsProcessed(aSite, anImportId, pcfg.getPersistenceConfigInfo());
	}
	
	protected int markImportDataAs(PersistenceContext pcfg, SqlSession aSession, FileImportDataPersistence p, int anImportDataId, RecordStatus aRecStatus)
	{
		if (p == null)
           p = FileImportDataPersistence.createPersistenceObject(pcfg, aSession);
		
        return p.markAs(anImportDataId, aRecStatus, pcfg.getPersistenceConfigInfo());
	}
	
}
