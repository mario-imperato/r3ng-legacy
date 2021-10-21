//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.openregattas.openregattasview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "OpenRegattasViewDTOBase")
public class OpenRegattasViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  regattaid;
    protected java.lang.String  title;
    protected java.lang.String  languages;
    protected java.lang.String  domain;
    protected java.lang.String  icon;

    public static final java.lang.String REGATTAID_DEFAULT  =  null;
    public static final java.lang.String TITLE_DEFAULT  =  null;
    public static final java.lang.String LANGUAGES_DEFAULT  =  null;
    public static final java.lang.String DOMAIN_DEFAULT  =  null;
    public static final java.lang.String ICON_DEFAULT  =  null;

    public static final int REGATTAID_DIRTYGROUP  =  0;
    public static final int REGATTAID_DIRTYMASK   =  1;
    public static final int TITLE_DIRTYGROUP  =  0;
    public static final int TITLE_DIRTYMASK   =  2;
    public static final int LANGUAGES_DIRTYGROUP  =  0;
    public static final int LANGUAGES_DIRTYMASK   =  4;
    public static final int DOMAIN_DIRTYGROUP  =  0;
    public static final int DOMAIN_DIRTYMASK   =  8;
    public static final int ICON_DIRTYGROUP  =  0;
    public static final int ICON_DIRTYMASK   =  16;


    /**
      * DataBean constructor.
      */
    public OpenRegattasViewDTOBase()
    {
       dirtyFlagsArray = new int[5 / 30 + 1];
       clearDirtyFlags();

       regattaid = REGATTAID_DEFAULT;
       title = TITLE_DEFAULT;
       languages = LANGUAGES_DEFAULT;
       domain = DOMAIN_DEFAULT;
       icon = ICON_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public OpenRegattasViewDTOBase(OpenRegattasViewDTOBase another)
    {

       regattaid = another.getRegattaid();
       title = another.getTitle();
       languages = another.getLanguages();
       domain = another.getDomain();
       icon = another.getIcon();

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



    /**
      * DataBean Getter And Setter Accessor
      */

    // regattaid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRegattaidDirty()  { return checkFieldDirtiness(REGATTAID_DIRTYGROUP, REGATTAID_DIRTYMASK); }

    public java.lang.String   getRegattaid()         { return regattaid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "regattaid")
    public java.lang.String   getRegattaidAsString() { return (regattaid == null) ? "" : regattaid; }

    // regattaid setter methods.
    
    protected void markRegattaidAsDirty(boolean aFlag)  { markFieldAsDirty(REGATTAID_DIRTYGROUP, REGATTAID_DIRTYMASK, aFlag); }


    public void setRegattaid(String  p)
    {
       setRegattaid(p, DTOCasingStyle.none);
    }
    
    public void setRegattaid(String  p, DTOCasingStyle casingStyle)
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
       markRegattaidAsDirty(!equalsObject(regattaid, p));
       regattaid = p;
    }

    // title getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTitleDirty()  { return checkFieldDirtiness(TITLE_DIRTYGROUP, TITLE_DIRTYMASK); }

    public java.lang.String   getTitle()         { return title; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "title")
    public java.lang.String   getTitleAsString() { return (title == null) ? "" : title; }

    // title setter methods.
    
    protected void markTitleAsDirty(boolean aFlag)  { markFieldAsDirty(TITLE_DIRTYGROUP, TITLE_DIRTYMASK, aFlag); }


    public void setTitle(String  p)
    {
       setTitle(p, DTOCasingStyle.none);
    }
    
    public void setTitle(String  p, DTOCasingStyle casingStyle)
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
       markTitleAsDirty(!equalsObject(title, p));
       title = p;
    }

    // languages getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLanguagesDirty()  { return checkFieldDirtiness(LANGUAGES_DIRTYGROUP, LANGUAGES_DIRTYMASK); }

    public java.lang.String   getLanguages()         { return languages; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "languages")
    public java.lang.String   getLanguagesAsString() { return (languages == null) ? "" : languages; }

    // languages setter methods.
    
    protected void markLanguagesAsDirty(boolean aFlag)  { markFieldAsDirty(LANGUAGES_DIRTYGROUP, LANGUAGES_DIRTYMASK, aFlag); }


    public void setLanguages(String  p)
    {
       setLanguages(p, DTOCasingStyle.none);
    }
    
    public void setLanguages(String  p, DTOCasingStyle casingStyle)
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
       markLanguagesAsDirty(!equalsObject(languages, p));
       languages = p;
    }

    // domain getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDomainDirty()  { return checkFieldDirtiness(DOMAIN_DIRTYGROUP, DOMAIN_DIRTYMASK); }

    public java.lang.String   getDomain()         { return domain; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "domain")
    public java.lang.String   getDomainAsString() { return (domain == null) ? "" : domain; }

    // domain setter methods.
    
    protected void markDomainAsDirty(boolean aFlag)  { markFieldAsDirty(DOMAIN_DIRTYGROUP, DOMAIN_DIRTYMASK, aFlag); }


    public void setDomain(String  p)
    {
       setDomain(p, DTOCasingStyle.none);
    }
    
    public void setDomain(String  p, DTOCasingStyle casingStyle)
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
       markDomainAsDirty(!equalsObject(domain, p));
       domain = p;
    }

    // icon getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIconDirty()  { return checkFieldDirtiness(ICON_DIRTYGROUP, ICON_DIRTYMASK); }

    public java.lang.String   getIcon()         { return icon; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "icon")
    public java.lang.String   getIconAsString() { return (icon == null) ? "" : icon; }

    // icon setter methods.
    
    protected void markIconAsDirty(boolean aFlag)  { markFieldAsDirty(ICON_DIRTYGROUP, ICON_DIRTYMASK, aFlag); }


    public void setIcon(String  p)
    {
       setIcon(p, DTOCasingStyle.none);
    }
    
    public void setIcon(String  p, DTOCasingStyle casingStyle)
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
       markIconAsDirty(!equalsObject(icon, p));
       icon = p;
    }

}
