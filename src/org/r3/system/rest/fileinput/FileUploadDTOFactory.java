package org.r3.system.rest.fileinput;

import org.r3.system.rest.fileinput.FileUploadDTO.FileUploadDTO_FileRole;
import org.r3.system.util.ContentTypeUtil;

public class FileUploadDTOFactory
{
	public FileUploadDTOFactory()
	{

	}
	
	public FileUploadDTO newFileUploadDTOInstance(String aContentType)
	{
		FileUploadDTO fileInfo = null;
		if (ContentTypeUtil.isInternetImage(aContentType))
		{
			 fileInfo = new FileUploadDTO(FileUploadDTO_FileRole.image);
		}
		else fileInfo = new FileUploadDTO();

		return fileInfo;
	}
}
