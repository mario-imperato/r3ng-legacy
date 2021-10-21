//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailattachment;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "OutMailAttachmentDTOBase")
public class OutMailAttachmentDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  attachmentid;
    protected java.lang.String  attachmentgroupid;
    protected java.lang.String  site;
    protected java.lang.String  messageid;
    protected java.lang.String  attachmenturl;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String ATTACHMENTID_DEFAULT  =  null;
    public static final java.lang.String ATTACHMENTGROUPID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String MESSAGEID_DEFAULT  =  null;
    public static final java.lang.String ATTACHMENTURL_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int ATTACHMENTID_DIRTYGROUP  =  0;
    public static final int ATTACHMENTID_DIRTYMASK   =  1;
    public static final int ATTACHMENTGROUPID_DIRTYGROUP  =  0;
    public static final int ATTACHMENTGROUPID_DIRTYMASK   =  2;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  4;
    public static final int MESSAGEID_DIRTYGROUP  =  0;
    public static final int MESSAGEID_DIRTYMASK   =  8;
    public static final int ATTACHMENTURL_DIRTYGROUP  =  0;
    public static final int ATTACHMENTURL_DIRTYMASK   =  16;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  32;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  64;


    /**
      * DataBean constructor.
      */
    public OutMailAttachmentDTOBase()
    {
       dirtyFlagsArray = new int[7 / 30 + 1];
       clearDirtyFlags();

       attachmentid = ATTACHMENTID_DEFAULT;
       attachmentgroupid = ATTACHMENTGROUPID_DEFAULT;
       site = SITE_DEFAULT;
       messageid = MESSAGEID_DEFAULT;
       attachmenturl = ATTACHMENTURL_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public OutMailAttachmentDTOBase(OutMailAttachmentDTOBase another)
    {

       attachmentid = another.getAttachmentid();
       attachmentgroupid = another.getAttachmentgroupid();
       site = another.getSite();
       messageid = another.getMessageid();
       attachmenturl = another.getAttachmenturl();
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
        stb.append(attachmentid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (attachmenturl != null)
        {
        stb.append(attachmenturl);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // attachmentid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAttachmentidDirty()  { return checkFieldDirtiness(ATTACHMENTID_DIRTYGROUP, ATTACHMENTID_DIRTYMASK); }

    public java.lang.String   getAttachmentid()         { return attachmentid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "attachmentid")
    public java.lang.String   getAttachmentidAsString() { return (attachmentid == null) ? "" : attachmentid; }

    // attachmentid setter methods.
    
    protected void markAttachmentidAsDirty(boolean aFlag)  { markFieldAsDirty(ATTACHMENTID_DIRTYGROUP, ATTACHMENTID_DIRTYMASK, aFlag); }


    public void setAttachmentid(String  p)
    {
       setAttachmentid(p, DTOCasingStyle.none);
    }
    
    public void setAttachmentid(String  p, DTOCasingStyle casingStyle)
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
       markAttachmentidAsDirty(!equalsObject(attachmentid, p));
       attachmentid = p;
    }

    // attachmentgroupid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAttachmentgroupidDirty()  { return checkFieldDirtiness(ATTACHMENTGROUPID_DIRTYGROUP, ATTACHMENTGROUPID_DIRTYMASK); }

    public java.lang.String   getAttachmentgroupid()         { return attachmentgroupid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "attachmentgroupid")
    public java.lang.String   getAttachmentgroupidAsString() { return (attachmentgroupid == null) ? "" : attachmentgroupid; }

    // attachmentgroupid setter methods.
    
    protected void markAttachmentgroupidAsDirty(boolean aFlag)  { markFieldAsDirty(ATTACHMENTGROUPID_DIRTYGROUP, ATTACHMENTGROUPID_DIRTYMASK, aFlag); }


    public void setAttachmentgroupid(String  p)
    {
       setAttachmentgroupid(p, DTOCasingStyle.none);
    }
    
    public void setAttachmentgroupid(String  p, DTOCasingStyle casingStyle)
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
       markAttachmentgroupidAsDirty(!equalsObject(attachmentgroupid, p));
       attachmentgroupid = p;
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

    // attachmenturl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAttachmenturlDirty()  { return checkFieldDirtiness(ATTACHMENTURL_DIRTYGROUP, ATTACHMENTURL_DIRTYMASK); }

    public java.lang.String   getAttachmenturl()         { return attachmenturl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "attachmenturl")
    public java.lang.String   getAttachmenturlAsString() { return (attachmenturl == null) ? "" : attachmenturl; }

    // attachmenturl setter methods.
    
    protected void markAttachmenturlAsDirty(boolean aFlag)  { markFieldAsDirty(ATTACHMENTURL_DIRTYGROUP, ATTACHMENTURL_DIRTYMASK, aFlag); }


    public void setAttachmenturl(String  p)
    {
       setAttachmenturl(p, DTOCasingStyle.none);
    }
    
    public void setAttachmenturl(String  p, DTOCasingStyle casingStyle)
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
       markAttachmenturlAsDirty(!equalsObject(attachmenturl, p));
       attachmenturl = p;
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
