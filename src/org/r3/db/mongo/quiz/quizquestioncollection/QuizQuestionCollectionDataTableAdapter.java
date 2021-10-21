//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizquestioncollection;

public class QuizQuestionCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public QuizQuestionCollectionDataTableAdapter()
  {
  }

  public QuizQuestionCollectionDataTableAdapter(java.util.List<QuizQuestionCollectionDTO> l, String asEcho)
  {
     setsEcho(asEcho);
	   
	   if (l != null)
	        setiTotalRecords(l.size());
	   else setiTotalRecords(0);
	   
	   if (l != null)	   
	        setiTotalDisplayRecords(l.size());
	   else setiTotalDisplayRecords(0);
	   
	   setAaData(l);
  }
  
  private java.util.List<QuizQuestionCollectionDTO> aaData;
	
	public java.util.List<QuizQuestionCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<QuizQuestionCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
