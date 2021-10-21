package org.r3.system.rest.fileinput;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.r3.db.dms.model.DMSFileMetadata;
import org.r3.system.util.ContentTypeUtil;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.tasks.io.InputStreamImageSource;

/**
 * @author Mario
 *
 */
public  class FileUploadDTO
{
	public enum FileUploadDTO_FileRole { image, icon, file, document }
	
	private String fileId;	
	private String fileName;
	private String fileurl;
	private String deleteUrl;
	private int imageWidth;
	private int imageHeight;
	
	public String getFileId()
	{
		return fileId;
	}

	public void setFileId(String fileId)
	{
		this.fileId = fileId;
	}

	// Funzionale al plugin js fileupload.
	public String getName()
	{
		return fileName;
	}
	
	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileurl()
	{
		return fileurl;
	}

	public void setFileurl(String fileurl)
	{
		this.fileurl = fileurl;
	}

	public String getDeleteUrl()
	{
		return deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl)
	{
		this.deleteUrl = deleteUrl;
	}

	protected FileUploadDTO_FileRole fileMajorRole;
	protected String fileMinorRole;
	
	protected List<FileUploadDTO> derivedFiles = null;
	
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public FileUploadDTO_FileRole getFileMajorRole()
	{
		return fileMajorRole;
	}

	public void setFileMajorRole(FileUploadDTO_FileRole fileMajorRole)
	{
		this.fileMajorRole = fileMajorRole;
	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public String getFileMinorRole()
	{
		return fileMinorRole;
	}

	public void setFileMinorRole(String fileMinorRole)
	{
		this.fileMinorRole = fileMinorRole;
	}

	private long size;
	
    private String contentType;
    private String uploadFileName;
    
//    private boolean validFlag;
//    
//    private String errorReason;
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    private InputStream fileInputStream;        
    	
    public FileUploadDTO()
    {
    	
    }        

    public FileUploadDTO(FileUploadDTO_FileRole aRole)
    {
    	fileMajorRole = aRole;
    }        
    
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public InputStream getFileInputStream()
	{
		return fileInputStream;
	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public byte[] getFileInputStreamAsByteArray() throws IOException
	{
    	if (fileInputStream != null)
    	{
    		fileInputStream.reset();
    		byte[] bytes = IOUtils.toByteArray(fileInputStream);
    		return bytes;    		
    	}
    	
    	return null;
	}    
    
    @com.fasterxml.jackson.annotation.JsonIgnore
	public void setFileInputStream(InputStream fileInputStream) throws IOException 
	{		
		if (fileMajorRole != null && fileMajorRole == FileUploadDTO_FileRole.image)
			setFileInputStream(fileInputStream, true);
		
		else setFileInputStream(fileInputStream, false);
	}
	
	public void setFileInputStream(InputStream fileInputStream, boolean computeImageSize) throws IOException
	{
		this.fileInputStream = fileInputStream;
		this.size = fileInputStream.available();
		if (computeImageSize)
			computeImageSize(fileInputStream);
	}
	
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public DMSFileMetadata getFileMetadata(String overrideFileName, boolean iconFlag)
	{
		DMSFileMetadata metadata = new DMSFileMetadata();

		String originalFileName = getUploadFileName();
		if (overrideFileName != null)
		{               
               if (ContentTypeUtil.findExtension(overrideFileName) == null)
               {
            	   String ext  = ContentTypeUtil.findExtension(originalFileName);   
            	   StringBuilder stb = new StringBuilder().append(overrideFileName);
            	   if (iconFlag)
            		   stb.append("_ico");
            	   
            	   stb.append('.').append(ext);
            	   overrideFileName = stb.toString();
               }
               
               metadata.setClientFileName(originalFileName);
               metadata.setFileName(overrideFileName);
		}
		else   metadata.setFileName(originalFileName);
		
		metadata.setContentType(this.getContentType());
		return metadata;
	}

	
	public String getUploadFileName()
	{
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}

	public void setSize(long size)
	{
		this.size = size;
	}

	public long getSize()
	{
		return size;
	}

	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public String getContentType()
	{
		return contentType;
	}
			    
	public boolean isImage()
	{
		return ContentTypeUtil.isInternetImage(contentType);
	}
		
		
	public void addDerivedFile(FileUploadDTO f)
	{
	    if (derivedFiles == null)
	    	derivedFiles = new ArrayList<FileUploadDTO>();
	    
	    derivedFiles.add(f);
	}
	
	public List<FileUploadDTO> getDerivedFiles()
	{
		return derivedFiles;
	}
	
	public boolean isResizeRequired(int maxWidth, int maxHeight)
	{
		return maxWidth > 0 && maxHeight > 0 && (this.imageWidth > maxWidth || this.imageHeight > maxHeight);
	}
	
	public void scale(int maxWidth, int maxHeight) throws IOException
	{
		InputStream uploadInputStream = getFileInputStream();

		int uploadWidth = imageWidth;
		int uploadHeight = imageHeight;
        				
		if (isResizeRequired(maxWidth, maxHeight))
		{
			float scale = getScalingRatio(uploadWidth, maxWidth, uploadHeight, maxHeight);
			
			uploadInputStream.reset();

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			Thumbnails.of(uploadInputStream).size(maxWidth, maxHeight).toOutputStream(os);

			ByteArrayInputStream bis = new ByteArrayInputStream(os.toByteArray());
			setFileInputStream(bis);
			imageWidth = Math.round(uploadWidth * scale);
			imageHeight = Math.round(uploadHeight * scale);
		}
	}
	
	public FileUploadDTO getIcon(int maxWidth, int maxHeight) throws IOException
	{
		InputStream uploadInputStream = getFileInputStream();
		
		int uploadWidth = imageWidth;
		int uploadHeight = imageHeight;
		
        // L'icona non viene generata in caso di no-resize...
		if (isResizeRequired(maxWidth, maxHeight))
		{
			float scale = getScalingRatio(uploadWidth, maxWidth, uploadHeight, maxHeight);
			
			uploadInputStream.reset();

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			Thumbnails.of(uploadInputStream).size(maxWidth, maxHeight).toOutputStream(os);

			ByteArrayInputStream bis = new ByteArrayInputStream(os.toByteArray());
			
			FileUploadDTO iconDTO = new FileUploadDTO(FileUploadDTO_FileRole.image);
			iconDTO.setUploadFileName(getUploadFileName());
			iconDTO.setContentType(getContentType());
			
			iconDTO.setFileInputStream(bis, false);
			iconDTO.setImageWidth(Math.round(uploadWidth * scale));
			iconDTO.setImageHeight(Math.round(uploadHeight * scale));
			
			return iconDTO;
		}
		
		return null;		
	}
	
	private float getScalingRatio(int currentWidth, int maxWidth, int currentHeight, int maxHeight)
	{
		float wr = (float)maxWidth / currentWidth;
		float hr = (float)maxHeight / currentHeight;
		
		return Math.min(wr,  hr);
	}

	public int getImageWidth()
	{
		return imageWidth;
	}

	public void setImageWidth(int imageWidth)
	{
		this.imageWidth = imageWidth;
	}

	public int getImageHeight()
	{
		return imageHeight;
	}

	public void setImageHeight(int imageHeight)
	{
		this.imageHeight = imageHeight;
	}

	private void computeImageSize(InputStream is) throws IOException
	{
		InputStreamImageSource imageSource = new InputStreamImageSource(is);

		BufferedImage bf = imageSource.read();
		imageWidth = bf.getWidth();
		imageHeight = bf.getHeight();		
	}


}
