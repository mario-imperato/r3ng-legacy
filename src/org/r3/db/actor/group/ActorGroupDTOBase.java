//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.group;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ActorGroupDTOBase")
public class ActorGroupDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  groupid;
    protected java.lang.String  grouptitle;
    protected java.lang.String  groupnature;
    protected java.lang.String  grouptype;
    protected java.lang.String  groupprofile;
    protected java.lang.String  businesskey;
    protected java.lang.Integer  grouporder;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String GROUPID_DEFAULT  =  null;
    public static final java.lang.String GROUPTITLE_DEFAULT  =  null;
    public static final java.lang.String GROUPNATURE_DEFAULT  =  null;
    public static final java.lang.String GROUPTYPE_DEFAULT  =  null;
    public static final java.lang.String GROUPPROFILE_DEFAULT  =  null;
    public static final java.lang.String BUSINESSKEY_DEFAULT  =  null;
    public static final java.lang.Integer GROUPORDER_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int GROUPID_DIRTYGROUP  =  0;
    public static final int GROUPID_DIRTYMASK   =  2;
    public static final int GROUPTITLE_DIRTYGROUP  =  0;
    public static final int GROUPTITLE_DIRTYMASK   =  4;
    public static final int GROUPNATURE_DIRTYGROUP  =  0;
    public static final int GROUPNATURE_DIRTYMASK   =  8;
    public static final int GROUPTYPE_DIRTYGROUP  =  0;
    public static final int GROUPTYPE_DIRTYMASK   =  16;
    public static final int GROUPPROFILE_DIRTYGROUP  =  0;
    public static final int GROUPPROFILE_DIRTYMASK   =  32;
    public static final int BUSINESSKEY_DIRTYGROUP  =  0;
    public static final int BUSINESSKEY_DIRTYMASK   =  64;
    public static final int GROUPORDER_DIRTYGROUP  =  0;
    public static final int GROUPORDER_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public ActorGroupDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       groupid = GROUPID_DEFAULT;
       grouptitle = GROUPTITLE_DEFAULT;
       groupnature = GROUPNATURE_DEFAULT;
       grouptype = GROUPTYPE_DEFAULT;
       groupprofile = GROUPPROFILE_DEFAULT;
       businesskey = BUSINESSKEY_DEFAULT;
       grouporder = GROUPORDER_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ActorGroupDTOBase(ActorGroupDTOBase another)
    {

       eventid = another.getEventid();
       groupid = another.getGroupid();
       grouptitle = another.getGrouptitle();
       groupnature = another.getGroupnature();
       grouptype = another.getGrouptype();
       groupprofile = another.getGroupprofile();
       businesskey = another.getBusinesskey();
       grouporder = another.getGrouporder();

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
        stb.append(groupid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (grouptitle != null)
        {
        stb.append(grouptitle);
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

    // groupid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGroupidDirty()  { return checkFieldDirtiness(GROUPID_DIRTYGROUP, GROUPID_DIRTYMASK); }

    public java.lang.String   getGroupid()         { return groupid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "groupid")
    public java.lang.String   getGroupidAsString() { return (groupid == null) ? "" : groupid; }

    // groupid setter methods.
    
    protected void markGroupidAsDirty(boolean aFlag)  { markFieldAsDirty(GROUPID_DIRTYGROUP, GROUPID_DIRTYMASK, aFlag); }


    public void setGroupid(String  p)
    {
       setGroupid(p, DTOCasingStyle.none);
    }
    
    public void setGroupid(String  p, DTOCasingStyle casingStyle)
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
       markGroupidAsDirty(!equalsObject(groupid, p));
       groupid = p;
    }

    // grouptitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGrouptitleDirty()  { return checkFieldDirtiness(GROUPTITLE_DIRTYGROUP, GROUPTITLE_DIRTYMASK); }

    public java.lang.String   getGrouptitle()         { return grouptitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "grouptitle")
    public java.lang.String   getGrouptitleAsString() { return (grouptitle == null) ? "" : grouptitle; }

    // grouptitle setter methods.
    
    protected void markGrouptitleAsDirty(boolean aFlag)  { markFieldAsDirty(GROUPTITLE_DIRTYGROUP, GROUPTITLE_DIRTYMASK, aFlag); }


    public void setGrouptitle(String  p)
    {
       setGrouptitle(p, DTOCasingStyle.none);
    }
    
    public void setGrouptitle(String  p, DTOCasingStyle casingStyle)
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
       markGrouptitleAsDirty(!equalsObject(grouptitle, p));
       grouptitle = p;
    }

    // groupnature getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGroupnatureDirty()  { return checkFieldDirtiness(GROUPNATURE_DIRTYGROUP, GROUPNATURE_DIRTYMASK); }

    public java.lang.String   getGroupnature()         { return groupnature; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "groupnature")
    public java.lang.String   getGroupnatureAsString() { return (groupnature == null) ? "" : groupnature; }

    // groupnature setter methods.
    
    protected void markGroupnatureAsDirty(boolean aFlag)  { markFieldAsDirty(GROUPNATURE_DIRTYGROUP, GROUPNATURE_DIRTYMASK, aFlag); }


    public void setGroupnature(String  p)
    {
       setGroupnature(p, DTOCasingStyle.none);
    }
    
    public void setGroupnature(String  p, DTOCasingStyle casingStyle)
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
       markGroupnatureAsDirty(!equalsObject(groupnature, p));
       groupnature = p;
    }

    // grouptype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGrouptypeDirty()  { return checkFieldDirtiness(GROUPTYPE_DIRTYGROUP, GROUPTYPE_DIRTYMASK); }

    public java.lang.String   getGrouptype()         { return grouptype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "grouptype")
    public java.lang.String   getGrouptypeAsString() { return (grouptype == null) ? "" : grouptype; }

    // grouptype setter methods.
    
    protected void markGrouptypeAsDirty(boolean aFlag)  { markFieldAsDirty(GROUPTYPE_DIRTYGROUP, GROUPTYPE_DIRTYMASK, aFlag); }


    public void setGrouptype(String  p)
    {
       setGrouptype(p, DTOCasingStyle.none);
    }
    
    public void setGrouptype(String  p, DTOCasingStyle casingStyle)
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
       markGrouptypeAsDirty(!equalsObject(grouptype, p));
       grouptype = p;
    }

    // groupprofile getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGroupprofileDirty()  { return checkFieldDirtiness(GROUPPROFILE_DIRTYGROUP, GROUPPROFILE_DIRTYMASK); }

    public java.lang.String   getGroupprofile()         { return groupprofile; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "groupprofile")
    public java.lang.String   getGroupprofileAsString() { return (groupprofile == null) ? "" : groupprofile; }

    // groupprofile setter methods.
    
    protected void markGroupprofileAsDirty(boolean aFlag)  { markFieldAsDirty(GROUPPROFILE_DIRTYGROUP, GROUPPROFILE_DIRTYMASK, aFlag); }


    public void setGroupprofile(String  p)
    {
       setGroupprofile(p, DTOCasingStyle.none);
    }
    
    public void setGroupprofile(String  p, DTOCasingStyle casingStyle)
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
       markGroupprofileAsDirty(!equalsObject(groupprofile, p));
       groupprofile = p;
    }

    // businesskey getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBusinesskeyDirty()  { return checkFieldDirtiness(BUSINESSKEY_DIRTYGROUP, BUSINESSKEY_DIRTYMASK); }

    public java.lang.String   getBusinesskey()         { return businesskey; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "businesskey")
    public java.lang.String   getBusinesskeyAsString() { return (businesskey == null) ? "" : businesskey; }

    // businesskey setter methods.
    
    protected void markBusinesskeyAsDirty(boolean aFlag)  { markFieldAsDirty(BUSINESSKEY_DIRTYGROUP, BUSINESSKEY_DIRTYMASK, aFlag); }


    public void setBusinesskey(String  p)
    {
       setBusinesskey(p, DTOCasingStyle.none);
    }
    
    public void setBusinesskey(String  p, DTOCasingStyle casingStyle)
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
       markBusinesskeyAsDirty(!equalsObject(businesskey, p));
       businesskey = p;
    }

    // grouporder getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGrouporderDirty()  { return checkFieldDirtiness(GROUPORDER_DIRTYGROUP, GROUPORDER_DIRTYMASK); }

    public java.lang.Integer   getGrouporder() { return grouporder; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "grouporder")
    public String getGrouporderAsString() { return integerAsString(grouporder); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getGrouporderAsInt()    { return grouporder != null ? grouporder.intValue() : 0; }

    // grouporder setter methods.
    
    protected void markGrouporderAsDirty(boolean aFlag)  { markFieldAsDirty(GROUPORDER_DIRTYGROUP, GROUPORDER_DIRTYMASK, aFlag); }


    public void setGrouporder(java.lang.Integer  p)
    {
        markGrouporderAsDirty(!equalsObject(grouporder, p));
    	grouporder = p;
    }
    public void setGrouporder(int p)
    {
    	setGrouporder(new java.lang.Integer(p));
    }
    public void setGrouporder()
    {
    	setGrouporder(0);
    }
    public void setGrouporder(String  p)
    {
    	setGrouporder(stringAsInteger(p));
    }

}
