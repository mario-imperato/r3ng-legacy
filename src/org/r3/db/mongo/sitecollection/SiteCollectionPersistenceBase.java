//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.sitecollection;

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

public class SiteCollectionPersistenceBase{
	public int insert(SiteCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectBySite(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Site) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbSiteCollectionName);
		
		Document filterCondition = new Document(SiteCollectionDTO.SITE, Site);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveBySite(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Site) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbSiteCollectionName);
		
		Document filterCondition = new Document(SiteCollectionDTO.SITE, Site);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public SiteCollectionDTO selectBySite(Datastore ds, java.lang.String aSite) 
	{
		Query<SiteCollectionDTO> query = ds.createQuery(SiteCollectionDTO.class);
		
		query.field(SiteCollectionDTO.SITE).equal(aSite);		
		
		List<SiteCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateBySite(Datastore ds, UpdateOperations<SiteCollectionDTO> anUpdateOperation, java.lang.String aSite, boolean createIfMissing) 
	{
		Query<SiteCollectionDTO> query = ds.createQuery(SiteCollectionDTO.class);
		query.field(SiteCollectionDTO.SITE).equal(aSite);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<SiteCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public SiteCollectionDataTableAdapter query(Query<SiteCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<SiteCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		SiteCollectionDataTableAdapter dt = new SiteCollectionDataTableAdapter();
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


