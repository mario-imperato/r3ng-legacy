//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.timelinecollection;

import org.mongodb.morphia.annotations.Entity;
import org.r3.db.MongoDbSchemaInfo;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbTimelineCollectionName = "r3_timelinecollection";
 */
@Entity(value = MongoDbSchemaInfo.MongoDbTimelineCollectionName, noClassnameStored = true)
public class TimelineCollectionDTO extends TimelineCollectionDTOBase
{
	public TimelineCollectionDTO()
	{
		super();
	}

	public java.lang.String getDtokey()
	{
		return timelineid.toString();
	}

	public java.lang.String getDtodescr()
	{
		return title;
	}
}
