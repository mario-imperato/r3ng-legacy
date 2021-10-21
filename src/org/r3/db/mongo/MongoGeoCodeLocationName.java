package org.r3.db.mongo;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class MongoGeoCodeLocationName
{
	public static final String LOCATIONID = "locationid";
	
	private String locationid;
    private String name;
    private String sname;
    
	public MongoGeoCodeLocationName()
	{
	}

	public String getLocationid()
	{
		return locationid;
	}

	public void setLocationid(String locationId)
	{
		this.locationid = locationId;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String aName)
	{
		int ndx = aName.indexOf('#');
		if (ndx < 0)
		{
		    name = aName;
		}
		else
		{
		    setSname(aName.substring(0, ndx));
		    name = aName.substring(ndx + 1);
		}		
	}

	public String getSname()
	{
		return sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}
	
}
