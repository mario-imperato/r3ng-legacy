//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.postcollection;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.utils.MongoUtils;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbPostCollectionName = "r3_postcollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbPostCollectionName, noClassnameStored=true)
public class PostCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String POSTID = "_id";
  public static final String STATUS = "status";
  public static final String GROUPS = "groups";
  public static final String GROUPS_i = "groups.%d";
  public static final String SITE = "site";
  public static final String DOMAIN = "domain";
  public static final String TIMELINE = "timeline";
  public static final String AUTHOR = "author";
  public static final String AUTHORNAME = "authorname";
  public static final String AUTHORTYPE = "authortype";
  public static final String USERID = "userid";
  public static final String REFDATE = "refdate";
  public static final String LASTMODIFIED = "lastmodified";
  public static final String TITLE = "title";
  public static final String GEOLOCATION = "geolocation";
  public static final String TEXTBODY = "textbody";
  public static final String TEXTBODY_i = "textbody.%d";
  public static final String PHOTO = "photo";
  public static final String ATTACHMENTS = "attachments";
  public static final String ATTACHMENTS_i = "attachments.%d";
  public static final String LINKS = "links";
  public static final String LINKS_i = "links.%d";
  public static final String GALLERY = "gallery";
  public static final String GALLERY_i = "gallery.%d";
  public static final String CALENDARS = "calendars";
  public static final String CALENDARS_i = "calendars.%d";
  public static final String CONTENTCATEGORY = "contentcategory";
  public static final String CONTENTCLASS = "contentclass";
  public static final String CONTENT = "content";
  public static final String COMMENTS = "comments";
  public static final String COMMENTS_i = "comments.%d";

	public static final String[] SIMPLETYPE_ATTRIBUTES_CSVLIST;

  	static
  	{
  		SIMPLETYPE_ATTRIBUTES_CSVLIST = new String[15];
		
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[0] = POSTID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[1] = STATUS;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[2] = SITE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[3] = DOMAIN;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[4] = TIMELINE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[5] = AUTHOR;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[6] = AUTHORNAME;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[7] = AUTHORTYPE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[8] = USERID;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[9] = REFDATE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[10] = LASTMODIFIED;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[11] = TITLE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[12] = GEOLOCATION;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[13] = CONTENTCATEGORY;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[14] = CONTENTCLASS;	
  	}
  
  @Id
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
  
  public void unsetPostid4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  postid = (org.bson.types.ObjectId)null;
	  anUpdateContext.unset(POSTID);
  } 
  
  public void setPostid4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.bson.types.ObjectId  p)
  {
	  postid = p;
	  anUpdateContext.set(POSTID, p);
  }    
    
  //
  protected java.lang.String  status;
  
  public java.lang.String   getStatus()         
  { 
     return status; 
  }

  public void setStatus(java.lang.String  p)         
  { 
     status = p; 
  }

  public void unsetStatus4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  status = (java.lang.String)null;
	  anUpdateContext.unset(STATUS);
  } 

  public void setStatus4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  status = p;
	  anUpdateContext.set(STATUS, p);
  }    
    
  //
  protected List<java.lang.String>  groups;
  
  public List<java.lang.String>   getGroups()         
  { 
     return groups; 
  }

  public void setGroups(List<java.lang.String>  p)         
  { 
     groups = p; 
  }
  
  public void addGroups(java.lang.String  p)
  {
	  if (groups == null)
		  groups = new ArrayList<java.lang.String>();
		
	  groups.add(p);      
  }
    

  public void unsetGroups4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  groups = (List<java.lang.String>)null;
	  anUpdateContext.unset(GROUPS);
  } 

  public void setGroups4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , List<java.lang.String>  p)
  {
	  groups = p;
	  anUpdateContext.set(GROUPS, p);
  }

  public void setGroups4UpdateV(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String...  varargsp)
  {
      for(java.lang.String p : varargsp)
	  {
		  addGroups(p);
	  }
	  
	  anUpdateContext.set(GROUPS, varargsp);
  }
      
  public void setGroups4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String p)
  {
	  if (groups == null || groups.size() <= i)
		  addGroups4Update(anUpdateContext, p);
	  else
	  {
		  groups.remove(i);
		  groups.add(i, p);
		  anUpdateContext.set(String.format(GROUPS_i, i), p);
	  }
  }

  public void add2setGroups4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (groups == null)
		  addGroups4Update(anUpdateContext , p);
		
	  if (!groups.contains(p))
      {
         groups.add(p);      
         anUpdateContext.add(GROUPS, p, false);
  	  }
  }
  
  public void addGroups4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (groups == null)
		  groups = new ArrayList<java.lang.String>();
		
	  groups.add(p);
      anUpdateContext.add(GROUPS, p);
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

  public void unsetSite4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  site = (java.lang.String)null;
	  anUpdateContext.unset(SITE);
  } 

  public void setSite4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetDomain4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  domain = (java.lang.String)null;
	  anUpdateContext.unset(DOMAIN);
  } 

  public void setDomain4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetTimeline4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  timeline = (java.lang.String)null;
	  anUpdateContext.unset(TIMELINE);
  } 

  public void setTimeline4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  timeline = p;
	  anUpdateContext.set(TIMELINE, p);
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

  public void unsetAuthor4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  author = (java.lang.String)null;
	  anUpdateContext.unset(AUTHOR);
  } 

  public void setAuthor4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetAuthorname4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  authorname = (java.lang.String)null;
	  anUpdateContext.unset(AUTHORNAME);
  } 

  public void setAuthorname4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetAuthortype4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  authortype = (java.lang.String)null;
	  anUpdateContext.unset(AUTHORTYPE);
  } 

  public void setAuthortype4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetUserid4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  userid = (java.lang.String)null;
	  anUpdateContext.unset(USERID);
  } 

  public void setUserid4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  userid = p;
	  anUpdateContext.set(USERID, p);
  }    
    
  //
  protected java.util.Date  refdate;
  
  public java.util.Date   getRefdate()         
  { 
     return refdate; 
  }

  public void setRefdate(java.util.Date  p)         
  { 
     refdate = p; 
  }

  public void unsetRefdate4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  refdate = (java.util.Date)null;
	  anUpdateContext.unset(REFDATE);
  } 
  
  public void setRefdate4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  refdate = p;
	  anUpdateContext.set(REFDATE, p);
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

  public void unsetLastmodified4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  lastmodified = (java.util.Date)null;
	  anUpdateContext.unset(LASTMODIFIED);
  } 
  
  public void setLastmodified4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.util.Date  p)
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

  public void unsetTitle4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  title = (java.lang.String)null;
	  anUpdateContext.unset(TITLE);
  } 

  public void setTitle4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetGeolocation4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  geolocation = (org.mongodb.morphia.geo.Point)null;
	  anUpdateContext.unset(GEOLOCATION);
  } 

  public void setGeolocation4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.mongodb.morphia.geo.Point  p)
  {
	  geolocation = p;
	  anUpdateContext.set(GEOLOCATION, p);
  }    
    
  @Embedded
  protected List<TextbodyDTO>  textbody;
  
  public List<TextbodyDTO>   getTextbody()         
  { 
     return textbody; 
  }

  public void setTextbody(List<TextbodyDTO>  p)         
  { 
     textbody = p; 
  }
  
  public void addTextbody(TextbodyDTO  p)
  {
	  if (textbody == null)
		  textbody = new ArrayList<TextbodyDTO>();
		
	  textbody.add(p);      
  }
    

  public void unsetTextbody4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  textbody = (List<TextbodyDTO>)null;
	  anUpdateContext.unset(TEXTBODY);
  } 

  public void setTextbody4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , List<TextbodyDTO>  p)
  {
	  textbody = p;
	  anUpdateContext.set(TEXTBODY, p);
  }

  public void setTextbody4UpdateV(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , TextbodyDTO...  varargsp)
  {
      for(TextbodyDTO p : varargsp)
	  {
		  addTextbody(p);
	  }
	  
	  anUpdateContext.set(TEXTBODY, varargsp);
  }
      
  public void setTextbody4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, TextbodyDTO p)
  {
	  if (textbody == null || textbody.size() <= i)
		  addTextbody4Update(anUpdateContext, p);
	  else
	  {
		  textbody.remove(i);
		  textbody.add(i, p);
		  anUpdateContext.set(String.format(TEXTBODY_i, i), p);
	  }
  }

  public void add2setTextbody4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , TextbodyDTO  p)
  {
	  if (textbody == null)
		  addTextbody4Update(anUpdateContext , p);
		
	  if (!textbody.contains(p))
      {
         textbody.add(p);      
         anUpdateContext.add(TEXTBODY, p, false);
  	  }
  }
  
  public void addTextbody4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , TextbodyDTO  p)
  {
	  if (textbody == null)
		  textbody = new ArrayList<TextbodyDTO>();
		
	  textbody.add(p);
      anUpdateContext.add(TEXTBODY, p);
  }
  
    
  @Embedded
  protected org.r3.db.mongo.MongoImageIconDTO  photo;
  
  public org.r3.db.mongo.MongoImageIconDTO   getPhoto()         
  { 
     return photo; 
  }

  public void setPhoto(org.r3.db.mongo.MongoImageIconDTO  p)         
  { 
     photo = p; 
  }

  public void unsetPhoto4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  photo = (org.r3.db.mongo.MongoImageIconDTO)null;
	  anUpdateContext.unset(PHOTO);
  } 

  public void setPhoto4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoImageIconDTO  p)
  {
	  photo = p;
	  anUpdateContext.set(PHOTO, p);
  }    
    
  //
  protected List<org.r3.db.mongo.MongoFileAttachmentDTO>  attachments;
  
  public List<org.r3.db.mongo.MongoFileAttachmentDTO>   getAttachments()         
  { 
     return attachments; 
  }

  public void setAttachments(List<org.r3.db.mongo.MongoFileAttachmentDTO>  p)         
  { 
     attachments = p; 
  }
  
  public void addAttachments(org.r3.db.mongo.MongoFileAttachmentDTO  p)
  {
	  if (attachments == null)
		  attachments = new ArrayList<org.r3.db.mongo.MongoFileAttachmentDTO>();
		
	  attachments.add(p);      
  }
    

  public void unsetAttachments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  attachments = (List<org.r3.db.mongo.MongoFileAttachmentDTO>)null;
	  anUpdateContext.unset(ATTACHMENTS);
  } 

  public void setAttachments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , List<org.r3.db.mongo.MongoFileAttachmentDTO>  p)
  {
	  attachments = p;
	  anUpdateContext.set(ATTACHMENTS, p);
  }

  public void setAttachments4UpdateV(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoFileAttachmentDTO...  varargsp)
  {
      for(org.r3.db.mongo.MongoFileAttachmentDTO p : varargsp)
	  {
		  addAttachments(p);
	  }
	  
	  anUpdateContext.set(ATTACHMENTS, varargsp);
  }
      
  public void setAttachments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, org.r3.db.mongo.MongoFileAttachmentDTO p)
  {
	  if (attachments == null || attachments.size() <= i)
		  addAttachments4Update(anUpdateContext, p);
	  else
	  {
		  attachments.remove(i);
		  attachments.add(i, p);
		  anUpdateContext.set(String.format(ATTACHMENTS_i, i), p);
	  }
  }

  public void add2setAttachments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoFileAttachmentDTO  p)
  {
	  if (attachments == null)
		  addAttachments4Update(anUpdateContext , p);
		
	  if (!attachments.contains(p))
      {
         attachments.add(p);      
         anUpdateContext.add(ATTACHMENTS, p, false);
  	  }
  }
  
  public void addAttachments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoFileAttachmentDTO  p)
  {
	  if (attachments == null)
		  attachments = new ArrayList<org.r3.db.mongo.MongoFileAttachmentDTO>();
		
	  attachments.add(p);
      anUpdateContext.add(ATTACHMENTS, p);
  }
  
    
  //
  protected List<org.r3.db.mongo.MongoLinkDTO>  links;
  
  public List<org.r3.db.mongo.MongoLinkDTO>   getLinks()         
  { 
     return links; 
  }

  public void setLinks(List<org.r3.db.mongo.MongoLinkDTO>  p)         
  { 
     links = p; 
  }
  
  public void addLinks(org.r3.db.mongo.MongoLinkDTO  p)
  {
	  if (links == null)
		  links = new ArrayList<org.r3.db.mongo.MongoLinkDTO>();
		
	  links.add(p);      
  }
    

  public void unsetLinks4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  links = (List<org.r3.db.mongo.MongoLinkDTO>)null;
	  anUpdateContext.unset(LINKS);
  } 

  public void setLinks4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , List<org.r3.db.mongo.MongoLinkDTO>  p)
  {
	  links = p;
	  anUpdateContext.set(LINKS, p);
  }

  public void setLinks4UpdateV(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoLinkDTO...  varargsp)
  {
      for(org.r3.db.mongo.MongoLinkDTO p : varargsp)
	  {
		  addLinks(p);
	  }
	  
	  anUpdateContext.set(LINKS, varargsp);
  }
      
  public void setLinks4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, org.r3.db.mongo.MongoLinkDTO p)
  {
	  if (links == null || links.size() <= i)
		  addLinks4Update(anUpdateContext, p);
	  else
	  {
		  links.remove(i);
		  links.add(i, p);
		  anUpdateContext.set(String.format(LINKS_i, i), p);
	  }
  }

  public void add2setLinks4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoLinkDTO  p)
  {
	  if (links == null)
		  addLinks4Update(anUpdateContext , p);
		
	  if (!links.contains(p))
      {
         links.add(p);      
         anUpdateContext.add(LINKS, p, false);
  	  }
  }
  
  public void addLinks4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoLinkDTO  p)
  {
	  if (links == null)
		  links = new ArrayList<org.r3.db.mongo.MongoLinkDTO>();
		
	  links.add(p);
      anUpdateContext.add(LINKS, p);
  }
  
    
  //
  protected List<org.r3.db.mongo.MongoImageIconDTO>  gallery;
  
  public List<org.r3.db.mongo.MongoImageIconDTO>   getGallery()         
  { 
     return gallery; 
  }

  public void setGallery(List<org.r3.db.mongo.MongoImageIconDTO>  p)         
  { 
     gallery = p; 
  }
  
  public void addGallery(org.r3.db.mongo.MongoImageIconDTO  p)
  {
	  if (gallery == null)
		  gallery = new ArrayList<org.r3.db.mongo.MongoImageIconDTO>();
		
	  gallery.add(p);      
  }
    

  public void unsetGallery4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  gallery = (List<org.r3.db.mongo.MongoImageIconDTO>)null;
	  anUpdateContext.unset(GALLERY);
  } 

  public void setGallery4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , List<org.r3.db.mongo.MongoImageIconDTO>  p)
  {
	  gallery = p;
	  anUpdateContext.set(GALLERY, p);
  }

  public void setGallery4UpdateV(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoImageIconDTO...  varargsp)
  {
      for(org.r3.db.mongo.MongoImageIconDTO p : varargsp)
	  {
		  addGallery(p);
	  }
	  
	  anUpdateContext.set(GALLERY, varargsp);
  }
      
  public void setGallery4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, org.r3.db.mongo.MongoImageIconDTO p)
  {
	  if (gallery == null || gallery.size() <= i)
		  addGallery4Update(anUpdateContext, p);
	  else
	  {
		  gallery.remove(i);
		  gallery.add(i, p);
		  anUpdateContext.set(String.format(GALLERY_i, i), p);
	  }
  }

  public void add2setGallery4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoImageIconDTO  p)
  {
	  if (gallery == null)
		  addGallery4Update(anUpdateContext , p);
		
	  if (!gallery.contains(p))
      {
         gallery.add(p);      
         anUpdateContext.add(GALLERY, p, false);
  	  }
  }
  
  public void addGallery4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoImageIconDTO  p)
  {
	  if (gallery == null)
		  gallery = new ArrayList<org.r3.db.mongo.MongoImageIconDTO>();
		
	  gallery.add(p);
      anUpdateContext.add(GALLERY, p);
  }
  
    
  //
  protected List<org.r3.db.mongo.MongoCalendarDTO>  calendars;
  
  public List<org.r3.db.mongo.MongoCalendarDTO>   getCalendars()         
  { 
     return calendars; 
  }

  public void setCalendars(List<org.r3.db.mongo.MongoCalendarDTO>  p)         
  { 
     calendars = p; 
  }
  
  public void addCalendars(org.r3.db.mongo.MongoCalendarDTO  p)
  {
	  if (calendars == null)
		  calendars = new ArrayList<org.r3.db.mongo.MongoCalendarDTO>();
		
	  calendars.add(p);      
  }
    

  public void unsetCalendars4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  calendars = (List<org.r3.db.mongo.MongoCalendarDTO>)null;
	  anUpdateContext.unset(CALENDARS);
  } 

  public void setCalendars4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , List<org.r3.db.mongo.MongoCalendarDTO>  p)
  {
	  calendars = p;
	  anUpdateContext.set(CALENDARS, p);
  }

  public void setCalendars4UpdateV(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoCalendarDTO...  varargsp)
  {
      for(org.r3.db.mongo.MongoCalendarDTO p : varargsp)
	  {
		  addCalendars(p);
	  }
	  
	  anUpdateContext.set(CALENDARS, varargsp);
  }
      
  public void setCalendars4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, org.r3.db.mongo.MongoCalendarDTO p)
  {
	  if (calendars == null || calendars.size() <= i)
		  addCalendars4Update(anUpdateContext, p);
	  else
	  {
		  calendars.remove(i);
		  calendars.add(i, p);
		  anUpdateContext.set(String.format(CALENDARS_i, i), p);
	  }
  }

  public void add2setCalendars4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoCalendarDTO  p)
  {
	  if (calendars == null)
		  addCalendars4Update(anUpdateContext , p);
		
	  if (!calendars.contains(p))
      {
         calendars.add(p);      
         anUpdateContext.add(CALENDARS, p, false);
  	  }
  }
  
  public void addCalendars4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoCalendarDTO  p)
  {
	  if (calendars == null)
		  calendars = new ArrayList<org.r3.db.mongo.MongoCalendarDTO>();
		
	  calendars.add(p);
      anUpdateContext.add(CALENDARS, p);
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

  public void unsetContentcategory4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  contentcategory = (java.lang.String)null;
	  anUpdateContext.unset(CONTENTCATEGORY);
  } 

  public void setContentcategory4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetContentclass4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  contentclass = (java.lang.String)null;
	  anUpdateContext.unset(CONTENTCLASS);
  } 

  public void setContentclass4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , java.lang.String  p)
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

  public void unsetContent4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  content = (org.bson.Document)null;
	  anUpdateContext.unset(CONTENT);
  } 

  public void setContent4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , org.bson.Document  p)
  {
	  content = p;
	  anUpdateContext.set(CONTENT, p);
  }    
    
  @Embedded
  protected List<CommentsDTO>  comments;
  
  public List<CommentsDTO>   getComments()         
  { 
     return comments; 
  }

  public void setComments(List<CommentsDTO>  p)         
  { 
     comments = p; 
  }
  
  public void addComments(CommentsDTO  p)
  {
	  if (comments == null)
		  comments = new ArrayList<CommentsDTO>();
		
	  comments.add(p);      
  }
    

  public void unsetComments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext )
  {
	  comments = (List<CommentsDTO>)null;
	  anUpdateContext.unset(COMMENTS);
  } 

  public void setComments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , List<CommentsDTO>  p)
  {
	  comments = p;
	  anUpdateContext.set(COMMENTS, p);
  }

  public void setComments4UpdateV(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , CommentsDTO...  varargsp)
  {
      for(CommentsDTO p : varargsp)
	  {
		  addComments(p);
	  }
	  
	  anUpdateContext.set(COMMENTS, varargsp);
  }
      
  public void setComments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, CommentsDTO p)
  {
	  if (comments == null || comments.size() <= i)
		  addComments4Update(anUpdateContext, p);
	  else
	  {
		  comments.remove(i);
		  comments.add(i, p);
		  anUpdateContext.set(String.format(COMMENTS_i, i), p);
	  }
  }

  public void add2setComments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , CommentsDTO  p)
  {
	  if (comments == null)
		  addComments4Update(anUpdateContext , p);
		
	  if (!comments.contains(p))
      {
         comments.add(p);      
         anUpdateContext.add(COMMENTS, p, false);
  	  }
  }
  
  public void addComments4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , CommentsDTO  p)
  {
	  if (comments == null)
		  comments = new ArrayList<CommentsDTO>();
		
	  comments.add(p);
      anUpdateContext.add(COMMENTS, p);
  }
  
    
 

  public static final String TEXTBODY_LANGUAGE = "textbody.language";
  public static final String TEXTBODY_i_LANGUAGE = "textbody.%d.language";
  public static final String TEXTBODY_TITLE = "textbody.title";
  public static final String TEXTBODY_i_TITLE = "textbody.%d.title";
  public static final String TEXTBODY_SUMMARY = "textbody.summary";
  public static final String TEXTBODY_i_SUMMARY = "textbody.%d.summary";
  public static final String TEXTBODY_BODY = "textbody.body";
  public static final String TEXTBODY_i_BODY = "textbody.%d.body";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class TextbodyDTO
  {
  //
  private java.lang.String  language;

  public java.lang.String   getLanguage()         
  { 
     return language; 
  }

  public void setLanguage(java.lang.String  p)         
  { 
     language = p; 
  }

  public void unsetTextbody_i_language4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  language = (java.lang.String)null;
	  anUpdateContext.unset(String.format(TEXTBODY_i_LANGUAGE, i));
  } 

  public void setTextbody_i_language4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  language = p;
	  anUpdateContext.set(String.format(TEXTBODY_i_LANGUAGE, i), p);
  }    
  
  //
  private java.lang.String  title;

  public java.lang.String   getTitle()         
  { 
     return title; 
  }

  public void setTitle(java.lang.String  p)         
  { 
     title = p; 
  }

  public void unsetTextbody_i_title4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  title = (java.lang.String)null;
	  anUpdateContext.unset(String.format(TEXTBODY_i_TITLE, i));
  } 

  public void setTextbody_i_title4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  title = p;
	  anUpdateContext.set(String.format(TEXTBODY_i_TITLE, i), p);
  }    
  
  //
  private java.lang.String  summary;

  public java.lang.String   getSummary()         
  { 
     return summary; 
  }

  public void setSummary(java.lang.String  p)         
  { 
     summary = p; 
  }

  public void unsetTextbody_i_summary4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  summary = (java.lang.String)null;
	  anUpdateContext.unset(String.format(TEXTBODY_i_SUMMARY, i));
  } 

  public void setTextbody_i_summary4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  summary = p;
	  anUpdateContext.set(String.format(TEXTBODY_i_SUMMARY, i), p);
  }    
  
  //
  private java.lang.String  body;

  public java.lang.String   getBody()         
  { 
     return body; 
  }

  public void setBody(java.lang.String  p)         
  { 
     body = p; 
  }

  public void unsetTextbody_i_body4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  body = (java.lang.String)null;
	  anUpdateContext.unset(String.format(TEXTBODY_i_BODY, i));
  } 

  public void setTextbody_i_body4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  body = p;
	  anUpdateContext.set(String.format(TEXTBODY_i_BODY, i), p);
  }    
  

  }    
  

  public static final String COMMENTS_COMMENTID = "comments.commentid";
  public static final String COMMENTS_i_COMMENTID = "comments.%d.commentid";
  public static final String COMMENTS_AUTHOR = "comments.author";
  public static final String COMMENTS_i_AUTHOR = "comments.%d.author";
  public static final String COMMENTS_AUTHORNAME = "comments.authorname";
  public static final String COMMENTS_i_AUTHORNAME = "comments.%d.authorname";
  public static final String COMMENTS_AUTHORTYPE = "comments.authortype";
  public static final String COMMENTS_i_AUTHORTYPE = "comments.%d.authortype";
  public static final String COMMENTS_USERID = "comments.userid";
  public static final String COMMENTS_i_USERID = "comments.%d.userid";
  public static final String COMMENTS_SHAKEEVENT = "comments.shakeevent";
  public static final String COMMENTS_i_SHAKEEVENT = "comments.%d.shakeevent";
  public static final String COMMENTS_SHAKEDATE = "comments.shakedate";
  public static final String COMMENTS_i_SHAKEDATE = "comments.%d.shakedate";
  public static final String COMMENTS_LASTMODIFIED = "comments.lastmodified";
  public static final String COMMENTS_i_LASTMODIFIED = "comments.%d.lastmodified";
  public static final String COMMENTS_TITLE = "comments.title";
  public static final String COMMENTS_i_TITLE = "comments.%d.title";
  public static final String COMMENTS_GEOLOCATION = "comments.geolocation";
  public static final String COMMENTS_i_GEOLOCATION = "comments.%d.geolocation";
  public static final String COMMENTS_CONTENTCATEGORY = "comments.contentcategory";
  public static final String COMMENTS_i_CONTENTCATEGORY = "comments.%d.contentcategory";
  public static final String COMMENTS_CONTENTCLASS = "comments.contentclass";
  public static final String COMMENTS_i_CONTENTCLASS = "comments.%d.contentclass";
  public static final String COMMENTS_CONTENT = "comments.content";
  public static final String COMMENTS_i_CONTENT = "comments.%d.content";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class CommentsDTO
  {
  //
  private org.bson.types.ObjectId  commentid;

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
  
  public void unsetComments_i_commentid4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  commentid = (org.bson.types.ObjectId)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_COMMENTID, i));
  } 
  
  public void setComments_i_commentid4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, org.bson.types.ObjectId  p)
  {
	  commentid = p;
	  anUpdateContext.set(String.format(COMMENTS_i_COMMENTID, i), p);
  }    
  
  //
  private java.lang.String  author;

  public java.lang.String   getAuthor()         
  { 
     return author; 
  }

  public void setAuthor(java.lang.String  p)         
  { 
     author = p; 
  }

  public void unsetComments_i_author4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  author = (java.lang.String)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_AUTHOR, i));
  } 

  public void setComments_i_author4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  author = p;
	  anUpdateContext.set(String.format(COMMENTS_i_AUTHOR, i), p);
  }    
  
  //
  private java.lang.String  authorname;

  public java.lang.String   getAuthorname()         
  { 
     return authorname; 
  }

  public void setAuthorname(java.lang.String  p)         
  { 
     authorname = p; 
  }

  public void unsetComments_i_authorname4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  authorname = (java.lang.String)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_AUTHORNAME, i));
  } 

  public void setComments_i_authorname4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  authorname = p;
	  anUpdateContext.set(String.format(COMMENTS_i_AUTHORNAME, i), p);
  }    
  
  //
  private java.lang.String  authortype;

  public java.lang.String   getAuthortype()         
  { 
     return authortype; 
  }

  public void setAuthortype(java.lang.String  p)         
  { 
     authortype = p; 
  }

  public void unsetComments_i_authortype4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  authortype = (java.lang.String)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_AUTHORTYPE, i));
  } 

  public void setComments_i_authortype4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  authortype = p;
	  anUpdateContext.set(String.format(COMMENTS_i_AUTHORTYPE, i), p);
  }    
  
  //
  private java.lang.String  userid;

  public java.lang.String   getUserid()         
  { 
     return userid; 
  }

  public void setUserid(java.lang.String  p)         
  { 
     userid = p; 
  }

  public void unsetComments_i_userid4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  userid = (java.lang.String)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_USERID, i));
  } 

  public void setComments_i_userid4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  userid = p;
	  anUpdateContext.set(String.format(COMMENTS_i_USERID, i), p);
  }    
  
  //
  private org.bson.types.ObjectId  shakeevent;

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
  
  public void unsetComments_i_shakeevent4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  shakeevent = (org.bson.types.ObjectId)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_SHAKEEVENT, i));
  } 
  
  public void setComments_i_shakeevent4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, org.bson.types.ObjectId  p)
  {
	  shakeevent = p;
	  anUpdateContext.set(String.format(COMMENTS_i_SHAKEEVENT, i), p);
  }    
  
  //
  private java.util.Date  shakedate;

  public java.util.Date   getShakedate()         
  { 
     return shakedate; 
  }

  public void setShakedate(java.util.Date  p)         
  { 
     shakedate = p; 
  }

  public void unsetComments_i_shakedate4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  shakedate = (java.util.Date)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_SHAKEDATE, i));
  } 
  
  public void setComments_i_shakedate4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.util.Date  p)
  {
	  shakedate = p;
	  anUpdateContext.set(String.format(COMMENTS_i_SHAKEDATE, i), p);
  }    
  
  //
  private java.util.Date  lastmodified;

  public java.util.Date   getLastmodified()         
  { 
     return lastmodified; 
  }

  public void setLastmodified(java.util.Date  p)         
  { 
     lastmodified = p; 
  }

  public void unsetComments_i_lastmodified4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  lastmodified = (java.util.Date)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_LASTMODIFIED, i));
  } 
  
  public void setComments_i_lastmodified4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.util.Date  p)
  {
	  lastmodified = p;
	  anUpdateContext.set(String.format(COMMENTS_i_LASTMODIFIED, i), p);
  }    
  
  //
  private java.lang.String  title;

  public java.lang.String   getTitle()         
  { 
     return title; 
  }

  public void setTitle(java.lang.String  p)         
  { 
     title = p; 
  }

  public void unsetComments_i_title4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  title = (java.lang.String)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_TITLE, i));
  } 

  public void setComments_i_title4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  title = p;
	  anUpdateContext.set(String.format(COMMENTS_i_TITLE, i), p);
  }    
  
  //
  private org.mongodb.morphia.geo.Point  geolocation;

  public org.mongodb.morphia.geo.Point   getGeolocation()         
  { 
     return geolocation; 
  }

  public void setGeolocation(org.mongodb.morphia.geo.Point  p)         
  { 
     geolocation = p; 
  }

  public void unsetComments_i_geolocation4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  geolocation = (org.mongodb.morphia.geo.Point)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_GEOLOCATION, i));
  } 

  public void setComments_i_geolocation4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, org.mongodb.morphia.geo.Point  p)
  {
	  geolocation = p;
	  anUpdateContext.set(String.format(COMMENTS_i_GEOLOCATION, i), p);
  }    
  
  //
  private java.lang.String  contentcategory;

  public java.lang.String   getContentcategory()         
  { 
     return contentcategory; 
  }

  public void setContentcategory(java.lang.String  p)         
  { 
     contentcategory = p; 
  }

  public void unsetComments_i_contentcategory4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  contentcategory = (java.lang.String)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_CONTENTCATEGORY, i));
  } 

  public void setComments_i_contentcategory4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  contentcategory = p;
	  anUpdateContext.set(String.format(COMMENTS_i_CONTENTCATEGORY, i), p);
  }    
  
  //
  private java.lang.String  contentclass;

  public java.lang.String   getContentclass()         
  { 
     return contentclass; 
  }

  public void setContentclass(java.lang.String  p)         
  { 
     contentclass = p; 
  }

  public void unsetComments_i_contentclass4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  contentclass = (java.lang.String)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_CONTENTCLASS, i));
  } 

  public void setComments_i_contentclass4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  contentclass = p;
	  anUpdateContext.set(String.format(COMMENTS_i_CONTENTCLASS, i), p);
  }    
  
  //
  private org.bson.Document  content;

  public org.bson.Document   getContent()         
  { 
     return content; 
  }

  public void setContent(org.bson.Document  p)         
  { 
     content = p; 
  }

  public void unsetComments_i_content4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i)
  {
	  content = (org.bson.Document)null;
	  anUpdateContext.unset(String.format(COMMENTS_i_CONTENT, i));
  } 

  public void setComments_i_content4Update(UpdateOperations<? extends PostCollectionDTOBase> anUpdateContext , int i, org.bson.Document  p)
  {
	  content = p;
	  anUpdateContext.set(String.format(COMMENTS_i_CONTENT, i), p);
  }    
  

  }    
  
  
}
