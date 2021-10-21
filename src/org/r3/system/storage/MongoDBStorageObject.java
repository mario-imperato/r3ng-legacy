package org.r3.system.storage;

import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.mongo.filecollection.FileCollectionUrl;

public class MongoDBStorageObject extends StorageObject
{

	public MongoDBStorageObject()
	{
	}

    public void setObjectid(org.bson.types.ObjectId  p)         
	{ 
	     setObjectid(p.toHexString()); 
	}
	  
	@Override
	public String getUrl()
	{
		String s = String.format(MongoDbSchemaInfo.MongoDbFileStoreUrlPattern, getSite(), getLanguage(), MongoDbSchemaInfo.MongoDbName, MongoDbSchemaInfo.MongoDbFileStoreCollectionName, getObjectid());		
		return s;
	}
	
	@Override
	public String getRestUrl()
	{
		return FileCollectionUrl.getRestUrl(getSite(), getLanguage(), getUrl());
	}

}
