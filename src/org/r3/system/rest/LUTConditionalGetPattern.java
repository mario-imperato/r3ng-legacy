package org.r3.system.rest;


import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.lut.LUTDictionaryDTO;
import org.r3.db.system.lut.LUTDictionaryPersistence;

public abstract class LUTConditionalGetPattern extends ServicePattern
{
	private int        cacheIntervalInSecs = -1;
	private EntityTag  classifierETag = null;
	private String     targetSite;
	
	public LUTConditionalGetPattern(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aLutName)
	{
		super(ctx, serviceEnvironment);
		retrieveCacheInfo(aLutName);
	}

	private void retrieveCacheInfo(String aLutName)
	{
		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		SqlSession aSession = pcfg.openSession();
		try
		{			
			LUTDictionaryPersistence p = LUTDictionaryPersistence.createPersistenceObject(pcfg, aSession);
			LUTDictionaryDTO dto = p.selectByLutid(aLutName, pcfg.getPersistenceConfigInfo());
			
			if (dto == null)
				System.out.println("LUTConditionalGetPattern::LutItem not found: " + aLutName);
			
			if (dto.getCacheinterval() == null)
				 cacheIntervalInSecs = -1;
			else cacheIntervalInSecs = dto.getCacheintervalAsInt();
			
			if (dto.getEtag() != null)
			     classifierETag = new EntityTag(dto.getEtag());
			else 
			{
				 classifierETag = new EntityTag(Long.toString(dto.getRectimestamp().getTime()));			
			}
			
			targetSite = dto.getTargetsite();
			
			aSession.commit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			aSession.close();
		}		
	}

	protected String getTargetSite()
	{		
		return targetSite;
	}
	
	protected long getCacheIntervalInMillis()
	{		
		return (cacheIntervalInSecs > 0) ? ((long)cacheIntervalInSecs) * 1000 : -1;
	}

	protected int getCacheIntervalInSecs()
	{
		return cacheIntervalInSecs;
	}
	
	protected EntityTag getETag()
	{
		return classifierETag;
	}

	protected boolean isCacheable()
	{
		return getCacheIntervalInMillis() > 0;
	}

	protected abstract Object process(PersistenceContext pcfg, SqlSession aSession);

	protected Date getExpires()
	{
		Calendar c = Calendar.getInstance();
		logger.debug("process(Request) -- Start setting expiration to --> " + c.getTime() + " with " + getCacheIntervalInSecs());
		c.add(Calendar.SECOND, getCacheIntervalInSecs());		
		logger.debug("process(Request) -- Setting expiration to --> " + c.getTime());
		return c.getTime();
	}

	@Override
	protected CacheControl getCacheControl()
	{
		CacheControl cc = new CacheControl();
		cc.setMaxAge(getCacheIntervalInSecs());
		return cc;
	}

	protected CacheControl getNoCache()
	{
		CacheControl cc = new CacheControl();
		cc.setNoCache(true);
		return cc;
	}

	@Override
	public Response process(Request request)
	{
		logger.debug("process(Request) -- " + new java.util.Date());
		
		if (isCacheable())
		{
			ResponseBuilder builder = request.evaluatePreconditions(getETag());
			if (builder != null)
			{
				logger.debug("process(Request) -- Preconditions Met --> NO DATA");

				CacheControl c = getCacheControl();
				if (c != null)
					builder.cacheControl(c);

				builder.expires(getExpires());
				return builder.build();
			}

			logger.debug("process(Request) -- Preconditions Failed --> Fetching Data");
		}
		else
		{
			logger.debug("process(Request) -- Request Not cacheable --> Fetching Data");
		}

		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
		
		SqlSession session = pcfg.openSession();
		try
		{
			Object responseData = process(pcfg, session);

			ResponseBuilder builder = Response.ok(responseData);
			if (isCacheable())
			{
				builder.expires(getExpires());
				builder.tag(getETag());
				CacheControl c = getCacheControl();
				if (c != null)
					builder.cacheControl(c);
			}
			else
			{
				CacheControl c = getNoCache();
				builder.cacheControl(c);
			}
			return builder.build();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

		throw new WebApplicationException(Response.Status.SERVICE_UNAVAILABLE);
	}

}
