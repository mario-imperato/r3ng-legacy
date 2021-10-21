package org.r3.ws.system.dms;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.core.CacheControl;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.mongo.filecollection.FileCollectionPersistence;
import org.r3.system.ServicePatternException;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.system.util.ContentTypeUtil;

public class GETMongoDMSFile extends ServicePattern
{
	private String urlSite;
	private String urlLanguage;
    private String dbName;
    private String collectionName;
    private String objectId;
    private String guessedFileName;
    private String mimeType;
    private boolean forceDownload;
    
	public GETMongoDMSFile(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aUrlSite, String aUrlLanguage, String aDbName, String aCollectionName, String anObjectId, boolean aForceDownloadFlag)
	{
		super(ctx, serviceEnvironment);

		mimeType = ContentTypeUtil.findMimeType(anObjectId);
		guessedFileName = ContentTypeUtil.guessFileName(anObjectId, mimeType);
		forceDownload = aForceDownloadFlag;
		
		urlSite = aUrlSite;
		urlLanguage = aUrlLanguage;
		dbName = aDbName;
		collectionName = aCollectionName;
		
		int ndx = anObjectId.indexOf('.');
		if (ndx >= 0)
			 objectId = anObjectId.substring(0, ndx);
		else objectId = anObjectId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)  throws ServicePatternException
	{        
		MongoPersistenceContext mpctx = pcfg.getMongoPersistenceContext();
		
		FileCollectionPersistence dp = new FileCollectionPersistence();
		FileCollectionDTO doc = dp.selectBySiteObjectid(mpctx, urlSite, objectId);
		
		if (doc != null)
		{
			mimeType = doc.getContenttype();
		}
		
		return doc.getData().getData();
		// return new File("c:/tmp/37089690-Twp-Cdc-Cookbook-0206.pdf");
	}

	@Override
	protected String getMediaType()
	{
		return mimeType;
	}

	@Override
	protected Map<String, String> returningHeaders()
	{
		if (forceDownload)
		{
		    Map<String, String> hs = new HashMap<String, String>(); 	
		    hs.put("Content-Transfer-Encoding", "binary");
		    hs.put("Accept-Ranges", "bytes");
		    hs.put("Content-Encoding", "none");
		    hs.put("Content-Disposition", "attachment; filename=" + guessedFileName);
		    
		    System.out.println("Returning Headers");
		    return hs;
		}
		
		return super.returningHeaders();
	}

	@Override
	protected CacheControl getCacheControl()
	{
		CacheControl cc = new CacheControl();
		cc.setPrivate(true);		
		return null;
	}
}
