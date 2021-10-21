//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizcollection;

import java.util.List;
import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import com.mongodb.client.result.DeleteResult;
import org.r3.db.*;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class QuizCollectionPersistenceBase{
	public int insert(QuizCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByQuizid(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Quizid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbQuizCollectionName);
		
		Document filterCondition = new Document(QuizCollectionDTO.QUIZID, Quizid);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByQuizid(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Quizid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbQuizCollectionName);
		
		Document filterCondition = new Document(QuizCollectionDTO.QUIZID, Quizid);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public QuizCollectionDTO selectByQuizid(Datastore ds, java.lang.String aQuizid) 
	{
		Query<QuizCollectionDTO> query = ds.createQuery(QuizCollectionDTO.class);
		
		query.field(QuizCollectionDTO.QUIZID).equal(aQuizid);		
		
		List<QuizCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByQuizid(Datastore ds, UpdateOperations<QuizCollectionDTO> anUpdateOperation, java.lang.String aQuizid, boolean createIfMissing) 
	{
		Query<QuizCollectionDTO> query = ds.createQuery(QuizCollectionDTO.class);
		query.field(QuizCollectionDTO.QUIZID).equal(aQuizid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<QuizCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public QuizCollectionDataTableAdapter query(Query<QuizCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<QuizCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		QuizCollectionDataTableAdapter dt = new QuizCollectionDataTableAdapter();
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


