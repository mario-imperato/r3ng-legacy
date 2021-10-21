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
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionPersistence;
import org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionDTO;
import org.r3.db.mongo.quiz.quizquestioncollection.QuizQuestionCollectionPersistence;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionPersistence;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO.BlockStatusType;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.AuthFunction;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTOpenSession extends ServicePattern
{
    private String quizId;
    private String quizIdUserSessionBlockNumber;
	public POSTOpenSession(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aQuizId, String aQuizIdUserSessionBlockNumber)
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
		QuizQuestionCollectionPersistence questionCollectionPersistence = QuizQuestionCollectionPersistence.createPersistenceObject(mctx);
		
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
					
		if (!(userBlock.isReady() || userBlock.isStarted()) || userBlock.getValidfrom().after(nowDate))
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q006", "Block Cannot Be Accessed");				
		}
		
		// Prendo la lista delle domande e cerco di capire la prima ancora da rispondere.
		List<String> listOfQuestionsId = userBlock.getQuestions();
		int firstQuestionIndex = userBlock.findIndexOfFirstUnansweredQuestion();
		
		if (firstQuestionIndex < 0)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q006", "No More Questions To Answer");				
		}
		
		// Costruisco un array con i soli Id che debbo interrogare
		List<String> listOfQueriedQuestions = new ArrayList<String>(userBlock.getNumberOfQuestions());
		for(int i = firstQuestionIndex; i < userBlock.getNumberOfQuestions(); i++ )
		{
			listOfQueriedQuestions.add(listOfQuestionsId.get(i));
		}
		
		// Ottengo la lista delle domande effettive		
		List<QuizQuestionCollectionDTO> listOfItems = questionCollectionPersistence.selectByQuestionids(mongoDatastore, listOfQueriedQuestions);
		if (listOfItems.size() != listOfQueriedQuestions.size())
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q007", "Questions Retrieved MisMatch");
		}

		for(QuizQuestionCollectionDTO q : listOfItems)
		{
			if (quizdto.isOpaque())
			{
				q.clearSensitiveInformation();
			}						
		}
		
		if (userBlock.isReady())
		{
			UpdateOperations<QuizUserBlockCollectionDTO> userBlockUpdateContext = mongoDatastore.createUpdateOperations(QuizUserBlockCollectionDTO.class);
			
			userBlock.setUserstartdate4Update(userBlockUpdateContext, nowDate);
			userBlock.setStatus4Update(userBlockUpdateContext, BlockStatusType.started.toString());
			userBlock.setUsertimer4Update(userBlockUpdateContext, 0);
			userBlockPersistence.updateByQuizuserblocknumber(mongoDatastore, userBlockUpdateContext, quizIdUserSessionBlockNumber, false);
		}
			
		// Pulisco sensitive information. E anche la lista degli id generale.
		if (!isQuizManager)
			userBlock = userBlock.clearSensitiveInformation();
		
		// Reinserisco la lista degli Ids e i dataBean delle domande effettive
		userBlock.setQuestionsDTOs(listOfItems);
		userBlock.setQuestions(listOfQueriedQuestions);
		
		return userBlock;
	}
	
	

}
