//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizuserblockcollection;

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
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbQuizUserBlockCollectionName = "r3_quizuserblockcollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbQuizUserBlockCollectionName, noClassnameStored=true)
public class QuizUserBlockCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String QUIZUSERBLOCKNUMBER = "_id";
  public static final String QUIZID = "quizid";
  public static final String USERSESSIONID = "usersessionid";
  public static final String BLOCKNUMBER = "blocknumber";
  public static final String STATUS = "status";
  public static final String VALIDFROM = "validfrom";
  public static final String VALIDTO = "validto";
  public static final String DURATION = "duration";
  public static final String LATEANSWERPENALTY = "lateanswerpenalty";
  public static final String USERSTARTDATE = "userstartdate";
  public static final String USERTIMER = "usertimer";
  public static final String SCORE = "score";
  public static final String LASTANSWERDATE = "lastanswerdate";
  public static final String LASTANSWERQUESTION = "lastanswerquestion";
  public static final String USERLATEANSWERPENALTY = "userlateanswerpenalty";
  public static final String NUMBEROFQUESTIONS = "numberofquestions";
  public static final String NUMBEROFANSWERED = "numberofanswered";
  public static final String NUMBEROFOK = "numberofok";
  public static final String QUESTIONS = "questions";
  public static final String QUESTIONS_i = "questions.%d";

	public static final String[] SIMPLETYPE_ATTRIBUTES_CSVLIST;

  	static
  	{
  		SIMPLETYPE_ATTRIBUTES_CSVLIST = new String[18];
		
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[0] = QUIZUSERBLOCKNUMBER;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[1] = QUIZID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[2] = USERSESSIONID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[3] = BLOCKNUMBER;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[4] = STATUS;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[5] = VALIDFROM;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[6] = VALIDTO;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[7] = DURATION;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[8] = LATEANSWERPENALTY;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[9] = USERSTARTDATE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[10] = USERTIMER;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[11] = SCORE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[12] = LASTANSWERDATE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[13] = LASTANSWERQUESTION;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[14] = USERLATEANSWERPENALTY;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[15] = NUMBEROFQUESTIONS;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[16] = NUMBEROFANSWERED;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[17] = NUMBEROFOK;	
  	}
  
  @Id
  protected java.lang.String  quizuserblocknumber;
  
  public java.lang.String   getQuizuserblocknumber()         
  { 
     return quizuserblocknumber; 
  }

  public void setQuizuserblocknumber(java.lang.String  p)         
  { 
     quizuserblocknumber = p; 
  }

  public void unsetQuizuserblocknumber4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  quizuserblocknumber = (java.lang.String)null;
	  anUpdateContext.unset(QUIZUSERBLOCKNUMBER);
  } 

  public void setQuizuserblocknumber4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  quizuserblocknumber = p;
	  anUpdateContext.set(QUIZUSERBLOCKNUMBER, p);
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

  public void unsetQuizid4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  quizid = (java.lang.String)null;
	  anUpdateContext.unset(QUIZID);
  } 

  public void setQuizid4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetUsersessionid4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  usersessionid = (java.lang.String)null;
	  anUpdateContext.unset(USERSESSIONID);
  } 

  public void setUsersessionid4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  usersessionid = p;
	  anUpdateContext.set(USERSESSIONID, p);
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

  public void unsetBlocknumber4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  blocknumber = 0;
	  anUpdateContext.unset(BLOCKNUMBER);
  } 

  public void setBlocknumber4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  blocknumber = p;
	  anUpdateContext.set(BLOCKNUMBER, p);
  }  
    
  //
  protected java.lang.String  status;
  
  public java.lang.String   getStatus()         
  { 
     return status; 
  }

  public void setStatus(java.lang.String  p)         
  { 
     status = p; 
  }

  public void unsetStatus4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  status = (java.lang.String)null;
	  anUpdateContext.unset(STATUS);
  } 

  public void setStatus4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  status = p;
	  anUpdateContext.set(STATUS, p);
  }    
    
  //
  protected java.util.Date  validfrom;
  
  public java.util.Date   getValidfrom()         
  { 
     return validfrom; 
  }

  public void setValidfrom(java.util.Date  p)         
  { 
     validfrom = p; 
  }

  public void unsetValidfrom4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  validfrom = (java.util.Date)null;
	  anUpdateContext.unset(VALIDFROM);
  } 
  
  public void setValidfrom4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  validfrom = p;
	  anUpdateContext.set(VALIDFROM, p);
  }    
    
  //
  protected java.util.Date  validto;
  
  public java.util.Date   getValidto()         
  { 
     return validto; 
  }

  public void setValidto(java.util.Date  p)         
  { 
     validto = p; 
  }

  public void unsetValidto4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  validto = (java.util.Date)null;
	  anUpdateContext.unset(VALIDTO);
  } 
  
  public void setValidto4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  validto = p;
	  anUpdateContext.set(VALIDTO, p);
  }    
    
  //
  protected int  duration;
  
  public int   getDuration()         
  { 
     return duration; 
  }

  public void setDuration(int  p)         
  { 
     duration = p; 
  }

  public void unsetDuration4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  duration = 0;
	  anUpdateContext.unset(DURATION);
  } 

  public void setDuration4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  duration = p;
	  anUpdateContext.set(DURATION, p);
  }  
    
  //
  protected int  lateanswerpenalty;
  
  public int   getLateanswerpenalty()         
  { 
     return lateanswerpenalty; 
  }

  public void setLateanswerpenalty(int  p)         
  { 
     lateanswerpenalty = p; 
  }

  public void unsetLateanswerpenalty4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  lateanswerpenalty = 0;
	  anUpdateContext.unset(LATEANSWERPENALTY);
  } 

  public void setLateanswerpenalty4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  lateanswerpenalty = p;
	  anUpdateContext.set(LATEANSWERPENALTY, p);
  }  
    
  //
  protected java.util.Date  userstartdate;
  
  public java.util.Date   getUserstartdate()         
  { 
     return userstartdate; 
  }

  public void setUserstartdate(java.util.Date  p)         
  { 
     userstartdate = p; 
  }

  public void unsetUserstartdate4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  userstartdate = (java.util.Date)null;
	  anUpdateContext.unset(USERSTARTDATE);
  } 
  
  public void setUserstartdate4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  userstartdate = p;
	  anUpdateContext.set(USERSTARTDATE, p);
  }    
    
  //
  protected int  usertimer;
  
  public int   getUsertimer()         
  { 
     return usertimer; 
  }

  public void setUsertimer(int  p)         
  { 
     usertimer = p; 
  }

  public void unsetUsertimer4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  usertimer = 0;
	  anUpdateContext.unset(USERTIMER);
  } 

  public void setUsertimer4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  usertimer = p;
	  anUpdateContext.set(USERTIMER, p);
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

  public void unsetScore4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  score = 0;
	  anUpdateContext.unset(SCORE);
  } 

  public void setScore4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  score = p;
	  anUpdateContext.set(SCORE, p);
  }  
    
  //
  protected java.util.Date  lastanswerdate;
  
  public java.util.Date   getLastanswerdate()         
  { 
     return lastanswerdate; 
  }

  public void setLastanswerdate(java.util.Date  p)         
  { 
     lastanswerdate = p; 
  }

  public void unsetLastanswerdate4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  lastanswerdate = (java.util.Date)null;
	  anUpdateContext.unset(LASTANSWERDATE);
  } 
  
  public void setLastanswerdate4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  lastanswerdate = p;
	  anUpdateContext.set(LASTANSWERDATE, p);
  }    
    
  //
  protected java.lang.String  lastanswerquestion;
  
  public java.lang.String   getLastanswerquestion()         
  { 
     return lastanswerquestion; 
  }

  public void setLastanswerquestion(java.lang.String  p)         
  { 
     lastanswerquestion = p; 
  }

  public void unsetLastanswerquestion4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  lastanswerquestion = (java.lang.String)null;
	  anUpdateContext.unset(LASTANSWERQUESTION);
  } 

  public void setLastanswerquestion4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  lastanswerquestion = p;
	  anUpdateContext.set(LASTANSWERQUESTION, p);
  }    
    
  //
  protected int  userlateanswerpenalty;
  
  public int   getUserlateanswerpenalty()         
  { 
     return userlateanswerpenalty; 
  }

  public void setUserlateanswerpenalty(int  p)         
  { 
     userlateanswerpenalty = p; 
  }

  public void unsetUserlateanswerpenalty4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  userlateanswerpenalty = 0;
	  anUpdateContext.unset(USERLATEANSWERPENALTY);
  } 

  public void setUserlateanswerpenalty4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  userlateanswerpenalty = p;
	  anUpdateContext.set(USERLATEANSWERPENALTY, p);
  }  
    
  //
  protected int  numberofquestions;
  
  public int   getNumberofquestions()         
  { 
     return numberofquestions; 
  }

  public void setNumberofquestions(int  p)         
  { 
     numberofquestions = p; 
  }

  public void unsetNumberofquestions4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  numberofquestions = 0;
	  anUpdateContext.unset(NUMBEROFQUESTIONS);
  } 

  public void setNumberofquestions4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  numberofquestions = p;
	  anUpdateContext.set(NUMBEROFQUESTIONS, p);
  }  
    
  //
  protected int  numberofanswered;
  
  public int   getNumberofanswered()         
  { 
     return numberofanswered; 
  }

  public void setNumberofanswered(int  p)         
  { 
     numberofanswered = p; 
  }

  public void unsetNumberofanswered4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  numberofanswered = 0;
	  anUpdateContext.unset(NUMBEROFANSWERED);
  } 

  public void setNumberofanswered4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  numberofanswered = p;
	  anUpdateContext.set(NUMBEROFANSWERED, p);
  }  
    
  //
  protected int  numberofok;
  
  public int   getNumberofok()         
  { 
     return numberofok; 
  }

  public void setNumberofok(int  p)         
  { 
     numberofok = p; 
  }

  public void unsetNumberofok4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  numberofok = 0;
	  anUpdateContext.unset(NUMBEROFOK);
  } 

  public void setNumberofok4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int  p)
  {
	  numberofok = p;
	  anUpdateContext.set(NUMBEROFOK, p);
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
    

  public void unsetQuestions4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext )
  {
	  questions = (List<java.lang.String>)null;
	  anUpdateContext.unset(QUESTIONS);
  } 

  public void setQuestions4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , List<java.lang.String>  p)
  {
	  questions = p;
	  anUpdateContext.set(QUESTIONS, p);
  }

  public void setQuestions4UpdateV(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.lang.String...  varargsp)
  {
      for(java.lang.String p : varargsp)
	  {
		  addQuestions(p);
	  }
	  
	  anUpdateContext.set(QUESTIONS, varargsp);
  }
      
  public void setQuestions4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , int i, java.lang.String p)
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

  public void add2setQuestions4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (questions == null)
		  addQuestions4Update(anUpdateContext , p);
		
	  if (!questions.contains(p))
      {
         questions.add(p);      
         anUpdateContext.add(QUESTIONS, p, false);
  	  }
  }
  
  public void addQuestions4Update(UpdateOperations<? extends QuizUserBlockCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (questions == null)
		  questions = new ArrayList<java.lang.String>();
		
	  questions.add(p);
      anUpdateContext.add(QUESTIONS, p);
  }
  
    
 
  
}
