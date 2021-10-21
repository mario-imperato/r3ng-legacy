package org.r3.ws.system.page.lut;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.cms.page.PageCriteria;
import org.r3.db.cms.page.PageDTO.PageType;
import org.r3.db.cms.page.PageFilter;
import org.r3.db.cms.page.PagePersistence;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.db.utils.SQLStringUtils;
import org.r3.db.utils.SQLStringUtils.LikeMode;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETCMSPageLUTItems extends LUTConditionalGetPattern
{
	private String pageType;
	private String pageVisibility;

	public GETCMSPageLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aPageType, String aPageVisibility)
	{
		super(ctx, serviceEnvironment, LUTName.cms_page.toString());
		pageType = aPageType;
		pageVisibility = aPageVisibility;
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
		PagePersistence p = PagePersistence.createPersistenceObject(pcfg, aSession);

		String querySite = getTargetSite(); 
		if (querySite == null)
			querySite = getServiceEnvironment().getRequestSiteId();
		
		PageFilter filter = new PageFilter();
		PageCriteria criteria = filter.or().andSiteEqualTo(querySite).andPageidNotEqualTo(PageType.group.toString());
		if (pageType != null)
			criteria.andPagetypeEqualTo(pageType);
		
		if (pageVisibility != null)
			criteria.andVisibilityLike(SQLStringUtils.getStringForLikeMode(pageVisibility, LikeMode.FullLike));
		
		filter.setOrderByClause(" pagetitle ");
		
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}
