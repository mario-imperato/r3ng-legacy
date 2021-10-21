//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.postcollection;

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

public class PostCollectionPersistenceBase{
	public int insert(PostCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByPostid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Postid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbPostCollectionName);
		
		Document filterCondition = new Document(PostCollectionDTO.POSTID, Postid);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByPostid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Postid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbPostCollectionName);
		
		Document filterCondition = new Document(PostCollectionDTO.POSTID, Postid);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public PostCollectionDTO selectByPostid(Datastore ds, org.bson.types.ObjectId aPostid) 
	{
		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
		
		query.field(PostCollectionDTO.POSTID).equal(aPostid);		
		
		List<PostCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByPostid(Datastore ds, UpdateOperations<PostCollectionDTO> anUpdateOperation, org.bson.types.ObjectId aPostid, boolean createIfMissing) 
	{
		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
		query.field(PostCollectionDTO.POSTID).equal(aPostid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<PostCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public PostCollectionDataTableAdapter query(Query<PostCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<PostCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		PostCollectionDataTableAdapter dt = new PostCollectionDataTableAdapter();
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


