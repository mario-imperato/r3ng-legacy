//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.dms.fileproperty;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "DMSFilePropertyDTOBase")
public class DMSFilePropertyDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  fileid;
    protected java.lang.String  propertyname;
    protected java.lang.String  propertyvalue;

    public static final java.lang.String FILEID_DEFAULT  =  null;
    public static final java.lang.String PROPERTYNAME_DEFAULT  =  null;
    public static final java.lang.String PROPERTYVALUE_DEFAULT  =  null;

    public static final int FILEID_DIRTYGROUP  =  0;
    public static final int FILEID_DIRTYMASK   =  1;
    public static final int PROPERTYNAME_DIRTYGROUP  =  0;
    public static final int PROPERTYNAME_DIRTYMASK   =  2;
    public static final int PROPERTYVALUE_DIRTYGROUP  =  0;
    public static final int PROPERTYVALUE_DIRTYMASK   =  4;


    /**
      * DataBean constructor.
      */
    public DMSFilePropertyDTOBase()
    {
       dirtyFlagsArray = new int[3 / 30 + 1];
       clearDirtyFlags();

       fileid = FILEID_DEFAULT;
       propertyname = PROPERTYNAME_DEFAULT;
       propertyvalue = PROPERTYVALUE_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public DMSFilePropertyDTOBase(DMSFilePropertyDTOBase another)
    {

       fileid = another.getFileid();
       propertyname = another.getPropertyname();
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
        stb.append(fileid);
        stb.append(", ");
        stb.append(propertyname);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(propertyname);
        return stb.toString();
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // fileid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFileidDirty()  { return checkFieldDirtiness(FILEID_DIRTYGROUP, FILEID_DIRTYMASK); }

    public java.lang.String   getFileid()         { return fileid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFileidAsString() { return (fileid == null) ? "" : fileid; }

    // fileid setter methods.
    
    protected void markFileidAsDirty(boolean aFlag)  { markFieldAsDirty(FILEID_DIRTYGROUP, FILEID_DIRTYMASK, aFlag); }


    public void setFileid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markFileidAsDirty(!equalsObject(fileid, p));
         fileid = p;
    }

    // propertyname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPropertynameDirty()  { return checkFieldDirtiness(PROPERTYNAME_DIRTYGROUP, PROPERTYNAME_DIRTYMASK); }

    public java.lang.String   getPropertyname()         { return propertyname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPropertynameAsString() { return (propertyname == null) ? "" : propertyname; }

    // propertyname setter methods.
    
    protected void markPropertynameAsDirty(boolean aFlag)  { markFieldAsDirty(PROPERTYNAME_DIRTYGROUP, PROPERTYNAME_DIRTYMASK, aFlag); }


    public void setPropertyname(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markPropertynameAsDirty(!equalsObject(propertyname, p));
         propertyname = p;
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
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markPropertyvalueAsDirty(!equalsObject(propertyvalue, p));
         propertyvalue = p;
    }

}
