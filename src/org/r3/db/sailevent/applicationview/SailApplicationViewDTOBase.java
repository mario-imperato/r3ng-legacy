//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.applicationview;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SailApplicationViewDTOBase")
public class SailApplicationViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;
    protected java.lang.String  userid;
    protected java.lang.String  completionstatus;
    protected java.lang.String  verificationstatus;
    protected java.lang.String  adminchecks;
    protected java.lang.String  plate;
    protected java.lang.String  sailnumber;
    protected java.lang.String  yachtname;
    protected java.lang.String  yachtclub;
    protected java.lang.String  yachttype;
    protected java.lang.String  mooringloc;
    protected java.lang.Float  yachtbsf;
    protected java.lang.Float  yachtgph;
    protected java.lang.String  racegroup;
    protected java.lang.String  raceclass;
    protected java.lang.String  apptype;
    protected java.lang.String  ownerid;
    protected java.lang.String  ownerfirstname;
    protected java.lang.String  ownerlastname;
    protected java.lang.String  owneremail;
    protected java.lang.String  ownercellphone;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONID_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String COMPLETIONSTATUS_DEFAULT  =  null;
    public static final java.lang.String VERIFICATIONSTATUS_DEFAULT  =  null;
    public static final java.lang.String ADMINCHECKS_DEFAULT  =  null;
    public static final java.lang.String PLATE_DEFAULT  =  null;
    public static final java.lang.String SAILNUMBER_DEFAULT  =  null;
    public static final java.lang.String YACHTNAME_DEFAULT  =  null;
    public static final java.lang.String YACHTCLUB_DEFAULT  =  null;
    public static final java.lang.String YACHTTYPE_DEFAULT  =  null;
    public static final java.lang.String MOORINGLOC_DEFAULT  =  null;
    public static final java.lang.Float YACHTBSF_DEFAULT  =  null;
    public static final java.lang.Float YACHTGPH_DEFAULT  =  null;
    public static final java.lang.String RACEGROUP_DEFAULT  =  null;
    public static final java.lang.String RACECLASS_DEFAULT  =  null;
    public static final java.lang.String APPTYPE_DEFAULT  =  null;
    public static final java.lang.String OWNERID_DEFAULT  =  null;
    public static final java.lang.String OWNERFIRSTNAME_DEFAULT  =  null;
    public static final java.lang.String OWNERLASTNAME_DEFAULT  =  null;
    public static final java.lang.String OWNEREMAIL_DEFAULT  =  null;
    public static final java.lang.String OWNERCELLPHONE_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int APPLICATIONID_DIRTYGROUP  =  0;
    public static final int APPLICATIONID_DIRTYMASK   =  2;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  4;
    public static final int COMPLETIONSTATUS_DIRTYGROUP  =  0;
    public static final int COMPLETIONSTATUS_DIRTYMASK   =  8;
    public static final int VERIFICATIONSTATUS_DIRTYGROUP  =  0;
    public static final int VERIFICATIONSTATUS_DIRTYMASK   =  16;
    public static final int ADMINCHECKS_DIRTYGROUP  =  0;
    public static final int ADMINCHECKS_DIRTYMASK   =  32;
    public static final int PLATE_DIRTYGROUP  =  0;
    public static final int PLATE_DIRTYMASK   =  64;
    public static final int SAILNUMBER_DIRTYGROUP  =  0;
    public static final int SAILNUMBER_DIRTYMASK   =  128;
    public static final int YACHTNAME_DIRTYGROUP  =  0;
    public static final int YACHTNAME_DIRTYMASK   =  256;
    public static final int YACHTCLUB_DIRTYGROUP  =  0;
    public static final int YACHTCLUB_DIRTYMASK   =  512;
    public static final int YACHTTYPE_DIRTYGROUP  =  0;
    public static final int YACHTTYPE_DIRTYMASK   =  1024;
    public static final int MOORINGLOC_DIRTYGROUP  =  0;
    public static final int MOORINGLOC_DIRTYMASK   =  2048;
    public static final int YACHTBSF_DIRTYGROUP  =  0;
    public static final int YACHTBSF_DIRTYMASK   =  4096;
    public static final int YACHTGPH_DIRTYGROUP  =  0;
    public static final int YACHTGPH_DIRTYMASK   =  8192;
    public static final int RACEGROUP_DIRTYGROUP  =  0;
    public static final int RACEGROUP_DIRTYMASK   =  16384;
    public static final int RACECLASS_DIRTYGROUP  =  0;
    public static final int RACECLASS_DIRTYMASK   =  32768;
    public static final int APPTYPE_DIRTYGROUP  =  0;
    public static final int APPTYPE_DIRTYMASK   =  65536;
    public static final int OWNERID_DIRTYGROUP  =  0;
    public static final int OWNERID_DIRTYMASK   =  131072;
    public static final int OWNERFIRSTNAME_DIRTYGROUP  =  0;
    public static final int OWNERFIRSTNAME_DIRTYMASK   =  262144;
    public static final int OWNERLASTNAME_DIRTYGROUP  =  0;
    public static final int OWNERLASTNAME_DIRTYMASK   =  524288;
    public static final int OWNEREMAIL_DIRTYGROUP  =  0;
    public static final int OWNEREMAIL_DIRTYMASK   =  1048576;
    public static final int OWNERCELLPHONE_DIRTYGROUP  =  0;
    public static final int OWNERCELLPHONE_DIRTYMASK   =  2097152;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  4194304;


    /**
      * DataBean constructor.
      */
    public SailApplicationViewDTOBase()
    {
       dirtyFlagsArray = new int[23 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       applicationid = APPLICATIONID_DEFAULT;
       userid = USERID_DEFAULT;
       completionstatus = COMPLETIONSTATUS_DEFAULT;
       verificationstatus = VERIFICATIONSTATUS_DEFAULT;
       adminchecks = ADMINCHECKS_DEFAULT;
       plate = PLATE_DEFAULT;
       sailnumber = SAILNUMBER_DEFAULT;
       yachtname = YACHTNAME_DEFAULT;
       yachtclub = YACHTCLUB_DEFAULT;
       yachttype = YACHTTYPE_DEFAULT;
       mooringloc = MOORINGLOC_DEFAULT;
       yachtbsf = YACHTBSF_DEFAULT;
       yachtgph = YACHTGPH_DEFAULT;
       racegroup = RACEGROUP_DEFAULT;
       raceclass = RACECLASS_DEFAULT;
       apptype = APPTYPE_DEFAULT;
       ownerid = OWNERID_DEFAULT;
       ownerfirstname = OWNERFIRSTNAME_DEFAULT;
       ownerlastname = OWNERLASTNAME_DEFAULT;
       owneremail = OWNEREMAIL_DEFAULT;
       ownercellphone = OWNERCELLPHONE_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailApplicationViewDTOBase(SailApplicationViewDTOBase another)
    {

       eventid = another.getEventid();
       applicationid = another.getApplicationid();
       userid = another.getUserid();
       completionstatus = another.getCompletionstatus();
       verificationstatus = another.getVerificationstatus();
       adminchecks = another.getAdminchecks();
       plate = another.getPlate();
       sailnumber = another.getSailnumber();
       yachtname = another.getYachtname();
       yachtclub = another.getYachtclub();
       yachttype = another.getYachttype();
       mooringloc = another.getMooringloc();
       yachtbsf = another.getYachtbsf();
       yachtgph = another.getYachtgph();
       racegroup = another.getRacegroup();
       raceclass = another.getRaceclass();
       apptype = another.getApptype();
       ownerid = another.getOwnerid();
       ownerfirstname = another.getOwnerfirstname();
       ownerlastname = another.getOwnerlastname();
       owneremail = another.getOwneremail();
       ownercellphone = another.getOwnercellphone();
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

    // applicationid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isApplicationidDirty()  { return checkFieldDirtiness(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK); }

    public java.lang.String   getApplicationid()         { return applicationid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getApplicationidAsString() { return (applicationid == null) ? "" : applicationid; }

    // applicationid setter methods.
    
    protected void markApplicationidAsDirty(boolean aFlag)  { markFieldAsDirty(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK, aFlag); }


    public void setApplicationid(String  p)
    {
       setApplicationid(p, DTOCasingStyle.none);
    }
    
    public void setApplicationid(String  p, DTOCasingStyle casingStyle)
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
       markApplicationidAsDirty(!equalsObject(applicationid, p));
       applicationid = p;
    }

    // userid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUseridDirty()  { return checkFieldDirtiness(USERID_DIRTYGROUP, USERID_DIRTYMASK); }

    public java.lang.String   getUserid()         { return userid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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

    // completionstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletionstatusDirty()  { return checkFieldDirtiness(COMPLETIONSTATUS_DIRTYGROUP, COMPLETIONSTATUS_DIRTYMASK); }

    public java.lang.String   getCompletionstatus()         { return completionstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCompletionstatusAsString() { return (completionstatus == null) ? "" : completionstatus; }

    // completionstatus setter methods.
    
    protected void markCompletionstatusAsDirty(boolean aFlag)  { markFieldAsDirty(COMPLETIONSTATUS_DIRTYGROUP, COMPLETIONSTATUS_DIRTYMASK, aFlag); }


    public void setCompletionstatus(String  p)
    {
       setCompletionstatus(p, DTOCasingStyle.none);
    }
    
    public void setCompletionstatus(String  p, DTOCasingStyle casingStyle)
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
       markCompletionstatusAsDirty(!equalsObject(completionstatus, p));
       completionstatus = p;
    }

    // verificationstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isVerificationstatusDirty()  { return checkFieldDirtiness(VERIFICATIONSTATUS_DIRTYGROUP, VERIFICATIONSTATUS_DIRTYMASK); }

    public java.lang.String   getVerificationstatus()         { return verificationstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getVerificationstatusAsString() { return (verificationstatus == null) ? "" : verificationstatus; }

    // verificationstatus setter methods.
    
    protected void markVerificationstatusAsDirty(boolean aFlag)  { markFieldAsDirty(VERIFICATIONSTATUS_DIRTYGROUP, VERIFICATIONSTATUS_DIRTYMASK, aFlag); }


    public void setVerificationstatus(String  p)
    {
       setVerificationstatus(p, DTOCasingStyle.none);
    }
    
    public void setVerificationstatus(String  p, DTOCasingStyle casingStyle)
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
       markVerificationstatusAsDirty(!equalsObject(verificationstatus, p));
       verificationstatus = p;
    }

    // adminchecks getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAdminchecksDirty()  { return checkFieldDirtiness(ADMINCHECKS_DIRTYGROUP, ADMINCHECKS_DIRTYMASK); }

    public java.lang.String   getAdminchecks()         { return adminchecks; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getAdminchecksAsString() { return (adminchecks == null) ? "" : adminchecks; }

    // adminchecks setter methods.
    
    protected void markAdminchecksAsDirty(boolean aFlag)  { markFieldAsDirty(ADMINCHECKS_DIRTYGROUP, ADMINCHECKS_DIRTYMASK, aFlag); }


    public void setAdminchecks(String  p)
    {
       setAdminchecks(p, DTOCasingStyle.none);
    }
    
    public void setAdminchecks(String  p, DTOCasingStyle casingStyle)
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
       markAdminchecksAsDirty(!equalsObject(adminchecks, p));
       adminchecks = p;
    }

    // plate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPlateDirty()  { return checkFieldDirtiness(PLATE_DIRTYGROUP, PLATE_DIRTYMASK); }

    public java.lang.String   getPlate()         { return plate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getPlateAsString() { return (plate == null) ? "" : plate; }

    // plate setter methods.
    
    protected void markPlateAsDirty(boolean aFlag)  { markFieldAsDirty(PLATE_DIRTYGROUP, PLATE_DIRTYMASK, aFlag); }


    public void setPlate(String  p)
    {
       setPlate(p, DTOCasingStyle.none);
    }
    
    public void setPlate(String  p, DTOCasingStyle casingStyle)
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
       markPlateAsDirty(!equalsObject(plate, p));
       plate = p;
    }

    // sailnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSailnumberDirty()  { return checkFieldDirtiness(SAILNUMBER_DIRTYGROUP, SAILNUMBER_DIRTYMASK); }

    public java.lang.String   getSailnumber()         { return sailnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSailnumberAsString() { return (sailnumber == null) ? "" : sailnumber; }

    // sailnumber setter methods.
    
    protected void markSailnumberAsDirty(boolean aFlag)  { markFieldAsDirty(SAILNUMBER_DIRTYGROUP, SAILNUMBER_DIRTYMASK, aFlag); }


    public void setSailnumber(String  p)
    {
       setSailnumber(p, DTOCasingStyle.none);
    }
    
    public void setSailnumber(String  p, DTOCasingStyle casingStyle)
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
       markSailnumberAsDirty(!equalsObject(sailnumber, p));
       sailnumber = p;
    }

    // yachtname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtnameDirty()  { return checkFieldDirtiness(YACHTNAME_DIRTYGROUP, YACHTNAME_DIRTYMASK); }

    public java.lang.String   getYachtname()         { return yachtname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getYachtnameAsString() { return (yachtname == null) ? "" : yachtname; }

    // yachtname setter methods.
    
    protected void markYachtnameAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTNAME_DIRTYGROUP, YACHTNAME_DIRTYMASK, aFlag); }


    public void setYachtname(String  p)
    {
       setYachtname(p, DTOCasingStyle.none);
    }
    
    public void setYachtname(String  p, DTOCasingStyle casingStyle)
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
       markYachtnameAsDirty(!equalsObject(yachtname, p));
       yachtname = p;
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

    // yachttype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachttypeDirty()  { return checkFieldDirtiness(YACHTTYPE_DIRTYGROUP, YACHTTYPE_DIRTYMASK); }

    public java.lang.String   getYachttype()         { return yachttype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getYachttypeAsString() { return (yachttype == null) ? "" : yachttype; }

    // yachttype setter methods.
    
    protected void markYachttypeAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTTYPE_DIRTYGROUP, YACHTTYPE_DIRTYMASK, aFlag); }


    public void setYachttype(String  p)
    {
       setYachttype(p, DTOCasingStyle.none);
    }
    
    public void setYachttype(String  p, DTOCasingStyle casingStyle)
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
       markYachttypeAsDirty(!equalsObject(yachttype, p));
       yachttype = p;
    }

    // mooringloc getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMooringlocDirty()  { return checkFieldDirtiness(MOORINGLOC_DIRTYGROUP, MOORINGLOC_DIRTYMASK); }

    public java.lang.String   getMooringloc()         { return mooringloc; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getMooringlocAsString() { return (mooringloc == null) ? "" : mooringloc; }

    // mooringloc setter methods.
    
    protected void markMooringlocAsDirty(boolean aFlag)  { markFieldAsDirty(MOORINGLOC_DIRTYGROUP, MOORINGLOC_DIRTYMASK, aFlag); }


    public void setMooringloc(String  p)
    {
       setMooringloc(p, DTOCasingStyle.none);
    }
    
    public void setMooringloc(String  p, DTOCasingStyle casingStyle)
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
       markMooringlocAsDirty(!equalsObject(mooringloc, p));
       mooringloc = p;
    }

    // yachtbsf getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtbsfDirty()  { return checkFieldDirtiness(YACHTBSF_DIRTYGROUP, YACHTBSF_DIRTYMASK); }

    public java.lang.Float   getYachtbsf() { return yachtbsf; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getYachtbsfAsString() { return floatAsString(yachtbsf); }

    // yachtbsf setter methods.
    
    protected void markYachtbsfAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTBSF_DIRTYGROUP, YACHTBSF_DIRTYMASK, aFlag); }


    public void setYachtbsf(java.lang.Float  p)
    {
    	markYachtbsfAsDirty(!equalsObject(yachtbsf, p));
    	yachtbsf = p;
    }
    public void setYachtbsf()
    {
    	setYachtbsf((java.lang.Float)null);
    }
    public void setYachtbsf(String  p)
    {
    	setYachtbsf(stringAsFloat(p));
    }

    // yachtgph getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtgphDirty()  { return checkFieldDirtiness(YACHTGPH_DIRTYGROUP, YACHTGPH_DIRTYMASK); }

    public java.lang.Float   getYachtgph() { return yachtgph; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getYachtgphAsString() { return floatAsString(yachtgph); }

    // yachtgph setter methods.
    
    protected void markYachtgphAsDirty(boolean aFlag)  { markFieldAsDirty(YACHTGPH_DIRTYGROUP, YACHTGPH_DIRTYMASK, aFlag); }


    public void setYachtgph(java.lang.Float  p)
    {
    	markYachtgphAsDirty(!equalsObject(yachtgph, p));
    	yachtgph = p;
    }
    public void setYachtgph()
    {
    	setYachtgph((java.lang.Float)null);
    }
    public void setYachtgph(String  p)
    {
    	setYachtgph(stringAsFloat(p));
    }

    // racegroup getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacegroupDirty()  { return checkFieldDirtiness(RACEGROUP_DIRTYGROUP, RACEGROUP_DIRTYMASK); }

    public java.lang.String   getRacegroup()         { return racegroup; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getRacegroupAsString() { return (racegroup == null) ? "" : racegroup; }

    // racegroup setter methods.
    
    protected void markRacegroupAsDirty(boolean aFlag)  { markFieldAsDirty(RACEGROUP_DIRTYGROUP, RACEGROUP_DIRTYMASK, aFlag); }


    public void setRacegroup(String  p)
    {
       setRacegroup(p, DTOCasingStyle.none);
    }
    
    public void setRacegroup(String  p, DTOCasingStyle casingStyle)
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
       markRacegroupAsDirty(!equalsObject(racegroup, p));
       racegroup = p;
    }

    // raceclass getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRaceclassDirty()  { return checkFieldDirtiness(RACECLASS_DIRTYGROUP, RACECLASS_DIRTYMASK); }

    public java.lang.String   getRaceclass()         { return raceclass; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getRaceclassAsString() { return (raceclass == null) ? "" : raceclass; }

    // raceclass setter methods.
    
    protected void markRaceclassAsDirty(boolean aFlag)  { markFieldAsDirty(RACECLASS_DIRTYGROUP, RACECLASS_DIRTYMASK, aFlag); }


    public void setRaceclass(String  p)
    {
       setRaceclass(p, DTOCasingStyle.none);
    }
    
    public void setRaceclass(String  p, DTOCasingStyle casingStyle)
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
       markRaceclassAsDirty(!equalsObject(raceclass, p));
       raceclass = p;
    }

    // apptype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isApptypeDirty()  { return checkFieldDirtiness(APPTYPE_DIRTYGROUP, APPTYPE_DIRTYMASK); }

    public java.lang.String   getApptype()         { return apptype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getApptypeAsString() { return (apptype == null) ? "" : apptype; }

    // apptype setter methods.
    
    protected void markApptypeAsDirty(boolean aFlag)  { markFieldAsDirty(APPTYPE_DIRTYGROUP, APPTYPE_DIRTYMASK, aFlag); }


    public void setApptype(String  p)
    {
       setApptype(p, DTOCasingStyle.none);
    }
    
    public void setApptype(String  p, DTOCasingStyle casingStyle)
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
       markApptypeAsDirty(!equalsObject(apptype, p));
       apptype = p;
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
       setOwnerid(p, DTOCasingStyle.none);
    }
    
    public void setOwnerid(String  p, DTOCasingStyle casingStyle)
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
       markOwneridAsDirty(!equalsObject(ownerid, p));
       ownerid = p;
    }

    // ownerfirstname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOwnerfirstnameDirty()  { return checkFieldDirtiness(OWNERFIRSTNAME_DIRTYGROUP, OWNERFIRSTNAME_DIRTYMASK); }

    public java.lang.String   getOwnerfirstname()         { return ownerfirstname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getOwnerfirstnameAsString() { return (ownerfirstname == null) ? "" : ownerfirstname; }

    // ownerfirstname setter methods.
    
    protected void markOwnerfirstnameAsDirty(boolean aFlag)  { markFieldAsDirty(OWNERFIRSTNAME_DIRTYGROUP, OWNERFIRSTNAME_DIRTYMASK, aFlag); }


    public void setOwnerfirstname(String  p)
    {
       setOwnerfirstname(p, DTOCasingStyle.none);
    }
    
    public void setOwnerfirstname(String  p, DTOCasingStyle casingStyle)
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
       markOwnerfirstnameAsDirty(!equalsObject(ownerfirstname, p));
       ownerfirstname = p;
    }

    // ownerlastname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOwnerlastnameDirty()  { return checkFieldDirtiness(OWNERLASTNAME_DIRTYGROUP, OWNERLASTNAME_DIRTYMASK); }

    public java.lang.String   getOwnerlastname()         { return ownerlastname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getOwnerlastnameAsString() { return (ownerlastname == null) ? "" : ownerlastname; }

    // ownerlastname setter methods.
    
    protected void markOwnerlastnameAsDirty(boolean aFlag)  { markFieldAsDirty(OWNERLASTNAME_DIRTYGROUP, OWNERLASTNAME_DIRTYMASK, aFlag); }


    public void setOwnerlastname(String  p)
    {
       setOwnerlastname(p, DTOCasingStyle.none);
    }
    
    public void setOwnerlastname(String  p, DTOCasingStyle casingStyle)
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
       markOwnerlastnameAsDirty(!equalsObject(ownerlastname, p));
       ownerlastname = p;
    }

    // owneremail getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOwneremailDirty()  { return checkFieldDirtiness(OWNEREMAIL_DIRTYGROUP, OWNEREMAIL_DIRTYMASK); }

    public java.lang.String   getOwneremail()         { return owneremail; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getOwneremailAsString() { return (owneremail == null) ? "" : owneremail; }

    // owneremail setter methods.
    
    protected void markOwneremailAsDirty(boolean aFlag)  { markFieldAsDirty(OWNEREMAIL_DIRTYGROUP, OWNEREMAIL_DIRTYMASK, aFlag); }


    public void setOwneremail(String  p)
    {
       setOwneremail(p, DTOCasingStyle.none);
    }
    
    public void setOwneremail(String  p, DTOCasingStyle casingStyle)
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
       markOwneremailAsDirty(!equalsObject(owneremail, p));
       owneremail = p;
    }

    // ownercellphone getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isOwnercellphoneDirty()  { return checkFieldDirtiness(OWNERCELLPHONE_DIRTYGROUP, OWNERCELLPHONE_DIRTYMASK); }

    public java.lang.String   getOwnercellphone()         { return ownercellphone; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getOwnercellphoneAsString() { return (ownercellphone == null) ? "" : ownercellphone; }

    // ownercellphone setter methods.
    
    protected void markOwnercellphoneAsDirty(boolean aFlag)  { markFieldAsDirty(OWNERCELLPHONE_DIRTYGROUP, OWNERCELLPHONE_DIRTYMASK, aFlag); }


    public void setOwnercellphone(String  p)
    {
       setOwnercellphone(p, DTOCasingStyle.none);
    }
    
    public void setOwnercellphone(String  p, DTOCasingStyle casingStyle)
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
       markOwnercellphoneAsDirty(!equalsObject(ownercellphone, p));
       ownercellphone = p;
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
