//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.relactorgroup;

public class ActorGroupRelationKey
{
    protected java.lang.String  eventid;
    protected java.lang.String  groupid;
    protected java.lang.String  actorid;


    /**
      * DataBean constructor.
      */
    public ActorGroupRelationKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public ActorGroupRelationKey(ActorGroupRelationKey another) 
    {    	
       eventid = another.getEventid();
       groupid = another.getGroupid();
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
    
    public java.lang.String   getGroupid()         { return groupid; }
    
    public void setGroupid(String  p)
    {
         groupid = p;
    }
    
    public java.lang.String   getActorid()         { return actorid; }
    
    public void setActorid(String  p)
    {
         actorid = p;
    }
}
