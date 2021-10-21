package org.r3.system.rest.fileupload;

import java.util.HashMap;

import org.r3.system.util.ContentTypeUtil;

public class FileUploadDTOFactory
{
    private String contentTypeSpecifierFieldName = null;
	public FileUploadDTOFactory()
	{

	}

	public FileUploadDTOFactory(String aContentTypeSpecifierFieldName)
	{
		contentTypeSpecifierFieldName = aContentTypeSpecifierFieldName; 
	}
	
	public FileUploadDTO newFileUploadDTOInstance(String aContentType, HashMap<String, FileUploadField> formFields)
	{
		String contentTypeSpecifier = null;
		if (contentTypeSpecifierFieldName != null && formFields != null)
		{
			FileUploadField fd = formFields.get(contentTypeSpecifierFieldName);
			if (fd != null)
			   contentTypeSpecifier = fd.getValue(); 
		}
		
		System.out.printf("The FileUploadDTOActionForm Input Params: %s - %s - %s\n", aContentType, contentTypeSpecifierFieldName, contentTypeSpecifier);
		
		FileUploadDTO fileInfo = null;
		if (ContentTypeUtil.isInternetImage(aContentType))
		{
			 fileInfo = new ImageUploadDTO();
		}
		else if (contentTypeSpecifier != null && contentTypeSpecifier.indexOf("reptracker")>=0)
			 fileInfo = new ReportTrackerFileUploadDTO();
		else fileInfo = new FileUploadDTO();

		return fileInfo;
	}
}
