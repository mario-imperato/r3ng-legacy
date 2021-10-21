package org.r3.ws.sailevent.openregattas;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewDataTableAdapter;
import org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewFilter;
import org.r3.db.sailevent.openregattas.openregattasview.OpenRegattasViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETRegattas extends ServicePattern
{
    private RegattasQueryActionForm queryForm;
    
	public GETRegattas(ServletContext ctx,  ServiceEnvironment serviceEnvironment, RegattasQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		OpenRegattasViewPersistence p = OpenRegattasViewPersistence.createPersistenceObject(pcfg, aSession);				
		OpenRegattasViewFilter filter = queryForm.getSearchCondition(senv.getRequestSiteId());
		
 	    OpenRegattasViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());				
		return dt;		
	}

}
