//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.actor;

public class ActorKey
{
    protected java.lang.String  eventid;
    protected java.lang.String  actorid;


    /**
      * DataBean constructor.
      */
    public ActorKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public ActorKey(ActorKey another) 
    {    	
       eventid = another.getEventid();
       actorid = another.getActorid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getEventid()         { return eventid; }
    
    public void setEventid(String  p)
    {
         eventid = p;
    }
    
    public java.lang.String   getActorid()         { return actorid; }
    
    public void setActorid(String  p)
    {
         actorid = p;
    }
}
