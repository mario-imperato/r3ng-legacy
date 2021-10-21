//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.siteresource;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SiteResourceDTOBase")
public class SiteResourceDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  resourceid;
    protected java.lang.String  profileid;
    protected java.lang.String  evalueunit;
    protected java.lang.Float  price;
    protected java.lang.Float  cost;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String RESOURCEID_DEFAULT  =  null;
    public static final java.lang.String PROFILEID_DEFAULT  =  null;
    public static final java.lang.String EVALUEUNIT_DEFAULT  =  null;
    public static final java.lang.Float PRICE_DEFAULT  =  null;
    public static final java.lang.Float COST_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int RESOURCEID_DIRTYGROUP  =  0;
    public static final int RESOURCEID_DIRTYMASK   =  2;
    public static final int PROFILEID_DIRTYGROUP  =  0;
    public static final int PROFILEID_DIRTYMASK   =  4;
    public static final int EVALUEUNIT_DIRTYGROUP  =  0;
    public static final int EVALUEUNIT_DIRTYMASK   =  8;
    public static final int PRICE_DIRTYGROUP  =  0;
    public static final int PRICE_DIRTYMASK   =  16;
    public static final int COST_DIRTYGROUP  =  0;
    public static final int COST_DIRTYMASK   =  32;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  64;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  128;


    /**
      * DataBean constructor.
      */
    public SiteResourceDTOBase()
    {
       dirtyFlagsArray = new int[8 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       resourceid = RESOURCEID_DEFAULT;
       profileid = PROFILEID_DEFAULT;
       evalueunit = EVALUEUNIT_DEFAULT;
       price = PRICE_DEFAULT;
       cost = COST_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SiteResourceDTOBase(SiteResourceDTOBase another)
    {

       site = another.getSite();
       resourceid = another.getResourceid();
       profileid = another.getProfileid();
       evalueunit = another.getEvalueunit();
       price = another.getPrice();
       cost = another.getCost();
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
        stb.append(resourceid);
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
