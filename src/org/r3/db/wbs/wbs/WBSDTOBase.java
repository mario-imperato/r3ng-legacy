//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbs;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "WBSDTOBase")
public class WBSDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  wbsid;
    protected java.lang.String  wbstitle;
    protected java.lang.String  wbstext;
    protected java.lang.String  bbstopicid;
    protected java.lang.String  options;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String WBSID_DEFAULT  =  null;
    public static final java.lang.String WBSTITLE_DEFAULT  =  null;
    public static final java.lang.String WBSTEXT_DEFAULT  =  null;
    public static final java.lang.String BBSTOPICID_DEFAULT  =  null;
    public static final java.lang.String OPTIONS_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int WBSID_DIRTYGROUP  =  0;
    public static final int WBSID_DIRTYMASK   =  2;
    public static final int WBSTITLE_DIRTYGROUP  =  0;
    public static final int WBSTITLE_DIRTYMASK   =  4;
    public static final int WBSTEXT_DIRTYGROUP  =  0;
    public static final int WBSTEXT_DIRTYMASK   =  8;
    public static final int BBSTOPICID_DIRTYGROUP  =  0;
    public static final int BBSTOPICID_DIRTYMASK   =  16;
    public static final int OPTIONS_DIRTYGROUP  =  0;
    public static final int OPTIONS_DIRTYMASK   =  32;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  64;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public WBSDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       wbsid = WBSID_DEFAULT;
       wbstitle = WBSTITLE_DEFAULT;
       wbstext = WBSTEXT_DEFAULT;
       bbstopicid = BBSTOPICID_DEFAULT;
       options = OPTIONS_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public WBSDTOBase(WBSDTOBase another)
    {

       site = another.getSite();
       wbsid = another.getWbsid();
       wbstitle = another.getWbstitle();
       wbstext = another.getWbstext();
       bbstopicid = another.getBbstopicid();
       options = another.getOptions();
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
        stb.append(wbsid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (wbstitle != null)
        {
        stb.append(wbstitle);
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

    // wbsid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWbsidDirty()  { return checkFieldDirtiness(WBSID_DIRTYGROUP, WBSID_DIRTYMASK); }

    public java.lang.String   getWbsid()         { return wbsid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "wbsid")
    public java.lang.String   getWbsidAsString() { return (wbsid == null) ? "" : wbsid; }

    // wbsid setter methods.
    
    protected void markWbsidAsDirty(boolean aFlag)  { markFieldAsDirty(WBSID_DIRTYGROUP, WBSID_DIRTYMASK, aFlag); }


    public void setWbsid(String  p)
    {
       setWbsid(p, DTOCasingStyle.none);
    }
    
    public void setWbsid(String  p, DTOCasingStyle casingStyle)
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
       markWbsidAsDirty(!equalsObject(wbsid, p));
       wbsid = p;
    }

    // wbstitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWbstitleDirty()  { return checkFieldDirtiness(WBSTITLE_DIRTYGROUP, WBSTITLE_DIRTYMASK); }

    public java.lang.String   getWbstitle()         { return wbstitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "wbstitle")
    public java.lang.String   getWbstitleAsString() { return (wbstitle == null) ? "" : wbstitle; }

    // wbstitle setter methods.
    
    protected void markWbstitleAsDirty(boolean aFlag)  { markFieldAsDirty(WBSTITLE_DIRTYGROUP, WBSTITLE_DIRTYMASK, aFlag); }


    public void setWbstitle(String  p)
    {
       setWbstitle(p, DTOCasingStyle.none);
    }
    
    public void setWbstitle(String  p, DTOCasingStyle casingStyle)
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
       markWbstitleAsDirty(!equalsObject(wbstitle, p));
       wbstitle = p;
    }

    // wbstext getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWbstextDirty()  { return checkFieldDirtiness(WBSTEXT_DIRTYGROUP, WBSTEXT_DIRTYMASK); }

    public java.lang.String   getWbstext()         { return wbstext; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "wbstext")
    public java.lang.String   getWbstextAsString() { return (wbstext == null) ? "" : wbstext; }

    // wbstext setter methods.
    
    protected void markWbstextAsDirty(boolean aFlag)  { markFieldAsDirty(WBSTEXT_DIRTYGROUP, WBSTEXT_DIRTYMASK, aFlag); }


    public void setWbstext(String  p)
    {
       setWbstext(p, DTOCasingStyle.none);
    }
    
    public void setWbstext(String  p, DTOCasingStyle casingStyle)
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
       markWbstextAsDirty(!equalsObject(wbstext, p));
       wbstext = p;
    }

    // bbstopicid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBbstopicidDirty()  { return checkFieldDirtiness(BBSTOPICID_DIRTYGROUP, BBSTOPICID_DIRTYMASK); }

    public java.lang.String   getBbstopicid()         { return bbstopicid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "bbstopicid")
    public java.lang.String   getBbstopicidAsString() { return (bbstopicid == null) ? "" : bbstopicid; }

    // bbstopicid setter methods.
    
    protected void markBbstopicidAsDirty(boolean aFlag)  { markFieldAsDirty(BBSTOPICID_DIRTYGROUP, BBSTOPICID_DIRTYMASK, aFlag); }


    public void setBbstopicid(String  p)
    {
       setBbstopicid(p, DTOCasingStyle.none);
    }
    
    public void setBbstopicid(String  p, DTOCasingStyle casingStyle)
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
       markBbstopicidAsDirty(!equalsObject(bbstopicid, p));
       bbstopicid = p;
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
