package org.r3.db.mongo.filecollection;

public class ExifTag
{
     private String tagname;
     private String tagvalue;
     
     public ExifTag(String n, String v)
     {
    	 tagname = n; tagvalue = v;
     }

	public String getTagname()
	{
		return tagname;
	}

	public String getTagvalue()
	{
		return tagvalue;
	}
     
     
}
