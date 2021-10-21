//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.homeentrylist;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SailHomeEntryListDTOBase")
public class SailHomeEntryListDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;
    protected java.lang.String  userid;
    protected java.lang.String  sailnumber;
    protected java.lang.String  yachtname;
    protected java.lang.String  yachttype;
    protected java.lang.String  boatimageurl;
    protected java.lang.Integer  boatimageheight;
    protected java.lang.Integer  boatimagewidth;
    protected java.lang.String  boaticonurl;
    protected java.lang.Integer  boaticonwidth;
    protected java.lang.Integer  boaticonheight;
    protected java.lang.String  addtohomeentrylist;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONID_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String SAILNUMBER_DEFAULT  =  null;
    public static final java.lang.String YACHTNAME_DEFAULT  =  null;
    public static final java.lang.String YACHTTYPE_DEFAULT  =  null;
    public static final java.lang.String BOATIMAGEURL_DEFAULT  =  null;
    public static final java.lang.Integer BOATIMAGEHEIGHT_DEFAULT  =  null;
    public static final java.lang.Integer BOATIMAGEWIDTH_DEFAULT  =  null;
    public static final java.lang.String BOATICONURL_DEFAULT  =  null;
    public static final java.lang.Integer BOATICONWIDTH_DEFAULT  =  null;
    public static final java.lang.Integer BOATICONHEIGHT_DEFAULT  =  null;
    public static final java.lang.String ADDTOHOMEENTRYLIST_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int APPLICATIONID_DIRTYGROUP  =  0;
    public static final int APPLICATIONID_DIRTYMASK   =  2;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  4;
    public static final int SAILNUMBER_DIRTYGROUP  =  0;
    public static final int SAILNUMBER_DIRTYMASK   =  8;
    public static final int YACHTNAME_DIRTYGROUP  =  0;
    public static final int YACHTNAME_DIRTYMASK   =  16;
    public static final int YACHTTYPE_DIRTYGROUP  =  0;
    public static final int YACHTTYPE_DIRTYMASK   =  32;
    public static final int BOATIMAGEURL_DIRTYGROUP  =  0;
    public static final int BOATIMAGEURL_DIRTYMASK   =  64;
    public static final int BOATIMAGEHEIGHT_DIRTYGROUP  =  0;
    public static final int BOATIMAGEHEIGHT_DIRTYMASK   =  128;
    public static final int BOATIMAGEWIDTH_DIRTYGROUP  =  0;
    public static final int BOATIMAGEWIDTH_DIRTYMASK   =  256;
    public static final int BOATICONURL_DIRTYGROUP  =  0;
    public static final int BOATICONURL_DIRTYMASK   =  512;
    public static final int BOATICONWIDTH_DIRTYGROUP  =  0;
    public static final int BOATICONWIDTH_DIRTYMASK   =  1024;
    public static final int BOATICONHEIGHT_DIRTYGROUP  =  0;
    public static final int BOATICONHEIGHT_DIRTYMASK   =  2048;
    public static final int ADDTOHOMEENTRYLIST_DIRTYGROUP  =  0;
    public static final int ADDTOHOMEENTRYLIST_DIRTYMASK   =  4096;


    /**
      * DataBean constructor.
      */
    public SailHomeEntryListDTOBase()
    {
       dirtyFlagsArray = new int[13 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       applicationid = APPLICATIONID_DEFAULT;
       userid = USERID_DEFAULT;
       sailnumber = SAILNUMBER_DEFAULT;
       yachtname = YACHTNAME_DEFAULT;
       yachttype = YACHTTYPE_DEFAULT;
       boatimageurl = BOATIMAGEURL_DEFAULT;
       boatimageheight = BOATIMAGEHEIGHT_DEFAULT;
       boatimagewidth = BOATIMAGEWIDTH_DEFAULT;
       boaticonurl = BOATICONURL_DEFAULT;
       boaticonwidth = BOATICONWIDTH_DEFAULT;
       boaticonheight = BOATICONHEIGHT_DEFAULT;
       addtohomeentrylist = ADDTOHOMEENTRYLIST_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailHomeEntryListDTOBase(SailHomeEntryListDTOBase another)
    {

       eventid = another.getEventid();
       applicationid = another.getApplicationid();
       userid = another.getUserid();
       sailnumber = another.getSailnumber();
       yachtname = another.getYachtname();
       yachttype = another.getYachttype();
       boatimageurl = another.getBoatimageurl();
       boatimageheight = another.getBoatimageheight();
       boatimagewidth = another.getBoatimagewidth();
       boaticonurl = another.getBoaticonurl();
       boaticonwidth = another.getBoaticonwidth();
       boaticonheight = another.getBoaticonheight();
       addtohomeentrylist = another.getAddtohomeentrylist();

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


    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (yachtname != null)
        {
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

    // eventid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventidDirty()  { return checkFieldDirtiness(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK); }

    public java.lang.String   getEventid()         { return eventid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getEventidAsString() { return (eventid == null) ? "" : eventid; }

    // eventid setter methods.
    
    protected void markEventidAsDirty(boolean aFlag)  { markFieldAsDirty(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK, aFlag); }


    public void setEventid(String  p)
    {
       setEventid(p, DTOCasingStyle.none);
    }
    
    public void setEventid(String  p, DTOCasingStyle casingStyle)
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
       markEventidAsDirty(!equalsObject(eventid, p));
       eventid = p;
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

    // yachttype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachttypeDirty()  { return checkFieldDirtiness(YACHTTYPE_DIRTYGROUP, YACHTTYPE_DIRTYMASK); }

    public java.lang.String   getYachttype()         { return yachttype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getYachttypeAsString() { return (yachttype == null) ? "" : yachttype; }

    // yachttype setter methods.
    
    protected void markYachttypeAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTTYPE_DIRTYGROUP, YACHTTYPE_DIRTYMASK, aFlag); }


    public void setYachttype(String  p)
    {
       setYachttype(p, DTOCasingStyle.none);
    }
    
    public void setYachttype(String  p, DTOCasingStyle casingStyle)
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
       markYachttypeAsDirty(!equalsObject(yachttype, p));
       yachttype = p;
    }

    // boatimageurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoatimageurlDirty()  { return checkFieldDirtiness(BOATIMAGEURL_DIRTYGROUP, BOATIMAGEURL_DIRTYMASK); }

    public java.lang.String   getBoatimageurl()         { return boatimageurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getBoatimageurlAsString() { return (boatimageurl == null) ? "" : boatimageurl; }

    // boatimageurl setter methods.
    
    protected void markBoatimageurlAsDirty(boolean aFlag)  { markFieldAsDirty(BOATIMAGEURL_DIRTYGROUP, BOATIMAGEURL_DIRTYMASK, aFlag); }


    public void setBoatimageurl(String  p)
    {
       setBoatimageurl(p, DTOCasingStyle.none);
    }
    
    public void setBoatimageurl(String  p, DTOCasingStyle casingStyle)
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
       markBoatimageurlAsDirty(!equalsObject(boatimageurl, p));
       boatimageurl = p;
    }

    // boatimageheight getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoatimageheightDirty()  { return checkFieldDirtiness(BOATIMAGEHEIGHT_DIRTYGROUP, BOATIMAGEHEIGHT_DIRTYMASK); }

    public java.lang.Integer   getBoatimageheight() { return boatimageheight; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getBoatimageheightAsString() { return integerAsString(boatimageheight); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getBoatimageheightAsInt()    { return boatimageheight != null ? boatimageheight.intValue() : 0; }

    // boatimageheight setter methods.
    
    protected void markBoatimageheightAsDirty(boolean aFlag)  { markFieldAsDirty(BOATIMAGEHEIGHT_DIRTYGROUP, BOATIMAGEHEIGHT_DIRTYMASK, aFlag); }


    public void setBoatimageheight(java.lang.Integer  p)
    {
        markBoatimageheightAsDirty(!equalsObject(boatimageheight, p));
    	boatimageheight = p;
    }
    public void setBoatimageheight(int p)
    {
    	setBoatimageheight(new java.lang.Integer(p));
    }
    public void setBoatimageheight()
    {
    	setBoatimageheight(0);
    }
    public void setBoatimageheight(String  p)
    {
    	setBoatimageheight(stringAsInteger(p));
    }

    // boatimagewidth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoatimagewidthDirty()  { return checkFieldDirtiness(BOATIMAGEWIDTH_DIRTYGROUP, BOATIMAGEWIDTH_DIRTYMASK); }

    public java.lang.Integer   getBoatimagewidth() { return boatimagewidth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getBoatimagewidthAsString() { return integerAsString(boatimagewidth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getBoatimagewidthAsInt()    { return boatimagewidth != null ? boatimagewidth.intValue() : 0; }

    // boatimagewidth setter methods.
    
    protected void markBoatimagewidthAsDirty(boolean aFlag)  { markFieldAsDirty(BOATIMAGEWIDTH_DIRTYGROUP, BOATIMAGEWIDTH_DIRTYMASK, aFlag); }


    public void setBoatimagewidth(java.lang.Integer  p)
    {
        markBoatimagewidthAsDirty(!equalsObject(boatimagewidth, p));
    	boatimagewidth = p;
    }
    public void setBoatimagewidth(int p)
    {
    	setBoatimagewidth(new java.lang.Integer(p));
    }
    public void setBoatimagewidth()
    {
    	setBoatimagewidth(0);
    }
    public void setBoatimagewidth(String  p)
    {
    	setBoatimagewidth(stringAsInteger(p));
    }

    // boaticonurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoaticonurlDirty()  { return checkFieldDirtiness(BOATICONURL_DIRTYGROUP, BOATICONURL_DIRTYMASK); }

    public java.lang.String   getBoaticonurl()         { return boaticonurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getBoaticonurlAsString() { return (boaticonurl == null) ? "" : boaticonurl; }

    // boaticonurl setter methods.
    
    protected void markBoaticonurlAsDirty(boolean aFlag)  { markFieldAsDirty(BOATICONURL_DIRTYGROUP, BOATICONURL_DIRTYMASK, aFlag); }


    public void setBoaticonurl(String  p)
    {
       setBoaticonurl(p, DTOCasingStyle.none);
    }
    
    public void setBoaticonurl(String  p, DTOCasingStyle casingStyle)
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
       markBoaticonurlAsDirty(!equalsObject(boaticonurl, p));
       boaticonurl = p;
    }

    // boaticonwidth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoaticonwidthDirty()  { return checkFieldDirtiness(BOATICONWIDTH_DIRTYGROUP, BOATICONWIDTH_DIRTYMASK); }

    public java.lang.Integer   getBoaticonwidth() { return boaticonwidth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getBoaticonwidthAsString() { return integerAsString(boaticonwidth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getBoaticonwidthAsInt()    { return boaticonwidth != null ? boaticonwidth.intValue() : 0; }

    // boaticonwidth setter methods.
    
    protected void markBoaticonwidthAsDirty(boolean aFlag)  { markFieldAsDirty(BOATICONWIDTH_DIRTYGROUP, BOATICONWIDTH_DIRTYMASK, aFlag); }


    public void setBoaticonwidth(java.lang.Integer  p)
    {
        markBoaticonwidthAsDirty(!equalsObject(boaticonwidth, p));
    	boaticonwidth = p;
    }
    public void setBoaticonwidth(int p)
    {
    	setBoaticonwidth(new java.lang.Integer(p));
    }
    public void setBoaticonwidth()
    {
    	setBoaticonwidth(0);
    }
    public void setBoaticonwidth(String  p)
    {
    	setBoaticonwidth(stringAsInteger(p));
    }

    // boaticonheight getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoaticonheightDirty()  { return checkFieldDirtiness(BOATICONHEIGHT_DIRTYGROUP, BOATICONHEIGHT_DIRTYMASK); }

    public java.lang.Integer   getBoaticonheight() { return boaticonheight; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getBoaticonheightAsString() { return integerAsString(boaticonheight); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getBoaticonheightAsInt()    { return boaticonheight != null ? boaticonheight.intValue() : 0; }

    // boaticonheight setter methods.
    
    protected void markBoaticonheightAsDirty(boolean aFlag)  { markFieldAsDirty(BOATICONHEIGHT_DIRTYGROUP, BOATICONHEIGHT_DIRTYMASK, aFlag); }


    public void setBoaticonheight(java.lang.Integer  p)
    {
        markBoaticonheightAsDirty(!equalsObject(boaticonheight, p));
    	boaticonheight = p;
    }
    public void setBoaticonheight(int p)
    {
    	setBoaticonheight(new java.lang.Integer(p));
    }
    public void setBoaticonheight()
    {
    	setBoaticonheight(0);
    }
    public void setBoaticonheight(String  p)
    {
    	setBoaticonheight(stringAsInteger(p));
    }

    // addtohomeentrylist getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAddtohomeentrylistDirty()  { return checkFieldDirtiness(ADDTOHOMEENTRYLIST_DIRTYGROUP, ADDTOHOMEENTRYLIST_DIRTYMASK); }

    public java.lang.String   getAddtohomeentrylist()         { return addtohomeentrylist; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getAddtohomeentrylistAsString() { return (addtohomeentrylist == null) ? "" : addtohomeentrylist; }

    // addtohomeentrylist setter methods.
    
    protected void markAddtohomeentrylistAsDirty(boolean aFlag)  { markFieldAsDirty(ADDTOHOMEENTRYLIST_DIRTYGROUP, ADDTOHOMEENTRYLIST_DIRTYMASK, aFlag); }


    public void setAddtohomeentrylist(String  p)
    {
       setAddtohomeentrylist(p, DTOCasingStyle.none);
    }
    
    public void setAddtohomeentrylist(String  p, DTOCasingStyle casingStyle)
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
       markAddtohomeentrylistAsDirty(!equalsObject(addtohomeentrylist, p));
       addtohomeentrylist = p;
    }

}
