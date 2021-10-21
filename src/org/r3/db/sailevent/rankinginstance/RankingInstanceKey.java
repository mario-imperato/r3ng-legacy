//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstance;

public class RankingInstanceKey
{
    protected java.lang.String  eventid;
    protected java.lang.String  instanceid;


    /**
      * DataBean constructor.
      */
    public RankingInstanceKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public RankingInstanceKey(RankingInstanceKey another) 
    {    	
       eventid = another.getEventid();
       instanceid = another.getInstanceid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getEventid()         { return eventid; }
    
    public void setEventid(String  p)
    {
         eventid = p;
    }
    
    public java.lang.String   getInstanceid()         { return instanceid; }
    
    public void setInstanceid(String  p)
    {
         instanceid = p;
    }
}
