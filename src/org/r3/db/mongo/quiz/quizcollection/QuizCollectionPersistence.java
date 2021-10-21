//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.quiz.quizcollection;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

public class QuizCollectionPersistence extends QuizCollectionPersistenceBase
{
	public static QuizCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
	{
		QuizCollectionPersistence p = new QuizCollectionPersistence();
		return p;
	}

	public QuizCollectionDTO selectBySiteQuizid(Datastore mongoDatastore, String requestSiteId, String quizId)
	{
		Query<QuizCollectionDTO> query = mongoDatastore.createQuery(QuizCollectionDTO.class);
		query.field(QuizCollectionDTO.QUIZID).equal(quizId);

		List<QuizCollectionDTO> l = query.asList();
		if (l != null && l.size() > 0)
			return l.get(0);
		return null;
	}
}
