//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizquestioncollection;

import org.r3.db.MongoDbSchemaInfo;
import org.mongodb.morphia.annotations.Entity;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbQuizQuestionCollectionName = "r3_quizquestioncollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbQuizQuestionCollectionName, noClassnameStored=true)
public class QuizQuestionCollectionDTO extends QuizQuestionCollectionDTOBase{
	public QuizQuestionCollectionDTO()
    {
        super();
    }

	public QuizQuestionCollectionDTO clearSensitiveInformation()
	{
		if (answers != null && answers.size() > 0)
		{
			for(AnswersDTO dto : answers )
			{
				dto.setValid(false);
			}
		}
		
		return this;
		
	}
	
	public AnswersDTO getAnswer(String answerId)
	{
		if (answers != null)
		{
			for(QuizQuestionCollectionDTOBase.AnswersDTO a : answers)
			{
				if (a.getAnswerid().equalsIgnoreCase(answerId))
					return a;
			}
		}
		
		return null;
	}
}

