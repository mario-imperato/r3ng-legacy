//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.classifieritem;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ClassifierItemDTOBase")
public class ClassifierItemDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  clsitemid;
    protected java.lang.String  site;
    protected java.lang.String  clsid;
    protected java.lang.String  clsitembusid;
    protected java.lang.String  parentitemid;
    protected java.lang.String  classifieritemdescr;
    protected java.lang.String  classifieritempath;
    protected java.lang.Integer  classifieritemdepth;
    protected java.lang.Integer  classifieritemorder;
    protected java.lang.Integer  classifieritemiattr;
    protected java.lang.String  classifieritemsattr;

    public static final java.lang.String CLSITEMID_DEFAULT  =  null;
    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String CLSID_DEFAULT  =  null;
    public static final java.lang.String CLSITEMBUSID_DEFAULT  =  null;
    public static final java.lang.String PARENTITEMID_DEFAULT  =  null;
    public static final java.lang.String CLASSIFIERITEMDESCR_DEFAULT  =  null;
    public static final java.lang.String CLASSIFIERITEMPATH_DEFAULT  =  null;
    public static final java.lang.Integer CLASSIFIERITEMDEPTH_DEFAULT  =  null;
    public static final java.lang.Integer CLASSIFIERITEMORDER_DEFAULT  =  null;
    public static final java.lang.Integer CLASSIFIERITEMIATTR_DEFAULT  =  null;
    public static final java.lang.String CLASSIFIERITEMSATTR_DEFAULT  =  null;

    public static final int CLSITEMID_DIRTYGROUP  =  0;
    public static final int CLSITEMID_DIRTYMASK   =  1;
    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  2;
    public static final int CLSID_DIRTYGROUP  =  0;
    public static final int CLSID_DIRTYMASK   =  4;
    public static final int CLSITEMBUSID_DIRTYGROUP  =  0;
    public static final int CLSITEMBUSID_DIRTYMASK   =  8;
    public static final int PARENTITEMID_DIRTYGROUP  =  0;
    public static final int PARENTITEMID_DIRTYMASK   =  16;
    public static final int CLASSIFIERITEMDESCR_DIRTYGROUP  =  0;
    public static final int CLASSIFIERITEMDESCR_DIRTYMASK   =  32;
    public static final int CLASSIFIERITEMPATH_DIRTYGROUP  =  0;
    public static final int CLASSIFIERITEMPATH_DIRTYMASK   =  64;
    public static final int CLASSIFIERITEMDEPTH_DIRTYGROUP  =  0;
    public static final int CLASSIFIERITEMDEPTH_DIRTYMASK   =  128;
    public static final int CLASSIFIERITEMORDER_DIRTYGROUP  =  0;
    public static final int CLASSIFIERITEMORDER_DIRTYMASK   =  256;
    public static final int CLASSIFIERITEMIATTR_DIRTYGROUP  =  0;
    public static final int CLASSIFIERITEMIATTR_DIRTYMASK   =  512;
    public static final int CLASSIFIERITEMSATTR_DIRTYGROUP  =  0;
    public static final int CLASSIFIERITEMSATTR_DIRTYMASK   =  1024;


    /**
      * DataBean constructor.
      */
    public ClassifierItemDTOBase()
    {
       dirtyFlagsArray = new int[11 / 30 + 1];
       clearDirtyFlags();

       clsitemid = CLSITEMID_DEFAULT;
       site = SITE_DEFAULT;
       clsid = CLSID_DEFAULT;
       clsitembusid = CLSITEMBUSID_DEFAULT;
       parentitemid = PARENTITEMID_DEFAULT;
       classifieritemdescr = CLASSIFIERITEMDESCR_DEFAULT;
       classifieritempath = CLASSIFIERITEMPATH_DEFAULT;
       classifieritemdepth = CLASSIFIERITEMDEPTH_DEFAULT;
       classifieritemorder = CLASSIFIERITEMORDER_DEFAULT;
       classifieritemiattr = CLASSIFIERITEMIATTR_DEFAULT;
       classifieritemsattr = CLASSIFIERITEMSATTR_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ClassifierItemDTOBase(ClassifierItemDTOBase another)
    {

       clsitemid = another.getClsitemid();
       site = another.getSite();
       clsid = another.getClsid();
       clsitembusid = another.getClsitembusid();
       parentitemid = another.getParentitemid();
       classifieritemdescr = another.getClassifieritemdescr();
       classifieritempath = another.getClassifieritempath();
       classifieritemdepth = another.getClassifieritemdepth();
       classifieritemorder = another.getClassifieritemorder();
       classifieritemiattr = another.getClassifieritemiattr();
       classifieritemsattr = another.getClassifieritemsattr();

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
        stb.append(clsitemid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (classifieritemdescr != null)
        {
        stb.append(classifieritemdescr);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // clsitemid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClsitemidDirty()  { return checkFieldDirtiness(CLSITEMID_DIRTYGROUP, CLSITEMID_DIRTYMASK); }

    public java.lang.String   getClsitemid()         { return clsitemid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "clsitemid")
    public java.lang.String   getClsitemidAsString() { return (clsitemid == null) ? "" : clsitemid; }

    // clsitemid setter methods.
    
    protected void markClsitemidAsDirty(boolean aFlag)  { markFieldAsDirty(CLSITEMID_DIRTYGROUP, CLSITEMID_DIRTYMASK, aFlag); }


    public void setClsitemid(String  p)
    {
       setClsitemid(p, DTOCasingStyle.none);
    }
    
    public void setClsitemid(String  p, DTOCasingStyle casingStyle)
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
       markClsitemidAsDirty(!equalsObject(clsitemid, p));
       clsitemid = p;
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

    // clsid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClsidDirty()  { return checkFieldDirtiness(CLSID_DIRTYGROUP, CLSID_DIRTYMASK); }

    public java.lang.String   getClsid()         { return clsid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "clsid")
    public java.lang.String   getClsidAsString() { return (clsid == null) ? "" : clsid; }

    // clsid setter methods.
    
    protected void markClsidAsDirty(boolean aFlag)  { markFieldAsDirty(CLSID_DIRTYGROUP, CLSID_DIRTYMASK, aFlag); }


    public void setClsid(String  p)
    {
       setClsid(p, DTOCasingStyle.none);
    }
    
    public void setClsid(String  p, DTOCasingStyle casingStyle)
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
       markClsidAsDirty(!equalsObject(clsid, p));
       clsid = p;
    }

    // clsitembusid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClsitembusidDirty()  { return checkFieldDirtiness(CLSITEMBUSID_DIRTYGROUP, CLSITEMBUSID_DIRTYMASK); }

    public java.lang.String   getClsitembusid()         { return clsitembusid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "clsitembusid")
    public java.lang.String   getClsitembusidAsString() { return (clsitembusid == null) ? "" : clsitembusid; }

    // clsitembusid setter methods.
    
    protected void markClsitembusidAsDirty(boolean aFlag)  { markFieldAsDirty(CLSITEMBUSID_DIRTYGROUP, CLSITEMBUSID_DIRTYMASK, aFlag); }


    public void setClsitembusid(String  p)
    {
       setClsitembusid(p, DTOCasingStyle.none);
    }
    
    public void setClsitembusid(String  p, DTOCasingStyle casingStyle)
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
       markClsitembusidAsDirty(!equalsObject(clsitembusid, p));
       clsitembusid = p;
    }

    // parentitemid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isParentitemidDirty()  { return checkFieldDirtiness(PARENTITEMID_DIRTYGROUP, PARENTITEMID_DIRTYMASK); }

    public java.lang.String   getParentitemid()         { return parentitemid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "parentitemid")
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

    // classifieritemdescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClassifieritemdescrDirty()  { return checkFieldDirtiness(CLASSIFIERITEMDESCR_DIRTYGROUP, CLASSIFIERITEMDESCR_DIRTYMASK); }

    public java.lang.String   getClassifieritemdescr()         { return classifieritemdescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "classifieritemdescr")
    public java.lang.String   getClassifieritemdescrAsString() { return (classifieritemdescr == null) ? "" : classifieritemdescr; }

    // classifieritemdescr setter methods.
    
    protected void markClassifieritemdescrAsDirty(boolean aFlag)  { markFieldAsDirty(CLASSIFIERITEMDESCR_DIRTYGROUP, CLASSIFIERITEMDESCR_DIRTYMASK, aFlag); }


    public void setClassifieritemdescr(String  p)
    {
       setClassifieritemdescr(p, DTOCasingStyle.none);
    }
    
    public void setClassifieritemdescr(String  p, DTOCasingStyle casingStyle)
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
       markClassifieritemdescrAsDirty(!equalsObject(classifieritemdescr, p));
       classifieritemdescr = p;
    }

    // classifieritempath getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClassifieritempathDirty()  { return checkFieldDirtiness(CLASSIFIERITEMPATH_DIRTYGROUP, CLASSIFIERITEMPATH_DIRTYMASK); }

    public java.lang.String   getClassifieritempath()         { return classifieritempath; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "classifieritempath")
    public java.lang.String   getClassifieritempathAsString() { return (classifieritempath == null) ? "" : classifieritempath; }

    // classifieritempath setter methods.
    
    protected void markClassifieritempathAsDirty(boolean aFlag)  { markFieldAsDirty(CLASSIFIERITEMPATH_DIRTYGROUP, CLASSIFIERITEMPATH_DIRTYMASK, aFlag); }


    public void setClassifieritempath(String  p)
    {
       setClassifieritempath(p, DTOCasingStyle.none);
    }
    
    public void setClassifieritempath(String  p, DTOCasingStyle casingStyle)
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
       markClassifieritempathAsDirty(!equalsObject(classifieritempath, p));
       classifieritempath = p;
    }

    // classifieritemdepth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClassifieritemdepthDirty()  { return checkFieldDirtiness(CLASSIFIERITEMDEPTH_DIRTYGROUP, CLASSIFIERITEMDEPTH_DIRTYMASK); }

    public java.lang.Integer   getClassifieritemdepth() { return classifieritemdepth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "classifieritemdepth")
    public String getClassifieritemdepthAsString() { return integerAsString(classifieritemdepth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getClassifieritemdepthAsInt()    { return classifieritemdepth != null ? classifieritemdepth.intValue() : 0; }

    // classifieritemdepth setter methods.
    
    protected void markClassifieritemdepthAsDirty(boolean aFlag)  { markFieldAsDirty(CLASSIFIERITEMDEPTH_DIRTYGROUP, CLASSIFIERITEMDEPTH_DIRTYMASK, aFlag); }


    public void setClassifieritemdepth(java.lang.Integer  p)
    {
        markClassifieritemdepthAsDirty(!equalsObject(classifieritemdepth, p));
    	classifieritemdepth = p;
    }
    public void setClassifieritemdepth(int p)
    {
    	setClassifieritemdepth(new java.lang.Integer(p));
    }
    public void setClassifieritemdepth()
    {
    	setClassifieritemdepth(0);
    }
    public void setClassifieritemdepth(String  p)
    {
    	setClassifieritemdepth(stringAsInteger(p));
    }

    // classifieritemorder getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClassifieritemorderDirty()  { return checkFieldDirtiness(CLASSIFIERITEMORDER_DIRTYGROUP, CLASSIFIERITEMORDER_DIRTYMASK); }

    public java.lang.Integer   getClassifieritemorder() { return classifieritemorder; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "classifieritemorder")
    public String getClassifieritemorderAsString() { return integerAsString(classifieritemorder); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getClassifieritemorderAsInt()    { return classifieritemorder != null ? classifieritemorder.intValue() : 0; }

    // classifieritemorder setter methods.
    
    protected void markClassifieritemorderAsDirty(boolean aFlag)  { markFieldAsDirty(CLASSIFIERITEMORDER_DIRTYGROUP, CLASSIFIERITEMORDER_DIRTYMASK, aFlag); }


    public void setClassifieritemorder(java.lang.Integer  p)
    {
        markClassifieritemorderAsDirty(!equalsObject(classifieritemorder, p));
    	classifieritemorder = p;
    }
    public void setClassifieritemorder(int p)
    {
    	setClassifieritemorder(new java.lang.Integer(p));
    }
    public void setClassifieritemorder()
    {
    	setClassifieritemorder(0);
    }
    public void setClassifieritemorder(String  p)
    {
    	setClassifieritemorder(stringAsInteger(p));
    }

    // classifieritemiattr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClassifieritemiattrDirty()  { return checkFieldDirtiness(CLASSIFIERITEMIATTR_DIRTYGROUP, CLASSIFIERITEMIATTR_DIRTYMASK); }

    public java.lang.Integer   getClassifieritemiattr() { return classifieritemiattr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "classifieritemiattr")
    public String getClassifieritemiattrAsString() { return integerAsString(classifieritemiattr); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getClassifieritemiattrAsInt()    { return classifieritemiattr != null ? classifieritemiattr.intValue() : 0; }

    // classifieritemiattr setter methods.
    
    protected void markClassifieritemiattrAsDirty(boolean aFlag)  { markFieldAsDirty(CLASSIFIERITEMIATTR_DIRTYGROUP, CLASSIFIERITEMIATTR_DIRTYMASK, aFlag); }


    public void setClassifieritemiattr(java.lang.Integer  p)
    {
        markClassifieritemiattrAsDirty(!equalsObject(classifieritemiattr, p));
    	classifieritemiattr = p;
    }
    public void setClassifieritemiattr(int p)
    {
    	setClassifieritemiattr(new java.lang.Integer(p));
    }
    public void setClassifieritemiattr()
    {
    	setClassifieritemiattr(0);
    }
    public void setClassifieritemiattr(String  p)
    {
    	setClassifieritemiattr(stringAsInteger(p));
    }

    // classifieritemsattr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClassifieritemsattrDirty()  { return checkFieldDirtiness(CLASSIFIERITEMSATTR_DIRTYGROUP, CLASSIFIERITEMSATTR_DIRTYMASK); }

    public java.lang.String   getClassifieritemsattr()         { return classifieritemsattr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "classifieritemsattr")
    public java.lang.String   getClassifieritemsattrAsString() { return (classifieritemsattr == null) ? "" : classifieritemsattr; }

    // classifieritemsattr setter methods.
    
    protected void markClassifieritemsattrAsDirty(boolean aFlag)  { markFieldAsDirty(CLASSIFIERITEMSATTR_DIRTYGROUP, CLASSIFIERITEMSATTR_DIRTYMASK, aFlag); }


    public void setClassifieritemsattr(String  p)
    {
       setClassifieritemsattr(p, DTOCasingStyle.none);
    }
    
    public void setClassifieritemsattr(String  p, DTOCasingStyle casingStyle)
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
       markClassifieritemsattrAsDirty(!equalsObject(classifieritemsattr, p));
       classifieritemsattr = p;
    }

}
