//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.usercollection;

import java.util.List;

import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.r3.db.MongoDbSchemaInfo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

public class UserCollectionPersistenceBase{
	public int insert(UserCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByUserid(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Userid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbUserCollectionName);
		
		Document filterCondition = new Document(UserCollectionDTO.USERID, Userid);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByUserid(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Userid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbUserCollectionName);
		
		Document filterCondition = new Document(UserCollectionDTO.USERID, Userid);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public UserCollectionDTO selectByUserid(Datastore ds, java.lang.String aUserid) 
	{
		Query<UserCollectionDTO> query = ds.createQuery(UserCollectionDTO.class);
		
		query.field(UserCollectionDTO.USERID).equal(aUserid);		
		
		List<UserCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByUserid(Datastore ds, UpdateOperations<UserCollectionDTO> anUpdateOperation, java.lang.String aUserid, boolean createIfMissing) 
	{
		Query<UserCollectionDTO> query = ds.createQuery(UserCollectionDTO.class);
		query.field(UserCollectionDTO.USERID).equal(aUserid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<UserCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public UserCollectionDataTableAdapter query(Query<UserCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<UserCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		UserCollectionDataTableAdapter dt = new UserCollectionDataTableAdapter();
		dt.setsEcho(sEcho);
		  
		if (numberOfItems >= 0)
		{
		     dt.setiTotalRecords(numberOfItems);
		     dt.setiTotalDisplayRecords(numberOfItems);
		}
		else
		{
		     if (l != null)
		     {
		     dt.setiTotalRecords(l.size());
		     dt.setiTotalDisplayRecords(l.size());
		     }
		     else
		     {
		     dt.setiTotalRecords(0);
		     dt.setiTotalDisplayRecords(0);
		     }
		}
		     
		dt.setAaData(l);		
		return dt;		  
	}
	  
}


