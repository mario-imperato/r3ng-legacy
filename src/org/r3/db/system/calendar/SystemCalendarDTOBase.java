//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.calendar;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SystemCalendarDTOBase")
public class SystemCalendarDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  sitedomain;
    protected java.lang.String  calendarid;
    protected java.sql.Date  caldate;
    protected java.lang.Integer  caleveday;
    protected java.lang.Integer  caleveworkday;
    protected java.lang.Integer  calday;
    protected java.lang.Integer  calmonth;
    protected java.lang.Integer  calyear;
    protected java.lang.Integer  calweek;
    protected java.lang.Integer  calquarter;
    protected java.lang.Integer  calyday;
    protected java.lang.Integer  calwday;
    protected java.lang.Integer  calevemonth;
    protected java.lang.Integer  caleveweek;
    protected java.lang.Integer  calevequarter;
    protected java.lang.Integer  caleveyear;
    protected java.lang.String  calentrytype;

    public static final java.lang.String SITEDOMAIN_DEFAULT  =  null;
    public static final java.lang.String CALENDARID_DEFAULT  =  null;
    public static final java.sql.Date CALDATE_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEDAY_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEWORKDAY_DEFAULT  =  null;
    public static final java.lang.Integer CALDAY_DEFAULT  =  null;
    public static final java.lang.Integer CALMONTH_DEFAULT  =  null;
    public static final java.lang.Integer CALYEAR_DEFAULT  =  null;
    public static final java.lang.Integer CALWEEK_DEFAULT  =  null;
    public static final java.lang.Integer CALQUARTER_DEFAULT  =  null;
    public static final java.lang.Integer CALYDAY_DEFAULT  =  null;
    public static final java.lang.Integer CALWDAY_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEMONTH_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEWEEK_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEQUARTER_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEYEAR_DEFAULT  =  null;
    public static final java.lang.String CALENTRYTYPE_DEFAULT  =  null;

    public static final int SITEDOMAIN_DIRTYGROUP  =  0;
    public static final int SITEDOMAIN_DIRTYMASK   =  1;
    public static final int CALENDARID_DIRTYGROUP  =  0;
    public static final int CALENDARID_DIRTYMASK   =  2;
    public static final int CALDATE_DIRTYGROUP  =  0;
    public static final int CALDATE_DIRTYMASK   =  4;
    public static final int CALEVEDAY_DIRTYGROUP  =  0;
    public static final int CALEVEDAY_DIRTYMASK   =  8;
    public static final int CALEVEWORKDAY_DIRTYGROUP  =  0;
    public static final int CALEVEWORKDAY_DIRTYMASK   =  16;
    public static final int CALDAY_DIRTYGROUP  =  0;
    public static final int CALDAY_DIRTYMASK   =  32;
    public static final int CALMONTH_DIRTYGROUP  =  0;
    public static final int CALMONTH_DIRTYMASK   =  64;
    public static final int CALYEAR_DIRTYGROUP  =  0;
    public static final int CALYEAR_DIRTYMASK   =  128;
    public static final int CALWEEK_DIRTYGROUP  =  0;
    public static final int CALWEEK_DIRTYMASK   =  256;
    public static final int CALQUARTER_DIRTYGROUP  =  0;
    public static final int CALQUARTER_DIRTYMASK   =  512;
    public static final int CALYDAY_DIRTYGROUP  =  0;
    public static final int CALYDAY_DIRTYMASK   =  1024;
    public static final int CALWDAY_DIRTYGROUP  =  0;
    public static final int CALWDAY_DIRTYMASK   =  2048;
    public static final int CALEVEMONTH_DIRTYGROUP  =  0;
    public static final int CALEVEMONTH_DIRTYMASK   =  4096;
    public static final int CALEVEWEEK_DIRTYGROUP  =  0;
    public static final int CALEVEWEEK_DIRTYMASK   =  8192;
    public static final int CALEVEQUARTER_DIRTYGROUP  =  0;
    public static final int CALEVEQUARTER_DIRTYMASK   =  16384;
    public static final int CALEVEYEAR_DIRTYGROUP  =  0;
    public static final int CALEVEYEAR_DIRTYMASK   =  32768;
    public static final int CALENTRYTYPE_DIRTYGROUP  =  0;
    public static final int CALENTRYTYPE_DIRTYMASK   =  65536;


    /**
      * DataBean constructor.
      */
    public SystemCalendarDTOBase()
    {
       dirtyFlagsArray = new int[17 / 30 + 1];
       clearDirtyFlags();

       sitedomain = SITEDOMAIN_DEFAULT;
       calendarid = CALENDARID_DEFAULT;
       caldate = CALDATE_DEFAULT;
       caleveday = CALEVEDAY_DEFAULT;
       caleveworkday = CALEVEWORKDAY_DEFAULT;
       calday = CALDAY_DEFAULT;
       calmonth = CALMONTH_DEFAULT;
       calyear = CALYEAR_DEFAULT;
       calweek = CALWEEK_DEFAULT;
       calquarter = CALQUARTER_DEFAULT;
       calyday = CALYDAY_DEFAULT;
       calwday = CALWDAY_DEFAULT;
       calevemonth = CALEVEMONTH_DEFAULT;
       caleveweek = CALEVEWEEK_DEFAULT;
       calevequarter = CALEVEQUARTER_DEFAULT;
       caleveyear = CALEVEYEAR_DEFAULT;
       calentrytype = CALENTRYTYPE_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SystemCalendarDTOBase(SystemCalendarDTOBase another)
    {

       sitedomain = another.getSitedomain();
       calendarid = another.getCalendarid();
       caldate = another.getCaldate();
       caleveday = another.getCaleveday();
       caleveworkday = another.getCaleveworkday();
       calday = another.getCalday();
       calmonth = another.getCalmonth();
       calyear = another.getCalyear();
       calweek = another.getCalweek();
       calquarter = another.getCalquarter();
       calyday = another.getCalyday();
       calwday = another.getCalwday();
       calevemonth = another.getCalevemonth();
       caleveweek = another.getCaleveweek();
       calevequarter = another.getCalevequarter();
       caleveyear = another.getCaleveyear();
       calentrytype = another.getCalentrytype();

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
        stb.append(sitedomain);
        stb.append(", ");
        stb.append(calendarid);
        stb.append(", ");
        stb.append(caldate);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // sitedomain getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSitedomainDirty()  { return checkFieldDirtiness(SITEDOMAIN_DIRTYGROUP, SITEDOMAIN_DIRTYMASK); }

    public java.lang.String   getSitedomain()         { return sitedomain; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "sitedomain")
    public java.lang.String   getSitedomainAsString() { return (sitedomain == null) ? "" : sitedomain; }

    // sitedomain setter methods.
    
    protected void markSitedomainAsDirty(boolean aFlag)  { markFieldAsDirty(SITEDOMAIN_DIRTYGROUP, SITEDOMAIN_DIRTYMASK, aFlag); }


    public void setSitedomain(String  p)
    {
       setSitedomain(p, DTOCasingStyle.none);
    }
    
    public void setSitedomain(String  p, DTOCasingStyle casingStyle)
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
       markSitedomainAsDirty(!equalsObject(sitedomain, p));
       sitedomain = p;
    }

    // calendarid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalendaridDirty()  { return checkFieldDirtiness(CALENDARID_DIRTYGROUP, CALENDARID_DIRTYMASK); }

    public java.lang.String   getCalendarid()         { return calendarid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calendarid")
    public java.lang.String   getCalendaridAsString() { return (calendarid == null) ? "" : calendarid; }

    // calendarid setter methods.
    
    protected void markCalendaridAsDirty(boolean aFlag)  { markFieldAsDirty(CALENDARID_DIRTYGROUP, CALENDARID_DIRTYMASK, aFlag); }


    public void setCalendarid(String  p)
    {
       setCalendarid(p, DTOCasingStyle.none);
    }
    
    public void setCalendarid(String  p, DTOCasingStyle casingStyle)
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
       markCalendaridAsDirty(!equalsObject(calendarid, p));
       calendarid = p;
    }

    // caldate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCaldateDirty()  { return checkFieldDirtiness(CALDATE_DIRTYGROUP, CALDATE_DIRTYMASK); }

    public java.sql.Date   getCaldate() { return caldate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "caldate")
    public String getCaldateAsString() { return dateAsString(caldate, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCaldateAsString(java.text.DateFormat aDateFormat) { return dateAsString(caldate, aDateFormat); }

    // caldate setter methods.
    
    protected void markCaldateAsDirty(boolean aFlag)  { markFieldAsDirty(CALDATE_DIRTYGROUP, CALDATE_DIRTYMASK, aFlag); }


    public void setCaldate(java.sql.Date  p)
    {
         markCaldateAsDirty(!equalsObject(caldate, p));
    	 caldate = p;
    }
    public void setCaldate(String p, java.text.DateFormat aDateFormat)
    {
    	setCaldate(stringAsDate(p, aDateFormat));
    }

    // caleveday getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalevedayDirty()  { return checkFieldDirtiness(CALEVEDAY_DIRTYGROUP, CALEVEDAY_DIRTYMASK); }

    public java.lang.Integer   getCaleveday() { return caleveday; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "caleveday")
    public String getCalevedayAsString() { return integerAsString(caleveday); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalevedayAsInt()    { return caleveday != null ? caleveday.intValue() : 0; }

    // caleveday setter methods.
    
    protected void markCalevedayAsDirty(boolean aFlag)  { markFieldAsDirty(CALEVEDAY_DIRTYGROUP, CALEVEDAY_DIRTYMASK, aFlag); }


    public void setCaleveday(java.lang.Integer  p)
    {
        markCalevedayAsDirty(!equalsObject(caleveday, p));
    	caleveday = p;
    }
    public void setCaleveday(int p)
    {
    	setCaleveday(new java.lang.Integer(p));
    }
    public void setCaleveday()
    {
    	setCaleveday(0);
    }
    public void setCaleveday(String  p)
    {
    	setCaleveday(stringAsInteger(p));
    }

    // caleveworkday getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCaleveworkdayDirty()  { return checkFieldDirtiness(CALEVEWORKDAY_DIRTYGROUP, CALEVEWORKDAY_DIRTYMASK); }

    public java.lang.Integer   getCaleveworkday() { return caleveworkday; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "caleveworkday")
    public String getCaleveworkdayAsString() { return integerAsString(caleveworkday); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCaleveworkdayAsInt()    { return caleveworkday != null ? caleveworkday.intValue() : 0; }

    // caleveworkday setter methods.
    
    protected void markCaleveworkdayAsDirty(boolean aFlag)  { markFieldAsDirty(CALEVEWORKDAY_DIRTYGROUP, CALEVEWORKDAY_DIRTYMASK, aFlag); }


    public void setCaleveworkday(java.lang.Integer  p)
    {
        markCaleveworkdayAsDirty(!equalsObject(caleveworkday, p));
    	caleveworkday = p;
    }
    public void setCaleveworkday(int p)
    {
    	setCaleveworkday(new java.lang.Integer(p));
    }
    public void setCaleveworkday()
    {
    	setCaleveworkday(0);
    }
    public void setCaleveworkday(String  p)
    {
    	setCaleveworkday(stringAsInteger(p));
    }

    // calday getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCaldayDirty()  { return checkFieldDirtiness(CALDAY_DIRTYGROUP, CALDAY_DIRTYMASK); }

    public java.lang.Integer   getCalday() { return calday; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calday")
    public String getCaldayAsString() { return integerAsString(calday); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCaldayAsInt()    { return calday != null ? calday.intValue() : 0; }

    // calday setter methods.
    
    protected void markCaldayAsDirty(boolean aFlag)  { markFieldAsDirty(CALDAY_DIRTYGROUP, CALDAY_DIRTYMASK, aFlag); }


    public void setCalday(java.lang.Integer  p)
    {
        markCaldayAsDirty(!equalsObject(calday, p));
    	calday = p;
    }
    public void setCalday(int p)
    {
    	setCalday(new java.lang.Integer(p));
    }
    public void setCalday()
    {
    	setCalday(0);
    }
    public void setCalday(String  p)
    {
    	setCalday(stringAsInteger(p));
    }

    // calmonth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalmonthDirty()  { return checkFieldDirtiness(CALMONTH_DIRTYGROUP, CALMONTH_DIRTYMASK); }

    public java.lang.Integer   getCalmonth() { return calmonth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calmonth")
    public String getCalmonthAsString() { return integerAsString(calmonth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalmonthAsInt()    { return calmonth != null ? calmonth.intValue() : 0; }

    // calmonth setter methods.
    
    protected void markCalmonthAsDirty(boolean aFlag)  { markFieldAsDirty(CALMONTH_DIRTYGROUP, CALMONTH_DIRTYMASK, aFlag); }


    public void setCalmonth(java.lang.Integer  p)
    {
        markCalmonthAsDirty(!equalsObject(calmonth, p));
    	calmonth = p;
    }
    public void setCalmonth(int p)
    {
    	setCalmonth(new java.lang.Integer(p));
    }
    public void setCalmonth()
    {
    	setCalmonth(0);
    }
    public void setCalmonth(String  p)
    {
    	setCalmonth(stringAsInteger(p));
    }

    // calyear getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalyearDirty()  { return checkFieldDirtiness(CALYEAR_DIRTYGROUP, CALYEAR_DIRTYMASK); }

    public java.lang.Integer   getCalyear() { return calyear; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calyear")
    public String getCalyearAsString() { return integerAsString(calyear); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalyearAsInt()    { return calyear != null ? calyear.intValue() : 0; }

    // calyear setter methods.
    
    protected void markCalyearAsDirty(boolean aFlag)  { markFieldAsDirty(CALYEAR_DIRTYGROUP, CALYEAR_DIRTYMASK, aFlag); }


    public void setCalyear(java.lang.Integer  p)
    {
        markCalyearAsDirty(!equalsObject(calyear, p));
    	calyear = p;
    }
    public void setCalyear(int p)
    {
    	setCalyear(new java.lang.Integer(p));
    }
    public void setCalyear()
    {
    	setCalyear(0);
    }
    public void setCalyear(String  p)
    {
    	setCalyear(stringAsInteger(p));
    }

    // calweek getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalweekDirty()  { return checkFieldDirtiness(CALWEEK_DIRTYGROUP, CALWEEK_DIRTYMASK); }

    public java.lang.Integer   getCalweek() { return calweek; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calweek")
    public String getCalweekAsString() { return integerAsString(calweek); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalweekAsInt()    { return calweek != null ? calweek.intValue() : 0; }

    // calweek setter methods.
    
    protected void markCalweekAsDirty(boolean aFlag)  { markFieldAsDirty(CALWEEK_DIRTYGROUP, CALWEEK_DIRTYMASK, aFlag); }


    public void setCalweek(java.lang.Integer  p)
    {
        markCalweekAsDirty(!equalsObject(calweek, p));
    	calweek = p;
    }
    public void setCalweek(int p)
    {
    	setCalweek(new java.lang.Integer(p));
    }
    public void setCalweek()
    {
    	setCalweek(0);
    }
    public void setCalweek(String  p)
    {
    	setCalweek(stringAsInteger(p));
    }

    // calquarter getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalquarterDirty()  { return checkFieldDirtiness(CALQUARTER_DIRTYGROUP, CALQUARTER_DIRTYMASK); }

    public java.lang.Integer   getCalquarter() { return calquarter; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calquarter")
    public String getCalquarterAsString() { return integerAsString(calquarter); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalquarterAsInt()    { return calquarter != null ? calquarter.intValue() : 0; }

    // calquarter setter methods.
    
    protected void markCalquarterAsDirty(boolean aFlag)  { markFieldAsDirty(CALQUARTER_DIRTYGROUP, CALQUARTER_DIRTYMASK, aFlag); }


    public void setCalquarter(java.lang.Integer  p)
    {
        markCalquarterAsDirty(!equalsObject(calquarter, p));
    	calquarter = p;
    }
    public void setCalquarter(int p)
    {
    	setCalquarter(new java.lang.Integer(p));
    }
    public void setCalquarter()
    {
    	setCalquarter(0);
    }
    public void setCalquarter(String  p)
    {
    	setCalquarter(stringAsInteger(p));
    }

    // calyday getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalydayDirty()  { return checkFieldDirtiness(CALYDAY_DIRTYGROUP, CALYDAY_DIRTYMASK); }

    public java.lang.Integer   getCalyday() { return calyday; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calyday")
    public String getCalydayAsString() { return integerAsString(calyday); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalydayAsInt()    { return calyday != null ? calyday.intValue() : 0; }

    // calyday setter methods.
    
    protected void markCalydayAsDirty(boolean aFlag)  { markFieldAsDirty(CALYDAY_DIRTYGROUP, CALYDAY_DIRTYMASK, aFlag); }


    public void setCalyday(java.lang.Integer  p)
    {
        markCalydayAsDirty(!equalsObject(calyday, p));
    	calyday = p;
    }
    public void setCalyday(int p)
    {
    	setCalyday(new java.lang.Integer(p));
    }
    public void setCalyday()
    {
    	setCalyday(0);
    }
    public void setCalyday(String  p)
    {
    	setCalyday(stringAsInteger(p));
    }

    // calwday getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalwdayDirty()  { return checkFieldDirtiness(CALWDAY_DIRTYGROUP, CALWDAY_DIRTYMASK); }

    public java.lang.Integer   getCalwday() { return calwday; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calwday")
    public String getCalwdayAsString() { return integerAsString(calwday); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalwdayAsInt()    { return calwday != null ? calwday.intValue() : 0; }

    // calwday setter methods.
    
    protected void markCalwdayAsDirty(boolean aFlag)  { markFieldAsDirty(CALWDAY_DIRTYGROUP, CALWDAY_DIRTYMASK, aFlag); }


    public void setCalwday(java.lang.Integer  p)
    {
        markCalwdayAsDirty(!equalsObject(calwday, p));
    	calwday = p;
    }
    public void setCalwday(int p)
    {
    	setCalwday(new java.lang.Integer(p));
    }
    public void setCalwday()
    {
    	setCalwday(0);
    }
    public void setCalwday(String  p)
    {
    	setCalwday(stringAsInteger(p));
    }

    // calevemonth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalevemonthDirty()  { return checkFieldDirtiness(CALEVEMONTH_DIRTYGROUP, CALEVEMONTH_DIRTYMASK); }

    public java.lang.Integer   getCalevemonth() { return calevemonth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calevemonth")
    public String getCalevemonthAsString() { return integerAsString(calevemonth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalevemonthAsInt()    { return calevemonth != null ? calevemonth.intValue() : 0; }

    // calevemonth setter methods.
    
    protected void markCalevemonthAsDirty(boolean aFlag)  { markFieldAsDirty(CALEVEMONTH_DIRTYGROUP, CALEVEMONTH_DIRTYMASK, aFlag); }


    public void setCalevemonth(java.lang.Integer  p)
    {
        markCalevemonthAsDirty(!equalsObject(calevemonth, p));
    	calevemonth = p;
    }
    public void setCalevemonth(int p)
    {
    	setCalevemonth(new java.lang.Integer(p));
    }
    public void setCalevemonth()
    {
    	setCalevemonth(0);
    }
    public void setCalevemonth(String  p)
    {
    	setCalevemonth(stringAsInteger(p));
    }

    // caleveweek getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCaleveweekDirty()  { return checkFieldDirtiness(CALEVEWEEK_DIRTYGROUP, CALEVEWEEK_DIRTYMASK); }

    public java.lang.Integer   getCaleveweek() { return caleveweek; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "caleveweek")
    public String getCaleveweekAsString() { return integerAsString(caleveweek); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCaleveweekAsInt()    { return caleveweek != null ? caleveweek.intValue() : 0; }

    // caleveweek setter methods.
    
    protected void markCaleveweekAsDirty(boolean aFlag)  { markFieldAsDirty(CALEVEWEEK_DIRTYGROUP, CALEVEWEEK_DIRTYMASK, aFlag); }


    public void setCaleveweek(java.lang.Integer  p)
    {
        markCaleveweekAsDirty(!equalsObject(caleveweek, p));
    	caleveweek = p;
    }
    public void setCaleveweek(int p)
    {
    	setCaleveweek(new java.lang.Integer(p));
    }
    public void setCaleveweek()
    {
    	setCaleveweek(0);
    }
    public void setCaleveweek(String  p)
    {
    	setCaleveweek(stringAsInteger(p));
    }

    // calevequarter getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalevequarterDirty()  { return checkFieldDirtiness(CALEVEQUARTER_DIRTYGROUP, CALEVEQUARTER_DIRTYMASK); }

    public java.lang.Integer   getCalevequarter() { return calevequarter; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calevequarter")
    public String getCalevequarterAsString() { return integerAsString(calevequarter); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCalevequarterAsInt()    { return calevequarter != null ? calevequarter.intValue() : 0; }

    // calevequarter setter methods.
    
    protected void markCalevequarterAsDirty(boolean aFlag)  { markFieldAsDirty(CALEVEQUARTER_DIRTYGROUP, CALEVEQUARTER_DIRTYMASK, aFlag); }


    public void setCalevequarter(java.lang.Integer  p)
    {
        markCalevequarterAsDirty(!equalsObject(calevequarter, p));
    	calevequarter = p;
    }
    public void setCalevequarter(int p)
    {
    	setCalevequarter(new java.lang.Integer(p));
    }
    public void setCalevequarter()
    {
    	setCalevequarter(0);
    }
    public void setCalevequarter(String  p)
    {
    	setCalevequarter(stringAsInteger(p));
    }

    // caleveyear getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCaleveyearDirty()  { return checkFieldDirtiness(CALEVEYEAR_DIRTYGROUP, CALEVEYEAR_DIRTYMASK); }

    public java.lang.Integer   getCaleveyear() { return caleveyear; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "caleveyear")
    public String getCaleveyearAsString() { return integerAsString(caleveyear); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getCaleveyearAsInt()    { return caleveyear != null ? caleveyear.intValue() : 0; }

    // caleveyear setter methods.
    
    protected void markCaleveyearAsDirty(boolean aFlag)  { markFieldAsDirty(CALEVEYEAR_DIRTYGROUP, CALEVEYEAR_DIRTYMASK, aFlag); }


    public void setCaleveyear(java.lang.Integer  p)
    {
        markCaleveyearAsDirty(!equalsObject(caleveyear, p));
    	caleveyear = p;
    }
    public void setCaleveyear(int p)
    {
    	setCaleveyear(new java.lang.Integer(p));
    }
    public void setCaleveyear()
    {
    	setCaleveyear(0);
    }
    public void setCaleveyear(String  p)
    {
    	setCaleveyear(stringAsInteger(p));
    }

    // calentrytype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCalentrytypeDirty()  { return checkFieldDirtiness(CALENTRYTYPE_DIRTYGROUP, CALENTRYTYPE_DIRTYMASK); }

    public java.lang.String   getCalentrytype()         { return calentrytype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "calentrytype")
    public java.lang.String   getCalentrytypeAsString() { return (calentrytype == null) ? "" : calentrytype; }

    // calentrytype setter methods.
    
    protected void markCalentrytypeAsDirty(boolean aFlag)  { markFieldAsDirty(CALENTRYTYPE_DIRTYGROUP, CALENTRYTYPE_DIRTYMASK, aFlag); }


    public void setCalentrytype(String  p)
    {
       setCalentrytype(p, DTOCasingStyle.none);
    }
    
    public void setCalentrytype(String  p, DTOCasingStyle casingStyle)
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
       markCalentrytypeAsDirty(!equalsObject(calentrytype, p));
       calentrytype = p;
    }

}
