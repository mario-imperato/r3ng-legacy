//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appeventlogview;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SailApplicationEventLogViewDTOBase")
public class SailApplicationEventLogViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  usecaseambit;
    protected java.lang.String  applicationid;
    protected java.lang.String  userid;
    protected java.lang.String  sailnumber;
    protected java.lang.String  yachtname;
    protected java.lang.String  ownername;
    protected java.sql.Timestamp  latest_ts;
    protected java.math.BigDecimal  ev_general;
    protected java.sql.Timestamp  ev_general_ts;
    protected java.math.BigDecimal  ev_document;
    protected java.sql.Timestamp  ev_doc_ts;
    protected java.math.BigDecimal  ev_crew;
    protected java.sql.Timestamp  ev_crew_ts;
    protected java.math.BigDecimal  ev_commit;
    protected java.sql.Timestamp  ev_commit_ts;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String USECASEAMBIT_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONID_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String SAILNUMBER_DEFAULT  =  null;
    public static final java.lang.String YACHTNAME_DEFAULT  =  null;
    public static final java.lang.String OWNERNAME_DEFAULT  =  null;
    public static final java.sql.Timestamp LATEST_TS_DEFAULT  =  null;
    public static final java.math.BigDecimal EV_GENERAL_DEFAULT  =  null;
    public static final java.sql.Timestamp EV_GENERAL_TS_DEFAULT  =  null;
    public static final java.math.BigDecimal EV_DOCUMENT_DEFAULT  =  null;
    public static final java.sql.Timestamp EV_DOC_TS_DEFAULT  =  null;
    public static final java.math.BigDecimal EV_CREW_DEFAULT  =  null;
    public static final java.sql.Timestamp EV_CREW_TS_DEFAULT  =  null;
    public static final java.math.BigDecimal EV_COMMIT_DEFAULT  =  null;
    public static final java.sql.Timestamp EV_COMMIT_TS_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int USECASEAMBIT_DIRTYGROUP  =  0;
    public static final int USECASEAMBIT_DIRTYMASK   =  2;
    public static final int APPLICATIONID_DIRTYGROUP  =  0;
    public static final int APPLICATIONID_DIRTYMASK   =  4;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  8;
    public static final int SAILNUMBER_DIRTYGROUP  =  0;
    public static final int SAILNUMBER_DIRTYMASK   =  16;
    public static final int YACHTNAME_DIRTYGROUP  =  0;
    public static final int YACHTNAME_DIRTYMASK   =  32;
    public static final int OWNERNAME_DIRTYGROUP  =  0;
    public static final int OWNERNAME_DIRTYMASK   =  64;
    public static final int LATEST_TS_DIRTYGROUP  =  0;
    public static final int LATEST_TS_DIRTYMASK   =  128;
    public static final int EV_GENERAL_DIRTYGROUP  =  0;
    public static final int EV_GENERAL_DIRTYMASK   =  256;
    public static final int EV_GENERAL_TS_DIRTYGROUP  =  0;
    public static final int EV_GENERAL_TS_DIRTYMASK   =  512;
    public static final int EV_DOCUMENT_DIRTYGROUP  =  0;
    public static final int EV_DOCUMENT_DIRTYMASK   =  1024;
    public static final int EV_DOC_TS_DIRTYGROUP  =  0;
    public static final int EV_DOC_TS_DIRTYMASK   =  2048;
    public static final int EV_CREW_DIRTYGROUP  =  0;
    public static final int EV_CREW_DIRTYMASK   =  4096;
    public static final int EV_CREW_TS_DIRTYGROUP  =  0;
    public static final int EV_CREW_TS_DIRTYMASK   =  8192;
    public static final int EV_COMMIT_DIRTYGROUP  =  0;
    public static final int EV_COMMIT_DIRTYMASK   =  16384;
    public static final int EV_COMMIT_TS_DIRTYGROUP  =  0;
    public static final int EV_COMMIT_TS_DIRTYMASK   =  32768;


    /**
      * DataBean constructor.
      */
    public SailApplicationEventLogViewDTOBase()
    {
       dirtyFlagsArray = new int[16 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       usecaseambit = USECASEAMBIT_DEFAULT;
       applicationid = APPLICATIONID_DEFAULT;
       userid = USERID_DEFAULT;
       sailnumber = SAILNUMBER_DEFAULT;
       yachtname = YACHTNAME_DEFAULT;
       ownername = OWNERNAME_DEFAULT;
       latest_ts = LATEST_TS_DEFAULT;
       ev_general = EV_GENERAL_DEFAULT;
       ev_general_ts = EV_GENERAL_TS_DEFAULT;
       ev_document = EV_DOCUMENT_DEFAULT;
       ev_doc_ts = EV_DOC_TS_DEFAULT;
       ev_crew = EV_CREW_DEFAULT;
       ev_crew_ts = EV_CREW_TS_DEFAULT;
       ev_commit = EV_COMMIT_DEFAULT;
       ev_commit_ts = EV_COMMIT_TS_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailApplicationEventLogViewDTOBase(SailApplicationEventLogViewDTOBase another)
    {

       site = another.getSite();
       usecaseambit = another.getUsecaseambit();
       applicationid = another.getApplicationid();
       userid = another.getUserid();
       sailnumber = another.getSailnumber();
       yachtname = another.getYachtname();
       ownername = another.getOwnername();
       latest_ts = another.getLatest_ts();
       ev_general = another.getEv_general();
       ev_general_ts = another.getEv_general_ts();
       ev_document = another.getEv_document();
       ev_doc_ts = another.getEv_doc_ts();
       ev_crew = another.getEv_crew();
       ev_crew_ts = another.getEv_crew_ts();
       ev_commit = another.getEv_commit();
       ev_commit_ts = another.getEv_commit_ts();

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
        stb.append(applicationid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (sailnumber != null)
        {
        stb.append(sailnumber);
        notNull = true;        
        }
        if (yachtname != null)
        {
        stb.append(", ");
        stb.append(yachtname);
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

    // usecaseambit getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUsecaseambitDirty()  { return checkFieldDirtiness(USECASEAMBIT_DIRTYGROUP, USECASEAMBIT_DIRTYMASK); }

    public java.lang.String   getUsecaseambit()         { return usecaseambit; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getUsecaseambitAsString() { return (usecaseambit == null) ? "" : usecaseambit; }

    // usecaseambit setter methods.
    
    protected void markUsecaseambitAsDirty(boolean aFlag)  { markFieldAsDirty(USECASEAMBIT_DIRTYGROUP, USECASEAMBIT_DIRTYMASK, aFlag); }


    public void setUsecaseambit(String  p)
    {
       setUsecaseambit(p, DTOCasingStyle.none);
    }
    
    public void setUsecaseambit(String  p, DTOCasingStyle casingStyle)
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
       markUsecaseambitAsDirty(!equalsObject(usecaseambit, p));
       usecaseambit = p;
    }

    // applicationid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isApplicationidDirty()  { return checkFieldDirtiness(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK); }

    public java.lang.String   getApplicationid()         { return applicationid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getApplicationidAsString() { return (applicationid == null) ? "" : applicationid; }

    // applicationid setter methods.
    
    protected void markApplicationidAsDirty(boolean aFlag)  { markFieldAsDirty(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK, aFlag); }


    public void setApplicationid(String  p)
    {
       setApplicationid(p, DTOCasingStyle.none);
    }
    
    public void setApplicationid(String  p, DTOCasingStyle casingStyle)
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
       markApplicationidAsDirty(!equalsObject(applicationid, p));
       applicationid = p;
    }

    // userid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUseridDirty()  { return checkFieldDirtiness(USERID_DIRTYGROUP, USERID_DIRTYMASK); }

    public java.lang.String   getUserid()         { return userid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getUseridAsString() { return (userid == null) ? "" : userid; }

    // userid setter methods.
    
    protected void markUseridAsDirty(boolean aFlag)  { markFieldAsDirty(USERID_DIRTYGROUP, USERID_DIRTYMASK, aFlag); }


    public void setUserid(String  p)
    {
       setUserid(p, DTOCasingStyle.none);
    }
    
    public void setUserid(String  p, DTOCasingStyle casingStyle)
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
       markUseridAsDirty(!equalsObject(userid, p));
       userid = p;
    }

    // sailnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSailnumberDirty()  { return checkFieldDirtiness(SAILNUMBER_DIRTYGROUP, SAILNUMBER_DIRTYMASK); }

    public java.lang.String   getSailnumber()         { return sailnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSailnumberAsString() { return (sailnumber == null) ? "" : sailnumber; }

    // sailnumber setter methods.
    
    protected void markSailnumberAsDirty(boolean aFlag)  { markFieldAsDirty(SAILNUMBER_DIRTYGROUP, SAILNUMBER_DIRTYMASK, aFlag); }


    public void setSailnumber(String  p)
    {
       setSailnumber(p, DTOCasingStyle.none);
    }
    
    public void setSailnumber(String  p, DTOCasingStyle casingStyle)
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
       markSailnumberAsDirty(!equalsObject(sailnumber, p));
       sailnumber = p;
    }

    // yachtname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtnameDirty()  { return checkFieldDirtiness(YACHTNAME_DIRTYGROUP, YACHTNAME_DIRTYMASK); }

    public java.lang.String   getYachtname()         { return yachtname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getYachtnameAsString() { return (yachtname == null) ? "" : yachtname; }

    // yachtname setter methods.
    
    protected void markYachtnameAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTNAME_DIRTYGROUP, YACHTNAME_DIRTYMASK, aFlag); }


    public void setYachtname(String  p)
    {
       setYachtname(p, DTOCasingStyle.none);
    }
    
    public void setYachtname(String  p, DTOCasingStyle casingStyle)
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
       markYachtnameAsDirty(!equalsObject(yachtname, p));
       yachtname = p;
    }

    // ownername getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOwnernameDirty()  { return checkFieldDirtiness(OWNERNAME_DIRTYGROUP, OWNERNAME_DIRTYMASK); }

    public java.lang.String   getOwnername()         { return ownername; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getOwnernameAsString() { return (ownername == null) ? "" : ownername; }

    // ownername setter methods.
    
    protected void markOwnernameAsDirty(boolean aFlag)  { markFieldAsDirty(OWNERNAME_DIRTYGROUP, OWNERNAME_DIRTYMASK, aFlag); }


    public void setOwnername(String  p)
    {
       setOwnername(p, DTOCasingStyle.none);
    }
    
    public void setOwnername(String  p, DTOCasingStyle casingStyle)
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
       markOwnernameAsDirty(!equalsObject(ownername, p));
       ownername = p;
    }

    // latest_ts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLatest_tsDirty()  { return checkFieldDirtiness(LATEST_TS_DIRTYGROUP, LATEST_TS_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getLatest_ts() { return latest_ts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getLatest_tsAsString() { return timestampAsString(latest_ts, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getLatest_tsAsString(java.text.DateFormat aDateFormat) { return timestampAsString(latest_ts, aDateFormat); }

    // latest_ts setter methods.
    
    protected void markLatest_tsAsDirty(boolean aFlag)  { markFieldAsDirty(LATEST_TS_DIRTYGROUP, LATEST_TS_DIRTYMASK, aFlag); }


    public void setLatest_ts(java.sql.Timestamp  p)
    {
        markLatest_tsAsDirty(!equalsObject(latest_ts, p));
    	latest_ts = p;
    }
    public void setLatest_ts(String  p, java.text.DateFormat aDateFormat)
    {
    	setLatest_ts(stringAsTimestamp(p, aDateFormat));
    }

    // ev_general getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEv_generalDirty()  { return checkFieldDirtiness(EV_GENERAL_DIRTYGROUP, EV_GENERAL_DIRTYMASK); }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public double getEv_generalAsDouble()   {
        return (ev_general != null) ? ev_general.doubleValue() : 0;
    }

    public java.math.BigDecimal getEv_general() { return ev_general; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getEv_generalAsString(java.text.NumberFormat    aNumberFormat)    { return currencyAsString(ev_general, aNumberFormat); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getEv_generalAsString()            { return decimalAsString(ev_general);  }

    // ev_general setter methods.
    
    protected void markEv_generalAsDirty(boolean aFlag)  { markFieldAsDirty(EV_GENERAL_DIRTYGROUP, EV_GENERAL_DIRTYMASK, aFlag); }


    public void setEv_general(java.math.BigDecimal  p) {
           p = (p != null) ? p.setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN) : null;
           markEv_generalAsDirty(!equalsBigDecimal(ev_general, p));
           ev_general = p;
    }
    public void setEv_general(double  p) {
       	   setEv_general(new java.math.BigDecimal(p).setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN));
    }
    public void setEv_general(String  p) {
           setEv_general(stringAsBigDecimal(p, 0));
    }

    // ev_general_ts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEv_general_tsDirty()  { return checkFieldDirtiness(EV_GENERAL_TS_DIRTYGROUP, EV_GENERAL_TS_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getEv_general_ts() { return ev_general_ts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEv_general_tsAsString() { return timestampAsString(ev_general_ts, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEv_general_tsAsString(java.text.DateFormat aDateFormat) { return timestampAsString(ev_general_ts, aDateFormat); }

    // ev_general_ts setter methods.
    
    protected void markEv_general_tsAsDirty(boolean aFlag)  { markFieldAsDirty(EV_GENERAL_TS_DIRTYGROUP, EV_GENERAL_TS_DIRTYMASK, aFlag); }


    public void setEv_general_ts(java.sql.Timestamp  p)
    {
        markEv_general_tsAsDirty(!equalsObject(ev_general_ts, p));
    	ev_general_ts = p;
    }
    public void setEv_general_ts(String  p, java.text.DateFormat aDateFormat)
    {
    	setEv_general_ts(stringAsTimestamp(p, aDateFormat));
    }

    // ev_document getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEv_documentDirty()  { return checkFieldDirtiness(EV_DOCUMENT_DIRTYGROUP, EV_DOCUMENT_DIRTYMASK); }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public double getEv_documentAsDouble()   {
        return (ev_document != null) ? ev_document.doubleValue() : 0;
    }

    public java.math.BigDecimal getEv_document() { return ev_document; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getEv_documentAsString(java.text.NumberFormat    aNumberFormat)    { return currencyAsString(ev_document, aNumberFormat); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getEv_documentAsString()            { return decimalAsString(ev_document);  }

    // ev_document setter methods.
    
    protected void markEv_documentAsDirty(boolean aFlag)  { markFieldAsDirty(EV_DOCUMENT_DIRTYGROUP, EV_DOCUMENT_DIRTYMASK, aFlag); }


    public void setEv_document(java.math.BigDecimal  p) {
           p = (p != null) ? p.setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN) : null;
           markEv_documentAsDirty(!equalsBigDecimal(ev_document, p));
           ev_document = p;
    }
    public void setEv_document(double  p) {
       	   setEv_document(new java.math.BigDecimal(p).setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN));
    }
    public void setEv_document(String  p) {
           setEv_document(stringAsBigDecimal(p, 0));
    }

    // ev_doc_ts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEv_doc_tsDirty()  { return checkFieldDirtiness(EV_DOC_TS_DIRTYGROUP, EV_DOC_TS_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getEv_doc_ts() { return ev_doc_ts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEv_doc_tsAsString() { return timestampAsString(ev_doc_ts, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEv_doc_tsAsString(java.text.DateFormat aDateFormat) { return timestampAsString(ev_doc_ts, aDateFormat); }

    // ev_doc_ts setter methods.
    
    protected void markEv_doc_tsAsDirty(boolean aFlag)  { markFieldAsDirty(EV_DOC_TS_DIRTYGROUP, EV_DOC_TS_DIRTYMASK, aFlag); }


    public void setEv_doc_ts(java.sql.Timestamp  p)
    {
        markEv_doc_tsAsDirty(!equalsObject(ev_doc_ts, p));
    	ev_doc_ts = p;
    }
    public void setEv_doc_ts(String  p, java.text.DateFormat aDateFormat)
    {
    	setEv_doc_ts(stringAsTimestamp(p, aDateFormat));
    }

    // ev_crew getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEv_crewDirty()  { return checkFieldDirtiness(EV_CREW_DIRTYGROUP, EV_CREW_DIRTYMASK); }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public double getEv_crewAsDouble()   {
        return (ev_crew != null) ? ev_crew.doubleValue() : 0;
    }

    public java.math.BigDecimal getEv_crew() { return ev_crew; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getEv_crewAsString(java.text.NumberFormat    aNumberFormat)    { return currencyAsString(ev_crew, aNumberFormat); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getEv_crewAsString()            { return decimalAsString(ev_crew);  }

    // ev_crew setter methods.
    
    protected void markEv_crewAsDirty(boolean aFlag)  { markFieldAsDirty(EV_CREW_DIRTYGROUP, EV_CREW_DIRTYMASK, aFlag); }


    public void setEv_crew(java.math.BigDecimal  p) {
           p = (p != null) ? p.setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN) : null;
           markEv_crewAsDirty(!equalsBigDecimal(ev_crew, p));
           ev_crew = p;
    }
    public void setEv_crew(double  p) {
       	   setEv_crew(new java.math.BigDecimal(p).setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN));
    }
    public void setEv_crew(String  p) {
           setEv_crew(stringAsBigDecimal(p, 0));
    }

    // ev_crew_ts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEv_crew_tsDirty()  { return checkFieldDirtiness(EV_CREW_TS_DIRTYGROUP, EV_CREW_TS_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getEv_crew_ts() { return ev_crew_ts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEv_crew_tsAsString() { return timestampAsString(ev_crew_ts, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEv_crew_tsAsString(java.text.DateFormat aDateFormat) { return timestampAsString(ev_crew_ts, aDateFormat); }

    // ev_crew_ts setter methods.
    
    protected void markEv_crew_tsAsDirty(boolean aFlag)  { markFieldAsDirty(EV_CREW_TS_DIRTYGROUP, EV_CREW_TS_DIRTYMASK, aFlag); }


    public void setEv_crew_ts(java.sql.Timestamp  p)
    {
        markEv_crew_tsAsDirty(!equalsObject(ev_crew_ts, p));
    	ev_crew_ts = p;
    }
    public void setEv_crew_ts(String  p, java.text.DateFormat aDateFormat)
    {
    	setEv_crew_ts(stringAsTimestamp(p, aDateFormat));
    }

    // ev_commit getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEv_commitDirty()  { return checkFieldDirtiness(EV_COMMIT_DIRTYGROUP, EV_COMMIT_DIRTYMASK); }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public double getEv_commitAsDouble()   {
        return (ev_commit != null) ? ev_commit.doubleValue() : 0;
    }

    public java.math.BigDecimal getEv_commit() { return ev_commit; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getEv_commitAsString(java.text.NumberFormat    aNumberFormat)    { return currencyAsString(ev_commit, aNumberFormat); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getEv_commitAsString()            { return decimalAsString(ev_commit);  }

    // ev_commit setter methods.
    
    protected void markEv_commitAsDirty(boolean aFlag)  { markFieldAsDirty(EV_COMMIT_DIRTYGROUP, EV_COMMIT_DIRTYMASK, aFlag); }


    public void setEv_commit(java.math.BigDecimal  p) {
           p = (p != null) ? p.setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN) : null;
           markEv_commitAsDirty(!equalsBigDecimal(ev_commit, p));
           ev_commit = p;
    }
    public void setEv_commit(double  p) {
       	   setEv_commit(new java.math.BigDecimal(p).setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN));
    }
    public void setEv_commit(String  p) {
           setEv_commit(stringAsBigDecimal(p, 0));
    }

    // ev_commit_ts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEv_commit_tsDirty()  { return checkFieldDirtiness(EV_COMMIT_TS_DIRTYGROUP, EV_COMMIT_TS_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getEv_commit_ts() { return ev_commit_ts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEv_commit_tsAsString() { return timestampAsString(ev_commit_ts, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getEv_commit_tsAsString(java.text.DateFormat aDateFormat) { return timestampAsString(ev_commit_ts, aDateFormat); }

    // ev_commit_ts setter methods.
    
    protected void markEv_commit_tsAsDirty(boolean aFlag)  { markFieldAsDirty(EV_COMMIT_TS_DIRTYGROUP, EV_COMMIT_TS_DIRTYMASK, aFlag); }


    public void setEv_commit_ts(java.sql.Timestamp  p)
    {
        markEv_commit_tsAsDirty(!equalsObject(ev_commit_ts, p));
    	ev_commit_ts = p;
    }
    public void setEv_commit_ts(String  p, java.text.DateFormat aDateFormat)
    {
    	setEv_commit_ts(stringAsTimestamp(p, aDateFormat));
    }

}
