//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.ranking;

public class RankingKey
{
    protected java.lang.String  eventid;
    protected java.lang.String  rankid;


    /**
      * DataBean constructor.
      */
    public RankingKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public RankingKey(RankingKey another) 
    {    	
       eventid = another.getEventid();
       rankid = another.getRankid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getEventid()         { return eventid; }
    
    public void setEventid(String  p)
    {
         eventid = p;
    }
    
    public java.lang.String   getRankid()         { return rankid; }
    
    public void setRankid(String  p)
    {
         rankid = p;
    }
}
