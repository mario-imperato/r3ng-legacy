//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.postcommentcollection;

public class PostCommentCollectionDataTableAdapter extends org.r3.db.utils.DataTableAdapter
{
  public PostCommentCollectionDataTableAdapter()
  {
  }

  public PostCommentCollectionDataTableAdapter(java.util.List<PostCommentCollectionDTO> l, String asEcho)
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
  
  private java.util.List<PostCommentCollectionDTO> aaData;
	
	public java.util.List<PostCommentCollectionDTO> getAaData() 
	{
		return aaData;
	}
	
	public void setAaData(java.util.List<PostCommentCollectionDTO> aaData) 
	{
		this.aaData = aaData;
	}

}
  
