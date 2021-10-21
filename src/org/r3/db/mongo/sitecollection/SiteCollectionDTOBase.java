//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.sitecollection;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbSiteCollectionName = "r3_sitecollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbSiteCollectionName, noClassnameStored=true)
public class SiteCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String SITE = "_id";
  public static final String DOMAIN = "domain";
  public static final String SITETYPE = "sitetype";
  public static final String SITESTATUS = "sitestatus";
  public static final String DESCRIPTION = "description";
  public static final String SUMMARY = "summary";
  public static final String PRIMARYGEO = "primarygeo";
  public static final String LASTMODIFIED = "lastmodified";
  public static final String SECTIONS = "sections";
  public static final String SECTIONS_i = "sections.%d";
  public static final String FRIENDS = "friends";
  public static final String FRIENDS_i = "friends.%d";
  public static final String GRAPHICS = "graphics";
  public static final String GRAPHICS_i = "graphics.%d";
  public static final String ADDRESS = "address";

	public static final String[] SIMPLETYPE_ATTRIBUTES_CSVLIST;

  	static
  	{
  		SIMPLETYPE_ATTRIBUTES_CSVLIST = new String[8];
		
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[0] = SITE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[1] = DOMAIN;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[2] = SITETYPE;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[3] = SITESTATUS;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[4] = DESCRIPTION;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[5] = SUMMARY;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[6] = PRIMARYGEO;	
   		SIMPLETYPE_ATTRIBUTES_CSVLIST[7] = LASTMODIFIED;	
  	}
  
  @Id
  private java.lang.String  site;
  
  public java.lang.String   getSite()         
  { 
     return site; 
  }

  public void setSite(java.lang.String  p)         
  { 
     site = p; 
  }

  public void setSite4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  site = p;
	  anUpdateContext.set(SITE, p);
  }    
    
  //
  private java.lang.String  domain;
  
  public java.lang.String   getDomain()         
  { 
     return domain; 
  }

  public void setDomain(java.lang.String  p)         
  { 
     domain = p; 
  }

  public void setDomain4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  domain = p;
	  anUpdateContext.set(DOMAIN, p);
  }    
    
  //
  private java.lang.String  sitetype;
  
  public java.lang.String   getSitetype()         
  { 
     return sitetype; 
  }

  public void setSitetype(java.lang.String  p)         
  { 
     sitetype = p; 
  }

  public void setSitetype4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  sitetype = p;
	  anUpdateContext.set(SITETYPE, p);
  }    
    
  //
  private java.lang.String  sitestatus;
  
  public java.lang.String   getSitestatus()         
  { 
     return sitestatus; 
  }

  public void setSitestatus(java.lang.String  p)         
  { 
     sitestatus = p; 
  }

  public void setSitestatus4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  sitestatus = p;
	  anUpdateContext.set(SITESTATUS, p);
  }    
    
  //
  private java.lang.String  description;
  
  public java.lang.String   getDescription()         
  { 
     return description; 
  }

  public void setDescription(java.lang.String  p)         
  { 
     description = p; 
  }

  public void setDescription4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  description = p;
	  anUpdateContext.set(DESCRIPTION, p);
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

  public void setSummary4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  summary = p;
	  anUpdateContext.set(SUMMARY, p);
  }    
    
  //
  private org.mongodb.morphia.geo.Point  primarygeo;
  
  public org.mongodb.morphia.geo.Point   getPrimarygeo()         
  { 
     return primarygeo; 
  }

  public void setPrimarygeo(org.mongodb.morphia.geo.Point  p)         
  { 
     primarygeo = p; 
  }

  public void setPrimarygeo4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , org.mongodb.morphia.geo.Point  p)
  {
	  primarygeo = p;
	  anUpdateContext.set(PRIMARYGEO, p);
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
  
  public void setLastmodified4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  lastmodified = p;
	  anUpdateContext.set(LASTMODIFIED, p);
  }    
    
  //
  private List<java.lang.String>  sections;
  
  public List<java.lang.String>   getSections()         
  { 
     return sections; 
  }

  public void setSections(List<java.lang.String>  p)         
  { 
     sections = p; 
  }
  
  public void addSections(java.lang.String  p)
  {
	  if (sections == null)
		  sections = new ArrayList<java.lang.String>();
		
	  sections.add(p);      
  }
    

  public void setSections4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , List<java.lang.String>  p)
  {
	  sections = p;
	  anUpdateContext.set(SECTIONS, p);
  }

  public void setSections4UpdateV(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String...  varargsp)
  {
      for(java.lang.String p : varargsp)
	  {
		  addSections(p);
	  }
	  
	  anUpdateContext.set(SECTIONS, varargsp);
  }
      
  public void setSections4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , int i, java.lang.String p)
  {
	  if (sections == null || sections.size() <= i)
		  addSections4Update(anUpdateContext, p);
	  else
	  {
		  sections.remove(i);
		  sections.add(i, p);
		  anUpdateContext.set(String.format(SECTIONS_i, i), p);
	  }
  }

  public void add2setSections4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (sections == null)
		  addSections4Update(anUpdateContext , p);
		
	  if (!sections.contains(p))
      {
         sections.add(p);      
         anUpdateContext.add(SECTIONS, p, false);
  	  }
  }
  
  public void addSections4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (sections == null)
		  sections = new ArrayList<java.lang.String>();
		
	  sections.add(p);
      anUpdateContext.add(SECTIONS, p);
  }
  
    
  @Embedded
  private List<FriendsDTO>  friends;
  
  public List<FriendsDTO>   getFriends()         
  { 
     return friends; 
  }

  public void setFriends(List<FriendsDTO>  p)         
  { 
     friends = p; 
  }
  
  public void addFriends(FriendsDTO  p)
  {
	  if (friends == null)
		  friends = new ArrayList<FriendsDTO>();
		
	  friends.add(p);      
  }
    

  public void setFriends4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , List<FriendsDTO>  p)
  {
	  friends = p;
	  anUpdateContext.set(FRIENDS, p);
  }

  public void setFriends4UpdateV(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , FriendsDTO...  varargsp)
  {
      for(FriendsDTO p : varargsp)
	  {
		  addFriends(p);
	  }
	  
	  anUpdateContext.set(FRIENDS, varargsp);
  }
      
  public void setFriends4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , int i, FriendsDTO p)
  {
	  if (friends == null || friends.size() <= i)
		  addFriends4Update(anUpdateContext, p);
	  else
	  {
		  friends.remove(i);
		  friends.add(i, p);
		  anUpdateContext.set(String.format(FRIENDS_i, i), p);
	  }
  }

  public void add2setFriends4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , FriendsDTO  p)
  {
	  if (friends == null)
		  addFriends4Update(anUpdateContext , p);
		
	  if (!friends.contains(p))
      {
         friends.add(p);      
         anUpdateContext.add(FRIENDS, p, false);
  	  }
  }
  
  public void addFriends4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , FriendsDTO  p)
  {
	  if (friends == null)
		  friends = new ArrayList<FriendsDTO>();
		
	  friends.add(p);
      anUpdateContext.add(FRIENDS, p);
  }
  
    
  //
  private List<org.r3.db.mongo.MongoImageIconDTO>  graphics;
  
  public List<org.r3.db.mongo.MongoImageIconDTO>   getGraphics()         
  { 
     return graphics; 
  }

  public void setGraphics(List<org.r3.db.mongo.MongoImageIconDTO>  p)         
  { 
     graphics = p; 
  }
  
  public void addGraphics(org.r3.db.mongo.MongoImageIconDTO  p)
  {
	  if (graphics == null)
		  graphics = new ArrayList<org.r3.db.mongo.MongoImageIconDTO>();
		
	  graphics.add(p);      
  }
    

  public void setGraphics4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , List<org.r3.db.mongo.MongoImageIconDTO>  p)
  {
	  graphics = p;
	  anUpdateContext.set(GRAPHICS, p);
  }

  public void setGraphics4UpdateV(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoImageIconDTO...  varargsp)
  {
      for(org.r3.db.mongo.MongoImageIconDTO p : varargsp)
	  {
		  addGraphics(p);
	  }
	  
	  anUpdateContext.set(GRAPHICS, varargsp);
  }
      
  public void setGraphics4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , int i, org.r3.db.mongo.MongoImageIconDTO p)
  {
	  if (graphics == null || graphics.size() <= i)
		  addGraphics4Update(anUpdateContext, p);
	  else
	  {
		  graphics.remove(i);
		  graphics.add(i, p);
		  anUpdateContext.set(String.format(GRAPHICS_i, i), p);
	  }
  }

  public void add2setGraphics4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoImageIconDTO  p)
  {
	  if (graphics == null)
		  addGraphics4Update(anUpdateContext , p);
		
	  if (!graphics.contains(p))
      {
         graphics.add(p);      
         anUpdateContext.add(GRAPHICS, p, false);
  	  }
  }
  
  public void addGraphics4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoImageIconDTO  p)
  {
	  if (graphics == null)
		  graphics = new ArrayList<org.r3.db.mongo.MongoImageIconDTO>();
		
	  graphics.add(p);
      anUpdateContext.add(GRAPHICS, p);
  }
  
    
  @Embedded
  private org.r3.db.mongo.MongoAddressDTO  address;
  
  public org.r3.db.mongo.MongoAddressDTO   getAddress()         
  { 
     return address; 
  }

  public void setAddress(org.r3.db.mongo.MongoAddressDTO  p)         
  { 
     address = p; 
  }

  public void setAddress4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoAddressDTO  p)
  {
	  address = p;
	  anUpdateContext.set(ADDRESS, p);
  }    
    
 

  public static final String FRIENDS_SITE = "friends.site";
  public static final String FRIENDS_i_SITE = "friends.%d.site";
  public static final String FRIENDS_SITETYPE = "friends.sitetype";
  public static final String FRIENDS_i_SITETYPE = "friends.%d.sitetype";
  public static final String FRIENDS_SITEDESCRIPTION = "friends.sitedescription";
  public static final String FRIENDS_i_SITEDESCRIPTION = "friends.%d.sitedescription";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class FriendsDTO
  {
  //
  private java.lang.String  site;

  public java.lang.String   getSite()         
  { 
     return site; 
  }

  public void setSite(java.lang.String  p)         
  { 
     site = p; 
  }

  public void setFriends_i_site4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  site = p;
	  anUpdateContext.set(String.format(FRIENDS_i_SITE, i), p);
  }    
  
  //
  private java.lang.String  sitetype;

  public java.lang.String   getSitetype()         
  { 
     return sitetype; 
  }

  public void setSitetype(java.lang.String  p)         
  { 
     sitetype = p; 
  }

  public void setFriends_i_sitetype4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  sitetype = p;
	  anUpdateContext.set(String.format(FRIENDS_i_SITETYPE, i), p);
  }    
  
  //
  private java.lang.String  sitedescription;

  public java.lang.String   getSitedescription()         
  { 
     return sitedescription; 
  }

  public void setSitedescription(java.lang.String  p)         
  { 
     sitedescription = p; 
  }

  public void setFriends_i_sitedescription4Update(UpdateOperations<? extends SiteCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  sitedescription = p;
	  anUpdateContext.set(String.format(FRIENDS_i_SITEDESCRIPTION, i), p);
  }    
  

  }    
  
  
}
