//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.userrole;

public class UserRoleKey
{
    protected java.lang.String  site;
    protected java.lang.String  userid;
    protected java.lang.String  roleid;


    /**
      * DataBean constructor.
      */
    public UserRoleKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public UserRoleKey(UserRoleKey another) 
    {    	
       site = another.getSite();
       userid = another.getUserid();
       roleid = another.getRoleid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getUserid()         { return userid; }
    
    public void setUserid(String  p)
    {
         userid = p;
    }
    
    public java.lang.String   getRoleid()         { return roleid; }
    
    public void setRoleid(String  p)
    {
         roleid = p;
    }
}
