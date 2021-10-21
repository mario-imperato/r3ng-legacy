package org.r3.ws.project.siteresource;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.project.siteresource.SiteResourceDTO;
import org.r3.db.project.siteresource.SiteResourcePersistence;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class PUTSiteResource extends ServicePattern
{

	private SiteResourceActionForm actionForm;
	private String resourceId;

	public PUTSiteResource(ServletContext ctx, ServiceEnvironment serviceEnvironment,
			String aResourceId, SiteResourceActionForm anActionForm)
	{
		super(ctx, serviceEnvironment);
		actionForm = anActionForm;
		resourceId = aResourceId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SiteResourcePersistence p = SiteResourcePersistence
				.createPersistenceObject(pcfg, aSession);

		SiteResourceDTO resourceDTO = actionForm.getDTO4Update(senv.getRequestSiteId(), resourceId);
		p.updateByPrimaryKey(resourceDTO, pcfg.getPersistenceConfigInfo());

		return resourceDTO;
	}


}
