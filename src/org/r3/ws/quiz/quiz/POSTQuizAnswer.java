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

public class POSTQuizAnswer extends ServicePattern
{
    private String quizId;
    private String quizIdUserSessionBlockNumber;
    private String questionId;
    private String answerId;
    
	public POSTQuizAnswer(ServletContext ctx,  ServiceEnvironment serviceEnvironment, 
			String aQuizId, String aQuizIdUserSessionBlockNumber, String aQuestionId, String anAnswerId)
	{
		super(ctx, serviceEnvironment);
		quizId = aQuizId;
		quizIdUserSessionBlockNumber = aQuizIdUserSessionBlockNumber;
		questionId = aQuestionId;
		answerId = anAnswerId;
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

		if (!userBlock.isStarted())
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q007", "Block Cannot Be Edited");
		}
		
		// Prendo la lista delle domande e cerco di capire la prima ancora da rispondere.
		List<String> listOfQuestionsId = userBlock.getQuestions();
		String question2Answer =  userBlock.findFirstUnansweredQuestionId();
		if (question2Answer == null)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q007", "No Question To Answer Found");
		}
		
		if (!question2Answer.equalsIgnoreCase(questionId))
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q008", "Requested Question Cannot Be Answered");
		}
		
		QuizQuestionCollectionPersistence questionCollectionPersistence = QuizQuestionCollectionPersistence.createPersistenceObject(mctx);
		QuizQuestionCollectionDTO qDTO = questionCollectionPersistence.selectByQuestionid(mongoDatastore, questionId);
		if (qDTO == null)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q009", "The Requested Question Cannot Be Found");
		}
		
		QuizQuestionCollectionDTO.AnswersDTO answerDTO = qDTO.getAnswer(answerId);
		if (answerDTO == null)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q010", "The Requested Answer Cannot Be Found");
		}

		// Calcolo i secondi che ci sta mettendo.
		long userTimer = (nowDate.getTime() - userBlock.getUserstartdate().getTime()) / 1000;
		boolean isTimeout = userBlock.isTimeout(userTimer);
		
		QuizUserAnswerCollectionPersistence userAnswerCollectionPersistence = QuizUserAnswerCollectionPersistence.createPersistenceObject(mctx);
		QuizUserAnswerCollectionDTO userAnswerDTO = new QuizUserAnswerCollectionDTO();
		userAnswerDTO.setAnswerid(answerId);
		userAnswerDTO.setUsersessionid(blockUser);
		userAnswerDTO.setBlocknumber(userBlock.getBlocknumber());
		userAnswerDTO.setQuestionid(questionId);
		userAnswerDTO.setQuizid(quizId);
		userAnswerDTO.setQuizuserblocknumber(quizIdUserSessionBlockNumber);
		userAnswerDTO.setTimeout(isTimeout);
		
		userAnswerDTO.setValid(answerDTO.isValid());		
		if (answerDTO.isValid() && !isTimeout)
		{
		  userAnswerDTO.setScore(answerDTO.getWeight());
		}
		else 
		  userAnswerDTO.setScore(0);
		
		userAnswerDTO.setWhen(nowDate);		
		userAnswerCollectionPersistence.insert(userAnswerDTO, mongoDatastore);
		
		/*
		 * Gestione Aggiornamento UserBlock. 
		 */
		UpdateOperations<QuizUserBlockCollectionDTO> userBlockUpdateContext = mongoDatastore.createUpdateOperations(QuizUserBlockCollectionDTO.class);
		
		if (!isTimeout)
		{
			if (answerDTO.isValid())
			{
				userBlock.setScore4Update(userBlockUpdateContext, userBlock.getScore() + answerDTO.getWeight());
				userBlock.setNumberofok4Update(userBlockUpdateContext, userBlock.getNumberofok() + 1);
			}			
			userBlock.setNumberofanswered4Update(userBlockUpdateContext, userBlock.getNumberofanswered() + 1);
		}
		
		userBlock.setLastanswerquestion4Update(userBlockUpdateContext, questionId);
		userBlock.setLastanswerdate4Update(userBlockUpdateContext, nowDate);
		
		// Capisco se applicare la penalty
		if (userBlock.getLateanswerpenalty() > 0 && nowDate.after(userBlock.getValidto()))
		{
			userBlock.setUserlateanswerpenalty4Update(userBlockUpdateContext, userBlock.getLateanswerpenalty());
		}
		
		// Aggiorno il timeout.
		userBlock.setUsertimer4Update(userBlockUpdateContext, (int)userTimer);
		if (isTimeout)
		{
			userBlock.setStatus4Update(userBlockUpdateContext, BlockStatusType.timeout.toString());		
		}
		else
		{
			// Debbo capire quando chiudere...
			if (userBlock.isLastQuestion(questionId))
				userBlock.setStatus4Update(userBlockUpdateContext, BlockStatusType.closed.toString());					
		}
				
		userBlockPersistence.updateByQuizuserblocknumber(mongoDatastore, userBlockUpdateContext, quizIdUserSessionBlockNumber, false);		
		return (isTimeout) ? new RestServiceDTO(RestServiceDTO.Status.fail, "QTIMEOUT", "Timeout For Answer"): RestServiceDTO.SuccessDTO;
	}
		

}
