//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstance;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "RankingInstanceDTOBase")
public class RankingInstanceDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  instanceid;
    protected java.lang.String  rankid;
    protected java.lang.String  instancetype;
    protected java.lang.Integer  racenumber;
    protected java.sql.Date  racedate;
    protected java.lang.String  racetime;
    protected java.math.BigDecimal  racedistance;
    protected java.lang.String  racecoefficient;
    protected java.lang.String  racerating;
    protected java.lang.Integer  minrealtime;
    protected java.lang.String  softwareversion;
    protected java.lang.String  softwarecode;
    protected java.lang.String  racefiledmsurl;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String INSTANCEID_DEFAULT  =  null;
    public static final java.lang.String RANKID_DEFAULT  =  null;
    public static final java.lang.String INSTANCETYPE_DEFAULT  =  null;
    public static final java.lang.Integer RACENUMBER_DEFAULT  =  null;
    public static final java.sql.Date RACEDATE_DEFAULT  =  null;
    public static final java.lang.String RACETIME_DEFAULT  =  null;
    public static final java.math.BigDecimal RACEDISTANCE_DEFAULT  =  null;
    public static final java.lang.String RACECOEFFICIENT_DEFAULT  =  null;
    public static final java.lang.String RACERATING_DEFAULT  =  null;
    public static final java.lang.Integer MINREALTIME_DEFAULT  =  null;
    public static final java.lang.String SOFTWAREVERSION_DEFAULT  =  null;
    public static final java.lang.String SOFTWARECODE_DEFAULT  =  null;
    public static final java.lang.String RACEFILEDMSURL_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int INSTANCEID_DIRTYGROUP  =  0;
    public static final int INSTANCEID_DIRTYMASK   =  2;
    public static final int RANKID_DIRTYGROUP  =  0;
    public static final int RANKID_DIRTYMASK   =  4;
    public static final int INSTANCETYPE_DIRTYGROUP  =  0;
    public static final int INSTANCETYPE_DIRTYMASK   =  8;
    public static final int RACENUMBER_DIRTYGROUP  =  0;
    public static final int RACENUMBER_DIRTYMASK   =  16;
    public static final int RACEDATE_DIRTYGROUP  =  0;
    public static final int RACEDATE_DIRTYMASK   =  32;
    public static final int RACETIME_DIRTYGROUP  =  0;
    public static final int RACETIME_DIRTYMASK   =  64;
    public static final int RACEDISTANCE_DIRTYGROUP  =  0;
    public static final int RACEDISTANCE_DIRTYMASK   =  128;
    public static final int RACECOEFFICIENT_DIRTYGROUP  =  0;
    public static final int RACECOEFFICIENT_DIRTYMASK   =  256;
    public static final int RACERATING_DIRTYGROUP  =  0;
    public static final int RACERATING_DIRTYMASK   =  512;
    public static final int MINREALTIME_DIRTYGROUP  =  0;
    public static final int MINREALTIME_DIRTYMASK   =  1024;
    public static final int SOFTWAREVERSION_DIRTYGROUP  =  0;
    public static final int SOFTWAREVERSION_DIRTYMASK   =  2048;
    public static final int SOFTWARECODE_DIRTYGROUP  =  0;
    public static final int SOFTWARECODE_DIRTYMASK   =  4096;
    public static final int RACEFILEDMSURL_DIRTYGROUP  =  0;
    public static final int RACEFILEDMSURL_DIRTYMASK   =  8192;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  16384;


    /**
      * DataBean constructor.
      */
    public RankingInstanceDTOBase()
    {
       dirtyFlagsArray = new int[15 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       instanceid = INSTANCEID_DEFAULT;
       rankid = RANKID_DEFAULT;
       instancetype = INSTANCETYPE_DEFAULT;
       racenumber = RACENUMBER_DEFAULT;
       racedate = RACEDATE_DEFAULT;
       racetime = RACETIME_DEFAULT;
       racedistance = RACEDISTANCE_DEFAULT;
       racecoefficient = RACECOEFFICIENT_DEFAULT;
       racerating = RACERATING_DEFAULT;
       minrealtime = MINREALTIME_DEFAULT;
       softwareversion = SOFTWAREVERSION_DEFAULT;
       softwarecode = SOFTWARECODE_DEFAULT;
       racefiledmsurl = RACEFILEDMSURL_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public RankingInstanceDTOBase(RankingInstanceDTOBase another)
    {

       eventid = another.getEventid();
       instanceid = another.getInstanceid();
       rankid = another.getRankid();
       instancetype = another.getInstancetype();
       racenumber = another.getRacenumber();
       racedate = another.getRacedate();
       racetime = another.getRacetime();
       racedistance = another.getRacedistance();
       racecoefficient = another.getRacecoefficient();
       racerating = another.getRacerating();
       minrealtime = another.getMinrealtime();
       softwareversion = another.getSoftwareversion();
       softwarecode = another.getSoftwarecode();
       racefiledmsurl = another.getRacefiledmsurl();
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
        stb.append(instanceid);
        return stb.toString();
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

    // racetime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacetimeDirty()  { return checkFieldDirtiness(RACETIME_DIRTYGROUP, RACETIME_DIRTYMASK); }

    public java.lang.String   getRacetime()         { return racetime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racetime")
    public java.lang.String   getRacetimeAsString() { return (racetime == null) ? "" : racetime; }

    // racetime setter methods.
    
    protected void markRacetimeAsDirty(boolean aFlag)  { markFieldAsDirty(RACETIME_DIRTYGROUP, RACETIME_DIRTYMASK, aFlag); }


    public void setRacetime(String  p)
    {
       setRacetime(p, DTOCasingStyle.none);
    }
    
    public void setRacetime(String  p, DTOCasingStyle casingStyle)
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
       markRacetimeAsDirty(!equalsObject(racetime, p));
       racetime = p;
    }

    // racedistance getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacedistanceDirty()  { return checkFieldDirtiness(RACEDISTANCE_DIRTYGROUP, RACEDISTANCE_DIRTYMASK); }

    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public double getRacedistanceAsDouble()   {
        return (racedistance != null) ? racedistance.doubleValue() : 0;
    }

    public java.math.BigDecimal getRacedistance() { return racedistance; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String               getRacedistanceAsString(java.text.NumberFormat    aNumberFormat)    { return currencyAsString(racedistance, aNumberFormat); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racedistance")
    public String               getRacedistanceAsString()            { return decimalAsString(racedistance);  }

    // racedistance setter methods.
    
    protected void markRacedistanceAsDirty(boolean aFlag)  { markFieldAsDirty(RACEDISTANCE_DIRTYGROUP, RACEDISTANCE_DIRTYMASK, aFlag); }


    public void setRacedistance(java.math.BigDecimal  p) {
           p = (p != null) ? p.setScale(2, java.math.BigDecimal.ROUND_HALF_DOWN) : null;
           markRacedistanceAsDirty(!equalsBigDecimal(racedistance, p));
           racedistance = p;
    }
    public void setRacedistance(double  p) {
       	   setRacedistance(new java.math.BigDecimal(p).setScale(2, java.math.BigDecimal.ROUND_HALF_DOWN));
    }
    public void setRacedistance(String  p) {
           setRacedistance(stringAsBigDecimal(p, 2));
    }

    // racecoefficient getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacecoefficientDirty()  { return checkFieldDirtiness(RACECOEFFICIENT_DIRTYGROUP, RACECOEFFICIENT_DIRTYMASK); }

    public java.lang.String   getRacecoefficient()         { return racecoefficient; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racecoefficient")
    public java.lang.String   getRacecoefficientAsString() { return (racecoefficient == null) ? "" : racecoefficient; }

    // racecoefficient setter methods.
    
    protected void markRacecoefficientAsDirty(boolean aFlag)  { markFieldAsDirty(RACECOEFFICIENT_DIRTYGROUP, RACECOEFFICIENT_DIRTYMASK, aFlag); }


    public void setRacecoefficient(String  p)
    {
       setRacecoefficient(p, DTOCasingStyle.none);
    }
    
    public void setRacecoefficient(String  p, DTOCasingStyle casingStyle)
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
       markRacecoefficientAsDirty(!equalsObject(racecoefficient, p));
       racecoefficient = p;
    }

    // racerating getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRaceratingDirty()  { return checkFieldDirtiness(RACERATING_DIRTYGROUP, RACERATING_DIRTYMASK); }

    public java.lang.String   getRacerating()         { return racerating; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racerating")
    public java.lang.String   getRaceratingAsString() { return (racerating == null) ? "" : racerating; }

    // racerating setter methods.
    
    protected void markRaceratingAsDirty(boolean aFlag)  { markFieldAsDirty(RACERATING_DIRTYGROUP, RACERATING_DIRTYMASK, aFlag); }


    public void setRacerating(String  p)
    {
       setRacerating(p, DTOCasingStyle.none);
    }
    
    public void setRacerating(String  p, DTOCasingStyle casingStyle)
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
       markRaceratingAsDirty(!equalsObject(racerating, p));
       racerating = p;
    }

    // minrealtime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMinrealtimeDirty()  { return checkFieldDirtiness(MINREALTIME_DIRTYGROUP, MINREALTIME_DIRTYMASK); }

    public java.lang.Integer   getMinrealtime() { return minrealtime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "minrealtime")
    public String getMinrealtimeAsString() { return integerAsString(minrealtime); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getMinrealtimeAsInt()    { return minrealtime != null ? minrealtime.intValue() : 0; }

    // minrealtime setter methods.
    
    protected void markMinrealtimeAsDirty(boolean aFlag)  { markFieldAsDirty(MINREALTIME_DIRTYGROUP, MINREALTIME_DIRTYMASK, aFlag); }


    public void setMinrealtime(java.lang.Integer  p)
    {
        markMinrealtimeAsDirty(!equalsObject(minrealtime, p));
    	minrealtime = p;
    }
    public void setMinrealtime(int p)
    {
    	setMinrealtime(new java.lang.Integer(p));
    }
    public void setMinrealtime()
    {
    	setMinrealtime(0);
    }
    public void setMinrealtime(String  p)
    {
    	setMinrealtime(stringAsInteger(p));
    }

    // softwareversion getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSoftwareversionDirty()  { return checkFieldDirtiness(SOFTWAREVERSION_DIRTYGROUP, SOFTWAREVERSION_DIRTYMASK); }

    public java.lang.String   getSoftwareversion()         { return softwareversion; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "softwareversion")
    public java.lang.String   getSoftwareversionAsString() { return (softwareversion == null) ? "" : softwareversion; }

    // softwareversion setter methods.
    
    protected void markSoftwareversionAsDirty(boolean aFlag)  { markFieldAsDirty(SOFTWAREVERSION_DIRTYGROUP, SOFTWAREVERSION_DIRTYMASK, aFlag); }


    public void setSoftwareversion(String  p)
    {
       setSoftwareversion(p, DTOCasingStyle.none);
    }
    
    public void setSoftwareversion(String  p, DTOCasingStyle casingStyle)
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
       markSoftwareversionAsDirty(!equalsObject(softwareversion, p));
       softwareversion = p;
    }

    // softwarecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSoftwarecodeDirty()  { return checkFieldDirtiness(SOFTWARECODE_DIRTYGROUP, SOFTWARECODE_DIRTYMASK); }

    public java.lang.String   getSoftwarecode()         { return softwarecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "softwarecode")
    public java.lang.String   getSoftwarecodeAsString() { return (softwarecode == null) ? "" : softwarecode; }

    // softwarecode setter methods.
    
    protected void markSoftwarecodeAsDirty(boolean aFlag)  { markFieldAsDirty(SOFTWARECODE_DIRTYGROUP, SOFTWARECODE_DIRTYMASK, aFlag); }


    public void setSoftwarecode(String  p)
    {
       setSoftwarecode(p, DTOCasingStyle.none);
    }
    
    public void setSoftwarecode(String  p, DTOCasingStyle casingStyle)
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
       markSoftwarecodeAsDirty(!equalsObject(softwarecode, p));
       softwarecode = p;
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
