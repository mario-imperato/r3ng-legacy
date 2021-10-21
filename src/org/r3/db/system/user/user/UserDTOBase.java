//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.user;

import org.r3.db.utils.CSVAnnotation;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "UserDTOBase")
public class UserDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  userid;
    protected java.lang.String  nickname;
    protected java.lang.String  password;
    protected java.lang.String  firstname;
    protected java.lang.String  lastname;
    protected java.lang.String  companyid;
    protected java.lang.String  email;
    protected java.lang.String  usertype;
    protected java.lang.String  avatarrole;
    protected java.lang.String  parentuserid;
    protected java.lang.String  userphoto;
    protected java.sql.Timestamp  lastlogin;
    protected java.lang.Integer  numberoflogins;
    protected java.lang.String  userconsent;
    protected java.lang.String  fbuserid;
    protected java.lang.String  recstatus;
    protected java.sql.Timestamp  rectimestamp;

    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String NICKNAME_DEFAULT  =  null;
    public static final java.lang.String PASSWORD_DEFAULT  =  null;
    public static final java.lang.String FIRSTNAME_DEFAULT  =  null;
    public static final java.lang.String LASTNAME_DEFAULT  =  null;
    public static final java.lang.String COMPANYID_DEFAULT  =  null;
    public static final java.lang.String EMAIL_DEFAULT  =  null;
    public static final java.lang.String USERTYPE_DEFAULT  =  null;
    public static final java.lang.String AVATARROLE_DEFAULT  =  null;
    public static final java.lang.String PARENTUSERID_DEFAULT  =  null;
    public static final java.lang.String USERPHOTO_DEFAULT  =  null;
    public static final java.sql.Timestamp LASTLOGIN_DEFAULT  =  null;
    public static final java.lang.Integer NUMBEROFLOGINS_DEFAULT  =  null;
    public static final java.lang.String USERCONSENT_DEFAULT  =  null;
    public static final java.lang.String FBUSERID_DEFAULT  =  null;
    public static final java.lang.String RECSTATUS_DEFAULT  =  null;
    public static final java.sql.Timestamp RECTIMESTAMP_DEFAULT  =  null;

    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  1;
    public static final int NICKNAME_DIRTYGROUP  =  0;
    public static final int NICKNAME_DIRTYMASK   =  2;
    public static final int PASSWORD_DIRTYGROUP  =  0;
    public static final int PASSWORD_DIRTYMASK   =  4;
    public static final int FIRSTNAME_DIRTYGROUP  =  0;
    public static final int FIRSTNAME_DIRTYMASK   =  8;
    public static final int LASTNAME_DIRTYGROUP  =  0;
    public static final int LASTNAME_DIRTYMASK   =  16;
    public static final int COMPANYID_DIRTYGROUP  =  0;
    public static final int COMPANYID_DIRTYMASK   =  32;
    public static final int EMAIL_DIRTYGROUP  =  0;
    public static final int EMAIL_DIRTYMASK   =  64;
    public static final int USERTYPE_DIRTYGROUP  =  0;
    public static final int USERTYPE_DIRTYMASK   =  128;
    public static final int AVATARROLE_DIRTYGROUP  =  0;
    public static final int AVATARROLE_DIRTYMASK   =  256;
    public static final int PARENTUSERID_DIRTYGROUP  =  0;
    public static final int PARENTUSERID_DIRTYMASK   =  512;
    public static final int USERPHOTO_DIRTYGROUP  =  0;
    public static final int USERPHOTO_DIRTYMASK   =  1024;
    public static final int LASTLOGIN_DIRTYGROUP  =  0;
    public static final int LASTLOGIN_DIRTYMASK   =  2048;
    public static final int NUMBEROFLOGINS_DIRTYGROUP  =  0;
    public static final int NUMBEROFLOGINS_DIRTYMASK   =  4096;
    public static final int USERCONSENT_DIRTYGROUP  =  0;
    public static final int USERCONSENT_DIRTYMASK   =  8192;
    public static final int FBUSERID_DIRTYGROUP  =  0;
    public static final int FBUSERID_DIRTYMASK   =  16384;
    public static final int RECSTATUS_DIRTYGROUP  =  0;
    public static final int RECSTATUS_DIRTYMASK   =  32768;
    public static final int RECTIMESTAMP_DIRTYGROUP  =  0;
    public static final int RECTIMESTAMP_DIRTYMASK   =  65536;


    /**
      * DataBean constructor.
      */
    public UserDTOBase()
    {
       dirtyFlagsArray = new int[17 / 30 + 1];
       clearDirtyFlags();

       userid = USERID_DEFAULT;
       nickname = NICKNAME_DEFAULT;
       password = PASSWORD_DEFAULT;
       firstname = FIRSTNAME_DEFAULT;
       lastname = LASTNAME_DEFAULT;
       companyid = COMPANYID_DEFAULT;
       email = EMAIL_DEFAULT;
       usertype = USERTYPE_DEFAULT;
       avatarrole = AVATARROLE_DEFAULT;
       parentuserid = PARENTUSERID_DEFAULT;
       userphoto = USERPHOTO_DEFAULT;
       lastlogin = LASTLOGIN_DEFAULT;
       numberoflogins = NUMBEROFLOGINS_DEFAULT;
       userconsent = USERCONSENT_DEFAULT;
       fbuserid = FBUSERID_DEFAULT;
       recstatus = RECSTATUS_DEFAULT;
       rectimestamp = RECTIMESTAMP_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public UserDTOBase(UserDTOBase another)
    {

       userid = another.getUserid();
       nickname = another.getNickname();
       password = another.getPassword();
       firstname = another.getFirstname();
       lastname = another.getLastname();
       companyid = another.getCompanyid();
       email = another.getEmail();
       usertype = another.getUsertype();
       avatarrole = another.getAvatarrole();
       parentuserid = another.getParentuserid();
       userphoto = another.getUserphoto();
       lastlogin = another.getLastlogin();
       numberoflogins = another.getNumberoflogins();
       userconsent = another.getUserconsent();
       fbuserid = another.getFbuserid();
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
        stb.append(userid);
        return stb.toString();
    }

    public String getDtodescr()
    {
        boolean notNull = false;
        StringBuilder stb = new StringBuilder();
        if (nickname != null)
        {
        stb.append(nickname);
        notNull = true;        
        }
        if (notNull)
            return stb.toString();
            
        return null;
    }

    /**
      * DataBean Getter And Setter Accessor
      */

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

    // nickname getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNicknameDirty()  { return checkFieldDirtiness(NICKNAME_DIRTYGROUP, NICKNAME_DIRTYMASK); }

    public java.lang.String   getNickname()         { return nickname; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "nickname")
    public java.lang.String   getNicknameAsString() { return (nickname == null) ? "" : nickname; }

    // nickname setter methods.
    
    protected void markNicknameAsDirty(boolean aFlag)  { markFieldAsDirty(NICKNAME_DIRTYGROUP, NICKNAME_DIRTYMASK, aFlag); }


    public void setNickname(String  p)
    {
       setNickname(p, DTOCasingStyle.none);
    }
    
    public void setNickname(String  p, DTOCasingStyle casingStyle)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
    	 	else switch(casingStyle) 
    	 	{
    	 	   case none: 
              p = p.toLowerCase();
    	 	   break;
    	 	   case uppercase:
    	 	      p = p.toUpperCase();
    	 	   break;
    	 	   case lowercase:
    	 	      p = p.toLowerCase();
    	 	   break;
    	 	}

       }
       markNicknameAsDirty(!equalsObject(nickname, p));
       nickname = p;
    }

    // password getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isPasswordDirty()  { return checkFieldDirtiness(PASSWORD_DIRTYGROUP, PASSWORD_DIRTYMASK); }

    public java.lang.String   getPassword()         { return password; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "password")
    public java.lang.String   getPasswordAsString() { return (password == null) ? "" : password; }

    // password setter methods.
    
    protected void markPasswordAsDirty(boolean aFlag)  { markFieldAsDirty(PASSWORD_DIRTYGROUP, PASSWORD_DIRTYMASK, aFlag); }


    public void setPassword(String  p)
    {
       setPassword(p, DTOCasingStyle.none);
    }
    
    public void setPassword(String  p, DTOCasingStyle casingStyle)
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
       markPasswordAsDirty(!equalsObject(password, p));
       password = p;
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
       markLastnameAsDirty(!equalsObject(lastname, p));
       lastname = p;
    }

    // companyid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isCompanyidDirty()  { return checkFieldDirtiness(COMPANYID_DIRTYGROUP, COMPANYID_DIRTYMASK); }

    public java.lang.String   getCompanyid()         { return companyid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "companyid")
    public java.lang.String   getCompanyidAsString() { return (companyid == null) ? "" : companyid; }

    // companyid setter methods.
    
    protected void markCompanyidAsDirty(boolean aFlag)  { markFieldAsDirty(COMPANYID_DIRTYGROUP, COMPANYID_DIRTYMASK, aFlag); }


    public void setCompanyid(String  p)
    {
       setCompanyid(p, DTOCasingStyle.none);
    }
    
    public void setCompanyid(String  p, DTOCasingStyle casingStyle)
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
       markCompanyidAsDirty(!equalsObject(companyid, p));
       companyid = p;
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

    // usertype getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUsertypeDirty()  { return checkFieldDirtiness(USERTYPE_DIRTYGROUP, USERTYPE_DIRTYMASK); }

    public java.lang.String   getUsertype()         { return usertype; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "usertype")
    public java.lang.String   getUsertypeAsString() { return (usertype == null) ? "" : usertype; }

    // usertype setter methods.
    
    protected void markUsertypeAsDirty(boolean aFlag)  { markFieldAsDirty(USERTYPE_DIRTYGROUP, USERTYPE_DIRTYMASK, aFlag); }


    public void setUsertype(String  p)
    {
       setUsertype(p, DTOCasingStyle.none);
    }
    
    public void setUsertype(String  p, DTOCasingStyle casingStyle)
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
       markUsertypeAsDirty(!equalsObject(usertype, p));
       usertype = p;
    }

    // avatarrole getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isAvatarroleDirty()  { return checkFieldDirtiness(AVATARROLE_DIRTYGROUP, AVATARROLE_DIRTYMASK); }

    public java.lang.String   getAvatarrole()         { return avatarrole; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "avatarrole")
    public java.lang.String   getAvatarroleAsString() { return (avatarrole == null) ? "" : avatarrole; }

    // avatarrole setter methods.
    
    protected void markAvatarroleAsDirty(boolean aFlag)  { markFieldAsDirty(AVATARROLE_DIRTYGROUP, AVATARROLE_DIRTYMASK, aFlag); }


    public void setAvatarrole(String  p)
    {
       setAvatarrole(p, DTOCasingStyle.none);
    }
    
    public void setAvatarrole(String  p, DTOCasingStyle casingStyle)
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
       markAvatarroleAsDirty(!equalsObject(avatarrole, p));
       avatarrole = p;
    }

    // parentuserid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isParentuseridDirty()  { return checkFieldDirtiness(PARENTUSERID_DIRTYGROUP, PARENTUSERID_DIRTYMASK); }

    public java.lang.String   getParentuserid()         { return parentuserid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "parentuserid")
    public java.lang.String   getParentuseridAsString() { return (parentuserid == null) ? "" : parentuserid; }

    // parentuserid setter methods.
    
    protected void markParentuseridAsDirty(boolean aFlag)  { markFieldAsDirty(PARENTUSERID_DIRTYGROUP, PARENTUSERID_DIRTYMASK, aFlag); }


    public void setParentuserid(String  p)
    {
       setParentuserid(p, DTOCasingStyle.none);
    }
    
    public void setParentuserid(String  p, DTOCasingStyle casingStyle)
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
       markParentuseridAsDirty(!equalsObject(parentuserid, p));
       parentuserid = p;
    }

    // userphoto getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUserphotoDirty()  { return checkFieldDirtiness(USERPHOTO_DIRTYGROUP, USERPHOTO_DIRTYMASK); }

    public java.lang.String   getUserphoto()         { return userphoto; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "userphoto")
    public java.lang.String   getUserphotoAsString() { return (userphoto == null) ? "" : userphoto; }

    // userphoto setter methods.
    
    protected void markUserphotoAsDirty(boolean aFlag)  { markFieldAsDirty(USERPHOTO_DIRTYGROUP, USERPHOTO_DIRTYMASK, aFlag); }


    public void setUserphoto(String  p)
    {
       setUserphoto(p, DTOCasingStyle.none);
    }
    
    public void setUserphoto(String  p, DTOCasingStyle casingStyle)
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
       markUserphotoAsDirty(!equalsObject(userphoto, p));
       userphoto = p;
    }

    // lastlogin getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isLastloginDirty()  { return checkFieldDirtiness(LASTLOGIN_DIRTYGROUP, LASTLOGIN_DIRTYMASK); }

    // @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.r3.db.utils.SQLTimestampJAXBAdapter.class)
    public java.sql.Timestamp   getLastlogin() { return lastlogin; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "lastlogin")
    public String getLastloginAsString() { return timestampAsString(lastlogin, getTimestampFormat()); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public String getLastloginAsString(java.text.DateFormat aDateFormat) { return timestampAsString(lastlogin, aDateFormat); }

    // lastlogin setter methods.
    
    protected void markLastloginAsDirty(boolean aFlag)  { markFieldAsDirty(LASTLOGIN_DIRTYGROUP, LASTLOGIN_DIRTYMASK, aFlag); }


    public void setLastlogin(java.sql.Timestamp  p)
    {
        markLastloginAsDirty(!equalsObject(lastlogin, p));
    	lastlogin = p;
    }
    public void setLastlogin(String  p, java.text.DateFormat aDateFormat)
    {
    	setLastlogin(stringAsTimestamp(p, aDateFormat));
    }

    // numberoflogins getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isNumberofloginsDirty()  { return checkFieldDirtiness(NUMBEROFLOGINS_DIRTYGROUP, NUMBEROFLOGINS_DIRTYMASK); }

    public java.lang.Integer   getNumberoflogins() { return numberoflogins; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "numberoflogins")
    public String getNumberofloginsAsString() { return integerAsString(numberoflogins); }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public int    getNumberofloginsAsInt()    { return numberoflogins != null ? numberoflogins.intValue() : 0; }

    // numberoflogins setter methods.
    
    protected void markNumberofloginsAsDirty(boolean aFlag)  { markFieldAsDirty(NUMBEROFLOGINS_DIRTYGROUP, NUMBEROFLOGINS_DIRTYMASK, aFlag); }


    public void setNumberoflogins(java.lang.Integer  p)
    {
        markNumberofloginsAsDirty(!equalsObject(numberoflogins, p));
    	numberoflogins = p;
    }
    public void setNumberoflogins(int p)
    {
    	setNumberoflogins(new java.lang.Integer(p));
    }
    public void setNumberoflogins()
    {
    	setNumberoflogins(0);
    }
    public void setNumberoflogins(String  p)
    {
    	setNumberoflogins(stringAsInteger(p));
    }

    // userconsent getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isUserconsentDirty()  { return checkFieldDirtiness(USERCONSENT_DIRTYGROUP, USERCONSENT_DIRTYMASK); }

    public java.lang.String   getUserconsent()         { return userconsent; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "userconsent")
    public java.lang.String   getUserconsentAsString() { return (userconsent == null) ? "" : userconsent; }

    // userconsent setter methods.
    
    protected void markUserconsentAsDirty(boolean aFlag)  { markFieldAsDirty(USERCONSENT_DIRTYGROUP, USERCONSENT_DIRTYMASK, aFlag); }


    public void setUserconsent(String  p)
    {
       setUserconsent(p, DTOCasingStyle.none);
    }
    
    public void setUserconsent(String  p, DTOCasingStyle casingStyle)
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
       markUserconsentAsDirty(!equalsObject(userconsent, p));
       userconsent = p;
    }

    // fbuserid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isFbuseridDirty()  { return checkFieldDirtiness(FBUSERID_DIRTYGROUP, FBUSERID_DIRTYMASK); }

    public java.lang.String   getFbuserid()         { return fbuserid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    @CSVAnnotation(attribute = "fbuserid")
    public java.lang.String   getFbuseridAsString() { return (fbuserid == null) ? "" : fbuserid; }

    // fbuserid setter methods.
    
    protected void markFbuseridAsDirty(boolean aFlag)  { markFieldAsDirty(FBUSERID_DIRTYGROUP, FBUSERID_DIRTYMASK, aFlag); }


    public void setFbuserid(String  p)
    {
       setFbuserid(p, DTOCasingStyle.none);
    }
    
    public void setFbuserid(String  p, DTOCasingStyle casingStyle)
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
       markFbuseridAsDirty(!equalsObject(fbuserid, p));
       fbuserid = p;
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
