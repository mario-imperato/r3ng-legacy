//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.user;

public class UserKey
{
    protected java.lang.String  userid;


    /**
      * DataBean constructor.
      */
    public UserKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public UserKey(UserKey another) 
    {    	
       userid = another.getUserid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getUserid()         { return userid; }
    
    public void setUserid(String  p)
    {
         userid = p;
    }
}
