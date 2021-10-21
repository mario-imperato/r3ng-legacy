//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teamresourceview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "TeamResourceViewDTOBase")
public class TeamResourceViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  teamid;
    protected java.lang.String  teamdescr;
    protected java.lang.Integer  periodindex;
    protected java.lang.String  periodtype;
    protected java.lang.String  teamstatus;
    protected java.lang.String  resourceid;
    protected java.lang.String  resourcedescr;
    protected java.lang.String  profileid;
    protected java.lang.String  evalueunit;
    protected java.lang.Float  price;
    protected java.lang.Float  cost;
    protected java.lang.String  resourcedefstatus;
    protected java.lang.String  recstatus;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String TEAMID_DEFAULT  =  null;
    public static final java.lang.String TEAMDESCR_DEFAULT  =  null;
    public static final java.lang.Integer PERIODINDEX_DEFAULT  =  null;
    public static final java.lang.String PERIODTYPE_DEFAULT  =  null;
    public static final java.lang.String TEAMSTATUS_DEFAULT  =  null;
    public static final java.lang.String RESOURCEID_DEFAULT  =  null;
    public static final java.lang.String RESOURCEDESCR_DEFAULT  =  null;
    public static final java.lang.String PROFILEID_DEFAULT  =  null;
    public static final java.lang.String EVALUEUNIT_DEFAULT  =  null;
    public static final java.lang.Float PRICE_DEFAULT  =  null;
    public static final java.lang.Float COST_DEFAULT  =  null;
    public static final java.lang.String RESOURCEDEFSTATUS_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int TEAMID_DIRTYGROUP  =  0;
    public static final int TEAMID_DIRTYMASK   =  2;
    public static final int TEAMDESCR_DIRTYGROUP  =  0;
    public static final int TEAMDESCR_DIRTYMASK   =  4;
    public static final int PERIODINDEX_DIRTYGROUP  =  0;
    public static final int PERIODINDEX_DIRTYMASK   =  8;
    public static final int PERIODTYPE_DIRTYGROUP  =  0;
    public static final int PERIODTYPE_DIRTYMASK   =  16;
    public static final int TEAMSTATUS_DIRTYGROUP  =  0;
    public static final int TEAMSTATUS_DIRTYMASK   =  32;
    public static final int RESOURCEID_DIRTYGROUP  =  0;
    public static final int RESOURCEID_DIRTYMASK   =  64;
    public static final int RESOURCEDESCR_DIRTYGROUP  =  0;
    public static final int RESOURCEDESCR_DIRTYMASK   =  128;
    public static final int PROFILEID_DIRTYGROUP  =  0;
    public static final int PROFILEID_DIRTYMASK   =  256;
    public static final int EVALUEUNIT_DIRTYGROUP  =  0;
    public static final int EVALUEUNIT_DIRTYMASK   =  512;
    public static final int PRICE_DIRTYGROUP  =  0;
    public static final int PRICE_DIRTYMASK   =  1024;
    public static final int COST_DIRTYGROUP  =  0;
    public static final int COST_DIRTYMASK   =  2048;
    public static final int RESOURCEDEFSTATUS_DIRTYGROUP  =  0;
    public static final int RESOURCEDEFSTATUS_DIRTYMASK   =  4096;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  8192;


    /**
      * DataBean constructor.
      */
    public TeamResourceViewDTOBase()
    {
       dirtyFlagsArray = new int[14 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       teamid = TEAMID_DEFAULT;
       teamdescr = TEAMDESCR_DEFAULT;
       periodindex = PERIODINDEX_DEFAULT;
       periodtype = PERIODTYPE_DEFAULT;
       teamstatus = TEAMSTATUS_DEFAULT;
       resourceid = RESOURCEID_DEFAULT;
       resourcedescr = RESOURCEDESCR_DEFAULT;
       profileid = PROFILEID_DEFAULT;
       evalueunit = EVALUEUNIT_DEFAULT;
       price = PRICE_DEFAULT;
       cost = COST_DEFAULT;
       resourcedefstatus = RESOURCEDEFSTATUS_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public TeamResourceViewDTOBase(TeamResourceViewDTOBase another)
    {

       site = another.getSite();
       teamid = another.getTeamid();
       teamdescr = another.getTeamdescr();
       periodindex = another.getPeriodindex();
       periodtype = another.getPeriodtype();
       teamstatus = another.getTeamstatus();
       resourceid = another.getResourceid();
       resourcedescr = another.getResourcedescr();
       profileid = another.getProfileid();
       evalueunit = another.getEvalueunit();
       price = another.getPrice();
       cost = another.getCost();
       resourcedefstatus = another.getResourcedefstatus();
       recstatus = another.getRecstatus();

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

    // teamdescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTeamdescrDirty()  { return checkFieldDirtiness(TEAMDESCR_DIRTYGROUP, TEAMDESCR_DIRTYMASK); }

    public java.lang.String   getTeamdescr()         { return teamdescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "teamdescr")
    public java.lang.String   getTeamdescrAsString() { return (teamdescr == null) ? "" : teamdescr; }

    // teamdescr setter methods.
    
    protected void markTeamdescrAsDirty(boolean aFlag)  { markFieldAsDirty(TEAMDESCR_DIRTYGROUP, TEAMDESCR_DIRTYMASK, aFlag); }


    public void setTeamdescr(String  p)
    {
       setTeamdescr(p, DTOCasingStyle.none);
    }
    
    public void setTeamdescr(String  p, DTOCasingStyle casingStyle)
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
       markTeamdescrAsDirty(!equalsObject(teamdescr, p));
       teamdescr = p;
    }

    // periodindex getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPeriodindexDirty()  { return checkFieldDirtiness(PERIODINDEX_DIRTYGROUP, PERIODINDEX_DIRTYMASK); }

    public java.lang.Integer   getPeriodindex() { return periodindex; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "periodindex")
    public String getPeriodindexAsString() { return integerAsString(periodindex); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getPeriodindexAsInt()    { return periodindex != null ? periodindex.intValue() : 0; }

    // periodindex setter methods.
    
    protected void markPeriodindexAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODINDEX_DIRTYGROUP, PERIODINDEX_DIRTYMASK, aFlag); }


    public void setPeriodindex(java.lang.Integer  p)
    {
        markPeriodindexAsDirty(!equalsObject(periodindex, p));
    	periodindex = p;
    }
    public void setPeriodindex(int p)
    {
    	setPeriodindex(new java.lang.Integer(p));
    }
    public void setPeriodindex()
    {
    	setPeriodindex(0);
    }
    public void setPeriodindex(String  p)
    {
    	setPeriodindex(stringAsInteger(p));
    }

    // periodtype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPeriodtypeDirty()  { return checkFieldDirtiness(PERIODTYPE_DIRTYGROUP, PERIODTYPE_DIRTYMASK); }

    public java.lang.String   getPeriodtype()         { return periodtype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "periodtype")
    public java.lang.String   getPeriodtypeAsString() { return (periodtype == null) ? "" : periodtype; }

    // periodtype setter methods.
    
    protected void markPeriodtypeAsDirty(boolean aFlag)  { markFieldAsDirty(PERIODTYPE_DIRTYGROUP, PERIODTYPE_DIRTYMASK, aFlag); }


    public void setPeriodtype(String  p)
    {
       setPeriodtype(p, DTOCasingStyle.none);
    }
    
    public void setPeriodtype(String  p, DTOCasingStyle casingStyle)
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
       markPeriodtypeAsDirty(!equalsObject(periodtype, p));
       periodtype = p;
    }

    // teamstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTeamstatusDirty()  { return checkFieldDirtiness(TEAMSTATUS_DIRTYGROUP, TEAMSTATUS_DIRTYMASK); }

    public java.lang.String   getTeamstatus()         { return teamstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "teamstatus")
    public java.lang.String   getTeamstatusAsString() { return (teamstatus == null) ? "" : teamstatus; }

    // teamstatus setter methods.
    
    protected void markTeamstatusAsDirty(boolean aFlag)  { markFieldAsDirty(TEAMSTATUS_DIRTYGROUP, TEAMSTATUS_DIRTYMASK, aFlag); }


    public void setTeamstatus(String  p)
    {
       setTeamstatus(p, DTOCasingStyle.none);
    }
    
    public void setTeamstatus(String  p, DTOCasingStyle casingStyle)
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
       markTeamstatusAsDirty(!equalsObject(teamstatus, p));
       teamstatus = p;
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

    // resourcedefstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isResourcedefstatusDirty()  { return checkFieldDirtiness(RESOURCEDEFSTATUS_DIRTYGROUP, RESOURCEDEFSTATUS_DIRTYMASK); }

    public java.lang.String   getResourcedefstatus()         { return resourcedefstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "resourcedefstatus")
    public java.lang.String   getResourcedefstatusAsString() { return (resourcedefstatus == null) ? "" : resourcedefstatus; }

    // resourcedefstatus setter methods.
    
    protected void markResourcedefstatusAsDirty(boolean aFlag)  { markFieldAsDirty(RESOURCEDEFSTATUS_DIRTYGROUP, RESOURCEDEFSTATUS_DIRTYMASK, aFlag); }


    public void setResourcedefstatus(String  p)
    {
       setResourcedefstatus(p, DTOCasingStyle.none);
    }
    
    public void setResourcedefstatus(String  p, DTOCasingStyle casingStyle)
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
       markResourcedefstatusAsDirty(!equalsObject(resourcedefstatus, p));
       resourcedefstatus = p;
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

}
