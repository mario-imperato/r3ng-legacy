package org.r3.ws.system.fileimport;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.fileimport.fileimport.FileImportDataTableAdapter;
import org.r3.db.system.fileimport.fileimport.FileImportFilter;
import org.r3.db.system.fileimport.fileimport.FileImportPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETFileImports extends ServicePattern
{
    private FileImportQueryActionForm queryForm;
    
	public GETFileImports(ServletContext ctx,  ServiceEnvironment serviceEnvironment, FileImportQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		FileImportPersistence p = FileImportPersistence.createPersistenceObject(pcfg, aSession);				
		FileImportFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
		FileImportDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		
		return dt;
	}



}
