//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.siteproperty;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SitePropertyDTOBase")
public class SitePropertyDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  propertyscope;
    protected java.lang.String  propertykey;
    protected java.lang.String  propertyvalue;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String PROPERTYSCOPE_DEFAULT  =  null;
    public static final java.lang.String PROPERTYKEY_DEFAULT  =  null;
    public static final java.lang.String PROPERTYVALUE_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int PROPERTYSCOPE_DIRTYGROUP  =  0;
    public static final int PROPERTYSCOPE_DIRTYMASK   =  2;
    public static final int PROPERTYKEY_DIRTYGROUP  =  0;
    public static final int PROPERTYKEY_DIRTYMASK   =  4;
    public static final int PROPERTYVALUE_DIRTYGROUP  =  0;
    public static final int PROPERTYVALUE_DIRTYMASK   =  8;


    /**
      * DataBean constructor.
      */
    public SitePropertyDTOBase()
    {
       dirtyFlagsArray = new int[4 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       propertyscope = PROPERTYSCOPE_DEFAULT;
       propertykey = PROPERTYKEY_DEFAULT;
       propertyvalue = PROPERTYVALUE_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SitePropertyDTOBase(SitePropertyDTOBase another)
    {

       site = another.getSite();
       propertyscope = another.getPropertyscope();
       propertykey = another.getPropertykey();
       propertyvalue = another.getPropertyvalue();

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
        stb.append(propertyscope);
        stb.append(", ");
        stb.append(propertykey);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (propertyvalue != null)
        {
        stb.append(propertyvalue);
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

    // propertyscope getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertyscopeDirty()  { return checkFieldDirtiness(PROPERTYSCOPE_DIRTYGROUP, PROPERTYSCOPE_DIRTYMASK); }

    public java.lang.String   getPropertyscope()         { return propertyscope; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPropertyscopeAsString() { return (propertyscope == null) ? "" : propertyscope; }

    // propertyscope setter methods.
    
    protected void markPropertyscopeAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYSCOPE_DIRTYGROUP, PROPERTYSCOPE_DIRTYMASK, aFlag); }


    public void setPropertyscope(String  p)
    {
       setPropertyscope(p, DTOCasingStyle.none);
    }
    
    public void setPropertyscope(String  p, DTOCasingStyle casingStyle)
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
       markPropertyscopeAsDirty(!equalsObject(propertyscope, p));
       propertyscope = p;
    }

    // propertykey getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertykeyDirty()  { return checkFieldDirtiness(PROPERTYKEY_DIRTYGROUP, PROPERTYKEY_DIRTYMASK); }

    public java.lang.String   getPropertykey()         { return propertykey; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPropertykeyAsString() { return (propertykey == null) ? "" : propertykey; }

    // propertykey setter methods.
    
    protected void markPropertykeyAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYKEY_DIRTYGROUP, PROPERTYKEY_DIRTYMASK, aFlag); }


    public void setPropertykey(String  p)
    {
       setPropertykey(p, DTOCasingStyle.none);
    }
    
    public void setPropertykey(String  p, DTOCasingStyle casingStyle)
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
       markPropertykeyAsDirty(!equalsObject(propertykey, p));
       propertykey = p;
    }

    // propertyvalue getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertyvalueDirty()  { return checkFieldDirtiness(PROPERTYVALUE_DIRTYGROUP, PROPERTYVALUE_DIRTYMASK); }

    public java.lang.String   getPropertyvalue()         { return propertyvalue; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPropertyvalueAsString() { return (propertyvalue == null) ? "" : propertyvalue; }

    // propertyvalue setter methods.
    
    protected void markPropertyvalueAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYVALUE_DIRTYGROUP, PROPERTYVALUE_DIRTYMASK, aFlag); }


    public void setPropertyvalue(String  p)
    {
       setPropertyvalue(p, DTOCasingStyle.none);
    }
    
    public void setPropertyvalue(String  p, DTOCasingStyle casingStyle)
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
       markPropertyvalueAsDirty(!equalsObject(propertyvalue, p));
       propertyvalue = p;
    }

}
