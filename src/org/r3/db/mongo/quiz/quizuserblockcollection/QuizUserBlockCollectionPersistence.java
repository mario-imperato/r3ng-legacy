//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.quiz.quizuserblockcollection;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

public class QuizUserBlockCollectionPersistence extends QuizUserBlockCollectionPersistenceBase
{
	public static QuizUserBlockCollectionPersistence createPersistenceObject(org.r3.db.MongoPersistenceContext pcfg)
	{
		QuizUserBlockCollectionPersistence p = new QuizUserBlockCollectionPersistence();
		return p;
	}

	public List<QuizUserBlockCollectionDTO> selectByQuizidUser(Datastore mongoDatastore, String aQuizId, String userIdOrUserSessionId)
	{
		Query<QuizUserBlockCollectionDTO> query = mongoDatastore.createQuery(QuizUserBlockCollectionDTO.class);
		query.field(QuizUserBlockCollectionDTO.QUIZID).equal(aQuizId);
		query.field(QuizUserBlockCollectionDTO.USERSESSIONID).equal(userIdOrUserSessionId);
		List<QuizUserBlockCollectionDTO> l = query.asList();
		return l;
	}
}
