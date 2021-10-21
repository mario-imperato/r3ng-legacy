package org.r3.ws.actors.actor;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.ws.actors.actor.csv.CSVFileUploadDTOFactory;
import org.r3.ws.system.fileimport.POSTCSVFileUpload;

public class POSTActorFileUpload extends POSTCSVFileUpload
{
	public POSTActorFileUpload(
			ServletContext ctx, ServiceEnvironment serviceEnvironment, 
			MultipartFormDataInput input, String fileDataPart, boolean isIEFlag)
	{
		super(ctx, serviceEnvironment, input, fileDataPart, new CSVFileUploadDTOFactory(), true, isIEFlag);
	}

}
