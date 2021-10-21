//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teammemberprofile;

public class TeamMemberProfileKey
{
    protected java.lang.String  profileid;


    /**
      * DataBean constructor.
      */
    public TeamMemberProfileKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public TeamMemberProfileKey(TeamMemberProfileKey another) 
    {    	
       profileid = another.getProfileid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getProfileid()         { return profileid; }
    
    public void setProfileid(String  p)
    {
         profileid = p;
    }
}
