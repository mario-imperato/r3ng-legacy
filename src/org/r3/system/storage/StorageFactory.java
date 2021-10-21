package org.r3.system.storage;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.system.storage.StorageManager.StorageManagerType;

public class StorageFactory
{
	public static StorageManager newStorageManagerInstance(PersistenceContext pcfg, SqlSession aSession, String aSite, StorageManagerType smType) throws StorageException
	{
		StorageManagerConfig config = StorageManagerConfig.readStorageManagerConfigFor(pcfg, aSession, aSite, smType);
		return new MongoDBStorageManager(pcfg, aSession, config);
	}
	
	public static StorageManager newStorageManagerInstance(PersistenceContext pcfg, SqlSession aSession, String aSite, String aUrl) throws StorageException
	{
		StorageManagerType storeManagerType = StorageUrl.getStorageManagerType(aUrl);
		if (storeManagerType == StorageManagerType.unknown)
			throw new StorageException("Could Not Determine StorageManagerType For: " + aUrl);
		
		return newStorageManagerInstance(pcfg, aSession, aSite, storeManagerType);
	}
	
	public static StorageManager newDefaultStorageManagerInstance(PersistenceContext pcfg, SqlSession aSession, String aSite) throws StorageException
	{
		StorageManagerConfig config = StorageManagerConfig.readStorageManagerConfigFor(pcfg, aSession, aSite);

		StorageManager sm = null;
		switch(config.getStorageManagerType())
		{
		case dms:
			sm = new DMSStorageManager(pcfg, aSession, config);
			break;
		case mongo:
			sm = new MongoDBStorageManager(pcfg, aSession, config);
			break;
		case swift:
			sm = new OpenStackStorageManager(pcfg, aSession, config);
			break;
		}
		
		if (sm == null)
			throw new StorageException("Could Not Determine StorageManagerConfig For Site: " + aSite);
		
		return sm;
	}
	
}
