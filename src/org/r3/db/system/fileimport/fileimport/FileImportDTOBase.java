//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.fileimport.fileimport;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "FileImportDTOBase")
public class FileImportDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  importid;
    protected java.lang.String  importname;
    protected java.lang.String  importcontext;
    protected java.lang.String  majortype;
    protected java.lang.String  minortype;
    protected java.lang.String  withheader;
    protected java.lang.Integer  numberofcolumns;
    protected java.lang.Integer  numberofrecords;
    protected java.sql.Timestamp  uploaddate;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String IMPORTID_DEFAULT  =  null;
    public static final java.lang.String IMPORTNAME_DEFAULT  =  null;
    public static final java.lang.String IMPORTCONTEXT_DEFAULT  =  null;
    public static final java.lang.String MAJORTYPE_DEFAULT  =  null;
    public static final java.lang.String MINORTYPE_DEFAULT  =  null;
    public static final java.lang.String WITHHEADER_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFCOLUMNS_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFRECORDS_DEFAULT  =  null;
    public static final java.sql.Timestamp UPLOADDATE_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int IMPORTID_DIRTYGROUP  =  0;
    public static final int IMPORTID_DIRTYMASK   =  2;
    public static final int IMPORTNAME_DIRTYGROUP  =  0;
    public static final int IMPORTNAME_DIRTYMASK   =  4;
    public static final int IMPORTCONTEXT_DIRTYGROUP  =  0;
    public static final int IMPORTCONTEXT_DIRTYMASK   =  8;
    public static final int MAJORTYPE_DIRTYGROUP  =  0;
    public static final int MAJORTYPE_DIRTYMASK   =  16;
    public static final int MINORTYPE_DIRTYGROUP  =  0;
    public static final int MINORTYPE_DIRTYMASK   =  32;
    public static final int WITHHEADER_DIRTYGROUP  =  0;
    public static final int WITHHEADER_DIRTYMASK   =  64;
    public static final int NUMBEROFCOLUMNS_DIRTYGROUP  =  0;
    public static final int NUMBEROFCOLUMNS_DIRTYMASK   =  128;
    public static final int NUMBEROFRECORDS_DIRTYGROUP  =  0;
    public static final int NUMBEROFRECORDS_DIRTYMASK   =  256;
    public static final int UPLOADDATE_DIRTYGROUP  =  0;
    public static final int UPLOADDATE_DIRTYMASK   =  512;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  1024;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  2048;


    /**
      * DataBean constructor.
      */
    public FileImportDTOBase()
    {
       dirtyFlagsArray = new int[12 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       importid = IMPORTID_DEFAULT;
       importname = IMPORTNAME_DEFAULT;
       importcontext = IMPORTCONTEXT_DEFAULT;
       majortype = MAJORTYPE_DEFAULT;
       minortype = MINORTYPE_DEFAULT;
       withheader = WITHHEADER_DEFAULT;
       numberofcolumns = NUMBEROFCOLUMNS_DEFAULT;
       numberofrecords = NUMBEROFRECORDS_DEFAULT;
       uploaddate = UPLOADDATE_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public FileImportDTOBase(FileImportDTOBase another)
    {

       site = another.getSite();
       importid = another.getImportid();
       importname = another.getImportname();
       importcontext = another.getImportcontext();
       majortype = another.getMajortype();
       minortype = another.getMinortype();
       withheader = another.getWithheader();
       numberofcolumns = another.getNumberofcolumns();
       numberofrecords = another.getNumberofrecords();
       uploaddate = another.getUploaddate();
       recstatus = another.getRecstatus();
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
        stb.append(site);
        stb.append(", ");
        stb.append(importid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (importname != null)
        {
        stb.append(importname);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // site getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSiteDirty()  { return checkFieldDirtiness(SITE_DIRTYGROUP, SITE_DIRTYMASK); }

    public java.lang.String   getSite()         { return site; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "site")
    public java.lang.String   getSiteAsString() { return (site == null) ? "" : site; }

    // site setter methods.
    
    protected void markSiteAsDirty(boolean aFlag)  { markFieldAsDirty(SITE_DIRTYGROUP, SITE_DIRTYMASK, aFlag); }


    public void setSite(String  p)
    {
       setSite(p, DTOCasingStyle.none);
    }
    
    public void setSite(String  p, DTOCasingStyle casingStyle)
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
       markSiteAsDirty(!equalsObject(site, p));
       site = p;
    }

    // importid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImportidDirty()  { return checkFieldDirtiness(IMPORTID_DIRTYGROUP, IMPORTID_DIRTYMASK); }

    public java.lang.String   getImportid()         { return importid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "importid")
    public java.lang.String   getImportidAsString() { return (importid == null) ? "" : importid; }

    // importid setter methods.
    
    protected void markImportidAsDirty(boolean aFlag)  { markFieldAsDirty(IMPORTID_DIRTYGROUP, IMPORTID_DIRTYMASK, aFlag); }


    public void setImportid(String  p)
    {
       setImportid(p, DTOCasingStyle.none);
    }
    
    public void setImportid(String  p, DTOCasingStyle casingStyle)
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
       markImportidAsDirty(!equalsObject(importid, p));
       importid = p;
    }

    // importname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImportnameDirty()  { return checkFieldDirtiness(IMPORTNAME_DIRTYGROUP, IMPORTNAME_DIRTYMASK); }

    public java.lang.String   getImportname()         { return importname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "importname")
    public java.lang.String   getImportnameAsString() { return (importname == null) ? "" : importname; }

    // importname setter methods.
    
    protected void markImportnameAsDirty(boolean aFlag)  { markFieldAsDirty(IMPORTNAME_DIRTYGROUP, IMPORTNAME_DIRTYMASK, aFlag); }


    public void setImportname(String  p)
    {
       setImportname(p, DTOCasingStyle.none);
    }
    
    public void setImportname(String  p, DTOCasingStyle casingStyle)
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
       markImportnameAsDirty(!equalsObject(importname, p));
       importname = p;
    }

    // importcontext getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImportcontextDirty()  { return checkFieldDirtiness(IMPORTCONTEXT_DIRTYGROUP, IMPORTCONTEXT_DIRTYMASK); }

    public java.lang.String   getImportcontext()         { return importcontext; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "importcontext")
    public java.lang.String   getImportcontextAsString() { return (importcontext == null) ? "" : importcontext; }

    // importcontext setter methods.
    
    protected void markImportcontextAsDirty(boolean aFlag)  { markFieldAsDirty(IMPORTCONTEXT_DIRTYGROUP, IMPORTCONTEXT_DIRTYMASK, aFlag); }


    public void setImportcontext(String  p)
    {
       setImportcontext(p, DTOCasingStyle.none);
    }
    
    public void setImportcontext(String  p, DTOCasingStyle casingStyle)
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
       markImportcontextAsDirty(!equalsObject(importcontext, p));
       importcontext = p;
    }

    // majortype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMajortypeDirty()  { return checkFieldDirtiness(MAJORTYPE_DIRTYGROUP, MAJORTYPE_DIRTYMASK); }

    public java.lang.String   getMajortype()         { return majortype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "majortype")
    public java.lang.String   getMajortypeAsString() { return (majortype == null) ? "" : majortype; }

    // majortype setter methods.
    
    protected void markMajortypeAsDirty(boolean aFlag)  { markFieldAsDirty(MAJORTYPE_DIRTYGROUP, MAJORTYPE_DIRTYMASK, aFlag); }


    public void setMajortype(String  p)
    {
       setMajortype(p, DTOCasingStyle.none);
    }
    
    public void setMajortype(String  p, DTOCasingStyle casingStyle)
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
       markMajortypeAsDirty(!equalsObject(majortype, p));
       majortype = p;
    }

    // minortype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMinortypeDirty()  { return checkFieldDirtiness(MINORTYPE_DIRTYGROUP, MINORTYPE_DIRTYMASK); }

    public java.lang.String   getMinortype()         { return minortype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "minortype")
    public java.lang.String   getMinortypeAsString() { return (minortype == null) ? "" : minortype; }

    // minortype setter methods.
    
    protected void markMinortypeAsDirty(boolean aFlag)  { markFieldAsDirty(MINORTYPE_DIRTYGROUP, MINORTYPE_DIRTYMASK, aFlag); }


    public void setMinortype(String  p)
    {
       setMinortype(p, DTOCasingStyle.none);
    }
    
    public void setMinortype(String  p, DTOCasingStyle casingStyle)
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
       markMinortypeAsDirty(!equalsObject(minortype, p));
       minortype = p;
    }

    // withheader getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWithheaderDirty()  { return checkFieldDirtiness(WITHHEADER_DIRTYGROUP, WITHHEADER_DIRTYMASK); }

    public java.lang.String   getWithheader()         { return withheader; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "withheader")
    public java.lang.String   getWithheaderAsString() { return (withheader == null) ? "" : withheader; }

    // withheader setter methods.
    
    protected void markWithheaderAsDirty(boolean aFlag)  { markFieldAsDirty(WITHHEADER_DIRTYGROUP, WITHHEADER_DIRTYMASK, aFlag); }


    public void setWithheader(String  p)
    {
       setWithheader(p, DTOCasingStyle.none);
    }
    
    public void setWithheader(String  p, DTOCasingStyle casingStyle)
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
       markWithheaderAsDirty(!equalsObject(withheader, p));
       withheader = p;
    }

    // numberofcolumns getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofcolumnsDirty()  { return checkFieldDirtiness(NUMBEROFCOLUMNS_DIRTYGROUP, NUMBEROFCOLUMNS_DIRTYMASK); }

    public java.lang.Integer   getNumberofcolumns() { return numberofcolumns; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numberofcolumns")
    public String getNumberofcolumnsAsString() { return integerAsString(numberofcolumns); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofcolumnsAsInt()    { return numberofcolumns != null ? numberofcolumns.intValue() : 0; }

    // numberofcolumns setter methods.
    
    protected void markNumberofcolumnsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFCOLUMNS_DIRTYGROUP, NUMBEROFCOLUMNS_DIRTYMASK, aFlag); }


    public void setNumberofcolumns(java.lang.Integer  p)
    {
        markNumberofcolumnsAsDirty(!equalsObject(numberofcolumns, p));
    	numberofcolumns = p;
    }
    public void setNumberofcolumns(int p)
    {
    	setNumberofcolumns(new java.lang.Integer(p));
    }
    public void setNumberofcolumns()
    {
    	setNumberofcolumns(0);
    }
    public void setNumberofcolumns(String  p)
    {
    	setNumberofcolumns(stringAsInteger(p));
    }

    // numberofrecords getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofrecordsDirty()  { return checkFieldDirtiness(NUMBEROFRECORDS_DIRTYGROUP, NUMBEROFRECORDS_DIRTYMASK); }

    public java.lang.Integer   getNumberofrecords() { return numberofrecords; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numberofrecords")
    public String getNumberofrecordsAsString() { return integerAsString(numberofrecords); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofrecordsAsInt()    { return numberofrecords != null ? numberofrecords.intValue() : 0; }

    // numberofrecords setter methods.
    
    protected void markNumberofrecordsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFRECORDS_DIRTYGROUP, NUMBEROFRECORDS_DIRTYMASK, aFlag); }


    public void setNumberofrecords(java.lang.Integer  p)
    {
        markNumberofrecordsAsDirty(!equalsObject(numberofrecords, p));
    	numberofrecords = p;
    }
    public void setNumberofrecords(int p)
    {
    	setNumberofrecords(new java.lang.Integer(p));
    }
    public void setNumberofrecords()
    {
    	setNumberofrecords(0);
    }
    public void setNumberofrecords(String  p)
    {
    	setNumberofrecords(stringAsInteger(p));
    }

    // uploaddate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUploaddateDirty()  { return checkFieldDirtiness(UPLOADDATE_DIRTYGROUP, UPLOADDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getUploaddate() { return uploaddate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "uploaddate")
    public String getUploaddateAsString() { return timestampAsString(uploaddate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getUploaddateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(uploaddate, aDateFormat); }

    // uploaddate setter methods.
    
    protected void markUploaddateAsDirty(boolean aFlag)  { markFieldAsDirty(UPLOADDATE_DIRTYGROUP, UPLOADDATE_DIRTYMASK, aFlag); }


    public void setUploaddate(java.sql.Timestamp  p)
    {
        markUploaddateAsDirty(!equalsObject(uploaddate, p));
    	uploaddate = p;
    }
    public void setUploaddate(String  p, java.text.DateFormat aDateFormat)
    {
    	setUploaddate(stringAsTimestamp(p, aDateFormat));
    }

    // recstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRecstatusDirty()  { return checkFieldDirtiness(RECSTATUS_DIRTYGROUP, RECSTATUS_DIRTYMASK); }

    public java.lang.String   getRecstatus()         { return recstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "recstatus")
    public java.lang.String   getRecstatusAsString() { return (recstatus == null) ? "" : recstatus; }

    // recstatus setter methods.
    
    protected void markRecstatusAsDirty(boolean aFlag)  { markFieldAsDirty(RECSTATUS_DIRTYGROUP, RECSTATUS_DIRTYMASK, aFlag); }


    public void setRecstatus(String  p)
    {
       setRecstatus(p, DTOCasingStyle.none);
    }
    
    public void setRecstatus(String  p, DTOCasingStyle casingStyle)
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
       markRecstatusAsDirty(!equalsObject(recstatus, p));
       recstatus = p;
    }

    // rectimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRectimestampDirty()  { return checkFieldDirtiness(RECTIMESTAMP_DIRTYGROUP, RECTIMESTAMP_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
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
