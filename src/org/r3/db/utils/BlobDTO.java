package org.r3.db.utils;

public class BlobDTO
{
     private byte[] blobData;

	public byte[] getBlobData()
	{
		return blobData;
	}

	public void setBlobData(byte[] blobData)
	{
		this.blobData = blobData;
	}
	
	public int size()
	{
		if (blobData != null)
			return blobData.length;
		
		return 0;
	}
          
}
