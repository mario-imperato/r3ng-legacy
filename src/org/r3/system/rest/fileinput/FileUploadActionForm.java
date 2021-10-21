package org.r3.system.rest.fileinput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.james.mime4j.message.BodyPart;
import org.apache.james.mime4j.message.SingleBody;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.cms.attachmenttype.AttachmentTypeDTO;
import org.r3.db.cms.attachmenttype.AttachmentTypeLUT;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.util.ContentTypeUtil;
import org.r3.system.util.StringUtils;

public class FileUploadActionForm
{
	private List<FileUploadDTO> listOfFiles;
	private HashMap<String, FileUploadField> listOfFields;
	private String fileUploadType;
	
	public FileUploadActionForm()
	{
		listOfFields = null;
		listOfFiles = null;
	}

	public void init(MultipartFormDataInput multipartFormDataInput, String filePartName, FileUploadDTOFactory dtoFactory, boolean forceUtf8Encoding, String anAttachmentType) throws Exception
	{				
		fileUploadType = anAttachmentType;
		Map<String, List<InputPart>> uploadForm = multipartFormDataInput.getFormDataMap();

		Set<String> setOfParts = uploadForm.keySet();
		
		List<InputPart> listOfFileInputPart = null;
		for (String aPartName : setOfParts)
		{
			List<InputPart> listOfInputPart = uploadForm.get(aPartName);
			if (filePartName.indexOf(aPartName)>=0)   // aPartName.equalsIgnoreCase(filePartName))
			{
				listOfFileInputPart = listOfInputPart;
			}
			else
			{
				for (InputPart propertyPart : listOfInputPart)
				{
					FileUploadField fd = retrieveFileUploadField(propertyPart);
					if (fd != null)
					{
//						if (fd.getName().equalsIgnoreCase(LUTName.cms_attachtype.toString()))
//						{
//							setImageOptions(fd.getValue());
//						}
//						else 
						add(fd);
					}
				}
			}
		}
		
		// Posticipo la lavorazione dei file al momento in cui conosco eventuali campi allegati alla form.
		if (listOfFileInputPart != null)
		{
			for (InputPart inputPart : listOfFileInputPart)
			{
				MultivaluedMap<String, String> header = inputPart.getHeaders();
				String originalFileName = InputPartUtils.extractAttributeFromContentDisposition(header.getFirst("Content-Disposition"),
								"filename");
				String contentType = header.getFirst("Content-Type");
                if (contentType != null && contentType.equalsIgnoreCase("binary/octet-stream"))
                {
                	contentType = ContentTypeUtil.findMimeType(originalFileName);
                }
                
				FileUploadDTO fileInfo = dtoFactory.newFileUploadDTOInstance(contentType);				
				fileInfo.setUploadFileName(originalFileName);
				fileInfo.setContentType(contentType);
				fileInfo.setFileInputStream(this.getInputPartInputStream(inputPart, forceUtf8Encoding));
									
				add(fileInfo);
			}
		}
	}
		
	public void add(FileUploadDTO fileUploadDTO)
	{
		if (listOfFiles == null)
			listOfFiles = new ArrayList<FileUploadDTO>();

		listOfFiles.add(fileUploadDTO);
	}

	public List<FileUploadDTO> getFiles()
	{
		return listOfFiles;
	}

	public FileUploadDTO getUploadedFile()
	{
		if (listOfFiles != null && listOfFiles.size() > 0)
			return listOfFiles.get(0);
		
		return null;
	}

	protected InputStream getInputPartInputStream(InputPart inputPart, boolean forceUtf8Encoding) throws Exception
	{
		InputStream is = null;
		if (forceUtf8Encoding)
		{
			byte[] fileBytes = readByteArray(inputPart);
			is = new ByteArrayInputStream(fileBytes);
		}
		else
		{
			is = inputPart.getBody(InputStream.class, null);
		}

		return is;
	}

	private byte[] readByteArray(InputPart inputPart) throws Exception
	{
		java.lang.reflect.Field f = inputPart.getClass().getDeclaredField("bodyPart");
		f.setAccessible(true);
		BodyPart bodyPart = (BodyPart) f.get(inputPart);
		SingleBody body = (SingleBody) bodyPart.getBody();

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		body.writeTo(os);
		byte[] fileBytes = os.toByteArray();
		return fileBytes;
	}

	public void add(FileUploadField formFieldData)
	{
		if (listOfFields == null)
			listOfFields = new HashMap<String, FileUploadField>();

		listOfFields.put(formFieldData.getName(), formFieldData);
	}

	public Collection<FileUploadField> getFields()
	{
		if (listOfFields != null)
		  return listOfFields.values();
		
		return null;
	}

	public FileUploadField getField(String aFieldName)
	{
		if (listOfFields != null)
			return listOfFields.get(aFieldName);

		return null;
	}

	private FileUploadField retrieveFileUploadField(InputPart inputPart)
	{
		try
		{
			MultivaluedMap<String, String> header = inputPart.getHeaders();

			String contentDisposition = header.getFirst("Content-Disposition");
			String fieldName = InputPartUtils.extractAttributeFromContentDisposition(contentDisposition, "name");
			if (fieldName != null)
			{		
				// Questo metodo non gestisce correttamente le accentate.
				// String fieldValue = inputPart.getBodyAsString();
				InputStream is = this.getInputPartInputStream(inputPart, true);
				String fieldValue = StringUtils.getStringFromInputStream(is);
				
				if (fieldValue != null)
				{
				FileUploadField p = new FileUploadField(fieldName, fieldValue);
				return p;
				}								
			}
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public AttachmentTypeDTO retrieveAttachmentTypeDTO(String aSite)
	{
		FileUploadField cmsAttachType = getField(LUTName.cms_attachtype.toString());
		String ut = fileUploadType;
		
		if (cmsAttachType == null && (ut == null || ut.trim().length() == 0))
		{			
			return null;			
		}
				
		if (cmsAttachType != null)
			ut = cmsAttachType.getValue();
		
		AttachmentTypeLUT attachmentTypeLUT = (AttachmentTypeLUT)LUTManager.getLUTManager().getLUT(LUTName.cms_attachtype, null);
		AttachmentTypeDTO lutItem = null;
		
		// Gestisco la situazione nella quale mi entra come x_y oppure solo y quando x == al sito richiesto.
		if (ut.startsWith(aSite))
			lutItem = attachmentTypeLUT.getItem(ut);
		else 
			lutItem = attachmentTypeLUT.getItem(aSite, ut);
		
		return lutItem;
	}

	
}
