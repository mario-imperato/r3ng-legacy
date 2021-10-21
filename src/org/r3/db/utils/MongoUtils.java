package org.r3.db.utils;

import org.bson.types.ObjectId;

public class MongoUtils
{

	public MongoUtils()
	{
		// TODO Auto-generated constructor stub
	}

	public static ObjectId getObjectIdFromString(String hex)
	{
		ObjectId o = new ObjectId(hex);
		return o;
	}
}
