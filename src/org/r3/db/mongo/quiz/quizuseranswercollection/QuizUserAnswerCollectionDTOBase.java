//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizuseranswercollection;

import java.util.List;
import java.util.ArrayList;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.utils.MongoUtils;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

import org.r3.db.*;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Transient;
import org.mongodb.morphia.annotations.Serialized;
import org.mongodb.morphia.query.UpdateOperations;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbQuizUserAnswerCollectionName = "r3_quizuseranswers";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbQuizUserAnswerCollectionName, noClassnameStored=true)
public class QuizUserAnswerCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String USERANSWERID = "_id";
  public static final String QUIZID = "quizid";
  public static final String USERSESSIONID = "usersessionid";
  public static final String QUIZUSERBLOCKNUMBER = "quizuserblocknumber";
  public static final String BLOCKNUMBER = "blocknumber";
  public static final String QUESTIONID = "questionid";
  public static final String ANSWERID = "answerid";
  public static final String VALID = "valid";
  public static final String SCORE = "score";
  public static final String WHEN = "when";
  public static final String TIMEOUT = "timeout";

	public static final String[] SIMPLETYPE_ATTRIBUTES_CSVLIST;

  	static
  	{
  		SIMPLETYPE_ATTRIBUTES_CSVLIST = new String[11];
		
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[0] = USERANSWERID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[1] = QUIZID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[2] = USERSESSIONID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[3] = QUIZUSERBLOCKNUMBER;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[4] = BLOCKNUMBER;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[5] = QUESTIONID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[6] = ANSWERID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[7] = VALID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[8] = SCORE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[9] = WHEN;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[10] = TIMEOUT;	
  	}
  
  @Id
  protected org.bson.types.ObjectId  useranswerid;
  
  public org.bson.types.ObjectId   getUseranswerid()         
  { 
     return useranswerid; 
  }

  public void setUseranswerid(org.bson.types.ObjectId  p)         
  { 
     useranswerid = p; 
  }

  public void setUseranswerid(java.lang.String  p)         
  { 
     useranswerid = MongoUtils.getObjectIdFromString(p); 
  }
  
  public void unsetUseranswerid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  useranswerid = (org.bson.types.ObjectId)null;
	  anUpdateContext.unset(USERANSWERID);
  } 
  
  public void setUseranswerid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , org.bson.types.ObjectId  p)
  {
	  useranswerid = p;
	  anUpdateContext.set(USERANSWERID, p);
  }    
    
  //
  protected java.lang.String  quizid;
  
  public java.lang.String   getQuizid()         
  { 
     return quizid; 
  }

  public void setQuizid(java.lang.String  p)         
  { 
     quizid = p; 
  }

  public void unsetQuizid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  quizid = (java.lang.String)null;
	  anUpdateContext.unset(QUIZID);
  } 

  public void setQuizid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  quizid = p;
	  anUpdateContext.set(QUIZID, p);
  }    
    
  //
  protected java.lang.String  usersessionid;
  
  public java.lang.String   getUsersessionid()         
  { 
     return usersessionid; 
  }

  public void setUsersessionid(java.lang.String  p)         
  { 
     usersessionid = p; 
  }

  public void unsetUsersessionid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  usersessionid = (java.lang.String)null;
	  anUpdateContext.unset(USERSESSIONID);
  } 

  public void setUsersessionid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  usersessionid = p;
	  anUpdateContext.set(USERSESSIONID, p);
  }    
    
  //
  protected java.lang.String  quizuserblocknumber;
  
  public java.lang.String   getQuizuserblocknumber()         
  { 
     return quizuserblocknumber; 
  }

  public void setQuizuserblocknumber(java.lang.String  p)         
  { 
     quizuserblocknumber = p; 
  }

  public void unsetQuizuserblocknumber4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  quizuserblocknumber = (java.lang.String)null;
	  anUpdateContext.unset(QUIZUSERBLOCKNUMBER);
  } 

  public void setQuizuserblocknumber4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  quizuserblocknumber = p;
	  anUpdateContext.set(QUIZUSERBLOCKNUMBER, p);
  }    
    
  //
  protected int  blocknumber;
  
  public int   getBlocknumber()         
  { 
     return blocknumber; 
  }

  public void setBlocknumber(int  p)         
  { 
     blocknumber = p; 
  }

  public void unsetBlocknumber4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  blocknumber = 0;
	  anUpdateContext.unset(BLOCKNUMBER);
  } 

  public void setBlocknumber4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , int  p)
  {
	  blocknumber = p;
	  anUpdateContext.set(BLOCKNUMBER, p);
  }  
    
  //
  protected java.lang.String  questionid;
  
  public java.lang.String   getQuestionid()         
  { 
     return questionid; 
  }

  public void setQuestionid(java.lang.String  p)         
  { 
     questionid = p; 
  }

  public void unsetQuestionid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  questionid = (java.lang.String)null;
	  anUpdateContext.unset(QUESTIONID);
  } 

  public void setQuestionid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  questionid = p;
	  anUpdateContext.set(QUESTIONID, p);
  }    
    
  //
  protected java.lang.String  answerid;
  
  public java.lang.String   getAnswerid()         
  { 
     return answerid; 
  }

  public void setAnswerid(java.lang.String  p)         
  { 
     answerid = p; 
  }

  public void unsetAnswerid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  answerid = (java.lang.String)null;
	  anUpdateContext.unset(ANSWERID);
  } 

  public void setAnswerid4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  answerid = p;
	  anUpdateContext.set(ANSWERID, p);
  }    
    
  //
  protected boolean  valid;
  

    
  public boolean isValid()
{
	return valid;
}

public void setValid(boolean valid)
{
	this.valid = valid;
}

//
  protected int  score;
  
  public int   getScore()         
  { 
     return score; 
  }

  public void setScore(int  p)         
  { 
     score = p; 
  }

  public void unsetScore4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  score = 0;
	  anUpdateContext.unset(SCORE);
  } 

  public void setScore4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , int  p)
  {
	  score = p;
	  anUpdateContext.set(SCORE, p);
  }  
    
  //
  protected java.util.Date  when;
  
  public java.util.Date   getWhen()         
  { 
     return when; 
  }

  public void setWhen(java.util.Date  p)         
  { 
     when = p; 
  }

  public void unsetWhen4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext )
  {
	  when = (java.util.Date)null;
	  anUpdateContext.unset(WHEN);
  } 
  
  public void setWhen4Update(UpdateOperations<? extends QuizUserAnswerCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  when = p;
	  anUpdateContext.set(WHEN, p);
  }    
    
  //
  protected boolean  timeout;

public boolean isTimeout()
{
	return timeout;
}

public void setTimeout(boolean timeout)
{
	this.timeout = timeout;
}
  

    
 
  
}
