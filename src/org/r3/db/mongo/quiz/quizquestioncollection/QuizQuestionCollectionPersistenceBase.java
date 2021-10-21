//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizquestioncollection;

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

public class QuizQuestionCollectionPersistenceBase{
	public int insert(QuizQuestionCollectionDTO aDto, Datastore aMorphiaDatastore)
	{
		aMorphiaDatastore.save(aDto);
		return 0;
	}

	public Document rawSelectByQuestionid(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Questionid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbQuizQuestionCollectionName);
		
		Document filterCondition = new Document(QuizQuestionCollectionDTO.QUESTIONID, Questionid);
		Document responseObject = coll.find(filterCondition).first();
		
		return responseObject;		
	}

	public long rawRemoveByQuestionid(org.r3.db.MongoPersistenceContext mpctx, java.lang.String Questionid) 
	{
		MongoDatabase db = mpctx.getMongoDbClient().getDatabase(MongoDbSchemaInfo.MongoDbName);
		MongoCollection<Document> coll = db.getCollection(MongoDbSchemaInfo.MongoDbQuizQuestionCollectionName);
		
		Document filterCondition = new Document(QuizQuestionCollectionDTO.QUESTIONID, Questionid);
		DeleteResult responseObject = coll.deleteOne(filterCondition);
		
		return responseObject.getDeletedCount();		
	}
	
	public QuizQuestionCollectionDTO selectByQuestionid(Datastore ds, java.lang.String aQuestionid) 
	{
		Query<QuizQuestionCollectionDTO> query = ds.createQuery(QuizQuestionCollectionDTO.class);
		
		query.field(QuizQuestionCollectionDTO.QUESTIONID).equal(aQuestionid);		
		
		List<QuizQuestionCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;		
	}

	public int updateByQuestionid(Datastore ds, UpdateOperations<QuizQuestionCollectionDTO> anUpdateOperation, java.lang.String aQuestionid, boolean createIfMissing) 
	{
		Query<QuizQuestionCollectionDTO> query = ds.createQuery(QuizQuestionCollectionDTO.class);
		query.field(QuizQuestionCollectionDTO.QUESTIONID).equal(aQuestionid);
		
		UpdateResults results = ds.update(query, anUpdateOperation, createIfMissing);
		return results.getUpdatedCount();		
	}

	public int count(Query<QuizQuestionCollectionDTO> query)
	{
		return (int)query.countAll();
	}

	public QuizQuestionCollectionDataTableAdapter query(Query<QuizQuestionCollectionDTO> query, String sEcho, int iDisplayStart, int iDisplayLength, boolean countElements)
	{
		int numberOfItems = (countElements) ? count(query) : -1;    	
		List<QuizQuestionCollectionDTO> l = null;
    	if (numberOfItems != 0)
    	{
    		if (iDisplayStart > 0)
    			query.offset(iDisplayStart);
    		
    		if (iDisplayLength > 0)
    			query.limit(iDisplayLength);
    	
		    l = query.asList();
        }

		QuizQuestionCollectionDataTableAdapter dt = new QuizQuestionCollectionDataTableAdapter();
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


