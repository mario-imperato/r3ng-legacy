//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.userroleview;

@org.jboss.resteasy.annotations.providers.jaxb.IgnoreMediaTypes("application/*+json")
@javax.xml.bind.annotation.XmlRootElement(name = "UserRoleViewDTOBase")
public class UserRoleViewDTOBase extends org.r3.db.DTOBase
{
    int[] dirtyFlagsArray;

    protected java.lang.String  site;
    protected java.lang.String  userid;
    protected java.lang.String  roleid;
    protected java.lang.String  roledescr;

    public static final java.lang.String SITE_DEFAULT  =  null;
    public static final java.lang.String USERID_DEFAULT  =  null;
    public static final java.lang.String ROLEID_DEFAULT  =  null;
    public static final java.lang.String ROLEDESCR_DEFAULT  =  null;

    public static final int SITE_DIRTYGROUP  =  0;
    public static final int SITE_DIRTYMASK   =  1;
    public static final int USERID_DIRTYGROUP  =  0;
    public static final int USERID_DIRTYMASK   =  2;
    public static final int ROLEID_DIRTYGROUP  =  0;
    public static final int ROLEID_DIRTYMASK   =  4;
    public static final int ROLEDESCR_DIRTYGROUP  =  0;
    public static final int ROLEDESCR_DIRTYMASK   =  8;


    /**
      * DataBean constructor.
      */
    public UserRoleViewDTOBase()
    {
       dirtyFlagsArray = new int[4 / 30 + 1];
       clearDirtyFlags();

       site = SITE_DEFAULT;
       userid = USERID_DEFAULT;
       roleid = ROLEID_DEFAULT;
       roledescr = ROLEDESCR_DEFAULT;
    }

    /**
      * Copy constructor.
      */
    public UserRoleViewDTOBase(UserRoleViewDTOBase another)
    {

       site = another.getSite();
       userid = another.getUserid();
       roleid = another.getRoleid();
       roledescr = another.getRoledescr();

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

    // site getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isSiteDirty()  { return checkFieldDirtiness(SITE_DIRTYGROUP, SITE_DIRTYMASK); }

    public java.lang.String   getSite()         { return site; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getSiteAsString() { return (site == null) ? "" : site; }

    // site setter methods.
    
    protected void markSiteAsDirty(boolean aFlag)  { markFieldAsDirty(SITE_DIRTYGROUP, SITE_DIRTYMASK, aFlag); }


    public void setSite(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markSiteAsDirty(!equalsObject(site, p));
         site = p;
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

    // roleid getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRoleidDirty()  { return checkFieldDirtiness(ROLEID_DIRTYGROUP, ROLEID_DIRTYMASK); }

    public java.lang.String   getRoleid()         { return roleid; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getRoleidAsString() { return (roleid == null) ? "" : roleid; }

    // roleid setter methods.
    
    protected void markRoleidAsDirty(boolean aFlag)  { markFieldAsDirty(ROLEID_DIRTYGROUP, ROLEID_DIRTYMASK, aFlag); }


    public void setRoleid(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markRoleidAsDirty(!equalsObject(roleid, p));
         roleid = p;
    }

    // roledescr getter methods.
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public boolean isRoledescrDirty()  { return checkFieldDirtiness(ROLEDESCR_DIRTYGROUP, ROLEDESCR_DIRTYMASK); }

    public java.lang.String   getRoledescr()         { return roledescr; }
    @com.fasterxml.jackson.annotation.JsonIgnore
    @javax.xml.bind.annotation.XmlTransient 
    public java.lang.String   getRoledescrAsString() { return (roledescr == null) ? "" : roledescr; }

    // roledescr setter methods.
    
    protected void markRoledescrAsDirty(boolean aFlag)  { markFieldAsDirty(ROLEDESCR_DIRTYGROUP, ROLEDESCR_DIRTYMASK, aFlag); }


    public void setRoledescr(String  p)
    {
    	 if (p != null)
    	 {
    	  p = p.trim();
    	 	if (p.length() == 0)  p = null;    	 	
         }
         markRoledescrAsDirty(!equalsObject(roledescr, p));
         roledescr = p;
    }

}
