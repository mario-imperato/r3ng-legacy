//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizuseranswercollection;

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

public class QuizUserAnswerCollectionPersistenceBase{
	public int insert(QuizUserAnswerCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByUseranswerid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Useranswerid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbQuizUserAnswerCollectionName);
		
		Document filterCondition = new Document(QuizUserAnswerCollectionDTO.USERANSWERID, Useranswerid);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByUseranswerid(org.r3.db.MongoPersistenceContext mpctx, org.bson.types.ObjectId Useranswerid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbQuizUserAnswerCollectionName);
		
		Document filterCondition = new Document(QuizUserAnswerCollectionDTO.USERANSWERID, Useranswerid);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public QuizUserAnswerCollectionDTO selectByUseranswerid(Datastore ds, org.bson.types.ObjectId aUseranswerid) 
	{
		Query<QuizUserAnswerCollectionDTO> query = ds.createQuery(QuizUserAnswerCollectionDTO.class);
		
		query.field(QuizUserAnswerCollectionDTO.USERANSWERID).equal(aUseranswerid);		
		
		List<QuizUserAnswerCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByUseranswerid(Datastore ds, UpdateOperations<QuizUserAnswerCollectionDTO> anUpdateOperation, org.bson.types.ObjectId aUseranswerid, boolean createIfMissing) 
	{
		Query<QuizUserAnswerCollectionDTO> query = ds.createQuery(QuizUserAnswerCollectionDTO.class);
		query.field(QuizUserAnswerCollectionDTO.USERANSWERID).equal(aUseranswerid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<QuizUserAnswerCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public QuizUserAnswerCollectionDataTableAdapter query(Query<QuizUserAnswerCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<QuizUserAnswerCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		QuizUserAnswerCollectionDataTableAdapter dt = new QuizUserAnswerCollectionDataTableAdapter();
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


