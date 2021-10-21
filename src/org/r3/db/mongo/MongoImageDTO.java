package org.r3.db.mongo;

import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.utils.DataTableAdapter;


public class MongoImageDTO
{
	public enum MongoImageRole 
	{ 
		image, icon
		;
		
	    public static MongoImageRole getValue4(String s, MongoImageRole defaultValue)
	    {
	    	if (s != null && s.length() > 0)
	    	{
	    		try
	    		{
	    			return MongoImageRole.valueOf(s);
	    		}
	    		catch(Exception exc)
	    		{
	    			exc.printStackTrace();
	    		}
	    	}
	    	
	    	return defaultValue;
	    }
	};
	
	public MongoImageDTO()
	{
	}

  	private String  imageid;
  
  	public String   getImageid()         
  	{ 
  		return imageid; 
  	}

  	public void setImageid(java.lang.String  p)         
  	{ 
  		imageid = p; 
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

	//
	private java.lang.String majorRole;

	public java.lang.String getMajorRole()
	{
		return majorRole;
	}

	public void setMajorRole(java.lang.String p)
	{
		majorRole = p;
	}

	//
	private java.lang.String minorRole;

	public java.lang.String getMinorRole()
	{
		return minorRole;
	}

	public void setMinorRole(java.lang.String p)
	{
		minorRole = p;
	}
	
	public boolean isOfRole(MongoImageRole aMajorRole, String aMinorRole)
	{
		return 
			minorRole != null && aMinorRole != null && aMinorRole.equalsIgnoreCase(minorRole) &&
			majorRole != null && aMajorRole != null && getMajorRole().equalsIgnoreCase(aMajorRole.toString())
		;
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
	
	private long size;
	
	public long getSize()
	{
		return size;
	}

	public void setSize(long size)
	{
		this.size = size;
	}
	
	public static class MongoImageDataTableAdapter extends DataTableAdapter
	{
		public MongoImageDataTableAdapter(java.util.List<MongoImageDTO> l, String asEcho)
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

		private java.util.List<MongoImageDTO> aaData;

		@javax.xml.bind.annotation.XmlElement(name = "aaData")
		public java.util.List<MongoImageDTO> getAaData()
		{
			return aaData;
		}

		public void setAaData(java.util.List<MongoImageDTO> aaData)
		{
			this.aaData = aaData;
		}
	}

	public MongoImageDTO populate(FileCollectionDTO r0Icon)
	{
		setImageid(r0Icon.getFileid().toHexString());
		setUrl(r0Icon.getUrl());
		setWidth(r0Icon.getWidth());
		setHeight(r0Icon.getHeight());
		setName(r0Icon.getName());
		setCtype(r0Icon.getContenttype());
		setMajorRole(r0Icon.getMajorrole());
		setMinorRole(r0Icon.getMinorrole());
		setSize(r0Icon.getSize());
		return this;
	}		
}