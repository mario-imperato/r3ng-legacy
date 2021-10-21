package org.r3.system.storage;

import org.apache.ibatis.session.SqlSession;
import org.r3.db.PersistenceContext;
import org.r3.system.storage.StorageManager.StorageManagerType;

public class DMSStorageManagerConfig extends StorageManagerConfig
{			
	public DMSStorageManagerConfig()
	{
		setStorageManagerType(StorageManagerType.dms);
	}

	@Override
	public void readStorageManagerConfig(PersistenceContext pcfg, SqlSession aSession, String aSite)
	{			
		setContainer("PUB");
	}
}
