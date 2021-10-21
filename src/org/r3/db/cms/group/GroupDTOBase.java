//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.group;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "GroupDTOBase")
public class GroupDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  groupid;
    protected java.lang.String  groupname;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String GROUPID_DEFAULT  =  null;
    public static final java.lang.String GROUPNAME_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int GROUPID_DIRTYGROUP  =  0;
    public static final int GROUPID_DIRTYMASK   =  2;
    public static final int GROUPNAME_DIRTYGROUP  =  0;
    public static final int GROUPNAME_DIRTYMASK   =  4;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  8;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  16;


    /**
      * DataBean constructor.
      */
    public GroupDTOBase()
    {
       dirtyFlagsArray = new int[5 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       groupid = GROUPID_DEFAULT;
       groupname = GROUPNAME_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public GroupDTOBase(GroupDTOBase another)
    {

       site = another.getSite();
       groupid = another.getGroupid();
       groupname = another.getGroupname();
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
        stb.append(site);
        stb.append(", ");
        stb.append(groupid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (groupname != null)
        {
        stb.append(groupname);
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

    // groupname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isGroupnameDirty()  { return checkFieldDirtiness(GROUPNAME_DIRTYGROUP, GROUPNAME_DIRTYMASK); }

    public java.lang.String   getGroupname()         { return groupname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "groupname")
    public java.lang.String   getGroupnameAsString() { return (groupname == null) ? "" : groupname; }

    // groupname setter methods.
    
    protected void markGroupnameAsDirty(boolean aFlag)  { markFieldAsDirty(GROUPNAME_DIRTYGROUP, GROUPNAME_DIRTYMASK, aFlag); }


    public void setGroupname(String  p)
    {
       setGroupname(p, DTOCasingStyle.none);
    }
    
    public void setGroupname(String  p, DTOCasingStyle casingStyle)
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
       markGroupnameAsDirty(!equalsObject(groupname, p));
       groupname = p;
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
