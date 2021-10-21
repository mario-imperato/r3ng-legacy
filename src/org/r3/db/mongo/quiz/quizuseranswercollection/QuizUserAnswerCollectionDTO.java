//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizuseranswercollection;

import org.r3.db.MongoDbSchemaInfo;
import org.mongodb.morphia.annotations.Entity;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbQuizUserAnswerCollectionName = "r3_quizuseranswers";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbQuizUserAnswerCollectionName, noClassnameStored=true)
public class QuizUserAnswerCollectionDTO extends QuizUserAnswerCollectionDTOBase{
	public QuizUserAnswerCollectionDTO()
    {
        super();
    }
}

