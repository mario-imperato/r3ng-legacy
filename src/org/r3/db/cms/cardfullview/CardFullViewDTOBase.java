//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardfullview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "CardFullViewDTOBase")
public class CardFullViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  cardid;
    protected java.lang.String  languagecode;
    protected java.lang.String  categoryid;
    protected java.lang.String  pagelinktype;
    protected java.lang.String  pagelink;
    protected java.lang.String  pageid;
    protected java.sql.Date  refdate;
    protected java.lang.String  options;
    protected java.lang.String  title;
    protected java.lang.String  summary;
    protected java.lang.String  textbody;
    protected java.sql.Timestamp  rectimestamp;
    protected java.lang.String  propertyid;
    protected java.lang.String  propertyrole;
    protected java.lang.String  propertytypecode;
    protected java.lang.String  propertyname;
    protected java.lang.String  propertyvalue;
    protected java.lang.Integer  propertysize;
    protected java.lang.String  refpropertyid;
    protected java.lang.String  contenttype;
    protected java.lang.String  imageurl;
    protected java.lang.Integer  imageheight;
    protected java.lang.Integer  imagewidth;
    protected java.lang.String  iconurl;
    protected java.lang.Integer  iconheight;
    protected java.lang.Integer  iconwidth;
    protected java.sql.Timestamp  proprectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String CARDID_DEFAULT  =  null;
    public static final java.lang.String LANGUAGECODE_DEFAULT  =  null;
    public static final java.lang.String CATEGORYID_DEFAULT  =  null;
    public static final java.lang.String PAGELINKTYPE_DEFAULT  =  null;
    public static final java.lang.String PAGELINK_DEFAULT  =  null;
    public static final java.lang.String PAGEID_DEFAULT  =  null;
    public static final java.sql.Date REFDATE_DEFAULT  =  null;
    public static final java.lang.String OPTIONS_DEFAULT  =  null;
    public static final java.lang.String TITLE_DEFAULT  =  null;
    public static final java.lang.String SUMMARY_DEFAULT  =  null;
    public static final java.lang.String TEXTBODY_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;
    public static final java.lang.String PROPERTYID_DEFAULT  =  null;
    public static final java.lang.String PROPERTYROLE_DEFAULT  =  null;
    public static final java.lang.String PROPERTYTYPECODE_DEFAULT  =  null;
    public static final java.lang.String PROPERTYNAME_DEFAULT  =  null;
    public static final java.lang.String PROPERTYVALUE_DEFAULT  =  null;
    public static final java.lang.Integer PROPERTYSIZE_DEFAULT  =  null;
    public static final java.lang.String REFPROPERTYID_DEFAULT  =  null;
    public static final java.lang.String CONTENTTYPE_DEFAULT  =  null;
    public static final java.lang.String IMAGEURL_DEFAULT  =  null;
    public static final java.lang.Integer IMAGEHEIGHT_DEFAULT  =  null;
    public static final java.lang.Integer IMAGEWIDTH_DEFAULT  =  null;
    public static final java.lang.String ICONURL_DEFAULT  =  null;
    public static final java.lang.Integer ICONHEIGHT_DEFAULT  =  null;
    public static final java.lang.Integer ICONWIDTH_DEFAULT  =  null;
    public static final java.sql.Timestamp PROPRECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int CARDID_DIRTYGROUP  =  0;
    public static final int CARDID_DIRTYMASK   =  2;
    public static final int LANGUAGECODE_DIRTYGROUP  =  0;
    public static final int LANGUAGECODE_DIRTYMASK   =  4;
    public static final int CATEGORYID_DIRTYGROUP  =  0;
    public static final int CATEGORYID_DIRTYMASK   =  8;
    public static final int PAGELINKTYPE_DIRTYGROUP  =  0;
    public static final int PAGELINKTYPE_DIRTYMASK   =  16;
    public static final int PAGELINK_DIRTYGROUP  =  0;
    public static final int PAGELINK_DIRTYMASK   =  32;
    public static final int PAGEID_DIRTYGROUP  =  0;
    public static final int PAGEID_DIRTYMASK   =  64;
    public static final int REFDATE_DIRTYGROUP  =  0;
    public static final int REFDATE_DIRTYMASK   =  128;
    public static final int OPTIONS_DIRTYGROUP  =  0;
    public static final int OPTIONS_DIRTYMASK   =  256;
    public static final int TITLE_DIRTYGROUP  =  0;
    public static final int TITLE_DIRTYMASK   =  512;
    public static final int SUMMARY_DIRTYGROUP  =  0;
    public static final int SUMMARY_DIRTYMASK   =  1024;
    public static final int TEXTBODY_DIRTYGROUP  =  0;
    public static final int TEXTBODY_DIRTYMASK   =  2048;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  4096;
    public static final int PROPERTYID_DIRTYGROUP  =  0;
    public static final int PROPERTYID_DIRTYMASK   =  8192;
    public static final int PROPERTYROLE_DIRTYGROUP  =  0;
    public static final int PROPERTYROLE_DIRTYMASK   =  16384;
    public static final int PROPERTYTYPECODE_DIRTYGROUP  =  0;
    public static final int PROPERTYTYPECODE_DIRTYMASK   =  32768;
    public static final int PROPERTYNAME_DIRTYGROUP  =  0;
    public static final int PROPERTYNAME_DIRTYMASK   =  65536;
    public static final int PROPERTYVALUE_DIRTYGROUP  =  0;
    public static final int PROPERTYVALUE_DIRTYMASK   =  131072;
    public static final int PROPERTYSIZE_DIRTYGROUP  =  0;
    public static final int PROPERTYSIZE_DIRTYMASK   =  262144;
    public static final int REFPROPERTYID_DIRTYGROUP  =  0;
    public static final int REFPROPERTYID_DIRTYMASK   =  524288;
    public static final int CONTENTTYPE_DIRTYGROUP  =  0;
    public static final int CONTENTTYPE_DIRTYMASK   =  1048576;
    public static final int IMAGEURL_DIRTYGROUP  =  0;
    public static final int IMAGEURL_DIRTYMASK   =  2097152;
    public static final int IMAGEHEIGHT_DIRTYGROUP  =  0;
    public static final int IMAGEHEIGHT_DIRTYMASK   =  4194304;
    public static final int IMAGEWIDTH_DIRTYGROUP  =  0;
    public static final int IMAGEWIDTH_DIRTYMASK   =  8388608;
    public static final int ICONURL_DIRTYGROUP  =  0;
    public static final int ICONURL_DIRTYMASK   =  16777216;
    public static final int ICONHEIGHT_DIRTYGROUP  =  0;
    public static final int ICONHEIGHT_DIRTYMASK   =  33554432;
    public static final int ICONWIDTH_DIRTYGROUP  =  0;
    public static final int ICONWIDTH_DIRTYMASK   =  67108864;
    public static final int PROPRECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int PROPRECTIMESTAMP_DIRTYMASK   =  134217728;


    /**
      * DataBean constructor.
      */
    public CardFullViewDTOBase()
    {
       dirtyFlagsArray = new int[28 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       cardid = CARDID_DEFAULT;
       languagecode = LANGUAGECODE_DEFAULT;
       categoryid = CATEGORYID_DEFAULT;
       pagelinktype = PAGELINKTYPE_DEFAULT;
       pagelink = PAGELINK_DEFAULT;
       pageid = PAGEID_DEFAULT;
       refdate = REFDATE_DEFAULT;
       options = OPTIONS_DEFAULT;
       title = TITLE_DEFAULT;
       summary = SUMMARY_DEFAULT;
       textbody = TEXTBODY_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
       propertyid = PROPERTYID_DEFAULT;
       propertyrole = PROPERTYROLE_DEFAULT;
       propertytypecode = PROPERTYTYPECODE_DEFAULT;
       propertyname = PROPERTYNAME_DEFAULT;
       propertyvalue = PROPERTYVALUE_DEFAULT;
       propertysize = PROPERTYSIZE_DEFAULT;
       refpropertyid = REFPROPERTYID_DEFAULT;
       contenttype = CONTENTTYPE_DEFAULT;
       imageurl = IMAGEURL_DEFAULT;
       imageheight = IMAGEHEIGHT_DEFAULT;
       imagewidth = IMAGEWIDTH_DEFAULT;
       iconurl = ICONURL_DEFAULT;
       iconheight = ICONHEIGHT_DEFAULT;
       iconwidth = ICONWIDTH_DEFAULT;
       proprectimestamp = PROPRECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public CardFullViewDTOBase(CardFullViewDTOBase another)
    {

       site = another.getSite();
       cardid = another.getCardid();
       languagecode = another.getLanguagecode();
       categoryid = another.getCategoryid();
       pagelinktype = another.getPagelinktype();
       pagelink = another.getPagelink();
       pageid = another.getPageid();
       refdate = another.getRefdate();
       options = another.getOptions();
       title = another.getTitle();
       summary = another.getSummary();
       textbody = another.getTextbody();
       rectimestamp = another.getRectimestamp();
       propertyid = another.getPropertyid();
       propertyrole = another.getPropertyrole();
       propertytypecode = another.getPropertytypecode();
       propertyname = another.getPropertyname();
       propertyvalue = another.getPropertyvalue();
       propertysize = another.getPropertysize();
       refpropertyid = another.getRefpropertyid();
       contenttype = another.getContenttype();
       imageurl = another.getImageurl();
       imageheight = another.getImageheight();
       imagewidth = another.getImagewidth();
       iconurl = another.getIconurl();
       iconheight = another.getIconheight();
       iconwidth = another.getIconwidth();
       proprectimestamp = another.getProprectimestamp();

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

    // languagecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLanguagecodeDirty()  { return checkFieldDirtiness(LANGUAGECODE_DIRTYGROUP, LANGUAGECODE_DIRTYMASK); }

    public java.lang.String   getLanguagecode()         { return languagecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "languagecode")
    public java.lang.String   getLanguagecodeAsString() { return (languagecode == null) ? "" : languagecode; }

    // languagecode setter methods.
    
    protected void markLanguagecodeAsDirty(boolean aFlag)  { markFieldAsDirty(LANGUAGECODE_DIRTYGROUP, LANGUAGECODE_DIRTYMASK, aFlag); }


    public void setLanguagecode(String  p)
    {
       setLanguagecode(p, DTOCasingStyle.none);
    }
    
    public void setLanguagecode(String  p, DTOCasingStyle casingStyle)
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
       markLanguagecodeAsDirty(!equalsObject(languagecode, p));
       languagecode = p;
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

    // title getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTitleDirty()  { return checkFieldDirtiness(TITLE_DIRTYGROUP, TITLE_DIRTYMASK); }

    public java.lang.String   getTitle()         { return title; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "title")
    public java.lang.String   getTitleAsString() { return (title == null) ? "" : title; }

    // title setter methods.
    
    protected void markTitleAsDirty(boolean aFlag)  { markFieldAsDirty(TITLE_DIRTYGROUP, TITLE_DIRTYMASK, aFlag); }


    public void setTitle(String  p)
    {
       setTitle(p, DTOCasingStyle.none);
    }
    
    public void setTitle(String  p, DTOCasingStyle casingStyle)
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
       markTitleAsDirty(!equalsObject(title, p));
       title = p;
    }

    // summary getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSummaryDirty()  { return checkFieldDirtiness(SUMMARY_DIRTYGROUP, SUMMARY_DIRTYMASK); }

    public java.lang.String   getSummary()         { return summary; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "summary")
    public java.lang.String   getSummaryAsString() { return (summary == null) ? "" : summary; }

    // summary setter methods.
    
    protected void markSummaryAsDirty(boolean aFlag)  { markFieldAsDirty(SUMMARY_DIRTYGROUP, SUMMARY_DIRTYMASK, aFlag); }


    public void setSummary(String  p)
    {
       setSummary(p, DTOCasingStyle.none);
    }
    
    public void setSummary(String  p, DTOCasingStyle casingStyle)
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
       markSummaryAsDirty(!equalsObject(summary, p));
       summary = p;
    }

    // textbody getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTextbodyDirty()  { return checkFieldDirtiness(TEXTBODY_DIRTYGROUP, TEXTBODY_DIRTYMASK); }

    public java.lang.String   getTextbody()         { return textbody; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "textbody")
    public java.lang.String   getTextbodyAsString() { return (textbody == null) ? "" : textbody; }

    // textbody setter methods.
    
    protected void markTextbodyAsDirty(boolean aFlag)  { markFieldAsDirty(TEXTBODY_DIRTYGROUP, TEXTBODY_DIRTYMASK, aFlag); }


    public void setTextbody(String  p)
    {
       setTextbody(p, DTOCasingStyle.none);
    }
    
    public void setTextbody(String  p, DTOCasingStyle casingStyle)
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
       markTextbodyAsDirty(!equalsObject(textbody, p));
       textbody = p;
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

    // propertyid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertyidDirty()  { return checkFieldDirtiness(PROPERTYID_DIRTYGROUP, PROPERTYID_DIRTYMASK); }

    public java.lang.String   getPropertyid()         { return propertyid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "propertyid")
    public java.lang.String   getPropertyidAsString() { return (propertyid == null) ? "" : propertyid; }

    // propertyid setter methods.
    
    protected void markPropertyidAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYID_DIRTYGROUP, PROPERTYID_DIRTYMASK, aFlag); }


    public void setPropertyid(String  p)
    {
       setPropertyid(p, DTOCasingStyle.none);
    }
    
    public void setPropertyid(String  p, DTOCasingStyle casingStyle)
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
       markPropertyidAsDirty(!equalsObject(propertyid, p));
       propertyid = p;
    }

    // propertyrole getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertyroleDirty()  { return checkFieldDirtiness(PROPERTYROLE_DIRTYGROUP, PROPERTYROLE_DIRTYMASK); }

    public java.lang.String   getPropertyrole()         { return propertyrole; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "propertyrole")
    public java.lang.String   getPropertyroleAsString() { return (propertyrole == null) ? "" : propertyrole; }

    // propertyrole setter methods.
    
    protected void markPropertyroleAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYROLE_DIRTYGROUP, PROPERTYROLE_DIRTYMASK, aFlag); }


    public void setPropertyrole(String  p)
    {
       setPropertyrole(p, DTOCasingStyle.none);
    }
    
    public void setPropertyrole(String  p, DTOCasingStyle casingStyle)
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
       markPropertyroleAsDirty(!equalsObject(propertyrole, p));
       propertyrole = p;
    }

    // propertytypecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertytypecodeDirty()  { return checkFieldDirtiness(PROPERTYTYPECODE_DIRTYGROUP, PROPERTYTYPECODE_DIRTYMASK); }

    public java.lang.String   getPropertytypecode()         { return propertytypecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "propertytypecode")
    public java.lang.String   getPropertytypecodeAsString() { return (propertytypecode == null) ? "" : propertytypecode; }

    // propertytypecode setter methods.
    
    protected void markPropertytypecodeAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYTYPECODE_DIRTYGROUP, PROPERTYTYPECODE_DIRTYMASK, aFlag); }


    public void setPropertytypecode(String  p)
    {
       setPropertytypecode(p, DTOCasingStyle.none);
    }
    
    public void setPropertytypecode(String  p, DTOCasingStyle casingStyle)
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
       markPropertytypecodeAsDirty(!equalsObject(propertytypecode, p));
       propertytypecode = p;
    }

    // propertyname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertynameDirty()  { return checkFieldDirtiness(PROPERTYNAME_DIRTYGROUP, PROPERTYNAME_DIRTYMASK); }

    public java.lang.String   getPropertyname()         { return propertyname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "propertyname")
    public java.lang.String   getPropertynameAsString() { return (propertyname == null) ? "" : propertyname; }

    // propertyname setter methods.
    
    protected void markPropertynameAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYNAME_DIRTYGROUP, PROPERTYNAME_DIRTYMASK, aFlag); }


    public void setPropertyname(String  p)
    {
       setPropertyname(p, DTOCasingStyle.none);
    }
    
    public void setPropertyname(String  p, DTOCasingStyle casingStyle)
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
       markPropertynameAsDirty(!equalsObject(propertyname, p));
       propertyname = p;
    }

    // propertyvalue getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertyvalueDirty()  { return checkFieldDirtiness(PROPERTYVALUE_DIRTYGROUP, PROPERTYVALUE_DIRTYMASK); }

    public java.lang.String   getPropertyvalue()         { return propertyvalue; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "propertyvalue")
    public java.lang.String   getPropertyvalueAsString() { return (propertyvalue == null) ? "" : propertyvalue; }

    // propertyvalue setter methods.
    
    protected void markPropertyvalueAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYVALUE_DIRTYGROUP, PROPERTYVALUE_DIRTYMASK, aFlag); }


    public void setPropertyvalue(String  p)
    {
       setPropertyvalue(p, DTOCasingStyle.none);
    }
    
    public void setPropertyvalue(String  p, DTOCasingStyle casingStyle)
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
       markPropertyvalueAsDirty(!equalsObject(propertyvalue, p));
       propertyvalue = p;
    }

    // propertysize getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertysizeDirty()  { return checkFieldDirtiness(PROPERTYSIZE_DIRTYGROUP, PROPERTYSIZE_DIRTYMASK); }

    public java.lang.Integer   getPropertysize() { return propertysize; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "propertysize")
    public String getPropertysizeAsString() { return integerAsString(propertysize); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getPropertysizeAsInt()    { return propertysize != null ? propertysize.intValue() : 0; }

    // propertysize setter methods.
    
    protected void markPropertysizeAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYSIZE_DIRTYGROUP, PROPERTYSIZE_DIRTYMASK, aFlag); }


    public void setPropertysize(java.lang.Integer  p)
    {
        markPropertysizeAsDirty(!equalsObject(propertysize, p));
    	propertysize = p;
    }
    public void setPropertysize(int p)
    {
    	setPropertysize(new java.lang.Integer(p));
    }
    public void setPropertysize()
    {
    	setPropertysize(0);
    }
    public void setPropertysize(String  p)
    {
    	setPropertysize(stringAsInteger(p));
    }

    // refpropertyid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRefpropertyidDirty()  { return checkFieldDirtiness(REFPROPERTYID_DIRTYGROUP, REFPROPERTYID_DIRTYMASK); }

    public java.lang.String   getRefpropertyid()         { return refpropertyid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "refpropertyid")
    public java.lang.String   getRefpropertyidAsString() { return (refpropertyid == null) ? "" : refpropertyid; }

    // refpropertyid setter methods.
    
    protected void markRefpropertyidAsDirty(boolean aFlag)  { markFieldAsDirty(REFPROPERTYID_DIRTYGROUP, REFPROPERTYID_DIRTYMASK, aFlag); }


    public void setRefpropertyid(String  p)
    {
       setRefpropertyid(p, DTOCasingStyle.none);
    }
    
    public void setRefpropertyid(String  p, DTOCasingStyle casingStyle)
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
       markRefpropertyidAsDirty(!equalsObject(refpropertyid, p));
       refpropertyid = p;
    }

    // contenttype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isContenttypeDirty()  { return checkFieldDirtiness(CONTENTTYPE_DIRTYGROUP, CONTENTTYPE_DIRTYMASK); }

    public java.lang.String   getContenttype()         { return contenttype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "contenttype")
    public java.lang.String   getContenttypeAsString() { return (contenttype == null) ? "" : contenttype; }

    // contenttype setter methods.
    
    protected void markContenttypeAsDirty(boolean aFlag)  { markFieldAsDirty(CONTENTTYPE_DIRTYGROUP, CONTENTTYPE_DIRTYMASK, aFlag); }


    public void setContenttype(String  p)
    {
       setContenttype(p, DTOCasingStyle.none);
    }
    
    public void setContenttype(String  p, DTOCasingStyle casingStyle)
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
       markContenttypeAsDirty(!equalsObject(contenttype, p));
       contenttype = p;
    }

    // imageurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImageurlDirty()  { return checkFieldDirtiness(IMAGEURL_DIRTYGROUP, IMAGEURL_DIRTYMASK); }

    public java.lang.String   getImageurl()         { return imageurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "imageurl")
    public java.lang.String   getImageurlAsString() { return (imageurl == null) ? "" : imageurl; }

    // imageurl setter methods.
    
    protected void markImageurlAsDirty(boolean aFlag)  { markFieldAsDirty(IMAGEURL_DIRTYGROUP, IMAGEURL_DIRTYMASK, aFlag); }


    public void setImageurl(String  p)
    {
       setImageurl(p, DTOCasingStyle.none);
    }
    
    public void setImageurl(String  p, DTOCasingStyle casingStyle)
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
       markImageurlAsDirty(!equalsObject(imageurl, p));
       imageurl = p;
    }

    // imageheight getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImageheightDirty()  { return checkFieldDirtiness(IMAGEHEIGHT_DIRTYGROUP, IMAGEHEIGHT_DIRTYMASK); }

    public java.lang.Integer   getImageheight() { return imageheight; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "imageheight")
    public String getImageheightAsString() { return integerAsString(imageheight); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getImageheightAsInt()    { return imageheight != null ? imageheight.intValue() : 0; }

    // imageheight setter methods.
    
    protected void markImageheightAsDirty(boolean aFlag)  { markFieldAsDirty(IMAGEHEIGHT_DIRTYGROUP, IMAGEHEIGHT_DIRTYMASK, aFlag); }


    public void setImageheight(java.lang.Integer  p)
    {
        markImageheightAsDirty(!equalsObject(imageheight, p));
    	imageheight = p;
    }
    public void setImageheight(int p)
    {
    	setImageheight(new java.lang.Integer(p));
    }
    public void setImageheight()
    {
    	setImageheight(0);
    }
    public void setImageheight(String  p)
    {
    	setImageheight(stringAsInteger(p));
    }

    // imagewidth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImagewidthDirty()  { return checkFieldDirtiness(IMAGEWIDTH_DIRTYGROUP, IMAGEWIDTH_DIRTYMASK); }

    public java.lang.Integer   getImagewidth() { return imagewidth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "imagewidth")
    public String getImagewidthAsString() { return integerAsString(imagewidth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getImagewidthAsInt()    { return imagewidth != null ? imagewidth.intValue() : 0; }

    // imagewidth setter methods.
    
    protected void markImagewidthAsDirty(boolean aFlag)  { markFieldAsDirty(IMAGEWIDTH_DIRTYGROUP, IMAGEWIDTH_DIRTYMASK, aFlag); }


    public void setImagewidth(java.lang.Integer  p)
    {
        markImagewidthAsDirty(!equalsObject(imagewidth, p));
    	imagewidth = p;
    }
    public void setImagewidth(int p)
    {
    	setImagewidth(new java.lang.Integer(p));
    }
    public void setImagewidth()
    {
    	setImagewidth(0);
    }
    public void setImagewidth(String  p)
    {
    	setImagewidth(stringAsInteger(p));
    }

    // iconurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIconurlDirty()  { return checkFieldDirtiness(ICONURL_DIRTYGROUP, ICONURL_DIRTYMASK); }

    public java.lang.String   getIconurl()         { return iconurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "iconurl")
    public java.lang.String   getIconurlAsString() { return (iconurl == null) ? "" : iconurl; }

    // iconurl setter methods.
    
    protected void markIconurlAsDirty(boolean aFlag)  { markFieldAsDirty(ICONURL_DIRTYGROUP, ICONURL_DIRTYMASK, aFlag); }


    public void setIconurl(String  p)
    {
       setIconurl(p, DTOCasingStyle.none);
    }
    
    public void setIconurl(String  p, DTOCasingStyle casingStyle)
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
       markIconurlAsDirty(!equalsObject(iconurl, p));
       iconurl = p;
    }

    // iconheight getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIconheightDirty()  { return checkFieldDirtiness(ICONHEIGHT_DIRTYGROUP, ICONHEIGHT_DIRTYMASK); }

    public java.lang.Integer   getIconheight() { return iconheight; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "iconheight")
    public String getIconheightAsString() { return integerAsString(iconheight); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getIconheightAsInt()    { return iconheight != null ? iconheight.intValue() : 0; }

    // iconheight setter methods.
    
    protected void markIconheightAsDirty(boolean aFlag)  { markFieldAsDirty(ICONHEIGHT_DIRTYGROUP, ICONHEIGHT_DIRTYMASK, aFlag); }


    public void setIconheight(java.lang.Integer  p)
    {
        markIconheightAsDirty(!equalsObject(iconheight, p));
    	iconheight = p;
    }
    public void setIconheight(int p)
    {
    	setIconheight(new java.lang.Integer(p));
    }
    public void setIconheight()
    {
    	setIconheight(0);
    }
    public void setIconheight(String  p)
    {
    	setIconheight(stringAsInteger(p));
    }

    // iconwidth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIconwidthDirty()  { return checkFieldDirtiness(ICONWIDTH_DIRTYGROUP, ICONWIDTH_DIRTYMASK); }

    public java.lang.Integer   getIconwidth() { return iconwidth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "iconwidth")
    public String getIconwidthAsString() { return integerAsString(iconwidth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getIconwidthAsInt()    { return iconwidth != null ? iconwidth.intValue() : 0; }

    // iconwidth setter methods.
    
    protected void markIconwidthAsDirty(boolean aFlag)  { markFieldAsDirty(ICONWIDTH_DIRTYGROUP, ICONWIDTH_DIRTYMASK, aFlag); }


    public void setIconwidth(java.lang.Integer  p)
    {
        markIconwidthAsDirty(!equalsObject(iconwidth, p));
    	iconwidth = p;
    }
    public void setIconwidth(int p)
    {
    	setIconwidth(new java.lang.Integer(p));
    }
    public void setIconwidth()
    {
    	setIconwidth(0);
    }
    public void setIconwidth(String  p)
    {
    	setIconwidth(stringAsInteger(p));
    }

    // proprectimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isProprectimestampDirty()  { return checkFieldDirtiness(PROPRECTIMESTAMP_DIRTYGROUP, PROPRECTIMESTAMP_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getProprectimestamp() { return proprectimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "proprectimestamp")
    public String getProprectimestampAsString() { return timestampAsString(proprectimestamp, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getProprectimestampAsString(java.text.DateFormat aDateFormat) { return timestampAsString(proprectimestamp, aDateFormat); }

    // proprectimestamp setter methods.
    
    protected void markProprectimestampAsDirty(boolean aFlag)  { markFieldAsDirty(PROPRECTIMESTAMP_DIRTYGROUP, PROPRECTIMESTAMP_DIRTYMASK, aFlag); }


    public void setProprectimestamp(java.sql.Timestamp  p)
    {
        markProprectimestampAsDirty(!equalsObject(proprectimestamp, p));
    	proprectimestamp = p;
    }
    public void setProprectimestamp(String  p, java.text.DateFormat aDateFormat)
    {
    	setProprectimestamp(stringAsTimestamp(p, aDateFormat));
    }

}
