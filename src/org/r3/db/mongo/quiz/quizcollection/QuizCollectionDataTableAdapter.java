//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.quiz.quizcollection;

public class QuizCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public QuizCollectionDataTableAdapter()
  {
  }

  public QuizCollectionDataTableAdapter(java.util.List<QuizCollectionDTO> l, String asEcho)
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
  
  private java.util.List<QuizCollectionDTO> aaData;
	
	public java.util.List<QuizCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<QuizCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
