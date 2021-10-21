//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuework;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "QueueWorkDTOBase")
public class QueueWorkDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  queueworkid;
    protected java.lang.String  queueid;
    protected java.lang.String  refambitid;
    protected java.lang.String  refentityid;
    protected java.sql.Date  refdate;
    protected java.sql.Timestamp  triggerdatetime;
    protected java.lang.String  correlationid;
    protected java.lang.String  messagestatus;
    protected java.lang.String  messagetype;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String QUEUEWORKID_DEFAULT  =  null;
    public static final java.lang.String QUEUEID_DEFAULT  =  null;
    public static final java.lang.String REFAMBITID_DEFAULT  =  null;
    public static final java.lang.String REFENTITYID_DEFAULT  =  null;
    public static final java.sql.Date REFDATE_DEFAULT  =  null;
    public static final java.sql.Timestamp TRIGGERDATETIME_DEFAULT  =  null;
    public static final java.lang.String CORRELATIONID_DEFAULT  =  null;
    public static final java.lang.String MESSAGESTATUS_DEFAULT  =  null;
    public static final java.lang.String MESSAGETYPE_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int QUEUEWORKID_DIRTYGROUP  =  0;
    public static final int QUEUEWORKID_DIRTYMASK   =  1;
    public static final int QUEUEID_DIRTYGROUP  =  0;
    public static final int QUEUEID_DIRTYMASK   =  2;
    public static final int REFAMBITID_DIRTYGROUP  =  0;
    public static final int REFAMBITID_DIRTYMASK   =  4;
    public static final int REFENTITYID_DIRTYGROUP  =  0;
    public static final int REFENTITYID_DIRTYMASK   =  8;
    public static final int REFDATE_DIRTYGROUP  =  0;
    public static final int REFDATE_DIRTYMASK   =  16;
    public static final int TRIGGERDATETIME_DIRTYGROUP  =  0;
    public static final int TRIGGERDATETIME_DIRTYMASK   =  32;
    public static final int CORRELATIONID_DIRTYGROUP  =  0;
    public static final int CORRELATIONID_DIRTYMASK   =  64;
    public static final int MESSAGESTATUS_DIRTYGROUP  =  0;
    public static final int MESSAGESTATUS_DIRTYMASK   =  128;
    public static final int MESSAGETYPE_DIRTYGROUP  =  0;
    public static final int MESSAGETYPE_DIRTYMASK   =  256;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  512;


    /**
      * DataBean constructor.
      */
    public QueueWorkDTOBase()
    {
       dirtyFlagsArray = new int[10 / 30 + 1];
       clearDirtyFlags();

       queueworkid = QUEUEWORKID_DEFAULT;
       queueid = QUEUEID_DEFAULT;
       refambitid = REFAMBITID_DEFAULT;
       refentityid = REFENTITYID_DEFAULT;
       refdate = REFDATE_DEFAULT;
       triggerdatetime = TRIGGERDATETIME_DEFAULT;
       correlationid = CORRELATIONID_DEFAULT;
       messagestatus = MESSAGESTATUS_DEFAULT;
       messagetype = MESSAGETYPE_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public QueueWorkDTOBase(QueueWorkDTOBase another)
    {

       queueworkid = another.getQueueworkid();
       queueid = another.getQueueid();
       refambitid = another.getRefambitid();
       refentityid = another.getRefentityid();
       refdate = another.getRefdate();
       triggerdatetime = another.getTriggerdatetime();
       correlationid = another.getCorrelationid();
       messagestatus = another.getMessagestatus();
       messagetype = another.getMessagetype();
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
        stb.append(queueworkid);
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

    // queueworkid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isQueueworkidDirty()  { return checkFieldDirtiness(QUEUEWORKID_DIRTYGROUP, QUEUEWORKID_DIRTYMASK); }

    public java.lang.String   getQueueworkid()         { return queueworkid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getQueueworkidAsString() { return (queueworkid == null) ? "" : queueworkid; }

    // queueworkid setter methods.
    
    protected void markQueueworkidAsDirty(boolean aFlag)  { markFieldAsDirty(QUEUEWORKID_DIRTYGROUP, QUEUEWORKID_DIRTYMASK, aFlag); }


    public void setQueueworkid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markQueueworkidAsDirty(!equalsObject(queueworkid, p));
         queueworkid = p;
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

    // refambitid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRefambitidDirty()  { return checkFieldDirtiness(REFAMBITID_DIRTYGROUP, REFAMBITID_DIRTYMASK); }

    public java.lang.String   getRefambitid()         { return refambitid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getRefambitidAsString() { return (refambitid == null) ? "" : refambitid; }

    // refambitid setter methods.
    
    protected void markRefambitidAsDirty(boolean aFlag)  { markFieldAsDirty(REFAMBITID_DIRTYGROUP, REFAMBITID_DIRTYMASK, aFlag); }


    public void setRefambitid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markRefambitidAsDirty(!equalsObject(refambitid, p));
         refambitid = p;
    }

    // refentityid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRefentityidDirty()  { return checkFieldDirtiness(REFENTITYID_DIRTYGROUP, REFENTITYID_DIRTYMASK); }

    public java.lang.String   getRefentityid()         { return refentityid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getRefentityidAsString() { return (refentityid == null) ? "" : refentityid; }

    // refentityid setter methods.
    
    protected void markRefentityidAsDirty(boolean aFlag)  { markFieldAsDirty(REFENTITYID_DIRTYGROUP, REFENTITYID_DIRTYMASK, aFlag); }


    public void setRefentityid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markRefentityidAsDirty(!equalsObject(refentityid, p));
         refentityid = p;
    }

    // refdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRefdateDirty()  { return checkFieldDirtiness(REFDATE_DIRTYGROUP, REFDATE_DIRTYMASK); }

    public java.sql.Date   getRefdate() { return refdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getRefdateAsString() { return dateAsString(refdate, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getRefdateAsString(java.text.DateFormat aDateFormat) { return dateAsString(refdate, aDateFormat); }

    // refdate setter methods.
    
    protected void markRefdateAsDirty(boolean aFlag)  { markFieldAsDirty(REFDATE_DIRTYGROUP, REFDATE_DIRTYMASK, aFlag); }


    public void setRefdate(java.sql.Date  p)
    {
         markRefdateAsDirty(!equalsObject(refdate, p));
    	 refdate = p;
    }
    public void setRefdate(String p, java.text.DateFormat aDateFormat)
    {
    	setRefdate(stringAsDate(p, aDateFormat));
    }

    // triggerdatetime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTriggerdatetimeDirty()  { return checkFieldDirtiness(TRIGGERDATETIME_DIRTYGROUP, TRIGGERDATETIME_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getTriggerdatetime() { return triggerdatetime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getTriggerdatetimeAsString() { return timestampAsString(triggerdatetime, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getTriggerdatetimeAsString(java.text.DateFormat aDateFormat) { return timestampAsString(triggerdatetime, aDateFormat); }

    // triggerdatetime setter methods.
    
    protected void markTriggerdatetimeAsDirty(boolean aFlag)  { markFieldAsDirty(TRIGGERDATETIME_DIRTYGROUP, TRIGGERDATETIME_DIRTYMASK, aFlag); }


    public void setTriggerdatetime(java.sql.Timestamp  p)
    {
        markTriggerdatetimeAsDirty(!equalsObject(triggerdatetime, p));
    	triggerdatetime = p;
    }
    public void setTriggerdatetime(String  p, java.text.DateFormat aDateFormat)
    {
    	setTriggerdatetime(stringAsTimestamp(p, aDateFormat));
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
