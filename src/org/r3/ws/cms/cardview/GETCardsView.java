package org.r3.ws.cms.cardview;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.cardfullview.CardFullViewDataTableAdapter;
import org.r3.db.cms.cardfullview.CardFullViewFilter;
import org.r3.db.cms.cardfullview.CardFullViewPersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETCardsView extends ServicePattern
{
    private CardViewQueryActionForm queryForm;
    private String site;
    private String languageCode;
    private boolean fullMode;
    
	public GETCardsView(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSite, String aLanguageCode, CardViewQueryActionForm aQueryForm, boolean fullModeFlag)
	{
		super(ctx, serviceEnvironment);
		site = aSite;
		languageCode = aLanguageCode;
		fullMode = fullModeFlag;	
		
		queryForm = aQueryForm;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		CardFullViewFilter filter = queryForm.getCardFullViewSearchCondition(site, languageCode, fullMode);
		CardFullViewPersistence p = CardFullViewPersistence.createPersistenceObject(pcfg, aSession);						

		CardFullViewDataTableAdapter dt = null;
		if (queryForm.isChannelMode())
		{
			dt = p.queryChannel(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());			
		}
		else
		{
		if (queryForm.isFullMode(fullMode))
		{
			dt = p.query(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), false);
		}
		else
		{
			dt = p.queryPartial(filter, pcfg.getPersistenceConfigInfo(), queryForm.getsEcho(), queryForm.getiDisplayStart(), queryForm.getiDisplayLength(), queryForm.isExecuteCount());
		}
		}
		
	    return dt;			
	}



}
