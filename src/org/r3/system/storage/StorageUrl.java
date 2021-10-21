package org.r3.system.storage;

import org.r3.db.dms.model.DMSUrl;
import org.r3.db.dms.model.DMSUrl.UrlType;
import org.r3.db.mongo.filecollection.FileCollectionUrl;
import org.r3.system.storage.StorageManager.StorageManagerType;

public class StorageUrl
{
	public static StorageManagerType getStorageManagerType(String aUrl)
	{
		if (DMSUrl.getUrlType(aUrl) != UrlType.DMS_UNKNOWN)
			return StorageManagerType.dms;
		
		if (FileCollectionUrl.isFileCollectionUrl(aUrl))
			return StorageManagerType.mongo;
		
		if (OpenStackStorageUrl.isOpenStackStorageUrl(aUrl))
			return StorageManagerType.swift;
		
		return StorageManagerType.unknown;
	}


}
