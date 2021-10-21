//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbsthreadnode;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "BBSThreadNodeDTOBase")
public class BBSThreadNodeDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  threadnodeid;
    protected java.lang.String  site;
    protected java.lang.String  threadid;
    protected java.lang.String  nodetype;
    protected java.lang.String  nodetitle;
    protected java.lang.String  nodetext;
    protected java.lang.String  nodeparentid;
    protected java.lang.String  nodepath;
    protected java.lang.String  userid;
    protected java.sql.Timestamp  creationdate;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String THREADNODEID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String THREADID_DEFAULT  =  null;
    public static final java.lang.String NODETYPE_DEFAULT  =  null;
    public static final java.lang.String NODETITLE_DEFAULT  =  null;
    public static final java.lang.String NODETEXT_DEFAULT  =  null;
    public static final java.lang.String NODEPARENTID_DEFAULT  =  null;
    public static final java.lang.String NODEPATH_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.sql.Timestamp CREATIONDATE_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int THREADNODEID_DIRTYGROUP  =  0;
    public static final int THREADNODEID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int THREADID_DIRTYGROUP  =  0;
    public static final int THREADID_DIRTYMASK   =  4;
    public static final int NODETYPE_DIRTYGROUP  =  0;
    public static final int NODETYPE_DIRTYMASK   =  8;
    public static final int NODETITLE_DIRTYGROUP  =  0;
    public static final int NODETITLE_DIRTYMASK   =  16;
    public static final int NODETEXT_DIRTYGROUP  =  0;
    public static final int NODETEXT_DIRTYMASK   =  32;
    public static final int NODEPARENTID_DIRTYGROUP  =  0;
    public static final int NODEPARENTID_DIRTYMASK   =  64;
    public static final int NODEPATH_DIRTYGROUP  =  0;
    public static final int NODEPATH_DIRTYMASK   =  128;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  256;
    public static final int CREATIONDATE_DIRTYGROUP  =  0;
    public static final int CREATIONDATE_DIRTYMASK   =  512;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  1024;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  2048;


    /**
      * DataBean constructor.
      */
    public BBSThreadNodeDTOBase()
    {
       dirtyFlagsArray = new int[12 / 30 + 1];
       clearDirtyFlags();

       threadnodeid = THREADNODEID_DEFAULT;
       site = SITE_DEFAULT;
       threadid = THREADID_DEFAULT;
       nodetype = NODETYPE_DEFAULT;
       nodetitle = NODETITLE_DEFAULT;
       nodetext = NODETEXT_DEFAULT;
       nodeparentid = NODEPARENTID_DEFAULT;
       nodepath = NODEPATH_DEFAULT;
       userid = USERID_DEFAULT;
       creationdate = CREATIONDATE_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public BBSThreadNodeDTOBase(BBSThreadNodeDTOBase another)
    {

       threadnodeid = another.getThreadnodeid();
       site = another.getSite();
       threadid = another.getThreadid();
       nodetype = another.getNodetype();
       nodetitle = another.getNodetitle();
       nodetext = another.getNodetext();
       nodeparentid = another.getNodeparentid();
       nodepath = another.getNodepath();
       userid = another.getUserid();
       creationdate = another.getCreationdate();
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
        stb.append(threadnodeid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (nodetitle != null)
        {
        stb.append(nodetitle);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // threadnodeid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isThreadnodeidDirty()  { return checkFieldDirtiness(THREADNODEID_DIRTYGROUP, THREADNODEID_DIRTYMASK); }

    public java.lang.String   getThreadnodeid()         { return threadnodeid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "threadnodeid")
    public java.lang.String   getThreadnodeidAsString() { return (threadnodeid == null) ? "" : threadnodeid; }

    // threadnodeid setter methods.
    
    protected void markThreadnodeidAsDirty(boolean aFlag)  { markFieldAsDirty(THREADNODEID_DIRTYGROUP, THREADNODEID_DIRTYMASK, aFlag); }


    public void setThreadnodeid(String  p)
    {
       setThreadnodeid(p, DTOCasingStyle.none);
    }
    
    public void setThreadnodeid(String  p, DTOCasingStyle casingStyle)
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
       markThreadnodeidAsDirty(!equalsObject(threadnodeid, p));
       threadnodeid = p;
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

    // nodetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodetypeDirty()  { return checkFieldDirtiness(NODETYPE_DIRTYGROUP, NODETYPE_DIRTYMASK); }

    public java.lang.String   getNodetype()         { return nodetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodetype")
    public java.lang.String   getNodetypeAsString() { return (nodetype == null) ? "" : nodetype; }

    // nodetype setter methods.
    
    protected void markNodetypeAsDirty(boolean aFlag)  { markFieldAsDirty(NODETYPE_DIRTYGROUP, NODETYPE_DIRTYMASK, aFlag); }


    public void setNodetype(String  p)
    {
       setNodetype(p, DTOCasingStyle.none);
    }
    
    public void setNodetype(String  p, DTOCasingStyle casingStyle)
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
       markNodetypeAsDirty(!equalsObject(nodetype, p));
       nodetype = p;
    }

    // nodetitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodetitleDirty()  { return checkFieldDirtiness(NODETITLE_DIRTYGROUP, NODETITLE_DIRTYMASK); }

    public java.lang.String   getNodetitle()         { return nodetitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodetitle")
    public java.lang.String   getNodetitleAsString() { return (nodetitle == null) ? "" : nodetitle; }

    // nodetitle setter methods.
    
    protected void markNodetitleAsDirty(boolean aFlag)  { markFieldAsDirty(NODETITLE_DIRTYGROUP, NODETITLE_DIRTYMASK, aFlag); }


    public void setNodetitle(String  p)
    {
       setNodetitle(p, DTOCasingStyle.none);
    }
    
    public void setNodetitle(String  p, DTOCasingStyle casingStyle)
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
       markNodetitleAsDirty(!equalsObject(nodetitle, p));
       nodetitle = p;
    }

    // nodetext getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodetextDirty()  { return checkFieldDirtiness(NODETEXT_DIRTYGROUP, NODETEXT_DIRTYMASK); }

    public java.lang.String   getNodetext()         { return nodetext; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodetext")
    public java.lang.String   getNodetextAsString() { return (nodetext == null) ? "" : nodetext; }

    // nodetext setter methods.
    
    protected void markNodetextAsDirty(boolean aFlag)  { markFieldAsDirty(NODETEXT_DIRTYGROUP, NODETEXT_DIRTYMASK, aFlag); }


    public void setNodetext(String  p)
    {
       setNodetext(p, DTOCasingStyle.none);
    }
    
    public void setNodetext(String  p, DTOCasingStyle casingStyle)
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
       markNodetextAsDirty(!equalsObject(nodetext, p));
       nodetext = p;
    }

    // nodeparentid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodeparentidDirty()  { return checkFieldDirtiness(NODEPARENTID_DIRTYGROUP, NODEPARENTID_DIRTYMASK); }

    public java.lang.String   getNodeparentid()         { return nodeparentid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodeparentid")
    public java.lang.String   getNodeparentidAsString() { return (nodeparentid == null) ? "" : nodeparentid; }

    // nodeparentid setter methods.
    
    protected void markNodeparentidAsDirty(boolean aFlag)  { markFieldAsDirty(NODEPARENTID_DIRTYGROUP, NODEPARENTID_DIRTYMASK, aFlag); }


    public void setNodeparentid(String  p)
    {
       setNodeparentid(p, DTOCasingStyle.none);
    }
    
    public void setNodeparentid(String  p, DTOCasingStyle casingStyle)
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
       markNodeparentidAsDirty(!equalsObject(nodeparentid, p));
       nodeparentid = p;
    }

    // nodepath getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNodepathDirty()  { return checkFieldDirtiness(NODEPATH_DIRTYGROUP, NODEPATH_DIRTYMASK); }

    public java.lang.String   getNodepath()         { return nodepath; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nodepath")
    public java.lang.String   getNodepathAsString() { return (nodepath == null) ? "" : nodepath; }

    // nodepath setter methods.
    
    protected void markNodepathAsDirty(boolean aFlag)  { markFieldAsDirty(NODEPATH_DIRTYGROUP, NODEPATH_DIRTYMASK, aFlag); }


    public void setNodepath(String  p)
    {
       setNodepath(p, DTOCasingStyle.none);
    }
    
    public void setNodepath(String  p, DTOCasingStyle casingStyle)
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
       markNodepathAsDirty(!equalsObject(nodepath, p));
       nodepath = p;
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
