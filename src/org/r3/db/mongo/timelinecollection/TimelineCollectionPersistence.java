//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.timelinecollection;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.r3.db.utils.MongoUtils;

import com.mongodb.WriteResult;

public class TimelineCollectionPersistence extends TimelineCollectionPersistenceBase
{
	public static TimelineCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
	{
		TimelineCollectionPersistence p = new TimelineCollectionPersistence();
		return p;
	}

	public TimelineCollectionDTO selectBySiteTimelineid(Datastore datastore, String aSite, String timelineId)
	{
		Query<TimelineCollectionDTO> query = datastore.createQuery(TimelineCollectionDTO.class);
		query.field(TimelineCollectionDTO.SITE).equal(aSite).field(TimelineCollectionDTO.TIMELINEID)
				.equal(MongoUtils.getObjectIdFromString(timelineId));

		List<TimelineCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;
	}
	
	public int updateBySiteTimelineid(
			Datastore ds, UpdateOperations<TimelineCollectionDTO> anUpdateOperation, 
			String aSite, ObjectId aPostId)
	{
		Query<TimelineCollectionDTO> query = ds.createQuery(TimelineCollectionDTO.class);
		query.field(TimelineCollectionDTO.SITE).equal(aSite)
		     .field(TimelineCollectionDTO.TIMELINEID).equal(aPostId);
		
		UpdateResults results = ds.update(query, anUpdateOperation);
		return results.getUpdatedCount();		
	}	
	
	public int updateBySiteTimelineid(
			Datastore ds, UpdateOperations<TimelineCollectionDTO> anUpdateOperation, 
			String aSite, String aPostId)
	{
		return updateBySiteTimelineid(ds, anUpdateOperation, aSite, MongoUtils.getObjectIdFromString(aPostId));	
	}	
	
	public int removeBySiteTimelineid(Datastore ds, String aSite, String aPostid) 
	{
		Query<TimelineCollectionDTO> query = ds.createQuery(TimelineCollectionDTO.class);
		query.field(TimelineCollectionDTO.SITE).equal(aSite)
		     .field(TimelineCollectionDTO.TIMELINEID).equal(MongoUtils.getObjectIdFromString(aPostid));
		
		WriteResult res = ds.delete(query);		
		return res.getN();		
	}
}
