package org.r3.ws.quiz.quiz;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTO;
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.AuthFunction;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETQuiz extends ServicePattern
{
    private String quizId;
    
	public GETQuiz(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aQuizId)
	{
		super(ctx, serviceEnvironment);
		quizId = aQuizId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
				
		QuizCollectionPersistence quizpersistence = QuizCollectionPersistence.createPersistenceObject(mctx);
		UserProfileViewDTO theUser = senv.getUserProfile();
		
		QuizCollectionDTO quizdto = quizpersistence.selectBySiteQuizid(mongoDatastore, senv.getRequestSiteId(), quizId);
		if (quizdto == null)
		{
			return RestServiceDTO.FailDTO;
		}
		
		boolean clearSensitiveData = true;
		if (senv.getUserProfile().isInRole(senv.getRequestSiteId(), new AuthFunction("quizmanager")))
		{
			clearSensitiveData = false;
		}
		
		if (clearSensitiveData)
		{
			quizdto.clearSensitiveInformation();
		}
		
		return quizdto;
	}
	
	

}
