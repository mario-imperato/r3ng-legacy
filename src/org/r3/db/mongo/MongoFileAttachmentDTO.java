package org.r3.db.mongo;

import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.utils.DataTableAdapter;

public class MongoFileAttachmentDTO 
{
	public MongoFileAttachmentDTO()
	{
	}

	private String fileid;

	public String getFileid()
	{
		return fileid;
	}

	public void setFileid(org.bson.types.ObjectId p)
	{
		fileid = p.toHexString();
	}

	public void setFileid(java.lang.String p)
	{
		fileid = p;
	}

	//
	private java.lang.String url;

	public java.lang.String getUrl()
	{
		return url;
	}

	public void setUrl(java.lang.String p)
	{
		url = p;
	}

	//
	private java.lang.String ctype;

	public java.lang.String getCtype()
	{
		return ctype;
	}

	public void setCtype(java.lang.String p)
	{
		ctype = p;
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

	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	private String attachmenttype;

	public String getAttachmenttype()
	{
		return attachmenttype;
	}

	public void setAttachmentType(String anAttachmentType)
	{
		this.attachmenttype = anAttachmentType;
	}

	private MongoImageDTO fileIcon;
		
	public MongoImageDTO getFileIcon()
	{
		return fileIcon;
	}

	public void setFileIcon(MongoImageDTO fileIcon)
	{
		this.fileIcon = fileIcon;
	}

	private long size;
		
	public long getSize()
	{
		return size;
	}

	public void setSize(long size)
	{
		this.size = size;
	}

	public static class MongoFileAttachmentDataTableAdapter extends DataTableAdapter
	{
		public MongoFileAttachmentDataTableAdapter(java.util.List<MongoFileAttachmentDTO> l, String asEcho)
		{
			setsEcho(asEcho);

			if (l != null)
				setiTotalRecords(l.size());
			else
				setiTotalRecords(0);

			if (l != null)
				setiTotalDisplayRecords(l.size());
			else
				setiTotalDisplayRecords(0);

			setAaData(l);
		}

		private java.util.List<MongoFileAttachmentDTO> aaData;

		@javax.xml.bind.annotation.XmlElement(name = "aaData")
		public java.util.List<MongoFileAttachmentDTO> getAaData()
		{
			return aaData;
		}

		public void setAaData(java.util.List<MongoFileAttachmentDTO> aaData)
		{
			this.aaData = aaData;
		}
	}

	public MongoFileAttachmentDTO populate(FileCollectionDTO r0, FileCollectionDTO r0Icon)
	{
		setFileid(r0.getFileid().toHexString());
		setUrl(r0.getUrl());
		setWidth(r0.getWidth());
		setHeight(r0.getHeight());
		setName(r0.getName());
		setCtype(r0.getContenttype());
		setAttachmentType(r0.getMinorrole());
		setSize(r0.getSize());
		
		if (r0Icon != null)
		{
		MongoImageDTO fileIcon = (new MongoImageDTO()).populate(r0Icon);
		setFileIcon(fileIcon);
		}
		
		return this;
	}
}