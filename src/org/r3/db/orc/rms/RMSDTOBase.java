//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.orc.rms;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "RMSDTOBase")
public class RMSDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  rmsid;
    protected java.lang.String  filename;
    protected java.lang.String  fileurl;
    protected java.lang.Integer  filesize;
    protected java.lang.Integer  numberofcerts;
    protected java.lang.Integer  numberofdupcerts;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String RMSID_DEFAULT  =  null;
    public static final java.lang.String FILENAME_DEFAULT  =  null;
    public static final java.lang.String FILEURL_DEFAULT  =  null;
    public static final java.lang.Integer FILESIZE_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFCERTS_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFDUPCERTS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int RMSID_DIRTYGROUP  =  0;
    public static final int RMSID_DIRTYMASK   =  1;
    public static final int FILENAME_DIRTYGROUP  =  0;
    public static final int FILENAME_DIRTYMASK   =  2;
    public static final int FILEURL_DIRTYGROUP  =  0;
    public static final int FILEURL_DIRTYMASK   =  4;
    public static final int FILESIZE_DIRTYGROUP  =  0;
    public static final int FILESIZE_DIRTYMASK   =  8;
    public static final int NUMBEROFCERTS_DIRTYGROUP  =  0;
    public static final int NUMBEROFCERTS_DIRTYMASK   =  16;
    public static final int NUMBEROFDUPCERTS_DIRTYGROUP  =  0;
    public static final int NUMBEROFDUPCERTS_DIRTYMASK   =  32;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  64;


    /**
      * DataBean constructor.
      */
    public RMSDTOBase()
    {
       dirtyFlagsArray = new int[7 / 30 + 1];
       clearDirtyFlags();

       rmsid = RMSID_DEFAULT;
       filename = FILENAME_DEFAULT;
       fileurl = FILEURL_DEFAULT;
       filesize = FILESIZE_DEFAULT;
       numberofcerts = NUMBEROFCERTS_DEFAULT;
       numberofdupcerts = NUMBEROFDUPCERTS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public RMSDTOBase(RMSDTOBase another)
    {

       rmsid = another.getRmsid();
       filename = another.getFilename();
       fileurl = another.getFileurl();
       filesize = another.getFilesize();
       numberofcerts = another.getNumberofcerts();
       numberofdupcerts = another.getNumberofdupcerts();
       rectimestamp = another.getRectimestamp();

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
        stb.append(rmsid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (filename != null)
        {
        stb.append(filename);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // rmsid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRmsidDirty()  { return checkFieldDirtiness(RMSID_DIRTYGROUP, RMSID_DIRTYMASK); }

    public java.lang.String   getRmsid()         { return rmsid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "rmsid")
    public java.lang.String   getRmsidAsString() { return (rmsid == null) ? "" : rmsid; }

    // rmsid setter methods.
    
    protected void markRmsidAsDirty(boolean aFlag)  { markFieldAsDirty(RMSID_DIRTYGROUP, RMSID_DIRTYMASK, aFlag); }


    public void setRmsid(String  p)
    {
       setRmsid(p, DTOCasingStyle.none);
    }
    
    public void setRmsid(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markRmsidAsDirty(!equalsObject(rmsid, p));
       rmsid = p;
    }

    // filename getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFilenameDirty()  { return checkFieldDirtiness(FILENAME_DIRTYGROUP, FILENAME_DIRTYMASK); }

    public java.lang.String   getFilename()         { return filename; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "filename")
    public java.lang.String   getFilenameAsString() { return (filename == null) ? "" : filename; }

    // filename setter methods.
    
    protected void markFilenameAsDirty(boolean aFlag)  { markFieldAsDirty(FILENAME_DIRTYGROUP, FILENAME_DIRTYMASK, aFlag); }


    public void setFilename(String  p)
    {
       setFilename(p, DTOCasingStyle.none);
    }
    
    public void setFilename(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markFilenameAsDirty(!equalsObject(filename, p));
       filename = p;
    }

    // fileurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFileurlDirty()  { return checkFieldDirtiness(FILEURL_DIRTYGROUP, FILEURL_DIRTYMASK); }

    public java.lang.String   getFileurl()         { return fileurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "fileurl")
    public java.lang.String   getFileurlAsString() { return (fileurl == null) ? "" : fileurl; }

    // fileurl setter methods.
    
    protected void markFileurlAsDirty(boolean aFlag)  { markFieldAsDirty(FILEURL_DIRTYGROUP, FILEURL_DIRTYMASK, aFlag); }


    public void setFileurl(String  p)
    {
       setFileurl(p, DTOCasingStyle.none);
    }
    
    public void setFileurl(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markFileurlAsDirty(!equalsObject(fileurl, p));
       fileurl = p;
    }

    // filesize getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFilesizeDirty()  { return checkFieldDirtiness(FILESIZE_DIRTYGROUP, FILESIZE_DIRTYMASK); }

    public java.lang.Integer   getFilesize() { return filesize; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "filesize")
    public String getFilesizeAsString() { return integerAsString(filesize); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getFilesizeAsInt()    { return filesize != null ? filesize.intValue() : 0; }

    // filesize setter methods.
    
    protected void markFilesizeAsDirty(boolean aFlag)  { markFieldAsDirty(FILESIZE_DIRTYGROUP, FILESIZE_DIRTYMASK, aFlag); }


    public void setFilesize(java.lang.Integer  p)
    {
        markFilesizeAsDirty(!equalsObject(filesize, p));
    	filesize = p;
    }
    public void setFilesize(int p)
    {
    	setFilesize(new java.lang.Integer(p));
    }
    public void setFilesize()
    {
    	setFilesize(0);
    }
    public void setFilesize(String  p)
    {
    	setFilesize(stringAsInteger(p));
    }

    // numberofcerts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofcertsDirty()  { return checkFieldDirtiness(NUMBEROFCERTS_DIRTYGROUP, NUMBEROFCERTS_DIRTYMASK); }

    public java.lang.Integer   getNumberofcerts() { return numberofcerts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numberofcerts")
    public String getNumberofcertsAsString() { return integerAsString(numberofcerts); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofcertsAsInt()    { return numberofcerts != null ? numberofcerts.intValue() : 0; }

    // numberofcerts setter methods.
    
    protected void markNumberofcertsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFCERTS_DIRTYGROUP, NUMBEROFCERTS_DIRTYMASK, aFlag); }


    public void setNumberofcerts(java.lang.Integer  p)
    {
        markNumberofcertsAsDirty(!equalsObject(numberofcerts, p));
    	numberofcerts = p;
    }
    public void setNumberofcerts(int p)
    {
    	setNumberofcerts(new java.lang.Integer(p));
    }
    public void setNumberofcerts()
    {
    	setNumberofcerts(0);
    }
    public void setNumberofcerts(String  p)
    {
    	setNumberofcerts(stringAsInteger(p));
    }

    // numberofdupcerts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofdupcertsDirty()  { return checkFieldDirtiness(NUMBEROFDUPCERTS_DIRTYGROUP, NUMBEROFDUPCERTS_DIRTYMASK); }

    public java.lang.Integer   getNumberofdupcerts() { return numberofdupcerts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numberofdupcerts")
    public String getNumberofdupcertsAsString() { return integerAsString(numberofdupcerts); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofdupcertsAsInt()    { return numberofdupcerts != null ? numberofdupcerts.intValue() : 0; }

    // numberofdupcerts setter methods.
    
    protected void markNumberofdupcertsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFDUPCERTS_DIRTYGROUP, NUMBEROFDUPCERTS_DIRTYMASK, aFlag); }


    public void setNumberofdupcerts(java.lang.Integer  p)
    {
        markNumberofdupcertsAsDirty(!equalsObject(numberofdupcerts, p));
    	numberofdupcerts = p;
    }
    public void setNumberofdupcerts(int p)
    {
    	setNumberofdupcerts(new java.lang.Integer(p));
    }
    public void setNumberofdupcerts()
    {
    	setNumberofdupcerts(0);
    }
    public void setNumberofdupcerts(String  p)
    {
    	setNumberofdupcerts(stringAsInteger(p));
    }

    // rectimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRectimestampDirty()  { return checkFieldDirtiness(RECTIMESTAMP_DIRTYGROUP, RECTIMESTAMP_DIRTYMASK); }

    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getRectimestamp() { return rectimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "rectimestamp")
    public String getRectimestampAsString() { return timestampAsString(rectimestamp, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getRectimestampAsString(java.text.DateFormat aDateFormat) { return timestampAsString(rectimestamp, aDateFormat); }

    // rectimestamp setter methods.
    
    protected void markRectimestampAsDirty(boolean aFlag)  { markFieldAsDirty(RECTIMESTAMP_DIRTYGROUP, RECTIMESTAMP_DIRTYMASK, aFlag); }


    public void setRectimestamp(java.sql.Timestamp  p)
    {
        markRectimestampAsDirty(!equalsObject(rectimestamp, p));
    	rectimestamp = p;
    }
    public void setRectimestamp(String  p, java.text.DateFormat aDateFormat)
    {
    	setRectimestamp(stringAsTimestamp(p, aDateFormat));
    }

}
