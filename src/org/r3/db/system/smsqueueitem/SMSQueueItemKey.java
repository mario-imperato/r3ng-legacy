//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.smsqueueitem;

public class SMSQueueItemKey
{
    protected java.lang.Integer  smsitemid;


    /**
      * DataBean constructor.
      */
    public SMSQueueItemKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public SMSQueueItemKey(SMSQueueItemKey another) 
    {    	
       smsitemid = another.getSmsitemid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.Integer   getSmsitemid() { return smsitemid; }
    
    public void setSmsitemid(java.lang.Integer  p)
    {
    	smsitemid = p;
    }
    public void setSmsitemid(int p)
    {
    	setSmsitemid(new java.lang.Integer(p));
    }
    public void setSmsitemid()
    {
    	setSmsitemid(0);
    }
}
