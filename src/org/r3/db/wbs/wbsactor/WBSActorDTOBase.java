//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.wbs.wbsactor;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "WBSActorDTOBase")
public class WBSActorDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  wbsactorid;
    protected java.lang.String  site;
    protected java.lang.String  actorid;
    protected java.lang.String  actorrole;
    protected java.lang.String  wbsid;
    protected java.lang.String  wbsnodeid;

    public static final java.lang.String WBSACTORID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String ACTORID_DEFAULT  =  null;
    public static final java.lang.String ACTORROLE_DEFAULT  =  null;
    public static final java.lang.String WBSID_DEFAULT  =  null;
    public static final java.lang.String WBSNODEID_DEFAULT  =  null;

    public static final int WBSACTORID_DIRTYGROUP  =  0;
    public static final int WBSACTORID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int ACTORID_DIRTYGROUP  =  0;
    public static final int ACTORID_DIRTYMASK   =  4;
    public static final int ACTORROLE_DIRTYGROUP  =  0;
    public static final int ACTORROLE_DIRTYMASK   =  8;
    public static final int WBSID_DIRTYGROUP  =  0;
    public static final int WBSID_DIRTYMASK   =  16;
    public static final int WBSNODEID_DIRTYGROUP  =  0;
    public static final int WBSNODEID_DIRTYMASK   =  32;


    /**
      * DataBean constructor.
      */
    public WBSActorDTOBase()
    {
       dirtyFlagsArray = new int[6 / 30 + 1];
       clearDirtyFlags();

       wbsactorid = WBSACTORID_DEFAULT;
       site = SITE_DEFAULT;
       actorid = ACTORID_DEFAULT;
       actorrole = ACTORROLE_DEFAULT;
       wbsid = WBSID_DEFAULT;
       wbsnodeid = WBSNODEID_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public WBSActorDTOBase(WBSActorDTOBase another)
    {

       wbsactorid = another.getWbsactorid();
       site = another.getSite();
       actorid = another.getActorid();
       actorrole = another.getActorrole();
       wbsid = another.getWbsid();
       wbsnodeid = another.getWbsnodeid();

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
        stb.append(wbsactorid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (actorid != null)
        {
        stb.append(actorid);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // wbsactorid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWbsactoridDirty()  { return checkFieldDirtiness(WBSACTORID_DIRTYGROUP, WBSACTORID_DIRTYMASK); }

    public java.lang.String   getWbsactorid()         { return wbsactorid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "wbsactorid")
    public java.lang.String   getWbsactoridAsString() { return (wbsactorid == null) ? "" : wbsactorid; }

    // wbsactorid setter methods.
    
    protected void markWbsactoridAsDirty(boolean aFlag)  { markFieldAsDirty(WBSACTORID_DIRTYGROUP, WBSACTORID_DIRTYMASK, aFlag); }


    public void setWbsactorid(String  p)
    {
       setWbsactorid(p, DTOCasingStyle.none);
    }
    
    public void setWbsactorid(String  p, DTOCasingStyle casingStyle)
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
       markWbsactoridAsDirty(!equalsObject(wbsactorid, p));
       wbsactorid = p;
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

    // actorid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isActoridDirty()  { return checkFieldDirtiness(ACTORID_DIRTYGROUP, ACTORID_DIRTYMASK); }

    public java.lang.String   getActorid()         { return actorid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "actorid")
    public java.lang.String   getActoridAsString() { return (actorid == null) ? "" : actorid; }

    // actorid setter methods.
    
    protected void markActoridAsDirty(boolean aFlag)  { markFieldAsDirty(ACTORID_DIRTYGROUP, ACTORID_DIRTYMASK, aFlag); }


    public void setActorid(String  p)
    {
       setActorid(p, DTOCasingStyle.none);
    }
    
    public void setActorid(String  p, DTOCasingStyle casingStyle)
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
       markActoridAsDirty(!equalsObject(actorid, p));
       actorid = p;
    }

    // actorrole getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isActorroleDirty()  { return checkFieldDirtiness(ACTORROLE_DIRTYGROUP, ACTORROLE_DIRTYMASK); }

    public java.lang.String   getActorrole()         { return actorrole; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "actorrole")
    public java.lang.String   getActorroleAsString() { return (actorrole == null) ? "" : actorrole; }

    // actorrole setter methods.
    
    protected void markActorroleAsDirty(boolean aFlag)  { markFieldAsDirty(ACTORROLE_DIRTYGROUP, ACTORROLE_DIRTYMASK, aFlag); }


    public void setActorrole(String  p)
    {
       setActorrole(p, DTOCasingStyle.none);
    }
    
    public void setActorrole(String  p, DTOCasingStyle casingStyle)
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
       markActorroleAsDirty(!equalsObject(actorrole, p));
       actorrole = p;
    }

    // wbsid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWbsidDirty()  { return checkFieldDirtiness(WBSID_DIRTYGROUP, WBSID_DIRTYMASK); }

    public java.lang.String   getWbsid()         { return wbsid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "wbsid")
    public java.lang.String   getWbsidAsString() { return (wbsid == null) ? "" : wbsid; }

    // wbsid setter methods.
    
    protected void markWbsidAsDirty(boolean aFlag)  { markFieldAsDirty(WBSID_DIRTYGROUP, WBSID_DIRTYMASK, aFlag); }


    public void setWbsid(String  p)
    {
       setWbsid(p, DTOCasingStyle.none);
    }
    
    public void setWbsid(String  p, DTOCasingStyle casingStyle)
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
       markWbsidAsDirty(!equalsObject(wbsid, p));
       wbsid = p;
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

}
