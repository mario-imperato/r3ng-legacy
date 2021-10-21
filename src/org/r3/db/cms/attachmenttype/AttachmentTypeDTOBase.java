//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.attachmenttype;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "AttachmentTypeDTOBase")
public class AttachmentTypeDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  attachtypeid;
    protected java.lang.String  attachtypedescr;
    protected java.lang.String  contenttype;
    protected java.lang.String  imagescaling;
    protected java.lang.String  iconscaling;
    protected java.lang.String  propertyrole;
    protected java.lang.String  attachscope;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String ATTACHTYPEID_DEFAULT  =  null;
    public static final java.lang.String ATTACHTYPEDESCR_DEFAULT  =  null;
    public static final java.lang.String CONTENTTYPE_DEFAULT  =  null;
    public static final java.lang.String IMAGESCALING_DEFAULT  =  null;
    public static final java.lang.String ICONSCALING_DEFAULT  =  null;
    public static final java.lang.String PROPERTYROLE_DEFAULT  =  null;
    public static final java.lang.String ATTACHSCOPE_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int ATTACHTYPEID_DIRTYGROUP  =  0;
    public static final int ATTACHTYPEID_DIRTYMASK   =  2;
    public static final int ATTACHTYPEDESCR_DIRTYGROUP  =  0;
    public static final int ATTACHTYPEDESCR_DIRTYMASK   =  4;
    public static final int CONTENTTYPE_DIRTYGROUP  =  0;
    public static final int CONTENTTYPE_DIRTYMASK   =  8;
    public static final int IMAGESCALING_DIRTYGROUP  =  0;
    public static final int IMAGESCALING_DIRTYMASK   =  16;
    public static final int ICONSCALING_DIRTYGROUP  =  0;
    public static final int ICONSCALING_DIRTYMASK   =  32;
    public static final int PROPERTYROLE_DIRTYGROUP  =  0;
    public static final int PROPERTYROLE_DIRTYMASK   =  64;
    public static final int ATTACHSCOPE_DIRTYGROUP  =  0;
    public static final int ATTACHSCOPE_DIRTYMASK   =  128;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  256;


    /**
      * DataBean constructor.
      */
    public AttachmentTypeDTOBase()
    {
       dirtyFlagsArray = new int[9 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       attachtypeid = ATTACHTYPEID_DEFAULT;
       attachtypedescr = ATTACHTYPEDESCR_DEFAULT;
       contenttype = CONTENTTYPE_DEFAULT;
       imagescaling = IMAGESCALING_DEFAULT;
       iconscaling = ICONSCALING_DEFAULT;
       propertyrole = PROPERTYROLE_DEFAULT;
       attachscope = ATTACHSCOPE_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public AttachmentTypeDTOBase(AttachmentTypeDTOBase another)
    {

       site = another.getSite();
       attachtypeid = another.getAttachtypeid();
       attachtypedescr = another.getAttachtypedescr();
       contenttype = another.getContenttype();
       imagescaling = another.getImagescaling();
       iconscaling = another.getIconscaling();
       propertyrole = another.getPropertyrole();
       attachscope = another.getAttachscope();
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
        stb.append(attachtypeid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (attachtypedescr != null)
        {
        stb.append(attachtypedescr);
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

    // attachtypeid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAttachtypeidDirty()  { return checkFieldDirtiness(ATTACHTYPEID_DIRTYGROUP, ATTACHTYPEID_DIRTYMASK); }

    public java.lang.String   getAttachtypeid()         { return attachtypeid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "attachtypeid")
    public java.lang.String   getAttachtypeidAsString() { return (attachtypeid == null) ? "" : attachtypeid; }

    // attachtypeid setter methods.
    
    protected void markAttachtypeidAsDirty(boolean aFlag)  { markFieldAsDirty(ATTACHTYPEID_DIRTYGROUP, ATTACHTYPEID_DIRTYMASK, aFlag); }


    public void setAttachtypeid(String  p)
    {
       setAttachtypeid(p, DTOCasingStyle.none);
    }
    
    public void setAttachtypeid(String  p, DTOCasingStyle casingStyle)
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
       markAttachtypeidAsDirty(!equalsObject(attachtypeid, p));
       attachtypeid = p;
    }

    // attachtypedescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAttachtypedescrDirty()  { return checkFieldDirtiness(ATTACHTYPEDESCR_DIRTYGROUP, ATTACHTYPEDESCR_DIRTYMASK); }

    public java.lang.String   getAttachtypedescr()         { return attachtypedescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "attachtypedescr")
    public java.lang.String   getAttachtypedescrAsString() { return (attachtypedescr == null) ? "" : attachtypedescr; }

    // attachtypedescr setter methods.
    
    protected void markAttachtypedescrAsDirty(boolean aFlag)  { markFieldAsDirty(ATTACHTYPEDESCR_DIRTYGROUP, ATTACHTYPEDESCR_DIRTYMASK, aFlag); }


    public void setAttachtypedescr(String  p)
    {
       setAttachtypedescr(p, DTOCasingStyle.none);
    }
    
    public void setAttachtypedescr(String  p, DTOCasingStyle casingStyle)
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
       markAttachtypedescrAsDirty(!equalsObject(attachtypedescr, p));
       attachtypedescr = p;
    }

    // contenttype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isContenttypeDirty()  { return checkFieldDirtiness(CONTENTTYPE_DIRTYGROUP, CONTENTTYPE_DIRTYMASK); }

    public java.lang.String   getContenttype()         { return contenttype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "contenttype")
    public java.lang.String   getContenttypeAsString() { return (contenttype == null) ? "" : contenttype; }

    // contenttype setter methods.
    
    protected void markContenttypeAsDirty(boolean aFlag)  { markFieldAsDirty(CONTENTTYPE_DIRTYGROUP, CONTENTTYPE_DIRTYMASK, aFlag); }


    public void setContenttype(String  p)
    {
       setContenttype(p, DTOCasingStyle.none);
    }
    
    public void setContenttype(String  p, DTOCasingStyle casingStyle)
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
       markContenttypeAsDirty(!equalsObject(contenttype, p));
       contenttype = p;
    }

    // imagescaling getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isImagescalingDirty()  { return checkFieldDirtiness(IMAGESCALING_DIRTYGROUP, IMAGESCALING_DIRTYMASK); }

    public java.lang.String   getImagescaling()         { return imagescaling; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "imagescaling")
    public java.lang.String   getImagescalingAsString() { return (imagescaling == null) ? "" : imagescaling; }

    // imagescaling setter methods.
    
    protected void markImagescalingAsDirty(boolean aFlag)  { markFieldAsDirty(IMAGESCALING_DIRTYGROUP, IMAGESCALING_DIRTYMASK, aFlag); }


    public void setImagescaling(String  p)
    {
       setImagescaling(p, DTOCasingStyle.none);
    }
    
    public void setImagescaling(String  p, DTOCasingStyle casingStyle)
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
       markImagescalingAsDirty(!equalsObject(imagescaling, p));
       imagescaling = p;
    }

    // iconscaling getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIconscalingDirty()  { return checkFieldDirtiness(ICONSCALING_DIRTYGROUP, ICONSCALING_DIRTYMASK); }

    public java.lang.String   getIconscaling()         { return iconscaling; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "iconscaling")
    public java.lang.String   getIconscalingAsString() { return (iconscaling == null) ? "" : iconscaling; }

    // iconscaling setter methods.
    
    protected void markIconscalingAsDirty(boolean aFlag)  { markFieldAsDirty(ICONSCALING_DIRTYGROUP, ICONSCALING_DIRTYMASK, aFlag); }


    public void setIconscaling(String  p)
    {
       setIconscaling(p, DTOCasingStyle.none);
    }
    
    public void setIconscaling(String  p, DTOCasingStyle casingStyle)
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
       markIconscalingAsDirty(!equalsObject(iconscaling, p));
       iconscaling = p;
    }

    // propertyrole getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertyroleDirty()  { return checkFieldDirtiness(PROPERTYROLE_DIRTYGROUP, PROPERTYROLE_DIRTYMASK); }

    public java.lang.String   getPropertyrole()         { return propertyrole; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "propertyrole")
    public java.lang.String   getPropertyroleAsString() { return (propertyrole == null) ? "" : propertyrole; }

    // propertyrole setter methods.
    
    protected void markPropertyroleAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYROLE_DIRTYGROUP, PROPERTYROLE_DIRTYMASK, aFlag); }


    public void setPropertyrole(String  p)
    {
       setPropertyrole(p, DTOCasingStyle.none);
    }
    
    public void setPropertyrole(String  p, DTOCasingStyle casingStyle)
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
       markPropertyroleAsDirty(!equalsObject(propertyrole, p));
       propertyrole = p;
    }

    // attachscope getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAttachscopeDirty()  { return checkFieldDirtiness(ATTACHSCOPE_DIRTYGROUP, ATTACHSCOPE_DIRTYMASK); }

    public java.lang.String   getAttachscope()         { return attachscope; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "attachscope")
    public java.lang.String   getAttachscopeAsString() { return (attachscope == null) ? "" : attachscope; }

    // attachscope setter methods.
    
    protected void markAttachscopeAsDirty(boolean aFlag)  { markFieldAsDirty(ATTACHSCOPE_DIRTYGROUP, ATTACHSCOPE_DIRTYMASK, aFlag); }


    public void setAttachscope(String  p)
    {
       setAttachscope(p, DTOCasingStyle.none);
    }
    
    public void setAttachscope(String  p, DTOCasingStyle casingStyle)
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
       markAttachscopeAsDirty(!equalsObject(attachscope, p));
       attachscope = p;
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
