package org.r3.system.rest.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.r3.db.dms.model.DMSFileMetadata;
import org.r3.system.rest.fileupload.FileUploadProcessingConfig.ConfigParamClass;
import org.r3.system.util.ContentTypeUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mario
 *
 */
public  class FileUploadDTO
{
	private String fileId;
	
	private String fileName;
	private String fileurl;
	private String deleteUrl;
	private long size;
	
    private String contentType;
    private String uploadFileName;
    
    private boolean validFlag;
    
    private String errorReason;
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    private InputStream fileInputStream;
    
    private List<FileUploadProcessingConfig> listOfFileUploadProcessingConfig;
    
    public FileUploadDTO()
    {
    	
    }
        
    
	public String getFileId()
	{
		return fileId;
	}


	public void setFileId(String fileId)
	{
		this.fileId = fileId;
	}


	public List<FileUploadProcessingConfig> getListOfFileUploadProcessingConfig()
	{
		return listOfFileUploadProcessingConfig;
	}

	public void addListOfFileUploadProcessingConfig(List<FileUploadProcessingConfig> fileUploadOptions)
	{
		if (fileUploadOptions != null)
		{
		if (this.listOfFileUploadProcessingConfig == null)
			   this.listOfFileUploadProcessingConfig = fileUploadOptions;
		else   this.listOfFileUploadProcessingConfig.addAll(fileUploadOptions);
		}
	}

	public void addFileUploadProcessingConfig(FileUploadProcessingConfig fileUploadOption)
	{
		if (this.listOfFileUploadProcessingConfig == null)
			this.listOfFileUploadProcessingConfig = new ArrayList<FileUploadProcessingConfig>();
		
		this.listOfFileUploadProcessingConfig.add(fileUploadOption);
	}

	protected FileUploadProcessingConfig getFileUploadProcessingConfig(ConfigParamClass anOptionClass)
	{
	    if (this.listOfFileUploadProcessingConfig != null && this.listOfFileUploadProcessingConfig.size() > 0)
	    {
	    	for(FileUploadProcessingConfig opt : this.listOfFileUploadProcessingConfig)
	    	{
	    		if (opt.getOptionClass() == anOptionClass)
	    			return opt;
	    	}
	    }
	    
	    return null;
	}

//	public FileUploadDTO(String aFileName, String aClientFileName, String aContentType, long aFileSize, String aFileUrl)
//	{
//		fileName = aFileName;
//		size = aFileSize;
//		fileUrl  = aFileUrl;
//		contentType = aContentType;
//		clientFileName = aClientFileName;
//		setValid(false);
//	}

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
	public InputStream getFileInputStream()
	{
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) throws IOException 
	{
		this.fileInputStream = fileInputStream;
		this.size = fileInputStream.available();
	}

	public void applyUploadOptions() throws IOException
	{
	  	
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

	public String getName()
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

	public String getUrl()
	{
		return fileurl;
	}

	public void setDeleteUrl(String aUrl)
	{
	    deleteUrl = aUrl;	
	}
	
	public String getDeleteUrl()
	{
		return deleteUrl;
	}
			
	public String getDeleteType()
	{
		if (deleteUrl != null)
		    return "DELETE";
		
		return "";
	}
	
	
	public void setFileurl(String fileUrl)
	{
		this.fileurl = fileUrl;
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
		
	public String getImageurl()
	{
		return null;
	}

	public String getIconurl()
	{
		return null;
	}
	
	public int getImageWidth()
	{
		return 0;
	}

	public int getImageHeight()
	{
		return 0;
	}

	public InputStream getIconInputStream()
	{
		return null;
	}
	
	public int getIconWidth()
	{
		return 0;
	}

	public int getIconHeight()
	{
		return 0;
	}
	
	public String toString()
	{
		String s = null;	

		Map<String, Object> hashmap = new HashMap<String, Object>();
	    hashmap.put("name", getName());
	    hashmap.put("size", getSize());
	    hashmap.put("contentType", getContentType());
	    hashmap.put("fileurl", getFileurl());
	    hashmap.put("error", getError());
	    
	    if (getDeleteUrl() != null)
	    {
	    	hashmap.put("deleteUrl", getDeleteUrl());
	    	hashmap.put("deleteType", getDeleteType());
	    }
	    
	    ObjectMapper mapper = new ObjectMapper();
        try
		{
			s = mapper.writeValueAsString(hashmap);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	    
// 		Sostituzione del codice ad hoc con un Mapper generico.        
//		if (!isValid())
//		{
//			s = String.format("{\"name\":\"%s\",\"size\":%d,\"contentType\":\"%s\",\"fileurl\":\"%s\",\"error\":\"%s\"}", getName(), getSize(), getContentType(), getFileurl(), getError());	
//		}
//		else
//		{
//			s = String.format("{\"name\":\"%s\",\"size\":%d,\"contentType\":\"%s\",\"fileurl\":\"%s\",\"error\":null}", getName(), getSize(), getContentType(), getFileurl());					
//		}
		return s;			
	}
	
	public void setValid(boolean aFlag)
	{
		validFlag = aFlag;
	}
	
	public boolean isValid()
	{
		return validFlag;
	}
	

//	private String getJSONValid()
//	{
//		if (isValid())
//			return "\"server_error\"";
//		return "false";
//	}

	public void setError(String e)
	{
		errorReason = e;
	}

	public String getError()
	{
		if (!isValid())
		{
			if (errorReason != null)
				return errorReason;
			else
				return "server_error";
		}
						
		return null;
	}
	
}
