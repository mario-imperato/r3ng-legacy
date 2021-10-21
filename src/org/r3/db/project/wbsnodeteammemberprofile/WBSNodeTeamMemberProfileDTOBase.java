//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.wbsnodeteammemberprofile;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "WBSNodeTeamMemberProfileDTOBase")
public class WBSNodeTeamMemberProfileDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  profileid;
    protected java.lang.String  wbsnodeid;
    protected java.lang.Float  effort;
    protected java.lang.String  uniteffort;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String PROFILEID_DEFAULT  =  null;
    public static final java.lang.String WBSNODEID_DEFAULT  =  null;
    public static final java.lang.Float EFFORT_DEFAULT  =  null;
    public static final java.lang.String UNITEFFORT_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int PROFILEID_DIRTYGROUP  =  0;
    public static final int PROFILEID_DIRTYMASK   =  1;
    public static final int WBSNODEID_DIRTYGROUP  =  0;
    public static final int WBSNODEID_DIRTYMASK   =  2;
    public static final int EFFORT_DIRTYGROUP  =  0;
    public static final int EFFORT_DIRTYMASK   =  4;
    public static final int UNITEFFORT_DIRTYGROUP  =  0;
    public static final int UNITEFFORT_DIRTYMASK   =  8;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  16;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  32;


    /**
      * DataBean constructor.
      */
    public WBSNodeTeamMemberProfileDTOBase()
    {
       dirtyFlagsArray = new int[6 / 30 + 1];
       clearDirtyFlags();

       profileid = PROFILEID_DEFAULT;
       wbsnodeid = WBSNODEID_DEFAULT;
       effort = EFFORT_DEFAULT;
       uniteffort = UNITEFFORT_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public WBSNodeTeamMemberProfileDTOBase(WBSNodeTeamMemberProfileDTOBase another)
    {

       profileid = another.getProfileid();
       wbsnodeid = another.getWbsnodeid();
       effort = another.getEffort();
       uniteffort = another.getUniteffort();
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
        stb.append(", ");
        stb.append(wbsnodeid);
        return stb.toString();
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

    // wbsnodeid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWbsnodeidDirty()  { return checkFieldDirtiness(WBSNODEID_DIRTYGROUP, WBSNODEID_DIRTYMASK); }

    public java.lang.String   getWbsnodeid()         { return wbsnodeid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "wbsnodeid")
    public java.lang.String   getWbsnodeidAsString() { return (wbsnodeid == null) ? "" : wbsnodeid; }

    // wbsnodeid setter methods.
    
    protected void markWbsnodeidAsDirty(boolean aFlag)  { markFieldAsDirty(WBSNODEID_DIRTYGROUP, WBSNODEID_DIRTYMASK, aFlag); }


    public void setWbsnodeid(String  p)
    {
       setWbsnodeid(p, DTOCasingStyle.none);
    }
    
    public void setWbsnodeid(String  p, DTOCasingStyle casingStyle)
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
       markWbsnodeidAsDirty(!equalsObject(wbsnodeid, p));
       wbsnodeid = p;
    }

    // effort getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEffortDirty()  { return checkFieldDirtiness(EFFORT_DIRTYGROUP, EFFORT_DIRTYMASK); }

    public java.lang.Float   getEffort() { return effort; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "effort")
    public String getEffortAsString() { return floatAsString(effort); }

    // effort setter methods.
    
    protected void markEffortAsDirty(boolean aFlag)  { markFieldAsDirty(EFFORT_DIRTYGROUP, EFFORT_DIRTYMASK, aFlag); }


    public void setEffort(java.lang.Float  p)
    {
    	markEffortAsDirty(!equalsObject(effort, p));
    	effort = p;
    }
    public void setEffort()
    {
    	setEffort((java.lang.Float)null);
    }
    public void setEffort(String  p)
    {
    	setEffort(stringAsFloat(p));
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
