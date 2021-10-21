//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizquestioncollection;

import java.util.List;
import java.util.ArrayList;
import org.r3.db.MongoDbSchemaInfo;
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
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbQuizQuestionCollectionName = "r3_quizquestioncollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbQuizQuestionCollectionName, noClassnameStored=true)
public class QuizQuestionCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String QUESTIONID = "_id";
  public static final String QUIZID = "quizid";
  public static final String TEXT = "text";
  public static final String QLEVEL = "qlevel";
  public static final String ANSWERS = "answers";
  public static final String ANSWERS_i = "answers.%d";

	public static final String[] SIMPLETYPE_ATTRIBUTES_CSVLIST;

  	static
  	{
  		SIMPLETYPE_ATTRIBUTES_CSVLIST = new String[4];
		
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[0] = QUESTIONID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[1] = QUIZID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[2] = TEXT;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[3] = QLEVEL;	
  	}
  
  @Id
  protected java.lang.String  questionid;
  
  public java.lang.String   getQuestionid()         
  { 
     return questionid; 
  }

  public void setQuestionid(java.lang.String  p)         
  { 
     questionid = p; 
  }

  public void unsetQuestionid4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext )
  {
	  questionid = (java.lang.String)null;
	  anUpdateContext.unset(QUESTIONID);
  } 

  public void setQuestionid4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  questionid = p;
	  anUpdateContext.set(QUESTIONID, p);
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

  public void unsetQuizid4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext )
  {
	  quizid = (java.lang.String)null;
	  anUpdateContext.unset(QUIZID);
  } 

  public void setQuizid4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  quizid = p;
	  anUpdateContext.set(QUIZID, p);
  }    
    
  //
  protected java.lang.String  text;
  
  public java.lang.String   getText()         
  { 
     return text; 
  }

  public void setText(java.lang.String  p)         
  { 
     text = p; 
  }

  public void unsetText4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext )
  {
	  text = (java.lang.String)null;
	  anUpdateContext.unset(TEXT);
  } 

  public void setText4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  text = p;
	  anUpdateContext.set(TEXT, p);
  }    
    
  //
  protected int  qlevel;
  
  public int   getQlevel()         
  { 
     return qlevel; 
  }

  public void setQlevel(int  p)         
  { 
     qlevel = p; 
  }

  public void unsetQlevel4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext )
  {
	  qlevel = 0;
	  anUpdateContext.unset(QLEVEL);
  } 

  public void setQlevel4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , int  p)
  {
	  qlevel = p;
	  anUpdateContext.set(QLEVEL, p);
  }  
    
  @Embedded
  protected List<AnswersDTO>  answers;
  
  public List<AnswersDTO>   getAnswers()         
  { 
     return answers; 
  }

  public void setAnswers(List<AnswersDTO>  p)         
  { 
     answers = p; 
  }
  
  public void addAnswers(AnswersDTO  p)
  {
	  if (answers == null)
		  answers = new ArrayList<AnswersDTO>();
		
	  answers.add(p);      
  }
    

  public void unsetAnswers4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext )
  {
	  answers = (List<AnswersDTO>)null;
	  anUpdateContext.unset(ANSWERS);
  } 

  public void setAnswers4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , List<AnswersDTO>  p)
  {
	  answers = p;
	  anUpdateContext.set(ANSWERS, p);
  }

  public void setAnswers4UpdateV(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , AnswersDTO...  varargsp)
  {
      for(AnswersDTO p : varargsp)
	  {
		  addAnswers(p);
	  }
	  
	  anUpdateContext.set(ANSWERS, varargsp);
  }
      
  public void setAnswers4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , int i, AnswersDTO p)
  {
	  if (answers == null || answers.size() <= i)
		  addAnswers4Update(anUpdateContext, p);
	  else
	  {
		  answers.remove(i);
		  answers.add(i, p);
		  anUpdateContext.set(String.format(ANSWERS_i, i), p);
	  }
  }

  public void add2setAnswers4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , AnswersDTO  p)
  {
	  if (answers == null)
		  addAnswers4Update(anUpdateContext , p);
		
	  if (!answers.contains(p))
      {
         answers.add(p);      
         anUpdateContext.add(ANSWERS, p, false);
  	  }
  }
  
  public void addAnswers4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , AnswersDTO  p)
  {
	  if (answers == null)
		  answers = new ArrayList<AnswersDTO>();
		
	  answers.add(p);
      anUpdateContext.add(ANSWERS, p);
  }
  
    
 

  public static final String ANSWERS_ANSWERID = "answers.answerid";
  public static final String ANSWERS_i_ANSWERID = "answers.%d.answerid";
  public static final String ANSWERS_TEXT = "answers.text";
  public static final String ANSWERS_i_TEXT = "answers.%d.text";
  public static final String ANSWERS_VALID = "answers.valid";
  public static final String ANSWERS_i_VALID = "answers.%d.valid";
  public static final String ANSWERS_WEIGHT = "answers.weight";
  public static final String ANSWERS_i_WEIGHT = "answers.%d.weight";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class AnswersDTO
  {
  //
  private java.lang.String  answerid;

  public java.lang.String   getAnswerid()         
  { 
     return answerid; 
  }

  public void setAnswerid(java.lang.String  p)         
  { 
     answerid = p; 
  }

  public void unsetAnswers_i_answerid4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , int i)
  {
	  answerid = (java.lang.String)null;
	  anUpdateContext.unset(String.format(ANSWERS_i_ANSWERID, i));
  } 

  public void setAnswers_i_answerid4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  answerid = p;
	  anUpdateContext.set(String.format(ANSWERS_i_ANSWERID, i), p);
  }    
  
  //
  private java.lang.String  text;

  public java.lang.String   getText()         
  { 
     return text; 
  }

  public void setText(java.lang.String  p)         
  { 
     text = p; 
  }

  public void unsetAnswers_i_text4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , int i)
  {
	  text = (java.lang.String)null;
	  anUpdateContext.unset(String.format(ANSWERS_i_TEXT, i));
  } 

  public void setAnswers_i_text4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  text = p;
	  anUpdateContext.set(String.format(ANSWERS_i_TEXT, i), p);
  }    
  
  //
  private boolean  valid;
  
  public boolean isValid()
{
	return valid;
}

public void setValid(boolean valid)
{
	this.valid = valid;
}

//
  private int  weight;

  public int   getWeight()         
  { 
     return weight; 
  }

  public void setWeight(int  p)         
  { 
     weight = p; 
  }

  public void unsetAnswers_i_weight4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , int i)
  {
	  weight = 0;
	  anUpdateContext.unset(String.format(ANSWERS_i_WEIGHT, i));
  } 

  public void setAnswers_i_weight4Update(UpdateOperations<? extends QuizQuestionCollectionDTOBase> anUpdateContext , int i, int  p)
  {
	  weight = p;
	  anUpdateContext.set(String.format(ANSWERS_i_WEIGHT, i), p);
  }  
  

  }    
  
  
}
