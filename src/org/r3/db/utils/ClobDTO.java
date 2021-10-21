package org.r3.db.utils;

public class ClobDTO
{
     private String blobData;

	public String getBlobData()
	{
		return blobData;
	}

	public void setBlobData(String blobData)
	{
		this.blobData = blobData;
	}
	
	public int size()
	{
		if (blobData != null)
			return blobData.length();
		
		return 0;
	}
          
}
