//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.card;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "CardDTOBase")
public class CardDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  cardid;
    protected java.lang.String  systemtitle;
    protected java.lang.String  pagelinktype;
    protected java.lang.String  pagelink;
    protected java.lang.String  pageid;
    protected java.sql.Date  refdate;
    protected java.lang.String  options;
    protected java.lang.String  validityrule;
    protected java.sql.Date  validfrom;
    protected java.sql.Date  validto;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;
    protected java.lang.String  categoryid;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String CARDID_DEFAULT  =  null;
    public static final java.lang.String SYSTEMTITLE_DEFAULT  =  null;
    public static final java.lang.String PAGELINKTYPE_DEFAULT  =  null;
    public static final java.lang.String PAGELINK_DEFAULT  =  null;
    public static final java.lang.String PAGEID_DEFAULT  =  null;
    public static final java.sql.Date REFDATE_DEFAULT  =  null;
    public static final java.lang.String OPTIONS_DEFAULT  =  null;
    public static final java.lang.String VALIDITYRULE_DEFAULT  =  null;
    public static final java.sql.Date VALIDFROM_DEFAULT  =  null;
    public static final java.sql.Date VALIDTO_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;
    public static final java.lang.String CATEGORYID_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int CARDID_DIRTYGROUP  =  0;
    public static final int CARDID_DIRTYMASK   =  2;
    public static final int SYSTEMTITLE_DIRTYGROUP  =  0;
    public static final int SYSTEMTITLE_DIRTYMASK   =  4;
    public static final int PAGELINKTYPE_DIRTYGROUP  =  0;
    public static final int PAGELINKTYPE_DIRTYMASK   =  8;
    public static final int PAGELINK_DIRTYGROUP  =  0;
    public static final int PAGELINK_DIRTYMASK   =  16;
    public static final int PAGEID_DIRTYGROUP  =  0;
    public static final int PAGEID_DIRTYMASK   =  32;
    public static final int REFDATE_DIRTYGROUP  =  0;
    public static final int REFDATE_DIRTYMASK   =  64;
    public static final int OPTIONS_DIRTYGROUP  =  0;
    public static final int OPTIONS_DIRTYMASK   =  128;
    public static final int VALIDITYRULE_DIRTYGROUP  =  0;
    public static final int VALIDITYRULE_DIRTYMASK   =  256;
    public static final int VALIDFROM_DIRTYGROUP  =  0;
    public static final int VALIDFROM_DIRTYMASK   =  512;
    public static final int VALIDTO_DIRTYGROUP  =  0;
    public static final int VALIDTO_DIRTYMASK   =  1024;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  2048;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  4096;
    public static final int CATEGORYID_DIRTYGROUP  =  0;
    public static final int CATEGORYID_DIRTYMASK   =  8192;


    /**
      * DataBean constructor.
      */
    public CardDTOBase()
    {
       dirtyFlagsArray = new int[14 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       cardid = CARDID_DEFAULT;
       systemtitle = SYSTEMTITLE_DEFAULT;
       pagelinktype = PAGELINKTYPE_DEFAULT;
       pagelink = PAGELINK_DEFAULT;
       pageid = PAGEID_DEFAULT;
       refdate = REFDATE_DEFAULT;
       options = OPTIONS_DEFAULT;
       validityrule = VALIDITYRULE_DEFAULT;
       validfrom = VALIDFROM_DEFAULT;
       validto = VALIDTO_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
       categoryid = CATEGORYID_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public CardDTOBase(CardDTOBase another)
    {

       site = another.getSite();
       cardid = another.getCardid();
       systemtitle = another.getSystemtitle();
       pagelinktype = another.getPagelinktype();
       pagelink = another.getPagelink();
       pageid = another.getPageid();
       refdate = another.getRefdate();
       options = another.getOptions();
       validityrule = another.getValidityrule();
       validfrom = another.getValidfrom();
       validto = another.getValidto();
       recstatus = another.getRecstatus();
       rectimestamp = another.getRectimestamp();
       categoryid = another.getCategoryid();

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
        stb.append(cardid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (systemtitle != null)
        {
        stb.append(systemtitle);
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

    // cardid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCardidDirty()  { return checkFieldDirtiness(CARDID_DIRTYGROUP, CARDID_DIRTYMASK); }

    public java.lang.String   getCardid()         { return cardid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cardid")
    public java.lang.String   getCardidAsString() { return (cardid == null) ? "" : cardid; }

    // cardid setter methods.
    
    protected void markCardidAsDirty(boolean aFlag)  { markFieldAsDirty(CARDID_DIRTYGROUP, CARDID_DIRTYMASK, aFlag); }


    public void setCardid(String  p)
    {
       setCardid(p, DTOCasingStyle.none);
    }
    
    public void setCardid(String  p, DTOCasingStyle casingStyle)
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
       markCardidAsDirty(!equalsObject(cardid, p));
       cardid = p;
    }

    // systemtitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSystemtitleDirty()  { return checkFieldDirtiness(SYSTEMTITLE_DIRTYGROUP, SYSTEMTITLE_DIRTYMASK); }

    public java.lang.String   getSystemtitle()         { return systemtitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "systemtitle")
    public java.lang.String   getSystemtitleAsString() { return (systemtitle == null) ? "" : systemtitle; }

    // systemtitle setter methods.
    
    protected void markSystemtitleAsDirty(boolean aFlag)  { markFieldAsDirty(SYSTEMTITLE_DIRTYGROUP, SYSTEMTITLE_DIRTYMASK, aFlag); }


    public void setSystemtitle(String  p)
    {
       setSystemtitle(p, DTOCasingStyle.none);
    }
    
    public void setSystemtitle(String  p, DTOCasingStyle casingStyle)
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
       markSystemtitleAsDirty(!equalsObject(systemtitle, p));
       systemtitle = p;
    }

    // pagelinktype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPagelinktypeDirty()  { return checkFieldDirtiness(PAGELINKTYPE_DIRTYGROUP, PAGELINKTYPE_DIRTYMASK); }

    public java.lang.String   getPagelinktype()         { return pagelinktype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pagelinktype")
    public java.lang.String   getPagelinktypeAsString() { return (pagelinktype == null) ? "" : pagelinktype; }

    // pagelinktype setter methods.
    
    protected void markPagelinktypeAsDirty(boolean aFlag)  { markFieldAsDirty(PAGELINKTYPE_DIRTYGROUP, PAGELINKTYPE_DIRTYMASK, aFlag); }


    public void setPagelinktype(String  p)
    {
       setPagelinktype(p, DTOCasingStyle.none);
    }
    
    public void setPagelinktype(String  p, DTOCasingStyle casingStyle)
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
       markPagelinktypeAsDirty(!equalsObject(pagelinktype, p));
       pagelinktype = p;
    }

    // pagelink getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPagelinkDirty()  { return checkFieldDirtiness(PAGELINK_DIRTYGROUP, PAGELINK_DIRTYMASK); }

    public java.lang.String   getPagelink()         { return pagelink; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pagelink")
    public java.lang.String   getPagelinkAsString() { return (pagelink == null) ? "" : pagelink; }

    // pagelink setter methods.
    
    protected void markPagelinkAsDirty(boolean aFlag)  { markFieldAsDirty(PAGELINK_DIRTYGROUP, PAGELINK_DIRTYMASK, aFlag); }


    public void setPagelink(String  p)
    {
       setPagelink(p, DTOCasingStyle.none);
    }
    
    public void setPagelink(String  p, DTOCasingStyle casingStyle)
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
       markPagelinkAsDirty(!equalsObject(pagelink, p));
       pagelink = p;
    }

    // pageid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPageidDirty()  { return checkFieldDirtiness(PAGEID_DIRTYGROUP, PAGEID_DIRTYMASK); }

    public java.lang.String   getPageid()         { return pageid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pageid")
    public java.lang.String   getPageidAsString() { return (pageid == null) ? "" : pageid; }

    // pageid setter methods.
    
    protected void markPageidAsDirty(boolean aFlag)  { markFieldAsDirty(PAGEID_DIRTYGROUP, PAGEID_DIRTYMASK, aFlag); }


    public void setPageid(String  p)
    {
       setPageid(p, DTOCasingStyle.none);
    }
    
    public void setPageid(String  p, DTOCasingStyle casingStyle)
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
       markPageidAsDirty(!equalsObject(pageid, p));
       pageid = p;
    }

    // refdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRefdateDirty()  { return checkFieldDirtiness(REFDATE_DIRTYGROUP, REFDATE_DIRTYMASK); }

    public java.sql.Date   getRefdate() { return refdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "refdate")
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

    // options getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOptionsDirty()  { return checkFieldDirtiness(OPTIONS_DIRTYGROUP, OPTIONS_DIRTYMASK); }

    public java.lang.String   getOptions()         { return options; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "options")
    public java.lang.String   getOptionsAsString() { return (options == null) ? "" : options; }

    // options setter methods.
    
    protected void markOptionsAsDirty(boolean aFlag)  { markFieldAsDirty(OPTIONS_DIRTYGROUP, OPTIONS_DIRTYMASK, aFlag); }


    public void setOptions(String  p)
    {
       setOptions(p, DTOCasingStyle.none);
    }
    
    public void setOptions(String  p, DTOCasingStyle casingStyle)
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
       markOptionsAsDirty(!equalsObject(options, p));
       options = p;
    }

    // validityrule getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isValidityruleDirty()  { return checkFieldDirtiness(VALIDITYRULE_DIRTYGROUP, VALIDITYRULE_DIRTYMASK); }

    public java.lang.String   getValidityrule()         { return validityrule; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "validityrule")
    public java.lang.String   getValidityruleAsString() { return (validityrule == null) ? "" : validityrule; }

    // validityrule setter methods.
    
    protected void markValidityruleAsDirty(boolean aFlag)  { markFieldAsDirty(VALIDITYRULE_DIRTYGROUP, VALIDITYRULE_DIRTYMASK, aFlag); }


    public void setValidityrule(String  p)
    {
       setValidityrule(p, DTOCasingStyle.none);
    }
    
    public void setValidityrule(String  p, DTOCasingStyle casingStyle)
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
       markValidityruleAsDirty(!equalsObject(validityrule, p));
       validityrule = p;
    }

    // validfrom getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isValidfromDirty()  { return checkFieldDirtiness(VALIDFROM_DIRTYGROUP, VALIDFROM_DIRTYMASK); }

    public java.sql.Date   getValidfrom() { return validfrom; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "validfrom")
    public String getValidfromAsString() { return dateAsString(validfrom, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getValidfromAsString(java.text.DateFormat aDateFormat) { return dateAsString(validfrom, aDateFormat); }

    // validfrom setter methods.
    
    protected void markValidfromAsDirty(boolean aFlag)  { markFieldAsDirty(VALIDFROM_DIRTYGROUP, VALIDFROM_DIRTYMASK, aFlag); }


    public void setValidfrom(java.sql.Date  p)
    {
         markValidfromAsDirty(!equalsObject(validfrom, p));
    	 validfrom = p;
    }
    public void setValidfrom(String p, java.text.DateFormat aDateFormat)
    {
    	setValidfrom(stringAsDate(p, aDateFormat));
    }

    // validto getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isValidtoDirty()  { return checkFieldDirtiness(VALIDTO_DIRTYGROUP, VALIDTO_DIRTYMASK); }

    public java.sql.Date   getValidto() { return validto; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "validto")
    public String getValidtoAsString() { return dateAsString(validto, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getValidtoAsString(java.text.DateFormat aDateFormat) { return dateAsString(validto, aDateFormat); }

    // validto setter methods.
    
    protected void markValidtoAsDirty(boolean aFlag)  { markFieldAsDirty(VALIDTO_DIRTYGROUP, VALIDTO_DIRTYMASK, aFlag); }


    public void setValidto(java.sql.Date  p)
    {
         markValidtoAsDirty(!equalsObject(validto, p));
    	 validto = p;
    }
    public void setValidto(String p, java.text.DateFormat aDateFormat)
    {
    	setValidto(stringAsDate(p, aDateFormat));
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

    // categoryid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCategoryidDirty()  { return checkFieldDirtiness(CATEGORYID_DIRTYGROUP, CATEGORYID_DIRTYMASK); }

    public java.lang.String   getCategoryid()         { return categoryid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "categoryid")
    public java.lang.String   getCategoryidAsString() { return (categoryid == null) ? "" : categoryid; }

    // categoryid setter methods.
    
    protected void markCategoryidAsDirty(boolean aFlag)  { markFieldAsDirty(CATEGORYID_DIRTYGROUP, CATEGORYID_DIRTYMASK, aFlag); }


    public void setCategoryid(String  p)
    {
       setCategoryid(p, DTOCasingStyle.none);
    }
    
    public void setCategoryid(String  p, DTOCasingStyle casingStyle)
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
       markCategoryidAsDirty(!equalsObject(categoryid, p));
       categoryid = p;
    }

}
