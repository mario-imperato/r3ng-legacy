package org.r3.ws.quiz.quiz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTO;
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTOBase.QuizblocksDTO;
import org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionDTO;
import org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionPersistence;
import org.r3.db.mongo.quiz.quizuseranswercollection.QuizUserAnswerCollectionDTO;
import org.r3.db.mongo.quiz.quizuseranswercollection.QuizUserAnswerCollectionPersistence;
import org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionDTOBase.AnswersDTO;
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionPersistence;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO.BlockStatusType;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTOBase;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.AuthFunction;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETQuizSessionInfo extends ServicePattern
{
    private String quizId;
    private String quizIdUserSessionBlockNumber;

    
	public GETQuizSessionInfo(ServletContext ctx,  ServiceEnvironment serviceEnvironment, 
			String aQuizId, String aQuizIdUserSessionBlockNumber)
	{
		super(ctx, serviceEnvironment);
		quizId = aQuizId;
		quizIdUserSessionBlockNumber = aQuizIdUserSessionBlockNumber;

	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		java.util.Date nowDate = new java.util.Date();
		
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);		
		
		UserProfileViewDTO theUser = senv.getUserProfile();
		
		boolean isQuizManager = false;
		if (senv.getUserProfile().isInRole(senv.getRequestSiteId(), new AuthFunction("quizmanager")))
		{
			isQuizManager = true;
		}		
		
		QuizCollectionPersistence quizpersistence = QuizCollectionPersistence.createPersistenceObject(mctx);
		QuizCollectionDTO quizdto = quizpersistence.selectBySiteQuizid(mongoDatastore, senv.getRequestSiteId(), quizId);
		if (quizdto == null)
		{
			return RestServiceDTO.FailDTO;
		}
		
		QuizUserBlockCollectionPersistence userBlockPersistence = QuizUserBlockCollectionPersistence.createPersistenceObject(mctx);
		QuizUserBlockCollectionDTO userBlock = userBlockPersistence.selectByQuizuserblocknumber(mongoDatastore, quizIdUserSessionBlockNumber);
		if (userBlock == null)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q005", "Could Not Find User Block");
		}
		
		String blockUser = senv.getAuthInfo().getUserIdOrUserSessionId();
		if (!userBlock.getUsersessionid().equalsIgnoreCase(blockUser) && !isQuizManager)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q006", "User And Block Doesn't Match");
		}
	
		if (userBlock.isStarted())
		{
			long userTimer = userBlock.computeUserTimer(nowDate);
			
			// Debbo Procedere con update
			UpdateOperations<QuizUserBlockCollectionDTO> userBlockUpdateContext = mongoDatastore.createUpdateOperations(QuizUserBlockCollectionDTO.class);	
			userBlock.setUsertimer4Update(userBlockUpdateContext, (int)userTimer);
			if (userBlock.isTimeout(userTimer))
			{
				userBlock.setStatus4Update(userBlockUpdateContext, BlockStatusType.timeout.toString());					
			}
			
			userBlockPersistence.updateByQuizuserblocknumber(mongoDatastore, userBlockUpdateContext, userBlock.getQuizuserblocknumber(), false);
		}
		
		return userBlock;
	}
		

}
