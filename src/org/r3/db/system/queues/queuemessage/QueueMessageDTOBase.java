//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuemessage;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "QueueMessageDTOBase")
public class QueueMessageDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  queuemessageid;
    protected java.lang.String  queueid;
    protected java.lang.String  correlationid;
    protected java.lang.String  srcqueuemessageid;
    protected java.lang.String  priority;
    protected java.lang.String  messagestatus;
    protected java.lang.String  messagetype;
    protected java.sql.Timestamp  putdate;
    protected java.sql.Timestamp  getdate;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String QUEUEMESSAGEID_DEFAULT  =  null;
    public static final java.lang.String QUEUEID_DEFAULT  =  null;
    public static final java.lang.String CORRELATIONID_DEFAULT  =  null;
    public static final java.lang.String SRCQUEUEMESSAGEID_DEFAULT  =  null;
    public static final java.lang.String PRIORITY_DEFAULT  =  null;
    public static final java.lang.String MESSAGESTATUS_DEFAULT  =  null;
    public static final java.lang.String MESSAGETYPE_DEFAULT  =  null;
    public static final java.sql.Timestamp PUTDATE_DEFAULT  =  null;
    public static final java.sql.Timestamp GETDATE_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int QUEUEMESSAGEID_DIRTYGROUP  =  0;
    public static final int QUEUEMESSAGEID_DIRTYMASK   =  1;
    public static final int QUEUEID_DIRTYGROUP  =  0;
    public static final int QUEUEID_DIRTYMASK   =  2;
    public static final int CORRELATIONID_DIRTYGROUP  =  0;
    public static final int CORRELATIONID_DIRTYMASK   =  4;
    public static final int SRCQUEUEMESSAGEID_DIRTYGROUP  =  0;
    public static final int SRCQUEUEMESSAGEID_DIRTYMASK   =  8;
    public static final int PRIORITY_DIRTYGROUP  =  0;
    public static final int PRIORITY_DIRTYMASK   =  16;
    public static final int MESSAGESTATUS_DIRTYGROUP  =  0;
    public static final int MESSAGESTATUS_DIRTYMASK   =  32;
    public static final int MESSAGETYPE_DIRTYGROUP  =  0;
    public static final int MESSAGETYPE_DIRTYMASK   =  64;
    public static final int PUTDATE_DIRTYGROUP  =  0;
    public static final int PUTDATE_DIRTYMASK   =  256;
    public static final int GETDATE_DIRTYGROUP  =  0;
    public static final int GETDATE_DIRTYMASK   =  512;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  1024;


    /**
      * DataBean constructor.
      */
    public QueueMessageDTOBase()
    {
       dirtyFlagsArray = new int[11 / 30 + 1];
       clearDirtyFlags();

       queuemessageid = QUEUEMESSAGEID_DEFAULT;
       queueid = QUEUEID_DEFAULT;
       correlationid = CORRELATIONID_DEFAULT;
       srcqueuemessageid = SRCQUEUEMESSAGEID_DEFAULT;
       priority = PRIORITY_DEFAULT;
       messagestatus = MESSAGESTATUS_DEFAULT;
       messagetype = MESSAGETYPE_DEFAULT;
       putdate = PUTDATE_DEFAULT;
       getdate = GETDATE_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public QueueMessageDTOBase(QueueMessageDTOBase another)
    {

       queuemessageid = another.getQueuemessageid();
       queueid = another.getQueueid();
       correlationid = another.getCorrelationid();
       srcqueuemessageid = another.getSrcqueuemessageid();
       priority = another.getPriority();
       messagestatus = another.getMessagestatus();
       messagetype = another.getMessagetype();
       putdate = another.getPutdate();
       getdate = another.getGetdate();
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
        stb.append(queuemessageid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(messagetype);
        return stb.toString();
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // queuemessageid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isQueuemessageidDirty()  { return checkFieldDirtiness(QUEUEMESSAGEID_DIRTYGROUP, QUEUEMESSAGEID_DIRTYMASK); }

    public java.lang.String   getQueuemessageid()         { return queuemessageid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getQueuemessageidAsString() { return (queuemessageid == null) ? "" : queuemessageid; }

    // queuemessageid setter methods.
    
    protected void markQueuemessageidAsDirty(boolean aFlag)  { markFieldAsDirty(QUEUEMESSAGEID_DIRTYGROUP, QUEUEMESSAGEID_DIRTYMASK, aFlag); }


    public void setQueuemessageid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markQueuemessageidAsDirty(!equalsObject(queuemessageid, p));
         queuemessageid = p;
    }

    // queueid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isQueueidDirty()  { return checkFieldDirtiness(QUEUEID_DIRTYGROUP, QUEUEID_DIRTYMASK); }

    public java.lang.String   getQueueid()         { return queueid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getQueueidAsString() { return (queueid == null) ? "" : queueid; }

    // queueid setter methods.
    
    protected void markQueueidAsDirty(boolean aFlag)  { markFieldAsDirty(QUEUEID_DIRTYGROUP, QUEUEID_DIRTYMASK, aFlag); }


    public void setQueueid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markQueueidAsDirty(!equalsObject(queueid, p));
         queueid = p;
    }

    // correlationid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCorrelationidDirty()  { return checkFieldDirtiness(CORRELATIONID_DIRTYGROUP, CORRELATIONID_DIRTYMASK); }

    public java.lang.String   getCorrelationid()         { return correlationid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCorrelationidAsString() { return (correlationid == null) ? "" : correlationid; }

    // correlationid setter methods.
    
    protected void markCorrelationidAsDirty(boolean aFlag)  { markFieldAsDirty(CORRELATIONID_DIRTYGROUP, CORRELATIONID_DIRTYMASK, aFlag); }


    public void setCorrelationid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markCorrelationidAsDirty(!equalsObject(correlationid, p));
         correlationid = p;
    }

    // srcqueuemessageid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSrcqueuemessageidDirty()  { return checkFieldDirtiness(SRCQUEUEMESSAGEID_DIRTYGROUP, SRCQUEUEMESSAGEID_DIRTYMASK); }

    public java.lang.String   getSrcqueuemessageid()         { return srcqueuemessageid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSrcqueuemessageidAsString() { return (srcqueuemessageid == null) ? "" : srcqueuemessageid; }

    // srcqueuemessageid setter methods.
    
    protected void markSrcqueuemessageidAsDirty(boolean aFlag)  { markFieldAsDirty(SRCQUEUEMESSAGEID_DIRTYGROUP, SRCQUEUEMESSAGEID_DIRTYMASK, aFlag); }


    public void setSrcqueuemessageid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markSrcqueuemessageidAsDirty(!equalsObject(srcqueuemessageid, p));
         srcqueuemessageid = p;
    }

    // priority getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPriorityDirty()  { return checkFieldDirtiness(PRIORITY_DIRTYGROUP, PRIORITY_DIRTYMASK); }

    public java.lang.String   getPriority()         { return priority; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPriorityAsString() { return (priority == null) ? "" : priority; }

    // priority setter methods.
    
    protected void markPriorityAsDirty(boolean aFlag)  { markFieldAsDirty(PRIORITY_DIRTYGROUP, PRIORITY_DIRTYMASK, aFlag); }


    public void setPriority(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markPriorityAsDirty(!equalsObject(priority, p));
         priority = p;
    }

    // messagestatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMessagestatusDirty()  { return checkFieldDirtiness(MESSAGESTATUS_DIRTYGROUP, MESSAGESTATUS_DIRTYMASK); }

    public java.lang.String   getMessagestatus()         { return messagestatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getMessagestatusAsString() { return (messagestatus == null) ? "" : messagestatus; }

    // messagestatus setter methods.
    
    protected void markMessagestatusAsDirty(boolean aFlag)  { markFieldAsDirty(MESSAGESTATUS_DIRTYGROUP, MESSAGESTATUS_DIRTYMASK, aFlag); }


    public void setMessagestatus(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markMessagestatusAsDirty(!equalsObject(messagestatus, p));
         messagestatus = p;
    }

    // messagetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMessagetypeDirty()  { return checkFieldDirtiness(MESSAGETYPE_DIRTYGROUP, MESSAGETYPE_DIRTYMASK); }

    public java.lang.String   getMessagetype()         { return messagetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getMessagetypeAsString() { return (messagetype == null) ? "" : messagetype; }

    // messagetype setter methods.
    
    protected void markMessagetypeAsDirty(boolean aFlag)  { markFieldAsDirty(MESSAGETYPE_DIRTYGROUP, MESSAGETYPE_DIRTYMASK, aFlag); }


    public void setMessagetype(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markMessagetypeAsDirty(!equalsObject(messagetype, p));
         messagetype = p;
    }

    // putdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPutdateDirty()  { return checkFieldDirtiness(PUTDATE_DIRTYGROUP, PUTDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getPutdate() { return putdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getPutdateAsString() { return timestampAsString(putdate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getPutdateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(putdate, aDateFormat); }

    // putdate setter methods.
    
    protected void markPutdateAsDirty(boolean aFlag)  { markFieldAsDirty(PUTDATE_DIRTYGROUP, PUTDATE_DIRTYMASK, aFlag); }


    public void setPutdate(java.sql.Timestamp  p)
    {
        markPutdateAsDirty(!equalsObject(putdate, p));
    	putdate = p;
    }
    public void setPutdate(String  p, java.text.DateFormat aDateFormat)
    {
    	setPutdate(stringAsTimestamp(p, aDateFormat));
    }

    // getdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGetdateDirty()  { return checkFieldDirtiness(GETDATE_DIRTYGROUP, GETDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getGetdate() { return getdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getGetdateAsString() { return timestampAsString(getdate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getGetdateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(getdate, aDateFormat); }

    // getdate setter methods.
    
    protected void markGetdateAsDirty(boolean aFlag)  { markFieldAsDirty(GETDATE_DIRTYGROUP, GETDATE_DIRTYMASK, aFlag); }


    public void setGetdate(java.sql.Timestamp  p)
    {
        markGetdateAsDirty(!equalsObject(getdate, p));
    	getdate = p;
    }
    public void setGetdate(String  p, java.text.DateFormat aDateFormat)
    {
    	setGetdate(stringAsTimestamp(p, aDateFormat));
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
