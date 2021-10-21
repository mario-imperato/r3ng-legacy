//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.postcommentcollection;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.utils.MongoUtils;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbPostCommentCollectionName = "r3_postcommentcollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbPostCommentCollectionName, noClassnameStored=true)
public class PostCommentCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String COMMENTID = "_id";
  public static final String SITE = "site";
  public static final String DOMAIN = "domain";
  public static final String TIMELINE = "timeline";
  public static final String POSTID = "postid";
  public static final String AUTHOR = "author";
  public static final String AUTHORNAME = "authorname";
  public static final String AUTHORTYPE = "authortype";
  public static final String USERID = "userid";
  public static final String SHAKEEVENT = "shakeevent";
  public static final String SHAKEDATE = "shakedate";
  public static final String LASTMODIFIED = "lastmodified";
  public static final String TITLE = "title";
  public static final String GEOLOCATION = "geolocation";
  public static final String CONTENTCATEGORY = "contentcategory";
  public static final String CONTENTCLASS = "contentclass";
  public static final String CONTENT = "content";

	public static final String[] SIMPLETYPE_ATTRIBUTES_CSVLIST;

  	static
  	{
  		SIMPLETYPE_ATTRIBUTES_CSVLIST = new String[16];
		
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[0] = COMMENTID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[1] = SITE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[2] = DOMAIN;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[3] = TIMELINE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[4] = POSTID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[5] = AUTHOR;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[6] = AUTHORNAME;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[7] = AUTHORTYPE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[8] = USERID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[9] = SHAKEEVENT;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[10] = SHAKEDATE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[11] = LASTMODIFIED;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[12] = TITLE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[13] = GEOLOCATION;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[14] = CONTENTCATEGORY;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[15] = CONTENTCLASS;	
  	}
  
  @Id
  protected org.bson.types.ObjectId  commentid;
  
  public org.bson.types.ObjectId   getCommentid()         
  { 
     return commentid; 
  }

  public void setCommentid(org.bson.types.ObjectId  p)         
  { 
     commentid = p; 
  }

  public void setCommentid(java.lang.String  p)         
  { 
     commentid = MongoUtils.getObjectIdFromString(p); 
  }
  
  public void unsetCommentid4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  commentid = (org.bson.types.ObjectId)null;
	  anUpdateContext.unset(COMMENTID);
  } 
  
  public void setCommentid4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , org.bson.types.ObjectId  p)
  {
	  commentid = p;
	  anUpdateContext.set(COMMENTID, p);
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

  public void unsetSite4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  site = (java.lang.String)null;
	  anUpdateContext.unset(SITE);
  } 

  public void setSite4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  site = p;
	  anUpdateContext.set(SITE, p);
  }    
    
  //
  protected java.lang.String  domain;
  
  public java.lang.String   getDomain()         
  { 
     return domain; 
  }

  public void setDomain(java.lang.String  p)         
  { 
     domain = p; 
  }

  public void unsetDomain4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  domain = (java.lang.String)null;
	  anUpdateContext.unset(DOMAIN);
  } 

  public void setDomain4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  domain = p;
	  anUpdateContext.set(DOMAIN, p);
  }    
    
  //
  protected java.lang.String  timeline;
  
  public java.lang.String   getTimeline()         
  { 
     return timeline; 
  }

  public void setTimeline(java.lang.String  p)         
  { 
     timeline = p; 
  }

  public void unsetTimeline4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  timeline = (java.lang.String)null;
	  anUpdateContext.unset(TIMELINE);
  } 

  public void setTimeline4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  timeline = p;
	  anUpdateContext.set(TIMELINE, p);
  }    
    
  //
  protected org.bson.types.ObjectId  postid;
  
  public org.bson.types.ObjectId   getPostid()         
  { 
     return postid; 
  }

  public void setPostid(org.bson.types.ObjectId  p)         
  { 
     postid = p; 
  }

  public void setPostid(java.lang.String  p)         
  { 
     postid = MongoUtils.getObjectIdFromString(p); 
  }
  
  public void unsetPostid4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  postid = (org.bson.types.ObjectId)null;
	  anUpdateContext.unset(POSTID);
  } 
  
  public void setPostid4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , org.bson.types.ObjectId  p)
  {
	  postid = p;
	  anUpdateContext.set(POSTID, p);
  }    
    
  //
  protected java.lang.String  author;
  
  public java.lang.String   getAuthor()         
  { 
     return author; 
  }

  public void setAuthor(java.lang.String  p)         
  { 
     author = p; 
  }

  public void unsetAuthor4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  author = (java.lang.String)null;
	  anUpdateContext.unset(AUTHOR);
  } 

  public void setAuthor4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  author = p;
	  anUpdateContext.set(AUTHOR, p);
  }    
    
  //
  protected java.lang.String  authorname;
  
  public java.lang.String   getAuthorname()         
  { 
     return authorname; 
  }

  public void setAuthorname(java.lang.String  p)         
  { 
     authorname = p; 
  }

  public void unsetAuthorname4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  authorname = (java.lang.String)null;
	  anUpdateContext.unset(AUTHORNAME);
  } 

  public void setAuthorname4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  authorname = p;
	  anUpdateContext.set(AUTHORNAME, p);
  }    
    
  //
  protected java.lang.String  authortype;
  
  public java.lang.String   getAuthortype()         
  { 
     return authortype; 
  }

  public void setAuthortype(java.lang.String  p)         
  { 
     authortype = p; 
  }

  public void unsetAuthortype4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  authortype = (java.lang.String)null;
	  anUpdateContext.unset(AUTHORTYPE);
  } 

  public void setAuthortype4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  authortype = p;
	  anUpdateContext.set(AUTHORTYPE, p);
  }    
    
  //
  protected java.lang.String  userid;
  
  public java.lang.String   getUserid()         
  { 
     return userid; 
  }

  public void setUserid(java.lang.String  p)         
  { 
     userid = p; 
  }

  public void unsetUserid4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  userid = (java.lang.String)null;
	  anUpdateContext.unset(USERID);
  } 

  public void setUserid4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  userid = p;
	  anUpdateContext.set(USERID, p);
  }    
    
  //
  protected org.bson.types.ObjectId  shakeevent;
  
  public org.bson.types.ObjectId   getShakeevent()         
  { 
     return shakeevent; 
  }

  public void setShakeevent(org.bson.types.ObjectId  p)         
  { 
     shakeevent = p; 
  }

  public void setShakeevent(java.lang.String  p)         
  { 
     shakeevent = MongoUtils.getObjectIdFromString(p); 
  }
  
  public void unsetShakeevent4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  shakeevent = (org.bson.types.ObjectId)null;
	  anUpdateContext.unset(SHAKEEVENT);
  } 
  
  public void setShakeevent4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , org.bson.types.ObjectId  p)
  {
	  shakeevent = p;
	  anUpdateContext.set(SHAKEEVENT, p);
  }    
    
  //
  protected java.util.Date  shakedate;
  
  public java.util.Date   getShakedate()         
  { 
     return shakedate; 
  }

  public void setShakedate(java.util.Date  p)         
  { 
     shakedate = p; 
  }

  public void unsetShakedate4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  shakedate = (java.util.Date)null;
	  anUpdateContext.unset(SHAKEDATE);
  } 
  
  public void setShakedate4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  shakedate = p;
	  anUpdateContext.set(SHAKEDATE, p);
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

  public void unsetLastmodified4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  lastmodified = (java.util.Date)null;
	  anUpdateContext.unset(LASTMODIFIED);
  } 
  
  public void setLastmodified4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  lastmodified = p;
	  anUpdateContext.set(LASTMODIFIED, p);
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

  public void unsetTitle4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  title = (java.lang.String)null;
	  anUpdateContext.unset(TITLE);
  } 

  public void setTitle4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  title = p;
	  anUpdateContext.set(TITLE, p);
  }    
    
  //
  protected org.mongodb.morphia.geo.Point  geolocation;
  
  public org.mongodb.morphia.geo.Point   getGeolocation()         
  { 
     return geolocation; 
  }

  public void setGeolocation(org.mongodb.morphia.geo.Point  p)         
  { 
     geolocation = p; 
  }

  public void unsetGeolocation4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  geolocation = (org.mongodb.morphia.geo.Point)null;
	  anUpdateContext.unset(GEOLOCATION);
  } 

  public void setGeolocation4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , org.mongodb.morphia.geo.Point  p)
  {
	  geolocation = p;
	  anUpdateContext.set(GEOLOCATION, p);
  }    
    
  //
  protected java.lang.String  contentcategory;
  
  public java.lang.String   getContentcategory()         
  { 
     return contentcategory; 
  }

  public void setContentcategory(java.lang.String  p)         
  { 
     contentcategory = p; 
  }

  public void unsetContentcategory4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  contentcategory = (java.lang.String)null;
	  anUpdateContext.unset(CONTENTCATEGORY);
  } 

  public void setContentcategory4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  contentcategory = p;
	  anUpdateContext.set(CONTENTCATEGORY, p);
  }    
    
  //
  protected java.lang.String  contentclass;
  
  public java.lang.String   getContentclass()         
  { 
     return contentclass; 
  }

  public void setContentclass(java.lang.String  p)         
  { 
     contentclass = p; 
  }

  public void unsetContentclass4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  contentclass = (java.lang.String)null;
	  anUpdateContext.unset(CONTENTCLASS);
  } 

  public void setContentclass4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  contentclass = p;
	  anUpdateContext.set(CONTENTCLASS, p);
  }    
    
  //
  protected org.bson.Document  content;
  
  public org.bson.Document   getContent()         
  { 
     return content; 
  }

  public void setContent(org.bson.Document  p)         
  { 
     content = p; 
  }

  public void unsetContent4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext )
  {
	  content = (org.bson.Document)null;
	  anUpdateContext.unset(CONTENT);
  } 

  public void setContent4Update(UpdateOperations<? extends PostCommentCollectionDTOBase> anUpdateContext , org.bson.Document  p)
  {
	  content = p;
	  anUpdateContext.set(CONTENT, p);
  }    
    
 
  
}
