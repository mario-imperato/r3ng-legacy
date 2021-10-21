//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.postcollection;

public class PostCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public PostCollectionDataTableAdapter()
  {
  }

  public PostCollectionDataTableAdapter(java.util.List<PostCollectionDTO> l, String asEcho)
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
  
  private java.util.List<PostCollectionDTO> aaData;
	
	public java.util.List<PostCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<PostCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
