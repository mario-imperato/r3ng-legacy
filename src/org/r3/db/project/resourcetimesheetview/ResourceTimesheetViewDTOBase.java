//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resourcetimesheetview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ResourceTimesheetViewDTOBase")
public class ResourceTimesheetViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  tsentryid;
    protected java.lang.String  sitedomain;
    protected java.lang.String  resourceid;
    protected java.lang.String  resourcedescr;
    protected java.lang.String  teamid;
    protected java.lang.Integer  teamperiod;
    protected java.lang.String  profileid;
    protected java.lang.String  companyid;
    protected java.lang.String  costcenter1;
    protected java.lang.String  costcenter2;
    protected java.lang.String  costcenter3;
    protected java.lang.String  uniteffort;
    protected java.lang.Integer  ordeffort;
    protected java.lang.Integer  exteffort;
    protected java.lang.Integer  oncalleffort;
    protected java.lang.Float  price;
    protected java.lang.Float  cost;
    protected java.lang.String  evalueunit;
    protected java.sql.Date  caldate;
    protected java.lang.Integer  caleveday;
    protected java.lang.Integer  calevemonth;
    protected java.lang.Integer  caleveweek;
    protected java.lang.Integer  calevequarter;
    protected java.lang.Integer  caleveyear;
    protected java.lang.String  tseuserid;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String TSENTRYID_DEFAULT  =  null;
    public static final java.lang.String SITEDOMAIN_DEFAULT  =  null;
    public static final java.lang.String RESOURCEID_DEFAULT  =  null;
    public static final java.lang.String RESOURCEDESCR_DEFAULT  =  null;
    public static final java.lang.String TEAMID_DEFAULT  =  null;
    public static final java.lang.Integer TEAMPERIOD_DEFAULT  =  null;
    public static final java.lang.String PROFILEID_DEFAULT  =  null;
    public static final java.lang.String COMPANYID_DEFAULT  =  null;
    public static final java.lang.String COSTCENTER1_DEFAULT  =  null;
    public static final java.lang.String COSTCENTER2_DEFAULT  =  null;
    public static final java.lang.String COSTCENTER3_DEFAULT  =  null;
    public static final java.lang.String UNITEFFORT_DEFAULT  =  null;
    public static final java.lang.Integer ORDEFFORT_DEFAULT  =  null;
    public static final java.lang.Integer EXTEFFORT_DEFAULT  =  null;
    public static final java.lang.Integer ONCALLEFFORT_DEFAULT  =  null;
    public static final java.lang.Float PRICE_DEFAULT  =  null;
    public static final java.lang.Float COST_DEFAULT  =  null;
    public static final java.lang.String EVALUEUNIT_DEFAULT  =  null;
    public static final java.sql.Date CALDATE_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEDAY_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEMONTH_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEWEEK_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEQUARTER_DEFAULT  =  null;
    public static final java.lang.Integer CALEVEYEAR_DEFAULT  =  null;
    public static final java.lang.String TSEUSERID_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int TSENTRYID_DIRTYGROUP  =  0;
    public static final int TSENTRYID_DIRTYMASK   =  2;
    public static final int SITEDOMAIN_DIRTYGROUP  =  0;
    public static final int SITEDOMAIN_DIRTYMASK   =  4;
    public static final int RESOURCEID_DIRTYGROUP  =  0;
    public static final int RESOURCEID_DIRTYMASK   =  8;
    public static final int RESOURCEDESCR_DIRTYGROUP  =  0;
    public static final int RESOURCEDESCR_DIRTYMASK   =  16;
    public static final int TEAMID_DIRTYGROUP  =  0;
    public static final int TEAMID_DIRTYMASK   =  32;
    public static final int TEAMPERIOD_DIRTYGROUP  =  0;
    public static final int TEAMPERIOD_DIRTYMASK   =  64;
    public static final int PROFILEID_DIRTYGROUP  =  0;
    public static final int PROFILEID_DIRTYMASK   =  128;
    public static final int COMPANYID_DIRTYGROUP  =  0;
    public static final int COMPANYID_DIRTYMASK   =  256;
    public static final int COSTCENTER1_DIRTYGROUP  =  0;
    public static final int COSTCENTER1_DIRTYMASK   =  512;
    public static final int COSTCENTER2_DIRTYGROUP  =  0;
    public static final int COSTCENTER2_DIRTYMASK   =  1024;
    public static final int COSTCENTER3_DIRTYGROUP  =  0;
    public static final int COSTCENTER3_DIRTYMASK   =  2048;
    public static final int UNITEFFORT_DIRTYGROUP  =  0;
    public static final int UNITEFFORT_DIRTYMASK   =  4096;
    public static final int ORDEFFORT_DIRTYGROUP  =  0;
    public static final int ORDEFFORT_DIRTYMASK   =  8192;
    public static final int EXTEFFORT_DIRTYGROUP  =  0;
    public static final int EXTEFFORT_DIRTYMASK   =  16384;
    public static final int ONCALLEFFORT_DIRTYGROUP  =  0;
    public static final int ONCALLEFFORT_DIRTYMASK   =  32768;
    public static final int PRICE_DIRTYGROUP  =  0;
    public static final int PRICE_DIRTYMASK   =  65536;
    public static final int COST_DIRTYGROUP  =  0;
    public static final int COST_DIRTYMASK   =  131072;
    public static final int EVALUEUNIT_DIRTYGROUP  =  0;
    public static final int EVALUEUNIT_DIRTYMASK   =  262144;
    public static final int CALDATE_DIRTYGROUP  =  0;
    public static final int CALDATE_DIRTYMASK   =  524288;
    public static final int CALEVEDAY_DIRTYGROUP  =  0;
    public static final int CALEVEDAY_DIRTYMASK   =  1048576;
    public static final int CALEVEMONTH_DIRTYGROUP  =  0;
    public static final int CALEVEMONTH_DIRTYMASK   =  2097152;
    public static final int CALEVEWEEK_DIRTYGROUP  =  0;
    public static final int CALEVEWEEK_DIRTYMASK   =  4194304;
    public static final int CALEVEQUARTER_DIRTYGROUP  =  0;
    public static final int CALEVEQUARTER_DIRTYMASK   =  8388608;
    public static final int CALEVEYEAR_DIRTYGROUP  =  0;
    public static final int CALEVEYEAR_DIRTYMASK   =  16777216;
    public static final int TSEUSERID_DIRTYGROUP  =  0;
    public static final int TSEUSERID_DIRTYMASK   =  33554432;


    /**
      * DataBean constructor.
      */
    public ResourceTimesheetViewDTOBase()
    {
       dirtyFlagsArray = new int[26 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       tsentryid = TSENTRYID_DEFAULT;
       sitedomain = SITEDOMAIN_DEFAULT;
       resourceid = RESOURCEID_DEFAULT;
       resourcedescr = RESOURCEDESCR_DEFAULT;
       teamid = TEAMID_DEFAULT;
       teamperiod = TEAMPERIOD_DEFAULT;
       profileid = PROFILEID_DEFAULT;
       companyid = COMPANYID_DEFAULT;
       costcenter1 = COSTCENTER1_DEFAULT;
       costcenter2 = COSTCENTER2_DEFAULT;
       costcenter3 = COSTCENTER3_DEFAULT;
       uniteffort = UNITEFFORT_DEFAULT;
       ordeffort = ORDEFFORT_DEFAULT;
       exteffort = EXTEFFORT_DEFAULT;
       oncalleffort = ONCALLEFFORT_DEFAULT;
       price = PRICE_DEFAULT;
       cost = COST_DEFAULT;
       evalueunit = EVALUEUNIT_DEFAULT;
       caldate = CALDATE_DEFAULT;
       caleveday = CALEVEDAY_DEFAULT;
       calevemonth = CALEVEMONTH_DEFAULT;
       caleveweek = CALEVEWEEK_DEFAULT;
       calevequarter = CALEVEQUARTER_DEFAULT;
       caleveyear = CALEVEYEAR_DEFAULT;
       tseuserid = TSEUSERID_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ResourceTimesheetViewDTOBase(ResourceTimesheetViewDTOBase another)
    {

       site = another.getSite();
       tsentryid = another.getTsentryid();
       sitedomain = another.getSitedomain();
       resourceid = another.getResourceid();
       resourcedescr = another.getResourcedescr();
       teamid = another.getTeamid();
       teamperiod = another.getTeamperiod();
       profileid = another.getProfileid();
       companyid = another.getCompanyid();
       costcenter1 = another.getCostcenter1();
       costcenter2 = another.getCostcenter2();
       costcenter3 = another.getCostcenter3();
       uniteffort = another.getUniteffort();
       ordeffort = another.getOrdeffort();
       exteffort = another.getExteffort();
       oncalleffort = another.getOncalleffort();
       price = another.getPrice();
       cost = another.getCost();
       evalueunit = another.getEvalueunit();
       caldate = another.getCaldate();
       caleveday = another.getCaleveday();
       calevemonth = another.getCalevemonth();
       caleveweek = another.getCaleveweek();
       calevequarter = another.getCalevequarter();
       caleveyear = another.getCaleveyear();
       tseuserid = another.getTseuserid();

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

    // tsentryid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTsentryidDirty()  { return checkFieldDirtiness(TSENTRYID_DIRTYGROUP, TSENTRYID_DIRTYMASK); }

    public java.lang.String   getTsentryid()         { return tsentryid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "tsentryid")
    public java.lang.String   getTsentryidAsString() { return (tsentryid == null) ? "" : tsentryid; }

    // tsentryid setter methods.
    
    protected void markTsentryidAsDirty(boolean aFlag)  { markFieldAsDirty(TSENTRYID_DIRTYGROUP, TSENTRYID_DIRTYMASK, aFlag); }


    public void setTsentryid(String  p)
    {
       setTsentryid(p, DTOCasingStyle.none);
    }
    
    public void setTsentryid(String  p, DTOCasingStyle casingStyle)
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
       markTsentryidAsDirty(!equalsObject(tsentryid, p));
       tsentryid = p;
    }

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

    // resourceid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isResourceidDirty()  { return checkFieldDirtiness(RESOURCEID_DIRTYGROUP, RESOURCEID_DIRTYMASK); }

    public java.lang.String   getResourceid()         { return resourceid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "resourceid")
    public java.lang.String   getResourceidAsString() { return (resourceid == null) ? "" : resourceid; }

    // resourceid setter methods.
    
    protected void markResourceidAsDirty(boolean aFlag)  { markFieldAsDirty(RESOURCEID_DIRTYGROUP, RESOURCEID_DIRTYMASK, aFlag); }


    public void setResourceid(String  p)
    {
       setResourceid(p, DTOCasingStyle.none);
    }
    
    public void setResourceid(String  p, DTOCasingStyle casingStyle)
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
       markResourceidAsDirty(!equalsObject(resourceid, p));
       resourceid = p;
    }

    // resourcedescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isResourcedescrDirty()  { return checkFieldDirtiness(RESOURCEDESCR_DIRTYGROUP, RESOURCEDESCR_DIRTYMASK); }

    public java.lang.String   getResourcedescr()         { return resourcedescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "resourcedescr")
    public java.lang.String   getResourcedescrAsString() { return (resourcedescr == null) ? "" : resourcedescr; }

    // resourcedescr setter methods.
    
    protected void markResourcedescrAsDirty(boolean aFlag)  { markFieldAsDirty(RESOURCEDESCR_DIRTYGROUP, RESOURCEDESCR_DIRTYMASK, aFlag); }


    public void setResourcedescr(String  p)
    {
       setResourcedescr(p, DTOCasingStyle.none);
    }
    
    public void setResourcedescr(String  p, DTOCasingStyle casingStyle)
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
       markResourcedescrAsDirty(!equalsObject(resourcedescr, p));
       resourcedescr = p;
    }

    // teamid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTeamidDirty()  { return checkFieldDirtiness(TEAMID_DIRTYGROUP, TEAMID_DIRTYMASK); }

    public java.lang.String   getTeamid()         { return teamid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "teamid")
    public java.lang.String   getTeamidAsString() { return (teamid == null) ? "" : teamid; }

    // teamid setter methods.
    
    protected void markTeamidAsDirty(boolean aFlag)  { markFieldAsDirty(TEAMID_DIRTYGROUP, TEAMID_DIRTYMASK, aFlag); }


    public void setTeamid(String  p)
    {
       setTeamid(p, DTOCasingStyle.none);
    }
    
    public void setTeamid(String  p, DTOCasingStyle casingStyle)
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
       markTeamidAsDirty(!equalsObject(teamid, p));
       teamid = p;
    }

    // teamperiod getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTeamperiodDirty()  { return checkFieldDirtiness(TEAMPERIOD_DIRTYGROUP, TEAMPERIOD_DIRTYMASK); }

    public java.lang.Integer   getTeamperiod() { return teamperiod; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "teamperiod")
    public String getTeamperiodAsString() { return integerAsString(teamperiod); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getTeamperiodAsInt()    { return teamperiod != null ? teamperiod.intValue() : 0; }

    // teamperiod setter methods.
    
    protected void markTeamperiodAsDirty(boolean aFlag)  { markFieldAsDirty(TEAMPERIOD_DIRTYGROUP, TEAMPERIOD_DIRTYMASK, aFlag); }


    public void setTeamperiod(java.lang.Integer  p)
    {
        markTeamperiodAsDirty(!equalsObject(teamperiod, p));
    	teamperiod = p;
    }
    public void setTeamperiod(int p)
    {
    	setTeamperiod(new java.lang.Integer(p));
    }
    public void setTeamperiod()
    {
    	setTeamperiod(0);
    }
    public void setTeamperiod(String  p)
    {
    	setTeamperiod(stringAsInteger(p));
    }

    // profileid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isProfileidDirty()  { return checkFieldDirtiness(PROFILEID_DIRTYGROUP, PROFILEID_DIRTYMASK); }

    public java.lang.String   getProfileid()         { return profileid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "profileid")
    public java.lang.String   getProfileidAsString() { return (profileid == null) ? "" : profileid; }

    // profileid setter methods.
    
    protected void markProfileidAsDirty(boolean aFlag)  { markFieldAsDirty(PROFILEID_DIRTYGROUP, PROFILEID_DIRTYMASK, aFlag); }


    public void setProfileid(String  p)
    {
       setProfileid(p, DTOCasingStyle.none);
    }
    
    public void setProfileid(String  p, DTOCasingStyle casingStyle)
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
       markProfileidAsDirty(!equalsObject(profileid, p));
       profileid = p;
    }

    // companyid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompanyidDirty()  { return checkFieldDirtiness(COMPANYID_DIRTYGROUP, COMPANYID_DIRTYMASK); }

    public java.lang.String   getCompanyid()         { return companyid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "companyid")
    public java.lang.String   getCompanyidAsString() { return (companyid == null) ? "" : companyid; }

    // companyid setter methods.
    
    protected void markCompanyidAsDirty(boolean aFlag)  { markFieldAsDirty(COMPANYID_DIRTYGROUP, COMPANYID_DIRTYMASK, aFlag); }


    public void setCompanyid(String  p)
    {
       setCompanyid(p, DTOCasingStyle.none);
    }
    
    public void setCompanyid(String  p, DTOCasingStyle casingStyle)
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
       markCompanyidAsDirty(!equalsObject(companyid, p));
       companyid = p;
    }

    // costcenter1 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCostcenter1Dirty()  { return checkFieldDirtiness(COSTCENTER1_DIRTYGROUP, COSTCENTER1_DIRTYMASK); }

    public java.lang.String   getCostcenter1()         { return costcenter1; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "costcenter1")
    public java.lang.String   getCostcenter1AsString() { return (costcenter1 == null) ? "" : costcenter1; }

    // costcenter1 setter methods.
    
    protected void markCostcenter1AsDirty(boolean aFlag)  { markFieldAsDirty(COSTCENTER1_DIRTYGROUP, COSTCENTER1_DIRTYMASK, aFlag); }


    public void setCostcenter1(String  p)
    {
       setCostcenter1(p, DTOCasingStyle.none);
    }
    
    public void setCostcenter1(String  p, DTOCasingStyle casingStyle)
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
       markCostcenter1AsDirty(!equalsObject(costcenter1, p));
       costcenter1 = p;
    }

    // costcenter2 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCostcenter2Dirty()  { return checkFieldDirtiness(COSTCENTER2_DIRTYGROUP, COSTCENTER2_DIRTYMASK); }

    public java.lang.String   getCostcenter2()         { return costcenter2; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "costcenter2")
    public java.lang.String   getCostcenter2AsString() { return (costcenter2 == null) ? "" : costcenter2; }

    // costcenter2 setter methods.
    
    protected void markCostcenter2AsDirty(boolean aFlag)  { markFieldAsDirty(COSTCENTER2_DIRTYGROUP, COSTCENTER2_DIRTYMASK, aFlag); }


    public void setCostcenter2(String  p)
    {
       setCostcenter2(p, DTOCasingStyle.none);
    }
    
    public void setCostcenter2(String  p, DTOCasingStyle casingStyle)
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
       markCostcenter2AsDirty(!equalsObject(costcenter2, p));
       costcenter2 = p;
    }

    // costcenter3 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCostcenter3Dirty()  { return checkFieldDirtiness(COSTCENTER3_DIRTYGROUP, COSTCENTER3_DIRTYMASK); }

    public java.lang.String   getCostcenter3()         { return costcenter3; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "costcenter3")
    public java.lang.String   getCostcenter3AsString() { return (costcenter3 == null) ? "" : costcenter3; }

    // costcenter3 setter methods.
    
    protected void markCostcenter3AsDirty(boolean aFlag)  { markFieldAsDirty(COSTCENTER3_DIRTYGROUP, COSTCENTER3_DIRTYMASK, aFlag); }


    public void setCostcenter3(String  p)
    {
       setCostcenter3(p, DTOCasingStyle.none);
    }
    
    public void setCostcenter3(String  p, DTOCasingStyle casingStyle)
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
       markCostcenter3AsDirty(!equalsObject(costcenter3, p));
       costcenter3 = p;
    }

    // uniteffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUniteffortDirty()  { return checkFieldDirtiness(UNITEFFORT_DIRTYGROUP, UNITEFFORT_DIRTYMASK); }

    public java.lang.String   getUniteffort()         { return uniteffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "uniteffort")
    public java.lang.String   getUniteffortAsString() { return (uniteffort == null) ? "" : uniteffort; }

    // uniteffort setter methods.
    
    protected void markUniteffortAsDirty(boolean aFlag)  { markFieldAsDirty(UNITEFFORT_DIRTYGROUP, UNITEFFORT_DIRTYMASK, aFlag); }


    public void setUniteffort(String  p)
    {
       setUniteffort(p, DTOCasingStyle.none);
    }
    
    public void setUniteffort(String  p, DTOCasingStyle casingStyle)
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
       markUniteffortAsDirty(!equalsObject(uniteffort, p));
       uniteffort = p;
    }

    // ordeffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOrdeffortDirty()  { return checkFieldDirtiness(ORDEFFORT_DIRTYGROUP, ORDEFFORT_DIRTYMASK); }

    public java.lang.Integer   getOrdeffort() { return ordeffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "ordeffort")
    public String getOrdeffortAsString() { return integerAsString(ordeffort); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getOrdeffortAsInt()    { return ordeffort != null ? ordeffort.intValue() : 0; }

    // ordeffort setter methods.
    
    protected void markOrdeffortAsDirty(boolean aFlag)  { markFieldAsDirty(ORDEFFORT_DIRTYGROUP, ORDEFFORT_DIRTYMASK, aFlag); }


    public void setOrdeffort(java.lang.Integer  p)
    {
        markOrdeffortAsDirty(!equalsObject(ordeffort, p));
    	ordeffort = p;
    }
    public void setOrdeffort(int p)
    {
    	setOrdeffort(new java.lang.Integer(p));
    }
    public void setOrdeffort()
    {
    	setOrdeffort(0);
    }
    public void setOrdeffort(String  p)
    {
    	setOrdeffort(stringAsInteger(p));
    }

    // exteffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isExteffortDirty()  { return checkFieldDirtiness(EXTEFFORT_DIRTYGROUP, EXTEFFORT_DIRTYMASK); }

    public java.lang.Integer   getExteffort() { return exteffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "exteffort")
    public String getExteffortAsString() { return integerAsString(exteffort); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getExteffortAsInt()    { return exteffort != null ? exteffort.intValue() : 0; }

    // exteffort setter methods.
    
    protected void markExteffortAsDirty(boolean aFlag)  { markFieldAsDirty(EXTEFFORT_DIRTYGROUP, EXTEFFORT_DIRTYMASK, aFlag); }


    public void setExteffort(java.lang.Integer  p)
    {
        markExteffortAsDirty(!equalsObject(exteffort, p));
    	exteffort = p;
    }
    public void setExteffort(int p)
    {
    	setExteffort(new java.lang.Integer(p));
    }
    public void setExteffort()
    {
    	setExteffort(0);
    }
    public void setExteffort(String  p)
    {
    	setExteffort(stringAsInteger(p));
    }

    // oncalleffort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOncalleffortDirty()  { return checkFieldDirtiness(ONCALLEFFORT_DIRTYGROUP, ONCALLEFFORT_DIRTYMASK); }

    public java.lang.Integer   getOncalleffort() { return oncalleffort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "oncalleffort")
    public String getOncalleffortAsString() { return integerAsString(oncalleffort); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getOncalleffortAsInt()    { return oncalleffort != null ? oncalleffort.intValue() : 0; }

    // oncalleffort setter methods.
    
    protected void markOncalleffortAsDirty(boolean aFlag)  { markFieldAsDirty(ONCALLEFFORT_DIRTYGROUP, ONCALLEFFORT_DIRTYMASK, aFlag); }


    public void setOncalleffort(java.lang.Integer  p)
    {
        markOncalleffortAsDirty(!equalsObject(oncalleffort, p));
    	oncalleffort = p;
    }
    public void setOncalleffort(int p)
    {
    	setOncalleffort(new java.lang.Integer(p));
    }
    public void setOncalleffort()
    {
    	setOncalleffort(0);
    }
    public void setOncalleffort(String  p)
    {
    	setOncalleffort(stringAsInteger(p));
    }

    // price getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPriceDirty()  { return checkFieldDirtiness(PRICE_DIRTYGROUP, PRICE_DIRTYMASK); }

    public java.lang.Float   getPrice() { return price; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "price")
    public String getPriceAsString() { return floatAsString(price); }

    // price setter methods.
    
    protected void markPriceAsDirty(boolean aFlag)  { markFieldAsDirty(PRICE_DIRTYGROUP, PRICE_DIRTYMASK, aFlag); }


    public void setPrice(java.lang.Float  p)
    {
    	markPriceAsDirty(!equalsObject(price, p));
    	price = p;
    }
    public void setPrice()
    {
    	setPrice((java.lang.Float)null);
    }
    public void setPrice(String  p)
    {
    	setPrice(stringAsFloat(p));
    }

    // cost getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCostDirty()  { return checkFieldDirtiness(COST_DIRTYGROUP, COST_DIRTYMASK); }

    public java.lang.Float   getCost() { return cost; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cost")
    public String getCostAsString() { return floatAsString(cost); }

    // cost setter methods.
    
    protected void markCostAsDirty(boolean aFlag)  { markFieldAsDirty(COST_DIRTYGROUP, COST_DIRTYMASK, aFlag); }


    public void setCost(java.lang.Float  p)
    {
    	markCostAsDirty(!equalsObject(cost, p));
    	cost = p;
    }
    public void setCost()
    {
    	setCost((java.lang.Float)null);
    }
    public void setCost(String  p)
    {
    	setCost(stringAsFloat(p));
    }

    // evalueunit getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEvalueunitDirty()  { return checkFieldDirtiness(EVALUEUNIT_DIRTYGROUP, EVALUEUNIT_DIRTYMASK); }

    public java.lang.String   getEvalueunit()         { return evalueunit; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "evalueunit")
    public java.lang.String   getEvalueunitAsString() { return (evalueunit == null) ? "" : evalueunit; }

    // evalueunit setter methods.
    
    protected void markEvalueunitAsDirty(boolean aFlag)  { markFieldAsDirty(EVALUEUNIT_DIRTYGROUP, EVALUEUNIT_DIRTYMASK, aFlag); }


    public void setEvalueunit(String  p)
    {
       setEvalueunit(p, DTOCasingStyle.none);
    }
    
    public void setEvalueunit(String  p, DTOCasingStyle casingStyle)
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
       markEvalueunitAsDirty(!equalsObject(evalueunit, p));
       evalueunit = p;
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

    // tseuserid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTseuseridDirty()  { return checkFieldDirtiness(TSEUSERID_DIRTYGROUP, TSEUSERID_DIRTYMASK); }

    public java.lang.String   getTseuserid()         { return tseuserid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "tseuserid")
    public java.lang.String   getTseuseridAsString() { return (tseuserid == null) ? "" : tseuserid; }

    // tseuserid setter methods.
    
    protected void markTseuseridAsDirty(boolean aFlag)  { markFieldAsDirty(TSEUSERID_DIRTYGROUP, TSEUSERID_DIRTYMASK, aFlag); }


    public void setTseuserid(String  p)
    {
       setTseuserid(p, DTOCasingStyle.none);
    }
    
    public void setTseuserid(String  p, DTOCasingStyle casingStyle)
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
       markTseuseridAsDirty(!equalsObject(tseuserid, p));
       tseuserid = p;
    }

}
