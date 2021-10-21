//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.address;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "AddressDTOBase")
public class AddressDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  addressid;
    protected java.lang.String  entityid;
    protected java.lang.String  countryid;
    protected java.lang.String  ownerid;
    protected java.lang.String  addresstypeid;
    protected java.lang.String  state;
    protected java.lang.String  city;
    protected java.lang.String  zipcode;
    protected java.lang.String  address;
    protected java.lang.String  phonecode1;
    protected java.lang.String  phonecode2;
    protected java.lang.String  phone1;
    protected java.lang.String  phone2;
    protected java.lang.String  website;

    public static final java.lang.String ADDRESSID_DEFAULT  =  null;
    public static final java.lang.String ENTITYID_DEFAULT  =  null;
    public static final java.lang.String COUNTRYID_DEFAULT  =  null;
    public static final java.lang.String OWNERID_DEFAULT  =  null;
    public static final java.lang.String ADDRESSTYPEID_DEFAULT  =  null;
    public static final java.lang.String STATE_DEFAULT  =  null;
    public static final java.lang.String CITY_DEFAULT  =  null;
    public static final java.lang.String ZIPCODE_DEFAULT  =  null;
    public static final java.lang.String ADDRESS_DEFAULT  =  null;
    public static final java.lang.String PHONECODE1_DEFAULT  =  null;
    public static final java.lang.String PHONECODE2_DEFAULT  =  null;
    public static final java.lang.String PHONE1_DEFAULT  =  null;
    public static final java.lang.String PHONE2_DEFAULT  =  null;
    public static final java.lang.String WEBSITE_DEFAULT  =  null;

    public static final int ADDRESSID_DIRTYGROUP  =  0;
    public static final int ADDRESSID_DIRTYMASK   =  1;
    public static final int ENTITYID_DIRTYGROUP  =  0;
    public static final int ENTITYID_DIRTYMASK   =  2;
    public static final int COUNTRYID_DIRTYGROUP  =  0;
    public static final int COUNTRYID_DIRTYMASK   =  4;
    public static final int OWNERID_DIRTYGROUP  =  0;
    public static final int OWNERID_DIRTYMASK   =  8;
    public static final int ADDRESSTYPEID_DIRTYGROUP  =  0;
    public static final int ADDRESSTYPEID_DIRTYMASK   =  16;
    public static final int STATE_DIRTYGROUP  =  0;
    public static final int STATE_DIRTYMASK   =  32;
    public static final int CITY_DIRTYGROUP  =  0;
    public static final int CITY_DIRTYMASK   =  64;
    public static final int ZIPCODE_DIRTYGROUP  =  0;
    public static final int ZIPCODE_DIRTYMASK   =  128;
    public static final int ADDRESS_DIRTYGROUP  =  0;
    public static final int ADDRESS_DIRTYMASK   =  256;
    public static final int PHONECODE1_DIRTYGROUP  =  0;
    public static final int PHONECODE1_DIRTYMASK   =  512;
    public static final int PHONECODE2_DIRTYGROUP  =  0;
    public static final int PHONECODE2_DIRTYMASK   =  1024;
    public static final int PHONE1_DIRTYGROUP  =  0;
    public static final int PHONE1_DIRTYMASK   =  2048;
    public static final int PHONE2_DIRTYGROUP  =  0;
    public static final int PHONE2_DIRTYMASK   =  4096;
    public static final int WEBSITE_DIRTYGROUP  =  0;
    public static final int WEBSITE_DIRTYMASK   =  8192;


    /**
      * DataBean constructor.
      */
    public AddressDTOBase()
    {
       dirtyFlagsArray = new int[14 / 30 + 1];
       clearDirtyFlags();

       addressid = ADDRESSID_DEFAULT;
       entityid = ENTITYID_DEFAULT;
       countryid = COUNTRYID_DEFAULT;
       ownerid = OWNERID_DEFAULT;
       addresstypeid = ADDRESSTYPEID_DEFAULT;
       state = STATE_DEFAULT;
       city = CITY_DEFAULT;
       zipcode = ZIPCODE_DEFAULT;
       address = ADDRESS_DEFAULT;
       phonecode1 = PHONECODE1_DEFAULT;
       phonecode2 = PHONECODE2_DEFAULT;
       phone1 = PHONE1_DEFAULT;
       phone2 = PHONE2_DEFAULT;
       website = WEBSITE_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public AddressDTOBase(AddressDTOBase another)
    {

       addressid = another.getAddressid();
       entityid = another.getEntityid();
       countryid = another.getCountryid();
       ownerid = another.getOwnerid();
       addresstypeid = another.getAddresstypeid();
       state = another.getState();
       city = another.getCity();
       zipcode = another.getZipcode();
       address = another.getAddress();
       phonecode1 = another.getPhonecode1();
       phonecode2 = another.getPhonecode2();
       phone1 = another.getPhone1();
       phone2 = another.getPhone2();
       website = another.getWebsite();

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
        stb.append(addressid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        StringBuilder stb = new StringBuilder();
        stb.append(address);
        return stb.toString();
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // addressid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAddressidDirty()  { return checkFieldDirtiness(ADDRESSID_DIRTYGROUP, ADDRESSID_DIRTYMASK); }

    public java.lang.String   getAddressid()         { return addressid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getAddressidAsString() { return (addressid == null) ? "" : addressid; }

    // addressid setter methods.
    
    protected void markAddressidAsDirty(boolean aFlag)  { markFieldAsDirty(ADDRESSID_DIRTYGROUP, ADDRESSID_DIRTYMASK, aFlag); }


    public void setAddressid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markAddressidAsDirty(!equalsObject(addressid, p));
         addressid = p;
    }

    // entityid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEntityidDirty()  { return checkFieldDirtiness(ENTITYID_DIRTYGROUP, ENTITYID_DIRTYMASK); }

    public java.lang.String   getEntityid()         { return entityid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getEntityidAsString() { return (entityid == null) ? "" : entityid; }

    // entityid setter methods.
    
    protected void markEntityidAsDirty(boolean aFlag)  { markFieldAsDirty(ENTITYID_DIRTYGROUP, ENTITYID_DIRTYMASK, aFlag); }


    public void setEntityid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markEntityidAsDirty(!equalsObject(entityid, p));
         entityid = p;
    }

    // countryid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCountryidDirty()  { return checkFieldDirtiness(COUNTRYID_DIRTYGROUP, COUNTRYID_DIRTYMASK); }

    public java.lang.String   getCountryid()         { return countryid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCountryidAsString() { return (countryid == null) ? "" : countryid; }

    // countryid setter methods.
    
    protected void markCountryidAsDirty(boolean aFlag)  { markFieldAsDirty(COUNTRYID_DIRTYGROUP, COUNTRYID_DIRTYMASK, aFlag); }


    public void setCountryid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markCountryidAsDirty(!equalsObject(countryid, p));
         countryid = p;
    }

    // ownerid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOwneridDirty()  { return checkFieldDirtiness(OWNERID_DIRTYGROUP, OWNERID_DIRTYMASK); }

    public java.lang.String   getOwnerid()         { return ownerid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getOwneridAsString() { return (ownerid == null) ? "" : ownerid; }

    // ownerid setter methods.
    
    protected void markOwneridAsDirty(boolean aFlag)  { markFieldAsDirty(OWNERID_DIRTYGROUP, OWNERID_DIRTYMASK, aFlag); }


    public void setOwnerid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markOwneridAsDirty(!equalsObject(ownerid, p));
         ownerid = p;
    }

    // addresstypeid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAddresstypeidDirty()  { return checkFieldDirtiness(ADDRESSTYPEID_DIRTYGROUP, ADDRESSTYPEID_DIRTYMASK); }

    public java.lang.String   getAddresstypeid()         { return addresstypeid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getAddresstypeidAsString() { return (addresstypeid == null) ? "" : addresstypeid; }

    // addresstypeid setter methods.
    
    protected void markAddresstypeidAsDirty(boolean aFlag)  { markFieldAsDirty(ADDRESSTYPEID_DIRTYGROUP, ADDRESSTYPEID_DIRTYMASK, aFlag); }


    public void setAddresstypeid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markAddresstypeidAsDirty(!equalsObject(addresstypeid, p));
         addresstypeid = p;
    }

    // state getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isStateDirty()  { return checkFieldDirtiness(STATE_DIRTYGROUP, STATE_DIRTYMASK); }

    public java.lang.String   getState()         { return state; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getStateAsString() { return (state == null) ? "" : state; }

    // state setter methods.
    
    protected void markStateAsDirty(boolean aFlag)  { markFieldAsDirty(STATE_DIRTYGROUP, STATE_DIRTYMASK, aFlag); }


    public void setState(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markStateAsDirty(!equalsObject(state, p));
         state = p;
    }

    // city getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCityDirty()  { return checkFieldDirtiness(CITY_DIRTYGROUP, CITY_DIRTYMASK); }

    public java.lang.String   getCity()         { return city; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCityAsString() { return (city == null) ? "" : city; }

    // city setter methods.
    
    protected void markCityAsDirty(boolean aFlag)  { markFieldAsDirty(CITY_DIRTYGROUP, CITY_DIRTYMASK, aFlag); }


    public void setCity(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markCityAsDirty(!equalsObject(city, p));
         city = p;
    }

    // zipcode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isZipcodeDirty()  { return checkFieldDirtiness(ZIPCODE_DIRTYGROUP, ZIPCODE_DIRTYMASK); }

    public java.lang.String   getZipcode()         { return zipcode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getZipcodeAsString() { return (zipcode == null) ? "" : zipcode; }

    // zipcode setter methods.
    
    protected void markZipcodeAsDirty(boolean aFlag)  { markFieldAsDirty(ZIPCODE_DIRTYGROUP, ZIPCODE_DIRTYMASK, aFlag); }


    public void setZipcode(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markZipcodeAsDirty(!equalsObject(zipcode, p));
         zipcode = p;
    }

    // address getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAddressDirty()  { return checkFieldDirtiness(ADDRESS_DIRTYGROUP, ADDRESS_DIRTYMASK); }

    public java.lang.String   getAddress()         { return address; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getAddressAsString() { return (address == null) ? "" : address; }

    // address setter methods.
    
    protected void markAddressAsDirty(boolean aFlag)  { markFieldAsDirty(ADDRESS_DIRTYGROUP, ADDRESS_DIRTYMASK, aFlag); }


    public void setAddress(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markAddressAsDirty(!equalsObject(address, p));
         address = p;
    }

    // phonecode1 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPhonecode1Dirty()  { return checkFieldDirtiness(PHONECODE1_DIRTYGROUP, PHONECODE1_DIRTYMASK); }

    public java.lang.String   getPhonecode1()         { return phonecode1; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPhonecode1AsString() { return (phonecode1 == null) ? "" : phonecode1; }

    // phonecode1 setter methods.
    
    protected void markPhonecode1AsDirty(boolean aFlag)  { markFieldAsDirty(PHONECODE1_DIRTYGROUP, PHONECODE1_DIRTYMASK, aFlag); }


    public void setPhonecode1(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markPhonecode1AsDirty(!equalsObject(phonecode1, p));
         phonecode1 = p;
    }

    // phonecode2 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPhonecode2Dirty()  { return checkFieldDirtiness(PHONECODE2_DIRTYGROUP, PHONECODE2_DIRTYMASK); }

    public java.lang.String   getPhonecode2()         { return phonecode2; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPhonecode2AsString() { return (phonecode2 == null) ? "" : phonecode2; }

    // phonecode2 setter methods.
    
    protected void markPhonecode2AsDirty(boolean aFlag)  { markFieldAsDirty(PHONECODE2_DIRTYGROUP, PHONECODE2_DIRTYMASK, aFlag); }


    public void setPhonecode2(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markPhonecode2AsDirty(!equalsObject(phonecode2, p));
         phonecode2 = p;
    }

    // phone1 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPhone1Dirty()  { return checkFieldDirtiness(PHONE1_DIRTYGROUP, PHONE1_DIRTYMASK); }

    public java.lang.String   getPhone1()         { return phone1; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPhone1AsString() { return (phone1 == null) ? "" : phone1; }

    // phone1 setter methods.
    
    protected void markPhone1AsDirty(boolean aFlag)  { markFieldAsDirty(PHONE1_DIRTYGROUP, PHONE1_DIRTYMASK, aFlag); }


    public void setPhone1(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markPhone1AsDirty(!equalsObject(phone1, p));
         phone1 = p;
    }

    // phone2 getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPhone2Dirty()  { return checkFieldDirtiness(PHONE2_DIRTYGROUP, PHONE2_DIRTYMASK); }

    public java.lang.String   getPhone2()         { return phone2; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPhone2AsString() { return (phone2 == null) ? "" : phone2; }

    // phone2 setter methods.
    
    protected void markPhone2AsDirty(boolean aFlag)  { markFieldAsDirty(PHONE2_DIRTYGROUP, PHONE2_DIRTYMASK, aFlag); }


    public void setPhone2(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markPhone2AsDirty(!equalsObject(phone2, p));
         phone2 = p;
    }

    // website getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWebsiteDirty()  { return checkFieldDirtiness(WEBSITE_DIRTYGROUP, WEBSITE_DIRTYMASK); }

    public java.lang.String   getWebsite()         { return website; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getWebsiteAsString() { return (website == null) ? "" : website; }

    // website setter methods.
    
    protected void markWebsiteAsDirty(boolean aFlag)  { markFieldAsDirty(WEBSITE_DIRTYGROUP, WEBSITE_DIRTYMASK, aFlag); }


    public void setWebsite(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markWebsiteAsDirty(!equalsObject(website, p));
         website = p;
    }

}
