//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pagedescr;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "PageDescrDTOBase")
public class PageDescrDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  pageid;
    protected java.lang.String  languagecode;
    protected java.lang.String  pagetitle;
    protected java.lang.String  summary;
    protected java.lang.String  textbody;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String PAGEID_DEFAULT  =  null;
    public static final java.lang.String LANGUAGECODE_DEFAULT  =  null;
    public static final java.lang.String PAGETITLE_DEFAULT  =  null;
    public static final java.lang.String SUMMARY_DEFAULT  =  null;
    public static final java.lang.String TEXTBODY_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int PAGEID_DIRTYGROUP  =  0;
    public static final int PAGEID_DIRTYMASK   =  2;
    public static final int LANGUAGECODE_DIRTYGROUP  =  0;
    public static final int LANGUAGECODE_DIRTYMASK   =  4;
    public static final int PAGETITLE_DIRTYGROUP  =  0;
    public static final int PAGETITLE_DIRTYMASK   =  8;
    public static final int SUMMARY_DIRTYGROUP  =  0;
    public static final int SUMMARY_DIRTYMASK   =  16;
    public static final int TEXTBODY_DIRTYGROUP  =  0;
    public static final int TEXTBODY_DIRTYMASK   =  32;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  64;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public PageDescrDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       pageid = PAGEID_DEFAULT;
       languagecode = LANGUAGECODE_DEFAULT;
       pagetitle = PAGETITLE_DEFAULT;
       summary = SUMMARY_DEFAULT;
       textbody = TEXTBODY_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public PageDescrDTOBase(PageDescrDTOBase another)
    {

       site = another.getSite();
       pageid = another.getPageid();
       languagecode = another.getLanguagecode();
       pagetitle = another.getPagetitle();
       summary = another.getSummary();
       textbody = another.getTextbody();
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
        stb.append(pageid);
        stb.append(", ");
        stb.append(languagecode);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (pagetitle != null)
        {
        stb.append(pagetitle);
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

    // pagetitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPagetitleDirty()  { return checkFieldDirtiness(PAGETITLE_DIRTYGROUP, PAGETITLE_DIRTYMASK); }

    public java.lang.String   getPagetitle()         { return pagetitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pagetitle")
    public java.lang.String   getPagetitleAsString() { return (pagetitle == null) ? "" : pagetitle; }

    // pagetitle setter methods.
    
    protected void markPagetitleAsDirty(boolean aFlag)  { markFieldAsDirty(PAGETITLE_DIRTYGROUP, PAGETITLE_DIRTYMASK, aFlag); }


    public void setPagetitle(String  p)
    {
       setPagetitle(p, DTOCasingStyle.none);
    }
    
    public void setPagetitle(String  p, DTOCasingStyle casingStyle)
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
       markPagetitleAsDirty(!equalsObject(pagetitle, p));
       pagetitle = p;
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
