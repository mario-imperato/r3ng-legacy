//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspoolerrecipient;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "OutMailSpoolerRecipientDTOBase")
public class OutMailSpoolerRecipientDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.Integer  recipientid;
    protected java.lang.String  site;
    protected java.lang.String  messageid;
    protected java.lang.String  msgto;
    protected java.lang.String  businesskey;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.Integer RECIPIENTID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String MESSAGEID_DEFAULT  =  null;
    public static final java.lang.String MSGTO_DEFAULT  =  null;
    public static final java.lang.String BUSINESSKEY_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int RECIPIENTID_DIRTYGROUP  =  0;
    public static final int RECIPIENTID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int MESSAGEID_DIRTYGROUP  =  0;
    public static final int MESSAGEID_DIRTYMASK   =  4;
    public static final int MSGTO_DIRTYGROUP  =  0;
    public static final int MSGTO_DIRTYMASK   =  8;
    public static final int BUSINESSKEY_DIRTYGROUP  =  0;
    public static final int BUSINESSKEY_DIRTYMASK   =  16;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  32;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  64;


    /**
      * DataBean constructor.
      */
    public OutMailSpoolerRecipientDTOBase()
    {
       dirtyFlagsArray = new int[7 / 30 + 1];
       clearDirtyFlags();

       recipientid = RECIPIENTID_DEFAULT;
       site = SITE_DEFAULT;
       messageid = MESSAGEID_DEFAULT;
       msgto = MSGTO_DEFAULT;
       businesskey = BUSINESSKEY_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public OutMailSpoolerRecipientDTOBase(OutMailSpoolerRecipientDTOBase another)
    {

       recipientid = another.getRecipientid();
       site = another.getSite();
       messageid = another.getMessageid();
       msgto = another.getMsgto();
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
        stb.append(recipientid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (msgto != null)
        {
        stb.append(msgto);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // recipientid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRecipientidDirty()  { return checkFieldDirtiness(RECIPIENTID_DIRTYGROUP, RECIPIENTID_DIRTYMASK); }

    public java.lang.Integer   getRecipientid() { return recipientid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "recipientid")
    public String getRecipientidAsString() { return integerAsString(recipientid); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getRecipientidAsInt()    { return recipientid != null ? recipientid.intValue() : 0; }

    // recipientid setter methods.
    
    protected void markRecipientidAsDirty(boolean aFlag)  { markFieldAsDirty(RECIPIENTID_DIRTYGROUP, RECIPIENTID_DIRTYMASK, aFlag); }


    public void setRecipientid(java.lang.Integer  p)
    {
        markRecipientidAsDirty(!equalsObject(recipientid, p));
    	recipientid = p;
    }
    public void setRecipientid(int p)
    {
    	setRecipientid(new java.lang.Integer(p));
    }
    public void setRecipientid()
    {
    	setRecipientid(0);
    }
    public void setRecipientid(String  p)
    {
    	setRecipientid(stringAsInteger(p));
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

    // messageid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMessageidDirty()  { return checkFieldDirtiness(MESSAGEID_DIRTYGROUP, MESSAGEID_DIRTYMASK); }

    public java.lang.String   getMessageid()         { return messageid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "messageid")
    public java.lang.String   getMessageidAsString() { return (messageid == null) ? "" : messageid; }

    // messageid setter methods.
    
    protected void markMessageidAsDirty(boolean aFlag)  { markFieldAsDirty(MESSAGEID_DIRTYGROUP, MESSAGEID_DIRTYMASK, aFlag); }


    public void setMessageid(String  p)
    {
       setMessageid(p, DTOCasingStyle.none);
    }
    
    public void setMessageid(String  p, DTOCasingStyle casingStyle)
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
       markMessageidAsDirty(!equalsObject(messageid, p));
       messageid = p;
    }

    // msgto getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMsgtoDirty()  { return checkFieldDirtiness(MSGTO_DIRTYGROUP, MSGTO_DIRTYMASK); }

    public java.lang.String   getMsgto()         { return msgto; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "msgto")
    public java.lang.String   getMsgtoAsString() { return (msgto == null) ? "" : msgto; }

    // msgto setter methods.
    
    protected void markMsgtoAsDirty(boolean aFlag)  { markFieldAsDirty(MSGTO_DIRTYGROUP, MSGTO_DIRTYMASK, aFlag); }


    public void setMsgto(String  p)
    {
       setMsgto(p, DTOCasingStyle.none);
    }
    
    public void setMsgto(String  p, DTOCasingStyle casingStyle)
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
       markMsgtoAsDirty(!equalsObject(msgto, p));
       msgto = p;
    }

    // businesskey getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBusinesskeyDirty()  { return checkFieldDirtiness(BUSINESSKEY_DIRTYGROUP, BUSINESSKEY_DIRTYMASK); }

    public java.lang.String   getBusinesskey()         { return businesskey; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "businesskey")
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

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
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
