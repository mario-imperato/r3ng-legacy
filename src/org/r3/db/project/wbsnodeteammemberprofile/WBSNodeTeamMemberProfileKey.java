//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.wbsnodeteammemberprofile;

public class WBSNodeTeamMemberProfileKey
{
    protected java.lang.String  profileid;
    protected java.lang.String  wbsnodeid;


    /**
      * DataBean constructor.
      */
    public WBSNodeTeamMemberProfileKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public WBSNodeTeamMemberProfileKey(WBSNodeTeamMemberProfileKey another) 
    {    	
       profileid = another.getProfileid();
       wbsnodeid = another.getWbsnodeid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getProfileid()         { return profileid; }
    
    public void setProfileid(String  p)
    {
         profileid = p;
    }
    
    public java.lang.String   getWbsnodeid()         { return wbsnodeid; }
    
    public void setWbsnodeid(String  p)
    {
         wbsnodeid = p;
    }
}
