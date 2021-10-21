package org.r3.ws.system.fileimport;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataDataTableAdapter;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataFilter;
import org.r3.db.system.fileimport.fileimportdata.FileImportDataPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETFileImportData extends ServicePattern
{
    private String importId;
    private FileImportDataQueryActionForm queryActionForm;
    
	public GETFileImportData(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anImportId, FileImportDataQueryActionForm aQueryActionForm)
	{
		super(ctx, serviceEnvironment);
		importId = anImportId;
		queryActionForm = aQueryActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		FileImportDataPersistence p = FileImportDataPersistence.createPersistenceObject(pcfg, aSession);
		FileImportDataFilter filter = queryActionForm.getSearchCondition(senv.getRequestSiteId(), importId, 0);
		FileImportDataDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo());		
		return dt;
	}

}
