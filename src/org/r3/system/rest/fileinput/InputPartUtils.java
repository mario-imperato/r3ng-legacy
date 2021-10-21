package org.r3.system.rest.fileinput;

import javax.ws.rs.core.MultivaluedMap;

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.r3.db.dms.model.DMSFileMetadata;
import org.r3.system.util.ContentTypeUtil;

public class InputPartUtils
{
	public static String extractAttributeFromContentDisposition(String headerContentDisposition, String attributeName)
	{
		String[] contentDisposition = headerContentDisposition.split(";");
		for (String filename : contentDisposition)
		{
			if ((filename.trim().startsWith(attributeName)))
			{
				String[] name = filename.split("=");

				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}

		return null;
	}
	
    public static DMSFileMetadata getFileMetadata(InputPart inputPart, String overrideFileName)
	{
		MultivaluedMap<String, String> header = inputPart.getHeaders();
		DMSFileMetadata metadata = new DMSFileMetadata();

		String originalFileName = InputPartUtils.extractAttributeFromContentDisposition(header.getFirst("Content-Disposition"), "filename");
		if (overrideFileName != null)
		{               
               if (ContentTypeUtil.findExtension(overrideFileName) == null)
               {
            	   String ext  = ContentTypeUtil.findExtension(originalFileName);   
            	   StringBuilder stb = new StringBuilder().append(overrideFileName).append('.').append(ext);
            	   overrideFileName = stb.toString();
               }
               
               metadata.setClientFileName(originalFileName);
               metadata.setFileName(overrideFileName);
		}
		else   metadata.setFileName(originalFileName);
		
		String contentType = header.getFirst("Content-Type");
		metadata.setContentType(contentType);

		return metadata;
	}


}
