package org.r3.ws.sailevent.sailevent.lut;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.sailevent.event.SailEventFilter;
import org.r3.db.sailevent.event.SailEventPersistence;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class GETSailEventLUTItems extends LUTConditionalGetPattern
{
	private String eventgroup;
	
	public GETSailEventLUTItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String anEventgroup)
	{
		super(ctx, serviceEnvironment, LUTName.sailevent.toString());
		eventgroup = anEventgroup;
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
		SailEventPersistence p = SailEventPersistence.createPersistenceObject(pcfg, aSession);

		SailEventFilter filter = new SailEventFilter();
		filter.setOrderByClause(" eventid ");
		
		if (eventgroup != null)
		{
		   filter.or().andEventgroupEqualTo(eventgroup).andEventidNotEqualTo(senv.getRequestSiteId());
		}
		
		return p.query(filter, pcfg.getPersistenceConfigInfo(), "1", 0, -1, false);
	}

}
