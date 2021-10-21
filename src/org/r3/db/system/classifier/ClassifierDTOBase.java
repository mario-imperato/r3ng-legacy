//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifier;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ClassifierDTOBase")
public class ClassifierDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  clsid;
    protected java.lang.String  clsdescr;
    protected java.lang.String  clstypecode;
    protected java.lang.String  clsambitcode;
    protected java.lang.Integer  cacheinterval;
    protected java.lang.String  etag;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String CLSID_DEFAULT  =  null;
    public static final java.lang.String CLSDESCR_DEFAULT  =  null;
    public static final java.lang.String CLSTYPECODE_DEFAULT  =  null;
    public static final java.lang.String CLSAMBITCODE_DEFAULT  =  null;
    public static final java.lang.Integer CACHEINTERVAL_DEFAULT  =  null;
    public static final java.lang.String ETAG_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int CLSID_DIRTYGROUP  =  0;
    public static final int CLSID_DIRTYMASK   =  2;
    public static final int CLSDESCR_DIRTYGROUP  =  0;
    public static final int CLSDESCR_DIRTYMASK   =  4;
    public static final int CLSTYPECODE_DIRTYGROUP  =  0;
    public static final int CLSTYPECODE_DIRTYMASK   =  8;
    public static final int CLSAMBITCODE_DIRTYGROUP  =  0;
    public static final int CLSAMBITCODE_DIRTYMASK   =  16;
    public static final int CACHEINTERVAL_DIRTYGROUP  =  0;
    public static final int CACHEINTERVAL_DIRTYMASK   =  32;
    public static final int ETAG_DIRTYGROUP  =  0;
    public static final int ETAG_DIRTYMASK   =  64;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public ClassifierDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       clsid = CLSID_DEFAULT;
       clsdescr = CLSDESCR_DEFAULT;
       clstypecode = CLSTYPECODE_DEFAULT;
       clsambitcode = CLSAMBITCODE_DEFAULT;
       cacheinterval = CACHEINTERVAL_DEFAULT;
       etag = ETAG_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ClassifierDTOBase(ClassifierDTOBase another)
    {

       site = another.getSite();
       clsid = another.getClsid();
       clsdescr = another.getClsdescr();
       clstypecode = another.getClstypecode();
       clsambitcode = another.getClsambitcode();
       cacheinterval = another.getCacheinterval();
       etag = another.getEtag();
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
        stb.append(clsid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (clsdescr != null)
        {
        stb.append(clsdescr);
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

    // clsid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClsidDirty()  { return checkFieldDirtiness(CLSID_DIRTYGROUP, CLSID_DIRTYMASK); }

    public java.lang.String   getClsid()         { return clsid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "clsid")
    public java.lang.String   getClsidAsString() { return (clsid == null) ? "" : clsid; }

    // clsid setter methods.
    
    protected void markClsidAsDirty(boolean aFlag)  { markFieldAsDirty(CLSID_DIRTYGROUP, CLSID_DIRTYMASK, aFlag); }


    public void setClsid(String  p)
    {
       setClsid(p, DTOCasingStyle.none);
    }
    
    public void setClsid(String  p, DTOCasingStyle casingStyle)
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
       markClsidAsDirty(!equalsObject(clsid, p));
       clsid = p;
    }

    // clsdescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClsdescrDirty()  { return checkFieldDirtiness(CLSDESCR_DIRTYGROUP, CLSDESCR_DIRTYMASK); }

    public java.lang.String   getClsdescr()         { return clsdescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "clsdescr")
    public java.lang.String   getClsdescrAsString() { return (clsdescr == null) ? "" : clsdescr; }

    // clsdescr setter methods.
    
    protected void markClsdescrAsDirty(boolean aFlag)  { markFieldAsDirty(CLSDESCR_DIRTYGROUP, CLSDESCR_DIRTYMASK, aFlag); }


    public void setClsdescr(String  p)
    {
       setClsdescr(p, DTOCasingStyle.none);
    }
    
    public void setClsdescr(String  p, DTOCasingStyle casingStyle)
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
       markClsdescrAsDirty(!equalsObject(clsdescr, p));
       clsdescr = p;
    }

    // clstypecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClstypecodeDirty()  { return checkFieldDirtiness(CLSTYPECODE_DIRTYGROUP, CLSTYPECODE_DIRTYMASK); }

    public java.lang.String   getClstypecode()         { return clstypecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "clstypecode")
    public java.lang.String   getClstypecodeAsString() { return (clstypecode == null) ? "" : clstypecode; }

    // clstypecode setter methods.
    
    protected void markClstypecodeAsDirty(boolean aFlag)  { markFieldAsDirty(CLSTYPECODE_DIRTYGROUP, CLSTYPECODE_DIRTYMASK, aFlag); }


    public void setClstypecode(String  p)
    {
       setClstypecode(p, DTOCasingStyle.none);
    }
    
    public void setClstypecode(String  p, DTOCasingStyle casingStyle)
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
       markClstypecodeAsDirty(!equalsObject(clstypecode, p));
       clstypecode = p;
    }

    // clsambitcode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClsambitcodeDirty()  { return checkFieldDirtiness(CLSAMBITCODE_DIRTYGROUP, CLSAMBITCODE_DIRTYMASK); }

    public java.lang.String   getClsambitcode()         { return clsambitcode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "clsambitcode")
    public java.lang.String   getClsambitcodeAsString() { return (clsambitcode == null) ? "" : clsambitcode; }

    // clsambitcode setter methods.
    
    protected void markClsambitcodeAsDirty(boolean aFlag)  { markFieldAsDirty(CLSAMBITCODE_DIRTYGROUP, CLSAMBITCODE_DIRTYMASK, aFlag); }


    public void setClsambitcode(String  p)
    {
       setClsambitcode(p, DTOCasingStyle.none);
    }
    
    public void setClsambitcode(String  p, DTOCasingStyle casingStyle)
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
       markClsambitcodeAsDirty(!equalsObject(clsambitcode, p));
       clsambitcode = p;
    }

    // cacheinterval getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCacheintervalDirty()  { return checkFieldDirtiness(CACHEINTERVAL_DIRTYGROUP, CACHEINTERVAL_DIRTYMASK); }

    public java.lang.Integer   getCacheinterval() { return cacheinterval; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cacheinterval")
    public String getCacheintervalAsString() { return integerAsString(cacheinterval); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCacheintervalAsInt()    { return cacheinterval != null ? cacheinterval.intValue() : 0; }

    // cacheinterval setter methods.
    
    protected void markCacheintervalAsDirty(boolean aFlag)  { markFieldAsDirty(CACHEINTERVAL_DIRTYGROUP, CACHEINTERVAL_DIRTYMASK, aFlag); }


    public void setCacheinterval(java.lang.Integer  p)
    {
        markCacheintervalAsDirty(!equalsObject(cacheinterval, p));
    	cacheinterval = p;
    }
    public void setCacheinterval(int p)
    {
    	setCacheinterval(new java.lang.Integer(p));
    }
    public void setCacheinterval()
    {
    	setCacheinterval(0);
    }
    public void setCacheinterval(String  p)
    {
    	setCacheinterval(stringAsInteger(p));
    }

    // etag getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEtagDirty()  { return checkFieldDirtiness(ETAG_DIRTYGROUP, ETAG_DIRTYMASK); }

    public java.lang.String   getEtag()         { return etag; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "etag")
    public java.lang.String   getEtagAsString() { return (etag == null) ? "" : etag; }

    // etag setter methods.
    
    protected void markEtagAsDirty(boolean aFlag)  { markFieldAsDirty(ETAG_DIRTYGROUP, ETAG_DIRTYMASK, aFlag); }


    public void setEtag(String  p)
    {
       setEtag(p, DTOCasingStyle.none);
    }
    
    public void setEtag(String  p, DTOCasingStyle casingStyle)
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
       markEtagAsDirty(!equalsObject(etag, p));
       etag = p;
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
