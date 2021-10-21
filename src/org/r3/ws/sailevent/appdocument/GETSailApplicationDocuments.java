package org.r3.ws.sailevent.appdocument;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentDataTableAdapter;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentFilter;
import org.r3.db.sailevent.appdocument.SailApplicationDocumentPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETSailApplicationDocuments extends ServicePattern
{
    private String applicationId;
    private String crewMemberId;
    private SailApplicationDocumentQueryActionForm queryForm;
    
	public GETSailApplicationDocuments(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anApplicationId, String aCrewMemberId, SailApplicationDocumentQueryActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		applicationId = anApplicationId;
		crewMemberId = aCrewMemberId;
		queryForm = anActionForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SailApplicationDocumentPersistence p = SailApplicationDocumentPersistence.createPersistenceObject(pcfg, aSession);				
		SailApplicationDocumentFilter filter = queryForm.getSearchCondition(applicationId, crewMemberId);
		
		SailApplicationDocumentDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}

}
