//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.event;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SailEventDTOBase")
public class SailEventDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  eventtitle;
    protected java.lang.String  eventdescr;
    protected java.lang.String  eventgroup;
    protected java.lang.String  eventstatus;
    protected java.lang.String  applicationstatus;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String EVENTTITLE_DEFAULT  =  null;
    public static final java.lang.String EVENTDESCR_DEFAULT  =  null;
    public static final java.lang.String EVENTGROUP_DEFAULT  =  null;
    public static final java.lang.String EVENTSTATUS_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONSTATUS_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int EVENTTITLE_DIRTYGROUP  =  0;
    public static final int EVENTTITLE_DIRTYMASK   =  2;
    public static final int EVENTDESCR_DIRTYGROUP  =  0;
    public static final int EVENTDESCR_DIRTYMASK   =  4;
    public static final int EVENTGROUP_DIRTYGROUP  =  0;
    public static final int EVENTGROUP_DIRTYMASK   =  8;
    public static final int EVENTSTATUS_DIRTYGROUP  =  0;
    public static final int EVENTSTATUS_DIRTYMASK   =  16;
    public static final int APPLICATIONSTATUS_DIRTYGROUP  =  0;
    public static final int APPLICATIONSTATUS_DIRTYMASK   =  32;


    /**
      * DataBean constructor.
      */
    public SailEventDTOBase()
    {
       dirtyFlagsArray = new int[6 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       eventtitle = EVENTTITLE_DEFAULT;
       eventdescr = EVENTDESCR_DEFAULT;
       eventgroup = EVENTGROUP_DEFAULT;
       eventstatus = EVENTSTATUS_DEFAULT;
       applicationstatus = APPLICATIONSTATUS_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailEventDTOBase(SailEventDTOBase another)
    {

       eventid = another.getEventid();
       eventtitle = another.getEventtitle();
       eventdescr = another.getEventdescr();
       eventgroup = another.getEventgroup();
       eventstatus = another.getEventstatus();
       applicationstatus = another.getApplicationstatus();

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
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (eventtitle != null)
        {
        stb.append(eventtitle);
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

    // eventtitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventtitleDirty()  { return checkFieldDirtiness(EVENTTITLE_DIRTYGROUP, EVENTTITLE_DIRTYMASK); }

    public java.lang.String   getEventtitle()         { return eventtitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "eventtitle")
    public java.lang.String   getEventtitleAsString() { return (eventtitle == null) ? "" : eventtitle; }

    // eventtitle setter methods.
    
    protected void markEventtitleAsDirty(boolean aFlag)  { markFieldAsDirty(EVENTTITLE_DIRTYGROUP, EVENTTITLE_DIRTYMASK, aFlag); }


    public void setEventtitle(String  p)
    {
       setEventtitle(p, DTOCasingStyle.none);
    }
    
    public void setEventtitle(String  p, DTOCasingStyle casingStyle)
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
       markEventtitleAsDirty(!equalsObject(eventtitle, p));
       eventtitle = p;
    }

    // eventdescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventdescrDirty()  { return checkFieldDirtiness(EVENTDESCR_DIRTYGROUP, EVENTDESCR_DIRTYMASK); }

    public java.lang.String   getEventdescr()         { return eventdescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "eventdescr")
    public java.lang.String   getEventdescrAsString() { return (eventdescr == null) ? "" : eventdescr; }

    // eventdescr setter methods.
    
    protected void markEventdescrAsDirty(boolean aFlag)  { markFieldAsDirty(EVENTDESCR_DIRTYGROUP, EVENTDESCR_DIRTYMASK, aFlag); }


    public void setEventdescr(String  p)
    {
       setEventdescr(p, DTOCasingStyle.none);
    }
    
    public void setEventdescr(String  p, DTOCasingStyle casingStyle)
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
       markEventdescrAsDirty(!equalsObject(eventdescr, p));
       eventdescr = p;
    }

    // eventgroup getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventgroupDirty()  { return checkFieldDirtiness(EVENTGROUP_DIRTYGROUP, EVENTGROUP_DIRTYMASK); }

    public java.lang.String   getEventgroup()         { return eventgroup; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "eventgroup")
    public java.lang.String   getEventgroupAsString() { return (eventgroup == null) ? "" : eventgroup; }

    // eventgroup setter methods.
    
    protected void markEventgroupAsDirty(boolean aFlag)  { markFieldAsDirty(EVENTGROUP_DIRTYGROUP, EVENTGROUP_DIRTYMASK, aFlag); }


    public void setEventgroup(String  p)
    {
       setEventgroup(p, DTOCasingStyle.none);
    }
    
    public void setEventgroup(String  p, DTOCasingStyle casingStyle)
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
       markEventgroupAsDirty(!equalsObject(eventgroup, p));
       eventgroup = p;
    }

    // eventstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventstatusDirty()  { return checkFieldDirtiness(EVENTSTATUS_DIRTYGROUP, EVENTSTATUS_DIRTYMASK); }

    public java.lang.String   getEventstatus()         { return eventstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "eventstatus")
    public java.lang.String   getEventstatusAsString() { return (eventstatus == null) ? "" : eventstatus; }

    // eventstatus setter methods.
    
    protected void markEventstatusAsDirty(boolean aFlag)  { markFieldAsDirty(EVENTSTATUS_DIRTYGROUP, EVENTSTATUS_DIRTYMASK, aFlag); }


    public void setEventstatus(String  p)
    {
       setEventstatus(p, DTOCasingStyle.none);
    }
    
    public void setEventstatus(String  p, DTOCasingStyle casingStyle)
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
       markEventstatusAsDirty(!equalsObject(eventstatus, p));
       eventstatus = p;
    }

    // applicationstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isApplicationstatusDirty()  { return checkFieldDirtiness(APPLICATIONSTATUS_DIRTYGROUP, APPLICATIONSTATUS_DIRTYMASK); }

    public java.lang.String   getApplicationstatus()         { return applicationstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "applicationstatus")
    public java.lang.String   getApplicationstatusAsString() { return (applicationstatus == null) ? "" : applicationstatus; }

    // applicationstatus setter methods.
    
    protected void markApplicationstatusAsDirty(boolean aFlag)  { markFieldAsDirty(APPLICATIONSTATUS_DIRTYGROUP, APPLICATIONSTATUS_DIRTYMASK, aFlag); }


    public void setApplicationstatus(String  p)
    {
       setApplicationstatus(p, DTOCasingStyle.none);
    }
    
    public void setApplicationstatus(String  p, DTOCasingStyle casingStyle)
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
       markApplicationstatusAsDirty(!equalsObject(applicationstatus, p));
       applicationstatus = p;
    }

}
