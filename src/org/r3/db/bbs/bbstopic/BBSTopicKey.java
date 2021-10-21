//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.bbs.bbstopic;

public class BBSTopicKey
{
    protected java.lang.String  site;
    protected java.lang.String  topicid;


    /**
      * DataBean constructor.
      */
    public BBSTopicKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public BBSTopicKey(BBSTopicKey another) 
    {    	
       site = another.getSite();
       topicid = another.getTopicid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getTopicid()         { return topicid; }
    
    public void setTopicid(String  p)
    {
         topicid = p;
    }
}
