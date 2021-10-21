//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queue;

public class QueueKey
{
    protected java.lang.String  queueid;


    /**
      * DataBean constructor.
      */
    public QueueKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public QueueKey(QueueKey another) 
    {    	
       queueid = another.getQueueid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getQueueid()         { return queueid; }
    
    public void setQueueid(String  p)
    {
         queueid = p;
    }
}
