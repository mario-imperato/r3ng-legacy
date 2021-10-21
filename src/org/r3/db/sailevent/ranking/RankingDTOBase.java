//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.ranking;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "RankingDTOBase")
public class RankingDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  rankid;
    protected java.lang.String  rankinggroup;
    protected java.lang.String  ranktitle;
    protected java.lang.String  ranktype;
    protected java.lang.String  championship;
    protected java.lang.String  racegroup;
    protected java.lang.String  raceclass;
    protected java.lang.String  rating;
    protected java.lang.String  racefilepattern;
    protected java.lang.String  overallfilepattern;
    protected java.lang.Integer  rankordering;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String RANKID_DEFAULT  =  null;
    public static final java.lang.String RANKINGGROUP_DEFAULT  =  null;
    public static final java.lang.String RANKTITLE_DEFAULT  =  null;
    public static final java.lang.String RANKTYPE_DEFAULT  =  null;
    public static final java.lang.String CHAMPIONSHIP_DEFAULT  =  null;
    public static final java.lang.String RACEGROUP_DEFAULT  =  null;
    public static final java.lang.String RACECLASS_DEFAULT  =  null;
    public static final java.lang.String RATING_DEFAULT  =  null;
    public static final java.lang.String RACEFILEPATTERN_DEFAULT  =  null;
    public static final java.lang.String OVERALLFILEPATTERN_DEFAULT  =  null;
    public static final java.lang.Integer RANKORDERING_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int RANKID_DIRTYGROUP  =  0;
    public static final int RANKID_DIRTYMASK   =  2;
    public static final int RANKINGGROUP_DIRTYGROUP  =  0;
    public static final int RANKINGGROUP_DIRTYMASK   =  4;
    public static final int RANKTITLE_DIRTYGROUP  =  0;
    public static final int RANKTITLE_DIRTYMASK   =  8;
    public static final int RANKTYPE_DIRTYGROUP  =  0;
    public static final int RANKTYPE_DIRTYMASK   =  16;
    public static final int CHAMPIONSHIP_DIRTYGROUP  =  0;
    public static final int CHAMPIONSHIP_DIRTYMASK   =  32;
    public static final int RACEGROUP_DIRTYGROUP  =  0;
    public static final int RACEGROUP_DIRTYMASK   =  64;
    public static final int RACECLASS_DIRTYGROUP  =  0;
    public static final int RACECLASS_DIRTYMASK   =  128;
    public static final int RATING_DIRTYGROUP  =  0;
    public static final int RATING_DIRTYMASK   =  256;
    public static final int RACEFILEPATTERN_DIRTYGROUP  =  0;
    public static final int RACEFILEPATTERN_DIRTYMASK   =  512;
    public static final int OVERALLFILEPATTERN_DIRTYGROUP  =  0;
    public static final int OVERALLFILEPATTERN_DIRTYMASK   =  1024;
    public static final int RANKORDERING_DIRTYGROUP  =  0;
    public static final int RANKORDERING_DIRTYMASK   =  2048;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  4096;


    /**
      * DataBean constructor.
      */
    public RankingDTOBase()
    {
       dirtyFlagsArray = new int[13 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       rankid = RANKID_DEFAULT;
       rankinggroup = RANKINGGROUP_DEFAULT;
       ranktitle = RANKTITLE_DEFAULT;
       ranktype = RANKTYPE_DEFAULT;
       championship = CHAMPIONSHIP_DEFAULT;
       racegroup = RACEGROUP_DEFAULT;
       raceclass = RACECLASS_DEFAULT;
       rating = RATING_DEFAULT;
       racefilepattern = RACEFILEPATTERN_DEFAULT;
       overallfilepattern = OVERALLFILEPATTERN_DEFAULT;
       rankordering = RANKORDERING_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public RankingDTOBase(RankingDTOBase another)
    {

       eventid = another.getEventid();
       rankid = another.getRankid();
       rankinggroup = another.getRankinggroup();
       ranktitle = another.getRanktitle();
       ranktype = another.getRanktype();
       championship = another.getChampionship();
       racegroup = another.getRacegroup();
       raceclass = another.getRaceclass();
       rating = another.getRating();
       racefilepattern = another.getRacefilepattern();
       overallfilepattern = another.getOverallfilepattern();
       rankordering = another.getRankordering();
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
        stb.append(eventid);
        stb.append(", ");
        stb.append(rankid);
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

    // ranktype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRanktypeDirty()  { return checkFieldDirtiness(RANKTYPE_DIRTYGROUP, RANKTYPE_DIRTYMASK); }

    public java.lang.String   getRanktype()         { return ranktype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "ranktype")
    public java.lang.String   getRanktypeAsString() { return (ranktype == null) ? "" : ranktype; }

    // ranktype setter methods.
    
    protected void markRanktypeAsDirty(boolean aFlag)  { markFieldAsDirty(RANKTYPE_DIRTYGROUP, RANKTYPE_DIRTYMASK, aFlag); }


    public void setRanktype(String  p)
    {
       setRanktype(p, DTOCasingStyle.none);
    }
    
    public void setRanktype(String  p, DTOCasingStyle casingStyle)
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
       markRanktypeAsDirty(!equalsObject(ranktype, p));
       ranktype = p;
    }

    // championship getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isChampionshipDirty()  { return checkFieldDirtiness(CHAMPIONSHIP_DIRTYGROUP, CHAMPIONSHIP_DIRTYMASK); }

    public java.lang.String   getChampionship()         { return championship; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "championship")
    public java.lang.String   getChampionshipAsString() { return (championship == null) ? "" : championship; }

    // championship setter methods.
    
    protected void markChampionshipAsDirty(boolean aFlag)  { markFieldAsDirty(CHAMPIONSHIP_DIRTYGROUP, CHAMPIONSHIP_DIRTYMASK, aFlag); }


    public void setChampionship(String  p)
    {
       setChampionship(p, DTOCasingStyle.none);
    }
    
    public void setChampionship(String  p, DTOCasingStyle casingStyle)
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
       markChampionshipAsDirty(!equalsObject(championship, p));
       championship = p;
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

    // rating getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRatingDirty()  { return checkFieldDirtiness(RATING_DIRTYGROUP, RATING_DIRTYMASK); }

    public java.lang.String   getRating()         { return rating; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "rating")
    public java.lang.String   getRatingAsString() { return (rating == null) ? "" : rating; }

    // rating setter methods.
    
    protected void markRatingAsDirty(boolean aFlag)  { markFieldAsDirty(RATING_DIRTYGROUP, RATING_DIRTYMASK, aFlag); }


    public void setRating(String  p)
    {
       setRating(p, DTOCasingStyle.none);
    }
    
    public void setRating(String  p, DTOCasingStyle casingStyle)
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
       markRatingAsDirty(!equalsObject(rating, p));
       rating = p;
    }

    // racefilepattern getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacefilepatternDirty()  { return checkFieldDirtiness(RACEFILEPATTERN_DIRTYGROUP, RACEFILEPATTERN_DIRTYMASK); }

    public java.lang.String   getRacefilepattern()         { return racefilepattern; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racefilepattern")
    public java.lang.String   getRacefilepatternAsString() { return (racefilepattern == null) ? "" : racefilepattern; }

    // racefilepattern setter methods.
    
    protected void markRacefilepatternAsDirty(boolean aFlag)  { markFieldAsDirty(RACEFILEPATTERN_DIRTYGROUP, RACEFILEPATTERN_DIRTYMASK, aFlag); }


    public void setRacefilepattern(String  p)
    {
       setRacefilepattern(p, DTOCasingStyle.none);
    }
    
    public void setRacefilepattern(String  p, DTOCasingStyle casingStyle)
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
       markRacefilepatternAsDirty(!equalsObject(racefilepattern, p));
       racefilepattern = p;
    }

    // overallfilepattern getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOverallfilepatternDirty()  { return checkFieldDirtiness(OVERALLFILEPATTERN_DIRTYGROUP, OVERALLFILEPATTERN_DIRTYMASK); }

    public java.lang.String   getOverallfilepattern()         { return overallfilepattern; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "overallfilepattern")
    public java.lang.String   getOverallfilepatternAsString() { return (overallfilepattern == null) ? "" : overallfilepattern; }

    // overallfilepattern setter methods.
    
    protected void markOverallfilepatternAsDirty(boolean aFlag)  { markFieldAsDirty(OVERALLFILEPATTERN_DIRTYGROUP, OVERALLFILEPATTERN_DIRTYMASK, aFlag); }


    public void setOverallfilepattern(String  p)
    {
       setOverallfilepattern(p, DTOCasingStyle.none);
    }
    
    public void setOverallfilepattern(String  p, DTOCasingStyle casingStyle)
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
       markOverallfilepatternAsDirty(!equalsObject(overallfilepattern, p));
       overallfilepattern = p;
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
