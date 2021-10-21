//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.timelinecollection;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.utils.MongoUtils;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbTimelineCollectionName = "r3_timelinecollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbTimelineCollectionName, noClassnameStored=true)
public class TimelineCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String TIMELINEID = "_id";
  public static final String SITE = "site";
  public static final String TITLE = "title";
  public static final String DESCRIPTION = "description";
  public static final String TIMELINETYPE = "timelinetype";
  public static final String CREATIONDATE = "creationdate";
  public static final String LASTMODIFIED = "lastmodified";
  public static final String ALLOWEDCONTENT = "allowedcontent";
  public static final String ALLOWEDCONTENT_i = "allowedcontent.%d";

	public static final String[] SIMPLETYPE_ATTRIBUTES_CSVLIST;

  	static
  	{
  		SIMPLETYPE_ATTRIBUTES_CSVLIST = new String[7];
		
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[0] = TIMELINEID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[1] = SITE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[2] = TITLE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[3] = DESCRIPTION;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[4] = TIMELINETYPE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[5] = CREATIONDATE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[6] = LASTMODIFIED;	
  	}
  
  @Id
  protected org.bson.types.ObjectId  timelineid;
  
  public org.bson.types.ObjectId   getTimelineid()         
  { 
     return timelineid; 
  }

  public void setTimelineid(org.bson.types.ObjectId  p)         
  { 
     timelineid = p; 
  }

  public void setTimelineid(java.lang.String  p)         
  { 
     timelineid = MongoUtils.getObjectIdFromString(p); 
  }
  
  public void setTimelineid4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , org.bson.types.ObjectId  p)
  {
	  timelineid = p;
	  anUpdateContext.set(TIMELINEID, p);
  }    
    
  //
  protected java.lang.String  site;
  
  public java.lang.String   getSite()         
  { 
     return site; 
  }

  public void setSite(java.lang.String  p)         
  { 
     site = p; 
  }

  public void setSite4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  site = p;
	  anUpdateContext.set(SITE, p);
  }    
    
  //
  protected java.lang.String  title;
  
  public java.lang.String   getTitle()         
  { 
     return title; 
  }

  public void setTitle(java.lang.String  p)         
  { 
     title = p; 
  }

  public void setTitle4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  title = p;
	  anUpdateContext.set(TITLE, p);
  }    
    
  //
  protected java.lang.String  description;
  
  public java.lang.String   getDescription()         
  { 
     return description; 
  }

  public void setDescription(java.lang.String  p)         
  { 
     description = p; 
  }

  public void setDescription4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  description = p;
	  anUpdateContext.set(DESCRIPTION, p);
  }    
    
  //
  protected java.lang.String  timelinetype;
  
  public java.lang.String   getTimelinetype()         
  { 
     return timelinetype; 
  }

  public void setTimelinetype(java.lang.String  p)         
  { 
     timelinetype = p; 
  }

  public void setTimelinetype4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  timelinetype = p;
	  anUpdateContext.set(TIMELINETYPE, p);
  }    
    
  //
  protected java.util.Date  creationdate;
  
  public java.util.Date   getCreationdate()         
  { 
     return creationdate; 
  }

  public void setCreationdate(java.util.Date  p)         
  { 
     creationdate = p; 
  }
  
  public void setCreationdate4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  creationdate = p;
	  anUpdateContext.set(CREATIONDATE, p);
  }    
    
  //
  protected java.util.Date  lastmodified;
  
  public java.util.Date   getLastmodified()         
  { 
     return lastmodified; 
  }

  public void setLastmodified(java.util.Date  p)         
  { 
     lastmodified = p; 
  }
  
  public void setLastmodified4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  lastmodified = p;
	  anUpdateContext.set(LASTMODIFIED, p);
  }    
    
  //
  protected List<java.lang.String>  allowedcontent;
  
  public List<java.lang.String>   getAllowedcontent()         
  { 
     return allowedcontent; 
  }

  public void setAllowedcontent(List<java.lang.String>  p)         
  { 
     allowedcontent = p; 
  }
  
  public void addAllowedcontent(java.lang.String  p)
  {
	  if (allowedcontent == null)
		  allowedcontent = new ArrayList<java.lang.String>();
		
	  allowedcontent.add(p);      
  }
    

  public void setAllowedcontent4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , List<java.lang.String>  p)
  {
	  allowedcontent = p;
	  anUpdateContext.set(ALLOWEDCONTENT, p);
  }

  public void setAllowedcontent4UpdateV(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.lang.String...  varargsp)
  {
      for(java.lang.String p : varargsp)
	  {
		  addAllowedcontent(p);
	  }
	  
	  anUpdateContext.set(ALLOWEDCONTENT, varargsp);
  }
      
  public void setAllowedcontent4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , int i, java.lang.String p)
  {
	  if (allowedcontent == null || allowedcontent.size() <= i)
		  addAllowedcontent4Update(anUpdateContext, p);
	  else
	  {
		  allowedcontent.remove(i);
		  allowedcontent.add(i, p);
		  anUpdateContext.set(String.format(ALLOWEDCONTENT_i, i), p);
	  }
  }

  public void add2setAllowedcontent4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (allowedcontent == null)
		  addAllowedcontent4Update(anUpdateContext , p);
		
	  if (!allowedcontent.contains(p))
      {
         allowedcontent.add(p);      
         anUpdateContext.add(ALLOWEDCONTENT, p, false);
  	  }
  }
  
  public void addAllowedcontent4Update(UpdateOperations<? extends TimelineCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (allowedcontent == null)
		  allowedcontent = new ArrayList<java.lang.String>();
		
	  allowedcontent.add(p);
      anUpdateContext.add(ALLOWEDCONTENT, p);
  }
  
    
 
  
}
