//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.usercollection;

public class UserCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public UserCollectionDataTableAdapter()
  {
  }

  public UserCollectionDataTableAdapter(java.util.List<UserCollectionDTO> l, String asEcho)
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
  
  private java.util.List<UserCollectionDTO> aaData;
	
	public java.util.List<UserCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<UserCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
