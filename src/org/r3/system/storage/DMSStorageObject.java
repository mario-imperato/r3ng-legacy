package org.r3.system.storage;

import org.r3.db.dms.model.DMSFileMetadata;
import org.r3.system.util.ContentTypeUtil;

public class DMSStorageObject extends StorageObject
{
	private String dmsUrl;
	
	public DMSStorageObject()
	{

	}

	public void setDmsUrl(String aUrl)
	{
		dmsUrl = aUrl;
	}
	
	@Override
	public String getUrl()
	{
		return dmsUrl;
	}

	@Override
	public String getRestUrl()
	{
		return dmsUrl;
	}

	public DMSFileMetadata getFileMetadata(String overrideFileName)
	{
		DMSFileMetadata metadata = new DMSFileMetadata();

		String originalFileName = getName();
		if (overrideFileName != null)
		{               
               if (ContentTypeUtil.findExtension(overrideFileName) == null)
               {
            	   String ext  = ContentTypeUtil.findExtension(originalFileName);   
            	   StringBuilder stb = new StringBuilder().append(overrideFileName);
            	               	   
            	   stb.append('.').append(ext);
            	   overrideFileName = stb.toString();
               }
               
               metadata.setClientFileName(originalFileName);
               metadata.setFileName(overrideFileName);
		}
		else   metadata.setFileName(originalFileName);
		
		metadata.setContentType(this.getContenttype());
		return metadata;
	}
}
