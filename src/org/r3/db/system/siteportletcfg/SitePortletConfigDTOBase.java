//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteportletcfg;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SitePortletConfigDTOBase")
public class SitePortletConfigDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  pageid;
    protected java.lang.String  positionid;
    protected java.lang.String  jsclassname;
    protected java.lang.String  cssclassname;
    protected java.lang.String  datacardid;
    protected java.lang.String  dataoptions;
    protected java.lang.String  dataonuserstatus;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String PAGEID_DEFAULT  =  null;
    public static final java.lang.String POSITIONID_DEFAULT  =  null;
    public static final java.lang.String JSCLASSNAME_DEFAULT  =  null;
    public static final java.lang.String CSSCLASSNAME_DEFAULT  =  null;
    public static final java.lang.String DATACARDID_DEFAULT  =  null;
    public static final java.lang.String DATAOPTIONS_DEFAULT  =  null;
    public static final java.lang.String DATAONUSERSTATUS_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int PAGEID_DIRTYGROUP  =  0;
    public static final int PAGEID_DIRTYMASK   =  2;
    public static final int POSITIONID_DIRTYGROUP  =  0;
    public static final int POSITIONID_DIRTYMASK   =  4;
    public static final int JSCLASSNAME_DIRTYGROUP  =  0;
    public static final int JSCLASSNAME_DIRTYMASK   =  8;
    public static final int CSSCLASSNAME_DIRTYGROUP  =  0;
    public static final int CSSCLASSNAME_DIRTYMASK   =  16;
    public static final int DATACARDID_DIRTYGROUP  =  0;
    public static final int DATACARDID_DIRTYMASK   =  32;
    public static final int DATAOPTIONS_DIRTYGROUP  =  0;
    public static final int DATAOPTIONS_DIRTYMASK   =  64;
    public static final int DATAONUSERSTATUS_DIRTYGROUP  =  0;
    public static final int DATAONUSERSTATUS_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public SitePortletConfigDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       pageid = PAGEID_DEFAULT;
       positionid = POSITIONID_DEFAULT;
       jsclassname = JSCLASSNAME_DEFAULT;
       cssclassname = CSSCLASSNAME_DEFAULT;
       datacardid = DATACARDID_DEFAULT;
       dataoptions = DATAOPTIONS_DEFAULT;
       dataonuserstatus = DATAONUSERSTATUS_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SitePortletConfigDTOBase(SitePortletConfigDTOBase another)
    {

       site = another.getSite();
       pageid = another.getPageid();
       positionid = another.getPositionid();
       jsclassname = another.getJsclassname();
       cssclassname = another.getCssclassname();
       datacardid = another.getDatacardid();
       dataoptions = another.getDataoptions();
       dataonuserstatus = another.getDataonuserstatus();

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
        stb.append(pageid);
        stb.append(", ");
        stb.append(positionid);
        return stb.toString();
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

    // pageid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPageidDirty()  { return checkFieldDirtiness(PAGEID_DIRTYGROUP, PAGEID_DIRTYMASK); }

    public java.lang.String   getPageid()         { return pageid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pageid")
    public java.lang.String   getPageidAsString() { return (pageid == null) ? "" : pageid; }

    // pageid setter methods.
    
    protected void markPageidAsDirty(boolean aFlag)  { markFieldAsDirty(PAGEID_DIRTYGROUP, PAGEID_DIRTYMASK, aFlag); }


    public void setPageid(String  p)
    {
       setPageid(p, DTOCasingStyle.none);
    }
    
    public void setPageid(String  p, DTOCasingStyle casingStyle)
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
       markPageidAsDirty(!equalsObject(pageid, p));
       pageid = p;
    }

    // positionid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPositionidDirty()  { return checkFieldDirtiness(POSITIONID_DIRTYGROUP, POSITIONID_DIRTYMASK); }

    public java.lang.String   getPositionid()         { return positionid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "positionid")
    public java.lang.String   getPositionidAsString() { return (positionid == null) ? "" : positionid; }

    // positionid setter methods.
    
    protected void markPositionidAsDirty(boolean aFlag)  { markFieldAsDirty(POSITIONID_DIRTYGROUP, POSITIONID_DIRTYMASK, aFlag); }


    public void setPositionid(String  p)
    {
       setPositionid(p, DTOCasingStyle.none);
    }
    
    public void setPositionid(String  p, DTOCasingStyle casingStyle)
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
       markPositionidAsDirty(!equalsObject(positionid, p));
       positionid = p;
    }

    // jsclassname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isJsclassnameDirty()  { return checkFieldDirtiness(JSCLASSNAME_DIRTYGROUP, JSCLASSNAME_DIRTYMASK); }

    public java.lang.String   getJsclassname()         { return jsclassname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "jsclassname")
    public java.lang.String   getJsclassnameAsString() { return (jsclassname == null) ? "" : jsclassname; }

    // jsclassname setter methods.
    
    protected void markJsclassnameAsDirty(boolean aFlag)  { markFieldAsDirty(JSCLASSNAME_DIRTYGROUP, JSCLASSNAME_DIRTYMASK, aFlag); }


    public void setJsclassname(String  p)
    {
       setJsclassname(p, DTOCasingStyle.none);
    }
    
    public void setJsclassname(String  p, DTOCasingStyle casingStyle)
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
       markJsclassnameAsDirty(!equalsObject(jsclassname, p));
       jsclassname = p;
    }

    // cssclassname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCssclassnameDirty()  { return checkFieldDirtiness(CSSCLASSNAME_DIRTYGROUP, CSSCLASSNAME_DIRTYMASK); }

    public java.lang.String   getCssclassname()         { return cssclassname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cssclassname")
    public java.lang.String   getCssclassnameAsString() { return (cssclassname == null) ? "" : cssclassname; }

    // cssclassname setter methods.
    
    protected void markCssclassnameAsDirty(boolean aFlag)  { markFieldAsDirty(CSSCLASSNAME_DIRTYGROUP, CSSCLASSNAME_DIRTYMASK, aFlag); }


    public void setCssclassname(String  p)
    {
       setCssclassname(p, DTOCasingStyle.none);
    }
    
    public void setCssclassname(String  p, DTOCasingStyle casingStyle)
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
       markCssclassnameAsDirty(!equalsObject(cssclassname, p));
       cssclassname = p;
    }

    // datacardid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDatacardidDirty()  { return checkFieldDirtiness(DATACARDID_DIRTYGROUP, DATACARDID_DIRTYMASK); }

    public java.lang.String   getDatacardid()         { return datacardid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "datacardid")
    public java.lang.String   getDatacardidAsString() { return (datacardid == null) ? "" : datacardid; }

    // datacardid setter methods.
    
    protected void markDatacardidAsDirty(boolean aFlag)  { markFieldAsDirty(DATACARDID_DIRTYGROUP, DATACARDID_DIRTYMASK, aFlag); }


    public void setDatacardid(String  p)
    {
       setDatacardid(p, DTOCasingStyle.none);
    }
    
    public void setDatacardid(String  p, DTOCasingStyle casingStyle)
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
       markDatacardidAsDirty(!equalsObject(datacardid, p));
       datacardid = p;
    }

    // dataoptions getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDataoptionsDirty()  { return checkFieldDirtiness(DATAOPTIONS_DIRTYGROUP, DATAOPTIONS_DIRTYMASK); }

    public java.lang.String   getDataoptions()         { return dataoptions; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "dataoptions")
    public java.lang.String   getDataoptionsAsString() { return (dataoptions == null) ? "" : dataoptions; }

    // dataoptions setter methods.
    
    protected void markDataoptionsAsDirty(boolean aFlag)  { markFieldAsDirty(DATAOPTIONS_DIRTYGROUP, DATAOPTIONS_DIRTYMASK, aFlag); }


    public void setDataoptions(String  p)
    {
       setDataoptions(p, DTOCasingStyle.none);
    }
    
    public void setDataoptions(String  p, DTOCasingStyle casingStyle)
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
       markDataoptionsAsDirty(!equalsObject(dataoptions, p));
       dataoptions = p;
    }

    // dataonuserstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDataonuserstatusDirty()  { return checkFieldDirtiness(DATAONUSERSTATUS_DIRTYGROUP, DATAONUSERSTATUS_DIRTYMASK); }

    public java.lang.String   getDataonuserstatus()         { return dataonuserstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "dataonuserstatus")
    public java.lang.String   getDataonuserstatusAsString() { return (dataonuserstatus == null) ? "" : dataonuserstatus; }

    // dataonuserstatus setter methods.
    
    protected void markDataonuserstatusAsDirty(boolean aFlag)  { markFieldAsDirty(DATAONUSERSTATUS_DIRTYGROUP, DATAONUSERSTATUS_DIRTYMASK, aFlag); }


    public void setDataonuserstatus(String  p)
    {
       setDataonuserstatus(p, DTOCasingStyle.none);
    }
    
    public void setDataonuserstatus(String  p, DTOCasingStyle casingStyle)
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
       markDataonuserstatusAsDirty(!equalsObject(dataonuserstatus, p));
       dataonuserstatus = p;
    }

}
