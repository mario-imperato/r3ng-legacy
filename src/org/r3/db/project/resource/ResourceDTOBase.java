//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.resource;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ResourceDTOBase")
public class ResourceDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  resourceid;
    protected java.lang.String  resourcetype;
    protected java.lang.String  resourcedescr;
    protected java.lang.String  sitedomain;
    protected java.lang.String  userid;
    protected java.lang.String  firstname;
    protected java.lang.String  lastname;
    protected java.lang.String  phone;
    protected java.lang.String  cellphone;
    protected java.lang.String  email;
    protected java.lang.String  address;
    protected java.lang.String  town;
    protected java.lang.String  zipcode;
    protected java.lang.String  ssn;
    protected java.lang.String  sex;
    protected java.sql.Date  birthdate;
    protected java.lang.String  birthtown;
    protected java.lang.String  birthdistrict;
    protected java.lang.String  resourcecardid;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String RESOURCEID_DEFAULT  =  null;
    public static final java.lang.String RESOURCETYPE_DEFAULT  =  null;
    public static final java.lang.String RESOURCEDESCR_DEFAULT  =  null;
    public static final java.lang.String SITEDOMAIN_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String FIRSTNAME_DEFAULT  =  null;
    public static final java.lang.String LASTNAME_DEFAULT  =  null;
    public static final java.lang.String PHONE_DEFAULT  =  null;
    public static final java.lang.String CELLPHONE_DEFAULT  =  null;
    public static final java.lang.String EMAIL_DEFAULT  =  null;
    public static final java.lang.String ADDRESS_DEFAULT  =  null;
    public static final java.lang.String TOWN_DEFAULT  =  null;
    public static final java.lang.String ZIPCODE_DEFAULT  =  null;
    public static final java.lang.String SSN_DEFAULT  =  null;
    public static final java.lang.String SEX_DEFAULT  =  null;
    public static final java.sql.Date BIRTHDATE_DEFAULT  =  null;
    public static final java.lang.String BIRTHTOWN_DEFAULT  =  null;
    public static final java.lang.String BIRTHDISTRICT_DEFAULT  =  null;
    public static final java.lang.String RESOURCECARDID_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int RESOURCEID_DIRTYGROUP  =  0;
    public static final int RESOURCEID_DIRTYMASK   =  1;
    public static final int RESOURCETYPE_DIRTYGROUP  =  0;
    public static final int RESOURCETYPE_DIRTYMASK   =  2;
    public static final int RESOURCEDESCR_DIRTYGROUP  =  0;
    public static final int RESOURCEDESCR_DIRTYMASK   =  4;
    public static final int SITEDOMAIN_DIRTYGROUP  =  0;
    public static final int SITEDOMAIN_DIRTYMASK   =  8;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  16;
    public static final int FIRSTNAME_DIRTYGROUP  =  0;
    public static final int FIRSTNAME_DIRTYMASK   =  32;
    public static final int LASTNAME_DIRTYGROUP  =  0;
    public static final int LASTNAME_DIRTYMASK   =  64;
    public static final int PHONE_DIRTYGROUP  =  0;
    public static final int PHONE_DIRTYMASK   =  128;
    public static final int CELLPHONE_DIRTYGROUP  =  0;
    public static final int CELLPHONE_DIRTYMASK   =  256;
    public static final int EMAIL_DIRTYGROUP  =  0;
    public static final int EMAIL_DIRTYMASK   =  512;
    public static final int ADDRESS_DIRTYGROUP  =  0;
    public static final int ADDRESS_DIRTYMASK   =  1024;
    public static final int TOWN_DIRTYGROUP  =  0;
    public static final int TOWN_DIRTYMASK   =  2048;
    public static final int ZIPCODE_DIRTYGROUP  =  0;
    public static final int ZIPCODE_DIRTYMASK   =  4096;
    public static final int SSN_DIRTYGROUP  =  0;
    public static final int SSN_DIRTYMASK   =  8192;
    public static final int SEX_DIRTYGROUP  =  0;
    public static final int SEX_DIRTYMASK   =  16384;
    public static final int BIRTHDATE_DIRTYGROUP  =  0;
    public static final int BIRTHDATE_DIRTYMASK   =  32768;
    public static final int BIRTHTOWN_DIRTYGROUP  =  0;
    public static final int BIRTHTOWN_DIRTYMASK   =  65536;
    public static final int BIRTHDISTRICT_DIRTYGROUP  =  0;
    public static final int BIRTHDISTRICT_DIRTYMASK   =  131072;
    public static final int RESOURCECARDID_DIRTYGROUP  =  0;
    public static final int RESOURCECARDID_DIRTYMASK   =  262144;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  524288;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  1048576;


    /**
      * DataBean constructor.
      */
    public ResourceDTOBase()
    {
       dirtyFlagsArray = new int[21 / 30 + 1];
       clearDirtyFlags();

       resourceid = RESOURCEID_DEFAULT;
       resourcetype = RESOURCETYPE_DEFAULT;
       resourcedescr = RESOURCEDESCR_DEFAULT;
       sitedomain = SITEDOMAIN_DEFAULT;
       userid = USERID_DEFAULT;
       firstname = FIRSTNAME_DEFAULT;
       lastname = LASTNAME_DEFAULT;
       phone = PHONE_DEFAULT;
       cellphone = CELLPHONE_DEFAULT;
       email = EMAIL_DEFAULT;
       address = ADDRESS_DEFAULT;
       town = TOWN_DEFAULT;
       zipcode = ZIPCODE_DEFAULT;
       ssn = SSN_DEFAULT;
       sex = SEX_DEFAULT;
       birthdate = BIRTHDATE_DEFAULT;
       birthtown = BIRTHTOWN_DEFAULT;
       birthdistrict = BIRTHDISTRICT_DEFAULT;
       resourcecardid = RESOURCECARDID_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ResourceDTOBase(ResourceDTOBase another)
    {

       resourceid = another.getResourceid();
       resourcetype = another.getResourcetype();
       resourcedescr = another.getResourcedescr();
       sitedomain = another.getSitedomain();
       userid = another.getUserid();
       firstname = another.getFirstname();
       lastname = another.getLastname();
       phone = another.getPhone();
       cellphone = another.getCellphone();
       email = another.getEmail();
       address = another.getAddress();
       town = another.getTown();
       zipcode = another.getZipcode();
       ssn = another.getSsn();
       sex = another.getSex();
       birthdate = another.getBirthdate();
       birthtown = another.getBirthtown();
       birthdistrict = another.getBirthdistrict();
       resourcecardid = another.getResourcecardid();
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
        stb.append(resourceid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (resourcedescr != null)
        {
        stb.append(resourcedescr);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // resourceid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isResourceidDirty()  { return checkFieldDirtiness(RESOURCEID_DIRTYGROUP, RESOURCEID_DIRTYMASK); }

    public java.lang.String   getResourceid()         { return resourceid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "resourceid")
    public java.lang.String   getResourceidAsString() { return (resourceid == null) ? "" : resourceid; }

    // resourceid setter methods.
    
    protected void markResourceidAsDirty(boolean aFlag)  { markFieldAsDirty(RESOURCEID_DIRTYGROUP, RESOURCEID_DIRTYMASK, aFlag); }


    public void setResourceid(String  p)
    {
       setResourceid(p, DTOCasingStyle.none);
    }
    
    public void setResourceid(String  p, DTOCasingStyle casingStyle)
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
       markResourceidAsDirty(!equalsObject(resourceid, p));
       resourceid = p;
    }

    // resourcetype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isResourcetypeDirty()  { return checkFieldDirtiness(RESOURCETYPE_DIRTYGROUP, RESOURCETYPE_DIRTYMASK); }

    public java.lang.String   getResourcetype()         { return resourcetype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "resourcetype")
    public java.lang.String   getResourcetypeAsString() { return (resourcetype == null) ? "" : resourcetype; }

    // resourcetype setter methods.
    
    protected void markResourcetypeAsDirty(boolean aFlag)  { markFieldAsDirty(RESOURCETYPE_DIRTYGROUP, RESOURCETYPE_DIRTYMASK, aFlag); }


    public void setResourcetype(String  p)
    {
       setResourcetype(p, DTOCasingStyle.none);
    }
    
    public void setResourcetype(String  p, DTOCasingStyle casingStyle)
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
       markResourcetypeAsDirty(!equalsObject(resourcetype, p));
       resourcetype = p;
    }

    // resourcedescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isResourcedescrDirty()  { return checkFieldDirtiness(RESOURCEDESCR_DIRTYGROUP, RESOURCEDESCR_DIRTYMASK); }

    public java.lang.String   getResourcedescr()         { return resourcedescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "resourcedescr")
    public java.lang.String   getResourcedescrAsString() { return (resourcedescr == null) ? "" : resourcedescr; }

    // resourcedescr setter methods.
    
    protected void markResourcedescrAsDirty(boolean aFlag)  { markFieldAsDirty(RESOURCEDESCR_DIRTYGROUP, RESOURCEDESCR_DIRTYMASK, aFlag); }


    public void setResourcedescr(String  p)
    {
       setResourcedescr(p, DTOCasingStyle.none);
    }
    
    public void setResourcedescr(String  p, DTOCasingStyle casingStyle)
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
       markResourcedescrAsDirty(!equalsObject(resourcedescr, p));
       resourcedescr = p;
    }

    // sitedomain getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSitedomainDirty()  { return checkFieldDirtiness(SITEDOMAIN_DIRTYGROUP, SITEDOMAIN_DIRTYMASK); }

    public java.lang.String   getSitedomain()         { return sitedomain; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "sitedomain")
    public java.lang.String   getSitedomainAsString() { return (sitedomain == null) ? "" : sitedomain; }

    // sitedomain setter methods.
    
    protected void markSitedomainAsDirty(boolean aFlag)  { markFieldAsDirty(SITEDOMAIN_DIRTYGROUP, SITEDOMAIN_DIRTYMASK, aFlag); }


    public void setSitedomain(String  p)
    {
       setSitedomain(p, DTOCasingStyle.none);
    }
    
    public void setSitedomain(String  p, DTOCasingStyle casingStyle)
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
       markSitedomainAsDirty(!equalsObject(sitedomain, p));
       sitedomain = p;
    }

    // userid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUseridDirty()  { return checkFieldDirtiness(USERID_DIRTYGROUP, USERID_DIRTYMASK); }

    public java.lang.String   getUserid()         { return userid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "userid")
    public java.lang.String   getUseridAsString() { return (userid == null) ? "" : userid; }

    // userid setter methods.
    
    protected void markUseridAsDirty(boolean aFlag)  { markFieldAsDirty(USERID_DIRTYGROUP, USERID_DIRTYMASK, aFlag); }


    public void setUserid(String  p)
    {
       setUserid(p, DTOCasingStyle.none);
    }
    
    public void setUserid(String  p, DTOCasingStyle casingStyle)
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
       markUseridAsDirty(!equalsObject(userid, p));
       userid = p;
    }

    // firstname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFirstnameDirty()  { return checkFieldDirtiness(FIRSTNAME_DIRTYGROUP, FIRSTNAME_DIRTYMASK); }

    public java.lang.String   getFirstname()         { return firstname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "firstname")
    public java.lang.String   getFirstnameAsString() { return (firstname == null) ? "" : firstname; }

    // firstname setter methods.
    
    protected void markFirstnameAsDirty(boolean aFlag)  { markFieldAsDirty(FIRSTNAME_DIRTYGROUP, FIRSTNAME_DIRTYMASK, aFlag); }


    public void setFirstname(String  p)
    {
       setFirstname(p, DTOCasingStyle.none);
    }
    
    public void setFirstname(String  p, DTOCasingStyle casingStyle)
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
       markFirstnameAsDirty(!equalsObject(firstname, p));
       firstname = p;
    }

    // lastname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLastnameDirty()  { return checkFieldDirtiness(LASTNAME_DIRTYGROUP, LASTNAME_DIRTYMASK); }

    public java.lang.String   getLastname()         { return lastname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "lastname")
    public java.lang.String   getLastnameAsString() { return (lastname == null) ? "" : lastname; }

    // lastname setter methods.
    
    protected void markLastnameAsDirty(boolean aFlag)  { markFieldAsDirty(LASTNAME_DIRTYGROUP, LASTNAME_DIRTYMASK, aFlag); }


    public void setLastname(String  p)
    {
       setLastname(p, DTOCasingStyle.none);
    }
    
    public void setLastname(String  p, DTOCasingStyle casingStyle)
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
       markLastnameAsDirty(!equalsObject(lastname, p));
       lastname = p;
    }

    // phone getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPhoneDirty()  { return checkFieldDirtiness(PHONE_DIRTYGROUP, PHONE_DIRTYMASK); }

    public java.lang.String   getPhone()         { return phone; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "phone")
    public java.lang.String   getPhoneAsString() { return (phone == null) ? "" : phone; }

    // phone setter methods.
    
    protected void markPhoneAsDirty(boolean aFlag)  { markFieldAsDirty(PHONE_DIRTYGROUP, PHONE_DIRTYMASK, aFlag); }


    public void setPhone(String  p)
    {
       setPhone(p, DTOCasingStyle.none);
    }
    
    public void setPhone(String  p, DTOCasingStyle casingStyle)
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
       markPhoneAsDirty(!equalsObject(phone, p));
       phone = p;
    }

    // cellphone getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCellphoneDirty()  { return checkFieldDirtiness(CELLPHONE_DIRTYGROUP, CELLPHONE_DIRTYMASK); }

    public java.lang.String   getCellphone()         { return cellphone; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "cellphone")
    public java.lang.String   getCellphoneAsString() { return (cellphone == null) ? "" : cellphone; }

    // cellphone setter methods.
    
    protected void markCellphoneAsDirty(boolean aFlag)  { markFieldAsDirty(CELLPHONE_DIRTYGROUP, CELLPHONE_DIRTYMASK, aFlag); }


    public void setCellphone(String  p)
    {
       setCellphone(p, DTOCasingStyle.none);
    }
    
    public void setCellphone(String  p, DTOCasingStyle casingStyle)
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
       markCellphoneAsDirty(!equalsObject(cellphone, p));
       cellphone = p;
    }

    // email getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEmailDirty()  { return checkFieldDirtiness(EMAIL_DIRTYGROUP, EMAIL_DIRTYMASK); }

    public java.lang.String   getEmail()         { return email; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "email")
    public java.lang.String   getEmailAsString() { return (email == null) ? "" : email; }

    // email setter methods.
    
    protected void markEmailAsDirty(boolean aFlag)  { markFieldAsDirty(EMAIL_DIRTYGROUP, EMAIL_DIRTYMASK, aFlag); }


    public void setEmail(String  p)
    {
       setEmail(p, DTOCasingStyle.none);
    }
    
    public void setEmail(String  p, DTOCasingStyle casingStyle)
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
       markEmailAsDirty(!equalsObject(email, p));
       email = p;
    }

    // address getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAddressDirty()  { return checkFieldDirtiness(ADDRESS_DIRTYGROUP, ADDRESS_DIRTYMASK); }

    public java.lang.String   getAddress()         { return address; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "address")
    public java.lang.String   getAddressAsString() { return (address == null) ? "" : address; }

    // address setter methods.
    
    protected void markAddressAsDirty(boolean aFlag)  { markFieldAsDirty(ADDRESS_DIRTYGROUP, ADDRESS_DIRTYMASK, aFlag); }


    public void setAddress(String  p)
    {
       setAddress(p, DTOCasingStyle.none);
    }
    
    public void setAddress(String  p, DTOCasingStyle casingStyle)
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
       markAddressAsDirty(!equalsObject(address, p));
       address = p;
    }

    // town getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isTownDirty()  { return checkFieldDirtiness(TOWN_DIRTYGROUP, TOWN_DIRTYMASK); }

    public java.lang.String   getTown()         { return town; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "town")
    public java.lang.String   getTownAsString() { return (town == null) ? "" : town; }

    // town setter methods.
    
    protected void markTownAsDirty(boolean aFlag)  { markFieldAsDirty(TOWN_DIRTYGROUP, TOWN_DIRTYMASK, aFlag); }


    public void setTown(String  p)
    {
       setTown(p, DTOCasingStyle.none);
    }
    
    public void setTown(String  p, DTOCasingStyle casingStyle)
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
       markTownAsDirty(!equalsObject(town, p));
       town = p;
    }

    // zipcode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isZipcodeDirty()  { return checkFieldDirtiness(ZIPCODE_DIRTYGROUP, ZIPCODE_DIRTYMASK); }

    public java.lang.String   getZipcode()         { return zipcode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "zipcode")
    public java.lang.String   getZipcodeAsString() { return (zipcode == null) ? "" : zipcode; }

    // zipcode setter methods.
    
    protected void markZipcodeAsDirty(boolean aFlag)  { markFieldAsDirty(ZIPCODE_DIRTYGROUP, ZIPCODE_DIRTYMASK, aFlag); }


    public void setZipcode(String  p)
    {
       setZipcode(p, DTOCasingStyle.none);
    }
    
    public void setZipcode(String  p, DTOCasingStyle casingStyle)
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
       markZipcodeAsDirty(!equalsObject(zipcode, p));
       zipcode = p;
    }

    // ssn getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSsnDirty()  { return checkFieldDirtiness(SSN_DIRTYGROUP, SSN_DIRTYMASK); }

    public java.lang.String   getSsn()         { return ssn; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "ssn")
    public java.lang.String   getSsnAsString() { return (ssn == null) ? "" : ssn; }

    // ssn setter methods.
    
    protected void markSsnAsDirty(boolean aFlag)  { markFieldAsDirty(SSN_DIRTYGROUP, SSN_DIRTYMASK, aFlag); }


    public void setSsn(String  p)
    {
       setSsn(p, DTOCasingStyle.none);
    }
    
    public void setSsn(String  p, DTOCasingStyle casingStyle)
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
       markSsnAsDirty(!equalsObject(ssn, p));
       ssn = p;
    }

    // sex getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSexDirty()  { return checkFieldDirtiness(SEX_DIRTYGROUP, SEX_DIRTYMASK); }

    public java.lang.String   getSex()         { return sex; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "sex")
    public java.lang.String   getSexAsString() { return (sex == null) ? "" : sex; }

    // sex setter methods.
    
    protected void markSexAsDirty(boolean aFlag)  { markFieldAsDirty(SEX_DIRTYGROUP, SEX_DIRTYMASK, aFlag); }


    public void setSex(String  p)
    {
       setSex(p, DTOCasingStyle.none);
    }
    
    public void setSex(String  p, DTOCasingStyle casingStyle)
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
       markSexAsDirty(!equalsObject(sex, p));
       sex = p;
    }

    // birthdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBirthdateDirty()  { return checkFieldDirtiness(BIRTHDATE_DIRTYGROUP, BIRTHDATE_DIRTYMASK); }

    public java.sql.Date   getBirthdate() { return birthdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "birthdate")
    public String getBirthdateAsString() { return dateAsString(birthdate, getDateFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getBirthdateAsString(java.text.DateFormat aDateFormat) { return dateAsString(birthdate, aDateFormat); }

    // birthdate setter methods.
    
    protected void markBirthdateAsDirty(boolean aFlag)  { markFieldAsDirty(BIRTHDATE_DIRTYGROUP, BIRTHDATE_DIRTYMASK, aFlag); }


    public void setBirthdate(java.sql.Date  p)
    {
         markBirthdateAsDirty(!equalsObject(birthdate, p));
    	 birthdate = p;
    }
    public void setBirthdate(String p, java.text.DateFormat aDateFormat)
    {
    	setBirthdate(stringAsDate(p, aDateFormat));
    }

    // birthtown getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBirthtownDirty()  { return checkFieldDirtiness(BIRTHTOWN_DIRTYGROUP, BIRTHTOWN_DIRTYMASK); }

    public java.lang.String   getBirthtown()         { return birthtown; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "birthtown")
    public java.lang.String   getBirthtownAsString() { return (birthtown == null) ? "" : birthtown; }

    // birthtown setter methods.
    
    protected void markBirthtownAsDirty(boolean aFlag)  { markFieldAsDirty(BIRTHTOWN_DIRTYGROUP, BIRTHTOWN_DIRTYMASK, aFlag); }


    public void setBirthtown(String  p)
    {
       setBirthtown(p, DTOCasingStyle.none);
    }
    
    public void setBirthtown(String  p, DTOCasingStyle casingStyle)
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
       markBirthtownAsDirty(!equalsObject(birthtown, p));
       birthtown = p;
    }

    // birthdistrict getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBirthdistrictDirty()  { return checkFieldDirtiness(BIRTHDISTRICT_DIRTYGROUP, BIRTHDISTRICT_DIRTYMASK); }

    public java.lang.String   getBirthdistrict()         { return birthdistrict; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "birthdistrict")
    public java.lang.String   getBirthdistrictAsString() { return (birthdistrict == null) ? "" : birthdistrict; }

    // birthdistrict setter methods.
    
    protected void markBirthdistrictAsDirty(boolean aFlag)  { markFieldAsDirty(BIRTHDISTRICT_DIRTYGROUP, BIRTHDISTRICT_DIRTYMASK, aFlag); }


    public void setBirthdistrict(String  p)
    {
       setBirthdistrict(p, DTOCasingStyle.none);
    }
    
    public void setBirthdistrict(String  p, DTOCasingStyle casingStyle)
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
       markBirthdistrictAsDirty(!equalsObject(birthdistrict, p));
       birthdistrict = p;
    }

    // resourcecardid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isResourcecardidDirty()  { return checkFieldDirtiness(RESOURCECARDID_DIRTYGROUP, RESOURCECARDID_DIRTYMASK); }

    public java.lang.String   getResourcecardid()         { return resourcecardid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "resourcecardid")
    public java.lang.String   getResourcecardidAsString() { return (resourcecardid == null) ? "" : resourcecardid; }

    // resourcecardid setter methods.
    
    protected void markResourcecardidAsDirty(boolean aFlag)  { markFieldAsDirty(RESOURCECARDID_DIRTYGROUP, RESOURCECARDID_DIRTYMASK, aFlag); }


    public void setResourcecardid(String  p)
    {
       setResourcecardid(p, DTOCasingStyle.none);
    }
    
    public void setResourcecardid(String  p, DTOCasingStyle casingStyle)
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
       markResourcecardidAsDirty(!equalsObject(resourcecardid, p));
       resourcecardid = p;
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

    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
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
