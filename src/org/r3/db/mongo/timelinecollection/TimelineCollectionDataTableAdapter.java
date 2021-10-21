//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.timelinecollection;

public class TimelineCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public TimelineCollectionDataTableAdapter()
  {
  }

  public TimelineCollectionDataTableAdapter(java.util.List<TimelineCollectionDTO> l, String asEcho)
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
  
  private java.util.List<TimelineCollectionDTO> aaData;
	
	public java.util.List<TimelineCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<TimelineCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
