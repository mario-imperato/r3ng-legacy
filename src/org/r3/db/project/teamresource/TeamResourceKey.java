//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.teamresource;

public class TeamResourceKey
{
    protected java.lang.String  site;
    protected java.lang.String  teamid;
    protected java.lang.String  resourceid;


    /**
      * DataBean constructor.
      */
    public TeamResourceKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public TeamResourceKey(TeamResourceKey another) 
    {    	
       site = another.getSite();
       teamid = another.getTeamid();
       resourceid = another.getResourceid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getTeamid()         { return teamid; }
    
    public void setTeamid(String  p)
    {
         teamid = p;
    }
    
    public java.lang.String   getResourceid()         { return resourceid; }
    
    public void setResourceid(String  p)
    {
         resourceid = p;
    }
}
