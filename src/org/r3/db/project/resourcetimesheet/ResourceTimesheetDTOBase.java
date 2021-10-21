//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resourcetimesheet;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ResourceTimesheetDTOBase")
public class ResourceTimesheetDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  tsentryid;
    protected java.lang.Integer  caleveday;
    protected java.lang.String  site;
    protected java.lang.String  teamid;
    protected java.lang.String  resourceid;
    protected java.lang.String  uniteffort;
    protected java.lang.Integer  ordeffort;
    protected java.lang.Integer  exteffort;
    protected java.lang.Integer  oncalleffort;
    protected java.lang.String  tseuserid;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String TSENTRYID_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEDAY_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String TEAMID_DEFAULT  =  null;
    public static final java.lang.String RESOURCEID_DEFAULT  =  null;
    public static final java.lang.String UNITEFFORT_DEFAULT  =  null;
    public static final java.lang.Integer ORDEFFORT_DEFAULT  =  null;
    public static final java.lang.Integer EXTEFFORT_DEFAULT  =  null;
    public static final java.lang.Integer ONCALLEFFORT_DEFAULT  =  null;
    public static final java.lang.String TSEUSERID_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int TSENTRYID_DIRTYGROUP  =  0;
    public static final int TSENTRYID_DIRTYMASK   =  1;
    public static final int CALEVEDAY_DIRTYGROUP  =  0;
    public static final int CALEVEDAY_DIRTYMASK   =  2;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  4;
    public static final int TEAMID_DIRTYGROUP  =  0;
    public static final int TEAMID_DIRTYMASK   =  8;
    public static final int RESOURCEID_DIRTYGROUP  =  0;
    public static final int RESOURCEID_DIRTYMASK   =  16;
    public static final int UNITEFFORT_DIRTYGROUP  =  0;
    public static final int UNITEFFORT_DIRTYMASK   =  32;
    public static final int ORDEFFORT_DIRTYGROUP  =  0;
    public static final int ORDEFFORT_DIRTYMASK   =  64;
    public static final int EXTEFFORT_DIRTYGROUP  =  0;
    public static final int EXTEFFORT_DIRTYMASK   =  128;
    public static final int ONCALLEFFORT_DIRTYGROUP  =  0;
    public static final int ONCALLEFFORT_DIRTYMASK   =  256;
    public static final int TSEUSERID_DIRTYGROUP  =  0;
    public static final int TSEUSERID_DIRTYMASK   =  512;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  1024;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  2048;


    /**
      * DataBean constructor.
      */
    public ResourceTimesheetDTOBase()
    {
       dirtyFlagsArray = new int[12 / 30 + 1];
       clearDirtyFlags();

       tsentryid = TSENTRYID_DEFAULT;
       caleveday = CALEVEDAY_DEFAULT;
       site = SITE_DEFAULT;
       teamid = TEAMID_DEFAULT;
       resourceid = RESOURCEID_DEFAULT;
       uniteffort = UNITEFFORT_DEFAULT;
       ordeffort = ORDEFFORT_DEFAULT;
       exteffort = EXTEFFORT_DEFAULT;
       oncalleffort = ONCALLEFFORT_DEFAULT;
       tseuserid = TSEUSERID_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ResourceTimesheetDTOBase(ResourceTimesheetDTOBase another)
    {

       tsentryid = another.getTsentryid();
       caleveday = another.getCaleveday();
       site = another.getSite();
       teamid = another.getTeamid();
       resourceid = another.getResourceid();
       uniteffort = another.getUniteffort();
       ordeffort = another.getOrdeffort();
       exteffort = another.getExteffort();
       oncalleffort = another.getOncalleffort();
       tseuserid = another.getTseuserid();
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
        stb.append(tsentryid);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // tsentryid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTsentryidDirty()  { return checkFieldDirtiness(TSENTRYID_DIRTYGROUP, TSENTRYID_DIRTYMASK); }

    public java.lang.String   getTsentryid()         { return tsentryid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "tsentryid")
    public java.lang.String   getTsentryidAsString() { return (tsentryid == null) ? "" : tsentryid; }

    // tsentryid setter methods.
    
    protected void markTsentryidAsDirty(boolean aFlag)  { markFieldAsDirty(TSENTRYID_DIRTYGROUP, TSENTRYID_DIRTYMASK, aFlag); }


    public void setTsentryid(String  p)
    {
       setTsentryid(p, DTOCasingStyle.none);
    }
    
    public void setTsentryid(String  p, DTOCasingStyle casingStyle)
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
       markTsentryidAsDirty(!equalsObject(tsentryid, p));
       tsentryid = p;
    }

    // caleveday getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalevedayDirty()  { return checkFieldDirtiness(CALEVEDAY_DIRTYGROUP, CALEVEDAY_DIRTYMASK); }

    public java.lang.Integer   getCaleveday() { return caleveday; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "caleveday")
    public String getCalevedayAsString() { return integerAsString(caleveday); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalevedayAsInt()    { return caleveday != null ? caleveday.intValue() : 0; }

    // caleveday setter methods.
    
    protected void markCalevedayAsDirty(boolean aFlag)  { markFieldAsDirty(CALEVEDAY_DIRTYGROUP, CALEVEDAY_DIRTYMASK, aFlag); }


    public void setCaleveday(java.lang.Integer  p)
    {
        markCalevedayAsDirty(!equalsObject(caleveday, p));
    	caleveday = p;
    }
    public void setCaleveday(int p)
    {
    	setCaleveday(new java.lang.Integer(p));
    }
    public void setCaleveday()
    {
    	setCaleveday(0);
    }
    public void setCaleveday(String  p)
    {
    	setCaleveday(stringAsInteger(p));
    }

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

    // teamid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTeamidDirty()  { return checkFieldDirtiness(TEAMID_DIRTYGROUP, TEAMID_DIRTYMASK); }

    public java.lang.String   getTeamid()         { return teamid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "teamid")
    public java.lang.String   getTeamidAsString() { return (teamid == null) ? "" : teamid; }

    // teamid setter methods.
    
    protected void markTeamidAsDirty(boolean aFlag)  { markFieldAsDirty(TEAMID_DIRTYGROUP, TEAMID_DIRTYMASK, aFlag); }


    public void setTeamid(String  p)
    {
       setTeamid(p, DTOCasingStyle.none);
    }
    
    public void setTeamid(String  p, DTOCasingStyle casingStyle)
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
       markTeamidAsDirty(!equalsObject(teamid, p));
       teamid = p;
    }

    // resourceid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isResourceidDirty()  { return checkFieldDirtiness(RESOURCEID_DIRTYGROUP, RESOURCEID_DIRTYMASK); }

    public java.lang.String   getResourceid()         { return resourceid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "resourceid")
    public java.lang.String   getResourceidAsString() { return (resourceid == null) ? "" : resourceid; }

    // resourceid setter methods.
    
    protected void markResourceidAsDirty(boolean aFlag)  { markFieldAsDirty(RESOURCEID_DIRTYGROUP, RESOURCEID_DIRTYMASK, aFlag); }


    public void setResourceid(String  p)
    {
       setResourceid(p, DTOCasingStyle.none);
    }
    
    public void setResourceid(String  p, DTOCasingStyle casingStyle)
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
       markResourceidAsDirty(!equalsObject(resourceid, p));
       resourceid = p;
    }

    // uniteffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUniteffortDirty()  { return checkFieldDirtiness(UNITEFFORT_DIRTYGROUP, UNITEFFORT_DIRTYMASK); }

    public java.lang.String   getUniteffort()         { return uniteffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "uniteffort")
    public java.lang.String   getUniteffortAsString() { return (uniteffort == null) ? "" : uniteffort; }

    // uniteffort setter methods.
    
    protected void markUniteffortAsDirty(boolean aFlag)  { markFieldAsDirty(UNITEFFORT_DIRTYGROUP, UNITEFFORT_DIRTYMASK, aFlag); }


    public void setUniteffort(String  p)
    {
       setUniteffort(p, DTOCasingStyle.none);
    }
    
    public void setUniteffort(String  p, DTOCasingStyle casingStyle)
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
       markUniteffortAsDirty(!equalsObject(uniteffort, p));
       uniteffort = p;
    }

    // ordeffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOrdeffortDirty()  { return checkFieldDirtiness(ORDEFFORT_DIRTYGROUP, ORDEFFORT_DIRTYMASK); }

    public java.lang.Integer   getOrdeffort() { return ordeffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "ordeffort")
    public String getOrdeffortAsString() { return integerAsString(ordeffort); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getOrdeffortAsInt()    { return ordeffort != null ? ordeffort.intValue() : 0; }

    // ordeffort setter methods.
    
    protected void markOrdeffortAsDirty(boolean aFlag)  { markFieldAsDirty(ORDEFFORT_DIRTYGROUP, ORDEFFORT_DIRTYMASK, aFlag); }


    public void setOrdeffort(java.lang.Integer  p)
    {
        markOrdeffortAsDirty(!equalsObject(ordeffort, p));
    	ordeffort = p;
    }
    public void setOrdeffort(int p)
    {
    	setOrdeffort(new java.lang.Integer(p));
    }
    public void setOrdeffort()
    {
    	setOrdeffort(0);
    }
    public void setOrdeffort(String  p)
    {
    	setOrdeffort(stringAsInteger(p));
    }

    // exteffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isExteffortDirty()  { return checkFieldDirtiness(EXTEFFORT_DIRTYGROUP, EXTEFFORT_DIRTYMASK); }

    public java.lang.Integer   getExteffort() { return exteffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "exteffort")
    public String getExteffortAsString() { return integerAsString(exteffort); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getExteffortAsInt()    { return exteffort != null ? exteffort.intValue() : 0; }

    // exteffort setter methods.
    
    protected void markExteffortAsDirty(boolean aFlag)  { markFieldAsDirty(EXTEFFORT_DIRTYGROUP, EXTEFFORT_DIRTYMASK, aFlag); }


    public void setExteffort(java.lang.Integer  p)
    {
        markExteffortAsDirty(!equalsObject(exteffort, p));
    	exteffort = p;
    }
    public void setExteffort(int p)
    {
    	setExteffort(new java.lang.Integer(p));
    }
    public void setExteffort()
    {
    	setExteffort(0);
    }
    public void setExteffort(String  p)
    {
    	setExteffort(stringAsInteger(p));
    }

    // oncalleffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOncalleffortDirty()  { return checkFieldDirtiness(ONCALLEFFORT_DIRTYGROUP, ONCALLEFFORT_DIRTYMASK); }

    public java.lang.Integer   getOncalleffort() { return oncalleffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "oncalleffort")
    public String getOncalleffortAsString() { return integerAsString(oncalleffort); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getOncalleffortAsInt()    { return oncalleffort != null ? oncalleffort.intValue() : 0; }

    // oncalleffort setter methods.
    
    protected void markOncalleffortAsDirty(boolean aFlag)  { markFieldAsDirty(ONCALLEFFORT_DIRTYGROUP, ONCALLEFFORT_DIRTYMASK, aFlag); }


    public void setOncalleffort(java.lang.Integer  p)
    {
        markOncalleffortAsDirty(!equalsObject(oncalleffort, p));
    	oncalleffort = p;
    }
    public void setOncalleffort(int p)
    {
    	setOncalleffort(new java.lang.Integer(p));
    }
    public void setOncalleffort()
    {
    	setOncalleffort(0);
    }
    public void setOncalleffort(String  p)
    {
    	setOncalleffort(stringAsInteger(p));
    }

    // tseuserid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTseuseridDirty()  { return checkFieldDirtiness(TSEUSERID_DIRTYGROUP, TSEUSERID_DIRTYMASK); }

    public java.lang.String   getTseuserid()         { return tseuserid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "tseuserid")
    public java.lang.String   getTseuseridAsString() { return (tseuserid == null) ? "" : tseuserid; }

    // tseuserid setter methods.
    
    protected void markTseuseridAsDirty(boolean aFlag)  { markFieldAsDirty(TSEUSERID_DIRTYGROUP, TSEUSERID_DIRTYMASK, aFlag); }


    public void setTseuserid(String  p)
    {
       setTseuserid(p, DTOCasingStyle.none);
    }
    
    public void setTseuserid(String  p, DTOCasingStyle casingStyle)
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
       markTseuseridAsDirty(!equalsObject(tseuserid, p));
       tseuserid = p;
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
