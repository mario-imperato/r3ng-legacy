package org.r3.db.mongo;

import org.r3.db.utils.DataTableAdapter;

public class MongoLinkDTO
{

	public MongoLinkDTO()
	{
		// TODO Auto-generated constructor stub
	}

  	private String  linkid;
  
  	public String   getLinkid()         
  	{ 
  		return linkid; 
  	}

  	public void setLinkid(org.bson.types.ObjectId  p)         
  	{ 
  		linkid = p.toHexString(); 
  	}

  	public void setLinkid(java.lang.String  p)         
  	{ 
  		linkid = p; 
  	}
  	
	private String refattachmentid;
	
	public String getRefattachmentid()
	{
		return refattachmentid;
	}

	public void setRefattachmentid(String aRefAttachmentId)
	{
		this.refattachmentid = aRefAttachmentId;
	}
	
	//
	private java.lang.String href;

	public java.lang.String getHref()
	{
		return href;
	}

	public void setHref(java.lang.String p)
	{
		href = p;
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

	private String linktype;
	
	public String getLinktype()
	{
		return linktype;
	}



	public void setLinktype(String attachmentType)
	{
		this.linktype = attachmentType;
	}
	
	public static class MongoLinkDataTableAdapter extends DataTableAdapter
	{
		public MongoLinkDataTableAdapter(java.util.List<MongoLinkDTO> l, String asEcho)
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

		private java.util.List<MongoLinkDTO> aaData;

		@javax.xml.bind.annotation.XmlElement(name = "aaData")
		public java.util.List<MongoLinkDTO> getAaData()
		{
			return aaData;
		}

		public void setAaData(java.util.List<MongoLinkDTO> aaData)
		{
			this.aaData = aaData;
		}
	}	
}

