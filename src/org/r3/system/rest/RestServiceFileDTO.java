package org.r3.system.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestServiceFileDTO
{
	public static class ArrayOfRestServiceFileDTO
	{
		private List<RestServiceFileDTO> files;

		public ArrayOfRestServiceFileDTO()
		{
		     files = null;	
		}
		
		public List<RestServiceFileDTO> getFiles()
		{
			return files;
		}
					
		public void addRestServiceFileDTO(RestServiceFileDTO aDto)
		{
			if (files == null)
				files = new ArrayList<RestServiceFileDTO>();
			
			files.add(aDto);
		}
		
		public RestServiceFileDTO getRestServiceFileDTOByIndex(int anIndex)
		{
			if (files == null || anIndex >= files.size())
				return null;
			
			return files.get(anIndex);
		}
	}	
	
	private String fileId;

	private String fileName;

	private long size;

	private String contentType;

	private String fileurl;
	private String deleteUrl;

	private boolean validFlag;
	private String errorReason;

	public String getFileId()
	{
		return fileId;
	}

	public void setFileId(String fileId)
	{
		this.fileId = fileId;
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
}
