//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.timelinecollection;

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

public class TimelineCollectionPersistenceBase{
	public int insert(TimelineCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByTimelineid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Timelineid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbTimelineCollectionName);
		
		Document filterCondition = new Document(TimelineCollectionDTO.TIMELINEID, Timelineid);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByTimelineid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Timelineid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbTimelineCollectionName);
		
		Document filterCondition = new Document(TimelineCollectionDTO.TIMELINEID, Timelineid);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public TimelineCollectionDTO selectByTimelineid(Datastore ds, org.bson.types.ObjectId aTimelineid) 
	{
		Query<TimelineCollectionDTO> query = ds.createQuery(TimelineCollectionDTO.class);
		
		query.field(TimelineCollectionDTO.TIMELINEID).equal(aTimelineid);		
		
		List<TimelineCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByTimelineid(Datastore ds, UpdateOperations<TimelineCollectionDTO> anUpdateOperation, org.bson.types.ObjectId aTimelineid, boolean createIfMissing) 
	{
		Query<TimelineCollectionDTO> query = ds.createQuery(TimelineCollectionDTO.class);
		query.field(TimelineCollectionDTO.TIMELINEID).equal(aTimelineid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<TimelineCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public TimelineCollectionDataTableAdapter query(Query<TimelineCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<TimelineCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		TimelineCollectionDataTableAdapter dt = new TimelineCollectionDataTableAdapter();
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


