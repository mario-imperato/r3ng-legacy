package org.r3.system.rest.fileupload;

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
import org.r3.system.rest.fileupload.FileUploadProcessingConfig.ConfigParamClass;
import org.r3.system.util.ContentTypeUtil;
import org.r3.system.util.StringUtils;

public class FileUploadActionForm
{
	private List<FileUploadDTO> listOfFiles;
	private HashMap<String, FileUploadField> listOfFields;

	private List<FileUploadProcessingConfig> fileUploadOptions;
	
	
//	public static class ImageInfo
//	{
//	     private int width;
//	     private int height;
//
//	     private InputStream inputStream;
//	     
//	     public ImageInfo(InputStream is, int w, int h)
//	     {
//	    	 width = w;
//	    	 height = h;
//	    	 
//	    	 inputStream = is;
//	     }
//
//		public int getWidth()
//		{
//			return width;
//		}
//
//		public int getHeight()
//		{
//			return height;
//		}
//
//		public InputStream getInputStream()
//		{
//			return inputStream;
//		}
//	     	     
//	}
	
	public List<FileUploadProcessingConfig> getListOfFileUploadProcessingConfig()
	{
	    return fileUploadOptions;	
	}

	public void addFileUploadProcessingConfig(FileUploadProcessingConfig anOption)
	{
		if (fileUploadOptions == null)
			fileUploadOptions = new ArrayList<FileUploadProcessingConfig>();
		
	    fileUploadOptions.add(anOption);	
	}

	public void removeFileUploadProcessingConfigByClass(ConfigParamClass anOptionClass)
	{
		if (fileUploadOptions != null && fileUploadOptions.size() > 0)
		{
			for(int i = 0; i < fileUploadOptions.size(); i++)
			{
				if (fileUploadOptions.get(i).getOptionClass() == anOptionClass)
				{
					fileUploadOptions.remove(i);
					return ;
				}
			}
		}
				
	}

	public FileUploadActionForm()
	{
		listOfFields = null;
		listOfFiles = null;
	}

	public void init(MultipartFormDataInput multipartFormDataInput, String filePartName, FileUploadDTOFactory dtoFactory, boolean forceUtf8Encoding) throws Exception
	{
		fileUploadOptions = null;
				
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
                
				FileUploadDTO fileInfo = dtoFactory.newFileUploadDTOInstance(contentType, listOfFields);				
				fileInfo.setUploadFileName(originalFileName);
				fileInfo.setContentType(contentType);
				fileInfo.setFileInputStream(this.getInputPartInputStream(inputPart, forceUtf8Encoding));
									
				add(fileInfo);
			}
		}
	}
	
//	protected FileUploadDTO newFileUploadDTOInstance(String aContentType)
//	{
//		FileUploadDTO fileInfo = null;
//		if (ContentTypeUtil.isInternetImage(aContentType))
//		{
//			 fileInfo = new ImageUploadDTO();
//		}
//		else fileInfo = new FileUploadDTO();
//
//		return fileInfo;
//	}
	
	public void setFileUploadOptions(List<FileUploadProcessingConfig> opts)
	{
	     fileUploadOptions = opts;	
	}
	
//	public void setImageOptions(String anImageClass)
//	{		
//		removeFileUploadProcessingConfigByClass(ConfigParamClass.image);
//	    
//		if (anImageClass == null || anImageClass.trim().length() == 0)
//	    	return;
//	    
//		ClassifierItemLUT clsLut = (ClassifierItemLUT)LUTManager.getLUTManager().getLUT(LUTName.cms_imgclass);
//		ClassifierItemDTO clsLutDTO = clsLut.getItem(anImageClass);
//		if (clsLutDTO != null && clsLutDTO.getClassifieritemsattr() != null)
//		{
//			addFileUploadProcessingConfig(new FileUploadProcessingImageConfig(ConfigParamClass.image, anImageClass, clsLutDTO.getClassifieritemsattr()));
//		}								
//	}
//
//	public void setIconOptions(String anIconClass)
//	{
//		removeFileUploadProcessingConfigByClass(ConfigParamClass.icon);
//		
//	    if (anIconClass == null || anIconClass.trim().length() == 0)
//	    	return;
//
//		ClassifierItemLUT clsLut = (ClassifierItemLUT)LUTManager.getLUTManager().getLUT(LUTName.cms_iconclass);
//		ClassifierItemDTO clsLutDTO = clsLut.getItem(anIconClass);
//		if (clsLutDTO != null && clsLutDTO.getClassifieritemsattr() != null)
//		{
//			addFileUploadProcessingConfig(new FileUploadProcessingImageConfig(ConfigParamClass.icon, anIconClass, clsLutDTO.getClassifieritemsattr()));
//		}								
//	}
	
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
		return listOfFields.values();
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
				        				
				FileUploadField p = new FileUploadField(fieldName, fieldValue);
				return p;
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

}
