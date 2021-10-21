package org.r3.ws.system.site.lut;


import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.site.SiteCriteria;
import org.r3.db.system.site.SiteFilter;
import org.r3.db.system.site.SitePersistence;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETSiteChildrenLUTItems extends LUTConditionalGetPattern
{
    private String filterOptParam;
    
	public GETSiteChildrenLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aFilterOptParam)
	{
		super(ctx, serviceEnvironment,LUTName.site.toString());
		filterOptParam = aFilterOptParam;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SitePersistence p = SitePersistence.createPersistenceObject(pcfg, aSession);

		SiteFilter filter = new SiteFilter();
		SiteCriteria criteria = filter.or().andSiteIsChildOf(senv.getRequestSiteId()).andHasOption(filterOptParam);		
		filter.setOrderByClause(" sitedescr ");
				
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}
