//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.filecollection;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.r3.db.MongoDbSchemaInfo;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbFileCollectionName = "r3_filecollection";
 */
@Entity(value = MongoDbSchemaInfo.MongoDbFileCollectionName, noClassnameStored = true)
public class FileCollectionDTO extends FileCollectionDTOBase
{
	@Embedded("exiftags")
	private List<ExifTag> exifData = null;
	
	public enum MajorRole  { image, icon, file, document }
	public enum FileStatus { 
		
		pending, permanent;
		
		public static FileStatus getValue4(String s, FileStatus defaultStatus)
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
	
	public FileCollectionDTO()
	{
		super();
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
	
	public String getUrl()
	{
		String s = String.format(MongoDbSchemaInfo.MongoDbFileStoreUrlPattern, getSite(), getLanguage(), MongoDbSchemaInfo.MongoDbName, MongoDbSchemaInfo.MongoDbFileStoreCollectionName, getFileid().toString());		
		return s;
	}
	
	public String getRestUrl()
	{
		return FileCollectionUrl.getRestUrl(getSite(), getLanguage(), getUrl());
	}
	
}
