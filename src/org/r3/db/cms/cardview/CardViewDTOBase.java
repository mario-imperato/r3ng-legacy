//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.cardview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "CardViewDTOBase")
public class CardViewDTOBase extends org.r3.db.DTOBase
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


    /**
      * DataBean constructor.
      */
    public CardViewDTOBase()
    {
       dirtyFlagsArray = new int[13 / 30 + 1];
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
    }

    /**
      * Copy constructor.
      */
    public CardViewDTOBase(CardViewDTOBase another)
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
        stb.append(", ");
        stb.append(languagecode);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (title != null)
        {
        stb.append(title);
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

}
