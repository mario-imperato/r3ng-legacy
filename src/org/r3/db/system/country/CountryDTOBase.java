//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.country;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "CountryDTOBase")
public class CountryDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  iso3166_a3;
    protected java.lang.String  iso3166_a2;
    protected java.lang.Integer  iso3166_num;
    protected java.lang.String  countryname;

    public static final java.lang.String ISO3166_A3_DEFAULT  =  null;
    public static final java.lang.String ISO3166_A2_DEFAULT  =  null;
    public static final java.lang.Integer ISO3166_NUM_DEFAULT  =  null;
    public static final java.lang.String COUNTRYNAME_DEFAULT  =  null;

    public static final int ISO3166_A3_DIRTYGROUP  =  0;
    public static final int ISO3166_A3_DIRTYMASK   =  1;
    public static final int ISO3166_A2_DIRTYGROUP  =  0;
    public static final int ISO3166_A2_DIRTYMASK   =  2;
    public static final int ISO3166_NUM_DIRTYGROUP  =  0;
    public static final int ISO3166_NUM_DIRTYMASK   =  4;
    public static final int COUNTRYNAME_DIRTYGROUP  =  0;
    public static final int COUNTRYNAME_DIRTYMASK   =  8;


    /**
      * DataBean constructor.
      */
    public CountryDTOBase()
    {
       dirtyFlagsArray = new int[4 / 30 + 1];
       clearDirtyFlags();

       iso3166_a3 = ISO3166_A3_DEFAULT;
       iso3166_a2 = ISO3166_A2_DEFAULT;
       iso3166_num = ISO3166_NUM_DEFAULT;
       countryname = COUNTRYNAME_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public CountryDTOBase(CountryDTOBase another)
    {

       iso3166_a3 = another.getIso3166_a3();
       iso3166_a2 = another.getIso3166_a2();
       iso3166_num = another.getIso3166_num();
       countryname = another.getCountryname();

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
        stb.append(iso3166_a3);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(countryname);
        return stb.toString();
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // iso3166_a3 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIso3166_a3Dirty()  { return checkFieldDirtiness(ISO3166_A3_DIRTYGROUP, ISO3166_A3_DIRTYMASK); }

    public java.lang.String   getIso3166_a3()         { return iso3166_a3; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getIso3166_a3AsString() { return (iso3166_a3 == null) ? "" : iso3166_a3; }

    // iso3166_a3 setter methods.
    
    protected void markIso3166_a3AsDirty(boolean aFlag)  { markFieldAsDirty(ISO3166_A3_DIRTYGROUP, ISO3166_A3_DIRTYMASK, aFlag); }


    public void setIso3166_a3(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markIso3166_a3AsDirty(!equalsObject(iso3166_a3, p));
         iso3166_a3 = p;
    }

    // iso3166_a2 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIso3166_a2Dirty()  { return checkFieldDirtiness(ISO3166_A2_DIRTYGROUP, ISO3166_A2_DIRTYMASK); }

    public java.lang.String   getIso3166_a2()         { return iso3166_a2; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getIso3166_a2AsString() { return (iso3166_a2 == null) ? "" : iso3166_a2; }

    // iso3166_a2 setter methods.
    
    protected void markIso3166_a2AsDirty(boolean aFlag)  { markFieldAsDirty(ISO3166_A2_DIRTYGROUP, ISO3166_A2_DIRTYMASK, aFlag); }


    public void setIso3166_a2(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markIso3166_a2AsDirty(!equalsObject(iso3166_a2, p));
         iso3166_a2 = p;
    }

    // iso3166_num getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIso3166_numDirty()  { return checkFieldDirtiness(ISO3166_NUM_DIRTYGROUP, ISO3166_NUM_DIRTYMASK); }

    public java.lang.Integer   getIso3166_num() { return iso3166_num; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getIso3166_numAsString() { return integerAsString(iso3166_num); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getIso3166_numAsInt()    { return iso3166_num != null ? iso3166_num.intValue() : 0; }

    // iso3166_num setter methods.
    
    protected void markIso3166_numAsDirty(boolean aFlag)  { markFieldAsDirty(ISO3166_NUM_DIRTYGROUP, ISO3166_NUM_DIRTYMASK, aFlag); }


    public void setIso3166_num(java.lang.Integer  p)
    {
        markIso3166_numAsDirty(!equalsObject(iso3166_num, p));
    	iso3166_num = p;
    }
    public void setIso3166_num(int p)
    {
    	setIso3166_num(new java.lang.Integer(p));
    }
    public void setIso3166_num()
    {
    	setIso3166_num(0);
    }
    public void setIso3166_num(String  p)
    {
    	setIso3166_num(stringAsInteger(p));
    }

    // countryname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCountrynameDirty()  { return checkFieldDirtiness(COUNTRYNAME_DIRTYGROUP, COUNTRYNAME_DIRTYMASK); }

    public java.lang.String   getCountryname()         { return countryname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCountrynameAsString() { return (countryname == null) ? "" : countryname; }

    // countryname setter methods.
    
    protected void markCountrynameAsDirty(boolean aFlag)  { markFieldAsDirty(COUNTRYNAME_DIRTYGROUP, COUNTRYNAME_DIRTYMASK, aFlag); }


    public void setCountryname(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markCountrynameAsDirty(!equalsObject(countryname, p));
         countryname = p;
    }

}
