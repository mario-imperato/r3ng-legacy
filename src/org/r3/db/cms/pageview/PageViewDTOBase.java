//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.cms.pageview;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "PageViewDTOBase")
public class PageViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  pageid;
    protected java.lang.String  languagecode;
    protected java.lang.String  pagetype;
    protected java.lang.String  pagetitle;
    protected java.lang.String  summary;
    protected java.lang.String  pageicon1;
    protected java.lang.String  pageicon2;
    protected java.lang.String  pagelink;
    protected java.lang.Integer  pageorder;
    protected java.lang.String  visibility;
    protected java.lang.String  pagestyle;
    protected java.lang.String  forwardview;
    protected java.lang.String  onuserstatus;
    protected java.lang.String  permissions;
    protected java.lang.String  viewoptions;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String PAGEID_DEFAULT  =  null;
    public static final java.lang.String LANGUAGECODE_DEFAULT  =  null;
    public static final java.lang.String PAGETYPE_DEFAULT  =  null;
    public static final java.lang.String PAGETITLE_DEFAULT  =  null;
    public static final java.lang.String SUMMARY_DEFAULT  =  null;
    public static final java.lang.String PAGEICON1_DEFAULT  =  null;
    public static final java.lang.String PAGEICON2_DEFAULT  =  null;
    public static final java.lang.String PAGELINK_DEFAULT  =  null;
    public static final java.lang.Integer PAGEORDER_DEFAULT  =  null;
    public static final java.lang.String VISIBILITY_DEFAULT  =  null;
    public static final java.lang.String PAGESTYLE_DEFAULT  =  null;
    public static final java.lang.String FORWARDVIEW_DEFAULT  =  null;
    public static final java.lang.String ONUSERSTATUS_DEFAULT  =  null;
    public static final java.lang.String PERMISSIONS_DEFAULT  =  null;
    public static final java.lang.String VIEWOPTIONS_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int PAGEID_DIRTYGROUP  =  0;
    public static final int PAGEID_DIRTYMASK   =  2;
    public static final int LANGUAGECODE_DIRTYGROUP  =  0;
    public static final int LANGUAGECODE_DIRTYMASK   =  4;
    public static final int PAGETYPE_DIRTYGROUP  =  0;
    public static final int PAGETYPE_DIRTYMASK   =  8;
    public static final int PAGETITLE_DIRTYGROUP  =  0;
    public static final int PAGETITLE_DIRTYMASK   =  16;
    public static final int SUMMARY_DIRTYGROUP  =  0;
    public static final int SUMMARY_DIRTYMASK   =  32;
    public static final int PAGEICON1_DIRTYGROUP  =  0;
    public static final int PAGEICON1_DIRTYMASK   =  64;
    public static final int PAGEICON2_DIRTYGROUP  =  0;
    public static final int PAGEICON2_DIRTYMASK   =  128;
    public static final int PAGELINK_DIRTYGROUP  =  0;
    public static final int PAGELINK_DIRTYMASK   =  256;
    public static final int PAGEORDER_DIRTYGROUP  =  0;
    public static final int PAGEORDER_DIRTYMASK   =  512;
    public static final int VISIBILITY_DIRTYGROUP  =  0;
    public static final int VISIBILITY_DIRTYMASK   =  1024;
    public static final int PAGESTYLE_DIRTYGROUP  =  0;
    public static final int PAGESTYLE_DIRTYMASK   =  2048;
    public static final int FORWARDVIEW_DIRTYGROUP  =  0;
    public static final int FORWARDVIEW_DIRTYMASK   =  4096;
    public static final int ONUSERSTATUS_DIRTYGROUP  =  0;
    public static final int ONUSERSTATUS_DIRTYMASK   =  8192;
    public static final int PERMISSIONS_DIRTYGROUP  =  0;
    public static final int PERMISSIONS_DIRTYMASK   =  16384;
    public static final int VIEWOPTIONS_DIRTYGROUP  =  0;
    public static final int VIEWOPTIONS_DIRTYMASK   =  32768;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  65536;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  131072;


    /**
      * DataBean constructor.
      */
    public PageViewDTOBase()
    {
       dirtyFlagsArray = new int[18 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       pageid = PAGEID_DEFAULT;
       languagecode = LANGUAGECODE_DEFAULT;
       pagetype = PAGETYPE_DEFAULT;
       pagetitle = PAGETITLE_DEFAULT;
       summary = SUMMARY_DEFAULT;
       pageicon1 = PAGEICON1_DEFAULT;
       pageicon2 = PAGEICON2_DEFAULT;
       pagelink = PAGELINK_DEFAULT;
       pageorder = PAGEORDER_DEFAULT;
       visibility = VISIBILITY_DEFAULT;
       pagestyle = PAGESTYLE_DEFAULT;
       forwardview = FORWARDVIEW_DEFAULT;
       onuserstatus = ONUSERSTATUS_DEFAULT;
       permissions = PERMISSIONS_DEFAULT;
       viewoptions = VIEWOPTIONS_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public PageViewDTOBase(PageViewDTOBase another)
    {

       site = another.getSite();
       pageid = another.getPageid();
       languagecode = another.getLanguagecode();
       pagetype = another.getPagetype();
       pagetitle = another.getPagetitle();
       summary = another.getSummary();
       pageicon1 = another.getPageicon1();
       pageicon2 = another.getPageicon2();
       pagelink = another.getPagelink();
       pageorder = another.getPageorder();
       visibility = another.getVisibility();
       pagestyle = another.getPagestyle();
       forwardview = another.getForwardview();
       onuserstatus = another.getOnuserstatus();
       permissions = another.getPermissions();
       viewoptions = another.getViewoptions();
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
        stb.append(pageid);
        stb.append(", ");
        stb.append(languagecode);
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

    // pagetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPagetypeDirty()  { return checkFieldDirtiness(PAGETYPE_DIRTYGROUP, PAGETYPE_DIRTYMASK); }

    public java.lang.String   getPagetype()         { return pagetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pagetype")
    public java.lang.String   getPagetypeAsString() { return (pagetype == null) ? "" : pagetype; }

    // pagetype setter methods.
    
    protected void markPagetypeAsDirty(boolean aFlag)  { markFieldAsDirty(PAGETYPE_DIRTYGROUP, PAGETYPE_DIRTYMASK, aFlag); }


    public void setPagetype(String  p)
    {
       setPagetype(p, DTOCasingStyle.none);
    }
    
    public void setPagetype(String  p, DTOCasingStyle casingStyle)
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
       markPagetypeAsDirty(!equalsObject(pagetype, p));
       pagetype = p;
    }

    // pagetitle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPagetitleDirty()  { return checkFieldDirtiness(PAGETITLE_DIRTYGROUP, PAGETITLE_DIRTYMASK); }

    public java.lang.String   getPagetitle()         { return pagetitle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pagetitle")
    public java.lang.String   getPagetitleAsString() { return (pagetitle == null) ? "" : pagetitle; }

    // pagetitle setter methods.
    
    protected void markPagetitleAsDirty(boolean aFlag)  { markFieldAsDirty(PAGETITLE_DIRTYGROUP, PAGETITLE_DIRTYMASK, aFlag); }


    public void setPagetitle(String  p)
    {
       setPagetitle(p, DTOCasingStyle.none);
    }
    
    public void setPagetitle(String  p, DTOCasingStyle casingStyle)
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
       markPagetitleAsDirty(!equalsObject(pagetitle, p));
       pagetitle = p;
    }

    // summary getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSummaryDirty()  { return checkFieldDirtiness(SUMMARY_DIRTYGROUP, SUMMARY_DIRTYMASK); }

    public java.lang.String   getSummary()         { return summary; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "summary")
    public java.lang.String   getSummaryAsString() { return (summary == null) ? "" : summary; }

    // summary setter methods.
    
    protected void markSummaryAsDirty(boolean aFlag)  { markFieldAsDirty(SUMMARY_DIRTYGROUP, SUMMARY_DIRTYMASK, aFlag); }


    public void setSummary(String  p)
    {
       setSummary(p, DTOCasingStyle.none);
    }
    
    public void setSummary(String  p, DTOCasingStyle casingStyle)
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
       markSummaryAsDirty(!equalsObject(summary, p));
       summary = p;
    }

    // pageicon1 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPageicon1Dirty()  { return checkFieldDirtiness(PAGEICON1_DIRTYGROUP, PAGEICON1_DIRTYMASK); }

    public java.lang.String   getPageicon1()         { return pageicon1; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pageicon1")
    public java.lang.String   getPageicon1AsString() { return (pageicon1 == null) ? "" : pageicon1; }

    // pageicon1 setter methods.
    
    protected void markPageicon1AsDirty(boolean aFlag)  { markFieldAsDirty(PAGEICON1_DIRTYGROUP, PAGEICON1_DIRTYMASK, aFlag); }


    public void setPageicon1(String  p)
    {
       setPageicon1(p, DTOCasingStyle.none);
    }
    
    public void setPageicon1(String  p, DTOCasingStyle casingStyle)
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
       markPageicon1AsDirty(!equalsObject(pageicon1, p));
       pageicon1 = p;
    }

    // pageicon2 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPageicon2Dirty()  { return checkFieldDirtiness(PAGEICON2_DIRTYGROUP, PAGEICON2_DIRTYMASK); }

    public java.lang.String   getPageicon2()         { return pageicon2; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pageicon2")
    public java.lang.String   getPageicon2AsString() { return (pageicon2 == null) ? "" : pageicon2; }

    // pageicon2 setter methods.
    
    protected void markPageicon2AsDirty(boolean aFlag)  { markFieldAsDirty(PAGEICON2_DIRTYGROUP, PAGEICON2_DIRTYMASK, aFlag); }


    public void setPageicon2(String  p)
    {
       setPageicon2(p, DTOCasingStyle.none);
    }
    
    public void setPageicon2(String  p, DTOCasingStyle casingStyle)
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
       markPageicon2AsDirty(!equalsObject(pageicon2, p));
       pageicon2 = p;
    }

    // pagelink getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPagelinkDirty()  { return checkFieldDirtiness(PAGELINK_DIRTYGROUP, PAGELINK_DIRTYMASK); }

    public java.lang.String   getPagelink()         { return pagelink; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pagelink")
    public java.lang.String   getPagelinkAsString() { return (pagelink == null) ? "" : pagelink; }

    // pagelink setter methods.
    
    protected void markPagelinkAsDirty(boolean aFlag)  { markFieldAsDirty(PAGELINK_DIRTYGROUP, PAGELINK_DIRTYMASK, aFlag); }


    public void setPagelink(String  p)
    {
       setPagelink(p, DTOCasingStyle.none);
    }
    
    public void setPagelink(String  p, DTOCasingStyle casingStyle)
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
       markPagelinkAsDirty(!equalsObject(pagelink, p));
       pagelink = p;
    }

    // pageorder getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPageorderDirty()  { return checkFieldDirtiness(PAGEORDER_DIRTYGROUP, PAGEORDER_DIRTYMASK); }

    public java.lang.Integer   getPageorder() { return pageorder; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pageorder")
    public String getPageorderAsString() { return integerAsString(pageorder); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getPageorderAsInt()    { return pageorder != null ? pageorder.intValue() : 0; }

    // pageorder setter methods.
    
    protected void markPageorderAsDirty(boolean aFlag)  { markFieldAsDirty(PAGEORDER_DIRTYGROUP, PAGEORDER_DIRTYMASK, aFlag); }


    public void setPageorder(java.lang.Integer  p)
    {
        markPageorderAsDirty(!equalsObject(pageorder, p));
    	pageorder = p;
    }
    public void setPageorder(int p)
    {
    	setPageorder(new java.lang.Integer(p));
    }
    public void setPageorder()
    {
    	setPageorder(0);
    }
    public void setPageorder(String  p)
    {
    	setPageorder(stringAsInteger(p));
    }

    // visibility getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isVisibilityDirty()  { return checkFieldDirtiness(VISIBILITY_DIRTYGROUP, VISIBILITY_DIRTYMASK); }

    public java.lang.String   getVisibility()         { return visibility; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "visibility")
    public java.lang.String   getVisibilityAsString() { return (visibility == null) ? "" : visibility; }

    // visibility setter methods.
    
    protected void markVisibilityAsDirty(boolean aFlag)  { markFieldAsDirty(VISIBILITY_DIRTYGROUP, VISIBILITY_DIRTYMASK, aFlag); }


    public void setVisibility(String  p)
    {
       setVisibility(p, DTOCasingStyle.none);
    }
    
    public void setVisibility(String  p, DTOCasingStyle casingStyle)
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
       markVisibilityAsDirty(!equalsObject(visibility, p));
       visibility = p;
    }

    // pagestyle getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPagestyleDirty()  { return checkFieldDirtiness(PAGESTYLE_DIRTYGROUP, PAGESTYLE_DIRTYMASK); }

    public java.lang.String   getPagestyle()         { return pagestyle; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "pagestyle")
    public java.lang.String   getPagestyleAsString() { return (pagestyle == null) ? "" : pagestyle; }

    // pagestyle setter methods.
    
    protected void markPagestyleAsDirty(boolean aFlag)  { markFieldAsDirty(PAGESTYLE_DIRTYGROUP, PAGESTYLE_DIRTYMASK, aFlag); }


    public void setPagestyle(String  p)
    {
       setPagestyle(p, DTOCasingStyle.none);
    }
    
    public void setPagestyle(String  p, DTOCasingStyle casingStyle)
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
       markPagestyleAsDirty(!equalsObject(pagestyle, p));
       pagestyle = p;
    }

    // forwardview getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isForwardviewDirty()  { return checkFieldDirtiness(FORWARDVIEW_DIRTYGROUP, FORWARDVIEW_DIRTYMASK); }

    public java.lang.String   getForwardview()         { return forwardview; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "forwardview")
    public java.lang.String   getForwardviewAsString() { return (forwardview == null) ? "" : forwardview; }

    // forwardview setter methods.
    
    protected void markForwardviewAsDirty(boolean aFlag)  { markFieldAsDirty(FORWARDVIEW_DIRTYGROUP, FORWARDVIEW_DIRTYMASK, aFlag); }


    public void setForwardview(String  p)
    {
       setForwardview(p, DTOCasingStyle.none);
    }
    
    public void setForwardview(String  p, DTOCasingStyle casingStyle)
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
       markForwardviewAsDirty(!equalsObject(forwardview, p));
       forwardview = p;
    }

    // onuserstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOnuserstatusDirty()  { return checkFieldDirtiness(ONUSERSTATUS_DIRTYGROUP, ONUSERSTATUS_DIRTYMASK); }

    public java.lang.String   getOnuserstatus()         { return onuserstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "onuserstatus")
    public java.lang.String   getOnuserstatusAsString() { return (onuserstatus == null) ? "" : onuserstatus; }

    // onuserstatus setter methods.
    
    protected void markOnuserstatusAsDirty(boolean aFlag)  { markFieldAsDirty(ONUSERSTATUS_DIRTYGROUP, ONUSERSTATUS_DIRTYMASK, aFlag); }


    public void setOnuserstatus(String  p)
    {
       setOnuserstatus(p, DTOCasingStyle.none);
    }
    
    public void setOnuserstatus(String  p, DTOCasingStyle casingStyle)
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
       markOnuserstatusAsDirty(!equalsObject(onuserstatus, p));
       onuserstatus = p;
    }

    // permissions getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPermissionsDirty()  { return checkFieldDirtiness(PERMISSIONS_DIRTYGROUP, PERMISSIONS_DIRTYMASK); }

    public java.lang.String   getPermissions()         { return permissions; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "permissions")
    public java.lang.String   getPermissionsAsString() { return (permissions == null) ? "" : permissions; }

    // permissions setter methods.
    
    protected void markPermissionsAsDirty(boolean aFlag)  { markFieldAsDirty(PERMISSIONS_DIRTYGROUP, PERMISSIONS_DIRTYMASK, aFlag); }


    public void setPermissions(String  p)
    {
       setPermissions(p, DTOCasingStyle.none);
    }
    
    public void setPermissions(String  p, DTOCasingStyle casingStyle)
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
       markPermissionsAsDirty(!equalsObject(permissions, p));
       permissions = p;
    }

    // viewoptions getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isViewoptionsDirty()  { return checkFieldDirtiness(VIEWOPTIONS_DIRTYGROUP, VIEWOPTIONS_DIRTYMASK); }

    public java.lang.String   getViewoptions()         { return viewoptions; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "viewoptions")
    public java.lang.String   getViewoptionsAsString() { return (viewoptions == null) ? "" : viewoptions; }

    // viewoptions setter methods.
    
    protected void markViewoptionsAsDirty(boolean aFlag)  { markFieldAsDirty(VIEWOPTIONS_DIRTYGROUP, VIEWOPTIONS_DIRTYMASK, aFlag); }


    public void setViewoptions(String  p)
    {
       setViewoptions(p, DTOCasingStyle.none);
    }
    
    public void setViewoptions(String  p, DTOCasingStyle casingStyle)
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
       markViewoptionsAsDirty(!equalsObject(viewoptions, p));
       viewoptions = p;
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
