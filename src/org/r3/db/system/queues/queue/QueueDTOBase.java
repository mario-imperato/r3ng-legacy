//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queue;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "QueueDTOBase")
public class QueueDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  queueid;
    protected java.lang.String  queuename;
    protected java.lang.String  queuephysicalname;
    protected java.lang.String  queuetype;
    protected java.lang.String  deadqueueid;
    protected java.lang.String  retryqueueid;
    protected java.lang.String  notifyqueueid;
    protected java.lang.Integer  maxnumberofretries;

    public static final java.lang.String QUEUEID_DEFAULT  =  null;
    public static final java.lang.String QUEUENAME_DEFAULT  =  null;
    public static final java.lang.String QUEUEPHYSICALNAME_DEFAULT  =  null;
    public static final java.lang.String QUEUETYPE_DEFAULT  =  null;
    public static final java.lang.String DEADQUEUEID_DEFAULT  =  null;
    public static final java.lang.String RETRYQUEUEID_DEFAULT  =  null;
    public static final java.lang.String NOTIFYQUEUEID_DEFAULT  =  null;
    public static final java.lang.Integer MAXNUMBEROFRETRIES_DEFAULT  =  null;

    public static final int QUEUEID_DIRTYGROUP  =  0;
    public static final int QUEUEID_DIRTYMASK   =  1;
    public static final int QUEUENAME_DIRTYGROUP  =  0;
    public static final int QUEUENAME_DIRTYMASK   =  2;
    public static final int QUEUEPHYSICALNAME_DIRTYGROUP  =  0;
    public static final int QUEUEPHYSICALNAME_DIRTYMASK   =  4;
    public static final int QUEUETYPE_DIRTYGROUP  =  0;
    public static final int QUEUETYPE_DIRTYMASK   =  8;
    public static final int DEADQUEUEID_DIRTYGROUP  =  0;
    public static final int DEADQUEUEID_DIRTYMASK   =  16;
    public static final int RETRYQUEUEID_DIRTYGROUP  =  0;
    public static final int RETRYQUEUEID_DIRTYMASK   =  32;
    public static final int NOTIFYQUEUEID_DIRTYGROUP  =  0;
    public static final int NOTIFYQUEUEID_DIRTYMASK   =  64;
    public static final int MAXNUMBEROFRETRIES_DIRTYGROUP  =  0;
    public static final int MAXNUMBEROFRETRIES_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public QueueDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       queueid = QUEUEID_DEFAULT;
       queuename = QUEUENAME_DEFAULT;
       queuephysicalname = QUEUEPHYSICALNAME_DEFAULT;
       queuetype = QUEUETYPE_DEFAULT;
       deadqueueid = DEADQUEUEID_DEFAULT;
       retryqueueid = RETRYQUEUEID_DEFAULT;
       notifyqueueid = NOTIFYQUEUEID_DEFAULT;
       maxnumberofretries = MAXNUMBEROFRETRIES_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public QueueDTOBase(QueueDTOBase another)
    {

       queueid = another.getQueueid();
       queuename = another.getQueuename();
       queuephysicalname = another.getQueuephysicalname();
       queuetype = another.getQueuetype();
       deadqueueid = another.getDeadqueueid();
       retryqueueid = another.getRetryqueueid();
       notifyqueueid = another.getNotifyqueueid();
       maxnumberofretries = another.getMaxnumberofretries();

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
        stb.append(queueid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(queuename);
        return stb.toString();
    }

    /**
      * DataBean Getter And Setter Accessor
      */

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

    // queuename getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isQueuenameDirty()  { return checkFieldDirtiness(QUEUENAME_DIRTYGROUP, QUEUENAME_DIRTYMASK); }

    public java.lang.String   getQueuename()         { return queuename; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getQueuenameAsString() { return (queuename == null) ? "" : queuename; }

    // queuename setter methods.
    
    protected void markQueuenameAsDirty(boolean aFlag)  { markFieldAsDirty(QUEUENAME_DIRTYGROUP, QUEUENAME_DIRTYMASK, aFlag); }


    public void setQueuename(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markQueuenameAsDirty(!equalsObject(queuename, p));
         queuename = p;
    }

    // queuephysicalname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isQueuephysicalnameDirty()  { return checkFieldDirtiness(QUEUEPHYSICALNAME_DIRTYGROUP, QUEUEPHYSICALNAME_DIRTYMASK); }

    public java.lang.String   getQueuephysicalname()         { return queuephysicalname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getQueuephysicalnameAsString() { return (queuephysicalname == null) ? "" : queuephysicalname; }

    // queuephysicalname setter methods.
    
    protected void markQueuephysicalnameAsDirty(boolean aFlag)  { markFieldAsDirty(QUEUEPHYSICALNAME_DIRTYGROUP, QUEUEPHYSICALNAME_DIRTYMASK, aFlag); }


    public void setQueuephysicalname(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markQueuephysicalnameAsDirty(!equalsObject(queuephysicalname, p));
         queuephysicalname = p;
    }

    // queuetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isQueuetypeDirty()  { return checkFieldDirtiness(QUEUETYPE_DIRTYGROUP, QUEUETYPE_DIRTYMASK); }

    public java.lang.String   getQueuetype()         { return queuetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getQueuetypeAsString() { return (queuetype == null) ? "" : queuetype; }

    // queuetype setter methods.
    
    protected void markQueuetypeAsDirty(boolean aFlag)  { markFieldAsDirty(QUEUETYPE_DIRTYGROUP, QUEUETYPE_DIRTYMASK, aFlag); }


    public void setQueuetype(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markQueuetypeAsDirty(!equalsObject(queuetype, p));
         queuetype = p;
    }

    // deadqueueid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDeadqueueidDirty()  { return checkFieldDirtiness(DEADQUEUEID_DIRTYGROUP, DEADQUEUEID_DIRTYMASK); }

    public java.lang.String   getDeadqueueid()         { return deadqueueid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getDeadqueueidAsString() { return (deadqueueid == null) ? "" : deadqueueid; }

    // deadqueueid setter methods.
    
    protected void markDeadqueueidAsDirty(boolean aFlag)  { markFieldAsDirty(DEADQUEUEID_DIRTYGROUP, DEADQUEUEID_DIRTYMASK, aFlag); }


    public void setDeadqueueid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markDeadqueueidAsDirty(!equalsObject(deadqueueid, p));
         deadqueueid = p;
    }

    // retryqueueid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRetryqueueidDirty()  { return checkFieldDirtiness(RETRYQUEUEID_DIRTYGROUP, RETRYQUEUEID_DIRTYMASK); }

    public java.lang.String   getRetryqueueid()         { return retryqueueid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getRetryqueueidAsString() { return (retryqueueid == null) ? "" : retryqueueid; }

    // retryqueueid setter methods.
    
    protected void markRetryqueueidAsDirty(boolean aFlag)  { markFieldAsDirty(RETRYQUEUEID_DIRTYGROUP, RETRYQUEUEID_DIRTYMASK, aFlag); }


    public void setRetryqueueid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markRetryqueueidAsDirty(!equalsObject(retryqueueid, p));
         retryqueueid = p;
    }

    // notifyqueueid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNotifyqueueidDirty()  { return checkFieldDirtiness(NOTIFYQUEUEID_DIRTYGROUP, NOTIFYQUEUEID_DIRTYMASK); }

    public java.lang.String   getNotifyqueueid()         { return notifyqueueid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getNotifyqueueidAsString() { return (notifyqueueid == null) ? "" : notifyqueueid; }

    // notifyqueueid setter methods.
    
    protected void markNotifyqueueidAsDirty(boolean aFlag)  { markFieldAsDirty(NOTIFYQUEUEID_DIRTYGROUP, NOTIFYQUEUEID_DIRTYMASK, aFlag); }


    public void setNotifyqueueid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markNotifyqueueidAsDirty(!equalsObject(notifyqueueid, p));
         notifyqueueid = p;
    }

    // maxnumberofretries getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMaxnumberofretriesDirty()  { return checkFieldDirtiness(MAXNUMBEROFRETRIES_DIRTYGROUP, MAXNUMBEROFRETRIES_DIRTYMASK); }

    public java.lang.Integer   getMaxnumberofretries() { return maxnumberofretries; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getMaxnumberofretriesAsString() { return integerAsString(maxnumberofretries); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getMaxnumberofretriesAsInt()    { return maxnumberofretries != null ? maxnumberofretries.intValue() : 0; }

    // maxnumberofretries setter methods.
    
    protected void markMaxnumberofretriesAsDirty(boolean aFlag)  { markFieldAsDirty(MAXNUMBEROFRETRIES_DIRTYGROUP, MAXNUMBEROFRETRIES_DIRTYMASK, aFlag); }


    public void setMaxnumberofretries(java.lang.Integer  p)
    {
        markMaxnumberofretriesAsDirty(!equalsObject(maxnumberofretries, p));
    	maxnumberofretries = p;
    }
    public void setMaxnumberofretries(int p)
    {
    	setMaxnumberofretries(new java.lang.Integer(p));
    }
    public void setMaxnumberofretries()
    {
    	setMaxnumberofretries(0);
    }
    public void setMaxnumberofretries(String  p)
    {
    	setMaxnumberofretries(stringAsInteger(p));
    }

}
