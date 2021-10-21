package org.r3.ws.system.classifiers;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifieritem.ClassifierItemDataTableAdapter;
import org.r3.db.system.classifieritem.ClassifierItemFilter;
import org.r3.db.system.classifieritem.ClassifierItemPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETClassifierItems extends ServicePattern
{
	private String classifierId;
    private ClassifierItemQueryActionForm queryForm;
    
	public GETClassifierItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aClassifierId, ClassifierItemQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
		classifierId = aClassifierId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{	
		ClassifierItemFilter filter = queryForm.getSearchCondition(getServiceEnvironment().getRequestSiteId(), classifierId);
		
		ClassifierItemPersistence p = ClassifierItemPersistence.createPersistenceObject(pcfg, aSession);
		ClassifierItemDataTableAdapter dt = 
				p.query_WNOC(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		
		return dt;
	}

}
