//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.racegroupview;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SailRaceGroupViewDTOBase")
public class SailRaceGroupViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  parentitemid;
    protected java.lang.String  parentitemdescr;
    protected java.lang.Integer  parentitemorder;
    protected java.lang.String  childitemid;
    protected java.lang.String  childitemdescr;
    protected java.lang.Long  childitemorder;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String PARENTITEMID_DEFAULT  =  null;
    public static final java.lang.String PARENTITEMDESCR_DEFAULT  =  null;
    public static final java.lang.Integer PARENTITEMORDER_DEFAULT  =  null;
    public static final java.lang.String CHILDITEMID_DEFAULT  =  null;
    public static final java.lang.String CHILDITEMDESCR_DEFAULT  =  null;
    public static final java.lang.Long CHILDITEMORDER_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int PARENTITEMID_DIRTYGROUP  =  0;
    public static final int PARENTITEMID_DIRTYMASK   =  2;
    public static final int PARENTITEMDESCR_DIRTYGROUP  =  0;
    public static final int PARENTITEMDESCR_DIRTYMASK   =  4;
    public static final int PARENTITEMORDER_DIRTYGROUP  =  0;
    public static final int PARENTITEMORDER_DIRTYMASK   =  8;
    public static final int CHILDITEMID_DIRTYGROUP  =  0;
    public static final int CHILDITEMID_DIRTYMASK   =  16;
    public static final int CHILDITEMDESCR_DIRTYGROUP  =  0;
    public static final int CHILDITEMDESCR_DIRTYMASK   =  32;
    public static final int CHILDITEMORDER_DIRTYGROUP  =  0;
    public static final int CHILDITEMORDER_DIRTYMASK   =  64;


    /**
      * DataBean constructor.
      */
    public SailRaceGroupViewDTOBase()
    {
       dirtyFlagsArray = new int[7 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       parentitemid = PARENTITEMID_DEFAULT;
       parentitemdescr = PARENTITEMDESCR_DEFAULT;
       parentitemorder = PARENTITEMORDER_DEFAULT;
       childitemid = CHILDITEMID_DEFAULT;
       childitemdescr = CHILDITEMDESCR_DEFAULT;
       childitemorder = CHILDITEMORDER_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailRaceGroupViewDTOBase(SailRaceGroupViewDTOBase another)
    {

       site = another.getSite();
       parentitemid = another.getParentitemid();
       parentitemdescr = another.getParentitemdescr();
       parentitemorder = another.getParentitemorder();
       childitemid = another.getChilditemid();
       childitemdescr = another.getChilditemdescr();
       childitemorder = another.getChilditemorder();

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
        stb.append(parentitemid);
        stb.append(", ");
        stb.append(childitemid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (parentitemdescr != null)
        {
        stb.append(parentitemdescr);
        notNull = true;        
        }
        if (childitemdescr != null)
        {
        stb.append(", ");
        stb.append(childitemdescr);
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

    // parentitemid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isParentitemidDirty()  { return checkFieldDirtiness(PARENTITEMID_DIRTYGROUP, PARENTITEMID_DIRTYMASK); }

    public java.lang.String   getParentitemid()         { return parentitemid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getParentitemidAsString() { return (parentitemid == null) ? "" : parentitemid; }

    // parentitemid setter methods.
    
    protected void markParentitemidAsDirty(boolean aFlag)  { markFieldAsDirty(PARENTITEMID_DIRTYGROUP, PARENTITEMID_DIRTYMASK, aFlag); }


    public void setParentitemid(String  p)
    {
       setParentitemid(p, DTOCasingStyle.none);
    }
    
    public void setParentitemid(String  p, DTOCasingStyle casingStyle)
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
       markParentitemidAsDirty(!equalsObject(parentitemid, p));
       parentitemid = p;
    }

    // parentitemdescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isParentitemdescrDirty()  { return checkFieldDirtiness(PARENTITEMDESCR_DIRTYGROUP, PARENTITEMDESCR_DIRTYMASK); }

    public java.lang.String   getParentitemdescr()         { return parentitemdescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getParentitemdescrAsString() { return (parentitemdescr == null) ? "" : parentitemdescr; }

    // parentitemdescr setter methods.
    
    protected void markParentitemdescrAsDirty(boolean aFlag)  { markFieldAsDirty(PARENTITEMDESCR_DIRTYGROUP, PARENTITEMDESCR_DIRTYMASK, aFlag); }


    public void setParentitemdescr(String  p)
    {
       setParentitemdescr(p, DTOCasingStyle.none);
    }
    
    public void setParentitemdescr(String  p, DTOCasingStyle casingStyle)
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
       markParentitemdescrAsDirty(!equalsObject(parentitemdescr, p));
       parentitemdescr = p;
    }

    // parentitemorder getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isParentitemorderDirty()  { return checkFieldDirtiness(PARENTITEMORDER_DIRTYGROUP, PARENTITEMORDER_DIRTYMASK); }

    public java.lang.Integer   getParentitemorder() { return parentitemorder; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getParentitemorderAsString() { return integerAsString(parentitemorder); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getParentitemorderAsInt()    { return parentitemorder != null ? parentitemorder.intValue() : 0; }

    // parentitemorder setter methods.
    
    protected void markParentitemorderAsDirty(boolean aFlag)  { markFieldAsDirty(PARENTITEMORDER_DIRTYGROUP, PARENTITEMORDER_DIRTYMASK, aFlag); }


    public void setParentitemorder(java.lang.Integer  p)
    {
        markParentitemorderAsDirty(!equalsObject(parentitemorder, p));
    	parentitemorder = p;
    }
    public void setParentitemorder(int p)
    {
    	setParentitemorder(new java.lang.Integer(p));
    }
    public void setParentitemorder()
    {
    	setParentitemorder(0);
    }
    public void setParentitemorder(String  p)
    {
    	setParentitemorder(stringAsInteger(p));
    }

    // childitemid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isChilditemidDirty()  { return checkFieldDirtiness(CHILDITEMID_DIRTYGROUP, CHILDITEMID_DIRTYMASK); }

    public java.lang.String   getChilditemid()         { return childitemid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getChilditemidAsString() { return (childitemid == null) ? "" : childitemid; }

    // childitemid setter methods.
    
    protected void markChilditemidAsDirty(boolean aFlag)  { markFieldAsDirty(CHILDITEMID_DIRTYGROUP, CHILDITEMID_DIRTYMASK, aFlag); }


    public void setChilditemid(String  p)
    {
       setChilditemid(p, DTOCasingStyle.none);
    }
    
    public void setChilditemid(String  p, DTOCasingStyle casingStyle)
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
       markChilditemidAsDirty(!equalsObject(childitemid, p));
       childitemid = p;
    }

    // childitemdescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isChilditemdescrDirty()  { return checkFieldDirtiness(CHILDITEMDESCR_DIRTYGROUP, CHILDITEMDESCR_DIRTYMASK); }

    public java.lang.String   getChilditemdescr()         { return childitemdescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getChilditemdescrAsString() { return (childitemdescr == null) ? "" : childitemdescr; }

    // childitemdescr setter methods.
    
    protected void markChilditemdescrAsDirty(boolean aFlag)  { markFieldAsDirty(CHILDITEMDESCR_DIRTYGROUP, CHILDITEMDESCR_DIRTYMASK, aFlag); }


    public void setChilditemdescr(String  p)
    {
       setChilditemdescr(p, DTOCasingStyle.none);
    }
    
    public void setChilditemdescr(String  p, DTOCasingStyle casingStyle)
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
       markChilditemdescrAsDirty(!equalsObject(childitemdescr, p));
       childitemdescr = p;
    }

    // childitemorder getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isChilditemorderDirty()  { return checkFieldDirtiness(CHILDITEMORDER_DIRTYGROUP, CHILDITEMORDER_DIRTYMASK); }

    public java.lang.Long   getChilditemorder() { return childitemorder; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getChilditemorderAsString() { return longAsString(childitemorder); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public long   getChilditemorderAsLong()    { return childitemorder != null ? childitemorder.longValue() : 0L; }

    // childitemorder setter methods.
    
    protected void markChilditemorderAsDirty(boolean aFlag)  { markFieldAsDirty(CHILDITEMORDER_DIRTYGROUP, CHILDITEMORDER_DIRTYMASK, aFlag); }


    public void setChilditemorder(java.lang.Long  p)
    {
    	markChilditemorderAsDirty(!equalsObject(childitemorder, p));
    	childitemorder = p;
    }
    public void setChilditemorder(long p)
    {
    	setChilditemorder(new java.lang.Long(p));
    }
    public void setChilditemorder()
    {
    	setChilditemorder(0L);
    }
    public void setChilditemorder(String  p)
    {
    	setChilditemorder(stringAsLong(p));
    }

}
