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
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionPersistence;
import org.r3.db.mongo.quiz.quizuserblockcollection.QuizUserBlockCollectionDTO.BlockStatusType;
import org.r3.db.system.user.userprofileview.UserProfileViewDTO;
import org.r3.system.AuthFunction;
import org.r3.system.rest.RestServiceDTO;
import org.r3.system.rest.ServiceEnvironment;
import org.r3.system.rest.ServicePattern;

public class GETVisibleUserBlocks extends ServicePattern
{
    private String quizId;
    
	public GETVisibleUserBlocks(ServletContext ctx,  ServiceEnvironment serviceEnvironment, String aQuizId)
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
		
		boolean clearSensitiveData = true;
		if (senv.getUserProfile().isInRole(senv.getRequestSiteId(), new AuthFunction("quizmanager")))
		{
			clearSensitiveData = false;
		}
		
		QuizCollectionDTO quizdto = quizpersistence.selectBySiteQuizid(mongoDatastore, senv.getRequestSiteId(), quizId);
		if (quizdto == null)
		{
			return RestServiceDTO.FailDTO;
		}

		List<QuizUserBlockCollectionDTO> listOfUserVisibleBlocks = null;
		String userOrSessionId = senv.getAuthInfo().getUserIdOrUserSessionId();
		QuizUserBlockCollectionPersistence userBlockPersistence = QuizUserBlockCollectionPersistence.createPersistenceObject(mctx);
		List<QuizUserBlockCollectionDTO> listOfUserBlockDTO = userBlockPersistence.selectByQuizidUser(mongoDatastore, quizId, userOrSessionId);
		if (listOfUserBlockDTO == null || listOfUserBlockDTO.isEmpty())
		{
			return new RestServiceDTO(RestServiceDTO.Status.fail, "QNOBLOCKS", "User Not Enrolled");
		}
		
		java.util.Date nowDate = new java.util.Date();
		listOfUserVisibleBlocks = new ArrayList<QuizUserBlockCollectionDTO>();
		for(QuizUserBlockCollectionDTO quizUserBlockDto : listOfUserBlockDTO)
		{
			if (quizUserBlockDto.getValidfrom().before(new java.util.Date()))
				listOfUserVisibleBlocks.add((clearSensitiveData) ? quizUserBlockDto.clearSensitiveInformation() : quizUserBlockDto);
			
			if (quizUserBlockDto.isStarted())
			{
				long userTimer = quizUserBlockDto.computeUserTimer(nowDate);
				
				// Debbo Procedere con update
				UpdateOperations<QuizUserBlockCollectionDTO> userBlockUpdateContext = mongoDatastore.createUpdateOperations(QuizUserBlockCollectionDTO.class);	
				quizUserBlockDto.setUsertimer4Update(userBlockUpdateContext, (int)userTimer);
				if (quizUserBlockDto.isTimeout(userTimer))
				{
					quizUserBlockDto.setStatus4Update(userBlockUpdateContext, BlockStatusType.timeout.toString());					
				}
				
				userBlockPersistence.updateByQuizuserblocknumber(mongoDatastore, userBlockUpdateContext, quizUserBlockDto.getQuizuserblocknumber(), false);
			}
		}
				
		return listOfUserVisibleBlocks;
	}
	
	

}
