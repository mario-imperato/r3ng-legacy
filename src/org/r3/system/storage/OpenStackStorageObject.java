package org.r3.system.storage;

public class OpenStackStorageObject extends StorageObject
{
	private String publicUrl;
	
	public OpenStackStorageObject()
	{
		// TODO Auto-generated constructor stub
	}
	
	public void setPublicUrl(String publicUrl)
	{
		this.publicUrl = publicUrl;
	}

	@Override
	public String getUrl()
	{
		return publicUrl;
	}

	@Override
	public String getRestUrl()
	{
		return publicUrl;
	}

}
