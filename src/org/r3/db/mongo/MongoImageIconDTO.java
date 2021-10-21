package org.r3.db.mongo;


import org.r3.db.mongo.filecollection.FileCollectionDTO;
import org.r3.db.utils.DataTableAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MongoImageIconDTO
{

	public MongoImageIconDTO()
	{
		// TODO Auto-generated constructor stub
	}

	private String imageiconid;
	private String imagerole;
	private MongoImageDTO image;
	private MongoImageDTO icon;
		
	public String getImageiconid()
	{
		return imageiconid;
	}
	
	public void setImageiconid(String imageiconid)
	{
		this.imageiconid = imageiconid;
	}
	
	public String getImagerole()
	{
		return imagerole;
	}

	public void setImagerole(String imagerole)
	{
		this.imagerole = imagerole;
	}

	public MongoImageDTO getImage()
	{
		return image;
	}
	
	public void setImage(MongoImageDTO image)
	{
		this.image = image;
	}
	
	public MongoImageDTO getIcon()
	{
		return icon;
	}
	
	public void setIcon(MongoImageDTO icon)
	{
		this.icon = icon;
	}

	public boolean isOfRole(String aMinorRole)
	{
		return 
				imagerole != null && aMinorRole != null && aMinorRole.equalsIgnoreCase(imagerole);
			
	}
	
	public MongoImageIconDTO populate(FileCollectionDTO r0, FileCollectionDTO r0Icon)
	{
		setImagerole(r0.getMinorrole());
		setImageiconid(r0.getFileid().toHexString());
		
		MongoImageDTO fileImage = (new MongoImageDTO()).populate(r0);
		setImage(fileImage);
		
		if (r0Icon != null)
		{
		MongoImageDTO fileIcon = (new MongoImageDTO()).populate(r0Icon);
		setIcon(fileIcon);
		}
		
		return this;
	}
	
	public static MongoImageIconDTO newInstanceFromJSONString(String aJsonObject)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try
		{
			MongoImageIconDTO o = objectMapper.readValue(aJsonObject, MongoImageIconDTO.class);
			return o;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static class MongoImageIconDataTableAdapter extends DataTableAdapter
	{
		public MongoImageIconDataTableAdapter(java.util.List<MongoImageIconDTO> l, String asEcho)
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

		private java.util.List<MongoImageIconDTO> aaData;

		@javax.xml.bind.annotation.XmlElement(name = "aaData")
		public java.util.List<MongoImageIconDTO> getAaData()
		{
			return aaData;
		}

		public void setAaData(java.util.List<MongoImageIconDTO> aaData)
		{
			this.aaData = aaData;
		}
	}			
}
