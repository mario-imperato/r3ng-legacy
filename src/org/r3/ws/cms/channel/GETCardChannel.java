package org.r3.ws.cms.channel;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.cardchannelview.CardChannelViewDataTableAdapter;
import org.r3.db.cms.cardchannelview.CardChannelViewFilter;
import org.r3.db.cms.cardchannelview.CardChannelViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETCardChannel extends ServicePattern
{
    private CardChannelQueryActionForm queryForm;
    
	public GETCardChannel(ServletContext ctx,  ServiceEnvironment serviceEnvironment, CardChannelQueryActionForm aQueryForm)
	{
		super(ctx, serviceEnvironment);
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		// UserProfileViewDTO user = this.getWebAuthInfo().getUserProfile();		

		CardChannelViewPersistence p = CardChannelViewPersistence.createPersistenceObject(pcfg, aSession);				
		CardChannelViewFilter filter = queryForm.getSearchCondition(getServiceEnvironment().getRequestSiteDomain(), getServiceEnvironment().getRequestSiteId(), getServiceEnvironment().getRequestLanguage());
		
		CardChannelViewDataTableAdapter dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		return dt;
	}
}
