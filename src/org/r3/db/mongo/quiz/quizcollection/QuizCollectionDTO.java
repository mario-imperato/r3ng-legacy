//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//

package org.r3.db.mongo.quiz.quizcollection;

import org.r3.db.MongoDbSchemaInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.mongodb.morphia.annotations.Entity;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbQuizCollectionName = "r3_quizcollection";
 */
@Entity(value = MongoDbSchemaInfo.MongoDbQuizCollectionName, noClassnameStored = true)
public class QuizCollectionDTO extends QuizCollectionDTOBase
{
	public QuizCollectionDTO()
	{
		super();
	}

	public void clearSensitiveInformation()
	{
		this.questions = null;
		this.quizblocks = null;
	}
	
	@JsonIgnore
	public boolean isOpaque()
	{
		return !mode.equalsIgnoreCase("clear");
	}
}
