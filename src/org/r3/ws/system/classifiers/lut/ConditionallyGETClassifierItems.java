package org.r3.ws.system.classifiers.lut;


import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.db.system.classifieritem.ClassifierItemDTO;
import org.r3.db.system.classifieritem.ClassifierItemDataTableAdapter;
import org.r3.db.system.classifieritem.ClassifierItemPersistence;
import org.r3.system.rest.LUTConditionalGetPattern;
import org.r3.system.rest.ServiceEnvironment;

public class ConditionallyGETClassifierItems extends LUTConditionalGetPattern
{
    private String     classifierId = null;
    private String     classifierItemId = null;
    private Integer    classifierItemDepth = null;
    private String     classifierItemSAttr = null;
    
//    private int        cacheIntervalInSecs = -1;
//    private EntityTag  classifierETag = null;
    
	public ConditionallyGETClassifierItems(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aClassifierId, Integer depth, String sattr)
	{
		this(ctx, serviceEnvironment, aClassifierId, null, depth, sattr);
	}

    public ConditionallyGETClassifierItems(ServletContext ctx, ServiceEnvironment serviceEnvironment, String aClassifierId, String aClassifierItemId, Integer depth, String sattr)
	{
		super(ctx, serviceEnvironment, aClassifierId);
		classifierId = aClassifierId;
		classifierItemId = aClassifierItemId;
		classifierItemDepth = depth;
		classifierItemSAttr = sattr;
		
		// retrieveCacheInfo(aClassifierId);
	}
	
//	private void retrieveCacheInfo(String aClassifierId)
//	{
//		PersistenceContext pcfg = PersistenceContext.getPersistenceContext();
//		SqlSession aSession = pcfg.openSession();
//		try
//		{			
//			UNEPClassifierPersistence p = UNEPClassifierPersistence.createPersistenceObject(pcfg, aSession);
//			UNEPClassifierDTO dto = p.selectByClassifierid(aClassifierId, pcfg.getPersistenceConfigInfo());
//			
//			if (dto.getCacheinterval() == null)
//				 cacheIntervalInSecs = -1;
//			else cacheIntervalInSecs = dto.getCacheintervalAsInt();
//			
//			if (dto.getEtag() != null)
//			     classifierETag = new EntityTag(dto.getEtag());
//			else 
//			{
//				 classifierETag = new EntityTag(Long.toString(dto.getRectimestamp().getTime()));			
//			}
//			
//			aSession.commit();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			aSession.close();
//		}		
//	}
//
//	@Override
//	protected long getCacheIntervalInMillis()
//	{		
//		return (cacheIntervalInSecs > 0) ? ((long)cacheIntervalInSecs) * 1000 : -1;
//	}
//
//	@Override
//	protected int getCacheIntervalInSecs()
//	{
//		return cacheIntervalInSecs;
//	}
//	
//	@Override 
//	protected EntityTag getETag()
//	{
//		return classifierETag;
//	}
	
	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{				
		ClassifierItemDataTableAdapter dt = getData(pcfg, aSession, classifierId, classifierItemId, classifierItemDepth);
		return dt;
	}

	private ClassifierItemDataTableAdapter getData(PersistenceContext pcfg, SqlSession sqlSession, String aClassifierId, String aClassifierItemId, Integer aClassifierItemDepth)
	{
		List<ClassifierItemDTO> l = null;
	
		String querySite = getTargetSite(); 
		if (querySite == null)
			querySite = getServiceEnvironment().getRequestSiteId();

		ClassifierItemPersistence p = ClassifierItemPersistence.createPersistenceObject(pcfg, sqlSession);
		// WARNING: Serve?
		// p.setMapper(sqlSession.getMapper(ClassifierItemMapper.class));
		
		if (aClassifierItemId != null)
		     l = p.selectChildrenOfClassifieritemid(querySite, aClassifierId, aClassifierItemId, classifierItemSAttr, pcfg.getPersistenceConfigInfo());
		else
		     l = p.selectByClassifierid(querySite, aClassifierId, aClassifierItemDepth, classifierItemSAttr, pcfg.getPersistenceConfigInfo());

		ClassifierItemDataTableAdapter dt = new ClassifierItemDataTableAdapter();
		dt.setsEcho("1");
		dt.setiTotalRecords(l.size());
		dt.setiTotalDisplayRecords(l.size());
		dt.setAaData(l);

		return dt;
	}

}
