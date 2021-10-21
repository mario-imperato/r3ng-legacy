//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.outmailspooler;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "OutMailSpoolerDTOBase")
public class OutMailSpoolerDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  messageid;
    protected java.lang.String  msgtitle;
    protected java.lang.String  msgtext;
    protected java.lang.String  msgfrom;
    protected java.lang.String  msgcc;
    protected java.lang.String  msgbcc;
    protected java.lang.String  msgmode;
    protected java.sql.Timestamp  msgsendat;
    protected java.lang.Integer  numberofattachments;
    protected java.lang.Integer  numberoftargets;
    protected java.lang.Integer  numberofsentitems;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String MESSAGEID_DEFAULT  =  null;
    public static final java.lang.String MSGTITLE_DEFAULT  =  null;
    public static final java.lang.String MSGTEXT_DEFAULT  =  null;
    public static final java.lang.String MSGFROM_DEFAULT  =  null;
    public static final java.lang.String MSGCC_DEFAULT  =  null;
    public static final java.lang.String MSGBCC_DEFAULT  =  null;
    public static final java.lang.String MSGMODE_DEFAULT  =  null;
    public static final java.sql.Timestamp MSGSENDAT_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFATTACHMENTS_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFTARGETS_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFSENTITEMS_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int MESSAGEID_DIRTYGROUP  =  0;
    public static final int MESSAGEID_DIRTYMASK   =  2;
    public static final int MSGTITLE_DIRTYGROUP  =  0;
    public static final int MSGTITLE_DIRTYMASK   =  4;
    public static final int MSGTEXT_DIRTYGROUP  =  0;
    public static final int MSGTEXT_DIRTYMASK   =  8;
    public static final int MSGFROM_DIRTYGROUP  =  0;
    public static final int MSGFROM_DIRTYMASK   =  16;
    public static final int MSGCC_DIRTYGROUP  =  0;
    public static final int MSGCC_DIRTYMASK   =  32;
    public static final int MSGBCC_DIRTYGROUP  =  0;
    public static final int MSGBCC_DIRTYMASK   =  64;
    public static final int MSGMODE_DIRTYGROUP  =  0;
    public static final int MSGMODE_DIRTYMASK   =  128;
    public static final int MSGSENDAT_DIRTYGROUP  =  0;
    public static final int MSGSENDAT_DIRTYMASK   =  256;
    public static final int NUMBEROFATTACHMENTS_DIRTYGROUP  =  0;
    public static final int NUMBEROFATTACHMENTS_DIRTYMASK   =  512;
    public static final int NUMBEROFTARGETS_DIRTYGROUP  =  0;
    public static final int NUMBEROFTARGETS_DIRTYMASK   =  1024;
    public static final int NUMBEROFSENTITEMS_DIRTYGROUP  =  0;
    public static final int NUMBEROFSENTITEMS_DIRTYMASK   =  2048;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  4096;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  8192;


    /**
      * DataBean constructor.
      */
    public OutMailSpoolerDTOBase()
    {
       dirtyFlagsArray = new int[14 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       messageid = MESSAGEID_DEFAULT;
       msgtitle = MSGTITLE_DEFAULT;
       msgtext = MSGTEXT_DEFAULT;
       msgfrom = MSGFROM_DEFAULT;
       msgcc = MSGCC_DEFAULT;
       msgbcc = MSGBCC_DEFAULT;
       msgmode = MSGMODE_DEFAULT;
       msgsendat = MSGSENDAT_DEFAULT;
       numberofattachments = NUMBEROFATTACHMENTS_DEFAULT;
       numberoftargets = NUMBEROFTARGETS_DEFAULT;
       numberofsentitems = NUMBEROFSENTITEMS_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public OutMailSpoolerDTOBase(OutMailSpoolerDTOBase another)
    {

       site = another.getSite();
       messageid = another.getMessageid();
       msgtitle = another.getMsgtitle();
       msgtext = another.getMsgtext();
       msgfrom = another.getMsgfrom();
       msgcc = another.getMsgcc();
       msgbcc = another.getMsgbcc();
       msgmode = another.getMsgmode();
       msgsendat = another.getMsgsendat();
       numberofattachments = another.getNumberofattachments();
       numberoftargets = another.getNumberoftargets();
       numberofsentitems = another.getNumberofsentitems();
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
        stb.append(messageid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (msgtitle != null)
        {
        stb.append(msgtitle);
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

    // msgtitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMsgtitleDirty()  { return checkFieldDirtiness(MSGTITLE_DIRTYGROUP, MSGTITLE_DIRTYMASK); }

    public java.lang.String   getMsgtitle()         { return msgtitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "msgtitle")
    public java.lang.String   getMsgtitleAsString() { return (msgtitle == null) ? "" : msgtitle; }

    // msgtitle setter methods.
    
    protected void markMsgtitleAsDirty(boolean aFlag)  { markFieldAsDirty(MSGTITLE_DIRTYGROUP, MSGTITLE_DIRTYMASK, aFlag); }


    public void setMsgtitle(String  p)
    {
       setMsgtitle(p, DTOCasingStyle.none);
    }
    
    public void setMsgtitle(String  p, DTOCasingStyle casingStyle)
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
       markMsgtitleAsDirty(!equalsObject(msgtitle, p));
       msgtitle = p;
    }

    // msgtext getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMsgtextDirty()  { return checkFieldDirtiness(MSGTEXT_DIRTYGROUP, MSGTEXT_DIRTYMASK); }

    public java.lang.String   getMsgtext()         { return msgtext; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "msgtext")
    public java.lang.String   getMsgtextAsString() { return (msgtext == null) ? "" : msgtext; }

    // msgtext setter methods.
    
    protected void markMsgtextAsDirty(boolean aFlag)  { markFieldAsDirty(MSGTEXT_DIRTYGROUP, MSGTEXT_DIRTYMASK, aFlag); }


    public void setMsgtext(String  p)
    {
       setMsgtext(p, DTOCasingStyle.none);
    }
    
    public void setMsgtext(String  p, DTOCasingStyle casingStyle)
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
       markMsgtextAsDirty(!equalsObject(msgtext, p));
       msgtext = p;
    }

    // msgfrom getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMsgfromDirty()  { return checkFieldDirtiness(MSGFROM_DIRTYGROUP, MSGFROM_DIRTYMASK); }

    public java.lang.String   getMsgfrom()         { return msgfrom; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "msgfrom")
    public java.lang.String   getMsgfromAsString() { return (msgfrom == null) ? "" : msgfrom; }

    // msgfrom setter methods.
    
    protected void markMsgfromAsDirty(boolean aFlag)  { markFieldAsDirty(MSGFROM_DIRTYGROUP, MSGFROM_DIRTYMASK, aFlag); }


    public void setMsgfrom(String  p)
    {
       setMsgfrom(p, DTOCasingStyle.none);
    }
    
    public void setMsgfrom(String  p, DTOCasingStyle casingStyle)
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
       markMsgfromAsDirty(!equalsObject(msgfrom, p));
       msgfrom = p;
    }

    // msgcc getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMsgccDirty()  { return checkFieldDirtiness(MSGCC_DIRTYGROUP, MSGCC_DIRTYMASK); }

    public java.lang.String   getMsgcc()         { return msgcc; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "msgcc")
    public java.lang.String   getMsgccAsString() { return (msgcc == null) ? "" : msgcc; }

    // msgcc setter methods.
    
    protected void markMsgccAsDirty(boolean aFlag)  { markFieldAsDirty(MSGCC_DIRTYGROUP, MSGCC_DIRTYMASK, aFlag); }


    public void setMsgcc(String  p)
    {
       setMsgcc(p, DTOCasingStyle.none);
    }
    
    public void setMsgcc(String  p, DTOCasingStyle casingStyle)
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
       markMsgccAsDirty(!equalsObject(msgcc, p));
       msgcc = p;
    }

    // msgbcc getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMsgbccDirty()  { return checkFieldDirtiness(MSGBCC_DIRTYGROUP, MSGBCC_DIRTYMASK); }

    public java.lang.String   getMsgbcc()         { return msgbcc; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "msgbcc")
    public java.lang.String   getMsgbccAsString() { return (msgbcc == null) ? "" : msgbcc; }

    // msgbcc setter methods.
    
    protected void markMsgbccAsDirty(boolean aFlag)  { markFieldAsDirty(MSGBCC_DIRTYGROUP, MSGBCC_DIRTYMASK, aFlag); }


    public void setMsgbcc(String  p)
    {
       setMsgbcc(p, DTOCasingStyle.none);
    }
    
    public void setMsgbcc(String  p, DTOCasingStyle casingStyle)
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
       markMsgbccAsDirty(!equalsObject(msgbcc, p));
       msgbcc = p;
    }

    // msgmode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMsgmodeDirty()  { return checkFieldDirtiness(MSGMODE_DIRTYGROUP, MSGMODE_DIRTYMASK); }

    public java.lang.String   getMsgmode()         { return msgmode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "msgmode")
    public java.lang.String   getMsgmodeAsString() { return (msgmode == null) ? "" : msgmode; }

    // msgmode setter methods.
    
    protected void markMsgmodeAsDirty(boolean aFlag)  { markFieldAsDirty(MSGMODE_DIRTYGROUP, MSGMODE_DIRTYMASK, aFlag); }


    public void setMsgmode(String  p)
    {
       setMsgmode(p, DTOCasingStyle.none);
    }
    
    public void setMsgmode(String  p, DTOCasingStyle casingStyle)
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
       markMsgmodeAsDirty(!equalsObject(msgmode, p));
       msgmode = p;
    }

    // msgsendat getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMsgsendatDirty()  { return checkFieldDirtiness(MSGSENDAT_DIRTYGROUP, MSGSENDAT_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getMsgsendat() { return msgsendat; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "msgsendat")
    public String getMsgsendatAsString() { return timestampAsString(msgsendat, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getMsgsendatAsString(java.text.DateFormat aDateFormat) { return timestampAsString(msgsendat, aDateFormat); }

    // msgsendat setter methods.
    
    protected void markMsgsendatAsDirty(boolean aFlag)  { markFieldAsDirty(MSGSENDAT_DIRTYGROUP, MSGSENDAT_DIRTYMASK, aFlag); }


    public void setMsgsendat(java.sql.Timestamp  p)
    {
        markMsgsendatAsDirty(!equalsObject(msgsendat, p));
    	msgsendat = p;
    }
    public void setMsgsendat(String  p, java.text.DateFormat aDateFormat)
    {
    	setMsgsendat(stringAsTimestamp(p, aDateFormat));
    }

    // numberofattachments getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofattachmentsDirty()  { return checkFieldDirtiness(NUMBEROFATTACHMENTS_DIRTYGROUP, NUMBEROFATTACHMENTS_DIRTYMASK); }

    public java.lang.Integer   getNumberofattachments() { return numberofattachments; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numberofattachments")
    public String getNumberofattachmentsAsString() { return integerAsString(numberofattachments); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofattachmentsAsInt()    { return numberofattachments != null ? numberofattachments.intValue() : 0; }

    // numberofattachments setter methods.
    
    protected void markNumberofattachmentsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFATTACHMENTS_DIRTYGROUP, NUMBEROFATTACHMENTS_DIRTYMASK, aFlag); }


    public void setNumberofattachments(java.lang.Integer  p)
    {
        markNumberofattachmentsAsDirty(!equalsObject(numberofattachments, p));
    	numberofattachments = p;
    }
    public void setNumberofattachments(int p)
    {
    	setNumberofattachments(new java.lang.Integer(p));
    }
    public void setNumberofattachments()
    {
    	setNumberofattachments(0);
    }
    public void setNumberofattachments(String  p)
    {
    	setNumberofattachments(stringAsInteger(p));
    }

    // numberoftargets getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberoftargetsDirty()  { return checkFieldDirtiness(NUMBEROFTARGETS_DIRTYGROUP, NUMBEROFTARGETS_DIRTYMASK); }

    public java.lang.Integer   getNumberoftargets() { return numberoftargets; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numberoftargets")
    public String getNumberoftargetsAsString() { return integerAsString(numberoftargets); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberoftargetsAsInt()    { return numberoftargets != null ? numberoftargets.intValue() : 0; }

    // numberoftargets setter methods.
    
    protected void markNumberoftargetsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFTARGETS_DIRTYGROUP, NUMBEROFTARGETS_DIRTYMASK, aFlag); }


    public void setNumberoftargets(java.lang.Integer  p)
    {
        markNumberoftargetsAsDirty(!equalsObject(numberoftargets, p));
    	numberoftargets = p;
    }
    public void setNumberoftargets(int p)
    {
    	setNumberoftargets(new java.lang.Integer(p));
    }
    public void setNumberoftargets()
    {
    	setNumberoftargets(0);
    }
    public void setNumberoftargets(String  p)
    {
    	setNumberoftargets(stringAsInteger(p));
    }

    // numberofsentitems getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofsentitemsDirty()  { return checkFieldDirtiness(NUMBEROFSENTITEMS_DIRTYGROUP, NUMBEROFSENTITEMS_DIRTYMASK); }

    public java.lang.Integer   getNumberofsentitems() { return numberofsentitems; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numberofsentitems")
    public String getNumberofsentitemsAsString() { return integerAsString(numberofsentitems); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofsentitemsAsInt()    { return numberofsentitems != null ? numberofsentitems.intValue() : 0; }

    // numberofsentitems setter methods.
    
    protected void markNumberofsentitemsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFSENTITEMS_DIRTYGROUP, NUMBEROFSENTITEMS_DIRTYMASK, aFlag); }


    public void setNumberofsentitems(java.lang.Integer  p)
    {
        markNumberofsentitemsAsDirty(!equalsObject(numberofsentitems, p));
    	numberofsentitems = p;
    }
    public void setNumberofsentitems(int p)
    {
    	setNumberofsentitems(new java.lang.Integer(p));
    }
    public void setNumberofsentitems()
    {
    	setNumberofsentitems(0);
    }
    public void setNumberofsentitems(String  p)
    {
    	setNumberofsentitems(stringAsInteger(p));
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
