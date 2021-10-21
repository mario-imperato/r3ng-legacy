//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.filecollection;

public class FileCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public FileCollectionDataTableAdapter()
  {
  }

  public FileCollectionDataTableAdapter(java.util.List<FileCollectionDTO> l, String asEcho)
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
  
  private java.util.List<FileCollectionDTO> aaData;
	
	public java.util.List<FileCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<FileCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
