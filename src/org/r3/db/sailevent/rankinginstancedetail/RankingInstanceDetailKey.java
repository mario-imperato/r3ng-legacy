//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.sailevent.rankinginstancedetail;

public class RankingInstanceDetailKey
{
    protected java.lang.Integer  rankentryid;


    /**
      * DataBean constructor.
      */
    public RankingInstanceDetailKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public RankingInstanceDetailKey(RankingInstanceDetailKey another) 
    {    	
       rankentryid = another.getRankentryid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.Integer   getRankentryid() { return rankentryid; }
    
    public void setRankentryid(java.lang.Integer  p)
    {
    	rankentryid = p;
    }
    public void setRankentryid(int p)
    {
    	setRankentryid(new java.lang.Integer(p));
    }
    public void setRankentryid()
    {
    	setRankentryid(0);
    }
}
