//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.team;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "TeamDTOBase")
public class TeamDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  teamid;
    protected java.lang.String  teamdescr;
    protected java.lang.Integer  periodindex;
    protected java.lang.String  periodtype;
    protected java.lang.String  teamstatus;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String TEAMID_DEFAULT  =  null;
    public static final java.lang.String TEAMDESCR_DEFAULT  =  null;
    public static final java.lang.Integer PERIODINDEX_DEFAULT  =  null;
    public static final java.lang.String PERIODTYPE_DEFAULT  =  null;
    public static final java.lang.String TEAMSTATUS_DEFAULT  =  null;

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


    /**
      * DataBean constructor.
      */
    public TeamDTOBase()
    {
       dirtyFlagsArray = new int[6 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       teamid = TEAMID_DEFAULT;
       teamdescr = TEAMDESCR_DEFAULT;
       periodindex = PERIODINDEX_DEFAULT;
       periodtype = PERIODTYPE_DEFAULT;
       teamstatus = TEAMSTATUS_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public TeamDTOBase(TeamDTOBase another)
    {

       site = another.getSite();
       teamid = another.getTeamid();
       teamdescr = another.getTeamdescr();
       periodindex = another.getPeriodindex();
       periodtype = another.getPeriodtype();
       teamstatus = another.getTeamstatus();

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
        stb.append(teamid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (teamdescr != null)
        {
        stb.append(teamdescr);
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

}
