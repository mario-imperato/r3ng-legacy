//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.postcollection;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.utils.MongoUtils;

import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;

public class PostCollectionPersistence extends PostCollectionPersistenceBase
{
	public static PostCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
	{
		PostCollectionPersistence p = new PostCollectionPersistence();
		return p;
	}

	public PostCollectionDTO selectBySitePostid(Datastore ds, String aSite, String aPostid, boolean includeComments)
	{
		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
		query.field(PostCollectionDTO.SITE).equal(aSite)
		     .field(PostCollectionDTO.POSTID).equal(MongoUtils.getObjectIdFromString(aPostid));	
		
		if (!includeComments)
		{
			query.retrievedFields(false, PostCollectionDTO.COMMENTS);
		}
		
		List<PostCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public PostCollectionDTO selectBySiteTimelinePostid(Datastore ds, String aSite, String aTimeline, String aPostid)
	{
		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
		query.field(PostCollectionDTO.SITE).equal(aSite)
		     .field(PostCollectionDTO.TIMELINE).equal(aTimeline)
		     .field(PostCollectionDTO.POSTID).equal(MongoUtils.getObjectIdFromString(aPostid));	
		
		List<PostCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}
	
	public int removeBySiteTimelinePostid(Datastore ds, String aSite, String aTimeline, String aPostid) 
	{
		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
		query.field(PostCollectionDTO.SITE).equal(aSite)
		     .field(PostCollectionDTO.TIMELINE).equal(aTimeline)
		     .field(PostCollectionDTO.POSTID).equal(MongoUtils.getObjectIdFromString(aPostid));
		
		WriteResult res = ds.delete(query);		
		return res.getN();		
	}

	public int removeBySitePostid(Datastore ds, String aSite, String aPostid) 
	{
		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
		query.field(PostCollectionDTO.SITE).equal(aSite)
		     .field(PostCollectionDTO.POSTID).equal(MongoUtils.getObjectIdFromString(aPostid));
		
		WriteResult res = ds.delete(query);		
		return res.getN();		
	}
	
	public int updateBySitePostid(
			Datastore ds, UpdateOperations<PostCollectionDTO> anUpdateOperation, 
			String aSite, ObjectId aPostId)
	{
		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
		query.field(PostCollectionDTO.SITE).equal(aSite)
		     .field(PostCollectionDTO.POSTID).equal(aPostId);
		
		UpdateResults results = ds.update(query, anUpdateOperation);
		return results.getUpdatedCount();		
	}	
	
	public int updateBySitePostid(
			Datastore ds, UpdateOperations<PostCollectionDTO> anUpdateOperation, 
			String aSite, String aPostId)
	{
		return updateBySitePostid(ds, anUpdateOperation, aSite, MongoUtils.getObjectIdFromString(aPostId));	
	}	
	
//	public int updateStatusBySitePostid(
//			Datastore ds, StatusType aStatus, String aSite, ObjectId aPostId)
//	{
//		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
//		query.field(PostCollectionDTO.SITE).equal(aSite)
//		     .field(PostCollectionDTO.POSTID).equal(aPostId);
//		
//		UpdateOperations<PostCollectionDTO> anUpdateOperation = ds.createUpdateOperations(PostCollectionDTO.class);
//		anUpdateOperation.set(PostCollectionDTO.STATUS, aStatus.toString());
//		
//		UpdateResults results = ds.update(query, anUpdateOperation);
//		return results.getUpdatedCount();		
//	}	
//	
//	public int updateStatusBySitePostid(
//			Datastore ds, StatusType aStatus, String aSite, String aPostId)
//	{
//		return updateStatusBySitePostid(ds, aStatus, aSite, MongoUtils.getObjectIdFromString(aPostId));	
//	}	
	
	public int updateBySiteTimelinePostid(
			Datastore ds, UpdateOperations<PostCollectionDTO> anUpdateOperation, 
			String aSite, String timelineId, String aPostId)
	{
		Query<PostCollectionDTO> query = ds.createQuery(PostCollectionDTO.class);
		query.field(PostCollectionDTO.SITE).equal(aSite)
		     .field(PostCollectionDTO.TIMELINE).equal(timelineId)
		     .field(PostCollectionDTO.POSTID).equal(MongoUtils.getObjectIdFromString(aPostId));
		
		UpdateResults results = ds.update(query, anUpdateOperation);
		return results.getUpdatedCount();		
	}	
		

	public long rawRemoveFileAttachmentBySitePostidFileid(org.r3.db.MongoPersistenceContext mpctx, String aSite, org.bson.types.ObjectId Postid, String aFileId) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbPostCollectionName);
		
		Document query = new Document().append(PostCollectionDTO.POSTID, Postid).append(PostCollectionDTO.SITE, aSite);
		Document fields = new Document().append(PostCollectionDTO.ATTACHMENTS, new Document().append( "fileid", aFileId));
		Document update = new Document("$pull",fields);

		UpdateResult result = coll.updateOne( query, update );				
		return result.getModifiedCount();		
	}
	
	public long rawRemoveFileAttachmentBySitePostidLinkid(org.r3.db.MongoPersistenceContext mpctx, String aSite, org.bson.types.ObjectId Postid, String aLinkId) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbPostCollectionName);
		
		Document query = new Document().append(PostCollectionDTO.POSTID, Postid).append(PostCollectionDTO.SITE, aSite);
		Document fields = new Document().append(PostCollectionDTO.LINKS, new Document().append( "linkid", aLinkId));
		Document update = new Document("$pull",fields);

		UpdateResult result = coll.updateOne( query, update );				
		return result.getModifiedCount();		
	}
	
}
