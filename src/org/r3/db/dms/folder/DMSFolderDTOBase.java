//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.folder;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "DMSFolderDTOBase")
public class DMSFolderDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  folderid;
    protected java.lang.String  deviceid;
    protected java.lang.String  folderlogicalpath;
    protected java.lang.String  folderphysicalpath;
    protected java.lang.String  folderstatus;
    protected java.lang.Integer  folderdepth;

    public static final java.lang.String FOLDERID_DEFAULT  =  null;
    public static final java.lang.String DEVICEID_DEFAULT  =  null;
    public static final java.lang.String FOLDERLOGICALPATH_DEFAULT  =  null;
    public static final java.lang.String FOLDERPHYSICALPATH_DEFAULT  =  null;
    public static final java.lang.String FOLDERSTATUS_DEFAULT  =  null;
    public static final java.lang.Integer FOLDERDEPTH_DEFAULT  =  null;

    public static final int FOLDERID_DIRTYGROUP  =  0;
    public static final int FOLDERID_DIRTYMASK   =  1;
    public static final int DEVICEID_DIRTYGROUP  =  0;
    public static final int DEVICEID_DIRTYMASK   =  2;
    public static final int FOLDERLOGICALPATH_DIRTYGROUP  =  0;
    public static final int FOLDERLOGICALPATH_DIRTYMASK   =  4;
    public static final int FOLDERPHYSICALPATH_DIRTYGROUP  =  0;
    public static final int FOLDERPHYSICALPATH_DIRTYMASK   =  8;
    public static final int FOLDERSTATUS_DIRTYGROUP  =  0;
    public static final int FOLDERSTATUS_DIRTYMASK   =  16;
    public static final int FOLDERDEPTH_DIRTYGROUP  =  0;
    public static final int FOLDERDEPTH_DIRTYMASK   =  32;


    /**
      * DataBean constructor.
      */
    public DMSFolderDTOBase()
    {
       dirtyFlagsArray = new int[6 / 30 + 1];
       clearDirtyFlags();

       folderid = FOLDERID_DEFAULT;
       deviceid = DEVICEID_DEFAULT;
       folderlogicalpath = FOLDERLOGICALPATH_DEFAULT;
       folderphysicalpath = FOLDERPHYSICALPATH_DEFAULT;
       folderstatus = FOLDERSTATUS_DEFAULT;
       folderdepth = FOLDERDEPTH_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public DMSFolderDTOBase(DMSFolderDTOBase another)
    {

       folderid = another.getFolderid();
       deviceid = another.getDeviceid();
       folderlogicalpath = another.getFolderlogicalpath();
       folderphysicalpath = another.getFolderphysicalpath();
       folderstatus = another.getFolderstatus();
       folderdepth = another.getFolderdepth();

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
        stb.append(folderid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(folderlogicalpath);
        return stb.toString();
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // folderid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFolderidDirty()  { return checkFieldDirtiness(FOLDERID_DIRTYGROUP, FOLDERID_DIRTYMASK); }

    public java.lang.String   getFolderid()         { return folderid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFolderidAsString() { return (folderid == null) ? "" : folderid; }

    // folderid setter methods.
    
    protected void markFolderidAsDirty(boolean aFlag)  { markFieldAsDirty(FOLDERID_DIRTYGROUP, FOLDERID_DIRTYMASK, aFlag); }


    public void setFolderid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFolderidAsDirty(!equalsObject(folderid, p));
         folderid = p;
    }

    // deviceid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDeviceidDirty()  { return checkFieldDirtiness(DEVICEID_DIRTYGROUP, DEVICEID_DIRTYMASK); }

    public java.lang.String   getDeviceid()         { return deviceid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getDeviceidAsString() { return (deviceid == null) ? "" : deviceid; }

    // deviceid setter methods.
    
    protected void markDeviceidAsDirty(boolean aFlag)  { markFieldAsDirty(DEVICEID_DIRTYGROUP, DEVICEID_DIRTYMASK, aFlag); }


    public void setDeviceid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markDeviceidAsDirty(!equalsObject(deviceid, p));
         deviceid = p;
    }

    // folderlogicalpath getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFolderlogicalpathDirty()  { return checkFieldDirtiness(FOLDERLOGICALPATH_DIRTYGROUP, FOLDERLOGICALPATH_DIRTYMASK); }

    public java.lang.String   getFolderlogicalpath()         { return folderlogicalpath; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFolderlogicalpathAsString() { return (folderlogicalpath == null) ? "" : folderlogicalpath; }

    // folderlogicalpath setter methods.
    
    protected void markFolderlogicalpathAsDirty(boolean aFlag)  { markFieldAsDirty(FOLDERLOGICALPATH_DIRTYGROUP, FOLDERLOGICALPATH_DIRTYMASK, aFlag); }


    public void setFolderlogicalpath(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFolderlogicalpathAsDirty(!equalsObject(folderlogicalpath, p));
         folderlogicalpath = p;
    }

    // folderphysicalpath getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFolderphysicalpathDirty()  { return checkFieldDirtiness(FOLDERPHYSICALPATH_DIRTYGROUP, FOLDERPHYSICALPATH_DIRTYMASK); }

    public java.lang.String   getFolderphysicalpath()         { return folderphysicalpath; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFolderphysicalpathAsString() { return (folderphysicalpath == null) ? "" : folderphysicalpath; }

    // folderphysicalpath setter methods.
    
    protected void markFolderphysicalpathAsDirty(boolean aFlag)  { markFieldAsDirty(FOLDERPHYSICALPATH_DIRTYGROUP, FOLDERPHYSICALPATH_DIRTYMASK, aFlag); }


    public void setFolderphysicalpath(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFolderphysicalpathAsDirty(!equalsObject(folderphysicalpath, p));
         folderphysicalpath = p;
    }

    // folderstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFolderstatusDirty()  { return checkFieldDirtiness(FOLDERSTATUS_DIRTYGROUP, FOLDERSTATUS_DIRTYMASK); }

    public java.lang.String   getFolderstatus()         { return folderstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFolderstatusAsString() { return (folderstatus == null) ? "" : folderstatus; }

    // folderstatus setter methods.
    
    protected void markFolderstatusAsDirty(boolean aFlag)  { markFieldAsDirty(FOLDERSTATUS_DIRTYGROUP, FOLDERSTATUS_DIRTYMASK, aFlag); }


    public void setFolderstatus(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFolderstatusAsDirty(!equalsObject(folderstatus, p));
         folderstatus = p;
    }

    // folderdepth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFolderdepthDirty()  { return checkFieldDirtiness(FOLDERDEPTH_DIRTYGROUP, FOLDERDEPTH_DIRTYMASK); }

    public java.lang.Integer   getFolderdepth() { return folderdepth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getFolderdepthAsString() { return integerAsString(folderdepth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getFolderdepthAsInt()    { return folderdepth != null ? folderdepth.intValue() : 0; }

    // folderdepth setter methods.
    
    protected void markFolderdepthAsDirty(boolean aFlag)  { markFieldAsDirty(FOLDERDEPTH_DIRTYGROUP, FOLDERDEPTH_DIRTYMASK, aFlag); }


    public void setFolderdepth(java.lang.Integer  p)
    {
        markFolderdepthAsDirty(!equalsObject(folderdepth, p));
    	folderdepth = p;
    }
    public void setFolderdepth(int p)
    {
    	setFolderdepth(new java.lang.Integer(p));
    }
    public void setFolderdepth()
    {
    	setFolderdepth(0);
    }
    public void setFolderdepth(String  p)
    {
    	setFolderdepth(stringAsInteger(p));
    }

}
