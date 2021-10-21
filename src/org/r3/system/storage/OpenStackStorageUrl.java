package org.r3.system.storage;

public class OpenStackStorageUrl extends StorageUrl
{

	public OpenStackStorageUrl()
	{

	}

	public static boolean isOpenStackStorageUrl(String aUrl)
	{
		if (aUrl.startsWith("http"))
			return true;
		
		return false;
	}
}
