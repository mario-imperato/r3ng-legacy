//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.lut;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "LUTDictionaryDTOBase")
public class LUTDictionaryDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  lutid;
    protected java.lang.Integer  cacheinterval;
    protected java.lang.Integer  invalidcount;
    protected java.lang.String  targetsite;
    protected java.lang.String  etag;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String LUTID_DEFAULT  =  null;
    public static final java.lang.Integer CACHEINTERVAL_DEFAULT  =  null;
    public static final java.lang.Integer INVALIDCOUNT_DEFAULT  =  null;
    public static final java.lang.String TARGETSITE_DEFAULT  =  null;
    public static final java.lang.String ETAG_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int LUTID_DIRTYGROUP  =  0;
    public static final int LUTID_DIRTYMASK   =  1;
    public static final int CACHEINTERVAL_DIRTYGROUP  =  0;
    public static final int CACHEINTERVAL_DIRTYMASK   =  2;
    public static final int INVALIDCOUNT_DIRTYGROUP  =  0;
    public static final int INVALIDCOUNT_DIRTYMASK   =  4;
    public static final int TARGETSITE_DIRTYGROUP  =  0;
    public static final int TARGETSITE_DIRTYMASK   =  8;
    public static final int ETAG_DIRTYGROUP  =  0;
    public static final int ETAG_DIRTYMASK   =  16;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  32;


    /**
      * DataBean constructor.
      */
    public LUTDictionaryDTOBase()
    {
       dirtyFlagsArray = new int[6 / 30 + 1];
       clearDirtyFlags();

       lutid = LUTID_DEFAULT;
       cacheinterval = CACHEINTERVAL_DEFAULT;
       invalidcount = INVALIDCOUNT_DEFAULT;
       targetsite = TARGETSITE_DEFAULT;
       etag = ETAG_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public LUTDictionaryDTOBase(LUTDictionaryDTOBase another)
    {

       lutid = another.getLutid();
       cacheinterval = another.getCacheinterval();
       invalidcount = another.getInvalidcount();
       targetsite = another.getTargetsite();
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
        stb.append(lutid);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // lutid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLutidDirty()  { return checkFieldDirtiness(LUTID_DIRTYGROUP, LUTID_DIRTYMASK); }

    public java.lang.String   getLutid()         { return lutid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getLutidAsString() { return (lutid == null) ? "" : lutid; }

    // lutid setter methods.
    
    protected void markLutidAsDirty(boolean aFlag)  { markFieldAsDirty(LUTID_DIRTYGROUP, LUTID_DIRTYMASK, aFlag); }


    public void setLutid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markLutidAsDirty(!equalsObject(lutid, p));
         lutid = p;
    }

    // cacheinterval getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCacheintervalDirty()  { return checkFieldDirtiness(CACHEINTERVAL_DIRTYGROUP, CACHEINTERVAL_DIRTYMASK); }

    public java.lang.Integer   getCacheinterval() { return cacheinterval; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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

    // invalidcount getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isInvalidcountDirty()  { return checkFieldDirtiness(INVALIDCOUNT_DIRTYGROUP, INVALIDCOUNT_DIRTYMASK); }

    public java.lang.Integer   getInvalidcount() { return invalidcount; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getInvalidcountAsString() { return integerAsString(invalidcount); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getInvalidcountAsInt()    { return invalidcount != null ? invalidcount.intValue() : 0; }

    // invalidcount setter methods.
    
    protected void markInvalidcountAsDirty(boolean aFlag)  { markFieldAsDirty(INVALIDCOUNT_DIRTYGROUP, INVALIDCOUNT_DIRTYMASK, aFlag); }


    public void setInvalidcount(java.lang.Integer  p)
    {
        markInvalidcountAsDirty(!equalsObject(invalidcount, p));
    	invalidcount = p;
    }
    public void setInvalidcount(int p)
    {
    	setInvalidcount(new java.lang.Integer(p));
    }
    public void setInvalidcount()
    {
    	setInvalidcount(0);
    }
    public void setInvalidcount(String  p)
    {
    	setInvalidcount(stringAsInteger(p));
    }

    // targetsite getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTargetsiteDirty()  { return checkFieldDirtiness(TARGETSITE_DIRTYGROUP, TARGETSITE_DIRTYMASK); }

    public java.lang.String   getTargetsite()         { return targetsite; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getTargetsiteAsString() { return (targetsite == null) ? "" : targetsite; }

    // targetsite setter methods.
    
    protected void markTargetsiteAsDirty(boolean aFlag)  { markFieldAsDirty(TARGETSITE_DIRTYGROUP, TARGETSITE_DIRTYMASK, aFlag); }


    public void setTargetsite(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markTargetsiteAsDirty(!equalsObject(targetsite, p));
         targetsite = p;
    }

    // etag getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEtagDirty()  { return checkFieldDirtiness(ETAG_DIRTYGROUP, ETAG_DIRTYMASK); }

    public java.lang.String   getEtag()         { return etag; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getEtagAsString() { return (etag == null) ? "" : etag; }

    // etag setter methods.
    
    protected void markEtagAsDirty(boolean aFlag)  { markFieldAsDirty(ETAG_DIRTYGROUP, ETAG_DIRTYMASK, aFlag); }


    public void setEtag(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
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
