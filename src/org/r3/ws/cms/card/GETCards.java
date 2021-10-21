package org.r3.ws.cms.card;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.card.CardDataTableAdapter;
import org.r3.db.cms.card.CardFilter;
import org.r3.db.cms.card.CardPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETCards extends ServicePattern
{
    private CardQueryActionForm queryForm;
    
	public GETCards(ServletContext ctx,  ServiceEnvironment serviceEnvironment, CardQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		// UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		CardPersistence p = CardPersistence.createPersistenceObject(pcfg, aSession);				
		CardFilter filter = queryForm.getSearchCondition(getServiceEnvironment().getRequestSiteId());
		
		CardDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}



}
