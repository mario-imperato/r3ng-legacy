//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthread;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "BBSThreadDTOBase")
public class BBSThreadDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  threadid;
    protected java.lang.String  topicid;
    protected java.lang.String  threadtitle;
    protected java.lang.String  threadprofile;
    protected java.lang.String  userid;
    protected java.sql.Timestamp  creationdate;
    protected java.lang.Integer  numposts;
    protected java.lang.String  lastthreadnodeid;
    protected java.sql.Timestamp  lastposttimestamp;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String THREADID_DEFAULT  =  null;
    public static final java.lang.String TOPICID_DEFAULT  =  null;
    public static final java.lang.String THREADTITLE_DEFAULT  =  null;
    public static final java.lang.String THREADPROFILE_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.sql.Timestamp CREATIONDATE_DEFAULT  =  null;
    public static final java.lang.Integer NUMPOSTS_DEFAULT  =  null;
    public static final java.lang.String LASTTHREADNODEID_DEFAULT  =  null;
    public static final java.sql.Timestamp LASTPOSTTIMESTAMP_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int THREADID_DIRTYGROUP  =  0;
    public static final int THREADID_DIRTYMASK   =  2;
    public static final int TOPICID_DIRTYGROUP  =  0;
    public static final int TOPICID_DIRTYMASK   =  4;
    public static final int THREADTITLE_DIRTYGROUP  =  0;
    public static final int THREADTITLE_DIRTYMASK   =  8;
    public static final int THREADPROFILE_DIRTYGROUP  =  0;
    public static final int THREADPROFILE_DIRTYMASK   =  16;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  32;
    public static final int CREATIONDATE_DIRTYGROUP  =  0;
    public static final int CREATIONDATE_DIRTYMASK   =  64;
    public static final int NUMPOSTS_DIRTYGROUP  =  0;
    public static final int NUMPOSTS_DIRTYMASK   =  128;
    public static final int LASTTHREADNODEID_DIRTYGROUP  =  0;
    public static final int LASTTHREADNODEID_DIRTYMASK   =  256;
    public static final int LASTPOSTTIMESTAMP_DIRTYGROUP  =  0;
    public static final int LASTPOSTTIMESTAMP_DIRTYMASK   =  512;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  1024;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  2048;


    /**
      * DataBean constructor.
      */
    public BBSThreadDTOBase()
    {
       dirtyFlagsArray = new int[12 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       threadid = THREADID_DEFAULT;
       topicid = TOPICID_DEFAULT;
       threadtitle = THREADTITLE_DEFAULT;
       threadprofile = THREADPROFILE_DEFAULT;
       userid = USERID_DEFAULT;
       creationdate = CREATIONDATE_DEFAULT;
       numposts = NUMPOSTS_DEFAULT;
       lastthreadnodeid = LASTTHREADNODEID_DEFAULT;
       lastposttimestamp = LASTPOSTTIMESTAMP_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public BBSThreadDTOBase(BBSThreadDTOBase another)
    {

       site = another.getSite();
       threadid = another.getThreadid();
       topicid = another.getTopicid();
       threadtitle = another.getThreadtitle();
       threadprofile = another.getThreadprofile();
       userid = another.getUserid();
       creationdate = another.getCreationdate();
       numposts = another.getNumposts();
       lastthreadnodeid = another.getLastthreadnodeid();
       lastposttimestamp = another.getLastposttimestamp();
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
        stb.append(threadid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (threadtitle != null)
        {
        stb.append(threadtitle);
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

    // threadid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isThreadidDirty()  { return checkFieldDirtiness(THREADID_DIRTYGROUP, THREADID_DIRTYMASK); }

    public java.lang.String   getThreadid()         { return threadid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "threadid")
    public java.lang.String   getThreadidAsString() { return (threadid == null) ? "" : threadid; }

    // threadid setter methods.
    
    protected void markThreadidAsDirty(boolean aFlag)  { markFieldAsDirty(THREADID_DIRTYGROUP, THREADID_DIRTYMASK, aFlag); }


    public void setThreadid(String  p)
    {
       setThreadid(p, DTOCasingStyle.none);
    }
    
    public void setThreadid(String  p, DTOCasingStyle casingStyle)
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
       markThreadidAsDirty(!equalsObject(threadid, p));
       threadid = p;
    }

    // topicid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTopicidDirty()  { return checkFieldDirtiness(TOPICID_DIRTYGROUP, TOPICID_DIRTYMASK); }

    public java.lang.String   getTopicid()         { return topicid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "topicid")
    public java.lang.String   getTopicidAsString() { return (topicid == null) ? "" : topicid; }

    // topicid setter methods.
    
    protected void markTopicidAsDirty(boolean aFlag)  { markFieldAsDirty(TOPICID_DIRTYGROUP, TOPICID_DIRTYMASK, aFlag); }


    public void setTopicid(String  p)
    {
       setTopicid(p, DTOCasingStyle.none);
    }
    
    public void setTopicid(String  p, DTOCasingStyle casingStyle)
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
       markTopicidAsDirty(!equalsObject(topicid, p));
       topicid = p;
    }

    // threadtitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isThreadtitleDirty()  { return checkFieldDirtiness(THREADTITLE_DIRTYGROUP, THREADTITLE_DIRTYMASK); }

    public java.lang.String   getThreadtitle()         { return threadtitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "threadtitle")
    public java.lang.String   getThreadtitleAsString() { return (threadtitle == null) ? "" : threadtitle; }

    // threadtitle setter methods.
    
    protected void markThreadtitleAsDirty(boolean aFlag)  { markFieldAsDirty(THREADTITLE_DIRTYGROUP, THREADTITLE_DIRTYMASK, aFlag); }


    public void setThreadtitle(String  p)
    {
       setThreadtitle(p, DTOCasingStyle.none);
    }
    
    public void setThreadtitle(String  p, DTOCasingStyle casingStyle)
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
       markThreadtitleAsDirty(!equalsObject(threadtitle, p));
       threadtitle = p;
    }

    // threadprofile getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isThreadprofileDirty()  { return checkFieldDirtiness(THREADPROFILE_DIRTYGROUP, THREADPROFILE_DIRTYMASK); }

    public java.lang.String   getThreadprofile()         { return threadprofile; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "threadprofile")
    public java.lang.String   getThreadprofileAsString() { return (threadprofile == null) ? "" : threadprofile; }

    // threadprofile setter methods.
    
    protected void markThreadprofileAsDirty(boolean aFlag)  { markFieldAsDirty(THREADPROFILE_DIRTYGROUP, THREADPROFILE_DIRTYMASK, aFlag); }


    public void setThreadprofile(String  p)
    {
       setThreadprofile(p, DTOCasingStyle.none);
    }
    
    public void setThreadprofile(String  p, DTOCasingStyle casingStyle)
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
       markThreadprofileAsDirty(!equalsObject(threadprofile, p));
       threadprofile = p;
    }

    // userid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUseridDirty()  { return checkFieldDirtiness(USERID_DIRTYGROUP, USERID_DIRTYMASK); }

    public java.lang.String   getUserid()         { return userid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "userid")
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

    // creationdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCreationdateDirty()  { return checkFieldDirtiness(CREATIONDATE_DIRTYGROUP, CREATIONDATE_DIRTYMASK); }

    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getCreationdate() { return creationdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "creationdate")
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

    // numposts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumpostsDirty()  { return checkFieldDirtiness(NUMPOSTS_DIRTYGROUP, NUMPOSTS_DIRTYMASK); }

    public java.lang.Integer   getNumposts() { return numposts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numposts")
    public String getNumpostsAsString() { return integerAsString(numposts); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumpostsAsInt()    { return numposts != null ? numposts.intValue() : 0; }

    // numposts setter methods.
    
    protected void markNumpostsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMPOSTS_DIRTYGROUP, NUMPOSTS_DIRTYMASK, aFlag); }


    public void setNumposts(java.lang.Integer  p)
    {
        markNumpostsAsDirty(!equalsObject(numposts, p));
    	numposts = p;
    }
    public void setNumposts(int p)
    {
    	setNumposts(new java.lang.Integer(p));
    }
    public void setNumposts()
    {
    	setNumposts(0);
    }
    public void setNumposts(String  p)
    {
    	setNumposts(stringAsInteger(p));
    }

    // lastthreadnodeid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLastthreadnodeidDirty()  { return checkFieldDirtiness(LASTTHREADNODEID_DIRTYGROUP, LASTTHREADNODEID_DIRTYMASK); }

    public java.lang.String   getLastthreadnodeid()         { return lastthreadnodeid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "lastthreadnodeid")
    public java.lang.String   getLastthreadnodeidAsString() { return (lastthreadnodeid == null) ? "" : lastthreadnodeid; }

    // lastthreadnodeid setter methods.
    
    protected void markLastthreadnodeidAsDirty(boolean aFlag)  { markFieldAsDirty(LASTTHREADNODEID_DIRTYGROUP, LASTTHREADNODEID_DIRTYMASK, aFlag); }


    public void setLastthreadnodeid(String  p)
    {
       setLastthreadnodeid(p, DTOCasingStyle.none);
    }
    
    public void setLastthreadnodeid(String  p, DTOCasingStyle casingStyle)
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
       markLastthreadnodeidAsDirty(!equalsObject(lastthreadnodeid, p));
       lastthreadnodeid = p;
    }

    // lastposttimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLastposttimestampDirty()  { return checkFieldDirtiness(LASTPOSTTIMESTAMP_DIRTYGROUP, LASTPOSTTIMESTAMP_DIRTYMASK); }

    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getLastposttimestamp() { return lastposttimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "lastposttimestamp")
    public String getLastposttimestampAsString() { return timestampAsString(lastposttimestamp, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getLastposttimestampAsString(java.text.DateFormat aDateFormat) { return timestampAsString(lastposttimestamp, aDateFormat); }

    // lastposttimestamp setter methods.
    
    protected void markLastposttimestampAsDirty(boolean aFlag)  { markFieldAsDirty(LASTPOSTTIMESTAMP_DIRTYGROUP, LASTPOSTTIMESTAMP_DIRTYMASK, aFlag); }


    public void setLastposttimestamp(java.sql.Timestamp  p)
    {
        markLastposttimestampAsDirty(!equalsObject(lastposttimestamp, p));
    	lastposttimestamp = p;
    }
    public void setLastposttimestamp(String  p, java.text.DateFormat aDateFormat)
    {
    	setLastposttimestamp(stringAsTimestamp(p, aDateFormat));
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
