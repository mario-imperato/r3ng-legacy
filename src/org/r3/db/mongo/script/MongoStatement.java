package org.r3.db.mongo.script;


import org.bson.Document;
import org.r3.db.mongo.script.MongoDirective.MongoDirectiveType;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;


public class MongoStatement
{
	protected String hashSeparator = ";(EOH)";
	
    private String statement;
    private MongoDirectiveType type;
    private String collectionName;
    
    public MongoStatement(MongoDirective aDirective, String aStatement) throws Exception
    {    	
    	if (aDirective == null)
    	{
    		throw new Exception("Directive Cannot Be Null");
    	}
    	
    	statement = aStatement; // .replace('\n', ' ').replace('\r', ' ').trim();
    	type = aDirective.getType();
    	collectionName = aDirective.getParam();
    }
    
    public MongoDirectiveType getType()
    {
    	return type;
    }

	public int execute(MongoDatabase dataStore)
	{
		int numberOfAffectedRows = 0;

		if (statement != null && statement.length() > 0)
		{
			MongoCollection<Document> coll = null;
			Document d = null;
			Document d2 = null;
			
			switch (getType())
			{
			case insert:

				d = Document.parse(statement);
				coll = dataStore.getCollection(collectionName);
				coll.insertOne(d);
				
				numberOfAffectedRows = 1;
				break;
				
			case update:

				String q = getUpdateStetament_Query(statement);
				String u = getUpdateStetament_Update(statement);
				if (q != null && u != null)
				{
					d = Document.parse(q);
					d2 = Document.parse(u);
					
					coll = dataStore.getCollection(collectionName);
					UpdateResult ur = coll.updateMany(d, d2);
					numberOfAffectedRows = (int)ur.getModifiedCount();
				}
				else numberOfAffectedRows = 0;
				break;		
				
			case delete:

				d = Document.parse(statement);
				coll = dataStore.getCollection(collectionName);
				DeleteResult dr = coll.deleteMany(d);
				
				numberOfAffectedRows = (int)dr.getDeletedCount();
				break;
				
			}
		}

		return numberOfAffectedRows;
	}
	
	private String getUpdateStetament_Query(String aStatement)
	{
		if (aStatement != null)
		{
			int ndx = aStatement.indexOf(hashSeparator);
			if (ndx >= 0)
				return aStatement.substring(0, ndx);
		}
		
		return null;
	}

	private String getUpdateStetament_Update(String aStatement)
	{
		if (aStatement != null)
		{
			int ndx = aStatement.indexOf(hashSeparator);
			if (ndx >= 0)
				return aStatement.substring(ndx + hashSeparator.length());
		}
		
		return null;
	}


}
