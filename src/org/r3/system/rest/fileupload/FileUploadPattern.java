package org.r3.system.rest.fileupload;


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
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;


public abstract class FileUploadPattern extends ServicePattern
{
	// Nel caso di IE non posso tornare application/json come content-type in quanto IE non supporta un sacco di cose
	// tra le quali l'upload dei file e quindi viene fatto con una hidden frame che poi viene parsata.... nu'bburdello.
	// Per IE debbo restituire un contenuto corretto come JSON ma marcarlo text/plain. In questi casi ho infatti una
	// doppia invocazione che viene decisa lato client.. Ci sarebbe anche un meccanismo per uniformare (ovvero
	// forzando tutti ad andare come IE..... 
    private boolean ieFlag = false;
    
	private FileUploadActionForm actionForm;
	// MultipartFormDataInput multipartFormDataInput;
	
	public static class ArrayOfFileUploadDTO
	{
		private List<FileUploadDTO> files;

		public ArrayOfFileUploadDTO(List<FileUploadDTO> aListOfFiles)
		{
		     files = aListOfFiles;	
		}
		
		public List<FileUploadDTO> getFiles()
		{
			return files;
		}
				
	}
	

	public FileUploadPattern(ServletContext ctx, ServiceEnvironment serviceEnvironment, MultipartFormDataInput input, String filePartName, FileUploadDTOFactory dtoFactory, boolean forceUtf8Encoding)
	{
		this(ctx, serviceEnvironment, input, filePartName, dtoFactory, forceUtf8Encoding, false);
	}

	public FileUploadPattern(ServletContext ctx, ServiceEnvironment serviceEnvironment, MultipartFormDataInput input, String filePartName, FileUploadDTOFactory dtoFactory, boolean forceUtf8Encoding, boolean isIEFlag)
	{
		super(ctx, serviceEnvironment);
				
		try
		{
			actionForm = newFileUploadActionFormInstance();
			actionForm.init(input, filePartName, dtoFactory, forceUtf8Encoding);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			actionForm = null;
		}
		
		ieFlag = isIEFlag;
	}

	public boolean isIE()
	{
		return this.ieFlag;
	}
		
	protected FileUploadActionForm newFileUploadActionFormInstance()
	{
	    return  new FileUploadActionForm();
	}
	
	protected FileUploadActionForm getFileUploadActionForm()
	{
	    return actionForm;
	}
	
//	protected List<FileUploadDTO> storeInputParts(DMSContext aDmsContext, DMSFolder dmsFolder, String filePartName, boolean generateFileName, boolean forceUtf8Encoding) throws DMSException
//	{
//		List<FileUploadDTO> resultList = this.actionForm.getFiles();
//		for(FileUploadDTO f : resultList)
//		{
//			storeFile(aDmsContext, dmsFolder, f, generateFileName);
//		}
//		
//		return resultList;
//	}
	
	protected FileUploadDTO storeFile(DMSContext aDmsContext, DMSFolder dmsFolder, FileUploadDTO fileInfo, boolean generateFileName) throws DMSException
	{
		try
		{
			fileInfo.addListOfFileUploadProcessingConfig(actionForm.getListOfFileUploadProcessingConfig());
		    fileInfo.applyUploadOptions();
			
			String overrideFileName = null;
			if (generateFileName)
			{
				overrideFileName = aDmsContext.generateFileId(); 
			}
			
			DMSFileMetadata theFileMetadata = null;
			DMSFile theFile = null;

			InputStream is = fileInfo.getFileInputStream();
			is.reset();
			
			theFileMetadata = fileInfo.getFileMetadata(overrideFileName, false);												
			theFile = dmsFolder.addFile(aDmsContext, is, theFileMetadata, DMSFolderAddFileMode.NEWNAMEIFPRESENT);

			fileInfo.setFileName(theFileMetadata.getFileName());
			fileInfo.setFileurl(theFile.getFileUrl().getUrl());			

			if (fileInfo.isImage())
			{
				((ImageUploadDTO)fileInfo).setImageurl(theFile.getFileUrl().getUrl());
				
				InputStream iconInputStream = fileInfo.getIconInputStream();
				if (iconInputStream != null)
				{
					theFileMetadata = fileInfo.getFileMetadata(overrideFileName, true);												
					theFile = dmsFolder.addFile(aDmsContext, iconInputStream, theFileMetadata, DMSFolderAddFileMode.NEWNAMEIFPRESENT);
					
					((ImageUploadDTO)fileInfo).setIconurl(theFile.getFileUrl().getUrl());
				}
			}
			
			// testThumbnailator(inputStream);			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new DMSException(e.getMessage());
		}

		return fileInfo;
	}


	
//    protected void p(InputPart inputPart)
//    {
//		File f = new File("C:/tmp/UNEP/myFile.xml");
//		PrintWriter prt = null;
//		BufferedReader reader = null;
//		try
//		{
//			
//			byte[] fileBytes = readByteArray(inputPart);
//            reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(fileBytes), "UTF-8"));
//            prt = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
//            String line = reader.readLine();
//            while(line != null)
//            {
//            	prt.println(line);
//            	line = reader.readLine();
//            }
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			SystemUtils.close(reader);
//			SystemUtils.close(prt);
//		}
//    }

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
	
	
//	private void testThumbnailator(InputStream is)
//	{
//		try
//		{
//			is.reset();
//			
//			InputStreamImageSource imageSource = new InputStreamImageSource(is);
//			
//			BufferedImage bf = imageSource.read();
//			
//			System.out.printf("Image: %d, %d\n", bf.getWidth(), bf.getHeight());
//			
//			Thumbnails.of(bf).size(300, 300)
//			  .toFile("c:/tmp/regattacubed/thumb.jpg");
//						
//						
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		
//	}
}
