//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.postcommentcollection;

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

public class PostCommentCollectionPersistenceBase{
	public int insert(PostCommentCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByCommentid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Commentid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbPostCommentCollectionName);
		
		Document filterCondition = new Document(PostCommentCollectionDTO.COMMENTID, Commentid);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByCommentid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Commentid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbPostCommentCollectionName);
		
		Document filterCondition = new Document(PostCommentCollectionDTO.COMMENTID, Commentid);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public PostCommentCollectionDTO selectByCommentid(Datastore ds, org.bson.types.ObjectId aCommentid) 
	{
		Query<PostCommentCollectionDTO> query = ds.createQuery(PostCommentCollectionDTO.class);
		
		query.field(PostCommentCollectionDTO.COMMENTID).equal(aCommentid);		
		
		List<PostCommentCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByCommentid(Datastore ds, UpdateOperations<PostCommentCollectionDTO> anUpdateOperation, org.bson.types.ObjectId aCommentid, boolean createIfMissing) 
	{
		Query<PostCommentCollectionDTO> query = ds.createQuery(PostCommentCollectionDTO.class);
		query.field(PostCommentCollectionDTO.COMMENTID).equal(aCommentid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<PostCommentCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public PostCommentCollectionDataTableAdapter query(Query<PostCommentCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<PostCommentCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		PostCommentCollectionDataTableAdapter dt = new PostCommentCollectionDataTableAdapter();
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


