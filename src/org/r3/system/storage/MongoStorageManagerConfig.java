package org.r3.system.storage;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.system.storage.StorageManager.StorageManagerType;

public class MongoStorageManagerConfig extends StorageManagerConfig
{			
	public MongoStorageManagerConfig()
	{
		setStorageManagerType(StorageManagerType.mongo);
	}

	@Override
	public void readStorageManagerConfig(PersistenceContext pcfg, SqlSession aSession, String aSite)
	{			

	}
}
