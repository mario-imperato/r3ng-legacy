package org.r3.ws.quiz.quiz;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.mongodb.morphia.Datastore;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.MongoPersistenceContext;
import org.r3.db.PersistenceContext;
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTO;
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionDTOBase.QuizblocksDTO;
import org.r3.db.mongo.quiz.quizcollection.QuizCollectionPersistence;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO.BlockStatusType;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionPersistence;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.AuthFunction;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class POSTEnrollInQuiz extends ServicePattern
{
    private String quizId;
    
	public POSTEnrollInQuiz(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aQuizId)
	{
		super(ctx, serviceEnvironment);
		quizId = aQuizId;
	}

	@Override
	protected Object process(PersistenceContext pcfg, SqlSession aSession)
	{
		List<QuizUserBlockCollectionDTO> listOfUserVisibleBlocks = null;
				
		MongoPersistenceContext mctx = pcfg.getMongoPersistenceContext();
		Datastore mongoDatastore = mctx.getDatastore(MongoDbSchemaInfo.MongoDbName);
		
		QuizCollectionPersistence quizpersistence = QuizCollectionPersistence.createPersistenceObject(mctx);
		// UserProfileViewDTO theUser = senv.getUserProfile();
		
		boolean clearSensitiveData = true;
		if (senv.getUserProfile().isInRole(senv.getRequestSiteId(), new AuthFunction("quizmanager")))
		{
			clearSensitiveData = false;
		}
		
		QuizCollectionDTO quizdto = quizpersistence.selectBySiteQuizid(mongoDatastore, senv.getRequestSiteId(), quizId);
		if (quizdto == null)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q001", "Requested Quiz Not Found");
		}
		
		String userOrSessionId = senv.getAuthInfo().getUserIdOrUserSessionId();
		QuizUserBlockCollectionPersistence userBlockPersistence = QuizUserBlockCollectionPersistence.createPersistenceObject(mctx);
		List<QuizUserBlockCollectionDTO> listOfUserBlockDTO = userBlockPersistence.selectByQuizidUser(mongoDatastore, quizId, userOrSessionId);
		if (listOfUserBlockDTO != null && listOfUserBlockDTO.size() > 0)
		{
			listOfUserVisibleBlocks = new ArrayList<QuizUserBlockCollectionDTO>();
			for(QuizUserBlockCollectionDTO quizUserBlockDto : listOfUserBlockDTO)
			{
				if (quizUserBlockDto.getValidfrom().before(new java.util.Date()))
					listOfUserVisibleBlocks.add((clearSensitiveData) ? quizUserBlockDto.clearSensitiveInformation() : quizUserBlockDto);
			}
			
			if (listOfUserVisibleBlocks.isEmpty())
				return RestServiceDTO.SuccessDTO;
			
			return listOfUserVisibleBlocks;
		}
		
		List<String> listOfQuestions = quizdto.getQuestions();		
		String[] arrOfQuestionsId = pickAQuestionSet(listOfQuestions, userOrSessionId);
		if (arrOfQuestionsId == null)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q003", "Quiz Data MisConfigured");
		}
				
		List<QuizblocksDTO> listOfDefinedBlocks = quizdto.getQuizblocks();
		int numberOfRequiredQuestions = 0;
		for(int i = 0; i < listOfDefinedBlocks.size(); i++)
		{
			int sz = listOfDefinedBlocks.get(i).getSize();
			if (sz <= 0)
			{
				return new RestServiceDTO(RestServiceDTO.Status.fail, "Q004", "Quiz Data MisConfigured");
			}
			
			numberOfRequiredQuestions += sz;
		}
		
		if (numberOfRequiredQuestions > arrOfQuestionsId.length)
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "Q005", "Quiz Data MisConfigured");
		}
		
		listOfUserVisibleBlocks = new ArrayList<QuizUserBlockCollectionDTO>();
		
		int questionIndex = 0;
		for(QuizblocksDTO quizBlockDto : listOfDefinedBlocks)
		{			
			QuizUserBlockCollectionDTO userBlockDTO = new QuizUserBlockCollectionDTO();
			userBlockDTO.setBlocknumber(quizBlockDto.getBlocknumber());
			userBlockDTO.setQuizid(quizId);
			userBlockDTO.setUsersessionid(userOrSessionId);
			userBlockDTO.setQuizuserblocknumber(String.format("%s_%s_%d", quizId, userOrSessionId, quizBlockDto.getBlocknumber()));
			userBlockDTO.setDuration(quizBlockDto.getDuration());
			userBlockDTO.setStatus(BlockStatusType.ready.toString());
			userBlockDTO.setValidfrom(quizBlockDto.getValidfrom());
			userBlockDTO.setValidto(quizBlockDto.getValidto());
			userBlockDTO.setLateanswerpenalty(quizBlockDto.getLateanswerpenalty());
			
			List<String> listOfUserBlockQuestions = new ArrayList<String>();
			for(int i = 0; i < quizBlockDto.getSize(); i++, questionIndex++)
			{
				listOfUserBlockQuestions.add(arrOfQuestionsId[questionIndex]);
			}
			userBlockDTO.setQuestions(listOfUserBlockQuestions);
			userBlockDTO.setNumberofquestions(listOfUserBlockQuestions.size());
			userBlockDTO.setNumberofanswered(0);
			userBlockDTO.setNumberofok(0);
			userBlockPersistence.insert(userBlockDTO, mongoDatastore);	
			
			if (userBlockDTO.getValidfrom().before(new java.util.Date()))
				listOfUserVisibleBlocks.add((clearSensitiveData) ? userBlockDTO.clearSensitiveInformation() : userBlockDTO);
		}
					
		if (listOfUserVisibleBlocks.isEmpty())
			return  RestServiceDTO.SuccessDTO;
		
		return listOfUserVisibleBlocks;
	}
	
	private String[] pickAQuestionSet(List<String> listOfQuestions, String userOrSessionId)
	{
		if (listOfQuestions == null || listOfQuestions.size() == 0)
		{
			return null;	
		}
		
		int questionSetIndex = 0;
		if (userOrSessionId.startsWith("USR0"))
		{
			try
			{
				questionSetIndex = Integer.parseInt(userOrSessionId.substring(4)) % listOfQuestions.size();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		String[] arrOfQuestionsId = listOfQuestions.get(questionSetIndex).split(",");
		return arrOfQuestionsId;
	}

}
