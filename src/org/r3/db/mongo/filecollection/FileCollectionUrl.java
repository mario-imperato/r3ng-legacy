package org.r3.db.mongo.filecollection;

import org.apache.velocity.exception.ParseErrorException;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.utils.MongoUtils;
import org.r3.system.R3Application;

public class FileCollectionUrl
{
    private String oid;
    private String site;
    private String language;
    private String dbname;
    private String collection;
    
	public FileCollectionUrl(String aSite, String aLanguage, String aDbname, String aCollection, String anOidAsString)
	{
		site = aSite;
		language = aLanguage;
		dbname = aDbname;
		collection = aCollection;
		oid = anOidAsString;
	}

	public static boolean isFileCollectionUrl(String aUrl)
	{
		if (aUrl.startsWith("mfs://"))
			return true;
		
		return false;
	}
	
	public FileCollectionUrl(String aUrl)
	{
		if (isFileCollectionUrl(aUrl))
		{
			// Tolgo uno slash in piu' in quanto se no lo split mi torna un elemento spurio vuoto...
			String[] s = aUrl.substring("mfs:///".length()).split("/");
			if (s.length == 5)
			{
				site = s[0];
				language = s[1];				
				dbname = s[2];
				collection = s[3];
				oid = s[4];
				
				return ;
			}
		}

		throw new ParseErrorException("Url Is not in the expected format: " + aUrl);			
	}
	
	public String getOid()
	{
		return oid;
	}

	public String getSite()
	{
		return site;
	}

	public String getLanguage()
	{
		return language;
	}

	public String getDbname()
	{
		return dbname;
	}

	public String getCollection()
	{
		return collection;
	}
	
	public static FileCollectionUrl newInstance(String aUrl)
	{
		try
		{
		    FileCollectionUrl fu = new FileCollectionUrl(aUrl);
			if (fu.oid  != null) return fu;
		}
		catch(ParseErrorException perr)
		{
			
		}
		
		return null;
	}
	
	public static String getRestUrl(String aSite, String aLanguage, String aUrl)
	{
	   String u = null;
		
	   FileCollectionUrl fu = FileCollectionUrl.newInstance(aUrl);
	   if (fu != null)
	   {
		   u = String.format(R3Application.MongoDbFileUrlMountPoint, aSite, aLanguage,aUrl.substring("mfs:///".length()));
	   }	   
	   
	   return u;
	}
	
	public String getUrl()
	{
		String s = String.format(MongoDbSchemaInfo.MongoDbFileStoreUrlPattern, site, language, MongoDbSchemaInfo.MongoDbName, MongoDbSchemaInfo.MongoDbFileStoreCollectionName, oid);		
		return s;
	}

	public Query<FileCollectionDTO> queryFilter(Datastore ds)
	{
		Query<FileCollectionDTO> q = ds.createQuery(FileCollectionDTO.class);
		q.field("site").equal(site);
		q.or(            		
			q.criteria("_id").equal(MongoUtils.getObjectIdFromString(oid)),
			q.criteria("masterfile").equal(oid)
		);
		
		return q;
	}
}
