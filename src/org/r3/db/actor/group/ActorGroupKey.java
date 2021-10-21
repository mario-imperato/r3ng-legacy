//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.actor.group;

public class ActorGroupKey
{
    protected java.lang.String  eventid;
    protected java.lang.String  groupid;


    /**
      * DataBean constructor.
      */
    public ActorGroupKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public ActorGroupKey(ActorGroupKey another) 
    {    	
       eventid = another.getEventid();
       groupid = another.getGroupid();
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
}
