package org.r3.ws.cms.category;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.categoryview.CategoryViewFilter;
import org.r3.db.cms.categoryview.CategoryViewPersistence;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETCMSCategoryLUTItems extends LUTConditionalGetPattern
{
	
	public GETCMSCategoryLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment)
	{
		super(ctx, serviceEnvironment, LUTName.cms_category.toString());
	}

//	private EntityTag computeETag()
//	{
//		long cacheInterval = getCacheIntervalInMillis();
//
//		Calendar c = Calendar.getInstance();
//		long currentTime = c.getTimeInMillis();
//
//		c.set(Calendar.HOUR_OF_DAY, 0);
//		c.set(Calendar.MINUTE, 0);
//		c.set(Calendar.SECOND, 0);
//		c.set(Calendar.MILLISECOND, 0);
//		long midnightTime = c.getTimeInMillis();
//
//		long diffTime = currentTime - midnightTime;
//		long lastModified = (diffTime / cacheInterval) * cacheInterval + midnightTime;
//
//		EntityTag tag = new EntityTag(Long.toString(lastModified));
//		return tag;
//	}

//	@Override
//	protected long getCacheIntervalInMillis()
//	{
//		return (cacheIntervalInSecs > 0) ? ((long) cacheIntervalInSecs) * 1000 : -1;
//	}
//
//	@Override
//	protected int getCacheIntervalInSecs()
//	{
//		return cacheIntervalInSecs;
//	}

//	@Override
//	protected EntityTag getETag()
//	{
//		return lutETag;
//	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		CategoryViewPersistence p = CategoryViewPersistence.createPersistenceObject(pcfg, aSession);

		String querySite = getTargetSite(); 
		if (querySite == null)
			querySite = getServiceEnvironment().getRequestSiteId();
		
		CategoryViewFilter filter = new CategoryViewFilter();
		filter.or().andSiteEqualTo(querySite).andLanguagecodeEqualTo(getServiceEnvironment().getRequestLanguage());
		filter.setOrderByClause(" categorydescr ");
		
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}
