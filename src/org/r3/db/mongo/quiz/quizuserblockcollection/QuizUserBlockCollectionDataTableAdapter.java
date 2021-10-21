//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizuserblockcollection;

public class QuizUserBlockCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public QuizUserBlockCollectionDataTableAdapter()
  {
  }

  public QuizUserBlockCollectionDataTableAdapter(java.util.List<QuizUserBlockCollectionDTO> l, String asEcho)
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
  
  private java.util.List<QuizUserBlockCollectionDTO> aaData;
	
	public java.util.List<QuizUserBlockCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<QuizUserBlockCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
