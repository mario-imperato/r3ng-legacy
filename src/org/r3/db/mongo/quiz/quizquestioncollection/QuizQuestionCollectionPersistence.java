//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.quiz.quizquestioncollection;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

public class QuizQuestionCollectionPersistence extends QuizQuestionCollectionPersistenceBase
{
	public static QuizQuestionCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
	{
		QuizQuestionCollectionPersistence p = new QuizQuestionCollectionPersistence();
		return p;
	}

	public List<QuizQuestionCollectionDTO> selectByQuestionids(Datastore mongoDatastore, List<String> aListOfQuestionId)
	{
		Query<QuizQuestionCollectionDTO> query = mongoDatastore.createQuery(QuizQuestionCollectionDTO.class);
		query.field(QuizQuestionCollectionDTO.QUESTIONID).in(aListOfQuestionId);
		List<QuizQuestionCollectionDTO> l = query.asList();
		return l;
	}
}
