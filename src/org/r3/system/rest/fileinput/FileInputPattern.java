package org.r3.system.rest.fileinput;


import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.r3.db.dms.model.DMSContext;
import org.r3.db.dms.model.DMSException;
import org.r3.db.dms.model.DMSFile;
import org.r3.db.dms.model.DMSFileMetadata;
import org.r3.db.dms.model.DMSFolder;
import org.r3.db.dms.model.SimpleDMSConstants.DMSFolderAddFileMode;
import org.r3.db.system.lut.ILUTItem;
import org.r3.db.system.lut.LUT;
import org.r3.db.system.lut.LUTManager;
import org.r3.db.system.lut.LUTManager.LUTName;
import org.r3.system.rest.RestServiceFileDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;
import org.r3.ws.mongocms.filecollection.FileUpload_POST.ResponseType;


public abstract class FileInputPattern extends ServicePattern
{
	// Nel caso di IE non posso tornare application/json come content-type in quanto IE non supporta un sacco di cose
	// tra le quali l'upload dei file e quindi viene fatto con una hidden frame che poi viene parsata.... nu'bburdello.
	// Per IE debbo restituire un contenuto corretto come JSON ma marcarlo text/plain. In questi casi ho infatti una
	// doppia invocazione che viene decisa lato client.. Ci sarebbe anche un meccanismo per uniformare (ovvero
	// forzando tutti ad andare come IE..... 
    private boolean ieFlag = false;
    private ResponseType responseType;
    
	private FileUploadActionForm actionForm;
	// MultipartFormDataInput multipartFormDataInput;
	
	public static class ArrayOfFileUploadDTO
	{
		private List<FileUploadDTO> files;
				
		public ArrayOfFileUploadDTO()
		{		     	
		}
		
		public ArrayOfFileUploadDTO(List<FileUploadDTO> aListOfFiles)
		{
			 files = aListOfFiles;	
		}
		
		public void setFiles(List<FileUploadDTO> aListOfFiles)
		{
			 files = aListOfFiles;	
		}
		
		public List<FileUploadDTO> getFiles()
		{
			return files;
		}				
	}
	
	public static class CKEditorOfFileUploadDTO
	{
		private String message;
		private int uploaded;
		private String fileName;
		private String url;
		    	
		public CKEditorOfFileUploadDTO(String aFileName, String aUrl)
		{
			fileName = aFileName;
			url = aUrl;
			uploaded = 1;
		}
		
		public String getMessage()
		{
			return message;
		}

		public int getUploaded()
		{
			return uploaded;
		}

		public String getFileName()
		{
			return fileName;
		}

		public String getUrl()
		{
			return url;
		}			
		
		
	}
	
	

	public FileInputPattern(ServletContext ctx, ServiceEnvironment serviceEnvironment, MultipartFormDataInput input, String filePartName, FileUploadDTOFactory dtoFactory, boolean forceUtf8Encoding)
	{
		this(ctx, serviceEnvironment, input, filePartName, dtoFactory, forceUtf8Encoding, null, null);
	}

	public FileInputPattern(ServletContext ctx, ServiceEnvironment serviceEnvironment, MultipartFormDataInput input, String filePartName, FileUploadDTOFactory dtoFactory, boolean forceUtf8Encoding, String anAttachmentType, ResponseType aResponseType)
	{
		super(ctx, serviceEnvironment);
				
		try
		{
			actionForm = new FileUploadActionForm();
			actionForm.init(input, filePartName, dtoFactory, forceUtf8Encoding, anAttachmentType);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			actionForm = null;
		}
		
		ieFlag = false;
		responseType = aResponseType;
	}

	public boolean isIE()
	{
		return this.ieFlag;
	}
			
	public ResponseType getResponseType()
	{
		return responseType;
	}
	
	protected FileUploadActionForm getFileUploadActionForm()
	{
	    return actionForm;
	}
	
	protected RestServiceFileDTO storeFile(DMSContext aDmsContext, DMSFolder dmsFolder, FileUploadDTO fileInfo, boolean generateFileName) throws DMSException
	{
		RestServiceFileDTO outInfo = new RestServiceFileDTO();
		outInfo.setContentType(fileInfo.getContentType());
		outInfo.setSize(fileInfo.getSize());
		
		try
		{			
			String overrideFileName = null;
			if (generateFileName)
			{
				overrideFileName = aDmsContext.generateFileId(); 
				outInfo.setFileId(overrideFileName);
			}
			
			DMSFileMetadata theFileMetadata = null;
			DMSFile theFile = null;

			InputStream is = fileInfo.getFileInputStream();
			is.reset();
			
			theFileMetadata = fileInfo.getFileMetadata(overrideFileName, false);												
			theFile = dmsFolder.addFile(aDmsContext, is, theFileMetadata, DMSFolderAddFileMode.NEWNAMEIFPRESENT);

			outInfo.setFileName(theFileMetadata.getFileName());
			outInfo.setFileurl(theFile.getFileUrl().getUrl());			

//			if (fileInfo.isImage())
//			{
//				((ImageUploadDTO)fileInfo).setImageurl(theFile.getFileUrl().getUrl());
//				
//				InputStream iconInputStream = fileInfo.getIconInputStream();
//				if (iconInputStream != null)
//				{
//					theFileMetadata = fileInfo.getFileMetadata(overrideFileName, true);												
//					theFile = dmsFolder.addFile(aDmsContext, iconInputStream, theFileMetadata, DMSFolderAddFileMode.NEWNAMEIFPRESENT);
//					
//					((ImageUploadDTO)fileInfo).setIconurl(theFile.getFileUrl().getUrl());
//				}
//			}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new DMSException(e.getMessage());
		}

		outInfo.setValid(true);
		return outInfo;
	}	

	protected String serializeFiles(List<FileUploadDTO> files)
	{
		String s = "";
		if (files != null && files.size() > 0)
		{
			StringBuilder stb = new StringBuilder();
			stb.append("[");
			
			boolean isFirst = true;
			for(FileUploadDTO aDto : files)
			{
				if (!isFirst)
					stb.append(",");
				
				stb.append(aDto.toString());
			}
			stb.append("]");
			
			return stb.toString();
		}
		
		return s;
	}
	
	public ILUTItem retrieveLUTItem(String aSite, String fieldName, LUTName aLutName, String lookupKey)
	{
		FileUploadField uploadField = actionForm.getField(fieldName);

		if (uploadField == null && (lookupKey == null || lookupKey.trim().length() == 0))
		{
			return null;
		}

		if (uploadField != null)
			lookupKey = uploadField.getValue();

		LUT aLUT = LUTManager.getLUTManager().getLUT(aLutName, null);
		ILUTItem lutItem = null;

		try
		{
			if (lookupKey.startsWith(aSite))
				lutItem = aLUT.getInstance().getItem(lookupKey);
			else
				lutItem = aLUT.getInstance().getItem4Site(aSite, lookupKey);
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		return lutItem;
	}
	
}
