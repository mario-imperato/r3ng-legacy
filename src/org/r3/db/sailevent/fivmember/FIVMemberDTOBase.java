//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.fivmember;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "FIVMemberDTOBase")
public class FIVMemberDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  cardnumber;
    protected java.lang.String  cardnumberstatuscode;
    protected java.lang.String  cardholdername;
    protected java.lang.String  cardholderlastname;
    protected java.sql.Timestamp  medexamexpirationdate;
    protected java.lang.String  medexamtypecode;
    protected java.sql.Timestamp  cardexpirationdate;
    protected java.lang.String  birthdate;
    protected java.lang.String  sex;
    protected java.lang.String  birthplace;
    protected java.lang.String  birthdistrict;
    protected java.lang.String  ssn;
    protected java.lang.String  address;
    protected java.lang.String  streetnumber;
    protected java.lang.String  city;
    protected java.lang.String  zipcode;
    protected java.lang.String  district;
    protected java.lang.String  phone;
    protected java.lang.String  cellular;
    protected java.lang.String  fax;
    protected java.lang.String  email;
    protected java.sql.Timestamp  renewaldate;
    protected java.lang.String  yachtclub;
    protected java.lang.String  membertypecode;
    protected java.lang.String  activitytypecode;
    protected java.sql.Timestamp  systemcheckdate;
    protected java.lang.String  verificationrequired;
    protected java.sql.Timestamp  createtimestamp;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String CARDNUMBER_DEFAULT  =  null;
    public static final java.lang.String CARDNUMBERSTATUSCODE_DEFAULT  =  null;
    public static final java.lang.String CARDHOLDERNAME_DEFAULT  =  null;
    public static final java.lang.String CARDHOLDERLASTNAME_DEFAULT  =  null;
    public static final java.sql.Timestamp MEDEXAMEXPIRATIONDATE_DEFAULT  =  null;
    public static final java.lang.String MEDEXAMTYPECODE_DEFAULT  =  null;
    public static final java.sql.Timestamp CARDEXPIRATIONDATE_DEFAULT  =  null;
    public static final java.lang.String BIRTHDATE_DEFAULT  =  null;
    public static final java.lang.String SEX_DEFAULT  =  null;
    public static final java.lang.String BIRTHPLACE_DEFAULT  =  null;
    public static final java.lang.String BIRTHDISTRICT_DEFAULT  =  null;
    public static final java.lang.String SSN_DEFAULT  =  null;
    public static final java.lang.String ADDRESS_DEFAULT  =  null;
    public static final java.lang.String STREETNUMBER_DEFAULT  =  null;
    public static final java.lang.String CITY_DEFAULT  =  null;
    public static final java.lang.String ZIPCODE_DEFAULT  =  null;
    public static final java.lang.String DISTRICT_DEFAULT  =  null;
    public static final java.lang.String PHONE_DEFAULT  =  null;
    public static final java.lang.String CELLULAR_DEFAULT  =  null;
    public static final java.lang.String FAX_DEFAULT  =  null;
    public static final java.lang.String EMAIL_DEFAULT  =  null;
    public static final java.sql.Timestamp RENEWALDATE_DEFAULT  =  null;
    public static final java.lang.String YACHTCLUB_DEFAULT  =  null;
    public static final java.lang.String MEMBERTYPECODE_DEFAULT  =  null;
    public static final java.lang.String ACTIVITYTYPECODE_DEFAULT  =  null;
    public static final java.sql.Timestamp SYSTEMCHECKDATE_DEFAULT  =  null;
    public static final java.lang.String VERIFICATIONREQUIRED_DEFAULT  =  null;
    public static final java.sql.Timestamp CREATETIMESTAMP_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int CARDNUMBER_DIRTYGROUP  =  0;
    public static final int CARDNUMBER_DIRTYMASK   =  1;
    public static final int CARDNUMBERSTATUSCODE_DIRTYGROUP  =  0;
    public static final int CARDNUMBERSTATUSCODE_DIRTYMASK   =  2;
    public static final int CARDHOLDERNAME_DIRTYGROUP  =  0;
    public static final int CARDHOLDERNAME_DIRTYMASK   =  4;
    public static final int CARDHOLDERLASTNAME_DIRTYGROUP  =  0;
    public static final int CARDHOLDERLASTNAME_DIRTYMASK   =  8;
    public static final int MEDEXAMEXPIRATIONDATE_DIRTYGROUP  =  0;
    public static final int MEDEXAMEXPIRATIONDATE_DIRTYMASK   =  16;
    public static final int MEDEXAMTYPECODE_DIRTYGROUP  =  0;
    public static final int MEDEXAMTYPECODE_DIRTYMASK   =  32;
    public static final int CARDEXPIRATIONDATE_DIRTYGROUP  =  0;
    public static final int CARDEXPIRATIONDATE_DIRTYMASK   =  64;
    public static final int BIRTHDATE_DIRTYGROUP  =  0;
    public static final int BIRTHDATE_DIRTYMASK   =  128;
    public static final int SEX_DIRTYGROUP  =  0;
    public static final int SEX_DIRTYMASK   =  256;
    public static final int BIRTHPLACE_DIRTYGROUP  =  0;
    public static final int BIRTHPLACE_DIRTYMASK   =  512;
    public static final int BIRTHDISTRICT_DIRTYGROUP  =  0;
    public static final int BIRTHDISTRICT_DIRTYMASK   =  1024;
    public static final int SSN_DIRTYGROUP  =  0;
    public static final int SSN_DIRTYMASK   =  2048;
    public static final int ADDRESS_DIRTYGROUP  =  0;
    public static final int ADDRESS_DIRTYMASK   =  4096;
    public static final int STREETNUMBER_DIRTYGROUP  =  0;
    public static final int STREETNUMBER_DIRTYMASK   =  8192;
    public static final int CITY_DIRTYGROUP  =  0;
    public static final int CITY_DIRTYMASK   =  16384;
    public static final int ZIPCODE_DIRTYGROUP  =  0;
    public static final int ZIPCODE_DIRTYMASK   =  32768;
    public static final int DISTRICT_DIRTYGROUP  =  0;
    public static final int DISTRICT_DIRTYMASK   =  65536;
    public static final int PHONE_DIRTYGROUP  =  0;
    public static final int PHONE_DIRTYMASK   =  131072;
    public static final int CELLULAR_DIRTYGROUP  =  0;
    public static final int CELLULAR_DIRTYMASK   =  262144;
    public static final int FAX_DIRTYGROUP  =  0;
    public static final int FAX_DIRTYMASK   =  524288;
    public static final int EMAIL_DIRTYGROUP  =  0;
    public static final int EMAIL_DIRTYMASK   =  1048576;
    public static final int RENEWALDATE_DIRTYGROUP  =  0;
    public static final int RENEWALDATE_DIRTYMASK   =  2097152;
    public static final int YACHTCLUB_DIRTYGROUP  =  0;
    public static final int YACHTCLUB_DIRTYMASK   =  4194304;
    public static final int MEMBERTYPECODE_DIRTYGROUP  =  0;
    public static final int MEMBERTYPECODE_DIRTYMASK   =  8388608;
    public static final int ACTIVITYTYPECODE_DIRTYGROUP  =  0;
    public static final int ACTIVITYTYPECODE_DIRTYMASK   =  16777216;
    public static final int SYSTEMCHECKDATE_DIRTYGROUP  =  0;
    public static final int SYSTEMCHECKDATE_DIRTYMASK   =  33554432;
    public static final int VERIFICATIONREQUIRED_DIRTYGROUP  =  0;
    public static final int VERIFICATIONREQUIRED_DIRTYMASK   =  67108864;
    public static final int CREATETIMESTAMP_DIRTYGROUP  =  0;
    public static final int CREATETIMESTAMP_DIRTYMASK   =  134217728;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  268435456;


    /**
      * DataBean constructor.
      */
    public FIVMemberDTOBase()
    {
       dirtyFlagsArray = new int[29 / 30 + 1];
       clearDirtyFlags();

       cardnumber = CARDNUMBER_DEFAULT;
       cardnumberstatuscode = CARDNUMBERSTATUSCODE_DEFAULT;
       cardholdername = CARDHOLDERNAME_DEFAULT;
       cardholderlastname = CARDHOLDERLASTNAME_DEFAULT;
       medexamexpirationdate = MEDEXAMEXPIRATIONDATE_DEFAULT;
       medexamtypecode = MEDEXAMTYPECODE_DEFAULT;
       cardexpirationdate = CARDEXPIRATIONDATE_DEFAULT;
       birthdate = BIRTHDATE_DEFAULT;
       sex = SEX_DEFAULT;
       birthplace = BIRTHPLACE_DEFAULT;
       birthdistrict = BIRTHDISTRICT_DEFAULT;
       ssn = SSN_DEFAULT;
       address = ADDRESS_DEFAULT;
       streetnumber = STREETNUMBER_DEFAULT;
       city = CITY_DEFAULT;
       zipcode = ZIPCODE_DEFAULT;
       district = DISTRICT_DEFAULT;
       phone = PHONE_DEFAULT;
       cellular = CELLULAR_DEFAULT;
       fax = FAX_DEFAULT;
       email = EMAIL_DEFAULT;
       renewaldate = RENEWALDATE_DEFAULT;
       yachtclub = YACHTCLUB_DEFAULT;
       membertypecode = MEMBERTYPECODE_DEFAULT;
       activitytypecode = ACTIVITYTYPECODE_DEFAULT;
       systemcheckdate = SYSTEMCHECKDATE_DEFAULT;
       verificationrequired = VERIFICATIONREQUIRED_DEFAULT;
       createtimestamp = CREATETIMESTAMP_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public FIVMemberDTOBase(FIVMemberDTOBase another)
    {

       cardnumber = another.getCardnumber();
       cardnumberstatuscode = another.getCardnumberstatuscode();
       cardholdername = another.getCardholdername();
       cardholderlastname = another.getCardholderlastname();
       medexamexpirationdate = another.getMedexamexpirationdate();
       medexamtypecode = another.getMedexamtypecode();
       cardexpirationdate = another.getCardexpirationdate();
       birthdate = another.getBirthdate();
       sex = another.getSex();
       birthplace = another.getBirthplace();
       birthdistrict = another.getBirthdistrict();
       ssn = another.getSsn();
       address = another.getAddress();
       streetnumber = another.getStreetnumber();
       city = another.getCity();
       zipcode = another.getZipcode();
       district = another.getDistrict();
       phone = another.getPhone();
       cellular = another.getCellular();
       fax = another.getFax();
       email = another.getEmail();
       renewaldate = another.getRenewaldate();
       yachtclub = another.getYachtclub();
       membertypecode = another.getMembertypecode();
       activitytypecode = another.getActivitytypecode();
       systemcheckdate = another.getSystemcheckdate();
       verificationrequired = another.getVerificationrequired();
       createtimestamp = another.getCreatetimestamp();
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
        stb.append(cardnumber);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (cardholderlastname != null)
        {
        stb.append(cardholderlastname);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // cardnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCardnumberDirty()  { return checkFieldDirtiness(CARDNUMBER_DIRTYGROUP, CARDNUMBER_DIRTYMASK); }

    public java.lang.String   getCardnumber()         { return cardnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCardnumberAsString() { return (cardnumber == null) ? "" : cardnumber; }

    // cardnumber setter methods.
    
    protected void markCardnumberAsDirty(boolean aFlag)  { markFieldAsDirty(CARDNUMBER_DIRTYGROUP, CARDNUMBER_DIRTYMASK, aFlag); }


    public void setCardnumber(String  p)
    {
       setCardnumber(p, DTOCasingStyle.none);
    }
    
    public void setCardnumber(String  p, DTOCasingStyle casingStyle)
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
       markCardnumberAsDirty(!equalsObject(cardnumber, p));
       cardnumber = p;
    }

    // cardnumberstatuscode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCardnumberstatuscodeDirty()  { return checkFieldDirtiness(CARDNUMBERSTATUSCODE_DIRTYGROUP, CARDNUMBERSTATUSCODE_DIRTYMASK); }

    public java.lang.String   getCardnumberstatuscode()         { return cardnumberstatuscode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCardnumberstatuscodeAsString() { return (cardnumberstatuscode == null) ? "" : cardnumberstatuscode; }

    // cardnumberstatuscode setter methods.
    
    protected void markCardnumberstatuscodeAsDirty(boolean aFlag)  { markFieldAsDirty(CARDNUMBERSTATUSCODE_DIRTYGROUP, CARDNUMBERSTATUSCODE_DIRTYMASK, aFlag); }


    public void setCardnumberstatuscode(String  p)
    {
       setCardnumberstatuscode(p, DTOCasingStyle.none);
    }
    
    public void setCardnumberstatuscode(String  p, DTOCasingStyle casingStyle)
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
       markCardnumberstatuscodeAsDirty(!equalsObject(cardnumberstatuscode, p));
       cardnumberstatuscode = p;
    }

    // cardholdername getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCardholdernameDirty()  { return checkFieldDirtiness(CARDHOLDERNAME_DIRTYGROUP, CARDHOLDERNAME_DIRTYMASK); }

    public java.lang.String   getCardholdername()         { return cardholdername; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCardholdernameAsString() { return (cardholdername == null) ? "" : cardholdername; }

    // cardholdername setter methods.
    
    protected void markCardholdernameAsDirty(boolean aFlag)  { markFieldAsDirty(CARDHOLDERNAME_DIRTYGROUP, CARDHOLDERNAME_DIRTYMASK, aFlag); }


    public void setCardholdername(String  p)
    {
       setCardholdername(p, DTOCasingStyle.none);
    }
    
    public void setCardholdername(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markCardholdernameAsDirty(!equalsObject(cardholdername, p));
       cardholdername = p;
    }

    // cardholderlastname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCardholderlastnameDirty()  { return checkFieldDirtiness(CARDHOLDERLASTNAME_DIRTYGROUP, CARDHOLDERLASTNAME_DIRTYMASK); }

    public java.lang.String   getCardholderlastname()         { return cardholderlastname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCardholderlastnameAsString() { return (cardholderlastname == null) ? "" : cardholderlastname; }

    // cardholderlastname setter methods.
    
    protected void markCardholderlastnameAsDirty(boolean aFlag)  { markFieldAsDirty(CARDHOLDERLASTNAME_DIRTYGROUP, CARDHOLDERLASTNAME_DIRTYMASK, aFlag); }


    public void setCardholderlastname(String  p)
    {
       setCardholderlastname(p, DTOCasingStyle.none);
    }
    
    public void setCardholderlastname(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markCardholderlastnameAsDirty(!equalsObject(cardholderlastname, p));
       cardholderlastname = p;
    }

    // medexamexpirationdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMedexamexpirationdateDirty()  { return checkFieldDirtiness(MEDEXAMEXPIRATIONDATE_DIRTYGROUP, MEDEXAMEXPIRATIONDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getMedexamexpirationdate() { return medexamexpirationdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getMedexamexpirationdateAsString() { return timestampAsString(medexamexpirationdate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getMedexamexpirationdateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(medexamexpirationdate, aDateFormat); }

    // medexamexpirationdate setter methods.
    
    protected void markMedexamexpirationdateAsDirty(boolean aFlag)  { markFieldAsDirty(MEDEXAMEXPIRATIONDATE_DIRTYGROUP, MEDEXAMEXPIRATIONDATE_DIRTYMASK, aFlag); }


    public void setMedexamexpirationdate(java.sql.Timestamp  p)
    {
        markMedexamexpirationdateAsDirty(!equalsObject(medexamexpirationdate, p));
    	medexamexpirationdate = p;
    }
    public void setMedexamexpirationdate(String  p, java.text.DateFormat aDateFormat)
    {
    	setMedexamexpirationdate(stringAsTimestamp(p, aDateFormat));
    }

    // medexamtypecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMedexamtypecodeDirty()  { return checkFieldDirtiness(MEDEXAMTYPECODE_DIRTYGROUP, MEDEXAMTYPECODE_DIRTYMASK); }

    public java.lang.String   getMedexamtypecode()         { return medexamtypecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getMedexamtypecodeAsString() { return (medexamtypecode == null) ? "" : medexamtypecode; }

    // medexamtypecode setter methods.
    
    protected void markMedexamtypecodeAsDirty(boolean aFlag)  { markFieldAsDirty(MEDEXAMTYPECODE_DIRTYGROUP, MEDEXAMTYPECODE_DIRTYMASK, aFlag); }


    public void setMedexamtypecode(String  p)
    {
       setMedexamtypecode(p, DTOCasingStyle.none);
    }
    
    public void setMedexamtypecode(String  p, DTOCasingStyle casingStyle)
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
       markMedexamtypecodeAsDirty(!equalsObject(medexamtypecode, p));
       medexamtypecode = p;
    }

    // cardexpirationdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCardexpirationdateDirty()  { return checkFieldDirtiness(CARDEXPIRATIONDATE_DIRTYGROUP, CARDEXPIRATIONDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getCardexpirationdate() { return cardexpirationdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCardexpirationdateAsString() { return timestampAsString(cardexpirationdate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCardexpirationdateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(cardexpirationdate, aDateFormat); }

    // cardexpirationdate setter methods.
    
    protected void markCardexpirationdateAsDirty(boolean aFlag)  { markFieldAsDirty(CARDEXPIRATIONDATE_DIRTYGROUP, CARDEXPIRATIONDATE_DIRTYMASK, aFlag); }


    public void setCardexpirationdate(java.sql.Timestamp  p)
    {
        markCardexpirationdateAsDirty(!equalsObject(cardexpirationdate, p));
    	cardexpirationdate = p;
    }
    public void setCardexpirationdate(String  p, java.text.DateFormat aDateFormat)
    {
    	setCardexpirationdate(stringAsTimestamp(p, aDateFormat));
    }

    // birthdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBirthdateDirty()  { return checkFieldDirtiness(BIRTHDATE_DIRTYGROUP, BIRTHDATE_DIRTYMASK); }

    public java.lang.String   getBirthdate()         { return birthdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getBirthdateAsString() { return (birthdate == null) ? "" : birthdate; }

    // birthdate setter methods.
    
    protected void markBirthdateAsDirty(boolean aFlag)  { markFieldAsDirty(BIRTHDATE_DIRTYGROUP, BIRTHDATE_DIRTYMASK, aFlag); }


    public void setBirthdate(String  p)
    {
       setBirthdate(p, DTOCasingStyle.none);
    }
    
    public void setBirthdate(String  p, DTOCasingStyle casingStyle)
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
       markBirthdateAsDirty(!equalsObject(birthdate, p));
       birthdate = p;
    }

    // sex getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSexDirty()  { return checkFieldDirtiness(SEX_DIRTYGROUP, SEX_DIRTYMASK); }

    public java.lang.String   getSex()         { return sex; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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

    // birthplace getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBirthplaceDirty()  { return checkFieldDirtiness(BIRTHPLACE_DIRTYGROUP, BIRTHPLACE_DIRTYMASK); }

    public java.lang.String   getBirthplace()         { return birthplace; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getBirthplaceAsString() { return (birthplace == null) ? "" : birthplace; }

    // birthplace setter methods.
    
    protected void markBirthplaceAsDirty(boolean aFlag)  { markFieldAsDirty(BIRTHPLACE_DIRTYGROUP, BIRTHPLACE_DIRTYMASK, aFlag); }


    public void setBirthplace(String  p)
    {
       setBirthplace(p, DTOCasingStyle.none);
    }
    
    public void setBirthplace(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markBirthplaceAsDirty(!equalsObject(birthplace, p));
       birthplace = p;
    }

    // birthdistrict getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBirthdistrictDirty()  { return checkFieldDirtiness(BIRTHDISTRICT_DIRTYGROUP, BIRTHDISTRICT_DIRTYMASK); }

    public java.lang.String   getBirthdistrict()         { return birthdistrict; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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
              p = p.toUpperCase();
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

    // ssn getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSsnDirty()  { return checkFieldDirtiness(SSN_DIRTYGROUP, SSN_DIRTYMASK); }

    public java.lang.String   getSsn()         { return ssn; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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
              p = p.toUpperCase();
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
              p = p.toUpperCase();
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

    // streetnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isStreetnumberDirty()  { return checkFieldDirtiness(STREETNUMBER_DIRTYGROUP, STREETNUMBER_DIRTYMASK); }

    public java.lang.String   getStreetnumber()         { return streetnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getStreetnumberAsString() { return (streetnumber == null) ? "" : streetnumber; }

    // streetnumber setter methods.
    
    protected void markStreetnumberAsDirty(boolean aFlag)  { markFieldAsDirty(STREETNUMBER_DIRTYGROUP, STREETNUMBER_DIRTYMASK, aFlag); }


    public void setStreetnumber(String  p)
    {
       setStreetnumber(p, DTOCasingStyle.none);
    }
    
    public void setStreetnumber(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markStreetnumberAsDirty(!equalsObject(streetnumber, p));
       streetnumber = p;
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
       setCity(p, DTOCasingStyle.none);
    }
    
    public void setCity(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

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
              p = p.toUpperCase();
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

    // district getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDistrictDirty()  { return checkFieldDirtiness(DISTRICT_DIRTYGROUP, DISTRICT_DIRTYMASK); }

    public java.lang.String   getDistrict()         { return district; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getDistrictAsString() { return (district == null) ? "" : district; }

    // district setter methods.
    
    protected void markDistrictAsDirty(boolean aFlag)  { markFieldAsDirty(DISTRICT_DIRTYGROUP, DISTRICT_DIRTYMASK, aFlag); }


    public void setDistrict(String  p)
    {
       setDistrict(p, DTOCasingStyle.none);
    }
    
    public void setDistrict(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markDistrictAsDirty(!equalsObject(district, p));
       district = p;
    }

    // phone getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPhoneDirty()  { return checkFieldDirtiness(PHONE_DIRTYGROUP, PHONE_DIRTYMASK); }

    public java.lang.String   getPhone()         { return phone; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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
              p = p.toUpperCase();
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

    // cellular getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCellularDirty()  { return checkFieldDirtiness(CELLULAR_DIRTYGROUP, CELLULAR_DIRTYMASK); }

    public java.lang.String   getCellular()         { return cellular; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCellularAsString() { return (cellular == null) ? "" : cellular; }

    // cellular setter methods.
    
    protected void markCellularAsDirty(boolean aFlag)  { markFieldAsDirty(CELLULAR_DIRTYGROUP, CELLULAR_DIRTYMASK, aFlag); }


    public void setCellular(String  p)
    {
       setCellular(p, DTOCasingStyle.none);
    }
    
    public void setCellular(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markCellularAsDirty(!equalsObject(cellular, p));
       cellular = p;
    }

    // fax getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFaxDirty()  { return checkFieldDirtiness(FAX_DIRTYGROUP, FAX_DIRTYMASK); }

    public java.lang.String   getFax()         { return fax; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getFaxAsString() { return (fax == null) ? "" : fax; }

    // fax setter methods.
    
    protected void markFaxAsDirty(boolean aFlag)  { markFieldAsDirty(FAX_DIRTYGROUP, FAX_DIRTYMASK, aFlag); }


    public void setFax(String  p)
    {
       setFax(p, DTOCasingStyle.none);
    }
    
    public void setFax(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markFaxAsDirty(!equalsObject(fax, p));
       fax = p;
    }

    // email getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEmailDirty()  { return checkFieldDirtiness(EMAIL_DIRTYGROUP, EMAIL_DIRTYMASK); }

    public java.lang.String   getEmail()         { return email; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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

    // renewaldate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRenewaldateDirty()  { return checkFieldDirtiness(RENEWALDATE_DIRTYGROUP, RENEWALDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getRenewaldate() { return renewaldate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getRenewaldateAsString() { return timestampAsString(renewaldate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getRenewaldateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(renewaldate, aDateFormat); }

    // renewaldate setter methods.
    
    protected void markRenewaldateAsDirty(boolean aFlag)  { markFieldAsDirty(RENEWALDATE_DIRTYGROUP, RENEWALDATE_DIRTYMASK, aFlag); }


    public void setRenewaldate(java.sql.Timestamp  p)
    {
        markRenewaldateAsDirty(!equalsObject(renewaldate, p));
    	renewaldate = p;
    }
    public void setRenewaldate(String  p, java.text.DateFormat aDateFormat)
    {
    	setRenewaldate(stringAsTimestamp(p, aDateFormat));
    }

    // yachtclub getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtclubDirty()  { return checkFieldDirtiness(YACHTCLUB_DIRTYGROUP, YACHTCLUB_DIRTYMASK); }

    public java.lang.String   getYachtclub()         { return yachtclub; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getYachtclubAsString() { return (yachtclub == null) ? "" : yachtclub; }

    // yachtclub setter methods.
    
    protected void markYachtclubAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTCLUB_DIRTYGROUP, YACHTCLUB_DIRTYMASK, aFlag); }


    public void setYachtclub(String  p)
    {
       setYachtclub(p, DTOCasingStyle.none);
    }
    
    public void setYachtclub(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toUpperCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markYachtclubAsDirty(!equalsObject(yachtclub, p));
       yachtclub = p;
    }

    // membertypecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMembertypecodeDirty()  { return checkFieldDirtiness(MEMBERTYPECODE_DIRTYGROUP, MEMBERTYPECODE_DIRTYMASK); }

    public java.lang.String   getMembertypecode()         { return membertypecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getMembertypecodeAsString() { return (membertypecode == null) ? "" : membertypecode; }

    // membertypecode setter methods.
    
    protected void markMembertypecodeAsDirty(boolean aFlag)  { markFieldAsDirty(MEMBERTYPECODE_DIRTYGROUP, MEMBERTYPECODE_DIRTYMASK, aFlag); }


    public void setMembertypecode(String  p)
    {
       setMembertypecode(p, DTOCasingStyle.none);
    }
    
    public void setMembertypecode(String  p, DTOCasingStyle casingStyle)
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
       markMembertypecodeAsDirty(!equalsObject(membertypecode, p));
       membertypecode = p;
    }

    // activitytypecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isActivitytypecodeDirty()  { return checkFieldDirtiness(ACTIVITYTYPECODE_DIRTYGROUP, ACTIVITYTYPECODE_DIRTYMASK); }

    public java.lang.String   getActivitytypecode()         { return activitytypecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getActivitytypecodeAsString() { return (activitytypecode == null) ? "" : activitytypecode; }

    // activitytypecode setter methods.
    
    protected void markActivitytypecodeAsDirty(boolean aFlag)  { markFieldAsDirty(ACTIVITYTYPECODE_DIRTYGROUP, ACTIVITYTYPECODE_DIRTYMASK, aFlag); }


    public void setActivitytypecode(String  p)
    {
       setActivitytypecode(p, DTOCasingStyle.none);
    }
    
    public void setActivitytypecode(String  p, DTOCasingStyle casingStyle)
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
       markActivitytypecodeAsDirty(!equalsObject(activitytypecode, p));
       activitytypecode = p;
    }

    // systemcheckdate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSystemcheckdateDirty()  { return checkFieldDirtiness(SYSTEMCHECKDATE_DIRTYGROUP, SYSTEMCHECKDATE_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getSystemcheckdate() { return systemcheckdate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getSystemcheckdateAsString() { return timestampAsString(systemcheckdate, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getSystemcheckdateAsString(java.text.DateFormat aDateFormat) { return timestampAsString(systemcheckdate, aDateFormat); }

    // systemcheckdate setter methods.
    
    protected void markSystemcheckdateAsDirty(boolean aFlag)  { markFieldAsDirty(SYSTEMCHECKDATE_DIRTYGROUP, SYSTEMCHECKDATE_DIRTYMASK, aFlag); }


    public void setSystemcheckdate(java.sql.Timestamp  p)
    {
        markSystemcheckdateAsDirty(!equalsObject(systemcheckdate, p));
    	systemcheckdate = p;
    }
    public void setSystemcheckdate(String  p, java.text.DateFormat aDateFormat)
    {
    	setSystemcheckdate(stringAsTimestamp(p, aDateFormat));
    }

    // verificationrequired getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isVerificationrequiredDirty()  { return checkFieldDirtiness(VERIFICATIONREQUIRED_DIRTYGROUP, VERIFICATIONREQUIRED_DIRTYMASK); }

    public java.lang.String   getVerificationrequired()         { return verificationrequired; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getVerificationrequiredAsString() { return (verificationrequired == null) ? "" : verificationrequired; }

    // verificationrequired setter methods.
    
    protected void markVerificationrequiredAsDirty(boolean aFlag)  { markFieldAsDirty(VERIFICATIONREQUIRED_DIRTYGROUP, VERIFICATIONREQUIRED_DIRTYMASK, aFlag); }


    public void setVerificationrequired(String  p)
    {
       setVerificationrequired(p, DTOCasingStyle.none);
    }
    
    public void setVerificationrequired(String  p, DTOCasingStyle casingStyle)
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
       markVerificationrequiredAsDirty(!equalsObject(verificationrequired, p));
       verificationrequired = p;
    }

    // createtimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCreatetimestampDirty()  { return checkFieldDirtiness(CREATETIMESTAMP_DIRTYGROUP, CREATETIMESTAMP_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getCreatetimestamp() { return createtimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCreatetimestampAsString() { return timestampAsString(createtimestamp, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCreatetimestampAsString(java.text.DateFormat aDateFormat) { return timestampAsString(createtimestamp, aDateFormat); }

    // createtimestamp setter methods.
    
    protected void markCreatetimestampAsDirty(boolean aFlag)  { markFieldAsDirty(CREATETIMESTAMP_DIRTYGROUP, CREATETIMESTAMP_DIRTYMASK, aFlag); }


    public void setCreatetimestamp(java.sql.Timestamp  p)
    {
        markCreatetimestampAsDirty(!equalsObject(createtimestamp, p));
    	createtimestamp = p;
    }
    public void setCreatetimestamp(String  p, java.text.DateFormat aDateFormat)
    {
    	setCreatetimestamp(stringAsTimestamp(p, aDateFormat));
    }

    // rectimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRectimestampDirty()  { return checkFieldDirtiness(RECTIMESTAMP_DIRTYGROUP, RECTIMESTAMP_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getRectimestamp() { return rectimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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
