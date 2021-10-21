package org.r3.system.storage;

import java.util.ArrayList;
import java.util.List;

import org.r3.db.mongo.filecollection.ExifTag;

public abstract class StorageObject
{
	private List<ExifTag> exifData = null;
	
	public enum MajorRole  { image, icon, file, document }
	public enum ObjectStatus { 
		
		pending, permanent;
		
		public static ObjectStatus getValue4(String s, ObjectStatus defaultStatus)
		{
			if (s != null && s.trim().length() > 0)
			{
				try
				{
					return valueOf(s);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			return defaultStatus;
		}
	}

	public StorageObject()
	{

	}

	private String fileid;

	public String getObjectid()
	{
		return fileid;
	}

	public void setObjectid(String p)
	{
		fileid = p;
	}

	//
	private int width;

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int p)
	{
		width = p;
	}

	//
	private int height;

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int p)
	{
		height = p;
	}

	//
	private java.lang.String masterfile;

	public java.lang.String getMasterfile()
	{
		return masterfile;
	}

	public void setMasterfile(java.lang.String p)
	{
		masterfile = p;
	}

	//
	private java.lang.String name;

	public java.lang.String getName()
	{
		return name;
	}

	public void setName(java.lang.String p)
	{
		name = p;
	}

	//
	private java.lang.String contenttype;

	public java.lang.String getContenttype()
	{
		return contenttype;
	}

	public void setContenttype(java.lang.String p)
	{
		contenttype = p;
	}

	//
	private java.lang.String majorrole;

	public java.lang.String getMajorrole()
	{
		return majorrole;
	}

	public void setMajorrole(java.lang.String p)
	{
		majorrole = p;
	}

	//
	private java.lang.String minorrole;

	public java.lang.String getMinorrole()
	{
		return minorrole;
	}

	public void setMinorrole(java.lang.String p)
	{
		minorrole = p;
	}

	//
	private java.lang.String site;

	public java.lang.String getSite()
	{
		return site;
	}

	public void setSite(java.lang.String p)
	{
		site = p;
	}

	//
	private java.lang.String language;

	public java.lang.String getLanguage()
	{
		return language;
	}

	public void setLanguage(java.lang.String p)
	{
		language = p;
	}

	//
	private java.lang.String refambit;

	public java.lang.String getRefambit()
	{
		return refambit;
	}

	public void setRefambit(java.lang.String p)
	{
		refambit = p;
	}

	//
	private java.lang.String refsubambit;

	public java.lang.String getRefsubambit()
	{
		return refsubambit;
	}

	public void setRefsubambit(java.lang.String p)
	{
		refsubambit = p;
	}

	//
	private java.lang.String refmainentity;

	public java.lang.String getRefmainentity()
	{
		return refmainentity;
	}

	public void setRefmainentity(java.lang.String p)
	{
		refmainentity = p;
	}

	//
	private java.lang.String refsubentity;

	public java.lang.String getRefsubentity()
	{
		return refsubentity;
	}

	public void setRefsubentity(java.lang.String p)
	{
		refsubentity = p;
	}

	//
	private long size;

	public long getSize()
	{
		return size;
	}

	public void setSize(long p)
	{
		size = p;
	}

    private byte[] data;

	public byte[] getData()
	{
		return data;
	}

	public void setData(byte[] p)
	{
		data = p;
	}

	//
	private java.util.Date creationdate;

	public java.util.Date getCreationdate()
	{
		return creationdate;
	}

	public void setCreationdate(java.util.Date p)
	{
		creationdate = p;
	}

	//
	private java.lang.String status;

	public java.lang.String getStatus()
	{
		return status;
	}

	public void setStatus(java.lang.String p)
	{
		status = p;
	}

	public List<ExifTag> getExifData()
	{
		return exifData;
	}

	public void setExifData(List<ExifTag> exifData)
	{
		this.exifData = exifData;
	}

	public void addExifTag(ExifTag aTag)
	{
		if (exifData == null)
			exifData = new ArrayList<ExifTag>();
		
		this.exifData.add(aTag);
	}
	
	public abstract String getUrl();
	public abstract String getRestUrl();

}
