//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.actor;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "ActorDTOBase")
public class ActorDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  actorid;
    protected java.lang.String  userid;
    protected java.lang.String  firstname;
    protected java.lang.String  lastname;
    protected java.lang.String  phone;
    protected java.lang.String  cellphone;
    protected java.lang.String  email;
    protected java.lang.String  address;
    protected java.lang.String  town;
    protected java.lang.String  zipcode;
    protected java.lang.String  contactgroup;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String ACTORID_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String FIRSTNAME_DEFAULT  =  null;
    public static final java.lang.String LASTNAME_DEFAULT  =  null;
    public static final java.lang.String PHONE_DEFAULT  =  null;
    public static final java.lang.String CELLPHONE_DEFAULT  =  null;
    public static final java.lang.String EMAIL_DEFAULT  =  null;
    public static final java.lang.String ADDRESS_DEFAULT  =  null;
    public static final java.lang.String TOWN_DEFAULT  =  null;
    public static final java.lang.String ZIPCODE_DEFAULT  =  null;
    public static final java.lang.String CONTACTGROUP_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int ACTORID_DIRTYGROUP  =  0;
    public static final int ACTORID_DIRTYMASK   =  2;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  4;
    public static final int FIRSTNAME_DIRTYGROUP  =  0;
    public static final int FIRSTNAME_DIRTYMASK   =  8;
    public static final int LASTNAME_DIRTYGROUP  =  0;
    public static final int LASTNAME_DIRTYMASK   =  16;
    public static final int PHONE_DIRTYGROUP  =  0;
    public static final int PHONE_DIRTYMASK   =  32;
    public static final int CELLPHONE_DIRTYGROUP  =  0;
    public static final int CELLPHONE_DIRTYMASK   =  64;
    public static final int EMAIL_DIRTYGROUP  =  0;
    public static final int EMAIL_DIRTYMASK   =  128;
    public static final int ADDRESS_DIRTYGROUP  =  0;
    public static final int ADDRESS_DIRTYMASK   =  256;
    public static final int TOWN_DIRTYGROUP  =  0;
    public static final int TOWN_DIRTYMASK   =  512;
    public static final int ZIPCODE_DIRTYGROUP  =  0;
    public static final int ZIPCODE_DIRTYMASK   =  1024;
    public static final int CONTACTGROUP_DIRTYGROUP  =  0;
    public static final int CONTACTGROUP_DIRTYMASK   =  2048;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  4096;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  8192;


    /**
      * DataBean constructor.
      */
    public ActorDTOBase()
    {
       dirtyFlagsArray = new int[14 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       actorid = ACTORID_DEFAULT;
       userid = USERID_DEFAULT;
       firstname = FIRSTNAME_DEFAULT;
       lastname = LASTNAME_DEFAULT;
       phone = PHONE_DEFAULT;
       cellphone = CELLPHONE_DEFAULT;
       email = EMAIL_DEFAULT;
       address = ADDRESS_DEFAULT;
       town = TOWN_DEFAULT;
       zipcode = ZIPCODE_DEFAULT;
       contactgroup = CONTACTGROUP_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public ActorDTOBase(ActorDTOBase another)
    {

       eventid = another.getEventid();
       actorid = another.getActorid();
       userid = another.getUserid();
       firstname = another.getFirstname();
       lastname = another.getLastname();
       phone = another.getPhone();
       cellphone = another.getCellphone();
       email = another.getEmail();
       address = another.getAddress();
       town = another.getTown();
       zipcode = another.getZipcode();
       contactgroup = another.getContactgroup();
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
        stb.append(eventid);
        stb.append(", ");
        stb.append(actorid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (lastname != null)
        {
        stb.append(lastname);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // eventid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isEventidDirty()  { return checkFieldDirtiness(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK); }

    public java.lang.String   getEventid()         { return eventid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "eventid")
    public java.lang.String   getEventidAsString() { return (eventid == null) ? "" : eventid; }

    // eventid setter methods.
    
    protected void markEventidAsDirty(boolean aFlag)  { markFieldAsDirty(EVENTID_DIRTYGROUP, EVENTID_DIRTYMASK, aFlag); }


    public void setEventid(String  p)
    {
       setEventid(p, DTOCasingStyle.none);
    }
    
    public void setEventid(String  p, DTOCasingStyle casingStyle)
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
       markEventidAsDirty(!equalsObject(eventid, p));
       eventid = p;
    }

    // actorid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isActoridDirty()  { return checkFieldDirtiness(ACTORID_DIRTYGROUP, ACTORID_DIRTYMASK); }

    public java.lang.String   getActorid()         { return actorid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "actorid")
    public java.lang.String   getActoridAsString() { return (actorid == null) ? "" : actorid; }

    // actorid setter methods.
    
    protected void markActoridAsDirty(boolean aFlag)  { markFieldAsDirty(ACTORID_DIRTYGROUP, ACTORID_DIRTYMASK, aFlag); }


    public void setActorid(String  p)
    {
       setActorid(p, DTOCasingStyle.none);
    }
    
    public void setActorid(String  p, DTOCasingStyle casingStyle)
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
       markActoridAsDirty(!equalsObject(actorid, p));
       actorid = p;
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

    // contactgroup getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isContactgroupDirty()  { return checkFieldDirtiness(CONTACTGROUP_DIRTYGROUP, CONTACTGROUP_DIRTYMASK); }

    public java.lang.String   getContactgroup()         { return contactgroup; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "contactgroup")
    public java.lang.String   getContactgroupAsString() { return (contactgroup == null) ? "" : contactgroup; }

    // contactgroup setter methods.
    
    protected void markContactgroupAsDirty(boolean aFlag)  { markFieldAsDirty(CONTACTGROUP_DIRTYGROUP, CONTACTGROUP_DIRTYMASK, aFlag); }


    public void setContactgroup(String  p)
    {
       setContactgroup(p, DTOCasingStyle.none);
    }
    
    public void setContactgroup(String  p, DTOCasingStyle casingStyle)
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
       markContactgroupAsDirty(!equalsObject(contactgroup, p));
       contactgroup = p;
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
