//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbstopicview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "BBSTopicViewDTOBase")
public class BBSTopicViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  topicid;
    protected java.lang.String  topictitle;
    protected java.lang.String  cardid;
    protected java.lang.String  moderatorid;
    protected java.lang.String  moderatormode;
    protected java.lang.String  options;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;
    protected java.lang.Long  numthreads;
    protected java.math.BigDecimal  numposts;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String TOPICID_DEFAULT  =  null;
    public static final java.lang.String TOPICTITLE_DEFAULT  =  null;
    public static final java.lang.String CARDID_DEFAULT  =  null;
    public static final java.lang.String MODERATORID_DEFAULT  =  null;
    public static final java.lang.String MODERATORMODE_DEFAULT  =  null;
    public static final java.lang.String OPTIONS_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;
    public static final java.lang.Long NUMTHREADS_DEFAULT  =  null;
    public static final java.math.BigDecimal NUMPOSTS_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int TOPICID_DIRTYGROUP  =  0;
    public static final int TOPICID_DIRTYMASK   =  2;
    public static final int TOPICTITLE_DIRTYGROUP  =  0;
    public static final int TOPICTITLE_DIRTYMASK   =  4;
    public static final int CARDID_DIRTYGROUP  =  0;
    public static final int CARDID_DIRTYMASK   =  8;
    public static final int MODERATORID_DIRTYGROUP  =  0;
    public static final int MODERATORID_DIRTYMASK   =  16;
    public static final int MODERATORMODE_DIRTYGROUP  =  0;
    public static final int MODERATORMODE_DIRTYMASK   =  32;
    public static final int OPTIONS_DIRTYGROUP  =  0;
    public static final int OPTIONS_DIRTYMASK   =  64;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  128;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  256;
    public static final int NUMTHREADS_DIRTYGROUP  =  0;
    public static final int NUMTHREADS_DIRTYMASK   =  512;
    public static final int NUMPOSTS_DIRTYGROUP  =  0;
    public static final int NUMPOSTS_DIRTYMASK   =  1024;


    /**
      * DataBean constructor.
      */
    public BBSTopicViewDTOBase()
    {
       dirtyFlagsArray = new int[11 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       topicid = TOPICID_DEFAULT;
       topictitle = TOPICTITLE_DEFAULT;
       cardid = CARDID_DEFAULT;
       moderatorid = MODERATORID_DEFAULT;
       moderatormode = MODERATORMODE_DEFAULT;
       options = OPTIONS_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
       numthreads = NUMTHREADS_DEFAULT;
       numposts = NUMPOSTS_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public BBSTopicViewDTOBase(BBSTopicViewDTOBase another)
    {

       site = another.getSite();
       topicid = another.getTopicid();
       topictitle = another.getTopictitle();
       cardid = another.getCardid();
       moderatorid = another.getModeratorid();
       moderatormode = another.getModeratormode();
       options = another.getOptions();
       recstatus = another.getRecstatus();
       rectimestamp = another.getRectimestamp();
       numthreads = another.getNumthreads();
       numposts = another.getNumposts();

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

    // topicid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTopicidDirty()  { return checkFieldDirtiness(TOPICID_DIRTYGROUP, TOPICID_DIRTYMASK); }

    public java.lang.String   getTopicid()         { return topicid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "topicid")
    public java.lang.String   getTopicidAsString() { return (topicid == null) ? "" : topicid; }

    // topicid setter methods.
    
    protected void markTopicidAsDirty(boolean aFlag)  { markFieldAsDirty(TOPICID_DIRTYGROUP, TOPICID_DIRTYMASK, aFlag); }


    public void setTopicid(String  p)
    {
       setTopicid(p, DTOCasingStyle.none);
    }
    
    public void setTopicid(String  p, DTOCasingStyle casingStyle)
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
       markTopicidAsDirty(!equalsObject(topicid, p));
       topicid = p;
    }

    // topictitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTopictitleDirty()  { return checkFieldDirtiness(TOPICTITLE_DIRTYGROUP, TOPICTITLE_DIRTYMASK); }

    public java.lang.String   getTopictitle()         { return topictitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "topictitle")
    public java.lang.String   getTopictitleAsString() { return (topictitle == null) ? "" : topictitle; }

    // topictitle setter methods.
    
    protected void markTopictitleAsDirty(boolean aFlag)  { markFieldAsDirty(TOPICTITLE_DIRTYGROUP, TOPICTITLE_DIRTYMASK, aFlag); }


    public void setTopictitle(String  p)
    {
       setTopictitle(p, DTOCasingStyle.none);
    }
    
    public void setTopictitle(String  p, DTOCasingStyle casingStyle)
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
       markTopictitleAsDirty(!equalsObject(topictitle, p));
       topictitle = p;
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

    // moderatorid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isModeratoridDirty()  { return checkFieldDirtiness(MODERATORID_DIRTYGROUP, MODERATORID_DIRTYMASK); }

    public java.lang.String   getModeratorid()         { return moderatorid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "moderatorid")
    public java.lang.String   getModeratoridAsString() { return (moderatorid == null) ? "" : moderatorid; }

    // moderatorid setter methods.
    
    protected void markModeratoridAsDirty(boolean aFlag)  { markFieldAsDirty(MODERATORID_DIRTYGROUP, MODERATORID_DIRTYMASK, aFlag); }


    public void setModeratorid(String  p)
    {
       setModeratorid(p, DTOCasingStyle.none);
    }
    
    public void setModeratorid(String  p, DTOCasingStyle casingStyle)
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
       markModeratoridAsDirty(!equalsObject(moderatorid, p));
       moderatorid = p;
    }

    // moderatormode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isModeratormodeDirty()  { return checkFieldDirtiness(MODERATORMODE_DIRTYGROUP, MODERATORMODE_DIRTYMASK); }

    public java.lang.String   getModeratormode()         { return moderatormode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "moderatormode")
    public java.lang.String   getModeratormodeAsString() { return (moderatormode == null) ? "" : moderatormode; }

    // moderatormode setter methods.
    
    protected void markModeratormodeAsDirty(boolean aFlag)  { markFieldAsDirty(MODERATORMODE_DIRTYGROUP, MODERATORMODE_DIRTYMASK, aFlag); }


    public void setModeratormode(String  p)
    {
       setModeratormode(p, DTOCasingStyle.none);
    }
    
    public void setModeratormode(String  p, DTOCasingStyle casingStyle)
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
       markModeratormodeAsDirty(!equalsObject(moderatormode, p));
       moderatormode = p;
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

    // numthreads getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumthreadsDirty()  { return checkFieldDirtiness(NUMTHREADS_DIRTYGROUP, NUMTHREADS_DIRTYMASK); }

    public java.lang.Long   getNumthreads() { return numthreads; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numthreads")
    public String getNumthreadsAsString() { return longAsString(numthreads); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public long   getNumthreadsAsLong()    { return numthreads != null ? numthreads.longValue() : 0L; }

    // numthreads setter methods.
    
    protected void markNumthreadsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMTHREADS_DIRTYGROUP, NUMTHREADS_DIRTYMASK, aFlag); }


    public void setNumthreads(java.lang.Long  p)
    {
    	markNumthreadsAsDirty(!equalsObject(numthreads, p));
    	numthreads = p;
    }
    public void setNumthreads(long p)
    {
    	setNumthreads(new java.lang.Long(p));
    }
    public void setNumthreads()
    {
    	setNumthreads(0L);
    }
    public void setNumthreads(String  p)
    {
    	setNumthreads(stringAsLong(p));
    }

    // numposts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumpostsDirty()  { return checkFieldDirtiness(NUMPOSTS_DIRTYGROUP, NUMPOSTS_DIRTYMASK); }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public double getNumpostsAsDouble()   {
        return (numposts != null) ? numposts.doubleValue() : 0;
    }

    public java.math.BigDecimal getNumposts() { return numposts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getNumpostsAsString(java.text.NumberFormat    aNumberFormat)    { return currencyAsString(numposts, aNumberFormat); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numposts")
    public String               getNumpostsAsString()            { return decimalAsString(numposts);  }

    // numposts setter methods.
    
    protected void markNumpostsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMPOSTS_DIRTYGROUP, NUMPOSTS_DIRTYMASK, aFlag); }


    public void setNumposts(java.math.BigDecimal  p) {
           p = (p != null) ? p.setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN) : null;
           markNumpostsAsDirty(!equalsBigDecimal(numposts, p));
           numposts = p;
    }
    public void setNumposts(double  p) {
       	   setNumposts(new java.math.BigDecimal(p).setScale(0, java.math.BigDecimal.ROUND_HALF_DOWN));
    }
    public void setNumposts(String  p) {
           setNumposts(stringAsBigDecimal(p, 0));
    }

}
