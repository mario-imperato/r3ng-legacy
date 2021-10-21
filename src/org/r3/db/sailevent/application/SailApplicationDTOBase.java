//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.application;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SailApplicationDTOBase")
public class SailApplicationDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;
    protected java.lang.String  userid;
    protected java.lang.String  dmsfolderurl;
    protected java.lang.String  annotation;
    protected java.lang.String  completionstatus;
    protected java.lang.String  verificationstatus;
    protected java.lang.String  adminchecks;
    protected java.lang.String  adminracegroup;
    protected java.lang.String  adminraceclass;
    protected java.lang.String  plate;
    protected java.lang.String  yachtname;
    protected java.lang.String  yachtclub;
    protected java.lang.String  yachttype;
    protected java.lang.String  mooringloc;
    protected java.lang.Float  yachtbsf;
    protected java.lang.Float  yachtgph;
    protected java.lang.String  sailnumber;
    protected java.lang.String  racegroup;
    protected java.lang.String  raceclass;
    protected java.lang.String  apptype;
    protected java.lang.String  ownerid;
    protected java.lang.String  helmsmanid;
    protected java.lang.String  boatimageid;
    protected java.lang.String  boatimageurl;
    protected java.lang.Integer  boatimageheight;
    protected java.lang.Integer  boatimagewidth;
    protected java.lang.String  boaticonurl;
    protected java.lang.Integer  boaticonwidth;
    protected java.lang.Integer  boaticonheight;
    protected java.lang.String  addtohomeentrylist;
    protected java.sql.Timestamp  createtimestamp;
    protected java.sql.Timestamp  committimestamp;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONID_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String DMSFOLDERURL_DEFAULT  =  null;
    public static final java.lang.String ANNOTATION_DEFAULT  =  null;
    public static final java.lang.String COMPLETIONSTATUS_DEFAULT  =  null;
    public static final java.lang.String VERIFICATIONSTATUS_DEFAULT  =  null;
    public static final java.lang.String ADMINCHECKS_DEFAULT  =  null;
    public static final java.lang.String ADMINRACEGROUP_DEFAULT  =  null;
    public static final java.lang.String ADMINRACECLASS_DEFAULT  =  null;
    public static final java.lang.String PLATE_DEFAULT  =  null;
    public static final java.lang.String YACHTNAME_DEFAULT  =  null;
    public static final java.lang.String YACHTCLUB_DEFAULT  =  null;
    public static final java.lang.String YACHTTYPE_DEFAULT  =  null;
    public static final java.lang.String MOORINGLOC_DEFAULT  =  null;
    public static final java.lang.Float YACHTBSF_DEFAULT  =  null;
    public static final java.lang.Float YACHTGPH_DEFAULT  =  null;
    public static final java.lang.String SAILNUMBER_DEFAULT  =  null;
    public static final java.lang.String RACEGROUP_DEFAULT  =  null;
    public static final java.lang.String RACECLASS_DEFAULT  =  null;
    public static final java.lang.String APPTYPE_DEFAULT  =  null;
    public static final java.lang.String OWNERID_DEFAULT  =  null;
    public static final java.lang.String HELMSMANID_DEFAULT  =  null;
    public static final java.lang.String BOATIMAGEID_DEFAULT  =  null;
    public static final java.lang.String BOATIMAGEURL_DEFAULT  =  null;
    public static final java.lang.Integer BOATIMAGEHEIGHT_DEFAULT  =  null;
    public static final java.lang.Integer BOATIMAGEWIDTH_DEFAULT  =  null;
    public static final java.lang.String BOATICONURL_DEFAULT  =  null;
    public static final java.lang.Integer BOATICONWIDTH_DEFAULT  =  null;
    public static final java.lang.Integer BOATICONHEIGHT_DEFAULT  =  null;
    public static final java.lang.String ADDTOHOMEENTRYLIST_DEFAULT  =  null;
    public static final java.sql.Timestamp CREATETIMESTAMP_DEFAULT  =  null;
    public static final java.sql.Timestamp COMMITTIMESTAMP_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  1;
    public static final int APPLICATIONID_DIRTYGROUP  =  0;
    public static final int APPLICATIONID_DIRTYMASK   =  2;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  4;
    public static final int DMSFOLDERURL_DIRTYGROUP  =  0;
    public static final int DMSFOLDERURL_DIRTYMASK   =  8;
    public static final int ANNOTATION_DIRTYGROUP  =  0;
    public static final int ANNOTATION_DIRTYMASK   =  16;
    public static final int COMPLETIONSTATUS_DIRTYGROUP  =  0;
    public static final int COMPLETIONSTATUS_DIRTYMASK   =  32;
    public static final int VERIFICATIONSTATUS_DIRTYGROUP  =  0;
    public static final int VERIFICATIONSTATUS_DIRTYMASK   =  64;
    public static final int ADMINCHECKS_DIRTYGROUP  =  0;
    public static final int ADMINCHECKS_DIRTYMASK   =  128;
    public static final int ADMINRACEGROUP_DIRTYGROUP  =  0;
    public static final int ADMINRACEGROUP_DIRTYMASK   =  256;
    public static final int ADMINRACECLASS_DIRTYGROUP  =  0;
    public static final int ADMINRACECLASS_DIRTYMASK   =  512;
    public static final int PLATE_DIRTYGROUP  =  0;
    public static final int PLATE_DIRTYMASK   =  1024;
    public static final int YACHTNAME_DIRTYGROUP  =  0;
    public static final int YACHTNAME_DIRTYMASK   =  2048;
    public static final int YACHTCLUB_DIRTYGROUP  =  0;
    public static final int YACHTCLUB_DIRTYMASK   =  4096;
    public static final int YACHTTYPE_DIRTYGROUP  =  0;
    public static final int YACHTTYPE_DIRTYMASK   =  8192;
    public static final int MOORINGLOC_DIRTYGROUP  =  0;
    public static final int MOORINGLOC_DIRTYMASK   =  16384;
    public static final int YACHTBSF_DIRTYGROUP  =  0;
    public static final int YACHTBSF_DIRTYMASK   =  32768;
    public static final int YACHTGPH_DIRTYGROUP  =  0;
    public static final int YACHTGPH_DIRTYMASK   =  65536;
    public static final int SAILNUMBER_DIRTYGROUP  =  0;
    public static final int SAILNUMBER_DIRTYMASK   =  131072;
    public static final int RACEGROUP_DIRTYGROUP  =  0;
    public static final int RACEGROUP_DIRTYMASK   =  262144;
    public static final int RACECLASS_DIRTYGROUP  =  0;
    public static final int RACECLASS_DIRTYMASK   =  524288;
    public static final int APPTYPE_DIRTYGROUP  =  0;
    public static final int APPTYPE_DIRTYMASK   =  1048576;
    public static final int OWNERID_DIRTYGROUP  =  0;
    public static final int OWNERID_DIRTYMASK   =  2097152;
    public static final int HELMSMANID_DIRTYGROUP  =  0;
    public static final int HELMSMANID_DIRTYMASK   =  4194304;
    public static final int BOATIMAGEID_DIRTYGROUP  =  0;
    public static final int BOATIMAGEID_DIRTYMASK   =  8388608;
    public static final int BOATIMAGEURL_DIRTYGROUP  =  0;
    public static final int BOATIMAGEURL_DIRTYMASK   =  16777216;
    public static final int BOATIMAGEHEIGHT_DIRTYGROUP  =  0;
    public static final int BOATIMAGEHEIGHT_DIRTYMASK   =  33554432;
    public static final int BOATIMAGEWIDTH_DIRTYGROUP  =  0;
    public static final int BOATIMAGEWIDTH_DIRTYMASK   =  67108864;
    public static final int BOATICONURL_DIRTYGROUP  =  0;
    public static final int BOATICONURL_DIRTYMASK   =  134217728;
    public static final int BOATICONWIDTH_DIRTYGROUP  =  0;
    public static final int BOATICONWIDTH_DIRTYMASK   =  268435456;
    public static final int BOATICONHEIGHT_DIRTYGROUP  =  0;
    public static final int BOATICONHEIGHT_DIRTYMASK   =  536870912;
    public static final int ADDTOHOMEENTRYLIST_DIRTYGROUP  =  1;
    public static final int ADDTOHOMEENTRYLIST_DIRTYMASK   =  1;
    public static final int CREATETIMESTAMP_DIRTYGROUP  =  1;
    public static final int CREATETIMESTAMP_DIRTYMASK   =  2;
    public static final int COMMITTIMESTAMP_DIRTYGROUP  =  1;
    public static final int COMMITTIMESTAMP_DIRTYMASK   =  4;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  1;
    public static final int RECTIMESTAMP_DIRTYMASK   =  8;


    /**
      * DataBean constructor.
      */
    public SailApplicationDTOBase()
    {
       dirtyFlagsArray = new int[34 / 30 + 1];
       clearDirtyFlags();

       eventid = EVENTID_DEFAULT;
       applicationid = APPLICATIONID_DEFAULT;
       userid = USERID_DEFAULT;
       dmsfolderurl = DMSFOLDERURL_DEFAULT;
       annotation = ANNOTATION_DEFAULT;
       completionstatus = COMPLETIONSTATUS_DEFAULT;
       verificationstatus = VERIFICATIONSTATUS_DEFAULT;
       adminchecks = ADMINCHECKS_DEFAULT;
       adminracegroup = ADMINRACEGROUP_DEFAULT;
       adminraceclass = ADMINRACECLASS_DEFAULT;
       plate = PLATE_DEFAULT;
       yachtname = YACHTNAME_DEFAULT;
       yachtclub = YACHTCLUB_DEFAULT;
       yachttype = YACHTTYPE_DEFAULT;
       mooringloc = MOORINGLOC_DEFAULT;
       yachtbsf = YACHTBSF_DEFAULT;
       yachtgph = YACHTGPH_DEFAULT;
       sailnumber = SAILNUMBER_DEFAULT;
       racegroup = RACEGROUP_DEFAULT;
       raceclass = RACECLASS_DEFAULT;
       apptype = APPTYPE_DEFAULT;
       ownerid = OWNERID_DEFAULT;
       helmsmanid = HELMSMANID_DEFAULT;
       boatimageid = BOATIMAGEID_DEFAULT;
       boatimageurl = BOATIMAGEURL_DEFAULT;
       boatimageheight = BOATIMAGEHEIGHT_DEFAULT;
       boatimagewidth = BOATIMAGEWIDTH_DEFAULT;
       boaticonurl = BOATICONURL_DEFAULT;
       boaticonwidth = BOATICONWIDTH_DEFAULT;
       boaticonheight = BOATICONHEIGHT_DEFAULT;
       addtohomeentrylist = ADDTOHOMEENTRYLIST_DEFAULT;
       createtimestamp = CREATETIMESTAMP_DEFAULT;
       committimestamp = COMMITTIMESTAMP_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailApplicationDTOBase(SailApplicationDTOBase another)
    {

       eventid = another.getEventid();
       applicationid = another.getApplicationid();
       userid = another.getUserid();
       dmsfolderurl = another.getDmsfolderurl();
       annotation = another.getAnnotation();
       completionstatus = another.getCompletionstatus();
       verificationstatus = another.getVerificationstatus();
       adminchecks = another.getAdminchecks();
       adminracegroup = another.getAdminracegroup();
       adminraceclass = another.getAdminraceclass();
       plate = another.getPlate();
       yachtname = another.getYachtname();
       yachtclub = another.getYachtclub();
       yachttype = another.getYachttype();
       mooringloc = another.getMooringloc();
       yachtbsf = another.getYachtbsf();
       yachtgph = another.getYachtgph();
       sailnumber = another.getSailnumber();
       racegroup = another.getRacegroup();
       raceclass = another.getRaceclass();
       apptype = another.getApptype();
       ownerid = another.getOwnerid();
       helmsmanid = another.getHelmsmanid();
       boatimageid = another.getBoatimageid();
       boatimageurl = another.getBoatimageurl();
       boatimageheight = another.getBoatimageheight();
       boatimagewidth = another.getBoatimagewidth();
       boaticonurl = another.getBoaticonurl();
       boaticonwidth = another.getBoaticonwidth();
       boaticonheight = another.getBoaticonheight();
       addtohomeentrylist = another.getAddtohomeentrylist();
       createtimestamp = another.getCreatetimestamp();
       committimestamp = another.getCommittimestamp();
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
        stb.append(applicationid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (yachtname != null)
        {
        stb.append(yachtname);
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

    // applicationid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isApplicationidDirty()  { return checkFieldDirtiness(APPLICATIONID_DIRTYGROUP, APPLICATIONID_DIRTYMASK); }

    public java.lang.String   getApplicationid()         { return applicationid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "applicationid")
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

    // dmsfolderurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDmsfolderurlDirty()  { return checkFieldDirtiness(DMSFOLDERURL_DIRTYGROUP, DMSFOLDERURL_DIRTYMASK); }

    public java.lang.String   getDmsfolderurl()         { return dmsfolderurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "dmsfolderurl")
    public java.lang.String   getDmsfolderurlAsString() { return (dmsfolderurl == null) ? "" : dmsfolderurl; }

    // dmsfolderurl setter methods.
    
    protected void markDmsfolderurlAsDirty(boolean aFlag)  { markFieldAsDirty(DMSFOLDERURL_DIRTYGROUP, DMSFOLDERURL_DIRTYMASK, aFlag); }


    public void setDmsfolderurl(String  p)
    {
       setDmsfolderurl(p, DTOCasingStyle.none);
    }
    
    public void setDmsfolderurl(String  p, DTOCasingStyle casingStyle)
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
       markDmsfolderurlAsDirty(!equalsObject(dmsfolderurl, p));
       dmsfolderurl = p;
    }

    // annotation getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAnnotationDirty()  { return checkFieldDirtiness(ANNOTATION_DIRTYGROUP, ANNOTATION_DIRTYMASK); }

    public java.lang.String   getAnnotation()         { return annotation; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "annotation")
    public java.lang.String   getAnnotationAsString() { return (annotation == null) ? "" : annotation; }

    // annotation setter methods.
    
    protected void markAnnotationAsDirty(boolean aFlag)  { markFieldAsDirty(ANNOTATION_DIRTYGROUP, ANNOTATION_DIRTYMASK, aFlag); }


    public void setAnnotation(String  p)
    {
       setAnnotation(p, DTOCasingStyle.none);
    }
    
    public void setAnnotation(String  p, DTOCasingStyle casingStyle)
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
       markAnnotationAsDirty(!equalsObject(annotation, p));
       annotation = p;
    }

    // completionstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompletionstatusDirty()  { return checkFieldDirtiness(COMPLETIONSTATUS_DIRTYGROUP, COMPLETIONSTATUS_DIRTYMASK); }

    public java.lang.String   getCompletionstatus()         { return completionstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "completionstatus")
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
    @CSVAnnotation(attribute = "verificationstatus")
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
    @CSVAnnotation(attribute = "adminchecks")
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

    // adminracegroup getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAdminracegroupDirty()  { return checkFieldDirtiness(ADMINRACEGROUP_DIRTYGROUP, ADMINRACEGROUP_DIRTYMASK); }

    public java.lang.String   getAdminracegroup()         { return adminracegroup; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "adminracegroup")
    public java.lang.String   getAdminracegroupAsString() { return (adminracegroup == null) ? "" : adminracegroup; }

    // adminracegroup setter methods.
    
    protected void markAdminracegroupAsDirty(boolean aFlag)  { markFieldAsDirty(ADMINRACEGROUP_DIRTYGROUP, ADMINRACEGROUP_DIRTYMASK, aFlag); }


    public void setAdminracegroup(String  p)
    {
       setAdminracegroup(p, DTOCasingStyle.none);
    }
    
    public void setAdminracegroup(String  p, DTOCasingStyle casingStyle)
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
       markAdminracegroupAsDirty(!equalsObject(adminracegroup, p));
       adminracegroup = p;
    }

    // adminraceclass getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAdminraceclassDirty()  { return checkFieldDirtiness(ADMINRACECLASS_DIRTYGROUP, ADMINRACECLASS_DIRTYMASK); }

    public java.lang.String   getAdminraceclass()         { return adminraceclass; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "adminraceclass")
    public java.lang.String   getAdminraceclassAsString() { return (adminraceclass == null) ? "" : adminraceclass; }

    // adminraceclass setter methods.
    
    protected void markAdminraceclassAsDirty(boolean aFlag)  { markFieldAsDirty(ADMINRACECLASS_DIRTYGROUP, ADMINRACECLASS_DIRTYMASK, aFlag); }


    public void setAdminraceclass(String  p)
    {
       setAdminraceclass(p, DTOCasingStyle.none);
    }
    
    public void setAdminraceclass(String  p, DTOCasingStyle casingStyle)
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
       markAdminraceclassAsDirty(!equalsObject(adminraceclass, p));
       adminraceclass = p;
    }

    // plate getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPlateDirty()  { return checkFieldDirtiness(PLATE_DIRTYGROUP, PLATE_DIRTYMASK); }

    public java.lang.String   getPlate()         { return plate; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "plate")
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
       markPlateAsDirty(!equalsObject(plate, p));
       plate = p;
    }

    // yachtname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachtnameDirty()  { return checkFieldDirtiness(YACHTNAME_DIRTYGROUP, YACHTNAME_DIRTYMASK); }

    public java.lang.String   getYachtname()         { return yachtname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "yachtname")
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
    @CSVAnnotation(attribute = "yachtclub")
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

    // yachttype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isYachttypeDirty()  { return checkFieldDirtiness(YACHTTYPE_DIRTYGROUP, YACHTTYPE_DIRTYMASK); }

    public java.lang.String   getYachttype()         { return yachttype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "yachttype")
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
    @CSVAnnotation(attribute = "mooringloc")
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
    @CSVAnnotation(attribute = "yachtbsf")
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
    @CSVAnnotation(attribute = "yachtgph")
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

    // sailnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSailnumberDirty()  { return checkFieldDirtiness(SAILNUMBER_DIRTYGROUP, SAILNUMBER_DIRTYMASK); }

    public java.lang.String   getSailnumber()         { return sailnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "sailnumber")
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
       markSailnumberAsDirty(!equalsObject(sailnumber, p));
       sailnumber = p;
    }

    // racegroup getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRacegroupDirty()  { return checkFieldDirtiness(RACEGROUP_DIRTYGROUP, RACEGROUP_DIRTYMASK); }

    public java.lang.String   getRacegroup()         { return racegroup; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "racegroup")
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
    @CSVAnnotation(attribute = "raceclass")
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
    @CSVAnnotation(attribute = "apptype")
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
    @CSVAnnotation(attribute = "ownerid")
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

    // helmsmanid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isHelmsmanidDirty()  { return checkFieldDirtiness(HELMSMANID_DIRTYGROUP, HELMSMANID_DIRTYMASK); }

    public java.lang.String   getHelmsmanid()         { return helmsmanid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "helmsmanid")
    public java.lang.String   getHelmsmanidAsString() { return (helmsmanid == null) ? "" : helmsmanid; }

    // helmsmanid setter methods.
    
    protected void markHelmsmanidAsDirty(boolean aFlag)  { markFieldAsDirty(HELMSMANID_DIRTYGROUP, HELMSMANID_DIRTYMASK, aFlag); }


    public void setHelmsmanid(String  p)
    {
       setHelmsmanid(p, DTOCasingStyle.none);
    }
    
    public void setHelmsmanid(String  p, DTOCasingStyle casingStyle)
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
       markHelmsmanidAsDirty(!equalsObject(helmsmanid, p));
       helmsmanid = p;
    }

    // boatimageid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoatimageidDirty()  { return checkFieldDirtiness(BOATIMAGEID_DIRTYGROUP, BOATIMAGEID_DIRTYMASK); }

    public java.lang.String   getBoatimageid()         { return boatimageid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "boatimageid")
    public java.lang.String   getBoatimageidAsString() { return (boatimageid == null) ? "" : boatimageid; }

    // boatimageid setter methods.
    
    protected void markBoatimageidAsDirty(boolean aFlag)  { markFieldAsDirty(BOATIMAGEID_DIRTYGROUP, BOATIMAGEID_DIRTYMASK, aFlag); }


    public void setBoatimageid(String  p)
    {
       setBoatimageid(p, DTOCasingStyle.none);
    }
    
    public void setBoatimageid(String  p, DTOCasingStyle casingStyle)
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
       markBoatimageidAsDirty(!equalsObject(boatimageid, p));
       boatimageid = p;
    }

    // boatimageurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoatimageurlDirty()  { return checkFieldDirtiness(BOATIMAGEURL_DIRTYGROUP, BOATIMAGEURL_DIRTYMASK); }

    public java.lang.String   getBoatimageurl()         { return boatimageurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "boatimageurl")
    public java.lang.String   getBoatimageurlAsString() { return (boatimageurl == null) ? "" : boatimageurl; }

    // boatimageurl setter methods.
    
    protected void markBoatimageurlAsDirty(boolean aFlag)  { markFieldAsDirty(BOATIMAGEURL_DIRTYGROUP, BOATIMAGEURL_DIRTYMASK, aFlag); }


    public void setBoatimageurl(String  p)
    {
       setBoatimageurl(p, DTOCasingStyle.none);
    }
    
    public void setBoatimageurl(String  p, DTOCasingStyle casingStyle)
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
       markBoatimageurlAsDirty(!equalsObject(boatimageurl, p));
       boatimageurl = p;
    }

    // boatimageheight getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoatimageheightDirty()  { return checkFieldDirtiness(BOATIMAGEHEIGHT_DIRTYGROUP, BOATIMAGEHEIGHT_DIRTYMASK); }

    public java.lang.Integer   getBoatimageheight() { return boatimageheight; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "boatimageheight")
    public String getBoatimageheightAsString() { return integerAsString(boatimageheight); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getBoatimageheightAsInt()    { return boatimageheight != null ? boatimageheight.intValue() : 0; }

    // boatimageheight setter methods.
    
    protected void markBoatimageheightAsDirty(boolean aFlag)  { markFieldAsDirty(BOATIMAGEHEIGHT_DIRTYGROUP, BOATIMAGEHEIGHT_DIRTYMASK, aFlag); }


    public void setBoatimageheight(java.lang.Integer  p)
    {
        markBoatimageheightAsDirty(!equalsObject(boatimageheight, p));
    	boatimageheight = p;
    }
    public void setBoatimageheight(int p)
    {
    	setBoatimageheight(new java.lang.Integer(p));
    }
    public void setBoatimageheight()
    {
    	setBoatimageheight(0);
    }
    public void setBoatimageheight(String  p)
    {
    	setBoatimageheight(stringAsInteger(p));
    }

    // boatimagewidth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoatimagewidthDirty()  { return checkFieldDirtiness(BOATIMAGEWIDTH_DIRTYGROUP, BOATIMAGEWIDTH_DIRTYMASK); }

    public java.lang.Integer   getBoatimagewidth() { return boatimagewidth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "boatimagewidth")
    public String getBoatimagewidthAsString() { return integerAsString(boatimagewidth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getBoatimagewidthAsInt()    { return boatimagewidth != null ? boatimagewidth.intValue() : 0; }

    // boatimagewidth setter methods.
    
    protected void markBoatimagewidthAsDirty(boolean aFlag)  { markFieldAsDirty(BOATIMAGEWIDTH_DIRTYGROUP, BOATIMAGEWIDTH_DIRTYMASK, aFlag); }


    public void setBoatimagewidth(java.lang.Integer  p)
    {
        markBoatimagewidthAsDirty(!equalsObject(boatimagewidth, p));
    	boatimagewidth = p;
    }
    public void setBoatimagewidth(int p)
    {
    	setBoatimagewidth(new java.lang.Integer(p));
    }
    public void setBoatimagewidth()
    {
    	setBoatimagewidth(0);
    }
    public void setBoatimagewidth(String  p)
    {
    	setBoatimagewidth(stringAsInteger(p));
    }

    // boaticonurl getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoaticonurlDirty()  { return checkFieldDirtiness(BOATICONURL_DIRTYGROUP, BOATICONURL_DIRTYMASK); }

    public java.lang.String   getBoaticonurl()         { return boaticonurl; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "boaticonurl")
    public java.lang.String   getBoaticonurlAsString() { return (boaticonurl == null) ? "" : boaticonurl; }

    // boaticonurl setter methods.
    
    protected void markBoaticonurlAsDirty(boolean aFlag)  { markFieldAsDirty(BOATICONURL_DIRTYGROUP, BOATICONURL_DIRTYMASK, aFlag); }


    public void setBoaticonurl(String  p)
    {
       setBoaticonurl(p, DTOCasingStyle.none);
    }
    
    public void setBoaticonurl(String  p, DTOCasingStyle casingStyle)
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
       markBoaticonurlAsDirty(!equalsObject(boaticonurl, p));
       boaticonurl = p;
    }

    // boaticonwidth getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoaticonwidthDirty()  { return checkFieldDirtiness(BOATICONWIDTH_DIRTYGROUP, BOATICONWIDTH_DIRTYMASK); }

    public java.lang.Integer   getBoaticonwidth() { return boaticonwidth; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "boaticonwidth")
    public String getBoaticonwidthAsString() { return integerAsString(boaticonwidth); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getBoaticonwidthAsInt()    { return boaticonwidth != null ? boaticonwidth.intValue() : 0; }

    // boaticonwidth setter methods.
    
    protected void markBoaticonwidthAsDirty(boolean aFlag)  { markFieldAsDirty(BOATICONWIDTH_DIRTYGROUP, BOATICONWIDTH_DIRTYMASK, aFlag); }


    public void setBoaticonwidth(java.lang.Integer  p)
    {
        markBoaticonwidthAsDirty(!equalsObject(boaticonwidth, p));
    	boaticonwidth = p;
    }
    public void setBoaticonwidth(int p)
    {
    	setBoaticonwidth(new java.lang.Integer(p));
    }
    public void setBoaticonwidth()
    {
    	setBoaticonwidth(0);
    }
    public void setBoaticonwidth(String  p)
    {
    	setBoaticonwidth(stringAsInteger(p));
    }

    // boaticonheight getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isBoaticonheightDirty()  { return checkFieldDirtiness(BOATICONHEIGHT_DIRTYGROUP, BOATICONHEIGHT_DIRTYMASK); }

    public java.lang.Integer   getBoaticonheight() { return boaticonheight; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "boaticonheight")
    public String getBoaticonheightAsString() { return integerAsString(boaticonheight); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getBoaticonheightAsInt()    { return boaticonheight != null ? boaticonheight.intValue() : 0; }

    // boaticonheight setter methods.
    
    protected void markBoaticonheightAsDirty(boolean aFlag)  { markFieldAsDirty(BOATICONHEIGHT_DIRTYGROUP, BOATICONHEIGHT_DIRTYMASK, aFlag); }


    public void setBoaticonheight(java.lang.Integer  p)
    {
        markBoaticonheightAsDirty(!equalsObject(boaticonheight, p));
    	boaticonheight = p;
    }
    public void setBoaticonheight(int p)
    {
    	setBoaticonheight(new java.lang.Integer(p));
    }
    public void setBoaticonheight()
    {
    	setBoaticonheight(0);
    }
    public void setBoaticonheight(String  p)
    {
    	setBoaticonheight(stringAsInteger(p));
    }

    // addtohomeentrylist getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAddtohomeentrylistDirty()  { return checkFieldDirtiness(ADDTOHOMEENTRYLIST_DIRTYGROUP, ADDTOHOMEENTRYLIST_DIRTYMASK); }

    public java.lang.String   getAddtohomeentrylist()         { return addtohomeentrylist; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "addtohomeentrylist")
    public java.lang.String   getAddtohomeentrylistAsString() { return (addtohomeentrylist == null) ? "" : addtohomeentrylist; }

    // addtohomeentrylist setter methods.
    
    protected void markAddtohomeentrylistAsDirty(boolean aFlag)  { markFieldAsDirty(ADDTOHOMEENTRYLIST_DIRTYGROUP, ADDTOHOMEENTRYLIST_DIRTYMASK, aFlag); }


    public void setAddtohomeentrylist(String  p)
    {
       setAddtohomeentrylist(p, DTOCasingStyle.none);
    }
    
    public void setAddtohomeentrylist(String  p, DTOCasingStyle casingStyle)
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
       markAddtohomeentrylistAsDirty(!equalsObject(addtohomeentrylist, p));
       addtohomeentrylist = p;
    }

    // createtimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCreatetimestampDirty()  { return checkFieldDirtiness(CREATETIMESTAMP_DIRTYGROUP, CREATETIMESTAMP_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getCreatetimestamp() { return createtimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "createtimestamp")
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

    // committimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCommittimestampDirty()  { return checkFieldDirtiness(COMMITTIMESTAMP_DIRTYGROUP, COMMITTIMESTAMP_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getCommittimestamp() { return committimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "committimestamp")
    public String getCommittimestampAsString() { return timestampAsString(committimestamp, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCommittimestampAsString(java.text.DateFormat aDateFormat) { return timestampAsString(committimestamp, aDateFormat); }

    // committimestamp setter methods.
    
    protected void markCommittimestampAsDirty(boolean aFlag)  { markFieldAsDirty(COMMITTIMESTAMP_DIRTYGROUP, COMMITTIMESTAMP_DIRTYMASK, aFlag); }


    public void setCommittimestamp(java.sql.Timestamp  p)
    {
        markCommittimestampAsDirty(!equalsObject(committimestamp, p));
    	committimestamp = p;
    }
    public void setCommittimestamp(String  p, java.text.DateFormat aDateFormat)
    {
    	setCommittimestamp(stringAsTimestamp(p, aDateFormat));
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
