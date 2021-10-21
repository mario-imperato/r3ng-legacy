//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.authrole;

public class AuthRoleKey
{
    protected java.lang.String  roleid;


    /**
      * DataBean constructor.
      */
    public AuthRoleKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public AuthRoleKey(AuthRoleKey another) 
    {    	
       roleid = another.getRoleid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getRoleid()         { return roleid; }
    
    public void setRoleid(String  p)
    {
         roleid = p;
    }
}
