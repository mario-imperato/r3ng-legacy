//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.filecollection;

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

public class FileCollectionPersistenceBase{
	public int insert(FileCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByFileid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Fileid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbFileCollectionName);
		
		Document filterCondition = new Document(FileCollectionDTO.FILEID, Fileid);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByFileid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Fileid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbFileCollectionName);
		
		Document filterCondition = new Document(FileCollectionDTO.FILEID, Fileid);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public FileCollectionDTO selectByFileid(Datastore ds, org.bson.types.ObjectId aFileid) 
	{
		Query<FileCollectionDTO> query = ds.createQuery(FileCollectionDTO.class);
		
		query.field(FileCollectionDTO.FILEID).equal(aFileid);		
		
		List<FileCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByFileid(Datastore ds, UpdateOperations<FileCollectionDTO> anUpdateOperation, org.bson.types.ObjectId aFileid, boolean createIfMissing) 
	{
		Query<FileCollectionDTO> query = ds.createQuery(FileCollectionDTO.class);
		query.field(FileCollectionDTO.FILEID).equal(aFileid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<FileCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public FileCollectionDataTableAdapter query(Query<FileCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<FileCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		FileCollectionDataTableAdapter dt = new FileCollectionDataTableAdapter();
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


