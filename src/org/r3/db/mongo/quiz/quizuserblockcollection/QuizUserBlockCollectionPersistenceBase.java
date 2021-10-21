//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizuserblockcollection;

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

public class QuizUserBlockCollectionPersistenceBase{
	public int insert(QuizUserBlockCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByQuizuserblocknumber(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Quizuserblocknumber) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbQuizUserBlockCollectionName);
		
		Document filterCondition = new Document(QuizUserBlockCollectionDTO.QUIZUSERBLOCKNUMBER, Quizuserblocknumber);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByQuizuserblocknumber(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Quizuserblocknumber) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbQuizUserBlockCollectionName);
		
		Document filterCondition = new Document(QuizUserBlockCollectionDTO.QUIZUSERBLOCKNUMBER, Quizuserblocknumber);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public QuizUserBlockCollectionDTO selectByQuizuserblocknumber(Datastore ds, java.lang.String aQuizuserblocknumber) 
	{
		Query<QuizUserBlockCollectionDTO> query = ds.createQuery(QuizUserBlockCollectionDTO.class);
		
		query.field(QuizUserBlockCollectionDTO.QUIZUSERBLOCKNUMBER).equal(aQuizuserblocknumber);		
		
		List<QuizUserBlockCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByQuizuserblocknumber(Datastore ds, UpdateOperations<QuizUserBlockCollectionDTO> anUpdateOperation, java.lang.String aQuizuserblocknumber, boolean createIfMissing) 
	{
		Query<QuizUserBlockCollectionDTO> query = ds.createQuery(QuizUserBlockCollectionDTO.class);
		query.field(QuizUserBlockCollectionDTO.QUIZUSERBLOCKNUMBER).equal(aQuizuserblocknumber);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<QuizUserBlockCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public QuizUserBlockCollectionDataTableAdapter query(Query<QuizUserBlockCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<QuizUserBlockCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		QuizUserBlockCollectionDataTableAdapter dt = new QuizUserBlockCollectionDataTableAdapter();
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


