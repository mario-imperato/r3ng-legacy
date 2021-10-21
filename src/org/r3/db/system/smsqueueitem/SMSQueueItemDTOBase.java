//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueueitem;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SMSQueueItemDTOBase")
public class SMSQueueItemDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.Integer  smsitemid;
    protected java.lang.String  site;
    protected java.lang.String  smsid;
    protected java.lang.String  phonenumber;
    protected java.lang.String  businesskey;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.Integer SMSITEMID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String SMSID_DEFAULT  =  null;
    public static final java.lang.String PHONENUMBER_DEFAULT  =  null;
    public static final java.lang.String BUSINESSKEY_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SMSITEMID_DIRTYGROUP  =  0;
    public static final int SMSITEMID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int SMSID_DIRTYGROUP  =  0;
    public static final int SMSID_DIRTYMASK   =  4;
    public static final int PHONENUMBER_DIRTYGROUP  =  0;
    public static final int PHONENUMBER_DIRTYMASK   =  8;
    public static final int BUSINESSKEY_DIRTYGROUP  =  0;
    public static final int BUSINESSKEY_DIRTYMASK   =  16;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  32;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  64;


    /**
      * DataBean constructor.
      */
    public SMSQueueItemDTOBase()
    {
       dirtyFlagsArray = new int[7 / 30 + 1];
       clearDirtyFlags();

       smsitemid = SMSITEMID_DEFAULT;
       site = SITE_DEFAULT;
       smsid = SMSID_DEFAULT;
       phonenumber = PHONENUMBER_DEFAULT;
       businesskey = BUSINESSKEY_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SMSQueueItemDTOBase(SMSQueueItemDTOBase another)
    {

       smsitemid = another.getSmsitemid();
       site = another.getSite();
       smsid = another.getSmsid();
       phonenumber = another.getPhonenumber();
       businesskey = another.getBusinesskey();
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
        stb.append(smsitemid);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // smsitemid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSmsitemidDirty()  { return checkFieldDirtiness(SMSITEMID_DIRTYGROUP, SMSITEMID_DIRTYMASK); }

    public java.lang.Integer   getSmsitemid() { return smsitemid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getSmsitemidAsString() { return integerAsString(smsitemid); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getSmsitemidAsInt()    { return smsitemid != null ? smsitemid.intValue() : 0; }

    // smsitemid setter methods.
    
    protected void markSmsitemidAsDirty(boolean aFlag)  { markFieldAsDirty(SMSITEMID_DIRTYGROUP, SMSITEMID_DIRTYMASK, aFlag); }


    public void setSmsitemid(java.lang.Integer  p)
    {
        markSmsitemidAsDirty(!equalsObject(smsitemid, p));
    	smsitemid = p;
    }
    public void setSmsitemid(int p)
    {
    	setSmsitemid(new java.lang.Integer(p));
    }
    public void setSmsitemid()
    {
    	setSmsitemid(0);
    }
    public void setSmsitemid(String  p)
    {
    	setSmsitemid(stringAsInteger(p));
    }

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

    // smsid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSmsidDirty()  { return checkFieldDirtiness(SMSID_DIRTYGROUP, SMSID_DIRTYMASK); }

    public java.lang.String   getSmsid()         { return smsid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSmsidAsString() { return (smsid == null) ? "" : smsid; }

    // smsid setter methods.
    
    protected void markSmsidAsDirty(boolean aFlag)  { markFieldAsDirty(SMSID_DIRTYGROUP, SMSID_DIRTYMASK, aFlag); }


    public void setSmsid(String  p)
    {
       setSmsid(p, DTOCasingStyle.none);
    }
    
    public void setSmsid(String  p, DTOCasingStyle casingStyle)
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
       markSmsidAsDirty(!equalsObject(smsid, p));
       smsid = p;
    }

    // phonenumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPhonenumberDirty()  { return checkFieldDirtiness(PHONENUMBER_DIRTYGROUP, PHONENUMBER_DIRTYMASK); }

    public java.lang.String   getPhonenumber()         { return phonenumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPhonenumberAsString() { return (phonenumber == null) ? "" : phonenumber; }

    // phonenumber setter methods.
    
    protected void markPhonenumberAsDirty(boolean aFlag)  { markFieldAsDirty(PHONENUMBER_DIRTYGROUP, PHONENUMBER_DIRTYMASK, aFlag); }


    public void setPhonenumber(String  p)
    {
       setPhonenumber(p, DTOCasingStyle.none);
    }
    
    public void setPhonenumber(String  p, DTOCasingStyle casingStyle)
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
       markPhonenumberAsDirty(!equalsObject(phonenumber, p));
       phonenumber = p;
    }

    // businesskey getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBusinesskeyDirty()  { return checkFieldDirtiness(BUSINESSKEY_DIRTYGROUP, BUSINESSKEY_DIRTYMASK); }

    public java.lang.String   getBusinesskey()         { return businesskey; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getBusinesskeyAsString() { return (businesskey == null) ? "" : businesskey; }

    // businesskey setter methods.
    
    protected void markBusinesskeyAsDirty(boolean aFlag)  { markFieldAsDirty(BUSINESSKEY_DIRTYGROUP, BUSINESSKEY_DIRTYMASK, aFlag); }


    public void setBusinesskey(String  p)
    {
       setBusinesskey(p, DTOCasingStyle.none);
    }
    
    public void setBusinesskey(String  p, DTOCasingStyle casingStyle)
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
       markBusinesskeyAsDirty(!equalsObject(businesskey, p));
       businesskey = p;
    }

    // recstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRecstatusDirty()  { return checkFieldDirtiness(RECSTATUS_DIRTYGROUP, RECSTATUS_DIRTYMASK); }

    public java.lang.String   getRecstatus()         { return recstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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
