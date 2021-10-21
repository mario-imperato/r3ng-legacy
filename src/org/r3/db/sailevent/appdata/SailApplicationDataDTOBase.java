//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appdata;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SailApplicationDataDTOBase")
public class SailApplicationDataDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;
    protected java.lang.String  sectionid;
    protected java.lang.String  paramname;
    protected java.lang.String  paramvalue;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONID_DEFAULT  =  null;
    public static final java.lang.String SECTIONID_DEFAULT  =  null;
    public static final java.lang.String PARAMNAME_DEFAULT  =  null;
    public static final java.lang.String PARAMVALUE_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int APPLICATIONID_DIRTYGROUP  =  0;
    public static final int APPLICATIONID_DIRTYMASK   =  2;
    public static final int SECTIONID_DIRTYGROUP  =  0;
    public static final int SECTIONID_DIRTYMASK   =  4;
    public static final int PARAMNAME_DIRTYGROUP  =  0;
    public static final int PARAMNAME_DIRTYMASK   =  8;
    public static final int PARAMVALUE_DIRTYGROUP  =  0;
    public static final int PARAMVALUE_DIRTYMASK   =  16;


    /**
      * DataBean constructor.
      */
    public SailApplicationDataDTOBase()
    {
       dirtyFlagsArray = new int[5 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       applicationid = APPLICATIONID_DEFAULT;
       sectionid = SECTIONID_DEFAULT;
       paramname = PARAMNAME_DEFAULT;
       paramvalue = PARAMVALUE_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailApplicationDataDTOBase(SailApplicationDataDTOBase another)
    {

       eventid = another.getEventid();
       applicationid = another.getApplicationid();
       sectionid = another.getSectionid();
       paramname = another.getParamname();
       paramvalue = another.getParamvalue();

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
        stb.append(applicationid);
        stb.append(", ");
        stb.append(sectionid);
        stb.append(", ");
        stb.append(paramname);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (paramvalue != null)
        {
        stb.append(paramvalue);
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

    // applicationid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isApplicationidDirty()  { return checkFieldDirtiness(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK); }

    public java.lang.String   getApplicationid()         { return applicationid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getApplicationidAsString() { return (applicationid == null) ? "" : applicationid; }

    // applicationid setter methods.
    
    protected void markApplicationidAsDirty(boolean aFlag)  { markFieldAsDirty(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK, aFlag); }


    public void setApplicationid(String  p)
    {
       setApplicationid(p, DTOCasingStyle.none);
    }
    
    public void setApplicationid(String  p, DTOCasingStyle casingStyle)
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
       markApplicationidAsDirty(!equalsObject(applicationid, p));
       applicationid = p;
    }

    // sectionid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSectionidDirty()  { return checkFieldDirtiness(SECTIONID_DIRTYGROUP, SECTIONID_DIRTYMASK); }

    public java.lang.String   getSectionid()         { return sectionid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSectionidAsString() { return (sectionid == null) ? "" : sectionid; }

    // sectionid setter methods.
    
    protected void markSectionidAsDirty(boolean aFlag)  { markFieldAsDirty(SECTIONID_DIRTYGROUP, SECTIONID_DIRTYMASK, aFlag); }


    public void setSectionid(String  p)
    {
       setSectionid(p, DTOCasingStyle.none);
    }
    
    public void setSectionid(String  p, DTOCasingStyle casingStyle)
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
       markSectionidAsDirty(!equalsObject(sectionid, p));
       sectionid = p;
    }

    // paramname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isParamnameDirty()  { return checkFieldDirtiness(PARAMNAME_DIRTYGROUP, PARAMNAME_DIRTYMASK); }

    public java.lang.String   getParamname()         { return paramname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getParamnameAsString() { return (paramname == null) ? "" : paramname; }

    // paramname setter methods.
    
    protected void markParamnameAsDirty(boolean aFlag)  { markFieldAsDirty(PARAMNAME_DIRTYGROUP, PARAMNAME_DIRTYMASK, aFlag); }


    public void setParamname(String  p)
    {
       setParamname(p, DTOCasingStyle.none);
    }
    
    public void setParamname(String  p, DTOCasingStyle casingStyle)
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
       markParamnameAsDirty(!equalsObject(paramname, p));
       paramname = p;
    }

    // paramvalue getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isParamvalueDirty()  { return checkFieldDirtiness(PARAMVALUE_DIRTYGROUP, PARAMVALUE_DIRTYMASK); }

    public java.lang.String   getParamvalue()         { return paramvalue; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getParamvalueAsString() { return (paramvalue == null) ? "" : paramvalue; }

    // paramvalue setter methods.
    
    protected void markParamvalueAsDirty(boolean aFlag)  { markFieldAsDirty(PARAMVALUE_DIRTYGROUP, PARAMVALUE_DIRTYMASK, aFlag); }


    public void setParamvalue(String  p)
    {
       setParamvalue(p, DTOCasingStyle.none);
    }
    
    public void setParamvalue(String  p, DTOCasingStyle casingStyle)
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
       markParamvalueAsDirty(!equalsObject(paramvalue, p));
       paramvalue = p;
    }

}
