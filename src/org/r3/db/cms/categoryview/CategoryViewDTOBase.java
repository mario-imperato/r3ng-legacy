//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.categoryview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "CategoryViewDTOBase")
public class CategoryViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  categoryid;
    protected java.lang.String  categorymode;
    protected java.lang.String  languagecode;
    protected java.lang.String  categorydescr;
    protected java.lang.String  previewtmpl;
    protected java.lang.String  fulltmpl;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String CATEGORYID_DEFAULT  =  null;
    public static final java.lang.String CATEGORYMODE_DEFAULT  =  null;
    public static final java.lang.String LANGUAGECODE_DEFAULT  =  null;
    public static final java.lang.String CATEGORYDESCR_DEFAULT  =  null;
    public static final java.lang.String PREVIEWTMPL_DEFAULT  =  null;
    public static final java.lang.String FULLTMPL_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int CATEGORYID_DIRTYGROUP  =  0;
    public static final int CATEGORYID_DIRTYMASK   =  2;
    public static final int CATEGORYMODE_DIRTYGROUP  =  0;
    public static final int CATEGORYMODE_DIRTYMASK   =  4;
    public static final int LANGUAGECODE_DIRTYGROUP  =  0;
    public static final int LANGUAGECODE_DIRTYMASK   =  8;
    public static final int CATEGORYDESCR_DIRTYGROUP  =  0;
    public static final int CATEGORYDESCR_DIRTYMASK   =  16;
    public static final int PREVIEWTMPL_DIRTYGROUP  =  0;
    public static final int PREVIEWTMPL_DIRTYMASK   =  32;
    public static final int FULLTMPL_DIRTYGROUP  =  0;
    public static final int FULLTMPL_DIRTYMASK   =  64;


    /**
      * DataBean constructor.
      */
    public CategoryViewDTOBase()
    {
       dirtyFlagsArray = new int[7 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       categoryid = CATEGORYID_DEFAULT;
       categorymode = CATEGORYMODE_DEFAULT;
       languagecode = LANGUAGECODE_DEFAULT;
       categorydescr = CATEGORYDESCR_DEFAULT;
       previewtmpl = PREVIEWTMPL_DEFAULT;
       fulltmpl = FULLTMPL_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public CategoryViewDTOBase(CategoryViewDTOBase another)
    {

       site = another.getSite();
       categoryid = another.getCategoryid();
       categorymode = another.getCategorymode();
       languagecode = another.getLanguagecode();
       categorydescr = another.getCategorydescr();
       previewtmpl = another.getPreviewtmpl();
       fulltmpl = another.getFulltmpl();

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
        stb.append(categoryid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (categorydescr != null)
        {
        stb.append(categorydescr);
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

    // categoryid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCategoryidDirty()  { return checkFieldDirtiness(CATEGORYID_DIRTYGROUP, CATEGORYID_DIRTYMASK); }

    public java.lang.String   getCategoryid()         { return categoryid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "categoryid")
    public java.lang.String   getCategoryidAsString() { return (categoryid == null) ? "" : categoryid; }

    // categoryid setter methods.
    
    protected void markCategoryidAsDirty(boolean aFlag)  { markFieldAsDirty(CATEGORYID_DIRTYGROUP, CATEGORYID_DIRTYMASK, aFlag); }


    public void setCategoryid(String  p)
    {
       setCategoryid(p, DTOCasingStyle.none);
    }
    
    public void setCategoryid(String  p, DTOCasingStyle casingStyle)
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
       markCategoryidAsDirty(!equalsObject(categoryid, p));
       categoryid = p;
    }

    // categorymode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCategorymodeDirty()  { return checkFieldDirtiness(CATEGORYMODE_DIRTYGROUP, CATEGORYMODE_DIRTYMASK); }

    public java.lang.String   getCategorymode()         { return categorymode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "categorymode")
    public java.lang.String   getCategorymodeAsString() { return (categorymode == null) ? "" : categorymode; }

    // categorymode setter methods.
    
    protected void markCategorymodeAsDirty(boolean aFlag)  { markFieldAsDirty(CATEGORYMODE_DIRTYGROUP, CATEGORYMODE_DIRTYMASK, aFlag); }


    public void setCategorymode(String  p)
    {
       setCategorymode(p, DTOCasingStyle.none);
    }
    
    public void setCategorymode(String  p, DTOCasingStyle casingStyle)
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
       markCategorymodeAsDirty(!equalsObject(categorymode, p));
       categorymode = p;
    }

    // languagecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLanguagecodeDirty()  { return checkFieldDirtiness(LANGUAGECODE_DIRTYGROUP, LANGUAGECODE_DIRTYMASK); }

    public java.lang.String   getLanguagecode()         { return languagecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "languagecode")
    public java.lang.String   getLanguagecodeAsString() { return (languagecode == null) ? "" : languagecode; }

    // languagecode setter methods.
    
    protected void markLanguagecodeAsDirty(boolean aFlag)  { markFieldAsDirty(LANGUAGECODE_DIRTYGROUP, LANGUAGECODE_DIRTYMASK, aFlag); }


    public void setLanguagecode(String  p)
    {
       setLanguagecode(p, DTOCasingStyle.none);
    }
    
    public void setLanguagecode(String  p, DTOCasingStyle casingStyle)
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
       markLanguagecodeAsDirty(!equalsObject(languagecode, p));
       languagecode = p;
    }

    // categorydescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCategorydescrDirty()  { return checkFieldDirtiness(CATEGORYDESCR_DIRTYGROUP, CATEGORYDESCR_DIRTYMASK); }

    public java.lang.String   getCategorydescr()         { return categorydescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "categorydescr")
    public java.lang.String   getCategorydescrAsString() { return (categorydescr == null) ? "" : categorydescr; }

    // categorydescr setter methods.
    
    protected void markCategorydescrAsDirty(boolean aFlag)  { markFieldAsDirty(CATEGORYDESCR_DIRTYGROUP, CATEGORYDESCR_DIRTYMASK, aFlag); }


    public void setCategorydescr(String  p)
    {
       setCategorydescr(p, DTOCasingStyle.none);
    }
    
    public void setCategorydescr(String  p, DTOCasingStyle casingStyle)
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
       markCategorydescrAsDirty(!equalsObject(categorydescr, p));
       categorydescr = p;
    }

    // previewtmpl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPreviewtmplDirty()  { return checkFieldDirtiness(PREVIEWTMPL_DIRTYGROUP, PREVIEWTMPL_DIRTYMASK); }

    public java.lang.String   getPreviewtmpl()         { return previewtmpl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "previewtmpl")
    public java.lang.String   getPreviewtmplAsString() { return (previewtmpl == null) ? "" : previewtmpl; }

    // previewtmpl setter methods.
    
    protected void markPreviewtmplAsDirty(boolean aFlag)  { markFieldAsDirty(PREVIEWTMPL_DIRTYGROUP, PREVIEWTMPL_DIRTYMASK, aFlag); }


    public void setPreviewtmpl(String  p)
    {
       setPreviewtmpl(p, DTOCasingStyle.none);
    }
    
    public void setPreviewtmpl(String  p, DTOCasingStyle casingStyle)
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
       markPreviewtmplAsDirty(!equalsObject(previewtmpl, p));
       previewtmpl = p;
    }

    // fulltmpl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFulltmplDirty()  { return checkFieldDirtiness(FULLTMPL_DIRTYGROUP, FULLTMPL_DIRTYMASK); }

    public java.lang.String   getFulltmpl()         { return fulltmpl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "fulltmpl")
    public java.lang.String   getFulltmplAsString() { return (fulltmpl == null) ? "" : fulltmpl; }

    // fulltmpl setter methods.
    
    protected void markFulltmplAsDirty(boolean aFlag)  { markFieldAsDirty(FULLTMPL_DIRTYGROUP, FULLTMPL_DIRTYMASK, aFlag); }


    public void setFulltmpl(String  p)
    {
       setFulltmpl(p, DTOCasingStyle.none);
    }
    
    public void setFulltmpl(String  p, DTOCasingStyle casingStyle)
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
       markFulltmplAsDirty(!equalsObject(fulltmpl, p));
       fulltmpl = p;
    }

}
