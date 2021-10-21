package org.r3.ws.cms.cardproperty;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.cardproperty.CardPropertyDataTableAdapter;
import org.r3.db.cms.cardproperty.CardPropertyFilter;
import org.r3.db.cms.cardproperty.CardPropertyPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.cms.CardServicePattern;

public class GETCardProperties extends CardServicePattern
{
    private CardPropertyQueryActionForm queryForm;
    
	public GETCardProperties(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aCardId, CardPropertyQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment, serviceEnvironment.getRequestSiteId(), null, aCardId);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		// UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		CardPropertyPersistence p = CardPropertyPersistence.createPersistenceObject(pcfg, aSession);				
		CardPropertyFilter filter = queryForm.getSearchCondition(site, cardId);
		
		CardPropertyDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
