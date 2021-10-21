//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.user.usersession;

public class UserSessionKey
{
    protected java.lang.String  sessionid;


    /**
      * DataBean constructor.
      */
    public UserSessionKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public UserSessionKey(UserSessionKey another) 
    {    	
       sessionid = another.getSessionid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSessionid()         { return sessionid; }
    
    public void setSessionid(String  p)
    {
         sessionid = p;
    }
}
