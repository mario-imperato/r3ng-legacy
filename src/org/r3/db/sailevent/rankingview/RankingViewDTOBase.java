//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankingview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "RankingViewDTOBase")
public class RankingViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  rankid;
    protected java.lang.String  rankinggroup;
    protected java.lang.String  ranktitle;
    protected java.lang.String  racegroup;
    protected java.lang.String  raceclass;
    protected java.lang.Integer  rankordering;
    protected java.lang.String  instanceid;
    protected java.lang.String  instancetype;
    protected java.lang.Integer  racenumber;
    protected java.lang.String  racefiledmsurl;
    protected java.sql.Date  racedate;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String RANKID_DEFAULT  =  null;
    public static final java.lang.String RANKINGGROUP_DEFAULT  =  null;
    public static final java.lang.String RANKTITLE_DEFAULT  =  null;
    public static final java.lang.String RACEGROUP_DEFAULT  =  null;
    public static final java.lang.String RACECLASS_DEFAULT  =  null;
    public static final java.lang.Integer RANKORDERING_DEFAULT  =  null;
    public static final java.lang.String INSTANCEID_DEFAULT  =  null;
    public static final java.lang.String INSTANCETYPE_DEFAULT  =  null;
    public static final java.lang.Integer RACENUMBER_DEFAULT  =  null;
    public static final java.lang.String RACEFILEDMSURL_DEFAULT  =  null;
    public static final java.sql.Date RACEDATE_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int RANKID_DIRTYGROUP  =  0;
    public static final int RANKID_DIRTYMASK   =  2;
    public static final int RANKINGGROUP_DIRTYGROUP  =  0;
    public static final int RANKINGGROUP_DIRTYMASK   =  4;
    public static final int RANKTITLE_DIRTYGROUP  =  0;
    public static final int RANKTITLE_DIRTYMASK   =  8;
    public static final int RACEGROUP_DIRTYGROUP  =  0;
    public static final int RACEGROUP_DIRTYMASK   =  16;
    public static final int RACECLASS_DIRTYGROUP  =  0;
    public static final int RACECLASS_DIRTYMASK   =  32;
    public static final int RANKORDERING_DIRTYGROUP  =  0;
    public static final int RANKORDERING_DIRTYMASK   =  64;
    public static final int INSTANCEID_DIRTYGROUP  =  0;
    public static final int INSTANCEID_DIRTYMASK   =  128;
    public static final int INSTANCETYPE_DIRTYGROUP  =  0;
    public static final int INSTANCETYPE_DIRTYMASK   =  256;
    public static final int RACENUMBER_DIRTYGROUP  =  0;
    public static final int RACENUMBER_DIRTYMASK   =  512;
    public static final int RACEFILEDMSURL_DIRTYGROUP  =  0;
    public static final int RACEFILEDMSURL_DIRTYMASK   =  1024;
    public static final int RACEDATE_DIRTYGROUP  =  0;
    public static final int RACEDATE_DIRTYMASK   =  2048;


    /**
      * DataBean constructor.
      */
    public RankingViewDTOBase()
    {
       dirtyFlagsArray = new int[12 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       rankid = RANKID_DEFAULT;
       rankinggroup = RANKINGGROUP_DEFAULT;
       ranktitle = RANKTITLE_DEFAULT;
       racegroup = RACEGROUP_DEFAULT;
       raceclass = RACECLASS_DEFAULT;
       rankordering = RANKORDERING_DEFAULT;
       instanceid = INSTANCEID_DEFAULT;
       instancetype = INSTANCETYPE_DEFAULT;
       racenumber = RACENUMBER_DEFAULT;
       racefiledmsurl = RACEFILEDMSURL_DEFAULT;
       racedate = RACEDATE_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public RankingViewDTOBase(RankingViewDTOBase another)
    {

       eventid = another.getEventid();
       rankid = another.getRankid();
       rankinggroup = another.getRankinggroup();
       ranktitle = another.getRanktitle();
       racegroup = another.getRacegroup();
       raceclass = another.getRaceclass();
       rankordering = another.getRankordering();
       instanceid = another.getInstanceid();
       instancetype = another.getInstancetype();
       racenumber = another.getRacenumber();
       racefiledmsurl = another.getRacefiledmsurl();
       racedate = another.getRacedate();

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
        stb.append(instanceid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (ranktitle != null)
        {
        stb.append(ranktitle);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // eventid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventidDirty()  { return checkFieldDirtiness(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK); }

    public java.lang.String   getEventid()         { return eventid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "eventid")
    public java.lang.String   getEventidAsString() { return (eventid == null) ? "" : eventid; }

    // eventid setter methods.
    
    protected void markEventidAsDirty(boolean aFlag)  { markFieldAsDirty(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK, aFlag); }


    public void setEventid(String  p)
    {
       setEventid(p, DTOCasingStyle.none);
    }
    
    public void setEventid(String  p, DTOCasingStyle casingStyle)
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
       markEventidAsDirty(!equalsObject(eventid, p));
       eventid = p;
    }

    // rankid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRankidDirty()  { return checkFieldDirtiness(RANKID_DIRTYGROUP, RANKID_DIRTYMASK); }

    public java.lang.String   getRankid()         { return rankid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "rankid")
    public java.lang.String   getRankidAsString() { return (rankid == null) ? "" : rankid; }

    // rankid setter methods.
    
    protected void markRankidAsDirty(boolean aFlag)  { markFieldAsDirty(RANKID_DIRTYGROUP, RANKID_DIRTYMASK, aFlag); }


    public void setRankid(String  p)
    {
       setRankid(p, DTOCasingStyle.none);
    }
    
    public void setRankid(String  p, DTOCasingStyle casingStyle)
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
       markRankidAsDirty(!equalsObject(rankid, p));
       rankid = p;
    }

    // rankinggroup getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRankinggroupDirty()  { return checkFieldDirtiness(RANKINGGROUP_DIRTYGROUP, RANKINGGROUP_DIRTYMASK); }

    public java.lang.String   getRankinggroup()         { return rankinggroup; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "rankinggroup")
    public java.lang.String   getRankinggroupAsString() { return (rankinggroup == null) ? "" : rankinggroup; }

    // rankinggroup setter methods.
    
    protected void markRankinggroupAsDirty(boolean aFlag)  { markFieldAsDirty(RANKINGGROUP_DIRTYGROUP, RANKINGGROUP_DIRTYMASK, aFlag); }


    public void setRankinggroup(String  p)
    {
       setRankinggroup(p, DTOCasingStyle.none);
    }
    
    public void setRankinggroup(String  p, DTOCasingStyle casingStyle)
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
       markRankinggroupAsDirty(!equalsObject(rankinggroup, p));
       rankinggroup = p;
    }

    // ranktitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRanktitleDirty()  { return checkFieldDirtiness(RANKTITLE_DIRTYGROUP, RANKTITLE_DIRTYMASK); }

    public java.lang.String   getRanktitle()         { return ranktitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "ranktitle")
    public java.lang.String   getRanktitleAsString() { return (ranktitle == null) ? "" : ranktitle; }

    // ranktitle setter methods.
    
    protected void markRanktitleAsDirty(boolean aFlag)  { markFieldAsDirty(RANKTITLE_DIRTYGROUP, RANKTITLE_DIRTYMASK, aFlag); }


    public void setRanktitle(String  p)
    {
       setRanktitle(p, DTOCasingStyle.none);
    }
    
    public void setRanktitle(String  p, DTOCasingStyle casingStyle)
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
       markRanktitleAsDirty(!equalsObject(ranktitle, p));
       ranktitle = p;
    }

    // racegroup getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacegroupDirty()  { return checkFieldDirtiness(RACEGROUP_DIRTYGROUP, RACEGROUP_DIRTYMASK); }

    public java.lang.String   getRacegroup()         { return racegroup; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racegroup")
    public java.lang.String   getRacegroupAsString() { return (racegroup == null) ? "" : racegroup; }

    // racegroup setter methods.
    
    protected void markRacegroupAsDirty(boolean aFlag)  { markFieldAsDirty(RACEGROUP_DIRTYGROUP, RACEGROUP_DIRTYMASK, aFlag); }


    public void setRacegroup(String  p)
    {
       setRacegroup(p, DTOCasingStyle.none);
    }
    
    public void setRacegroup(String  p, DTOCasingStyle casingStyle)
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
       markRacegroupAsDirty(!equalsObject(racegroup, p));
       racegroup = p;
    }

    // raceclass getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRaceclassDirty()  { return checkFieldDirtiness(RACECLASS_DIRTYGROUP, RACECLASS_DIRTYMASK); }

    public java.lang.String   getRaceclass()         { return raceclass; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "raceclass")
    public java.lang.String   getRaceclassAsString() { return (raceclass == null) ? "" : raceclass; }

    // raceclass setter methods.
    
    protected void markRaceclassAsDirty(boolean aFlag)  { markFieldAsDirty(RACECLASS_DIRTYGROUP, RACECLASS_DIRTYMASK, aFlag); }


    public void setRaceclass(String  p)
    {
       setRaceclass(p, DTOCasingStyle.none);
    }
    
    public void setRaceclass(String  p, DTOCasingStyle casingStyle)
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
       markRaceclassAsDirty(!equalsObject(raceclass, p));
       raceclass = p;
    }

    // rankordering getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRankorderingDirty()  { return checkFieldDirtiness(RANKORDERING_DIRTYGROUP, RANKORDERING_DIRTYMASK); }

    public java.lang.Integer   getRankordering() { return rankordering; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "rankordering")
    public String getRankorderingAsString() { return integerAsString(rankordering); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getRankorderingAsInt()    { return rankordering != null ? rankordering.intValue() : 0; }

    // rankordering setter methods.
    
    protected void markRankorderingAsDirty(boolean aFlag)  { markFieldAsDirty(RANKORDERING_DIRTYGROUP, RANKORDERING_DIRTYMASK, aFlag); }


    public void setRankordering(java.lang.Integer  p)
    {
        markRankorderingAsDirty(!equalsObject(rankordering, p));
    	rankordering = p;
    }
    public void setRankordering(int p)
    {
    	setRankordering(new java.lang.Integer(p));
    }
    public void setRankordering()
    {
    	setRankordering(0);
    }
    public void setRankordering(String  p)
    {
    	setRankordering(stringAsInteger(p));
    }

    // instanceid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isInstanceidDirty()  { return checkFieldDirtiness(INSTANCEID_DIRTYGROUP, INSTANCEID_DIRTYMASK); }

    public java.lang.String   getInstanceid()         { return instanceid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "instanceid")
    public java.lang.String   getInstanceidAsString() { return (instanceid == null) ? "" : instanceid; }

    // instanceid setter methods.
    
    protected void markInstanceidAsDirty(boolean aFlag)  { markFieldAsDirty(INSTANCEID_DIRTYGROUP, INSTANCEID_DIRTYMASK, aFlag); }


    public void setInstanceid(String  p)
    {
       setInstanceid(p, DTOCasingStyle.none);
    }
    
    public void setInstanceid(String  p, DTOCasingStyle casingStyle)
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
       markInstanceidAsDirty(!equalsObject(instanceid, p));
       instanceid = p;
    }

    // instancetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isInstancetypeDirty()  { return checkFieldDirtiness(INSTANCETYPE_DIRTYGROUP, INSTANCETYPE_DIRTYMASK); }

    public java.lang.String   getInstancetype()         { return instancetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "instancetype")
    public java.lang.String   getInstancetypeAsString() { return (instancetype == null) ? "" : instancetype; }

    // instancetype setter methods.
    
    protected void markInstancetypeAsDirty(boolean aFlag)  { markFieldAsDirty(INSTANCETYPE_DIRTYGROUP, INSTANCETYPE_DIRTYMASK, aFlag); }


    public void setInstancetype(String  p)
    {
       setInstancetype(p, DTOCasingStyle.none);
    }
    
    public void setInstancetype(String  p, DTOCasingStyle casingStyle)
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
       markInstancetypeAsDirty(!equalsObject(instancetype, p));
       instancetype = p;
    }

    // racenumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacenumberDirty()  { return checkFieldDirtiness(RACENUMBER_DIRTYGROUP, RACENUMBER_DIRTYMASK); }

    public java.lang.Integer   getRacenumber() { return racenumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racenumber")
    public String getRacenumberAsString() { return integerAsString(racenumber); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getRacenumberAsInt()    { return racenumber != null ? racenumber.intValue() : 0; }

    // racenumber setter methods.
    
    protected void markRacenumberAsDirty(boolean aFlag)  { markFieldAsDirty(RACENUMBER_DIRTYGROUP, RACENUMBER_DIRTYMASK, aFlag); }


    public void setRacenumber(java.lang.Integer  p)
    {
        markRacenumberAsDirty(!equalsObject(racenumber, p));
    	racenumber = p;
    }
    public void setRacenumber(int p)
    {
    	setRacenumber(new java.lang.Integer(p));
    }
    public void setRacenumber()
    {
    	setRacenumber(0);
    }
    public void setRacenumber(String  p)
    {
    	setRacenumber(stringAsInteger(p));
    }

    // racefiledmsurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacefiledmsurlDirty()  { return checkFieldDirtiness(RACEFILEDMSURL_DIRTYGROUP, RACEFILEDMSURL_DIRTYMASK); }

    public java.lang.String   getRacefiledmsurl()         { return racefiledmsurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racefiledmsurl")
    public java.lang.String   getRacefiledmsurlAsString() { return (racefiledmsurl == null) ? "" : racefiledmsurl; }

    // racefiledmsurl setter methods.
    
    protected void markRacefiledmsurlAsDirty(boolean aFlag)  { markFieldAsDirty(RACEFILEDMSURL_DIRTYGROUP, RACEFILEDMSURL_DIRTYMASK, aFlag); }


    public void setRacefiledmsurl(String  p)
    {
       setRacefiledmsurl(p, DTOCasingStyle.none);
    }
    
    public void setRacefiledmsurl(String  p, DTOCasingStyle casingStyle)
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
       markRacefiledmsurlAsDirty(!equalsObject(racefiledmsurl, p));
       racefiledmsurl = p;
    }

    // racedate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacedateDirty()  { return checkFieldDirtiness(RACEDATE_DIRTYGROUP, RACEDATE_DIRTYMASK); }

    public java.sql.Date   getRacedate() { return racedate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racedate")
    public String getRacedateAsString() { return dateAsString(racedate, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getRacedateAsString(java.text.DateFormat aDateFormat) { return dateAsString(racedate, aDateFormat); }

    // racedate setter methods.
    
    protected void markRacedateAsDirty(boolean aFlag)  { markFieldAsDirty(RACEDATE_DIRTYGROUP, RACEDATE_DIRTYMASK, aFlag); }


    public void setRacedate(java.sql.Date  p)
    {
         markRacedateAsDirty(!equalsObject(racedate, p));
    	 racedate = p;
    }
    public void setRacedate(String p, java.text.DateFormat aDateFormat)
    {
    	setRacedate(stringAsDate(p, aDateFormat));
    }

}
