//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.device;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "DMSDeviceDTOBase")
public class DMSDeviceDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  deviceid;
    protected java.lang.String  devicename;
    protected java.lang.String  devicetype;

    public static final java.lang.String DEVICEID_DEFAULT  =  null;
    public static final java.lang.String DEVICENAME_DEFAULT  =  null;
    public static final java.lang.String DEVICETYPE_DEFAULT  =  null;

    public static final int DEVICEID_DIRTYGROUP  =  0;
    public static final int DEVICEID_DIRTYMASK   =  1;
    public static final int DEVICENAME_DIRTYGROUP  =  0;
    public static final int DEVICENAME_DIRTYMASK   =  2;
    public static final int DEVICETYPE_DIRTYGROUP  =  0;
    public static final int DEVICETYPE_DIRTYMASK   =  4;


    /**
      * DataBean constructor.
      */
    public DMSDeviceDTOBase()
    {
       dirtyFlagsArray = new int[3 / 30 + 1];
       clearDirtyFlags();

       deviceid = DEVICEID_DEFAULT;
       devicename = DEVICENAME_DEFAULT;
       devicetype = DEVICETYPE_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public DMSDeviceDTOBase(DMSDeviceDTOBase another)
    {

       deviceid = another.getDeviceid();
       devicename = another.getDevicename();
       devicetype = another.getDevicetype();

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
        stb.append(deviceid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(devicename);
        return stb.toString();
    }

    /**
      * DataBean Getter And Setter Accessor
      */

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

    // devicename getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDevicenameDirty()  { return checkFieldDirtiness(DEVICENAME_DIRTYGROUP, DEVICENAME_DIRTYMASK); }

    public java.lang.String   getDevicename()         { return devicename; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getDevicenameAsString() { return (devicename == null) ? "" : devicename; }

    // devicename setter methods.
    
    protected void markDevicenameAsDirty(boolean aFlag)  { markFieldAsDirty(DEVICENAME_DIRTYGROUP, DEVICENAME_DIRTYMASK, aFlag); }


    public void setDevicename(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markDevicenameAsDirty(!equalsObject(devicename, p));
         devicename = p;
    }

    // devicetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDevicetypeDirty()  { return checkFieldDirtiness(DEVICETYPE_DIRTYGROUP, DEVICETYPE_DIRTYMASK); }

    public java.lang.String   getDevicetype()         { return devicetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getDevicetypeAsString() { return (devicetype == null) ? "" : devicetype; }

    // devicetype setter methods.
    
    protected void markDevicetypeAsDirty(boolean aFlag)  { markFieldAsDirty(DEVICETYPE_DIRTYGROUP, DEVICETYPE_DIRTYMASK, aFlag); }


    public void setDevicetype(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markDevicetypeAsDirty(!equalsObject(devicetype, p));
         devicetype = p;
    }

}
