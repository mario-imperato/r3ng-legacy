//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.otp;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "OTPDTOBase")
public class OTPDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  digest;
    protected java.sql.Timestamp  expirytime;
    protected java.lang.String  userid;

    public static final java.lang.String DIGEST_DEFAULT  =  null;
    public static final java.sql.Timestamp EXPIRYTIME_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;

    public static final int DIGEST_DIRTYGROUP  =  0;
    public static final int DIGEST_DIRTYMASK   =  1;
    public static final int EXPIRYTIME_DIRTYGROUP  =  0;
    public static final int EXPIRYTIME_DIRTYMASK   =  2;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  4;


    /**
      * DataBean constructor.
      */
    public OTPDTOBase()
    {
       dirtyFlagsArray = new int[3 / 30 + 1];
       clearDirtyFlags();

       digest = DIGEST_DEFAULT;
       expirytime = EXPIRYTIME_DEFAULT;
       userid = USERID_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public OTPDTOBase(OTPDTOBase another)
    {

       digest = another.getDigest();
       expirytime = another.getExpirytime();
       userid = another.getUserid();

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
        stb.append(digest);
        return stb.toString();
    }


    /**
      * DataBean Getter And Setter Accessor
      */

    // digest getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isDigestDirty()  { return checkFieldDirtiness(DIGEST_DIRTYGROUP, DIGEST_DIRTYMASK); }

    public java.lang.String   getDigest()         { return digest; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getDigestAsString() { return (digest == null) ? "" : digest; }

    // digest setter methods.
    
    protected void markDigestAsDirty(boolean aFlag)  { markFieldAsDirty(DIGEST_DIRTYGROUP, DIGEST_DIRTYMASK, aFlag); }


    public void setDigest(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markDigestAsDirty(!equalsObject(digest, p));
         digest = p;
    }

    // expirytime getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isExpirytimeDirty()  { return checkFieldDirtiness(EXPIRYTIME_DIRTYGROUP, EXPIRYTIME_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getExpirytime() { return expirytime; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getExpirytimeAsString() { return timestampAsString(expirytime, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getExpirytimeAsString(java.text.DateFormat aDateFormat) { return timestampAsString(expirytime, aDateFormat); }

    // expirytime setter methods.
    
    protected void markExpirytimeAsDirty(boolean aFlag)  { markFieldAsDirty(EXPIRYTIME_DIRTYGROUP, EXPIRYTIME_DIRTYMASK, aFlag); }


    public void setExpirytime(java.sql.Timestamp  p)
    {
        markExpirytimeAsDirty(!equalsObject(expirytime, p));
    	expirytime = p;
    }
    public void setExpirytime(String  p, java.text.DateFormat aDateFormat)
    {
    	setExpirytime(stringAsTimestamp(p, aDateFormat));
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
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markUseridAsDirty(!equalsObject(userid, p));
         userid = p;
    }

}
