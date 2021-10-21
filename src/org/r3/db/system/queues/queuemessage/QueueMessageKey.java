//
// GPA Gruppo Progetti Avanzati s.r.l. - 
// Progetto UNEP 2012 per PosteItaliane S.p.a.
//
//
// TODO: Readme Section.
//


package org.r3.db.system.queues.queuemessage;

public class QueueMessageKey
{
    protected java.lang.String  queuemessageid;


    /**
      * DataBean constructor.
      */
    public QueueMessageKey() 
    {    
    }
    
    /**
      * Copy constructor.
      */    
    public QueueMessageKey(QueueMessageKey another) 
    {    	
       queuemessageid = another.getQueuemessageid();
    }
       
    /**
      * DataBean Getter And Setter Accessor
      */    
    
    public java.lang.String   getQueuemessageid()         { return queuemessageid; }
    
    public void setQueuemessageid(String  p)
    {
         queuemessageid = p;
    }
}
