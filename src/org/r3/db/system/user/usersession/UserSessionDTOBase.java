//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.usersession;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "UserSessionDTOBase")
public class UserSessionDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  sessionid;
    protected java.lang.String  userid;
    protected java.lang.String  ipaddress;
    protected java.lang.String  consentmode;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String SESSIONID_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String IPADDRESS_DEFAULT  =  null;
    public static final java.lang.String CONSENTMODE_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int SESSIONID_DIRTYGROUP  =  0;
    public static final int SESSIONID_DIRTYMASK   =  1;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  2;
    public static final int IPADDRESS_DIRTYGROUP  =  0;
    public static final int IPADDRESS_DIRTYMASK   =  4;
    public static final int CONSENTMODE_DIRTYGROUP  =  0;
    public static final int CONSENTMODE_DIRTYMASK   =  8;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  16;


    /**
      * DataBean constructor.
      */
    public UserSessionDTOBase()
    {
       dirtyFlagsArray = new int[5 / 30 + 1];
       clearDirtyFlags();

       sessionid = SESSIONID_DEFAULT;
       userid = USERID_DEFAULT;
       ipaddress = IPADDRESS_DEFAULT;
       consentmode = CONSENTMODE_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public UserSessionDTOBase(UserSessionDTOBase another)
    {

       sessionid = another.getSessionid();
       userid = another.getUserid();
       ipaddress = another.getIpaddress();
       consentmode = another.getConsentmode();
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
        stb.append(sessionid);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // sessionid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSessionidDirty()  { return checkFieldDirtiness(SESSIONID_DIRTYGROUP, SESSIONID_DIRTYMASK); }

    public java.lang.String   getSessionid()         { return sessionid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "sessionid")
    public java.lang.String   getSessionidAsString() { return (sessionid == null) ? "" : sessionid; }

    // sessionid setter methods.
    
    protected void markSessionidAsDirty(boolean aFlag)  { markFieldAsDirty(SESSIONID_DIRTYGROUP, SESSIONID_DIRTYMASK, aFlag); }


    public void setSessionid(String  p)
    {
       setSessionid(p, DTOCasingStyle.none);
    }
    
    public void setSessionid(String  p, DTOCasingStyle casingStyle)
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
       markSessionidAsDirty(!equalsObject(sessionid, p));
       sessionid = p;
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

    // ipaddress getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isIpaddressDirty()  { return checkFieldDirtiness(IPADDRESS_DIRTYGROUP, IPADDRESS_DIRTYMASK); }

    public java.lang.String   getIpaddress()         { return ipaddress; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "ipaddress")
    public java.lang.String   getIpaddressAsString() { return (ipaddress == null) ? "" : ipaddress; }

    // ipaddress setter methods.
    
    protected void markIpaddressAsDirty(boolean aFlag)  { markFieldAsDirty(IPADDRESS_DIRTYGROUP, IPADDRESS_DIRTYMASK, aFlag); }


    public void setIpaddress(String  p)
    {
       setIpaddress(p, DTOCasingStyle.none);
    }
    
    public void setIpaddress(String  p, DTOCasingStyle casingStyle)
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
       markIpaddressAsDirty(!equalsObject(ipaddress, p));
       ipaddress = p;
    }

    // consentmode getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isConsentmodeDirty()  { return checkFieldDirtiness(CONSENTMODE_DIRTYGROUP, CONSENTMODE_DIRTYMASK); }

    public java.lang.String   getConsentmode()         { return consentmode; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "consentmode")
    public java.lang.String   getConsentmodeAsString() { return (consentmode == null) ? "" : consentmode; }

    // consentmode setter methods.
    
    protected void markConsentmodeAsDirty(boolean aFlag)  { markFieldAsDirty(CONSENTMODE_DIRTYGROUP, CONSENTMODE_DIRTYMASK, aFlag); }


    public void setConsentmode(String  p)
    {
       setConsentmode(p, DTOCasingStyle.none);
    }
    
    public void setConsentmode(String  p, DTOCasingStyle casingStyle)
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
       markConsentmodeAsDirty(!equalsObject(consentmode, p));
       consentmode = p;
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
