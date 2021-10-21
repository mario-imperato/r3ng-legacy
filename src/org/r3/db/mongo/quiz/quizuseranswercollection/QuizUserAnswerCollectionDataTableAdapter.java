//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizuseranswercollection;

public class QuizUserAnswerCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public QuizUserAnswerCollectionDataTableAdapter()
  {
  }

  public QuizUserAnswerCollectionDataTableAdapter(java.util.List<QuizUserAnswerCollectionDTO> l, String asEcho)
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
  
  private java.util.List<QuizUserAnswerCollectionDTO> aaData;
	
	public java.util.List<QuizUserAnswerCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<QuizUserAnswerCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
