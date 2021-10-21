//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizcollection;

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
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbQuizCollectionName = "r3_quizcollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbQuizCollectionName, noClassnameStored=true)
public class QuizCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String QUIZID = "_id";
  public static final String MODE = "mode";
  public static final String USEWEIGHT = "useweight";
  public static final String TITLE = "title";
  public static final String DESCRIPTION = "description";
  public static final String SCORE_COMMENT = "score_comment";
  public static final String SCORE_COMMENT_i = "score_comment.%d";
  public static final String QUIZBLOCKS = "quizblocks";
  public static final String QUIZBLOCKS_i = "quizblocks.%d";
  public static final String QUESTIONS = "questions";
  public static final String QUESTIONS_i = "questions.%d";

	public static final String[] SIMPLETYPE_ATTRIBUTES_CSVLIST;

  	static
  	{
  		SIMPLETYPE_ATTRIBUTES_CSVLIST = new String[5];
		
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[0] = QUIZID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[1] = MODE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[2] = USEWEIGHT;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[3] = TITLE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[4] = DESCRIPTION;	
  	}
  
  @Id
  protected java.lang.String  quizid;
  
  public java.lang.String   getQuizid()         
  { 
     return quizid; 
  }

  public void setQuizid(java.lang.String  p)         
  { 
     quizid = p; 
  }

  public void unsetQuizid4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext )
  {
	  quizid = (java.lang.String)null;
	  anUpdateContext.unset(QUIZID);
  } 

  public void setQuizid4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  quizid = p;
	  anUpdateContext.set(QUIZID, p);
  }    
    
  //
  protected java.lang.String  mode;
  
  public java.lang.String   getMode()         
  { 
     return mode; 
  }

  public void setMode(java.lang.String  p)         
  { 
     mode = p; 
  }

  public void unsetMode4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext )
  {
	  mode = (java.lang.String)null;
	  anUpdateContext.unset(MODE);
  } 

  public void setMode4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  mode = p;
	  anUpdateContext.set(MODE, p);
  }    
    
  //
  protected boolean  useweight;
  

    
  public boolean isUseweight()
{
	return useweight;
}

public void setUseweight(boolean useweight)
{
	this.useweight = useweight;
}

//
  protected java.lang.String  title;
  
  public java.lang.String   getTitle()         
  { 
     return title; 
  }

  public void setTitle(java.lang.String  p)         
  { 
     title = p; 
  }

  public void unsetTitle4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext )
  {
	  title = (java.lang.String)null;
	  anUpdateContext.unset(TITLE);
  } 

  public void setTitle4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  title = p;
	  anUpdateContext.set(TITLE, p);
  }    
    
  //
  protected java.lang.String  description;
  
  public java.lang.String   getDescription()         
  { 
     return description; 
  }

  public void setDescription(java.lang.String  p)         
  { 
     description = p; 
  }

  public void unsetDescription4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext )
  {
	  description = (java.lang.String)null;
	  anUpdateContext.unset(DESCRIPTION);
  } 

  public void setDescription4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  description = p;
	  anUpdateContext.set(DESCRIPTION, p);
  }    
    
  @Embedded
  protected List<Score_commentDTO>  score_comment;
  
  public List<Score_commentDTO>   getScore_comment()         
  { 
     return score_comment; 
  }

  public void setScore_comment(List<Score_commentDTO>  p)         
  { 
     score_comment = p; 
  }
  
  public void addScore_comment(Score_commentDTO  p)
  {
	  if (score_comment == null)
		  score_comment = new ArrayList<Score_commentDTO>();
		
	  score_comment.add(p);      
  }
    

  public void unsetScore_comment4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext )
  {
	  score_comment = (List<Score_commentDTO>)null;
	  anUpdateContext.unset(SCORE_COMMENT);
  } 

  public void setScore_comment4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , List<Score_commentDTO>  p)
  {
	  score_comment = p;
	  anUpdateContext.set(SCORE_COMMENT, p);
  }

  public void setScore_comment4UpdateV(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , Score_commentDTO...  varargsp)
  {
      for(Score_commentDTO p : varargsp)
	  {
		  addScore_comment(p);
	  }
	  
	  anUpdateContext.set(SCORE_COMMENT, varargsp);
  }
      
  public void setScore_comment4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, Score_commentDTO p)
  {
	  if (score_comment == null || score_comment.size() <= i)
		  addScore_comment4Update(anUpdateContext, p);
	  else
	  {
		  score_comment.remove(i);
		  score_comment.add(i, p);
		  anUpdateContext.set(String.format(SCORE_COMMENT_i, i), p);
	  }
  }

  public void add2setScore_comment4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , Score_commentDTO  p)
  {
	  if (score_comment == null)
		  addScore_comment4Update(anUpdateContext , p);
		
	  if (!score_comment.contains(p))
      {
         score_comment.add(p);      
         anUpdateContext.add(SCORE_COMMENT, p, false);
  	  }
  }
  
  public void addScore_comment4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , Score_commentDTO  p)
  {
	  if (score_comment == null)
		  score_comment = new ArrayList<Score_commentDTO>();
		
	  score_comment.add(p);
      anUpdateContext.add(SCORE_COMMENT, p);
  }
  
    
  @Embedded
  protected List<QuizblocksDTO>  quizblocks;
  
  public List<QuizblocksDTO>   getQuizblocks()         
  { 
     return quizblocks; 
  }

  public void setQuizblocks(List<QuizblocksDTO>  p)         
  { 
     quizblocks = p; 
  }
  
  public void addQuizblocks(QuizblocksDTO  p)
  {
	  if (quizblocks == null)
		  quizblocks = new ArrayList<QuizblocksDTO>();
		
	  quizblocks.add(p);      
  }
    

  public void unsetQuizblocks4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext )
  {
	  quizblocks = (List<QuizblocksDTO>)null;
	  anUpdateContext.unset(QUIZBLOCKS);
  } 

  public void setQuizblocks4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , List<QuizblocksDTO>  p)
  {
	  quizblocks = p;
	  anUpdateContext.set(QUIZBLOCKS, p);
  }

  public void setQuizblocks4UpdateV(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , QuizblocksDTO...  varargsp)
  {
      for(QuizblocksDTO p : varargsp)
	  {
		  addQuizblocks(p);
	  }
	  
	  anUpdateContext.set(QUIZBLOCKS, varargsp);
  }
      
  public void setQuizblocks4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, QuizblocksDTO p)
  {
	  if (quizblocks == null || quizblocks.size() <= i)
		  addQuizblocks4Update(anUpdateContext, p);
	  else
	  {
		  quizblocks.remove(i);
		  quizblocks.add(i, p);
		  anUpdateContext.set(String.format(QUIZBLOCKS_i, i), p);
	  }
  }

  public void add2setQuizblocks4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , QuizblocksDTO  p)
  {
	  if (quizblocks == null)
		  addQuizblocks4Update(anUpdateContext , p);
		
	  if (!quizblocks.contains(p))
      {
         quizblocks.add(p);      
         anUpdateContext.add(QUIZBLOCKS, p, false);
  	  }
  }
  
  public void addQuizblocks4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , QuizblocksDTO  p)
  {
	  if (quizblocks == null)
		  quizblocks = new ArrayList<QuizblocksDTO>();
		
	  quizblocks.add(p);
      anUpdateContext.add(QUIZBLOCKS, p);
  }
  
    
  //
  protected List<java.lang.String>  questions;
  
  public List<java.lang.String>   getQuestions()         
  { 
     return questions; 
  }

  public void setQuestions(List<java.lang.String>  p)         
  { 
     questions = p; 
  }
  
  public void addQuestions(java.lang.String  p)
  {
	  if (questions == null)
		  questions = new ArrayList<java.lang.String>();
		
	  questions.add(p);      
  }
    

  public void unsetQuestions4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext )
  {
	  questions = (List<java.lang.String>)null;
	  anUpdateContext.unset(QUESTIONS);
  } 

  public void setQuestions4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , List<java.lang.String>  p)
  {
	  questions = p;
	  anUpdateContext.set(QUESTIONS, p);
  }

  public void setQuestions4UpdateV(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , java.lang.String...  varargsp)
  {
      for(java.lang.String p : varargsp)
	  {
		  addQuestions(p);
	  }
	  
	  anUpdateContext.set(QUESTIONS, varargsp);
  }
      
  public void setQuestions4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, java.lang.String p)
  {
	  if (questions == null || questions.size() <= i)
		  addQuestions4Update(anUpdateContext, p);
	  else
	  {
		  questions.remove(i);
		  questions.add(i, p);
		  anUpdateContext.set(String.format(QUESTIONS_i, i), p);
	  }
  }

  public void add2setQuestions4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (questions == null)
		  addQuestions4Update(anUpdateContext , p);
		
	  if (!questions.contains(p))
      {
         questions.add(p);      
         anUpdateContext.add(QUESTIONS, p, false);
  	  }
  }
  
  public void addQuestions4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (questions == null)
		  questions = new ArrayList<java.lang.String>();
		
	  questions.add(p);
      anUpdateContext.add(QUESTIONS, p);
  }
  
    
 

  public static final String SCORE_COMMENT_SCORE_LEVEL = "score_comment.score_level";
  public static final String SCORE_COMMENT_i_SCORE_LEVEL = "score_comment.%d.score_level";
  public static final String SCORE_COMMENT_SCORE_COMMENT = "score_comment.score_comment";
  public static final String SCORE_COMMENT_i_SCORE_COMMENT = "score_comment.%d.score_comment";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class Score_commentDTO
  {
  //
  private int  score_level;

  public int   getScore_level()         
  { 
     return score_level; 
  }

  public void setScore_level(int  p)         
  { 
     score_level = p; 
  }

  public void unsetScore_comment_i_score_level4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i)
  {
	  score_level = 0;
	  anUpdateContext.unset(String.format(SCORE_COMMENT_i_SCORE_LEVEL, i));
  } 

  public void setScore_comment_i_score_level4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, int  p)
  {
	  score_level = p;
	  anUpdateContext.set(String.format(SCORE_COMMENT_i_SCORE_LEVEL, i), p);
  }  
  
  //
  private java.lang.String  score_comment;

  public java.lang.String   getScore_comment()         
  { 
     return score_comment; 
  }

  public void setScore_comment(java.lang.String  p)         
  { 
     score_comment = p; 
  }

  public void unsetScore_comment_i_score_comment4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i)
  {
	  score_comment = (java.lang.String)null;
	  anUpdateContext.unset(String.format(SCORE_COMMENT_i_SCORE_COMMENT, i));
  } 

  public void setScore_comment_i_score_comment4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  score_comment = p;
	  anUpdateContext.set(String.format(SCORE_COMMENT_i_SCORE_COMMENT, i), p);
  }    
  

  }    
  

  public static final String QUIZBLOCKS_BLOCKNUMBER = "quizblocks.blocknumber";
  public static final String QUIZBLOCKS_i_BLOCKNUMBER = "quizblocks.%d.blocknumber";
  public static final String QUIZBLOCKS_LATEANSWERPENALTY = "quizblocks.lateanswerpenalty";
  public static final String QUIZBLOCKS_i_LATEANSWERPENALTY = "quizblocks.%d.lateanswerpenalty";
  public static final String QUIZBLOCKS_SIZE = "quizblocks.size";
  public static final String QUIZBLOCKS_i_SIZE = "quizblocks.%d.size";
  public static final String QUIZBLOCKS_DURATION = "quizblocks.duration";
  public static final String QUIZBLOCKS_i_DURATION = "quizblocks.%d.duration";
  public static final String QUIZBLOCKS_VALIDFROM = "quizblocks.validfrom";
  public static final String QUIZBLOCKS_i_VALIDFROM = "quizblocks.%d.validfrom";
  public static final String QUIZBLOCKS_VALIDTO = "quizblocks.validto";
  public static final String QUIZBLOCKS_i_VALIDTO = "quizblocks.%d.validto";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class QuizblocksDTO
  {
  //
  private int  blocknumber;

  public int   getBlocknumber()         
  { 
     return blocknumber; 
  }

  public void setBlocknumber(int  p)         
  { 
     blocknumber = p; 
  }

  public void unsetQuizblocks_i_blocknumber4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i)
  {
	  blocknumber = 0;
	  anUpdateContext.unset(String.format(QUIZBLOCKS_i_BLOCKNUMBER, i));
  } 

  public void setQuizblocks_i_blocknumber4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, int  p)
  {
	  blocknumber = p;
	  anUpdateContext.set(String.format(QUIZBLOCKS_i_BLOCKNUMBER, i), p);
  }  
  
  //
  private int  lateanswerpenalty;

  public int   getLateanswerpenalty()         
  { 
     return lateanswerpenalty; 
  }

  public void setLateanswerpenalty(int  p)         
  { 
     lateanswerpenalty = p; 
  }

  public void unsetQuizblocks_i_lateanswerpenalty4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i)
  {
	  lateanswerpenalty = 0;
	  anUpdateContext.unset(String.format(QUIZBLOCKS_i_LATEANSWERPENALTY, i));
  } 

  public void setQuizblocks_i_lateanswerpenalty4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, int  p)
  {
	  lateanswerpenalty = p;
	  anUpdateContext.set(String.format(QUIZBLOCKS_i_LATEANSWERPENALTY, i), p);
  }  
  
  //
  private int  size;

  public int   getSize()         
  { 
     return size; 
  }

  public void setSize(int  p)         
  { 
     size = p; 
  }

  public void unsetQuizblocks_i_size4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i)
  {
	  size = 0;
	  anUpdateContext.unset(String.format(QUIZBLOCKS_i_SIZE, i));
  } 

  public void setQuizblocks_i_size4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, int  p)
  {
	  size = p;
	  anUpdateContext.set(String.format(QUIZBLOCKS_i_SIZE, i), p);
  }  
  
  //
  private int  duration;

  public int   getDuration()         
  { 
     return duration; 
  }

  public void setDuration(int  p)         
  { 
     duration = p; 
  }

  public void unsetQuizblocks_i_duration4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i)
  {
	  duration = 0;
	  anUpdateContext.unset(String.format(QUIZBLOCKS_i_DURATION, i));
  } 

  public void setQuizblocks_i_duration4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, int  p)
  {
	  duration = p;
	  anUpdateContext.set(String.format(QUIZBLOCKS_i_DURATION, i), p);
  }  
  
  //
  private java.util.Date  validfrom;

  public java.util.Date   getValidfrom()         
  { 
     return validfrom; 
  }

  public void setValidfrom(java.util.Date  p)         
  { 
     validfrom = p; 
  }

  public void unsetQuizblocks_i_validfrom4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i)
  {
	  validfrom = (java.util.Date)null;
	  anUpdateContext.unset(String.format(QUIZBLOCKS_i_VALIDFROM, i));
  } 
  
  public void setQuizblocks_i_validfrom4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, java.util.Date  p)
  {
	  validfrom = p;
	  anUpdateContext.set(String.format(QUIZBLOCKS_i_VALIDFROM, i), p);
  }    
  
  //
  private java.util.Date  validto;

  public java.util.Date   getValidto()         
  { 
     return validto; 
  }

  public void setValidto(java.util.Date  p)         
  { 
     validto = p; 
  }

  public void unsetQuizblocks_i_validto4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i)
  {
	  validto = (java.util.Date)null;
	  anUpdateContext.unset(String.format(QUIZBLOCKS_i_VALIDTO, i));
  } 
  
  public void setQuizblocks_i_validto4Update(UpdateOperations<? extends QuizCollectionDTOBase> anUpdateContext , int i, java.util.Date  p)
  {
	  validto = p;
	  anUpdateContext.set(String.format(QUIZBLOCKS_i_VALIDTO, i), p);
  }    
  

  }    
  
  
}
