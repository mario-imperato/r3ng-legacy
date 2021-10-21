//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.usercollection;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbUserCollectionName = "r3_usercollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbUserCollectionName, noClassnameStored=true)
public class UserCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String USERID = "_id";
  public static final String NICKNAME = "nickname";
  public static final String FIRSTNAME = "firstname";
  public static final String LASTNAME = "lastname";
  public static final String EMAIL = "email";
  public static final String USERTYPE = "usertype";
  public static final String PRIMARYGEO = "primarygeo";
  public static final String LASTMODIFIED = "lastmodified";
  public static final String USERSTATUS = "userstatus";
  public static final String LASTLOGIN = "lastlogin";
  public static final String NUMBEROFLOGINS = "numberoflogins";
  public static final String USERCONSENT = "userconsent";
  public static final String USERANA = "userana";
  public static final String SECTIONS = "sections";
  public static final String SECTIONS_i = "sections.%d";
  public static final String FAVSITES = "favsites";
  public static final String FAVSITES_i = "favsites.%d";
  public static final String PHOTO = "photo";
  public static final String PHOTO_i = "photo.%d";
  public static final String ADDRESS = "address";
  public static final String BUSINESSCARD = "businesscard";

  @Id
  private java.lang.String  userid;
  
  public java.lang.String   getUserid()         
  { 
     return userid; 
  }

  public void setUserid(java.lang.String  p)         
  { 
     userid = p; 
  }

  public void setUserid4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  userid = p;
	  anUpdateContext.set(USERID, p);
  }    
    
  //
  private java.lang.String  nickname;
  
  public java.lang.String   getNickname()         
  { 
     return nickname; 
  }

  public void setNickname(java.lang.String  p)         
  { 
     nickname = p; 
  }

  public void setNickname4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  nickname = p;
	  anUpdateContext.set(NICKNAME, p);
  }    
    
  //
  private java.lang.String  firstname;
  
  public java.lang.String   getFirstname()         
  { 
     return firstname; 
  }

  public void setFirstname(java.lang.String  p)         
  { 
     firstname = p; 
  }

  public void setFirstname4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  firstname = p;
	  anUpdateContext.set(FIRSTNAME, p);
  }    
    
  //
  private java.lang.String  lastname;
  
  public java.lang.String   getLastname()         
  { 
     return lastname; 
  }

  public void setLastname(java.lang.String  p)         
  { 
     lastname = p; 
  }

  public void setLastname4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  lastname = p;
	  anUpdateContext.set(LASTNAME, p);
  }    
    
  //
  private java.lang.String  email;
  
  public java.lang.String   getEmail()         
  { 
     return email; 
  }

  public void setEmail(java.lang.String  p)         
  { 
     email = p; 
  }

  public void setEmail4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  email = p;
	  anUpdateContext.set(EMAIL, p);
  }    
    
  //
  private java.lang.String  usertype;
  
  public java.lang.String   getUsertype()         
  { 
     return usertype; 
  }

  public void setUsertype(java.lang.String  p)         
  { 
     usertype = p; 
  }

  public void setUsertype4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  usertype = p;
	  anUpdateContext.set(USERTYPE, p);
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

  public void setPrimarygeo4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , org.mongodb.morphia.geo.Point  p)
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
  
  public void setLastmodified4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  lastmodified = p;
	  anUpdateContext.set(LASTMODIFIED, p);
  }    
    
  //
  private java.lang.String  userstatus;
  
  public java.lang.String   getUserstatus()         
  { 
     return userstatus; 
  }

  public void setUserstatus(java.lang.String  p)         
  { 
     userstatus = p; 
  }

  public void setUserstatus4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  userstatus = p;
	  anUpdateContext.set(USERSTATUS, p);
  }    
    
  //
  private java.util.Date  lastlogin;
  
  public java.util.Date   getLastlogin()         
  { 
     return lastlogin; 
  }

  public void setLastlogin(java.util.Date  p)         
  { 
     lastlogin = p; 
  }
  
  public void setLastlogin4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  lastlogin = p;
	  anUpdateContext.set(LASTLOGIN, p);
  }    
    
  //
  private int  numberoflogins;
  
  public int   getNumberoflogins()         
  { 
     return numberoflogins; 
  }

  public void setNumberoflogins(int  p)         
  { 
     numberoflogins = p; 
  }

  public void setNumberoflogins4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int  p)
  {
	  numberoflogins = p;
	  anUpdateContext.set(NUMBEROFLOGINS, p);
  }  
    
  //
  private java.lang.String  userconsent;
  
  public java.lang.String   getUserconsent()         
  { 
     return userconsent; 
  }

  public void setUserconsent(java.lang.String  p)         
  { 
     userconsent = p; 
  }

  public void setUserconsent4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  userconsent = p;
	  anUpdateContext.set(USERCONSENT, p);
  }    
    
  @Embedded
  private UseranaDTO  userana;
  
  public UseranaDTO   getUserana()         
  { 
     return userana; 
  }

  public void setUserana(UseranaDTO  p)         
  { 
     userana = p; 
  }
  
  public void setUserana4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , UseranaDTO  p)
  {
	  userana = p;
	  anUpdateContext.set(USERANA, p);
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
    

  public void setSections4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , List<java.lang.String>  p)
  {
	  sections = p;
	  anUpdateContext.set(SECTIONS, p);
  }

  public void setSections4UpdateV(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String...  varargsp)
  {
      for(java.lang.String p : varargsp)
	  {
		  addSections(p);
	  }
	  
	  anUpdateContext.set(SECTIONS, varargsp);
  }
      
  public void setSections4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int i, java.lang.String p)
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

  public void add2setSections4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (sections == null)
		  addSections4Update(anUpdateContext , p);
		
	  if (!sections.contains(p))
      {
         sections.add(p);      
         anUpdateContext.add(SECTIONS, p, false);
  	  }
  }
  
  public void addSections4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (sections == null)
		  sections = new ArrayList<java.lang.String>();
		
	  sections.add(p);
      anUpdateContext.add(SECTIONS, p);
  }
  
    
  //
  private List<java.lang.String>  favsites;
  
  public List<java.lang.String>   getFavsites()         
  { 
     return favsites; 
  }

  public void setFavsites(List<java.lang.String>  p)         
  { 
     favsites = p; 
  }
  
  public void addFavsites(java.lang.String  p)
  {
	  if (favsites == null)
		  favsites = new ArrayList<java.lang.String>();
		
	  favsites.add(p);      
  }
    

  public void setFavsites4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , List<java.lang.String>  p)
  {
	  favsites = p;
	  anUpdateContext.set(FAVSITES, p);
  }

  public void setFavsites4UpdateV(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String...  varargsp)
  {
      for(java.lang.String p : varargsp)
	  {
		  addFavsites(p);
	  }
	  
	  anUpdateContext.set(FAVSITES, varargsp);
  }
      
  public void setFavsites4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int i, java.lang.String p)
  {
	  if (favsites == null || favsites.size() <= i)
		  addFavsites4Update(anUpdateContext, p);
	  else
	  {
		  favsites.remove(i);
		  favsites.add(i, p);
		  anUpdateContext.set(String.format(FAVSITES_i, i), p);
	  }
  }

  public void add2setFavsites4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (favsites == null)
		  addFavsites4Update(anUpdateContext , p);
		
	  if (!favsites.contains(p))
      {
         favsites.add(p);      
         anUpdateContext.add(FAVSITES, p, false);
  	  }
  }
  
  public void addFavsites4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  if (favsites == null)
		  favsites = new ArrayList<java.lang.String>();
		
	  favsites.add(p);
      anUpdateContext.add(FAVSITES, p);
  }
  
    
  @Embedded
  private List<PhotoDTO>  photo;
  
  public List<PhotoDTO>   getPhoto()         
  { 
     return photo; 
  }

  public void setPhoto(List<PhotoDTO>  p)         
  { 
     photo = p; 
  }
  
  public void addPhoto(PhotoDTO  p)
  {
	  if (photo == null)
		  photo = new ArrayList<PhotoDTO>();
		
	  photo.add(p);      
  }
    

  public void setPhoto4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , List<PhotoDTO>  p)
  {
	  photo = p;
	  anUpdateContext.set(PHOTO, p);
  }

  public void setPhoto4UpdateV(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , PhotoDTO...  varargsp)
  {
      for(PhotoDTO p : varargsp)
	  {
		  addPhoto(p);
	  }
	  
	  anUpdateContext.set(PHOTO, varargsp);
  }
      
  public void setPhoto4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int i, PhotoDTO p)
  {
	  if (photo == null || photo.size() <= i)
		  addPhoto4Update(anUpdateContext, p);
	  else
	  {
		  photo.remove(i);
		  photo.add(i, p);
		  anUpdateContext.set(String.format(PHOTO_i, i), p);
	  }
  }

  public void add2setPhoto4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , PhotoDTO  p)
  {
	  if (photo == null)
		  addPhoto4Update(anUpdateContext , p);
		
	  if (!photo.contains(p))
      {
         photo.add(p);      
         anUpdateContext.add(PHOTO, p, false);
  	  }
  }
  
  public void addPhoto4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , PhotoDTO  p)
  {
	  if (photo == null)
		  photo = new ArrayList<PhotoDTO>();
		
	  photo.add(p);
      anUpdateContext.add(PHOTO, p);
  }
  
    
  @Embedded
  private AddressDTO  address;
  
  public AddressDTO   getAddress()         
  { 
     return address; 
  }

  public void setAddress(AddressDTO  p)         
  { 
     address = p; 
  }
  
  public void setAddress4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , AddressDTO  p)
  {
	  address = p;
	  anUpdateContext.set(ADDRESS, p);
  }    
    
  @Embedded
  private BusinesscardDTO  businesscard;
  
  public BusinesscardDTO   getBusinesscard()         
  { 
     return businesscard; 
  }

  public void setBusinesscard(BusinesscardDTO  p)         
  { 
     businesscard = p; 
  }
  
  public void setBusinesscard4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , BusinesscardDTO  p)
  {
	  businesscard = p;
	  anUpdateContext.set(BUSINESSCARD, p);
  }    
    
 

  public static final String USERANA_NUMBEROFPOSTS = "userana.numberofposts";
  public static final String USERANA_LASTPOSTACTION = "userana.lastpostaction";
  public static final String USERANA_NUMBEROFCOMMENTS = "userana.numberofcomments";
  public static final String USERANA_LASTCOMMENTACTION = "userana.lastcommentaction";
  public static final String USERANA_LASTPOSTAUTHORID = "userana.lastpostauthorid";
  public static final String USERANA_LASTPOSTAUTHORTYPE = "userana.lastpostauthortype";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class UseranaDTO
  {
  //
  private int  numberofposts;

  public int   getNumberofposts()         
  { 
     return numberofposts; 
  }

  public void setNumberofposts(int  p)         
  { 
     numberofposts = p; 
  }

  public void setUserana_numberofposts4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int  p)
  {
	  numberofposts = p;
	  anUpdateContext.set(USERANA_NUMBEROFPOSTS, p);
  }  
  
  //
  private java.util.Date  lastpostaction;

  public java.util.Date   getLastpostaction()         
  { 
     return lastpostaction; 
  }

  public void setLastpostaction(java.util.Date  p)         
  { 
     lastpostaction = p; 
  }
  
  public void setUserana_lastpostaction4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  lastpostaction = p;
	  anUpdateContext.set(USERANA_LASTPOSTACTION, p);
  }    
  
  //
  private int  numberofcomments;

  public int   getNumberofcomments()         
  { 
     return numberofcomments; 
  }

  public void setNumberofcomments(int  p)         
  { 
     numberofcomments = p; 
  }

  public void setUserana_numberofcomments4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int  p)
  {
	  numberofcomments = p;
	  anUpdateContext.set(USERANA_NUMBEROFCOMMENTS, p);
  }  
  
  //
  private java.util.Date  lastcommentaction;

  public java.util.Date   getLastcommentaction()         
  { 
     return lastcommentaction; 
  }

  public void setLastcommentaction(java.util.Date  p)         
  { 
     lastcommentaction = p; 
  }
  
  public void setUserana_lastcommentaction4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  lastcommentaction = p;
	  anUpdateContext.set(USERANA_LASTCOMMENTACTION, p);
  }    
  
  //
  private java.lang.String  lastpostauthorid;

  public java.lang.String   getLastpostauthorid()         
  { 
     return lastpostauthorid; 
  }

  public void setLastpostauthorid(java.lang.String  p)         
  { 
     lastpostauthorid = p; 
  }

  public void setUserana_lastpostauthorid4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  lastpostauthorid = p;
	  anUpdateContext.set(USERANA_LASTPOSTAUTHORID, p);
  }    
  
  //
  private java.lang.String  lastpostauthortype;

  public java.lang.String   getLastpostauthortype()         
  { 
     return lastpostauthortype; 
  }

  public void setLastpostauthortype(java.lang.String  p)         
  { 
     lastpostauthortype = p; 
  }

  public void setUserana_lastpostauthortype4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  lastpostauthortype = p;
	  anUpdateContext.set(USERANA_LASTPOSTAUTHORTYPE, p);
  }    
  

  }    
  

  public static final String PHOTO_URL = "photo.url";
  public static final String PHOTO_i_URL = "photo.%d.url";
  public static final String PHOTO_CTYPE = "photo.ctype";
  public static final String PHOTO_i_CTYPE = "photo.%d.ctype";
  public static final String PHOTO_WIDTH = "photo.width";
  public static final String PHOTO_i_WIDTH = "photo.%d.width";
  public static final String PHOTO_HEIGHT = "photo.height";
  public static final String PHOTO_i_HEIGHT = "photo.%d.height";
  public static final String PHOTO_ROLE = "photo.role";
  public static final String PHOTO_i_ROLE = "photo.%d.role";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class PhotoDTO
  {
  //
  private java.lang.String  url;

  public java.lang.String   getUrl()         
  { 
     return url; 
  }

  public void setUrl(java.lang.String  p)         
  { 
     url = p; 
  }

  public void setPhoto_i_url4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  url = p;
	  anUpdateContext.set(String.format(PHOTO_i_URL, i), p);
  }    
  
  //
  private java.lang.String  ctype;

  public java.lang.String   getCtype()         
  { 
     return ctype; 
  }

  public void setCtype(java.lang.String  p)         
  { 
     ctype = p; 
  }

  public void setPhoto_i_ctype4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  ctype = p;
	  anUpdateContext.set(String.format(PHOTO_i_CTYPE, i), p);
  }    
  
  //
  private int  width;

  public int   getWidth()         
  { 
     return width; 
  }

  public void setWidth(int  p)         
  { 
     width = p; 
  }

  public void setPhoto_i_width4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int i, int  p)
  {
	  width = p;
	  anUpdateContext.set(String.format(PHOTO_i_WIDTH, i), p);
  }  
  
  //
  private int  height;

  public int   getHeight()         
  { 
     return height; 
  }

  public void setHeight(int  p)         
  { 
     height = p; 
  }

  public void setPhoto_i_height4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int i, int  p)
  {
	  height = p;
	  anUpdateContext.set(String.format(PHOTO_i_HEIGHT, i), p);
  }  
  
  //
  private java.lang.String  role;

  public java.lang.String   getRole()         
  { 
     return role; 
  }

  public void setRole(java.lang.String  p)         
  { 
     role = p; 
  }

  public void setPhoto_i_role4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , int i, java.lang.String  p)
  {
	  role = p;
	  anUpdateContext.set(String.format(PHOTO_i_ROLE, i), p);
  }    
  

  }    
  

  public static final String ADDRESS_FORMATTED = "address.formatted";
  public static final String ADDRESS_SNUMBER = "address.snumber";
  public static final String ADDRESS_ROUTE = "address.route";
  public static final String ADDRESS_LOCALITY = "address.locality";
  public static final String ADDRESS_ADMINAREA_L3 = "address.adminarea_l3";
  public static final String ADDRESS_ADMINAREA_L2 = "address.adminarea_l2";
  public static final String ADDRESS_ADMINAREA_L1 = "address.adminarea_l1";
  public static final String ADDRESS_COUNTRY = "address.country";
  public static final String ADDRESS_POSTCODE = "address.postcode";
  public static final String ADDRESS_GEOM = "address.geom";
  public static final String ADDRESS_GMAPPLACEID = "address.gmapplaceid";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class AddressDTO
  {
  //
  private java.lang.String  formatted;

  public java.lang.String   getFormatted()         
  { 
     return formatted; 
  }

  public void setFormatted(java.lang.String  p)         
  { 
     formatted = p; 
  }

  public void setAddress_formatted4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  formatted = p;
	  anUpdateContext.set(ADDRESS_FORMATTED, p);
  }    
  
  //
  private java.lang.String  snumber;

  public java.lang.String   getSnumber()         
  { 
     return snumber; 
  }

  public void setSnumber(java.lang.String  p)         
  { 
     snumber = p; 
  }

  public void setAddress_snumber4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  snumber = p;
	  anUpdateContext.set(ADDRESS_SNUMBER, p);
  }    
  
  //
  private java.lang.String  route;

  public java.lang.String   getRoute()         
  { 
     return route; 
  }

  public void setRoute(java.lang.String  p)         
  { 
     route = p; 
  }

  public void setAddress_route4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  route = p;
	  anUpdateContext.set(ADDRESS_ROUTE, p);
  }    
  
  //
  private java.lang.String  locality;

  public java.lang.String   getLocality()         
  { 
     return locality; 
  }

  public void setLocality(java.lang.String  p)         
  { 
     locality = p; 
  }

  public void setAddress_locality4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  locality = p;
	  anUpdateContext.set(ADDRESS_LOCALITY, p);
  }    
  
  @Embedded
  private org.r3.db.mongo.MongoGeoCodeLocationName  adminarea_l3;

  public org.r3.db.mongo.MongoGeoCodeLocationName   getAdminarea_l3()         
  { 
     return adminarea_l3; 
  }

  public void setAdminarea_l3(org.r3.db.mongo.MongoGeoCodeLocationName  p)         
  { 
     adminarea_l3 = p; 
  }

  public void setAddress_adminarea_l34Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoGeoCodeLocationName  p)
  {
	  adminarea_l3 = p;
	  anUpdateContext.set(ADDRESS_ADMINAREA_L3, p);
  }    
  
  @Embedded
  private org.r3.db.mongo.MongoGeoCodeLocationName  adminarea_l2;

  public org.r3.db.mongo.MongoGeoCodeLocationName   getAdminarea_l2()         
  { 
     return adminarea_l2; 
  }

  public void setAdminarea_l2(org.r3.db.mongo.MongoGeoCodeLocationName  p)         
  { 
     adminarea_l2 = p; 
  }

  public void setAddress_adminarea_l24Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoGeoCodeLocationName  p)
  {
	  adminarea_l2 = p;
	  anUpdateContext.set(ADDRESS_ADMINAREA_L2, p);
  }    
  
  @Embedded
  private org.r3.db.mongo.MongoGeoCodeLocationName  adminarea_l1;

  public org.r3.db.mongo.MongoGeoCodeLocationName   getAdminarea_l1()         
  { 
     return adminarea_l1; 
  }

  public void setAdminarea_l1(org.r3.db.mongo.MongoGeoCodeLocationName  p)         
  { 
     adminarea_l1 = p; 
  }

  public void setAddress_adminarea_l14Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoGeoCodeLocationName  p)
  {
	  adminarea_l1 = p;
	  anUpdateContext.set(ADDRESS_ADMINAREA_L1, p);
  }    
  
  @Embedded
  private org.r3.db.mongo.MongoGeoCodeLocationName  country;

  public org.r3.db.mongo.MongoGeoCodeLocationName   getCountry()         
  { 
     return country; 
  }

  public void setCountry(org.r3.db.mongo.MongoGeoCodeLocationName  p)         
  { 
     country = p; 
  }

  public void setAddress_country4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , org.r3.db.mongo.MongoGeoCodeLocationName  p)
  {
	  country = p;
	  anUpdateContext.set(ADDRESS_COUNTRY, p);
  }    
  
  //
  private java.lang.String  postcode;

  public java.lang.String   getPostcode()         
  { 
     return postcode; 
  }

  public void setPostcode(java.lang.String  p)         
  { 
     postcode = p; 
  }

  public void setAddress_postcode4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  postcode = p;
	  anUpdateContext.set(ADDRESS_POSTCODE, p);
  }    
  
  @Embedded
  private AddressGeomDTO  geom;

  public AddressGeomDTO   getGeom()         
  { 
     return geom; 
  }

  public void setGeom(AddressGeomDTO  p)         
  { 
     geom = p; 
  }
  
  public void setAddress_geom4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , AddressGeomDTO  p)
  {
	  geom = p;
	  anUpdateContext.set(ADDRESS_GEOM, p);
  }    
  
  //
  private java.lang.String  gmapplaceid;

  public java.lang.String   getGmapplaceid()         
  { 
     return gmapplaceid; 
  }

  public void setGmapplaceid(java.lang.String  p)         
  { 
     gmapplaceid = p; 
  }

  public void setAddress_gmapplaceid4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  gmapplaceid = p;
	  anUpdateContext.set(ADDRESS_GMAPPLACEID, p);
  }    
  

  }    
  

  public static final String ADDRESS_GEOM_LOCATION = "address.geom.location";
  public static final String ADDRESS_GEOM_VIEWPNORTHEAST = "address.geom.viewpnortheast";
  public static final String ADDRESS_GEOM_VIEWPSOUTHWEST = "address.geom.viewpsouthwest";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class AddressGeomDTO
  {
  //
  private org.mongodb.morphia.geo.Point  location;

  public org.mongodb.morphia.geo.Point   getLocation()         
  { 
     return location; 
  }

  public void setLocation(org.mongodb.morphia.geo.Point  p)         
  { 
     location = p; 
  }

  public void setAddress_geom_location4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , org.mongodb.morphia.geo.Point  p)
  {
	  location = p;
	  anUpdateContext.set(ADDRESS_GEOM_LOCATION, p);
  }    
  
  //
  private org.mongodb.morphia.geo.Point  viewpnortheast;

  public org.mongodb.morphia.geo.Point   getViewpnortheast()         
  { 
     return viewpnortheast; 
  }

  public void setViewpnortheast(org.mongodb.morphia.geo.Point  p)         
  { 
     viewpnortheast = p; 
  }

  public void setAddress_geom_viewpnortheast4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , org.mongodb.morphia.geo.Point  p)
  {
	  viewpnortheast = p;
	  anUpdateContext.set(ADDRESS_GEOM_VIEWPNORTHEAST, p);
  }    
  
  //
  private org.mongodb.morphia.geo.Point  viewpsouthwest;

  public org.mongodb.morphia.geo.Point   getViewpsouthwest()         
  { 
     return viewpsouthwest; 
  }

  public void setViewpsouthwest(org.mongodb.morphia.geo.Point  p)         
  { 
     viewpsouthwest = p; 
  }

  public void setAddress_geom_viewpsouthwest4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , org.mongodb.morphia.geo.Point  p)
  {
	  viewpsouthwest = p;
	  anUpdateContext.set(ADDRESS_GEOM_VIEWPSOUTHWEST, p);
  }    
  

  }    
  

  public static final String BUSINESSCARD_PERSONALSTATEMENT = "businesscard.personalstatement";
  public static final String BUSINESSCARD_EMAIL = "businesscard.email";
  public static final String BUSINESSCARD_CELLPHONE = "businesscard.cellphone";

  @Embedded
  @Entity(noClassnameStored=true)
  public static class BusinesscardDTO
  {
  //
  private java.lang.String  personalstatement;

  public java.lang.String   getPersonalstatement()         
  { 
     return personalstatement; 
  }

  public void setPersonalstatement(java.lang.String  p)         
  { 
     personalstatement = p; 
  }

  public void setBusinesscard_personalstatement4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  personalstatement = p;
	  anUpdateContext.set(BUSINESSCARD_PERSONALSTATEMENT, p);
  }    
  
  //
  private java.lang.String  email;

  public java.lang.String   getEmail()         
  { 
     return email; 
  }

  public void setEmail(java.lang.String  p)         
  { 
     email = p; 
  }

  public void setBusinesscard_email4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  email = p;
	  anUpdateContext.set(BUSINESSCARD_EMAIL, p);
  }    
  
  //
  private java.lang.String  cellphone;

  public java.lang.String   getCellphone()         
  { 
     return cellphone; 
  }

  public void setCellphone(java.lang.String  p)         
  { 
     cellphone = p; 
  }

  public void setBusinesscard_cellphone4Update(UpdateOperations<? extends UserCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  cellphone = p;
	  anUpdateContext.set(BUSINESSCARD_CELLPHONE, p);
  }    
  

  }    
  
  
}
