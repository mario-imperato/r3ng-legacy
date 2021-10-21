//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueue;

public class SMSQueueKey
{
    protected java.lang.String  site;
    protected java.lang.String  smsid;


    /**
      * DataBean constructor.
      */
    public SMSQueueKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SMSQueueKey(SMSQueueKey another) 
    {    	
       site = another.getSite();
       smsid = another.getSmsid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getSite()         { return site; }
    
    public void setSite(String  p)
    {
         site = p;
    }
    
    public java.lang.String   getSmsid()         { return smsid; }
    
    public void setSmsid(String  p)
    {
         smsid = p;
    }
}
