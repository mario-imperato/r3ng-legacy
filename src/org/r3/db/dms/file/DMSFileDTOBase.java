//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.file;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "DMSFileDTOBase")
public class DMSFileDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  fileid;
    protected java.lang.String  filename;
    protected java.lang.String  mimetype;
    protected java.lang.Long  filelength;
    protected java.lang.String  filephysicalpath;
    protected java.lang.String  folderid;
    protected java.sql.Timestamp  creationdate;

    public static final java.lang.String FILEID_DEFAULT  =  null;
    public static final java.lang.String FILENAME_DEFAULT  =  null;
    public static final java.lang.String MIMETYPE_DEFAULT  =  null;
    public static final java.lang.Long FILELENGTH_DEFAULT  =  null;
    public static final java.lang.String FILEPHYSICALPATH_DEFAULT  =  null;
    public static final java.lang.String FOLDERID_DEFAULT  =  null;
    public static final java.sql.Timestamp CREATIONDATE_DEFAULT  =  null;

    public static final int FILEID_DIRTYGROUP  =  0;
    public static final int FILEID_DIRTYMASK   =  1;
    public static final int FILENAME_DIRTYGROUP  =  0;
    public static final int FILENAME_DIRTYMASK   =  2;
    public static final int MIMETYPE_DIRTYGROUP  =  0;
    public static final int MIMETYPE_DIRTYMASK   =  4;
    public static final int FILELENGTH_DIRTYGROUP  =  0;
    public static final int FILELENGTH_DIRTYMASK   =  8;
    public static final int FILEPHYSICALPATH_DIRTYGROUP  =  0;
    public static final int FILEPHYSICALPATH_DIRTYMASK   =  16;
    public static final int FOLDERID_DIRTYGROUP  =  0;
    public static final int FOLDERID_DIRTYMASK   =  64;
    public static final int CREATIONDATE_DIRTYGROUP  =  0;
    public static final int CREATIONDATE_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public DMSFileDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       fileid = FILEID_DEFAULT;
       filename = FILENAME_DEFAULT;
       mimetype = MIMETYPE_DEFAULT;
       filelength = FILELENGTH_DEFAULT;
       filephysicalpath = FILEPHYSICALPATH_DEFAULT;
       folderid = FOLDERID_DEFAULT;
       creationdate = CREATIONDATE_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public DMSFileDTOBase(DMSFileDTOBase another)
    {

       fileid = another.getFileid();
       filename = another.getFilename();
       mimetype = another.getMimetype();
       filelength = another.getFilelength();
       filephysicalpath = another.getFilephysicalpath();
       folderid = another.getFolderid();
       creationdate = another.getCreationdate();

       dirtyFlagsArray = another.getCopyOfDirtyFlags();
    }

    public void clearDirtyFlags()
    {
       for(int i = 0; i < dirtyFlagsArray.length; i++)
            dirtyFlagsArray[i] = 0;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient
    public int[] getCopyOfDirtyFlags()
    {
       int[] copyOf = new int[dirtyFlagsArray.length];
       for(int i = 0; i < dirtyFlagsArray.length; i++)
            copyOf[i] = dirtyFlagsArray[i];

       return copyOf;
    }

    protected void markFieldAsDirty(int mainIndex, int bitwiseIndex, boolean aFlag)
    {
       if (aFlag)
          dirtyFlagsArray[mainIndex] = dirtyFlagsArray[mainIndex] | bitwiseIndex;
       else
          dirtyFlagsArray[mainIndex] = dirtyFlagsArray[mainIndex] & ~bitwiseIndex;
    }

    protected boolean checkFieldDirtiness(int mainIndex, int bitwiseIndex)
    {
       return (dirtyFlagsArray[mainIndex] & bitwiseIndex) != 0;
    }

    public String getDtokey()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(fileid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(filename);
        return stb.toString();
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // fileid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFileidDirty()  { return checkFieldDirtiness(FILEID_DIRTYGROUP, FILEID_DIRTYMASK); }

    public java.lang.String   getFileid()         { return fileid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFileidAsString() { return (fileid == null) ? "" : fileid; }

    // fileid setter methods.
    
    protected void markFileidAsDirty(boolean aFlag)  { markFieldAsDirty(FILEID_DIRTYGROUP, FILEID_DIRTYMASK, aFlag); }


    public void setFileid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFileidAsDirty(!equalsObject(fileid, p));
         fileid = p;
    }

    // filename getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFilenameDirty()  { return checkFieldDirtiness(FILENAME_DIRTYGROUP, FILENAME_DIRTYMASK); }

    public java.lang.String   getFilename()         { return filename; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFilenameAsString() { return (filename == null) ? "" : filename; }

    // filename setter methods.
    
    protected void markFilenameAsDirty(boolean aFlag)  { markFieldAsDirty(FILENAME_DIRTYGROUP, FILENAME_DIRTYMASK, aFlag); }


    public void setFilename(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFilenameAsDirty(!equalsObject(filename, p));
         filename = p;
    }

    // mimetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMimetypeDirty()  { return checkFieldDirtiness(MIMETYPE_DIRTYGROUP, MIMETYPE_DIRTYMASK); }

    public java.lang.String   getMimetype()         { return mimetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getMimetypeAsString() { return (mimetype == null) ? "" : mimetype; }

    // mimetype setter methods.
    
    protected void markMimetypeAsDirty(boolean aFlag)  { markFieldAsDirty(MIMETYPE_DIRTYGROUP, MIMETYPE_DIRTYMASK, aFlag); }


    public void setMimetype(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markMimetypeAsDirty(!equalsObject(mimetype, p));
         mimetype = p;
    }

    // filelength getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFilelengthDirty()  { return checkFieldDirtiness(FILELENGTH_DIRTYGROUP, FILELENGTH_DIRTYMASK); }

    public java.lang.Long   getFilelength() { return filelength; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getFilelengthAsString() { return longAsString(filelength); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public long   getFilelengthAsLong()    { return filelength != null ? filelength.longValue() : 0L; }

    // filelength setter methods.
    
    protected void markFilelengthAsDirty(boolean aFlag)  { markFieldAsDirty(FILELENGTH_DIRTYGROUP, FILELENGTH_DIRTYMASK, aFlag); }


    public void setFilelength(java.lang.Long  p)
    {
    	markFilelengthAsDirty(!equalsObject(filelength, p));
    	filelength = p;
    }
    public void setFilelength(long p)
    {
    	setFilelength(new java.lang.Long(p));
    }
    public void setFilelength()
    {
    	setFilelength(0L);
    }
    public void setFilelength(String  p)
    {
    	setFilelength(stringAsLong(p));
    }

    // filephysicalpath getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFilephysicalpathDirty()  { return checkFieldDirtiness(FILEPHYSICALPATH_DIRTYGROUP, FILEPHYSICALPATH_DIRTYMASK); }

    public java.lang.String   getFilephysicalpath()         { return filephysicalpath; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFilephysicalpathAsString() { return (filephysicalpath == null) ? "" : filephysicalpath; }

    // filephysicalpath setter methods.
    
    protected void markFilephysicalpathAsDirty(boolean aFlag)  { markFieldAsDirty(FILEPHYSICALPATH_DIRTYGROUP, FILEPHYSICALPATH_DIRTYMASK, aFlag); }


    public void setFilephysicalpath(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFilephysicalpathAsDirty(!equalsObject(filephysicalpath, p));
         filephysicalpath = p;
    }

    // folderid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFolderidDirty()  { return checkFieldDirtiness(FOLDERID_DIRTYGROUP, FOLDERID_DIRTYMASK); }

    public java.lang.String   getFolderid()         { return folderid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFolderidAsString() { return (folderid == null) ? "" : folderid; }

    // folderid setter methods.
    
    protected void markFolderidAsDirty(boolean aFlag)  { markFieldAsDirty(FOLDERID_DIRTYGROUP, FOLDERID_DIRTYMASK, aFlag); }


    public void setFolderid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFolderidAsDirty(!equalsObject(folderid, p));
         folderid = p;
    }

    // creationdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCreationdateDirty()  { return checkFieldDirtiness(CREATIONDATE_DIRTYGROUP, CREATIONDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getCreationdate() { return creationdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCreationdateAsString() { return timestampAsString(creationdate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCreationdateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(creationdate, aDateFormat); }

    // creationdate setter methods.
    
    protected void markCreationdateAsDirty(boolean aFlag)  { markFieldAsDirty(CREATIONDATE_DIRTYGROUP, CREATIONDATE_DIRTYMASK, aFlag); }


    public void setCreationdate(java.sql.Timestamp  p)
    {
        markCreationdateAsDirty(!equalsObject(creationdate, p));
    	creationdate = p;
    }
    public void setCreationdate(String  p, java.text.DateFormat aDateFormat)
    {
    	setCreationdate(stringAsTimestamp(p, aDateFormat));
    }

}
