package org.r3.db;

public class MongoDbSchemaInfo
{
	public static final String MongoDbName = "regatta3";
	public static final String MongoDbFileStoreCollectionName = "r3_filecollection";
	
	public static final String MongoDbFileCollectionName = "r3_filecollection";
	public static final String MongoDbUserCollectionName = "r3_usercollection";
	public static final String MongoDbSiteCollectionName = "r3_sitecollection";
	public static final String MongoDbPostCollectionName = "r3_postcollection";
	public static final String MongoDbPostCommentCollectionName = "r3_postcommentcollection";
	public static final String MongoDbLUTCollectionName = "r3_lutcollection";
	public static final String MongoDbTimelineCollectionName = "r3_timelinecollection";
	public static final String MongoDbQuizCollectionName = "r3_quizcollection";
	public static final String MongoDbQuizQuestionCollectionName = "r3_quizquestioncollection";
	public static final String MongoDbQuizUserAnswerCollectionName = "r3_quizuseranswers";
	public static final String MongoDbQuizUserBlockCollectionName = "r3_quizuserblockcollection";
	
	public static final String MongoDbFileStoreUrlPattern = "mfs:///%s/%s/%s/%s/%s";

	public MongoDbSchemaInfo()
	{
	}

}
