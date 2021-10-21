package org.r3.ws.actors.actor.csv;

import java.util.HashMap;

import org.r3.system.rest.fileupload.FileUploadDTO;
import org.r3.system.rest.fileupload.FileUploadDTOFactory;
import org.r3.system.rest.fileupload.FileUploadField;

public class CSVFileUploadDTOFactory extends FileUploadDTOFactory
{

	public CSVFileUploadDTOFactory()
	{
	}

	@Override
	public FileUploadDTO newFileUploadDTOInstance(String aContentType, HashMap<String, FileUploadField> formFields)
	{
		return new CSVFileUploadDTO();
	}
}
