package org.r3.ws.sailevent.ranking.cyberaltura;

import java.util.HashMap;

import org.r3.system.rest.fileupload.FileUploadDTO;
import org.r3.system.rest.fileupload.FileUploadDTOFactory;
import org.r3.system.rest.fileupload.FileUploadField;

public class CyberAlturaFileUploadDTOFactory extends FileUploadDTOFactory
{

	public CyberAlturaFileUploadDTOFactory()
	{
	}

	@Override
	public FileUploadDTO newFileUploadDTOInstance(String aContentType, HashMap<String, FileUploadField> formFields)
	{
		return new CyberAlturaFileUploadDTO();
	}
}
