//
// Understanding Department - 2016 
//
//
// Mongo - TODO: Readme Section.
//




package org.r3.db.mongo.filecollection;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Serialized;
import org.mongodb.morphia.query.UpdateOperations;
import org.r3.db.MongoDbSchemaInfo;
import org.r3.db.utils.MongoUtils;

/*
 * Please Define in MongoDbSchemaInfo: public static final String MongoDbFileCollectionName = "r3_filecollection";
 */
@Entity(value=MongoDbSchemaInfo.MongoDbFileCollectionName, noClassnameStored=true)
public class FileCollectionDTOBase extends org.r3.db.MongoDTOBase
{
  public static final String FILEID = "_id";
  public static final String WIDTH = "width";
  public static final String HEIGHT = "height";
  public static final String MASTERFILE = "masterfile";
  public static final String NAME = "name";
  public static final String CONTENTTYPE = "contenttype";
  public static final String MAJORROLE = "majorrole";
  public static final String MINORROLE = "minorrole";
  public static final String SITE = "site";
  public static final String LANGUAGE = "language";
  public static final String REFAMBIT = "refambit";
  public static final String REFSUBAMBIT = "refsubambit";
  public static final String REFMAINENTITY = "refmainentity";
  public static final String REFSUBENTITY = "refsubentity";
  public static final String SIZE = "size";
  public static final String DATA = "data";
  public static final String CREATIONDATE = "creationdate";
  public static final String STATUS = "status";

  @Id
  private org.bson.types.ObjectId  fileid;
  
  public org.bson.types.ObjectId   getFileid()         
  { 
     return fileid; 
  }

  public void setFileid(org.bson.types.ObjectId  p)         
  { 
     fileid = p; 
  }

  public void setFileid(java.lang.String  p)         
  { 
     fileid = MongoUtils.getObjectIdFromString(p); 
  }
  
  public void setFileid4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , org.bson.types.ObjectId  p)
  {
	  fileid = p;
	  anUpdateContext.set(FILEID, p);
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

  public void setWidth4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , int  p)
  {
	  width = p;
	  anUpdateContext.set(WIDTH, p);
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

  public void setHeight4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , int  p)
  {
	  height = p;
	  anUpdateContext.set(HEIGHT, p);
  }  
    
  //
  private java.lang.String  masterfile;
  
  public java.lang.String   getMasterfile()         
  { 
     return masterfile; 
  }

  public void setMasterfile(java.lang.String  p)         
  { 
     masterfile = p; 
  }

  public void setMasterfile4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  masterfile = p;
	  anUpdateContext.set(MASTERFILE, p);
  }    
    
  //
  private java.lang.String  name;
  
  public java.lang.String   getName()         
  { 
     return name; 
  }

  public void setName(java.lang.String  p)         
  { 
     name = p; 
  }

  public void setName4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  name = p;
	  anUpdateContext.set(NAME, p);
  }    
    
  //
  private java.lang.String  contenttype;
  
  public java.lang.String   getContenttype()         
  { 
     return contenttype; 
  }

  public void setContenttype(java.lang.String  p)         
  { 
     contenttype = p; 
  }

  public void setContenttype4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  contenttype = p;
	  anUpdateContext.set(CONTENTTYPE, p);
  }    
    
  //
  private java.lang.String  majorrole;
  
  public java.lang.String   getMajorrole()         
  { 
     return majorrole; 
  }

  public void setMajorrole(java.lang.String  p)         
  { 
     majorrole = p; 
  }

  public void setMajorrole4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  majorrole = p;
	  anUpdateContext.set(MAJORROLE, p);
  }    
    
  //
  private java.lang.String  minorrole;
  
  public java.lang.String   getMinorrole()         
  { 
     return minorrole; 
  }

  public void setMinorrole(java.lang.String  p)         
  { 
     minorrole = p; 
  }

  public void setMinorrole4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  minorrole = p;
	  anUpdateContext.set(MINORROLE, p);
  }    
    
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

  public void setSite4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  site = p;
	  anUpdateContext.set(SITE, p);
  }    
    
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

  public void setLanguage4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  language = p;
	  anUpdateContext.set(LANGUAGE, p);
  }    
    
  //
  private java.lang.String  refambit;
  
  public java.lang.String   getRefambit()         
  { 
     return refambit; 
  }

  public void setRefambit(java.lang.String  p)         
  { 
     refambit = p; 
  }

  public void setRefambit4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  refambit = p;
	  anUpdateContext.set(REFAMBIT, p);
  }    
    
  //
  private java.lang.String  refsubambit;
  
  public java.lang.String   getRefsubambit()         
  { 
     return refsubambit; 
  }

  public void setRefsubambit(java.lang.String  p)         
  { 
     refsubambit = p; 
  }

  public void setRefsubambit4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  refsubambit = p;
	  anUpdateContext.set(REFSUBAMBIT, p);
  }    
    
  //
  private java.lang.String  refmainentity;
  
  public java.lang.String   getRefmainentity()         
  { 
     return refmainentity; 
  }

  public void setRefmainentity(java.lang.String  p)         
  { 
     refmainentity = p; 
  }

  public void setRefmainentity4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  refmainentity = p;
	  anUpdateContext.set(REFMAINENTITY, p);
  }    
    
  //
  private java.lang.String  refsubentity;
  
  public java.lang.String   getRefsubentity()         
  { 
     return refsubentity; 
  }

  public void setRefsubentity(java.lang.String  p)         
  { 
     refsubentity = p; 
  }

  public void setRefsubentity4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  refsubentity = p;
	  anUpdateContext.set(REFSUBENTITY, p);
  }    
    
  //
  private long  size;
  
  public long   getSize()         
  { 
     return size; 
  }

  public void setSize(long  p)         
  { 
     size = p; 
  }

  public void setSize4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , long  p)
  {
	  size = p;
	  anUpdateContext.set(SIZE, p);
  }  
    
  @Serialized
  private org.bson.types.Binary  data;
  
  public org.bson.types.Binary   getData()         
  { 
     return data; 
  }

  public void setData(org.bson.types.Binary  p)         
  { 
     data = p; 
  }

  public void setData4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , org.bson.types.Binary  p)
  {
	  data = p;
	  anUpdateContext.set(DATA, p);
  }    
    
  //
  private java.util.Date  creationdate;
  
  public java.util.Date   getCreationdate()         
  { 
     return creationdate; 
  }

  public void setCreationdate(java.util.Date  p)         
  { 
     creationdate = p; 
  }
  
  public void setCreationdate4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.util.Date  p)
  {
	  creationdate = p;
	  anUpdateContext.set(CREATIONDATE, p);
  }    
    
  //
  private java.lang.String  status;
  
  public java.lang.String   getStatus()         
  { 
     return status; 
  }

  public void setStatus(java.lang.String  p)         
  { 
     status = p; 
  }

  public void setStatus4Update(UpdateOperations<? extends FileCollectionDTOBase> anUpdateContext , java.lang.String  p)
  {
	  status = p;
	  anUpdateContext.set(STATUS, p);
  }    
    
 
  
}
