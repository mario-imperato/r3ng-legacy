package org.r3.ws.system.site.lut;


import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.system.site.SiteFilter;
import org.r3.db.system.site.SitePersistence;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETSiteLUTItems extends LUTConditionalGetPattern
{
    private String siteType;
    
	public GETSiteLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aSiteType)
	{
		super(ctx, serviceEnvironment,LUTName.site.toString());
		siteType = aSiteType;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		SitePersistence p = SitePersistence.createPersistenceObject(pcfg, aSession);

		SiteFilter filter = new SiteFilter();
		filter.setOrderByClause(" sitedescr ");
		filter.or().andSitetypeEqualTo(siteType);
		
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}
