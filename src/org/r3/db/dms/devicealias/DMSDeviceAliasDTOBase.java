//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.devicealias;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "DMSDeviceAliasDTOBase")
public class DMSDeviceAliasDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  deviceid;
    protected java.lang.String  clientid;
    protected java.lang.String  devicephysicalname;

    public static final java.lang.String DEVICEID_DEFAULT  =  null;
    public static final java.lang.String CLIENTID_DEFAULT  =  null;
    public static final java.lang.String DEVICEPHYSICALNAME_DEFAULT  =  null;

    public static final int DEVICEID_DIRTYGROUP  =  0;
    public static final int DEVICEID_DIRTYMASK   =  1;
    public static final int CLIENTID_DIRTYGROUP  =  0;
    public static final int CLIENTID_DIRTYMASK   =  2;
    public static final int DEVICEPHYSICALNAME_DIRTYGROUP  =  0;
    public static final int DEVICEPHYSICALNAME_DIRTYMASK   =  4;


    /**
      * DataBean constructor.
      */
    public DMSDeviceAliasDTOBase()
    {
       dirtyFlagsArray = new int[3 / 30 + 1];
       clearDirtyFlags();

       deviceid = DEVICEID_DEFAULT;
       clientid = CLIENTID_DEFAULT;
       devicephysicalname = DEVICEPHYSICALNAME_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public DMSDeviceAliasDTOBase(DMSDeviceAliasDTOBase another)
    {

       deviceid = another.getDeviceid();
       clientid = another.getClientid();
       devicephysicalname = another.getDevicephysicalname();

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
        stb.append(", ");
        stb.append(clientid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(devicephysicalname);
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

    // clientid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isClientidDirty()  { return checkFieldDirtiness(CLIENTID_DIRTYGROUP, CLIENTID_DIRTYMASK); }

    public java.lang.String   getClientid()         { return clientid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getClientidAsString() { return (clientid == null) ? "" : clientid; }

    // clientid setter methods.
    
    protected void markClientidAsDirty(boolean aFlag)  { markFieldAsDirty(CLIENTID_DIRTYGROUP, CLIENTID_DIRTYMASK, aFlag); }


    public void setClientid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markClientidAsDirty(!equalsObject(clientid, p));
         clientid = p;
    }

    // devicephysicalname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDevicephysicalnameDirty()  { return checkFieldDirtiness(DEVICEPHYSICALNAME_DIRTYGROUP, DEVICEPHYSICALNAME_DIRTYMASK); }

    public java.lang.String   getDevicephysicalname()         { return devicephysicalname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getDevicephysicalnameAsString() { return (devicephysicalname == null) ? "" : devicephysicalname; }

    // devicephysicalname setter methods.
    
    protected void markDevicephysicalnameAsDirty(boolean aFlag)  { markFieldAsDirty(DEVICEPHYSICALNAME_DIRTYGROUP, DEVICEPHYSICALNAME_DIRTYMASK, aFlag); }


    public void setDevicephysicalname(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markDevicephysicalnameAsDirty(!equalsObject(devicephysicalname, p));
         devicephysicalname = p;
    }

}
