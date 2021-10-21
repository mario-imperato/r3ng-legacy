//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.project.team;

public class TeamKey
{
    protected java.lang.String  site;
    protected java.lang.String  teamid;


    /**
      * DataBean constructor.
      */
    public TeamKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public TeamKey(TeamKey another) 
    {    	
       site = another.getSite();
       teamid = another.getTeamid();
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
}
