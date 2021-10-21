//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.filecollection;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.mongo.filecollection.FileCollectionDTO.FileStatus;
import org.r3.db.utils.MongoUtils;

import com.mongodb.WriteResult;

public class FileCollectionPersistence extends FileCollectionPersistenceBase
{
  public static FileCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
  {
      FileCollectionPersistence p = new FileCollectionPersistence();
      return p;
  }    
  
	public FileCollectionDTO selectBySiteObjectid(MongoPersistenceContext mpctx, String aSite, String objectId) 
	{
		Datastore ds = mpctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		Query<FileCollectionDTO> query = ds.createQuery(FileCollectionDTO.class);
		query.field(FileCollectionDTO.SITE).equal(aSite); 		
		query.field(FileCollectionDTO.FILEID).equal(MongoUtils.getObjectIdFromString(objectId)); 
		List<FileCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		
		return null;
	}
	
	public int updateBySiteFileid(Datastore ds, UpdateOperations<FileCollectionDTO> anUpdateOperation, String aSite, org.bson.types.ObjectId aFileid, boolean createIfMissing) 
	{
		Query<FileCollectionDTO> query = ds.createQuery(FileCollectionDTO.class);
		query.field(FileCollectionDTO.SITE).equal(aSite);
		query.field(FileCollectionDTO.FILEID).equal(aFileid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}
	
	public int removeByUrl(String userphotoUrl, Datastore datastore)
	{
		FileCollectionUrl u = new FileCollectionUrl(userphotoUrl);
		
		WriteResult r = datastore.delete(u.queryFilter(datastore));
		return r.getN();		
	}
	
	public byte[] getUrlAsByteArray(MongoPersistenceContext mpctx, FileCollectionUrl aUrl)
	{		
		FileCollectionDTO dto = selectBySiteObjectid(mpctx, aUrl.getSite(), aUrl.getOid());
		if (dto != null)
			return dto.getData().getData();
		
		return null;
	}
	
	public int updateRefinfoBySiteFileid(Datastore mongoDatastore, String aSite, String oid, String aMainentityid, String anAmbitid, String aSubAmbitid, FileStatus aFileStatus)
	{
		UpdateOperations<FileCollectionDTO> uop = mongoDatastore.createUpdateOperations(FileCollectionDTO.class);
		
		if (anAmbitid != null)
		   uop.set(FileCollectionDTO.REFAMBIT, anAmbitid);

		if (aSubAmbitid != null)
			uop.set(FileCollectionDTO.REFSUBAMBIT, aSubAmbitid);		
		
		if (aMainentityid != null)
		uop.set(FileCollectionDTO.REFMAINENTITY, aMainentityid);
		
		if (aFileStatus != null)
			uop.set(FileCollectionDTO.STATUS, aFileStatus.toString());
		else 
			uop.unset(FileCollectionDTO.STATUS);
		
		return updateBySiteFileid(mongoDatastore, uop, aSite, MongoUtils.getObjectIdFromString(oid), false);
	}

	public int removeBySiteRefInfo(Datastore mongoDatastore, String aSite, String timeline, String contentclass, String postid)
	{
		Query<FileCollectionDTO> q = mongoDatastore.createQuery(FileCollectionDTO.class);
		q.field(FileCollectionDTO.SITE).equal(aSite);
		q.field(FileCollectionDTO.REFMAINENTITY).equal(postid);

		if (timeline != null)
			q.field(FileCollectionDTO.REFAMBIT).equal(timeline);
		
		if (contentclass != null)
			q.field(FileCollectionDTO.REFSUBAMBIT).equal(contentclass);
				
		WriteResult r = mongoDatastore.delete(q);
		return r.getN();			
	}

	public int removeMasterfileBySiteFileid(Datastore mongoDatastore, String aSite, ObjectId aFileId)
	{
		Query<FileCollectionDTO> q = mongoDatastore.createQuery(FileCollectionDTO.class);
		q.field(FileCollectionDTO.SITE).equal(aSite);
		q.or(q.criteria(FileCollectionDTO.FILEID).equal(aFileId), q.criteria(FileCollectionDTO.MASTERFILE).equal(aFileId.toHexString()));
				
		WriteResult r = mongoDatastore.delete(q);
		return r.getN();			
	}

}


