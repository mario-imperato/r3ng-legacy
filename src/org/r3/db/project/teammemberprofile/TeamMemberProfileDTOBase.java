//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teammemberprofile;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "TeamMemberProfileDTOBase")
public class TeamMemberProfileDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  profileid;
    protected java.lang.String  site;
    protected java.lang.String  teamid;
    protected java.lang.String  profiledescr;
    protected java.lang.String  skillprofile;
    protected java.lang.String  skillambit;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String PROFILEID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String TEAMID_DEFAULT  =  null;
    public static final java.lang.String PROFILEDESCR_DEFAULT  =  null;
    public static final java.lang.String SKILLPROFILE_DEFAULT  =  null;
    public static final java.lang.String SKILLAMBIT_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int PROFILEID_DIRTYGROUP  =  0;
    public static final int PROFILEID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int TEAMID_DIRTYGROUP  =  0;
    public static final int TEAMID_DIRTYMASK   =  4;
    public static final int PROFILEDESCR_DIRTYGROUP  =  0;
    public static final int PROFILEDESCR_DIRTYMASK   =  8;
    public static final int SKILLPROFILE_DIRTYGROUP  =  0;
    public static final int SKILLPROFILE_DIRTYMASK   =  16;
    public static final int SKILLAMBIT_DIRTYGROUP  =  0;
    public static final int SKILLAMBIT_DIRTYMASK   =  32;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  64;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public TeamMemberProfileDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       profileid = PROFILEID_DEFAULT;
       site = SITE_DEFAULT;
       teamid = TEAMID_DEFAULT;
       profiledescr = PROFILEDESCR_DEFAULT;
       skillprofile = SKILLPROFILE_DEFAULT;
       skillambit = SKILLAMBIT_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public TeamMemberProfileDTOBase(TeamMemberProfileDTOBase another)
    {

       profileid = another.getProfileid();
       site = another.getSite();
       teamid = another.getTeamid();
       profiledescr = another.getProfiledescr();
       skillprofile = another.getSkillprofile();
       skillambit = another.getSkillambit();
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
        stb.append(profileid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (profiledescr != null)
        {
        stb.append(profiledescr);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

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

    // profiledescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isProfiledescrDirty()  { return checkFieldDirtiness(PROFILEDESCR_DIRTYGROUP, PROFILEDESCR_DIRTYMASK); }

    public java.lang.String   getProfiledescr()         { return profiledescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "profiledescr")
    public java.lang.String   getProfiledescrAsString() { return (profiledescr == null) ? "" : profiledescr; }

    // profiledescr setter methods.
    
    protected void markProfiledescrAsDirty(boolean aFlag)  { markFieldAsDirty(PROFILEDESCR_DIRTYGROUP, PROFILEDESCR_DIRTYMASK, aFlag); }


    public void setProfiledescr(String  p)
    {
       setProfiledescr(p, DTOCasingStyle.none);
    }
    
    public void setProfiledescr(String  p, DTOCasingStyle casingStyle)
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
       markProfiledescrAsDirty(!equalsObject(profiledescr, p));
       profiledescr = p;
    }

    // skillprofile getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSkillprofileDirty()  { return checkFieldDirtiness(SKILLPROFILE_DIRTYGROUP, SKILLPROFILE_DIRTYMASK); }

    public java.lang.String   getSkillprofile()         { return skillprofile; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "skillprofile")
    public java.lang.String   getSkillprofileAsString() { return (skillprofile == null) ? "" : skillprofile; }

    // skillprofile setter methods.
    
    protected void markSkillprofileAsDirty(boolean aFlag)  { markFieldAsDirty(SKILLPROFILE_DIRTYGROUP, SKILLPROFILE_DIRTYMASK, aFlag); }


    public void setSkillprofile(String  p)
    {
       setSkillprofile(p, DTOCasingStyle.none);
    }
    
    public void setSkillprofile(String  p, DTOCasingStyle casingStyle)
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
       markSkillprofileAsDirty(!equalsObject(skillprofile, p));
       skillprofile = p;
    }

    // skillambit getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSkillambitDirty()  { return checkFieldDirtiness(SKILLAMBIT_DIRTYGROUP, SKILLAMBIT_DIRTYMASK); }

    public java.lang.String   getSkillambit()         { return skillambit; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "skillambit")
    public java.lang.String   getSkillambitAsString() { return (skillambit == null) ? "" : skillambit; }

    // skillambit setter methods.
    
    protected void markSkillambitAsDirty(boolean aFlag)  { markFieldAsDirty(SKILLAMBIT_DIRTYGROUP, SKILLAMBIT_DIRTYMASK, aFlag); }


    public void setSkillambit(String  p)
    {
       setSkillambit(p, DTOCasingStyle.none);
    }
    
    public void setSkillambit(String  p, DTOCasingStyle casingStyle)
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
       markSkillambitAsDirty(!equalsObject(skillambit, p));
       skillambit = p;
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

    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
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
