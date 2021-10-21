//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.appcrewmember;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "SailApplicationCrewMemberDTOBase")
public class SailApplicationCrewMemberDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  crewmemberid;
    protected java.lang.String  eventid;
    protected java.lang.String  applicationid;
    protected java.lang.String  cardnumber;
    protected java.lang.String  crewmembername;
    protected java.lang.Float  weight;
    protected java.lang.String  crewmemberrolecode;
    protected java.lang.String  memberstatuscode;
    protected java.sql.Timestamp  createtimestamp;
    protected java.sql.Timestamp  deletetimestamp;
    protected java.lang.String  checkcardnumber;
    protected java.sql.Timestamp  checkcardnumber_ts;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String CREWMEMBERID_DEFAULT  =  null;
    public static final java.lang.String EVENTID_DEFAULT  =  null;
    public static final java.lang.String APPLICATIONID_DEFAULT  =  null;
    public static final java.lang.String CARDNUMBER_DEFAULT  =  null;
    public static final java.lang.String CREWMEMBERNAME_DEFAULT  =  null;
    public static final java.lang.Float WEIGHT_DEFAULT  =  null;
    public static final java.lang.String CREWMEMBERROLECODE_DEFAULT  =  null;
    public static final java.lang.String MEMBERSTATUSCODE_DEFAULT  =  null;
    public static final java.sql.Timestamp CREATETIMESTAMP_DEFAULT  =  null;
    public static final java.sql.Timestamp DELETETIMESTAMP_DEFAULT  =  null;
    public static final java.lang.String CHECKCARDNUMBER_DEFAULT  =  null;
    public static final java.sql.Timestamp CHECKCARDNUMBER_TS_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int CREWMEMBERID_DIRTYGROUP  =  0;
    public static final int CREWMEMBERID_DIRTYMASK   =  1;
    public static final int EVENTID_DIRTYGROUP  =  0;
    public static final int EVENTID_DIRTYMASK   =  2;
    public static final int APPLICATIONID_DIRTYGROUP  =  0;
    public static final int APPLICATIONID_DIRTYMASK   =  4;
    public static final int CARDNUMBER_DIRTYGROUP  =  0;
    public static final int CARDNUMBER_DIRTYMASK   =  8;
    public static final int CREWMEMBERNAME_DIRTYGROUP  =  0;
    public static final int CREWMEMBERNAME_DIRTYMASK   =  16;
    public static final int WEIGHT_DIRTYGROUP  =  0;
    public static final int WEIGHT_DIRTYMASK   =  32;
    public static final int CREWMEMBERROLECODE_DIRTYGROUP  =  0;
    public static final int CREWMEMBERROLECODE_DIRTYMASK   =  64;
    public static final int MEMBERSTATUSCODE_DIRTYGROUP  =  0;
    public static final int MEMBERSTATUSCODE_DIRTYMASK   =  128;
    public static final int CREATETIMESTAMP_DIRTYGROUP  =  0;
    public static final int CREATETIMESTAMP_DIRTYMASK   =  256;
    public static final int DELETETIMESTAMP_DIRTYGROUP  =  0;
    public static final int DELETETIMESTAMP_DIRTYMASK   =  512;
    public static final int CHECKCARDNUMBER_DIRTYGROUP  =  0;
    public static final int CHECKCARDNUMBER_DIRTYMASK   =  1024;
    public static final int CHECKCARDNUMBER_TS_DIRTYGROUP  =  0;
    public static final int CHECKCARDNUMBER_TS_DIRTYMASK   =  2048;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  4096;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  8192;


    /**
      * DataBean constructor.
      */
    public SailApplicationCrewMemberDTOBase()
    {
       dirtyFlagsArray = new int[14 / 30 + 1];
       clearDirtyFlags();

       crewmemberid = CREWMEMBERID_DEFAULT;
       eventid = EVENTID_DEFAULT;
       applicationid = APPLICATIONID_DEFAULT;
       cardnumber = CARDNUMBER_DEFAULT;
       crewmembername = CREWMEMBERNAME_DEFAULT;
       weight = WEIGHT_DEFAULT;
       crewmemberrolecode = CREWMEMBERROLECODE_DEFAULT;
       memberstatuscode = MEMBERSTATUSCODE_DEFAULT;
       createtimestamp = CREATETIMESTAMP_DEFAULT;
       deletetimestamp = DELETETIMESTAMP_DEFAULT;
       checkcardnumber = CHECKCARDNUMBER_DEFAULT;
       checkcardnumber_ts = CHECKCARDNUMBER_TS_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public SailApplicationCrewMemberDTOBase(SailApplicationCrewMemberDTOBase another)
    {

       crewmemberid = another.getCrewmemberid();
       eventid = another.getEventid();
       applicationid = another.getApplicationid();
       cardnumber = another.getCardnumber();
       crewmembername = another.getCrewmembername();
       weight = another.getWeight();
       crewmemberrolecode = another.getCrewmemberrolecode();
       memberstatuscode = another.getMemberstatuscode();
       createtimestamp = another.getCreatetimestamp();
       deletetimestamp = another.getDeletetimestamp();
       checkcardnumber = another.getCheckcardnumber();
       checkcardnumber_ts = another.getCheckcardnumber_ts();
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
        stb.append(crewmemberid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (cardnumber != null)
        {
        stb.append(cardnumber);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

    // crewmemberid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCrewmemberidDirty()  { return checkFieldDirtiness(CREWMEMBERID_DIRTYGROUP, CREWMEMBERID_DIRTYMASK); }

    public java.lang.String   getCrewmemberid()         { return crewmemberid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCrewmemberidAsString() { return (crewmemberid == null) ? "" : crewmemberid; }

    // crewmemberid setter methods.
    
    protected void markCrewmemberidAsDirty(boolean aFlag)  { markFieldAsDirty(CREWMEMBERID_DIRTYGROUP, CREWMEMBERID_DIRTYMASK, aFlag); }


    public void setCrewmemberid(String  p)
    {
       setCrewmemberid(p, DTOCasingStyle.none);
    }
    
    public void setCrewmemberid(String  p, DTOCasingStyle casingStyle)
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
       markCrewmemberidAsDirty(!equalsObject(crewmemberid, p));
       crewmemberid = p;
    }

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

    // crewmembername getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCrewmembernameDirty()  { return checkFieldDirtiness(CREWMEMBERNAME_DIRTYGROUP, CREWMEMBERNAME_DIRTYMASK); }

    public java.lang.String   getCrewmembername()         { return crewmembername; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCrewmembernameAsString() { return (crewmembername == null) ? "" : crewmembername; }

    // crewmembername setter methods.
    
    protected void markCrewmembernameAsDirty(boolean aFlag)  { markFieldAsDirty(CREWMEMBERNAME_DIRTYGROUP, CREWMEMBERNAME_DIRTYMASK, aFlag); }


    public void setCrewmembername(String  p)
    {
       setCrewmembername(p, DTOCasingStyle.none);
    }
    
    public void setCrewmembername(String  p, DTOCasingStyle casingStyle)
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
       markCrewmembernameAsDirty(!equalsObject(crewmembername, p));
       crewmembername = p;
    }

    // weight getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isWeightDirty()  { return checkFieldDirtiness(WEIGHT_DIRTYGROUP, WEIGHT_DIRTYMASK); }

    public java.lang.Float   getWeight() { return weight; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getWeightAsString() { return floatAsString(weight); }

    // weight setter methods.
    
    protected void markWeightAsDirty(boolean aFlag)  { markFieldAsDirty(WEIGHT_DIRTYGROUP, WEIGHT_DIRTYMASK, aFlag); }


    public void setWeight(java.lang.Float  p)
    {
    	markWeightAsDirty(!equalsObject(weight, p));
    	weight = p;
    }
    public void setWeight()
    {
    	setWeight((java.lang.Float)null);
    }
    public void setWeight(String  p)
    {
    	setWeight(stringAsFloat(p));
    }

    // crewmemberrolecode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCrewmemberrolecodeDirty()  { return checkFieldDirtiness(CREWMEMBERROLECODE_DIRTYGROUP, CREWMEMBERROLECODE_DIRTYMASK); }

    public java.lang.String   getCrewmemberrolecode()         { return crewmemberrolecode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCrewmemberrolecodeAsString() { return (crewmemberrolecode == null) ? "" : crewmemberrolecode; }

    // crewmemberrolecode setter methods.
    
    protected void markCrewmemberrolecodeAsDirty(boolean aFlag)  { markFieldAsDirty(CREWMEMBERROLECODE_DIRTYGROUP, CREWMEMBERROLECODE_DIRTYMASK, aFlag); }


    public void setCrewmemberrolecode(String  p)
    {
       setCrewmemberrolecode(p, DTOCasingStyle.none);
    }
    
    public void setCrewmemberrolecode(String  p, DTOCasingStyle casingStyle)
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
       markCrewmemberrolecodeAsDirty(!equalsObject(crewmemberrolecode, p));
       crewmemberrolecode = p;
    }

    // memberstatuscode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isMemberstatuscodeDirty()  { return checkFieldDirtiness(MEMBERSTATUSCODE_DIRTYGROUP, MEMBERSTATUSCODE_DIRTYMASK); }

    public java.lang.String   getMemberstatuscode()         { return memberstatuscode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getMemberstatuscodeAsString() { return (memberstatuscode == null) ? "" : memberstatuscode; }

    // memberstatuscode setter methods.
    
    protected void markMemberstatuscodeAsDirty(boolean aFlag)  { markFieldAsDirty(MEMBERSTATUSCODE_DIRTYGROUP, MEMBERSTATUSCODE_DIRTYMASK, aFlag); }


    public void setMemberstatuscode(String  p)
    {
       setMemberstatuscode(p, DTOCasingStyle.none);
    }
    
    public void setMemberstatuscode(String  p, DTOCasingStyle casingStyle)
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
       markMemberstatuscodeAsDirty(!equalsObject(memberstatuscode, p));
       memberstatuscode = p;
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

    // deletetimestamp getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDeletetimestampDirty()  { return checkFieldDirtiness(DELETETIMESTAMP_DIRTYGROUP, DELETETIMESTAMP_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getDeletetimestamp() { return deletetimestamp; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getDeletetimestampAsString() { return timestampAsString(deletetimestamp, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getDeletetimestampAsString(java.text.DateFormat aDateFormat) { return timestampAsString(deletetimestamp, aDateFormat); }

    // deletetimestamp setter methods.
    
    protected void markDeletetimestampAsDirty(boolean aFlag)  { markFieldAsDirty(DELETETIMESTAMP_DIRTYGROUP, DELETETIMESTAMP_DIRTYMASK, aFlag); }


    public void setDeletetimestamp(java.sql.Timestamp  p)
    {
        markDeletetimestampAsDirty(!equalsObject(deletetimestamp, p));
    	deletetimestamp = p;
    }
    public void setDeletetimestamp(String  p, java.text.DateFormat aDateFormat)
    {
    	setDeletetimestamp(stringAsTimestamp(p, aDateFormat));
    }

    // checkcardnumber getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCheckcardnumberDirty()  { return checkFieldDirtiness(CHECKCARDNUMBER_DIRTYGROUP, CHECKCARDNUMBER_DIRTYMASK); }

    public java.lang.String   getCheckcardnumber()         { return checkcardnumber; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getCheckcardnumberAsString() { return (checkcardnumber == null) ? "" : checkcardnumber; }

    // checkcardnumber setter methods.
    
    protected void markCheckcardnumberAsDirty(boolean aFlag)  { markFieldAsDirty(CHECKCARDNUMBER_DIRTYGROUP, CHECKCARDNUMBER_DIRTYMASK, aFlag); }


    public void setCheckcardnumber(String  p)
    {
       setCheckcardnumber(p, DTOCasingStyle.none);
    }
    
    public void setCheckcardnumber(String  p, DTOCasingStyle casingStyle)
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
       markCheckcardnumberAsDirty(!equalsObject(checkcardnumber, p));
       checkcardnumber = p;
    }

    // checkcardnumber_ts getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCheckcardnumber_tsDirty()  { return checkFieldDirtiness(CHECKCARDNUMBER_TS_DIRTYGROUP, CHECKCARDNUMBER_TS_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getCheckcardnumber_ts() { return checkcardnumber_ts; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCheckcardnumber_tsAsString() { return timestampAsString(checkcardnumber_ts, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getCheckcardnumber_tsAsString(java.text.DateFormat aDateFormat) { return timestampAsString(checkcardnumber_ts, aDateFormat); }

    // checkcardnumber_ts setter methods.
    
    protected void markCheckcardnumber_tsAsDirty(boolean aFlag)  { markFieldAsDirty(CHECKCARDNUMBER_TS_DIRTYGROUP, CHECKCARDNUMBER_TS_DIRTYMASK, aFlag); }


    public void setCheckcardnumber_ts(java.sql.Timestamp  p)
    {
        markCheckcardnumber_tsAsDirty(!equalsObject(checkcardnumber_ts, p));
    	checkcardnumber_ts = p;
    }
    public void setCheckcardnumber_ts(String  p, java.text.DateFormat aDateFormat)
    {
    	setCheckcardnumber_ts(stringAsTimestamp(p, aDateFormat));
    }

    // recstatus getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRecstatusDirty()  { return checkFieldDirtiness(RECSTATUS_DIRTYGROUP, RECSTATUS_DIRTYMASK); }

    public java.lang.String   getRecstatus()         { return recstatus; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
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
